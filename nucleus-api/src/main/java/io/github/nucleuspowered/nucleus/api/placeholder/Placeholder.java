/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.placeholder;

import io.github.nucleuspowered.nucleus.api.service.NucleusTextTemplateFactory;
import io.github.nucleuspowered.nucleus.api.text.NucleusTextTemplate;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.serializer.TextSerializer;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * A {@link TextRepresentable} that can be used in {@link Text} building methods
 * that represents a placeholder in text.
 *
 * <p>While such placeholders will generally be built from tokenised strings,
 * (such as {@link NucleusTextTemplate} objects, these objects make no
 * assumption about the format of text templating. Such as system can therefore
 * be used by other templating engines without conforming to the Nucleus
 * standard.</p>
 *
 * <p>If you are a plugin that wishes to use the Nucleus text template format,
 * use {@link NucleusTextTemplateFactory#createFromString(String)} instead.</p>
 *
 * <p>Due to the potential for game objects being stored within the
 * placeholders, they should not be held for longer than necessary.</p>
 */
public interface Placeholder extends TextRepresentable {

    /**
     * Returns a builder that creates a {@link Placeholder} that represents
     * plugin provided placeholders.
     *
     * @return A {@link StandardBuilder}
     */
    static StandardBuilder builder() {
        return Sponge.getRegistry().createBuilder(StandardBuilder.class);
    }

    /**
     * Returns a builder that creates a {@link Placeholder} that represents
     * a named {@link Subject#getOption(String)}, parsed using the given
     * {@link TextSerializer}.
     *
     * @return A {@link OptionBuilder}
     */
    static OptionBuilder option() {
        return Sponge.getRegistry().createBuilder(OptionBuilder.class);
    }

    /**
     * Gets any {@link Text} that will be prepend to the output returned by
     * this placeholder if it not empty.
     *
     * @return The {@link Text}
     */
    Text getPrependingTextIfNotEmpty();

    /**
     * Gets any {@link Text} that will be appended to the output returned by
     * this placeholder if it not empty.
     *
     * @return The {@link Text}
     */
    Text getAppendingTextIfNotEmpty();

    /**
     * A placeholder that represents a plugin provided placeholder.
     */
    interface Standard extends Placeholder {

        /**
         * The registered token text.
         *
         * @return The token
         */
        String getRegisteredToken();

        /**
         * The {@link PluginContainer} that registered this token.
         *
         * @return The {@link PluginContainer}
         */
        PluginContainer getRegisteredPlugin();

        /**
         * Gets the {@link PlaceholderParser} that handles this
         * placeholder.
         *
         * @return The {@link PlaceholderParser}
         */
        PlaceholderParser getParser();

        /**
         * If provided, the {@link CommandSource} which to pull information
         * from when building the placeholder text.
         *
         * <p>Examples of how this might affect a placeholder are:</p>
         *
         * <ul>
         *     <li>
         *         For a "name" placeholder that prints out the source's name,
         *         the name would be selected from this source.
         *     </li>
         *     <li>
         *         For a "balance" placeholder that returns a player's monetary
         *         balance, this would pull the balance from the player.
         *     </li>
         * </ul>
         *
         * <p>It is important to note that the associated source does not
         * necessarily have to be the sender/invoker of a message, nor does it
         * have to be the recipient. The source is selected by the context of
         * builder. It is up to plugins that use such placeholders to be aware
         * of the context of which the placeholder is used.</p>
         *
         * @return The associated {@link CommandSource}, if any.
         */
        Optional<CommandSource> getAssociatedSource();

        /**
         * The variable string passed to this token to provide contextual
         * information.
         *
         * @return The argument, if any.
         */
        Optional<String> argument();

    }

    /**
     * A placeholder that represents a named option on a {@link Subject}.
     */
    interface Option extends Placeholder {

        /**
         * Gets the default {@link Text} that is used if the option defined by
         * the key {@link #getOptionKey()} does not exist on the target
         * {@link SubjectReference}.
         *
         * @return The default text
         */
        Text getDefault();

        /**
         * Gets the key for the option to retrieve on the supplied
         * {@link SubjectReference}.
         *
         * @return The key
         */
        String getOptionKey();

        /**
         * Gets the {@link SubjectReference} that refers to the {@link Subject}
         * that this placeholder refers to.
         *
         * <p>It is important to note that the associated subject does not
         * necessarily have to be the sender/invoker of a message, nor does it
         * have to be the recipient. The subject is selected by the context of
         * builder. It is up to plugins that use such placeholders to be aware
         * of the context of which the placeholder is used.</p>
         *
         * @return The {@link SubjectReference}
         */
        SubjectReference getSubjectReference();

        /**
         * The {@link TextSerializer} to use to translate the option value into
         * {@link Text}
         *
         * @return The {@link TextSerializer}
         */
        TextSerializer getTextSerializer();

    }

    /**
     * A builder for {@link Placeholder.Standard} objects.
     */
    interface StandardBuilder extends Builder<Standard, StandardBuilder> {

        /**
         * Sets the token that represents a {@link PlaceholderParser} for use
         * in this {@link Placeholder}.
         *
         * @param token The token that represents a {@link PlaceholderParser}
         * @return This, for chaining
         * @throws NoSuchElementException if the {@code token} does not exist
         */
        StandardBuilder setToken(String token) throws NoSuchElementException;

        /**
         * Sets the {@link CommandSource} to use as a source of information
         * for this {@link Placeholder}. If {@code null}, removes this source.
         *
         * @param source The source, or null
         * @return This, for chaining
         *
         * @see Standard#getAssociatedSource()
         */
        StandardBuilder setAssociatedSource(@Nullable CommandSource source);

        /**
         * Sets a string that represents variables for the supplied token.
         * The format of this argument string is dependent on the
         * {@link PlaceholderParser} retrieved by {@link #setToken(String)}
         * and thus is not prescribed here.
         *
         * @param string The argument string, may be null
         * @return This, for chaining
         *
         * @see Standard#argument()
         */
        StandardBuilder setArgument(@Nullable String string);

    }

    /**
     * A builder for {@link Placeholder.Option}
     */
    interface OptionBuilder extends Builder<Option, OptionBuilder> {

        /**
         * Sets the {@link Text} returned by the placeholder if the provided
         * option on a {@link Subject} does not exist.
         *
         * @param defaultText The default text
         * @return This, for chaining
         */
        OptionBuilder setDefault(Text defaultText);

        /**
         * Sets the option key to check for on a {@link Subject}
         *
         * @param option The option key
         * @return This, for chaining
         */
        OptionBuilder setOptionKey(String option);

        /**
         * Sets the {@link SubjectReference} that the built placeholder will
         * try to obtain the option from.
         *
         * @param source The {@link SubjectReference}
         * @return This, for chaining
         */
        OptionBuilder setSubjectReference(SubjectReference source);

        /**
         * Sets the {@link SubjectReference} from the supplied {@link Subject}.
         *
         * @param source The {@link Subject}
         * @return This, for chaining
         */
        default OptionBuilder setSubject(Subject source) {
            return setSubjectReference(source.asSubjectReference());
        }

        /**
         * The {@link TextSerializer} to use when converting the returned
         * option from the {@link SubjectReference} into {@link Text}.
         *
         * @param serializer The {@link TextSerializer} to use
         * @return This, for chaining
         */
        OptionBuilder setTextSerializer(TextSerializer serializer);

    }

    /**
     * A common interface for the placeholder builders.
     *
     * @param <O> The type of output
     * @param <T> The type of builder
     */
    interface Builder<O, T extends Builder<O, T>> extends ResettableBuilder<O, T> {

        /**
         * The {@link Text} that will be prepended to the placeholder
         * if the returned text is not empty.
         *
         * @param prefix The prefix
         * @return This, for chaining
         */
        T setPrependingTextIfNotEmpty(@Nullable Text prefix);

        /**
         * The {@link Text} that will be appended to the placeholder
         * if the returned text is not empty.
         *
         * @param prefix The prefix
         * @return This, for chaining
         */
        T setAppendingTextIfNotEmpty(@Nullable Text prefix);

        /**
         * Builds and returns the placeholder.
         *
         * @return The appropriate {@link Placeholder}
         * @throws IllegalStateException if the builder has not been completed,
         *  or the associated {@link PlaceholderParser} could not validate the
         *  built {@link Placeholder}, if applicable.
         */
        O build() throws IllegalStateException;

    }
}
