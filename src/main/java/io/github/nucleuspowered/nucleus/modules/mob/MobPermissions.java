/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.mob;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class MobPermissions {
    private MobPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "spawnmob" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SPAWNMOB = "spawnmob.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "spawnmob" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_SPAWNMOB = "spawnmob.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "spawnmob" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_SPAWNMOB = "spawnmob.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "spawnmob" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_SPAWNMOB = "spawnmob.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.spawnmob.mob", level = SuggestedLevel.ADMIN)
    public static final String SPAWNMOB_MOB = "spawnmob.mob";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "spawnmob" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_SPAWNMOB = "spawnmob.others";

}
