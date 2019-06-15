/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.freezeplayer;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class FreezePlayerPermissions {

    private FreezePlayerPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "freezeplayer" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_FREEZEPLAYER = "freezeplayer.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "freezeplayer" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_FREEZEPLAYER = "freezeplayer.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "freezeplayer" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_FREEZEPLAYER = "freezeplayer.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "freezeplayer" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_FREEZEPLAYER = "freezeplayer.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "freezeplayer" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_FREEZEPLAYER = "freezeplayer.others";

}
