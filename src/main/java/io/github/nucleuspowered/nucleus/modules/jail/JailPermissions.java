/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.jail;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class JailPermissions {
    private JailPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "checkjailed" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_CHECKJAILED = "checkjailed.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "jail" }, level = SuggestedLevel.MOD)
    public static final String BASE_JAIL = "jail.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "checkjail" }, level = SuggestedLevel.MOD)
    public static final String BASE_CHECKJAIL = "jail.checkjail.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "jails delete" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_JAILS_DELETE = "jail.delete.base";

    @PermissionMetadata(descriptionKey = "permission.jail.exempt.target", level = SuggestedLevel.ADMIN)
    public static final String JAIL_EXEMPT_TARGET = "jail.exempt.target";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "jails tp" }, level = SuggestedLevel.MOD)
    public static final String BASE_JAILS_TP = "jail.list.base";

    @PermissionMetadata(descriptionKey = "permission.jail.notify", level = SuggestedLevel.MOD)
    public static final String JAIL_NOTIFY = "jail.notify";

    @PermissionMetadata(descriptionKey = "permission.jail.offline", level = SuggestedLevel.MOD)
    public static final String JAIL_OFFLINE = "jail.offline";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "jails set" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_JAILS_SET = "jail.set.base";

    @PermissionMetadata(descriptionKey = "permission.jail.teleportjailed", level = SuggestedLevel.ADMIN)
    public static final String JAIL_TELEPORTJAILED = "jail.teleportjailed";

    @PermissionMetadata(descriptionKey = "permission.jail.teleporttojailed", level = SuggestedLevel.ADMIN)
    public static final String JAIL_TELEPORTTOJAILED = "jail.teleporttojailed";

    @PermissionMetadata(descriptionKey = "permission.jail.unjail", level = SuggestedLevel.MOD)
    public static final String JAIL_UNJAIL = "jail.unjail";

}
