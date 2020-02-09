/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.jail;

import com.google.common.collect.ImmutableMap;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import io.github.nucleuspowered.nucleus.modules.jail.config.JailConfig;
import io.github.nucleuspowered.nucleus.modules.jail.config.JailConfigAdapter;
import io.github.nucleuspowered.nucleus.modules.jail.services.JailHandler;
import io.github.nucleuspowered.nucleus.quickstart.module.ConfigurableModule;
import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import io.github.nucleuspowered.nucleus.services.impl.placeholder.parser.ConditionalParser;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import uk.co.drnaylor.quickstart.annotations.ModuleData;
import uk.co.drnaylor.quickstart.holders.DiscoveryModuleHolder;

import java.util.Map;
import java.util.function.Supplier;

import javax.inject.Inject;

@ModuleData(id = JailModule.ID, name = "Jail")
public class JailModule extends ConfigurableModule<JailConfig, JailConfigAdapter> {

    public static final String LEVEL_KEY = "nucleus.jail.key";
    public static final String ID = "jail";

    @Inject
    public JailModule(Supplier<DiscoveryModuleHolder<?, ?>> moduleHolder, INucleusServiceCollection collection) {
        super(moduleHolder, collection);
    }

    @Override
    public JailConfigAdapter createAdapter() {
        return new JailConfigAdapter();
    }

    @Override
    protected Map<String, PlaceholderParser> tokensToRegister() {
        return ImmutableMap.<String, PlaceholderParser>builder()
                .put("jailed", new ConditionalParser.PlayerCondition(Text.of(TextColors.GRAY, "[Jailed]"),
                        player -> serviceCollection.getServiceUnchecked(JailHandler.class).isPlayerJailed(player)))
                .put("jail", placeholder -> {
                    if (placeholder.getAssociatedSource().filter(x -> x instanceof Player).isPresent()) {
                        return serviceCollection.getServiceUnchecked(JailHandler.class)
                                .getPlayerJailData((Player) placeholder.getAssociatedSource().get())
                                .<Text>map(x -> Text.of(x.getJailName()))
                                .orElse(Text.EMPTY);
                    }

                    return Text.EMPTY;
                })
                .build();
    }
}
