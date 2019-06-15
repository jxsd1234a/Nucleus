/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.warp;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class WarpPermissions {
    private WarpPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp" }, level = SuggestedLevel.USER)
    public static final String BASE_WARP = "warp.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp category" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WARP_CATEGORY = "warp.category.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "category removedescription" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_CATEGORY_REMOVEDESCRIPTION = "warp.category.description.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "category removedisplayname" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_CATEGORY_REMOVEDISPLAYNAME = "warp.category.displayname.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "warp category" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WARP_CATEGORY = "warp.category.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "warp category" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WARP_CATEGORY = "warp.category.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "warp category" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WARP_CATEGORY = "warp.category.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "category list" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_CATEGORY_LIST = "warp.category.list.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp cost" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WARP_COST = "warp.cost.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp delete" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WARP_DELETE = "warp.delete.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "warp delete" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WARP_DELETE = "warp.delete.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "warp delete" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WARP_DELETE = "warp.delete.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "warp delete" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WARP_DELETE = "warp.delete.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "warp" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WARP = "warp.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "warp" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WARP = "warp.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp list" }, level = SuggestedLevel.USER)
    public static final String BASE_WARP_LIST = "warp.list.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "warp list" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WARP_LIST = "warp.list.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "warp list" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WARP_LIST = "warp.list.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "warp list" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WARP_LIST = "warp.list.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "warp" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_WARP = "warp.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp set" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WARP_SET = "warp.set.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "warp set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WARP_SET = "warp.set.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "warp set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WARP_SET = "warp.set.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "warp set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WARP_SET = "warp.set.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp setcategory" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WARP_SETCATEGORY = "warp.setcategory.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "warp setdescription" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WARP_SETDESCRIPTION = "warp.setdescription.base";

    @PermissionMetadata(descriptionKey = "permissions.warps", level = SuggestedLevel.ADMIN, isPrefix = true)
    public static final String PERMISSIONS_WARPS = "warps";

}
