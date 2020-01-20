/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import com.google.common.collect.ImmutableMap;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderVariables;

import java.util.Optional;

public class NucleusPlaceholderVariables implements PlaceholderVariables {

    private final ImmutableMap<Key<?>, Object> map;

    public NucleusPlaceholderVariables(ImmutableMap<Key<?>, Object> map) {
        this.map = map;
    }

    @Override
    public <T> Optional<T> get(Key<T> key) {
        return Optional.ofNullable((T) this.map.get(key));
    }

    ImmutableMap<Key<?>, Object> getMap() {
        return this.map;
    }
}
