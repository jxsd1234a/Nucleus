/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.kit.listeners;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.Util;
import io.github.nucleuspowered.nucleus.api.events.NucleusFirstJoinEvent;
import io.github.nucleuspowered.nucleus.api.exceptions.KitRedeemException;
import io.github.nucleuspowered.nucleus.api.nucleusdata.Kit;
import io.github.nucleuspowered.nucleus.dataservices.KitService;
import io.github.nucleuspowered.nucleus.dataservices.loaders.UserDataManager;
import io.github.nucleuspowered.nucleus.internal.PermissionRegistry;
import io.github.nucleuspowered.nucleus.internal.interfaces.ListenerBase;
import io.github.nucleuspowered.nucleus.internal.interfaces.Reloadable;
import io.github.nucleuspowered.nucleus.modules.kit.config.KitConfig;
import io.github.nucleuspowered.nucleus.modules.kit.config.KitConfigAdapter;
import io.github.nucleuspowered.nucleus.modules.kit.datamodules.KitUserDataModule;
import io.github.nucleuspowered.nucleus.modules.kit.services.KitHandler;
import org.slf4j.Logger;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.filter.type.Exclude;
import org.spongepowered.api.event.item.inventory.InteractInventoryEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.item.inventory.Container;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class KitListener implements Reloadable, ListenerBase {

    private final UserDataManager loader = Nucleus.getNucleus().getUserDataManager();
    private final KitHandler handler = getServiceUnchecked(KitHandler.class);
    private final KitService gds = Nucleus.getNucleus().getKitService();
    private final Logger logger = Nucleus.getNucleus().getLogger();

    private boolean mustGetAll;
    private boolean logAutoRedeem = false;

    @Listener
    public void onPlayerFirstJoin(NucleusFirstJoinEvent event, @Getter("getTargetEntity") Player player) {
        loader.get(player).ifPresent(p -> {
            for (Kit kit : gds.getFirstJoinKits()) {
                try {
                    handler.redeemKit(kit, player, true, true);
                } catch (KitRedeemException e) {
                    // ignored
                }
            }
        });
    }

    @Listener
    public void onPlayerJoin(ClientConnectionEvent.Join event, @Root Player player) {
        loader.get(player).ifPresent(p -> {
            KitUserDataModule user = loader.getUnchecked(player.getUniqueId()).get(KitUserDataModule.class);
            List<Kit> autoRedeemable = this.gds.getAutoRedeemable();
            String name = "[Kit Auto Redeem - " + player.getName() + "]: ";
            for (Kit kit : autoRedeemable) {
                String permission = PermissionRegistry.PERMISSIONS_PREFIX + "kits." + kit.getName().toLowerCase();
                String kitName = kit.getName();
                if (kit.ignoresPermission()) {
                    log(name + kitName + " - permission check bypassed.");
                } else if (player.hasPermission(permission)) {
                    log(name  + kitName + " - permission check " + permission + " passed.");
                } else {
                    continue;
                }

                Instant timeOfLastUse = user.getLastRedeemedTime(kit.getName());
                if (timeOfLastUse != null && !this.handler.checkOneTime(kit, player)) {
                    log(name  + kitName + " - one time kit already redeemed.");
                } else {
                    if (timeOfLastUse != null) {
                        Optional<Duration> od = this.handler.checkCooldown(kit, player, timeOfLastUse);
                        if (od.isPresent()) {
                            log(name + kitName + " - cooldown not expired - " + Util.getTimeStringFromSeconds(od.get().getSeconds()) + ".");
                            continue;
                        }
                    }

                    log(name  + kitName + " - redeeming kit.");
                    try {
                        this.handler.redeemKit(kit, player, false, false, this.mustGetAll, false, user);
                        user.addKitLastUsedTime(kit.getName(), Instant.now());
                        log(name  + kitName + " - kit redeemed.");
                    } catch (KitRedeemException e) {
                        if (this.logAutoRedeem) {
                            Nucleus.getNucleus().getLogger().error(name + kitName + " - kit could not be redeemed.", e);
                        }
                    }
                }
            }
        });
    }

    @Listener
    @Exclude({InteractInventoryEvent.Open.class})
    public void onPlayerInteractInventory(final InteractInventoryEvent event, @Root final Player player,
            @Getter("getTargetInventory") final Container inventory) {
        handler.getCurrentlyOpenInventoryKit(inventory).ifPresent(x -> {
            try {
                x.getFirst().updateKitInventory(x.getSecond());
                handler.saveKit(x.getFirst());

                if (event instanceof InteractInventoryEvent.Close) {
                    gds.save();
                    player.sendMessage(Nucleus.getNucleus().getMessageProvider().getTextMessageWithFormat("command.kit.edit.success", x.getFirst().getName()));
                    handler.removeKitInventoryFromListener(inventory);
                    return;
                }
            } catch (Exception e) {
                if (Nucleus.getNucleus().isDebugMode()) {
                    e.printStackTrace();
                }

                player.sendMessage(Nucleus.getNucleus().getMessageProvider().getTextMessageWithFormat("command.kit.edit.error", x.getFirst().getName()));
            }
        });

        if (handler.isViewer(inventory)) {
            if (event instanceof InteractInventoryEvent.Close) {
                this.handler.removeViewer(inventory);
            } else {
                event.setCancelled(true);
            }
        }
    }

    private void log(String message) {
        if (this.logAutoRedeem) {
            this.logger.info(message);
        }
    }

    @Override public void onReload() throws Exception {
        KitConfig kca = getServiceUnchecked(KitConfigAdapter.class).getNodeOrDefault();
        this.mustGetAll = kca.isMustGetAll();
        this.logAutoRedeem = kca.isLogAutoredeem();
    }
}
