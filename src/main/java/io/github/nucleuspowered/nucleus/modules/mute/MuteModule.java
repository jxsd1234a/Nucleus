/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.mute;

import com.google.common.collect.ImmutableMap;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import io.github.nucleuspowered.nucleus.modules.mute.config.MuteConfig;
import io.github.nucleuspowered.nucleus.modules.mute.config.MuteConfigAdapter;
import io.github.nucleuspowered.nucleus.modules.mute.services.MuteHandler;
import io.github.nucleuspowered.nucleus.quickstart.module.ConfigurableModule;
import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import io.github.nucleuspowered.nucleus.services.impl.placeholder.parser.ConditionalParser;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import uk.co.drnaylor.quickstart.annotations.ModuleData;
import uk.co.drnaylor.quickstart.holders.DiscoveryModuleHolder;

import java.util.Map;
import java.util.function.Supplier;

import javax.inject.Inject;

@ModuleData(id = MuteModule.ID, name = "Mute")
public class MuteModule extends ConfigurableModule<MuteConfig, MuteConfigAdapter> {

    public static final String LEVEL_KEY = "nucleus.mute.level";
    public static final String ID = "mute";

    @Inject
    public MuteModule(Supplier<DiscoveryModuleHolder<?, ?>> moduleHolder, INucleusServiceCollection collection) {
        super(moduleHolder, collection);
    }

    @Override
    public MuteConfigAdapter createAdapter() {
        return new MuteConfigAdapter();
    }

    @Override protected Map<String, PlaceholderParser> tokensToRegister() {
        return ImmutableMap.<String, PlaceholderParser>builder()
                .put("muted", new ConditionalParser.PlayerCondition(
                        Text.of(TextColors.GRAY, "[Muted]"),
                        player -> serviceCollection.getServiceUnchecked(MuteHandler.class).isMuted(player)
                ))
                .build();
    }
}
