/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.message;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.internal.userprefs.NucleusKeysProvider;
import io.github.nucleuspowered.nucleus.internal.userprefs.PreferenceKey;
import io.github.nucleuspowered.nucleus.internal.userprefs.PreferenceKey.BooleanKey;
import io.github.nucleuspowered.nucleus.internal.userprefs.UserPrefKeys;
import io.github.nucleuspowered.nucleus.modules.message.commands.MsgToggleCommand;
import io.github.nucleuspowered.nucleus.modules.message.commands.SocialSpyCommand;

public class MessageUserPrefKeys implements UserPrefKeys {

    private static final String SOCIAL_SPY_BASE =
            Nucleus.getNucleus().getPermissionRegistry().getPermissionsForNucleusCommand(SocialSpyCommand.class).getBase();
    private static final String SOCIAL_SPY_FORCE =
            Nucleus.getNucleus().getPermissionRegistry().getPermissionsForNucleusCommand(SocialSpyCommand.class).getPermissionWithSuffix("force");

    public static final PreferenceKey<Boolean> SOCIAL_SPY = new BooleanKey(
            NucleusKeysProvider.SOCIAL_SPY_KEY,
            true,
            user -> user.hasPermission(SOCIAL_SPY_BASE) && !user.hasPermission(SOCIAL_SPY_FORCE),
            "userpref.socialspy"
    );

    public static final PreferenceKey<Boolean> RECEIVING_MESSAGES = new BooleanKey(
            NucleusKeysProvider.MESSAGE_TOGGLE_KEY,
            true,
            Nucleus.getNucleus().getPermissionRegistry().getPermissionsForNucleusCommand(MsgToggleCommand.class).getBase(),
            "userpref.messagetoggle"
    );

}
