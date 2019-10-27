/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.service;

import io.github.nucleuspowered.nucleus.api.exceptions.NameBanException;
import org.spongepowered.api.event.cause.Cause;

import java.util.Optional;

/**
 * Created by Daniel on 26/02/2017.
 */
public interface NucleusNameBanService {

    void addName(String name, String reason, Cause cause) throws NameBanException;

    Optional<String> getReasonForBan(String name);

    void removeName(String name, Cause cause) throws NameBanException;
}
