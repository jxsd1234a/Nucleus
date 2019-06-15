/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.kit;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class KitPermissions {
    private KitPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit add" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_ADD = "kit.add.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit autoredeem" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_AUTOREDEEM = "kit.autoredeem.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit" }, level = SuggestedLevel.USER)
    public static final String BASE_KIT = "kit.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "command add" }, level = SuggestedLevel.OWNER)
    public static final String BASE_COMMAND_ADD = "kit.command.add.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit command" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_COMMAND = "kit.command.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "command clear" }, level = SuggestedLevel.OWNER)
    public static final String BASE_COMMAND_CLEAR = "kit.command.remove.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit cost" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_COST = "kit.cost.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit create" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_CREATE = "kit.create.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit edit" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_EDIT = "kit.edit.base";

    @PermissionMetadata(descriptionKey = "permission.kit.exempt.cooldown", level = SuggestedLevel.ADMIN)
    public static final String KIT_EXEMPT_COOLDOWN = "kit.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.kit.exempt.cost", level = SuggestedLevel.ADMIN)
    public static final String KIT_EXEMPT_COST = "kit.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.kit.exempt.onetime", level = SuggestedLevel.ADMIN)
    public static final String KIT_EXEMPT_ONETIME = "kit.exempt.onetime";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "kit" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_KIT = "kit.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit give" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_GIVE = "kit.give.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "kit give" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_KIT_GIVE = "kit.give.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "kit give" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_KIT_GIVE = "kit.give.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "kit give" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_KIT_GIVE = "kit.give.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.kit.give.override", level = SuggestedLevel.ADMIN)
    public static final String KIT_GIVE_OVERRIDE = "kit.give.overridecheck";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit hidden" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_HIDDEN = "kit.hidden.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit info" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_INFO = "kit.info.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit list" }, level = SuggestedLevel.USER)
    public static final String BASE_KIT_LIST = "kit.list.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit onetime" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_ONETIME = "kit.onetime.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit permissionbypass" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_PERMISSIONBYPASS = "kit.permissionbypass.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit remove" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_REMOVE = "kit.remove.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit rename" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_RENAME = "kit.rename.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit resetusage" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_RESETUSAGE = "kit.resetusage.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit set" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_SET = "kit.set.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit setcooldown" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_SETCOOLDOWN = "kit.setcooldown.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit setfirstjoin" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_SETFIRSTJOIN = "kit.setfirstjoin.base";

    @PermissionMetadata(descriptionKey = "permission.kit.showhidden", level = SuggestedLevel.ADMIN)
    public static final String KIT_SHOWHIDDEN = "kit.showhidden";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit toggleredeemmessage" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_TOGGLEREDEEMMESSAGE = "kit.toggleredeemmessage.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "kit view" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_KIT_VIEW = "kit.view.base";

    @PermissionMetadata(descriptionKey = "permission.kits", level = SuggestedLevel.ADMIN, isPrefix = true)
    public static final String KITS = "kits";

}
