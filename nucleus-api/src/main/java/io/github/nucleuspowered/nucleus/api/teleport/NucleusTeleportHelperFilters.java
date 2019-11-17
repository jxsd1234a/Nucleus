/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.teleport;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;

/**
 * Do not access before Pre-Init
 */
public final class NucleusTeleportHelperFilters {

    public final static String NO_CHECK_ID = "nucleus:no_check";
    public final static String WALL_CHECK_ID = "nucleus:wall_check";

    /**
     * Returns the location that is passed into the filter.
     */
    public final static TeleportHelperFilter NO_CHECK = Sponge.getRegistry().getType(TeleportHelperFilter.class, NO_CHECK_ID).get();

    /**
     * Returns a location that is not a wall.
     */
    public final static TeleportHelperFilter WALL_CHECK = Sponge.getRegistry().getType(TeleportHelperFilter.class, WALL_CHECK_ID).get();

}
