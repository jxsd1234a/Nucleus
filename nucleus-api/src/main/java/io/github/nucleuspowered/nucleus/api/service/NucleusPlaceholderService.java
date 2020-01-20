/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.service;

import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderVariables;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;

import java.util.Optional;

/**
 * Provides a way to supply placeholders to Nucleus
 */
public interface NucleusPlaceholderService {

    /**
     * Parses a string on behalf of a {@link CommandSource} based on the Nucleus
     * chat format.
     *
     * @param commandSource The source that tokens should use as a context. May
     *                      be {@code null}, but some tokens may not parse
     *                      without this supplied.
     * @param token The token text to parse.
     * @return The parsed {@link Text}.
     */
    default TextRepresentable parse(@Nullable CommandSource commandSource, String token) {
        return parse(commandSource, token, PlaceholderVariables.empty());
    }

    /**
     * Parses a string on behalf of a {@link CommandSource} based on the Nucleus
     * chat format.
     *
     * @param commandSource The source that tokens should use as a context. May
     *                      be {@code null}, but some tokens may not parse
     *                      without this supplied.
     * @param token The token text to parse.
     * @param variables The variables to pass to the placeholder parser.
     * @return The parsed {@link Text}.
     */
    TextRepresentable parse(@Nullable CommandSource commandSource, String token, PlaceholderVariables variables);

    /**
     * Registers a token.
     *
     * @param pluginContainer The {@link PluginContainer} that wants to register
     *                        the token
     * @param tokenName The name of the token to register. This will be converted
     *                  to lowercase.
     * @param parser The parser to register.
     * @throws IllegalArgumentException if the token name contains whitespace, :, | or _
     * @throws IllegalStateException if the token name has already been registered
     */
    void registerToken(PluginContainer pluginContainer, String tokenName, PlaceholderParser parser);

    /**
     * Gets the parser associated with the provided token name, if any.
     *
     * @param token The token name
     * @return The {@link PlaceholderParser}, if any
     */
    Optional<PlaceholderParser> getParser(String token);

    /**
     * Gets the {@link PluginContainer} that registered provided token name, if any.
     *
     * @param token The token name
     * @return The {@link PluginContainer}, if any
     */
    Optional<PluginContainer> getOwner(String token);
}
