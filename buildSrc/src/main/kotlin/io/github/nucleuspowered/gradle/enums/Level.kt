/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.gradle.enums

fun getLevel(version: String): Level {
    for (level in Level.values()) {
        if (level.selectionCriteria(version)) {
            return level
        }
    }

    // Fallback
    return Level.SNAPSHOT
}

enum class Level(val selectionCriteria: (String) -> Boolean, val template: String, val isNotUnique: Boolean) {
    SNAPSHOT( { version -> version.endsWith("SNAPSHOT") } , "snapshot", true),
    ALPHA( { version -> version.contains("ALPHA") }, "alpha", false),
    BETA( { version -> version.contains("BETA") }, "beta", false),
    RELEASE_CANDIDATE( { version -> version.contains("RC") } , "rc", false),
    RELEASE_MAJOR( { version -> version.endsWith(".0") } , "release-big", false),
    RELEASE_MINOR( { true }, "release", false);
}