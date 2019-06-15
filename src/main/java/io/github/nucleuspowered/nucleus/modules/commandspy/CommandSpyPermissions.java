/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.commandspy;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class CommandSpyPermissions {

    private CommandSpyPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "commandspy" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_COMMANDSPY = "commandspy.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "commandspy" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_COMMANDSPY = "commandspy.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "commandspy" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_COMMANDSPY = "commandspy.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.commandspy.exempt.target", level = SuggestedLevel.ADMIN)
    public static final String COMMANDSPY_EXEMPT_TARGET = "commandspy.exempt.target";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "commandspy" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_COMMANDSPY = "commandspy.exempt.warmup";

}
