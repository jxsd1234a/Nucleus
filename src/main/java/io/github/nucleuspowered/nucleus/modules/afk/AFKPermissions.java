/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.afk;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class AFKPermissions {
    private AFKPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "afk" }, level = SuggestedLevel.USER)
    public static final String BASE_AFK = "afk.base";

    @PermissionMetadata(descriptionKey = "permission.afk.exempt.kick", level = SuggestedLevel.ADMIN)
    public static final String AFK_EXEMPT_KICK = "afk.exempt.kick";

    @PermissionMetadata(descriptionKey = "permission.afk.exempt.toggle", level = SuggestedLevel.NONE)
    public static final String AFK_EXEMPT_TOGGLE = "afk.exempt.toggle";

    @PermissionMetadata(descriptionKey = "permission.afk.notify", level = SuggestedLevel.ADMIN)
    public static final String AFK_NOTIFY = "afk.notify";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "afkkick" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_AFKKICK = "afkkick.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "afkrefresh" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_AFKREFRESH = "afkrefresh.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "afkrefresh" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_AFKREFRESH = "afkrefresh.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "afkrefresh" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_AFKREFRESH = "afkrefresh.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "afkrefresh" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_AFKREFRESH = "afkrefresh.exempt.warmup";

}