/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.module.nameban;

import io.github.nucleuspowered.nucleus.api.module.nameban.exception.NameBanException;
import org.spongepowered.api.event.cause.Cause;

import java.util.Optional;

/**
 * Manages player names that are prohibited from joining a server.
 */
public interface NucleusNameBanService {

    /**
     * Adds a name to a blacklist, preventing them from joining the server.
     *
     * @param name The name
     * @param reason The reason to give for the banning
     * @param cause The {@link Cause} of this request
     * @throws NameBanException thrown if the name could not be added to the list
     */
    void addName(String name, String reason, Cause cause) throws NameBanException;

    /**
     * If a name is banned, returns the reason.
     *
     * @param name The name to get the reason for
     * @return The reason if the name is banned
     */
    Optional<String> getReasonForBan(String name);

    /**
     * Removes a name from the blacklist.
     *
     * @param name The name to remove
     * @param cause The {@link Cause} of this request
     * @throws NameBanException thrown if the name could not be removed from the list
     */
    void removeName(String name, Cause cause) throws NameBanException;
}
