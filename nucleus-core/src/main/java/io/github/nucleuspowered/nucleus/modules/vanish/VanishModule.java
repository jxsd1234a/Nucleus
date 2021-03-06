/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.vanish;

import com.google.common.collect.ImmutableMap;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import io.github.nucleuspowered.nucleus.modules.core.CoreModule;
import io.github.nucleuspowered.nucleus.modules.vanish.config.VanishConfig;
import io.github.nucleuspowered.nucleus.modules.vanish.config.VanishConfigAdapter;
import io.github.nucleuspowered.nucleus.modules.vanish.services.VanishService;
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

@ModuleData(id = VanishModule.ID, name = "Vanish", dependencies = CoreModule.ID)
public class VanishModule extends ConfigurableModule<VanishConfig, VanishConfigAdapter> {

    public static final String ID = "vanish";

    @Inject
    public VanishModule(Supplier<DiscoveryModuleHolder<?, ?>> moduleHolder, INucleusServiceCollection collection) {
        super(moduleHolder, collection);
    }

    @Override
    public VanishConfigAdapter createAdapter() {
        return new VanishConfigAdapter();
    }

    @Override
    protected Map<String, PlaceholderParser> tokensToRegister() {
        return ImmutableMap.<String,  PlaceholderParser>builder()
                .put("vanished", new ConditionalParser.PlayerCondition(
                        Text.of(TextColors.GRAY, "[Vanished]"),
                        player -> serviceCollection.getServiceUnchecked(VanishService.class).isVanished(player)
                )).build();
    }

}
