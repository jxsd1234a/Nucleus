/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.playerinfo.commands;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.internal.annotations.command.Permissions;
import io.github.nucleuspowered.nucleus.internal.annotations.command.RegisterCommand;
import io.github.nucleuspowered.nucleus.internal.command.AbstractCommand;
import io.github.nucleuspowered.nucleus.internal.command.NucleusParameters;
import io.github.nucleuspowered.nucleus.internal.command.ReturnMessageException;
import io.github.nucleuspowered.nucleus.internal.docgen.annotations.EssentialsEquivalent;
import io.github.nucleuspowered.nucleus.internal.interfaces.Reloadable;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionInformation;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;
import io.github.nucleuspowered.nucleus.internal.services.PlayerOnlineService;
import io.github.nucleuspowered.nucleus.modules.core.datamodules.CoreUserDataModule;
import io.github.nucleuspowered.nucleus.modules.playerinfo.config.PlayerInfoConfigAdapter;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.*;
import java.util.stream.Collectors;

@Permissions(suggestedLevel = SuggestedLevel.USER, supportsOthers = true)
@RegisterCommand("near")
@EssentialsEquivalent("near")
@NonnullByDefault
public class NearCommand extends AbstractCommand<CommandSource> implements Reloadable {

    private final String radiusKey = "radius";
    private int maxRadius;

    @Override
    protected Map<String, PermissionInformation> permissionSuffixesToRegister() {
        final Map<String, PermissionInformation> pi = super.permissionSuffixesToRegister();
        pi.put("maxexempt", PermissionInformation.getWithTranslation("permission.near.maxexempt", SuggestedLevel.MOD));
        return pi;
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[] {
                GenericArguments.optionalWeak(requirePermissionArg(GenericArguments.user(Text.of(NucleusParameters.ONE_USER_PLAYER_KEY)), this.permissions.getOthers())),
                GenericArguments.optionalWeak(GenericArguments.integer(Text.of(this.radiusKey)))
        };
    }

    //near radius
    //near player radius
    @Override
    protected CommandResult executeCommand(CommandSource src, CommandContext args, Cause cause) throws Exception {
        final User user = this.getUserFromArgs(User.class, src, NucleusParameters.Keys.PLAYER, args);
        final Location<World> location;
        if (user.isOnline()) {
            location = user.getPlayer().get().getLocation();
        } else {
            location = Nucleus.getNucleus().getUserDataManager().get(user).flatMap(x -> x.get(CoreUserDataModule.class).getLogoutLocation()).orElseThrow(() -> ReturnMessageException.fromKey("command.near.location.nolocation", user.getName()));
        }

        int radius = maxRadius;
        final Optional<Integer> radiusOpt = args.getOne(radiusKey);
        if(radiusOpt.isPresent()) {
            int inputRadius = radiusOpt.get();
            //Check if executer has max radius override permission
            if (inputRadius > maxRadius && this.permissions.testSuffix(src, "maxexempt")) {
                radius = inputRadius;
            } else {
                src.sendMessage(Nucleus.getNucleus().getMessageProvider().getTextMessageWithFormat("command.near.radiustoobig", this.maxRadius));
            }
        }

        final PlayerOnlineService playerOnlineService = getServiceManager().getServiceUnchecked(PlayerOnlineService.class);
        final List<Player> nearbyPlayers = location.getExtent().getNearbyEntities(location.getPosition(), radius).stream()
                .filter(Player.class::isInstance)
                .map(Player.class::cast)
                .filter(e -> e.getUniqueId() != user.getUniqueId() && playerOnlineService.isOnline(src, e))
                .sorted((o1, o2) -> (int) o1.getLocation().getPosition().distanceSquared(o2.getPosition()))//Sort by distance
                .collect(Collectors.toList());

        final PaginationList.Builder listBuilder = PaginationList.builder().title(Nucleus.getNucleus().getMessageProvider().getTextMessageWithFormat("command.near.playersnear", user.getName()));
        final List<Text> messages = new ArrayList<>(nearbyPlayers.size());
        nearbyPlayers.forEach(nearbyPlayer -> {
            Text.Builder line = Text.builder();
            line.append(Nucleus.getNucleus().getMessageProvider().getTextMessageWithFormat("command.near.playerdistancefrom", nearbyPlayer.getName(), (int)Math.abs(nearbyPlayer.getLocation().getPosition().distance(location.getPosition()))))
            .onClick(TextActions.runCommand("/tp "+nearbyPlayer.getName()))
            .onHover(TextActions.showText(Nucleus.getNucleus().getMessageProvider().getTextMessageWithFormat("command.near.tpto", nearbyPlayer.getName())));
            messages.add(line.build());
        });
        listBuilder.contents(messages).sendTo(src);

        return CommandResult.success();
    }

    @Override
    public void onReload() {
        PlayerInfoConfigAdapter configAdapter = getServiceUnchecked(PlayerInfoConfigAdapter.class);
        this.maxRadius = configAdapter.getNodeOrDefault().getNear().getMaxRadius();
    }

}
