/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.misc;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class MiscPermissions {
    private MiscPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "blockinfo" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_BLOCKINFO = "blockinfo.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "blockinfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_BLOCKINFO = "blockinfo.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "blockinfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_BLOCKINFO = "blockinfo.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "blockinfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_BLOCKINFO = "blockinfo.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.blockinfo.extended", level = SuggestedLevel.ADMIN)
    public static final String BLOCKINFO_EXTENDED = "blockinfo.extended";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "entityinfo" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_ENTITYINFO = "entityinfo.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "entityinfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_ENTITYINFO = "entityinfo.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "entityinfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_ENTITYINFO = "entityinfo.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "entityinfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_ENTITYINFO = "entityinfo.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.entityinfo.extended", level = SuggestedLevel.ADMIN)
    public static final String ENTITYINFO_EXTENDED = "entityinfo.extended";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "extinguish" }, level = SuggestedLevel.MOD)
    public static final String BASE_EXTINGUISH = "extinguish.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "extinguish" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_EXTINGUISH = "extinguish.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "extinguish" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_EXTINGUISH = "extinguish.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "extinguish" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_EXTINGUISH = "extinguish.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "extinguish" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_EXTINGUISH = "extinguish.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "feed" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_FEED = "feed.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "feed" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_FEED = "feed.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "feed" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_FEED = "feed.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "feed" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_FEED = "feed.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "feed" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_FEED = "feed.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "heal" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_HEAL = "heal.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "heal" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_HEAL = "heal.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "heal" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_HEAL = "heal.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "heal" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_HEAL = "heal.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "heal" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_HEAL = "heal.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "iteminfo" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_ITEMINFO = "iteminfo.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "iteminfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_ITEMINFO = "iteminfo.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "iteminfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_ITEMINFO = "iteminfo.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "iteminfo" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_ITEMINFO = "iteminfo.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.iteminfo.extended", level = SuggestedLevel.ADMIN)
    public static final String ITEMINFO_EXTENDED = "iteminfo.extended";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "ping" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_PING = "ping.base";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "ping" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_PING = "ping.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "serverstat" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SERVERSTAT = "serverstat.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "servertime" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SERVERTIME = "servertime.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "speed" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_SPEED = "speed.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "speed" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_SPEED = "speed.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "speed" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_SPEED = "speed.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.speed.exempt.max", level = SuggestedLevel.OWNER)
    public static final String SPEED_EXEMPT_MAX = "speed.exempt.max";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "speed" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_SPEED = "speed.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "speed" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_SPEED = "speed.others";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "suicide" }, level = SuggestedLevel.USER)
    public static final String BASE_SUICIDE = "suicide.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "suicide" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_SUICIDE = "suicide.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "suicide" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_SUICIDE = "suicide.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "suicide" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_SUICIDE = "suicide.exempt.warmup";

}
