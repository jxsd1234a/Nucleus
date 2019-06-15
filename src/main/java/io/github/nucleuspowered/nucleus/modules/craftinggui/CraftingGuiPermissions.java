/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.craftinggui;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class CraftingGuiPermissions {

    private CraftingGuiPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"anvil"}, level = SuggestedLevel.ADMIN)
    public static final String BASE_ANVIL = "anvil.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = {"anvil"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_ANVIL = "anvil.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = {"anvil"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_ANVIL = "anvil.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = {"anvil"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_ANVIL = "anvil.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"enchantingtable"}, level = SuggestedLevel.ADMIN)
    public static final String BASE_ENCHANTINGTABLE = "enchantingtable.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = {"enchantingtable"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_ENCHANTINGTABLE = "enchantingtable.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = {"enchantingtable"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_ENCHANTINGTABLE = "enchantingtable.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = {"enchantingtable"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_ENCHANTINGTABLE = "enchantingtable.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = {"workbench"}, level = SuggestedLevel.ADMIN)
    public static final String BASE_WORKBENCH = "workbench.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = {"workbench"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WORKBENCH = "workbench.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = {"workbench"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WORKBENCH = "workbench.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = {"workbench"}, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WORKBENCH = "workbench.exempt.warmup";

}
