/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.servershop;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class ServerShopPermissions {

    private ServerShopPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"itembuy"}, level = SuggestedLevel.USER)
    public static final String BASE_ITEMBUY = "itembuy.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"itemsell"}, level = SuggestedLevel.USER)
    public static final String BASE_ITEMSELL = "itemsell.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"itemsellall"}, level = SuggestedLevel.USER)
    public static final String BASE_ITEMSELLALL = "itemsellall.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"setworth"}, level = SuggestedLevel.ADMIN)
    public static final String BASE_SETWORTH = "setworth.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"worth"}, level = SuggestedLevel.USER)
    public static final String BASE_WORTH = "worth.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = {"worth"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORTH = "worth.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = {"worth"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORTH = "worth.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = {"worth"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORTH = "worth.exempt.warmup";

}
