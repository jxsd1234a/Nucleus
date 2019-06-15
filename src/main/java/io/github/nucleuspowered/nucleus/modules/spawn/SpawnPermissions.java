/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.spawn;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class SpawnPermissions {
    private SpawnPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "firstspawn" }, level = SuggestedLevel.USER)
    public static final String BASE_FIRSTSPAWN = "firstspawn.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "firstspawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_FIRSTSPAWN = "firstspawn.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "firstspawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_FIRSTSPAWN = "firstspawn.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "firstspawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_FIRSTSPAWN = "firstspawn.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "setfirstspawn del" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SETFIRSTSPAWN_DEL = "firstspawn.remove.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "setfirstspawn" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SETFIRSTSPAWN = "firstspawn.set.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "setspawn" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SETSPAWN = "setspawn.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "spawn" }, level = SuggestedLevel.USER)
    public static final String BASE_SPAWN = "spawn.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "spawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_SPAWN = "spawn.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "spawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_SPAWN = "spawn.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.spawn.exempt.login", level = SuggestedLevel.ADMIN)
    public static final String SPAWN_EXEMPT_LOGIN = "spawn.exempt.login";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "spawn" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_SPAWN = "spawn.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.spawn.force", level = SuggestedLevel.ADMIN)
    public static final String SPAWN_FORCE = "spawn.force";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "spawn other" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SPAWN_OTHER = "spawn.other.base";

    @PermissionMetadata(descriptionKey = "permission.spawnother.offline", level = SuggestedLevel.ADMIN)
    public static final String SPAWNOTHER_OFFLINE = "spawn.other.offline";

    @PermissionMetadata(descriptionKey = "permission.spawn.otherworlds", level = SuggestedLevel.ADMIN)
    public static final String SPAWN_OTHERWORLDS = "spawn.otherworlds";

    @PermissionMetadata(descriptionKey = "permission.spawn.worlds", level = SuggestedLevel.ADMIN)
    public static final String SPAWN_WORLDS = "spawn.worlds";

}
