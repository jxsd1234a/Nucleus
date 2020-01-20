/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import java.util.Optional;

public class NucleusPlaceholder implements Placeholder.Standard {

    private final PlaceholderMetadata metadata;
    @Nullable private final CommandSource sender;
    @Nullable private final String argument;
    private final Text append;
    private final Text prepend;

    public NucleusPlaceholder(
            PlaceholderMetadata metadata,
            @Nullable CommandSource sender,
            @Nullable String argument,
            Text prepend,
            Text append) {
        this.metadata = metadata;
        this.sender = sender;
        this.argument = argument;
        this.prepend = prepend;
        this.append = append;
    }

    @Override
    public String getRegisteredToken() {
        return this.metadata.getToken();
    }

    @Override
    public PluginContainer getRegisteredPlugin() {
        return this.metadata.getPluginContainer();
    }

    @Override
    public PlaceholderParser getParser() {
        return this.metadata.getParser();
    }

    @Override
    public Optional<CommandSource> getAssociatedSource() {
        return Optional.ofNullable(this.sender);
    }

    @Override
    public Optional<String> argument() {
        return Optional.ofNullable(this.argument);
    }

    @Override
    public Text getPrependingTextIfNotEmpty() {
        return this.prepend;
    }

    @Override
    public Text getAppendingTextIfNotEmpty() {
        return this.append;
    }

    PlaceholderMetadata getMetadata() {
        return this.metadata;
    }

    @NonNull
    @Override
    public Text toText() {
        Text result = this.metadata.getParser().parse(this);
        if (!result.isEmpty()) {
            return Text.of(this.prepend, result, this.append);
        }

        return result;
    }

}
