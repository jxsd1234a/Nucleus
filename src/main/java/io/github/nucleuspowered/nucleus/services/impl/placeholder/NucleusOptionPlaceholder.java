/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializer;

public class NucleusOptionPlaceholder implements Placeholder.Option {

    private final SubjectReference source;
    private final String option;
    private final Text defaultText;
    private final TextSerializer serializer;
    private final Text prepend;
    private final Text append;

    public NucleusOptionPlaceholder(SubjectReference source, String option, Text defaultText, TextSerializer serializer, Text prepend, Text append) {
        this.source = source;
        this.option = option;
        this.defaultText = defaultText;
        this.serializer = serializer;
        this.prepend = prepend;
        this.append = append;
    }

    @Override
    public Text getDefault() {
        return this.defaultText;
    }

    @Override
    public String getOption() {
        return this.option;
    }

    @Override
    public SubjectReference getSubjectReference() {
        return this.source;
    }

    @Override
    public Text getPrependingText() {
        return this.prepend;
    }

    @Override
    public Text getAppendingText() {
        return this.append;
    }

    @Override public TextSerializer getTextSerializer(TextSerializer serializer) {
        return this.serializer;
    }

    @Override
    @NonNull
    public Text toText() {
        return Text.of(this.prepend,
                this.source.resolve().join().getOption(this.option).map(this.serializer::deserialize).orElse(this.defaultText),
                this.append);
    }

}
