/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.fly;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class FlyPermissions {
    private FlyPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "fly" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_FLY = "fly.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "fly" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_FLY = "fly.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "fly" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_FLY = "fly.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "fly" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_FLY = "fly.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "fly" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_FLY = "fly.others";

}
