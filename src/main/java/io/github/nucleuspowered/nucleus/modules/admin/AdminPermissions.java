/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.admin;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class AdminPermissions {

    private AdminPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "blockzap" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_BLOCKZAP = "blockzap.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "blockzap" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_BLOCKZAP = "blockzap.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "blockzap" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_BLOCKZAP = "blockzap.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "blockzap" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_BLOCKZAP = "blockzap.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "broadcast" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_BROADCAST = "broadcast.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "exp" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_EXP = "exp.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "exp give" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_EXP_GIVE = "exp.give.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "exp set" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_EXP_SET = "exp.set.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "exp take" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_EXP_TAKE = "exp.take.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "gamemode" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_GAMEMODE = "gamemode.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "gamemode" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_GAMEMODE = "gamemode.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "gamemode" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_GAMEMODE = "gamemode.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "gamemode" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_GAMEMODE = "gamemode.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.gamemode.modes.adventure", level = SuggestedLevel.ADMIN)
    public static final String GAMEMODE_MODES_ADVENTURE = "gamemode.modes.adventure";

    @PermissionMetadata(descriptionKey = "permission.gamemode.modes.creative", level = SuggestedLevel.ADMIN)
    public static final String GAMEMODE_MODES_CREATIVE = "gamemode.modes.creative";

    @PermissionMetadata(descriptionKey = "permission.gamemode.modes.spectator", level = SuggestedLevel.ADMIN)
    public static final String GAMEMODE_MODES_SPECTATOR = "gamemode.modes.spectator";

    @PermissionMetadata(descriptionKey = "permission.gamemode.modes.survival", level = SuggestedLevel.ADMIN)
    public static final String GAMEMODE_MODES_SURVIVAL = "gamemode.modes.survival";

    @PermissionMetadata(descriptionKey = "permission.gamemode.other", level = SuggestedLevel.ADMIN)
    public static final String GAMEMODE_OTHER = "gamemode.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kill" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KILL = "kill.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "kill" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_KILL = "kill.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "kill" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_KILL = "kill.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "kill" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_KILL = "kill.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "killentity" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KILLENTITY = "killentity.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "killentity" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_KILLENTITY = "killentity.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "killentity" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_KILLENTITY = "killentity.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "killentity" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_KILLENTITY = "killentity.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "plainbroadcast" }, level = SuggestedLevel.OWNER)
    public static final String BASE_PLAINBROADCAST = "plainbroadcast.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "stop" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_STOP = "stop.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "sudo" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SUDO = "sudo.base";

    @PermissionMetadata(descriptionKey = "permission.sudo.exempt", level = SuggestedLevel.ADMIN)
    public static final String SUDO_EXEMPT = "sudo.exempt.target";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "tellplain" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_TELLPLAIN = "tellplain.base";

}
