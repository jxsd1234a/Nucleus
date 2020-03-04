/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.configurate.typeserialisers;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Locale;

public class LocaleSerialiser implements TypeSerializer<Locale> {

    @Nullable
    @Override
    public Locale deserialize(@NonNull TypeToken<?> type, @NonNull ConfigurationNode value) {
        Locale l = Locale.forLanguageTag(value.getString("und"));
        if (l.toString().isEmpty()) {
            return null;
        }
        return l;
    }

    @Override
    public void serialize(@NonNull TypeToken<?> type, @Nullable Locale obj, @NonNull ConfigurationNode value) {
        if (obj != null && !obj.toString().isEmpty()) {
            value.setValue(obj.toString());
        }
    }
}
