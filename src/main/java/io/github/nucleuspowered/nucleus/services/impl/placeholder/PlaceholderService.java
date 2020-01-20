/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder;

import io.github.nucleuspowered.nucleus.Util;
import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import io.github.nucleuspowered.nucleus.modules.core.services.UniqueUserService;
import io.github.nucleuspowered.nucleus.services.IInitService;
import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import io.github.nucleuspowered.nucleus.services.impl.placeholder.standard.NamePlaceholder;
import io.github.nucleuspowered.nucleus.services.impl.placeholder.standard.OptionAliasPlaceholder;
import io.github.nucleuspowered.nucleus.services.interfaces.IPermissionService;
import io.github.nucleuspowered.nucleus.services.interfaces.IPlaceholderService;
import io.github.nucleuspowered.nucleus.services.interfaces.IPlayerDisplayNameService;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.RemoteSource;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlaceholderService implements IPlaceholderService, IInitService {

    private static final Pattern SUFFIX_PATTERN = Pattern.compile(":([sp]+)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern SEPARATOR = Pattern.compile("[\\s|:_]]");
    private final Map<String, PlaceholderMetadata> parsers = new HashMap<>();
    private final PluginContainer pluginContainer;

    @Inject
    public PlaceholderService(INucleusServiceCollection serviceCollection) {
        this.pluginContainer = serviceCollection.pluginContainer();
    }

    @Override
    public void init(final INucleusServiceCollection serviceCollection) {
        // player, variables, map?
        PluginContainer pluginContainer = serviceCollection.pluginContainer();
        NamePlaceholder normalName = new NamePlaceholder(
                serviceCollection.playerDisplayNameService(),
                IPlayerDisplayNameService::addCommandToName);
        registerToken(pluginContainer, "name", normalName);
        registerToken(pluginContainer, "playername", normalName);
        registerToken(pluginContainer, "subject", new NamePlaceholder(
                serviceCollection.playerDisplayNameService(),
                IPlayerDisplayNameService::addCommandToName,
                true));

        NamePlaceholder displayName = new NamePlaceholder(
                serviceCollection.playerDisplayNameService(),
                IPlayerDisplayNameService::addCommandToName);
        registerToken(pluginContainer, "player", displayName);
        registerToken(pluginContainer, "playerdisplayname", displayName);
        registerToken(pluginContainer, "displayname", displayName);

        IPermissionService permissionService = serviceCollection.permissionService();
        registerToken(pluginContainer, "prefix", new OptionAliasPlaceholder(permissionService, "prefix"));
        registerToken(pluginContainer, "suffix", new OptionAliasPlaceholder(permissionService, "suffix"));

        registerToken(pluginContainer, "maxplayers", p -> Text.of(Sponge.getServer().getMaxPlayers()));
        registerToken(pluginContainer, "onlineplayers", p -> Text.of(Sponge.getServer().getOnlinePlayers().size()));
        registerToken(pluginContainer, "currentworld", placeholder -> Text.of(getWorld(placeholder)));
        registerToken(pluginContainer, "time", placeholder ->
                Text.of(Util.getTimeFromTicks(serviceCollection.messageProvider(), getWorld(placeholder).getProperties().getWorldTime())));

        registerToken(pluginContainer, "uniquevisitor",
                placeholder -> Text.of(serviceCollection.getServiceUnchecked(UniqueUserService.class).getUniqueUserCount()));
        registerToken(pluginContainer, "ipaddress",
                placeholder -> placeholder.getAssociatedSource().filter(x -> x instanceof RemoteSource)
                        .map(x -> Text.of(((RemoteSource) x).getConnection().getAddress().getAddress().toString()))
                        .orElse(Text.of("localhost")));

        // register the builders.
        Sponge.getRegistry().registerBuilderSupplier(Placeholder.StandardBuilder.class, () -> new NucleusPlaceholderStandardBuilder(this));
        Sponge.getRegistry().registerBuilderSupplier(Placeholder.OptionBuilder.class, NucleusOptionPlaceholderBuilder::new);
    }

    @Override
    public TextRepresentable parse(@Nullable CommandSource commandSource, String input) {
        String token = input.toLowerCase().trim().replace("{{", "").replace("}}", "");
        Matcher m = SUFFIX_PATTERN.matcher(token);
        Text appendSpace = Text.EMPTY;
        Text prependSpace = Text.EMPTY;
        if (m.find(0)) {
            String match = m.group(1).toLowerCase();
            if (match.contains("s")) {
                appendSpace = Util.SPACE;
            }
            if (match.contains("p")) {
                prependSpace = Util.SPACE;
            }

            token = token.replaceAll(SUFFIX_PATTERN.pattern(), "");
        }

        Placeholder.Builder<? extends Placeholder, ?> builder;
        if (token.startsWith("o:")) {
            if (commandSource == null) {
                return Text.EMPTY;
            }
            // option
            builder = new NucleusOptionPlaceholderBuilder()
                    .setOptionKey(token.substring(2))
                    .setSubject(commandSource)
                    .setTextSerializer(TextSerializers.FORMATTING_CODE);
        } else {
            String[] s = token.split("\\|", 2);
            String tokenIn = s[0].toLowerCase();
            Placeholder.StandardBuilder b = new NucleusPlaceholderStandardBuilder(this)
                    .setToken(tokenIn)
                    .setAssociatedSource(commandSource);
            if (s.length == 2) {
                b.setArgument(s[1]);
            }

            builder = b;
        }

        return builder
                .setPrependingTextIfNotEmpty(prependSpace)
                .setAppendingTextIfNotEmpty(appendSpace)
                .build();
    }

    @Override
    public void registerToken(PluginContainer pluginContainer, String tokenName, PlaceholderParser parser) {
        if (SEPARATOR.asPredicate().test(tokenName)) {
            // can't be registered.
            throw new IllegalArgumentException("Tokens must not contain |, :, _ or space characters.");
        }
        String token = tokenName.toLowerCase();
        if (!this.parsers.containsKey(token)) {
            this.parsers.put(token, new PlaceholderMetadata(token, pluginContainer, parser));
        } else {
            throw new IllegalStateException("Token " + tokenName.toLowerCase() + " has already been registered.");
        }
    }

    @Override
    public Optional<PlaceholderParser> getParser(String token) {
        PlaceholderMetadata placeholderMetadata = this.parsers.get(SEPARATOR.split(token.toLowerCase(), 2)[0]);
        if (placeholderMetadata == null) {
            return Optional.empty();
        }
        return Optional.of(placeholderMetadata.getParser());
    }

    @Override
    public Optional<PluginContainer> getOwner(String token) {
        PlaceholderMetadata placeholderMetadata = this.parsers.get(SEPARATOR.split(token.toLowerCase(), 2)[0]);
        if (placeholderMetadata == null) {
            return Optional.empty();
        }
        return Optional.of(placeholderMetadata.getPluginContainer());
    }

    @Nullable
    PlaceholderMetadata getMetadata(String token) {
        PlaceholderMetadata m = this.parsers.get(token);
        if (m == null) {
            throw new NoSuchElementException("Parser does not exist.");
        }

        return m;
    }

    // --

    private static World getWorld(Placeholder.Standard placeholder) {
        CommandSource p = placeholder.getAssociatedSource().orElseGet(Sponge.getServer()::getConsole);
        World world;
        if (p instanceof Locatable) {
            world = ((Locatable) p).getWorld();
        } else {
            world = Sponge.getServer().getWorld(Sponge.getServer().getDefaultWorldName()).get();
        }

        return world;
    }

    @Override
    public Collection<PlaceholderMetadata> getNucleusParsers() {
        return this.parsers.values().stream().filter(x -> x.getPluginContainer().equals(this.pluginContainer)).collect(Collectors.toList());
    }
}
