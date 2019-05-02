/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.world.listeners;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.internal.interfaces.ListenerBase;
import io.github.nucleuspowered.nucleus.modules.world.datamodules.WorldgenWorldDataModule;
import io.github.nucleuspowered.nucleus.modules.world.services.WorldHelper;
import org.spongepowered.api.GameState;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.world.LoadWorldEvent;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.world.World;

import java.util.concurrent.TimeUnit;

public class WorldGenListener implements ListenerBase {

    @Listener
    public void onStart(GameStartedServerEvent event) {
        Task.builder().execute(() -> Sponge.getServer().getWorlds().forEach(this::onWorldLoad)).delay(1, TimeUnit.SECONDS).submit(Nucleus.getNucleus());
    }

    @Listener
    public void onWorldLoad(LoadWorldEvent event) {
        if (Sponge.getGame().getState() == GameState.SERVER_STARTED) {
            Task.builder().execute(() -> onWorldLoad(event.getTargetWorld())).delay(1, TimeUnit.SECONDS).submit(Nucleus.getNucleus());
        }
    }

    private void onWorldLoad(final World world) {
        try {
            WorldHelper worldHelper = getServiceUnchecked(WorldHelper.class);
            Nucleus.getNucleus().getWorldDataManager().getWorld(world).ifPresent(mws -> {
                WorldgenWorldDataModule worldgenWorldDataModule = mws.get(WorldgenWorldDataModule.class);
                if (worldgenWorldDataModule.isStart()) {
                    if (worldHelper.startPregenningForWorld(
                            world,
                            worldgenWorldDataModule.isAggressive(),
                            worldgenWorldDataModule.getSaveTime(),
                            worldgenWorldDataModule.getTickPercent(),
                            worldgenWorldDataModule.getTickFreq(),
                            true
                    )) {
                        sendMessageTo(Sponge.getServer().getConsole(), "command.world.gen.started", world.getName());
                    }
                }
            });

        } catch (IllegalStateException e) {
            Nucleus.getNucleus().getLogger().error(
                    "Could not determine World Generation restart status for world {}, WorldProperties could not be loaded from the Sponge "
                            + "World Manager (Sponge.getServer().getWorldProperties({}) returned empty.)", world.getName(), world.getUniqueId());
            e.printStackTrace();
        }
    }
}
