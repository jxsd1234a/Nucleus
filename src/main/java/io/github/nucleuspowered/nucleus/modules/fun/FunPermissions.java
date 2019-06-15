/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.fun;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class FunPermissions {
    private FunPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "hat" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_HAT = "hat.base";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "hat" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_HAT = "hat.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "ignite" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_IGNITE = "ignite.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "ignite" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_IGNITE = "ignite.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "ignite" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_IGNITE = "ignite.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "ignite" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_IGNITE = "ignite.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "ignite" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_IGNITE = "ignite.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kittycannon" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KITTYCANNON = "kittycannon.base";

    @PermissionMetadata(descriptionKey = "permission.kittycannon.break", level = SuggestedLevel.ADMIN)
    public static final String KITTYCANNON_BREAK = "kittycannon.break";

    @PermissionMetadata(descriptionKey = "permission.kittycannon.damage", level = SuggestedLevel.ADMIN)
    public static final String KITTYCANNON_DAMAGE = "kittycannon.damage";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "kittycannon" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_KITTYCANNON = "kittycannon.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "kittycannon" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_KITTYCANNON = "kittycannon.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "kittycannon" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_KITTYCANNON = "kittycannon.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.kittycannon.fire", level = SuggestedLevel.ADMIN)
    public static final String KITTYCANNON_FIRE = "kittycannon.fire";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "kittycannon" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_KITTYCANNON = "kittycannon.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "lightning" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_LIGHTNING = "lightning.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "lightning" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_LIGHTNING = "lightning.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "lightning" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_LIGHTNING = "lightning.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "lightning" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_LIGHTNING = "lightning.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "lightning" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_LIGHTNING = "lightning.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "rocket" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_ROCKET = "rocket.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "rocket" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_ROCKET = "rocket.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "rocket" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_ROCKET = "rocket.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "rocket" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_ROCKET = "rocket.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "rocket" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_ROCKET = "rocket.others";

}

