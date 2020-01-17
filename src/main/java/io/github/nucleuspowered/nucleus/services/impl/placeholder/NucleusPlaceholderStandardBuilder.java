/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import com.google.common.base.Preconditions;
import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;

public class NucleusPlaceholderStandardBuilder implements Placeholder.StandardBuilder {

    private final PlaceholderService placeholderService;
    @Nullable private PlaceholderMetadata metadata;
    @Nullable private CommandSource source;
    @Nullable private String argument;
    private Text prepend = Text.EMPTY;
    private Text append = Text.EMPTY;


    public NucleusPlaceholderStandardBuilder(PlaceholderService placeholderService) {
        this.placeholderService = placeholderService;
    }

    @Override
    public Placeholder.StandardBuilder setParser(String parser) {
        this.metadata = this.placeholderService.getMetadata(parser);
        return this;
    }

    @Override
    public Placeholder.StandardBuilder setAssociatedSource(@Nullable CommandSource source) {
        this.source = source;
        return this;
    }

    @Override
    public Placeholder.StandardBuilder setArgument(@Nullable String string) {
        this.argument = string;
        return this;
    }

    @Override
    public Placeholder.StandardBuilder setPrependingText(Text prefix) {
        this.prepend = prefix == null ? Text.EMPTY : prefix;
        return this;
    }

    @Override
    public Placeholder.StandardBuilder setAppendingText(Text prefix) {
        this.append = append == null ? Text.EMPTY : prefix;
        return this;
    }

    @Override
    public Placeholder.Standard build() {
        Preconditions.checkState(this.metadata != null, "Parser has not been set!");
        return new NucleusPlaceholder(this.metadata, this.source, this.argument, this.prepend, this.append);
    }

    @Override
    public Placeholder.StandardBuilder from(Placeholder.@NonNull Standard value) {
        Preconditions.checkArgument(value instanceof NucleusPlaceholder, "Must be a Nucleus Placeholder");
        NucleusPlaceholder np = (NucleusPlaceholder) value;
        this.metadata = np.getMetadata();
        this.source = np.getAssociatedSource().orElse(null);
        return this;
    }

    @Override
    public Placeholder.StandardBuilder reset() {
        this.metadata = null;
        this.source = null;
        this.prepend = Text.EMPTY;
        this.append = Text.EMPTY;
        return this;
    }

}
