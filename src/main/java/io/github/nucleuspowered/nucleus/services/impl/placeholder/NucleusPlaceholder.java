/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.command.CommandSource;
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
    public String getParser() {
        return this.metadata.getToken();
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
    public Text getPrependingText() {
        return this.prepend;
    }

    @Override
    public Text getAppendingText() {
        return this.append;
    }

    PlaceholderMetadata getMetadata() {
        return this.metadata;
    }

    @NonNull
    @Override
    public Text toText() {
        return Text.of(this.prepend, this.metadata.getParser().parse(this), this.append);
    }

}
