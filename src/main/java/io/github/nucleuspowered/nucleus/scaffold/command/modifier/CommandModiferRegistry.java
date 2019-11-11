/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.scaffold.command.modifier;

import io.github.nucleuspowered.nucleus.scaffold.command.modifier.impl.CooldownModifier;
import io.github.nucleuspowered.nucleus.scaffold.command.modifier.impl.CostModifier;
import io.github.nucleuspowered.nucleus.scaffold.command.modifier.impl.RequiresEconomyModifier;
import io.github.nucleuspowered.nucleus.scaffold.command.modifier.impl.WarmupModifier;
import io.github.nucleuspowered.nucleus.scaffold.registry.NucleusRegistryModule;
import org.spongepowered.api.util.annotation.NonnullByDefault;

@NonnullByDefault
public class CommandModiferRegistry extends NucleusRegistryModule<CommandModifierFactory> {

    @Override public Class<CommandModifierFactory> catalogClass() {
        return CommandModifierFactory.class;
    }

    @Override public void registerModuleDefaults() {
        registerAdditionalCatalog(new CommandModifierFactory.Simple(new CooldownModifier()));
        registerAdditionalCatalog(new CommandModifierFactory.Simple(new CostModifier()));
        registerAdditionalCatalog(new CommandModifierFactory.Simple(new WarmupModifier()));
        registerAdditionalCatalog(new CommandModifierFactory.Simple(new RequiresEconomyModifier()));
    }
}
