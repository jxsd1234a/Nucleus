/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Consumer;

abstract class PreloadTasks {

    private PreloadTasks() {}

    static List<Consumer<NucleusBootstrap>> getPreloadTasks() {
        return ImmutableList.of();
    }

    static List<Consumer<NucleusBootstrap>> getPreloadTasks2() {
        return ImmutableList.of();
    }
}
