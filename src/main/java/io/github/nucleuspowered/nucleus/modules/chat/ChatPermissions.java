/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.chat;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class ChatPermissions {
    private ChatPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.chat.color", level = SuggestedLevel.ADMIN, isPrefix = true)
    public static final String CHAT_COLOR = "chat.color";

    @PermissionMetadata(descriptionKey = "permission.chat.magic", level = SuggestedLevel.ADMIN)
    public static final String CHAT_MAGIC = "chat.magic";

    @PermissionMetadata(descriptionKey = "permission.chat.style", level = SuggestedLevel.ADMIN, isPrefix = true)
    public static final String CHAT_STYLE = "chat.style";

    @PermissionMetadata(descriptionKey = "permission.chat.urls", level = SuggestedLevel.ADMIN)
    public static final String CHAT_URLS = "chat.url";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "me" }, level = SuggestedLevel.USER)
    public static final String BASE_ME = "me.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "me" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_ME = "me.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "me" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_ME = "me.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "me" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_ME = "me.exempt.warmup";

}
