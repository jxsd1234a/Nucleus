/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.back.commands;

import com.google.inject.Inject;
import io.github.nucleuspowered.nucleus.Util;
import io.github.nucleuspowered.nucleus.internal.annotations.Permissions;
import io.github.nucleuspowered.nucleus.internal.annotations.RegisterCommand;
import io.github.nucleuspowered.nucleus.internal.command.CommandBase;
import io.github.nucleuspowered.nucleus.modules.back.handlers.BackHandler;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.World;

import java.util.Optional;

@Permissions
@RegisterCommand({"back", "return"})
public class BackCommand extends CommandBase<Player> {

    @Inject private BackHandler handler;

    @Override
    @SuppressWarnings("deprecation")
    public CommandResult executeCommand(Player src, CommandContext args) throws Exception {
        Optional<Transform<World>> ol = handler.getLastLocation(src);
        if (!ol.isPresent()) {
            src.sendMessage(Util.getTextMessageWithFormat("command.back.noloc"));
            return CommandResult.empty();
        }

        Transform<World> currentLocation = src.getTransform();

        Transform<World> loc = ol.get();
        if (src.setLocationAndRotationSafely(loc.getLocation(), loc.getRotation())) {
            handler.setLastLocationInternal(src, currentLocation);
            src.sendMessage(Util.getTextMessageWithFormat("command.back.success"));
            return CommandResult.success();
        } else {
            src.sendMessage(Util.getTextMessageWithFormat("command.back.nosafe"));
            return CommandResult.empty();
        }
    }
}
