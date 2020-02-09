/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderVariables;

import java.util.HashMap;
import java.util.Map;

public class NucleusPlaceholderVariablesBuilder implements PlaceholderVariables.Builder {

    private final Map<PlaceholderVariables.Key<?>, Object> map = new HashMap<>();

    @Override
    public <T> PlaceholderVariables.Builder put(PlaceholderVariables.Key<T> key, T value) {
        this.map.put(key, value);
        return this;
    }

    @Override
    public PlaceholderVariables build() {
        return new NucleusPlaceholderVariables(ImmutableMap.copyOf(this.map));
    }

    @Override
    public PlaceholderVariables.Builder from(PlaceholderVariables value) {
        Preconditions.checkArgument(value instanceof NucleusPlaceholderVariables, "Value must be NucleusPlaceholderVariable");
        this.map.clear();
        this.map.putAll(((NucleusPlaceholderVariables) value).getMap());
        return this;
    }

    @Override
    public PlaceholderVariables.Builder reset() {
        this.map.clear();
        return this;
    }

}
