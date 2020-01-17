/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import com.google.common.base.Preconditions;
import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializer;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.Objects;

public class NucleusOptionPlaceholderBuilder implements Placeholder.OptionBuilder {

    private Text defaultText = Text.EMPTY;
    @Nullable private SubjectReference source;
    @Nullable private String option;
    private Text prepend = Text.EMPTY;
    private Text append = Text.EMPTY;
    private TextSerializer serializer = TextSerializers.FORMATTING_CODE;

    @Override
    public Placeholder.OptionBuilder setDefault(Text defaultText) {
        this.defaultText = defaultText == null ? Text.EMPTY : defaultText;
        return this;
    }

    @Override
    public Placeholder.OptionBuilder setOption(String option) {
        this.option = option;
        return this;
    }

    @Override
    public Placeholder.OptionBuilder setSubjectReference(SubjectReference source) {
        this.source = source;
        return this;
    }

    @Override
    public Placeholder.OptionBuilder setSubject(Subject source) {
        return setSubjectReference(source.asSubjectReference());
    }

    @Override
    public Placeholder.OptionBuilder setTextSerializer(TextSerializer serializer) {
        this.serializer = Objects.requireNonNull(serializer);
        return this;
    }

    @Override
    public Placeholder.OptionBuilder setPrependingText(Text prefix) {
        this.prepend = prefix == null ? Text.EMPTY : prefix;
        return this;
    }

    @Override
    public Placeholder.OptionBuilder setAppendingText(Text prefix) {
        this.append = append == null ? Text.EMPTY : prefix;
        return this;
    }

    @Override
    public Placeholder.Option build() {
        Preconditions.checkState(this.source != null, "Subject must be set!");
        Preconditions.checkState(this.option != null, "Option must be set!");
        return new NucleusOptionPlaceholder(
                this.source,
                this.option,
                this.defaultText,
                this.serializer,
                this.prepend,
                this.append
        );
    }

    @Override
    public Placeholder.OptionBuilder from(Placeholder.Option value) {
        this.source = value.getSubjectReference();
        this.option = value.getOption();
        this.defaultText = value.getDefault();
        return this;
    }

    @Override
    public Placeholder.OptionBuilder reset() {
        this.source = null;
        this.option = null;
        this.defaultText = Text.EMPTY;
        return this;
    }
}
