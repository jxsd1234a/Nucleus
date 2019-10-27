/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.core.commands.nucleus;

import io.github.nucleuspowered.nucleus.command.ICommandContext;
import io.github.nucleuspowered.nucleus.command.ICommandExecutor;
import io.github.nucleuspowered.nucleus.command.ICommandResult;
import io.github.nucleuspowered.nucleus.command.annotation.Command;
import io.github.nucleuspowered.nucleus.modules.core.CorePermissions;
import io.github.nucleuspowered.nucleus.modules.core.commands.NucleusCommand;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.util.annotation.NonnullByDefault;

@NonnullByDefault
@Command(
        aliases = "save",
        basePermission = CorePermissions.BASE_NUCLEUS_SAVE,
        commandDescriptionKey = "nucleus.save",
        parentCommand = NucleusCommand.class,
        async = true
)
public class SaveCommand implements ICommandExecutor<CommandSource> {

    @Override
    public ICommandResult execute(ICommandContext<? extends CommandSource> context) {
        context.sendMessage("command.nucleus.save.start");
        context.getServiceCollection().storageManager().saveAll().join();
        context.sendMessage("command.nucleus.save.complete");
        return context.successResult();
    }
}
