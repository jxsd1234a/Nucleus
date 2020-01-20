/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import com.google.common.reflect.TypeToken;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderVariables;

import java.util.Objects;

public class NucleusPlaceholderVariableKey<T> implements PlaceholderVariables.Key<T> {

    private final String key;
    private final TypeToken<T> clazz;

    public NucleusPlaceholderVariableKey(String key, TypeToken<T> clazz) {
        this.key = key;
        this.clazz = clazz;
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public TypeToken<T> getValueClass() {
        return this.clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NucleusPlaceholderVariableKey<?> that = (NucleusPlaceholderVariableKey<?>) o;
        return Objects.equals(this.key, that.key) &&
                Objects.equals(this.clazz, that.clazz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.clazz);
    }

}
