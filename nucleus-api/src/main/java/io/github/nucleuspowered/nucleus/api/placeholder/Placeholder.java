/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.placeholder;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.serializer.TextSerializer;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;

public interface Placeholder extends TextRepresentable {

    static StandardBuilder builder() {
        return Sponge.getRegistry().createBuilder(StandardBuilder.class);
    }

    static OptionBuilder option() {
        return Sponge.getRegistry().createBuilder(OptionBuilder.class);
    }

    Text getPrependingText();

    Text getAppendingText();

    interface Standard extends Placeholder {

        String getParser();

        Optional<CommandSource> getAssociatedSource();

        Optional<String> argument();
    }

    interface Option extends Placeholder {

        Text getDefault();

        String getOption();

        SubjectReference getSubjectReference();

        TextSerializer getTextSerializer(TextSerializer serializer);
    }

    interface StandardBuilder extends Builder<Standard, StandardBuilder> {

        StandardBuilder setParser(String parser);

        StandardBuilder setAssociatedSource(@Nullable CommandSource source);

        StandardBuilder setArgument(@Nullable String string);

    }

    interface OptionBuilder extends Builder<Option, OptionBuilder> {

        OptionBuilder setDefault(Text defaultText);

        OptionBuilder setOption(String option);

        OptionBuilder setSubjectReference(SubjectReference source);

        OptionBuilder setSubject(Subject source);

        OptionBuilder setTextSerializer(TextSerializer serializer);

    }

    interface Builder<O, T extends Builder<O, T>> extends ResettableBuilder<O, T> {

        T setPrependingText(Text prefix);

        T setAppendingText(Text prefix);

        O build();

    }
}
