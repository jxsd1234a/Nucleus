/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.ignore;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class IgnorePermissions {
    private IgnorePermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "ignore" }, level = SuggestedLevel.USER)
    public static final String BASE_IGNORE = "ignore.base";

    @PermissionMetadata(descriptionKey = "permission.ignore.chat", level = SuggestedLevel.MOD)
    public static final String IGNORE_CHAT = "ignore.exempt.chat";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "ignorelist" }, level = SuggestedLevel.USER)
    public static final String BASE_IGNORELIST = "ignorelist.base";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "ignorelist" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_IGNORELIST = "ignorelist.others";

}
