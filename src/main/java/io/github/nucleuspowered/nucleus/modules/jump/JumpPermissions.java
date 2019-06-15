/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.jump;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class JumpPermissions {
    private JumpPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "jump" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_JUMP = "jump.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "jump" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_JUMP = "jump.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "jump" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_JUMP = "jump.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "jump" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_JUMP = "jump.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "thru" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_THRU = "thru.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "thru" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_THRU = "thru.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "thru" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_THRU = "thru.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "thru" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_THRU = "thru.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "top" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_TOP = "top.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "top" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_TOP = "top.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "top" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_TOP = "top.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "top" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_TOP = "top.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "top" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_TOP = "top.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "unstuck" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_UNSTUCK = "unstuck.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "unstuck" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_UNSTUCK = "unstuck.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "unstuck" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_UNSTUCK = "unstuck.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "unstuck" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_UNSTUCK = "unstuck.exempt.warmup";

}
