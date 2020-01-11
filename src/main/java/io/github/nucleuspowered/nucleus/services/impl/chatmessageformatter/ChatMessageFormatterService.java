/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.chatmessageformatter;

import com.google.common.base.Preconditions;
import io.github.nucleuspowered.nucleus.api.util.NoExceptionAutoClosable;
import io.github.nucleuspowered.nucleus.services.interfaces.IChatMessageFormatterService;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Singleton;

@Singleton
public class ChatMessageFormatterService implements IChatMessageFormatterService {

    private final Map<UUID, Channel> chatChannels = new HashMap<>();

    @Override
    public Optional<Channel> getNucleusChannel(UUID uuid) {
        return Optional.ofNullable(this.chatChannels.get(uuid));
    }

    @Override
    public void setPlayerNucleusChannel(UUID uuid, @Nullable Channel channel) {
        if (channel == null) {
            this.chatChannels.remove(uuid);
        } else {
            this.chatChannels.put(uuid, channel);
        }
    }

    @Override public NoExceptionAutoClosable setPlayerNucleusChannelTemporarily(UUID uuid, Channel channel) {
        Preconditions.checkNotNull(channel);
        final Channel original = this.chatChannels.get(uuid);
        this.chatChannels.put(uuid, channel);
        return () -> this.setPlayerNucleusChannel(uuid, channel);
    }

}
