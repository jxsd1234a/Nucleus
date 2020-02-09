/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder.standard;

import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import io.github.nucleuspowered.nucleus.services.interfaces.IPlayerDisplayNameService;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.text.Text;

import java.util.function.BiFunction;

public class NamePlaceholder implements PlaceholderParser.RequireSender {

    private static final Text CONSOLE = Text.of("-");
    private final IPlayerDisplayNameService playerDisplayNameService;
    private final boolean consoleFilter;
    private final BiFunction<IPlayerDisplayNameService, CommandSource, Text> parser;

    public NamePlaceholder(IPlayerDisplayNameService playerDisplayNameService, BiFunction<IPlayerDisplayNameService, CommandSource, Text> parser) {
        this(playerDisplayNameService, parser, false);
    }

    public NamePlaceholder(IPlayerDisplayNameService playerDisplayNameService, BiFunction<IPlayerDisplayNameService, CommandSource, Text> parser, boolean consoleFilter) {
        this.playerDisplayNameService = playerDisplayNameService;
        this.parser = parser;
        this.consoleFilter = consoleFilter;
    }

    @Override
    public Text parse(Placeholder.Standard placeholder) {
        if (this.consoleFilter && placeholder.getAssociatedSource().get() instanceof ConsoleSource) {
            return CONSOLE;
        }
        return this.parser.apply(this.playerDisplayNameService, placeholder.getAssociatedSource().get());
    }

}
