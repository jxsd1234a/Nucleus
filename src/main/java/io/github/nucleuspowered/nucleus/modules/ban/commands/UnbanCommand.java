/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.ban.commands;

import io.github.nucleuspowered.nucleus.Util;
import io.github.nucleuspowered.nucleus.modules.ban.BanPermissions;
import io.github.nucleuspowered.nucleus.scaffold.command.ICommandContext;
import io.github.nucleuspowered.nucleus.scaffold.command.ICommandExecutor;
import io.github.nucleuspowered.nucleus.scaffold.command.ICommandResult;
import io.github.nucleuspowered.nucleus.scaffold.command.NucleusParameters;
import io.github.nucleuspowered.nucleus.scaffold.command.annotation.Command;
import io.github.nucleuspowered.nucleus.scaffold.command.annotation.EssentialsEquivalent;
import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.text.channel.MutableMessageChannel;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.api.util.ban.Ban;

import java.util.Optional;

@Command(
        aliases = {"unban", "pardon"},
        basePermission = BanPermissions.BASE_TEMPBAN,
        commandDescriptionKey = "unban"
)
@EssentialsEquivalent({"unban", "pardon"})
@NonnullByDefault
public class UnbanCommand implements ICommandExecutor<CommandSource> {

    @Override
    public CommandElement[] parameters(INucleusServiceCollection serviceCollection) {
        return new CommandElement[] {
            GenericArguments.firstParsing(
                    NucleusParameters.ONE_GAME_PROFILE_UUID.get(serviceCollection),
                    NucleusParameters.ONE_GAME_PROFILE.get(serviceCollection)
            )
        };
    }

    @Override
    public ICommandResult execute(ICommandContext<? extends CommandSource> context) throws CommandException {
        GameProfile gp;
        if (context.hasAny(NucleusParameters.Keys.USER_UUID)) {
            gp = context.requireOne(NucleusParameters.Keys.USER_UUID, GameProfile.class);
        } else {
            gp = context.requireOne(NucleusParameters.Keys.USER, GameProfile.class);
        }

        BanService service = Sponge.getServiceManager().provideUnchecked(BanService.class);

        Optional<Ban.Profile> obp = service.getBanFor(gp);
        if (!obp.isPresent()) {
            return context.errorResult(
                    "command.checkban.notset", Util.getNameOrUnkown(context, gp));
        }

        service.removeBan(obp.get());

        MutableMessageChannel notify = context.getServiceCollection().permissionService().permissionMessageChannel(BanPermissions.BAN_NOTIFY).asMutable();
        notify.addMember(context.getCommandSource());
        for (MessageReceiver receiver : notify.getMembers()) {
            context.sendMessageTo(receiver, "command.unban.success", Util.getNameOrUnkown(context, obp.get().getProfile()));
        }
        return context.successResult();
    }
}
