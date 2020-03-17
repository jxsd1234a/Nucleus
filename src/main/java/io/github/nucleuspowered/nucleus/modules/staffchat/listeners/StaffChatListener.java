/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.staffchat.listeners;

import io.github.nucleuspowered.nucleus.internal.interfaces.ListenerBase;
import io.github.nucleuspowered.nucleus.modules.staffchat.StaffChatMessageChannel;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;
import org.spongepowered.api.event.filter.Getter;

public class StaffChatListener implements ListenerBase {

    @Listener
    public void onPlayerRespawn(RespawnPlayerEvent event, @Getter("getTargetEntity") Player player, @Getter("getOriginalPlayer") Player original) {
        if (original.getMessageChannel() instanceof StaffChatMessageChannel) {
            player.setMessageChannel(StaffChatMessageChannel.getInstance());
        }
    }

}
