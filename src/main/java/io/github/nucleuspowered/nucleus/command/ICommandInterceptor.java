/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.command;

import io.github.nucleuspowered.nucleus.command.control.CommandControl;
import org.spongepowered.api.command.CommandSource;

public interface ICommandInterceptor {

    void onPreCommand(Class<? extends ICommandExecutor<?>> commandClass,
            CommandControl commandControl,
            ICommandContext<? extends CommandSource> context);

    void onPostCommand(Class<? extends ICommandExecutor<?>> commandClass,
            CommandControl commandControl,
            ICommandContext<? extends CommandSource> context,
            ICommandResult result);
}
