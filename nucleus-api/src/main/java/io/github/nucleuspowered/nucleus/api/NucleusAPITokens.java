/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api;

import io.github.nucleuspowered.nucleus.api.core.NucleusAPIMetaService;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.annotation.NonnullByDefault;

@NonnullByDefault
public final class NucleusAPITokens {

    private NucleusAPITokens() {}

    final static String ID = "nucleus-api";
    final static String NAME = "Nucleus API";
    final static String VERSION = "@version@";
    final static String DESCRIPTION = "@description@";

    public static void onPreInit(Object plugin) {
        Sponge.getServiceManager().setProvider(plugin, NucleusAPIMetaService.class, new NucleusAPIMetaService(VERSION));
    }

}
