/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.back;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class BackPermissions {
    private BackPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "back" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_BACK = "back.base";

    @PermissionMetadata(descriptionKey = "permission.tppos.border", level = SuggestedLevel.ADMIN)
    public static final String TPPOS_BORDER = "back.exempt.bordercheck";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "back" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_BACK = "back.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "back" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_BACK = "back.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.back.exempt.samedimension", level = SuggestedLevel.MOD)
    public static final String BACK_EXEMPT_SAMEDIMENSION = "back.exempt.samedimension";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "back" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_BACK = "back.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.back.ondeath", level = SuggestedLevel.USER)
    public static final String BACK_ONDEATH = "back.targets.death";

    @PermissionMetadata(descriptionKey = "permission.back.onportal", level = SuggestedLevel.USER)
    public static final String BACK_ONPORTAL = "back.targets.portal";

    @PermissionMetadata(descriptionKey = "permission.back.onteleport", level = SuggestedLevel.USER)
    public static final String BACK_ONTELEPORT = "back.targets.teleport";

}
