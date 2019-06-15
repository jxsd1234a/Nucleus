/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.teleport;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class TeleportPermissions {
    private TeleportPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "teleport" }, level = SuggestedLevel.MOD)
    public static final String BASE_TELEPORT = "teleport.teleport.base";

    @PermissionMetadata(descriptionKey = "permission.tppos.border", level = SuggestedLevel.ADMIN)
    public static final String TELEPORT_BORDER = "teleport.teleport.exempt.bordercheck";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "teleport" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_TELEPORT = "teleport.teleport.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "teleport" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_TELEPORT = "teleport.teleport.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "teleport" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_TELEPORT = "teleport.teleport.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.teleport.offline", level = SuggestedLevel.ADMIN)
    public static final String TELEPORT_OFFLINE = "teleport.teleport.offline";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "teleport" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_TELEPORT = "teleport.teleport.others";

    @PermissionMetadata(descriptionKey = "permission.teleport.quiet", level = SuggestedLevel.ADMIN)
    public static final String TELEPORT_QUIET = "teleport.teleport.quiet";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tpa" }, level = SuggestedLevel.USER)
    public static final String BASE_TPA = "teleport.tpa.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "tpa" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_TPA = "teleport.tpa.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "tpa" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_TPA = "teleport.tpa.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "tpa" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_TPA = "teleport.tpa.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.teleport.force", level = SuggestedLevel.ADMIN)
    public static final String TELEPORT_ASK_FORCE = "teleport.tpa.force";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tpaall" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_TPAALL = "teleport.tpaall.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tpaccept" }, level = SuggestedLevel.USER)
    public static final String BASE_TPACCEPT = "teleport.tpaccept.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tpahere" }, level = SuggestedLevel.MOD)
    public static final String BASE_TPAHERE = "teleport.tpahere.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "tpahere" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_TPAHERE = "teleport.tpahere.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "tpahere" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_TPAHERE = "teleport.tpahere.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "tpahere" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_TPAHERE = "teleport.tpahere.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.teleport.force", level = SuggestedLevel.ADMIN)
    public static final String TELEPORT_HERE_FORCE = "teleport.tpahere.force";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tpall" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_TPALL = "teleport.tpall.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tpdeny" }, level = SuggestedLevel.USER)
    public static final String BASE_TPDENY = "teleport.tpdeny.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tphere" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_TPHERE = "teleport.tphere.base";

    @PermissionMetadata(descriptionKey = "permission.tphere.offline", level = SuggestedLevel.ADMIN)
    public static final String TPHERE_OFFLINE = "teleport.tphere.offline";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tppos" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_TPPOS = "teleport.tppos.base";

    @PermissionMetadata(descriptionKey = "permission.tppos.border", level = SuggestedLevel.ADMIN)
    public static final String TPPOS_BORDER = "teleport.tppos.exempt.bordercheck";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "tppos" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_TPPOS = "teleport.tppos.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tptoggle" }, level = SuggestedLevel.USER)
    public static final String BASE_TPTOGGLE = "teleport.tptoggle.base";

    @PermissionMetadata(descriptionKey = "permission.tptoggle.exempt", level = SuggestedLevel.ADMIN)
    public static final String TPTOGGLE_EXEMPT = "teleport.tptoggle.exempt";

}
