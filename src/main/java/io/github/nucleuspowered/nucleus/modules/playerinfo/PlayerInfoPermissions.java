/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.playerinfo;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class PlayerInfoPermissions {

    private PlayerInfoPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "getfromip" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_GETFROMIP = "getfromip.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "getfromip" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_GETFROMIP = "getfromip.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "getfromip" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_GETFROMIP = "getfromip.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "getfromip" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_GETFROMIP = "getfromip.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "getpos" }, level = SuggestedLevel.USER)
    public static final String BASE_GETPOS = "getpos.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "getpos" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_GETPOS = "getpos.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "getpos" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_GETPOS = "getpos.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "getpos" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_GETPOS = "getpos.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.getpos.others", level = SuggestedLevel.MOD)
    public static final String GETPOS_OTHERS = "getpos.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "list" }, level = SuggestedLevel.USER)
    public static final String BASE_LIST = "list.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "list" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_LIST = "list.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "list" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_LIST = "list.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "list" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_LIST = "list.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.list.seevanished", level = SuggestedLevel.ADMIN)
    public static final String LIST_SEEVANISHED = "list.seevanished";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "seen" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SEEN = "seen.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "seen" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_SEEN = "seen.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "seen" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_SEEN = "seen.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "seen" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_SEEN = "seen.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.seen.extended", level = SuggestedLevel.NONE)
    public static final String SEEN_EXTENDED = "seen.extended";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.firstplayed", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_FIRSTPLAYED = "seen.extended.firstplayed";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.flying", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_FLYING = "seen.extended.flying";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.gamemode", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_GAMEMODE = "seen.extended.gamemode";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.ip", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_IP = "seen.extended.ip";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.lastplayed", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_LASTPLAYED = "seen.extended.lastplayed";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.location", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_LOCATION = "seen.extended.location";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.speed", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_SPEED = "seen.extended.speed";

    @PermissionMetadata(descriptionKey = "permission.seen.extendedperms.uuid", level = SuggestedLevel.ADMIN)
    public static final String SEEN_EXTENDEDPERMS_UUID = "seen.extended.uuid";

}
