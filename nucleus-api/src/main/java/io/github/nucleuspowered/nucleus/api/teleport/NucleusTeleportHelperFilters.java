/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.teleport;

import io.github.nucleuspowered.nucleus.api.util.RegistrySupplier;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;

import java.util.function.Supplier;

/**
 * Do not access before Pre-Init
 */
public final class NucleusTeleportHelperFilters {

    /**
     * Returns the location that is passed into the filter.
     */
    public final static Supplier<TeleportHelperFilter> NO_CHECK =
            RegistrySupplier.supply(TeleportHelperFilter.class, "NO_CHECK");

    /**
     * Returns a location that is not a wall.
     */
    public final static Supplier<TeleportHelperFilter> WALL_CHECK =
            RegistrySupplier.supply(TeleportHelperFilter.class, "WALL_CHECK");

}
