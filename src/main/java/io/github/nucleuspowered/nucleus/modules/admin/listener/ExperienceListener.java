/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.admin.listener;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.internal.interfaces.ListenerBase;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionInformation;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.util.Tristate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ExperienceListener implements ListenerBase {

    private final Map<UUID, Integer> deadExpPlayers = new HashMap<>();
    private final static String KEEP_EXP_PERMISSION = "nucleus.exp.keepondeath";

    @Override
    public Map<String, PermissionInformation> getPermissions() {
        Map<String, PermissionInformation> map = new HashMap<>();
        map.put(KEEP_EXP_PERMISSION,
                PermissionInformation.getWithTranslation(
                        "permission.enchantment.keepxp",
                        SuggestedLevel.NONE
                ));
        return map;
    }

    // We check the tristate as we have three potential behaviours:
    // * TRUE: keep EXP
    // * FALSE (Explicitly set): remove EXP
    // * UNDEFINED: do whatever the system wants us to do.
    @Listener(order = Order.POST)
    public void onPlayerDeathMonitor(DestructEntityEvent.Death deathEvent, @Getter("getTargetEntity") Player player) {
        Tristate tristate = player.getPermissionValue(player.getActiveContexts(), KEEP_EXP_PERMISSION);
        if (tristate == Tristate.TRUE) {
            int exp = player.get(Keys.TOTAL_EXPERIENCE).orElse(0);
            this.deadExpPlayers.put(player.getUniqueId(), exp);
        } else if (tristate == Tristate.FALSE) {
            this.deadExpPlayers.put(player.getUniqueId(), 0);
        }
    }

    @Listener
    public void preventExperienceDroppingOrb(SpawnEntityEvent event, @Root Player player) {
        if (this.deadExpPlayers.getOrDefault(player.getUniqueId(), 0) > 0) {
            // don't drop orbs for people who die, unless we're setting to zero.
            event.filterEntities(entity -> !(entity instanceof ExperienceOrb));
        }
    }

    @Listener
    public void onPlayerRespawn(RespawnPlayerEvent event, @Getter("getTargetEntity") Player player) {
        applyExperience(player);
    }

    @Listener
    public void onPlayerJoin(ClientConnectionEvent.Join event, @Getter("getTargetEntity") Player player) {
        applyExperience(player);
    }

    private void applyExperience(final Player player) {
        if (this.deadExpPlayers.containsKey(player.getUniqueId())) {
            final int e = this.deadExpPlayers.get(player.getUniqueId());
            //player.offer(Keys.TOTAL_EXPERIENCE, e);
            Task.builder().delayTicks(1).execute(() -> player.offer(Keys.TOTAL_EXPERIENCE, e)).submit(Nucleus.getNucleus());
            this.deadExpPlayers.remove(player.getUniqueId());
        }
    }

}
