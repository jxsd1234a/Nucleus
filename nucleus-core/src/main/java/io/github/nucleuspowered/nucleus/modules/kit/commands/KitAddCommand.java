/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.kit.commands;

import io.github.nucleuspowered.nucleus.modules.kit.KitPermissions;
import io.github.nucleuspowered.nucleus.modules.kit.services.KitService;
import io.github.nucleuspowered.nucleus.scaffold.command.ICommandContext;
import io.github.nucleuspowered.nucleus.scaffold.command.ICommandExecutor;
import io.github.nucleuspowered.nucleus.scaffold.command.ICommandResult;
import io.github.nucleuspowered.nucleus.scaffold.command.annotation.Command;
import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.NonnullByDefault;

/**
 * Sets kit items.
 */
@NonnullByDefault
@Command(
        aliases = { "add", "createFromInventory" },
        basePermission = KitPermissions.BASE_KIT_ADD,
        commandDescriptionKey = "kit.add",
        parentCommand = KitCommand.class
)
public class KitAddCommand implements ICommandExecutor<Player> {

    private final String name = "name";
/*
    @Override protected boolean allowFallback(CommandSource source, CommandArgs args, CommandContext context) {
        if (context.hasAny(this.name)) {
            return false;
        }
        return super.allowFallback(source, args, context);
    }
*/

    @Override
    public CommandElement[] parameters(INucleusServiceCollection serviceCollection) {
        return new CommandElement[] {
                GenericArguments.onlyOne(GenericArguments.string(Text.of(this.name)))
        };
    }

    @Override
    public ICommandResult execute(ICommandContext<? extends Player> context) throws CommandException {
        String kitName = context.requireOne(this.name, String.class);

        KitService service = context.getServiceCollection().getServiceUnchecked(KitService.class);
        if (service.getKitNames().stream().noneMatch(kitName::equalsIgnoreCase)) {
            service.saveKit(service.createKit(kitName).updateKitInventory(context.getCommandSourceAsPlayerUnchecked()));
            context.sendMessage("command.kit.add.success", kitName);
            return context.successResult();
        } else {
            return context.errorResult("command.kit.add.alreadyexists", kitName);
        }
    }
}
