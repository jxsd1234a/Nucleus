/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.world;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class WorldPermissions {
    private WorldPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD = "world.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world border" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_BORDER = "world.border.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world border" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_BORDER = "world.border.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world border" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_BORDER = "world.border.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world border" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_BORDER = "world.border.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "border gen" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_BORDER_GEN = "world.border.gen.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "border gen" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_BORDER_GEN = "world.border.gen.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "border gen" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_BORDER_GEN = "world.border.gen.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "border gen" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_BORDER_GEN = "world.border.gen.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.world.border.gen.notify", level = SuggestedLevel.ADMIN)
    public static final String WORLD_BORDER_GEN_NOTIFY = "world.border.gen.notify";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "border set" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_BORDER_SET = "world.border.set.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world clone" }, level = SuggestedLevel.OWNER)
    public static final String BASE_WORLD_CLONE = "world.clone.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world presets" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_PRESETS = "world.create.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world create" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_CREATE = "world.create.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world create" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_CREATE = "world.create.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world create" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_CREATE = "world.create.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world delete" }, level = SuggestedLevel.OWNER)
    public static final String BASE_WORLD_DELETE = "world.delete.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world disable" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_DISABLE = "world.disable.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world enable" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_ENABLE = "world.enable.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD = "world.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD = "world.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD = "world.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.world.force-gamemode.override", level = SuggestedLevel.ADMIN)
    public static final String WORLD_FORCE_GAMEMODE_OVERRIDE = "world.force-gamemode.override";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world gamerule" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_GAMERULE = "world.gamerule.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "gamerule set" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_GAMERULE_SET = "world.gamerule.set.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world info" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_INFO = "world.list.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world info" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_INFO = "world.list.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world info" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_INFO = "world.list.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world info" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_INFO = "world.list.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.world.seed", level = SuggestedLevel.ADMIN)
    public static final String WORLD_SEED = "world.list.seed";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world load" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_LOAD = "world.load.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world rename" }, level = SuggestedLevel.OWNER)
    public static final String BASE_WORLD_RENAME = "world.rename.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world setdifficulty" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SETDIFFICULTY = "world.setdifficulty.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world setgamemode" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SETGAMEMODE = "world.setgamemode.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world sethardcore" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SETHARDCORE = "world.sethardcore.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world sethardcore" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_SETHARDCORE = "world.sethardcore.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world sethardcore" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_SETHARDCORE = "world.sethardcore.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world sethardcore" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_SETHARDCORE = "world.sethardcore.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world setkeepspawnloaded" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SETKEEPSPAWNLOADED = "world.setkeepspawnloaded.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world setkeepspawnloaded" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_SETKEEPSPAWNLOADED = "world.setkeepspawnloaded.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world setkeepspawnloaded" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_SETKEEPSPAWNLOADED = "world.setkeepspawnloaded.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world setkeepspawnloaded" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_SETKEEPSPAWNLOADED = "world.setkeepspawnloaded.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world setloadonstartup" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SETLOADONSTARTUP = "world.setloadonstartup.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world setloadonstartup" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_SETLOADONSTARTUP = "world.setloadonstartup.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world setloadonstartup" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_SETLOADONSTARTUP = "world.setloadonstartup.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world setloadonstartup" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_SETLOADONSTARTUP = "world.setloadonstartup.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world setpvpenabled" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SETPVPENABLED = "world.setpvpenabled.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world setpvpenabled" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_SETPVPENABLED = "world.setpvpenabled.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world setpvpenabled" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_SETPVPENABLED = "world.setpvpenabled.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world setpvpenabled" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_SETPVPENABLED = "world.setpvpenabled.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world setspawn" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SETSPAWN = "world.setspawn.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world setspawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_SETSPAWN = "world.setspawn.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world setspawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_SETSPAWN = "world.setspawn.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world setspawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_SETSPAWN = "world.setspawn.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world spawn" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_SPAWN = "world.spawn.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world spawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_SPAWN = "world.spawn.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world spawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_SPAWN = "world.spawn.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world spawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_SPAWN = "world.spawn.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world teleport" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_TELEPORT = "world.teleport.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "world teleport" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORLD_TELEPORT = "world.teleport.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "world teleport" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORLD_TELEPORT = "world.teleport.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "world teleport" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORLD_TELEPORT = "world.teleport.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.world.teleport.other", level = SuggestedLevel.ADMIN)
    public static final String WORLD_TELEPORT_OTHER = "world.teleport.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "world unload" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORLD_UNLOAD = "world.unload.base";

}
