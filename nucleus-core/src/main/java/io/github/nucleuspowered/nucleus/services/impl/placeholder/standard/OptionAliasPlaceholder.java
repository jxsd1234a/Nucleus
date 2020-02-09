/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder.standard;

import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import io.github.nucleuspowered.nucleus.services.interfaces.IPermissionService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

public class OptionAliasPlaceholder implements PlaceholderParser.RequireSender {

    private final IPermissionService permissionService;
    private final String option;

    public OptionAliasPlaceholder(IPermissionService permissionService, String option) {
        this.option = option;
        this.permissionService = permissionService;
    }

    @Override
    public Text parse(Placeholder.Standard placeholder) {
        return this.permissionService
                .getOptionFromSubject(placeholder.getAssociatedSource().get(), this.option)
                .map(TextSerializers.FORMATTING_CODE::deserialize)
                .orElse(Text.EMPTY);
    }
}
