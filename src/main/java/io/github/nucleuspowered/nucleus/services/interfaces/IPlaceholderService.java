/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.interfaces;

import com.google.inject.ImplementedBy;
import io.github.nucleuspowered.nucleus.api.service.NucleusPlaceholderService;
import io.github.nucleuspowered.nucleus.services.impl.placeholder.PlaceholderMetadata;
import io.github.nucleuspowered.nucleus.services.impl.placeholder.PlaceholderService;

import java.util.Collection;

@ImplementedBy(PlaceholderService.class)
public interface IPlaceholderService extends NucleusPlaceholderService {

    Collection<PlaceholderMetadata> getNucleusParsers();

}
