/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.commandelement;

import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

public class LocaleElement extends CommandElement {

    private final INucleusServiceCollection serviceCollection;

    public LocaleElement(Text key, INucleusServiceCollection serviceCollection) {
        super(key);
        this.serviceCollection = serviceCollection;
    }

    @Nullable
    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        String s = args.next();
        return this.serviceCollection.messageProvider().getLocaleFromName(s).orElseGet(() -> Locale.forLanguageTag(s.replace("_", "-")));
    }

    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        List<String> l = this.serviceCollection.messageProvider().getAllLocaleNames();
        try {
            String a = args.peek().toLowerCase();
            return l.stream()
                    .filter(x -> x.toLowerCase().startsWith(a))
                    .collect(Collectors.toList());
        } catch (ArgumentParseException e) {
            return l;
        }
    }
}
