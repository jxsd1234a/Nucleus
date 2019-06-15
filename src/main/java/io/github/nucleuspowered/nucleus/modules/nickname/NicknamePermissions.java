/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.nickname;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class NicknamePermissions {
    private NicknamePermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "delnick" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_DELNICK = "nick.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "delnick" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_DELNICK = "nick.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "delnick" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_DELNICK = "nick.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "delnick" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_DELNICK = "nick.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "realname" }, level = SuggestedLevel.USER)
    public static final String BASE_REALNAME = "realname.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "realname" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_REALNAME = "realname.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "realname" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_REALNAME = "realname.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "realname" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_REALNAME = "realname.exempt.warmup";

}
