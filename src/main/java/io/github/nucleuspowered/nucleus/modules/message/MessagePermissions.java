/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.message;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class MessagePermissions {
    private MessagePermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "helpop" }, level = SuggestedLevel.USER)
    public static final String BASE_HELPOP = "helpop.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "helpop" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_HELPOP = "helpop.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "helpop" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_HELPOP = "helpop.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "helpop" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_HELPOP = "helpop.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.helpop.receive", level = SuggestedLevel.MOD)
    public static final String HELPOP_RECEIVE = "helpop.receive";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "reply" }, level = SuggestedLevel.USER)
    public static final String BASE_REPLY = "message.base";

    @PermissionMetadata(descriptionKey = "permission.message.color", level = SuggestedLevel.ADMIN)
    public static final String MESSAGE_COLOR = "message.color";

    @PermissionMetadata(descriptionKey = "permission.message.colour", level = SuggestedLevel.ADMIN)
    public static final String MESSAGE_COLOUR = "message.colour";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "reply" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_REPLY = "message.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "reply" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_REPLY = "message.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "reply" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_REPLY = "message.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.message.magic", level = SuggestedLevel.ADMIN)
    public static final String MESSAGE_MAGIC = "message.magic";

    @PermissionMetadata(descriptionKey = "permission.message.style", level = SuggestedLevel.ADMIN)
    public static final String MESSAGE_STYLE = "message.style";

    @PermissionMetadata(descriptionKey = "permission.message.urls", level = SuggestedLevel.ADMIN)
    public static final String MESSAGE_URLS = "message.url";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "msgtoggle" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_MSGTOGGLE = "msgtoggle.base";

    @PermissionMetadata(descriptionKey = "permission.msgtoggle.bypass", level = SuggestedLevel.ADMIN)
    public static final String MSGTOGGLE_BYPASS = "msgtoggle.bypass";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "socialspy" }, level = SuggestedLevel.MOD)
    public static final String BASE_SOCIALSPY = "socialspy.base";

    @PermissionMetadata(descriptionKey = "permission.socialspy.force", level = SuggestedLevel.NONE)
    public static final String SOCIALSPY_FORCE = "socialspy.force";

}
