/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.vanish;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class VanishPermissions {
    private VanishPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "vanish" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_VANISH = "vanish.base";

    @PermissionMetadata(descriptionKey = "permission.vanish.onlogin", level = SuggestedLevel.NONE)
    public static final String VANISH_ONLOGIN = "vanish.onlogin";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "vanish" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_VANISH = "vanish.others";

    @PermissionMetadata(descriptionKey = "permission.vanish.persist", level = SuggestedLevel.ADMIN)
    public static final String VANISH_PERSIST = "vanish.persist";

    @PermissionMetadata(descriptionKey = "permission.vanish.see", level = SuggestedLevel.ADMIN)
    public static final String VANISH_SEE = "vanish.see";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "vanishonlogin" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_VANISHONLOGIN = "vanishonlogin.base";

}