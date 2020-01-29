/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.userprefs;

import io.github.nucleuspowered.nucleus.Constants;
import io.github.nucleuspowered.nucleus.annotationprocessor.Store;

/**
 * Indicates that this contains {@link io.github.nucleuspowered.nucleus.api.core.NucleusUserPreferenceService.PreferenceKey}s.
 */
@Store(Constants.PREF_KEYS)
public interface UserPrefKeys { }
