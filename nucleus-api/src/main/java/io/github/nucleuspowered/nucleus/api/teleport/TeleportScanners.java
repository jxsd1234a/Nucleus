/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.teleport;

import io.github.nucleuspowered.nucleus.api.util.RegistrySupplier;

import java.util.function.Supplier;

public final class TeleportScanners {

    public static final Supplier<TeleportScanner> ASCENDING_SCAN =
            RegistrySupplier.supply(TeleportScanner.class, "ASCENDING_SCAN");

    public static final Supplier<TeleportScanner> DESCENDING_SCAN =
            RegistrySupplier.supply(TeleportScanner.class, "DESCENDING_SCAN");

    public static final Supplier<TeleportScanner> NO_SCAN =
            RegistrySupplier.supply(TeleportScanner.class, "NO_SCAN");;
}
