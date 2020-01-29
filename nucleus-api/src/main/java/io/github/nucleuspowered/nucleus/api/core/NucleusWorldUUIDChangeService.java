/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.core;

import java.util.Optional;
import java.util.UUID;

/**
 * Gets the specified world {@link UUID} mapping.
 */
public interface NucleusWorldUUIDChangeService {

    /**
     * Gets the new {@link UUID} as specified in the config file.
     *
     * @param oldUUID The old UUID that has been mapped
     * @return The new {@link UUID} if specified in the config file
     */
    Optional<UUID> getMappedUUID(UUID oldUUID);
}
