/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.scaffold.command.modifier.impl;

import io.github.nucleuspowered.nucleus.scaffold.command.ICommandContext;
import io.github.nucleuspowered.nucleus.scaffold.command.annotation.CommandModifier;
import io.github.nucleuspowered.nucleus.scaffold.command.config.CommandModifiersConfig;
import io.github.nucleuspowered.nucleus.scaffold.command.control.CommandControl;
import io.github.nucleuspowered.nucleus.scaffold.command.modifier.CommandModifiers;
import io.github.nucleuspowered.nucleus.scaffold.command.modifier.ICommandModifier;
import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import io.github.nucleuspowered.nucleus.services.interfaces.IMessageProviderService;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.time.Duration;
import java.util.Optional;

public class CooldownModifier implements ICommandModifier {

    private static final String COOLDOWN = "cooldown";

    @Override public String getId() {
        return CommandModifiers.HAS_COOLDOWN;
    }

    @Override public String getName() {
        return "Cooldown Modifier";
    }

    @Override public void getDefaultNode(ConfigurationNode node, IMessageProviderService messageProviderService) {
        ConfigurationNode n = node.getNode(COOLDOWN);
        if (n instanceof CommentedConfigurationNode) {
            ((CommentedConfigurationNode) n).setComment(messageProviderService.getMessageString("config.cooldown"));
        }
        n.setValue(0);
    }

    @Override public void setDataFromNode(CommandModifiersConfig config, ConfigurationNode node) {
        config.setCooldown(node.getNode(COOLDOWN).getInt(0));
    }

    @Override public void setValueFromOther(CommandModifiersConfig from, CommandModifiersConfig to) {
        to.setCooldown(from.getCooldown());
    }

    @Override public boolean canExecuteModifier(INucleusServiceCollection serviceCollection, CommandSource source) throws CommandException {
        return source instanceof Player;
    }

    @Override public Optional<Text> testRequirement(ICommandContext.Mutable<? extends CommandSource> source,
            CommandControl control,
            INucleusServiceCollection serviceCollection, CommandModifier modifier) throws CommandException {
        CommandSource c = source.getCommandSource();
        return serviceCollection.cooldownService().getCooldown(control.getModifierKey(), source.getIfPlayer())
                .map(duration -> serviceCollection.messageProvider().getMessageFor(c, "cooldown.message",
                        source.getTimeString(duration.getSeconds())));
    }

    @Override public void onCompletion(ICommandContext<? extends CommandSource> source,
            CommandControl control,
            INucleusServiceCollection serviceCollection, CommandModifier modifier) throws CommandException {
        serviceCollection.cooldownService().setCooldown(control.getModifierKey(), source.getIfPlayer(), Duration.ofSeconds(source.getCooldown()));
    }

}
