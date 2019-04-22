/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.chat.listeners;

import com.google.common.collect.ImmutableList;
import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.internal.interfaces.ListenerBase;
import io.github.nucleuspowered.nucleus.modules.chat.config.ChatConfigAdapter;
import org.spongepowered.api.Platform;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.text.transform.SimpleTextFormatter;

public class ModBypassListener implements ListenerBase.Conditional {

    private ImmutableList<SimpleTextFormatter> toTransfer;

    @Listener(order = Order.POST, beforeModifications = true)
    public void onChatBeforeMods(MessageChannelEvent.Chat event) {
        if (Sponge.getServer().isMainThread()) {
            this.toTransfer = event.getFormatter().getAll();
        }
    }

    @Listener(order = Order.PRE)
    public void onChatAfterMods(MessageChannelEvent.Chat event) {
        if (Sponge.getServer().isMainThread() && !this.toTransfer.isEmpty()) {
            event.getFormatter().clear();
            this.toTransfer.forEach(event.getFormatter()::add);
            this.toTransfer = ImmutableList.of();
        }
    }

    @Override
    public boolean shouldEnable() {
        this.toTransfer = ImmutableList.of();
        if (Nucleus.getNucleus().getInternalServiceManager()
                .getServiceUnchecked(ChatConfigAdapter.class)
                .getNodeOrDefault()
                .isOverwriteMods()) {
            return Sponge.getPlatform().getContainer(Platform.Component.IMPLEMENTATION).getId().equals("spongeforge");
        }

        return false;
    }
}
