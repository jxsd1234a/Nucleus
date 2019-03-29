/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.staffchat;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.internal.userprefs.NucleusKeysProvider;
import io.github.nucleuspowered.nucleus.internal.userprefs.PreferenceKey;
import io.github.nucleuspowered.nucleus.internal.userprefs.UserPrefKeys;
import io.github.nucleuspowered.nucleus.modules.staffchat.commands.StaffChatCommand;

public class StaffChatUserPrefKeys implements UserPrefKeys {

    // String key, @Nullable Boolean def, String permission, String descriptionKey
    public static final PreferenceKey<Boolean> VIEW_STAFF_CHAT = new PreferenceKey.BooleanKey(
            NucleusKeysProvider.VIEW_STAFF_CHAT_KEY,
            true,
            Nucleus.getNucleus().getPermissionRegistry().getPermissionsForNucleusCommand(StaffChatCommand.class).getBase(),
            "userpref.viewstaffchat"
    );
}
