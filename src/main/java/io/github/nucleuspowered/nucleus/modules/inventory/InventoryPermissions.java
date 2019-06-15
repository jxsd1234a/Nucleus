/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.inventory;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class InventoryPermissions {
    private InventoryPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "clear" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_CLEAR = "clear.base";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "clear" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_CLEAR = "clear.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "enderchest" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_ENDERCHEST = "enderchest.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "enderchest" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_ENDERCHEST = "enderchest.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "enderchest" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_ENDERCHEST = "enderchest.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.enderchest.exempt.modify", level = SuggestedLevel.ADMIN)
    public static final String ENDERCHEST_EXEMPT_MODIFY = "enderchest.exempt.modify";

    @PermissionMetadata(descriptionKey = "permission.enderchest.exempt.inspect", level = SuggestedLevel.ADMIN)
    public static final String ENDERCHEST_EXEMPT_INSPECT = "enderchest.exempt.target";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "enderchest" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_ENDERCHEST = "enderchest.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.enderchest.modify", level = SuggestedLevel.ADMIN)
    public static final String ENDERCHEST_MODIFY = "enderchest.modify";

    @PermissionMetadata(descriptionKey = "permission.enderchest.offline", level = SuggestedLevel.ADMIN)
    public static final String ENDERCHEST_OFFLINE = "enderchest.offline";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "enderchest" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_ENDERCHEST = "enderchest.others";

    @PermissionMetadata(descriptionKey = "permission.inventory.keep", level = SuggestedLevel.ADMIN)
    public static final String INVENTORY_KEEP = "inventory.keepondeath";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "invsee" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_INVSEE = "invsee.base";

    @PermissionMetadata(descriptionKey = "permission.invsee.exempt.interact", level = SuggestedLevel.ADMIN)
    public static final String INVSEE_EXEMPT_INTERACT = "invsee.exempt.interact";

    @PermissionMetadata(descriptionKey = "permission.invsee.exempt.inspect", level = SuggestedLevel.ADMIN)
    public static final String INVSEE_EXEMPT_INSPECT = "invsee.exempt.target";

    @PermissionMetadata(descriptionKey = "permission.invsee.modify", level = SuggestedLevel.ADMIN)
    public static final String INVSEE_MODIFY = "invsee.modify";

    @PermissionMetadata(descriptionKey = "permission.invsee.offline", level = SuggestedLevel.ADMIN)
    public static final String INVSEE_OFFLINE = "invsee.offline";

}
