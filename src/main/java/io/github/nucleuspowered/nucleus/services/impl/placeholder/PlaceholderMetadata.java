/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import org.spongepowered.api.plugin.PluginContainer;

public class PlaceholderMetadata {
    private final String token;
    private final PluginContainer pluginContainer;
    private final PlaceholderParser parser;

    PlaceholderMetadata(String token, PluginContainer pluginContainer, PlaceholderParser parser) {
        this.token = token;
        this.pluginContainer = pluginContainer;
        this.parser = parser;
    }

    public String getToken() {
        return this.token;
    }

    public PluginContainer getPluginContainer() {
        return this.pluginContainer;
    }

    public PlaceholderParser getParser() {
        return this.parser;
    }
}
