/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.teleport;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(TeleportResult.class)
public final class TeleportResults {

    public static final String SUCCESS_KEY = "nucleus:success";
    public static final String FAIL_NO_LOCATION_KEY = "nucleus:fail_no_location";
    public static final String FAIL_CANCELLED_KEY = "nucleus:fail_cancelled";

    public static final TeleportResult SUCCESS = Sponge.getRegistry().getType(TeleportResult.class, SUCCESS_KEY).get();

    public static final TeleportResult FAIL_NO_LOCATION =
            Sponge.getRegistry().getType(TeleportResult.class, FAIL_NO_LOCATION_KEY).get();

    public static final TeleportResult FAIL_CANCELLED =
            Sponge.getRegistry().getType(TeleportResult.class, FAIL_CANCELLED_KEY).get();

}
