/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import com.google.common.reflect.TypeToken;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderVariables;
import org.checkerframework.checker.nullness.qual.NonNull;

public class NucleusPlaceholderVariableKeyBuilder implements PlaceholderVariables.KeyBuilder {

    static final NucleusPlaceholderVariableKeyBuilder INSTANCE = new NucleusPlaceholderVariableKeyBuilder();

    private NucleusPlaceholderVariableKeyBuilder() {
        // nope
    }

    @Override
    public <T> PlaceholderVariables.@NonNull Key<T> build(String name, TypeToken<T> clazz) {
        return new NucleusPlaceholderVariableKey<>(name, clazz);
    }

    @Override
    public PlaceholderVariables.@NonNull KeyBuilder from(PlaceholderVariables.@NonNull Key<?> value) {
        return this;
    }

    @Override
    public PlaceholderVariables.@NonNull KeyBuilder reset() {
        return this;
    }
}
