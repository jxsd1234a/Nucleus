/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.util;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * A utility class for supplying {@link CatalogType} entries.
 */
public class RegistrySupplier {

    private RegistrySupplier() {}

    /**
     * Gets a {@link Supplier}
     *
     * @param clazz The type of {@link CatalogType}
     * @param field The field name
     * @param <T> The type of {@link CatalogType}
     * @return The {@link Supplier}
     */
    public static <T extends CatalogType> Supplier<T> supply(Class<T> clazz, String field) {
        return () -> Sponge.getRegistry().getType(clazz, "nucleus:" + field.toLowerCase()).get();
    }

}
