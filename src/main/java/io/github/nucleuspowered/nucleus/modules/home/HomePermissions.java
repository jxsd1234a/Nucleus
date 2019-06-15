/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.home;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class HomePermissions {
    private HomePermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "home delete" }, level = SuggestedLevel.USER)
    public static final String BASE_HOME_DELETE = "home.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "home deleteother" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_HOME_DELETEOTHER = "home.deleteother.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "home" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_HOME = "home.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "home" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_HOME = "home.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.home.exempt.samedimension", level = SuggestedLevel.ADMIN)
    public static final String HOME_EXEMPT_SAMEDIMENSION = "home.exempt.samedimension";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "home" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_HOME = "home.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "home limit" }, level = SuggestedLevel.USER)
    public static final String BASE_HOME_LIMIT = "home.limit.base";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "limit" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_LIMIT = "home.limit.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "home list" }, level = SuggestedLevel.USER)
    public static final String BASE_HOME_LIST = "home.list.base";

    @PermissionMetadata(descriptionKey = "permission.others", level = SuggestedLevel.ADMIN)
    public static final String OTHERS = "home.list.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "home other" }, level = SuggestedLevel.MOD)
    public static final String BASE_HOME_OTHER = "home.other.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "home other" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_HOME_OTHER = "home.other.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "home other" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_HOME_OTHER = "home.other.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.home.other.exempt.target", level = SuggestedLevel.ADMIN)
    public static final String HOME_OTHER_EXEMPT_TARGET = "home.other.exempt.target";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "home other" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_HOME_OTHER = "home.other.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "home set" }, level = SuggestedLevel.USER)
    public static final String BASE_HOME_SET = "home.set.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "home set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_HOME_SET = "home.set.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "home set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_HOME_SET = "home.set.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "home set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_HOME_SET = "home.set.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.homes.unlimited", level = SuggestedLevel.ADMIN)
    public static final String HOMES_UNLIMITED = "home.set.unlimited";

}
