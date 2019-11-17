/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.teleport;

import org.spongepowered.api.Sponge;

public final class TeleportScanners {

    public static final String ASCENDING_SCAN_KEY = "nucleus:ascending_scan";
    public static final String DESCENDING_SCAN_KEY = "nucleus:descending_scan";
    public static final String NO_SCAN_KEY = "nucleus:no_scan";

    public static final TeleportScanner ASCENDING_SCAN =
            Sponge.getRegistry().getType(TeleportScanner.class, ASCENDING_SCAN_KEY).get();

    public static final TeleportScanner DESCENDING_SCAN =
            Sponge.getRegistry().getType(TeleportScanner.class, DESCENDING_SCAN_KEY).get();

    public static final TeleportScanner NO_SCAN = Sponge.getRegistry().getType(TeleportScanner.class, NO_SCAN_KEY).get();
}
