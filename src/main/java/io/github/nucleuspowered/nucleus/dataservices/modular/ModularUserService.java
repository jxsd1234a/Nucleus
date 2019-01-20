/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.dataservices.modular;

import io.github.nucleuspowered.nucleus.dataservices.dataproviders.DataProvider;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.user.UserStorageService;

import java.util.Optional;
import java.util.UUID;

public class ModularUserService extends ModularDataService<ModularUserService> {

    private static UserStorageService uss = null;

    private final UUID uuid;
    private static final ConfigurationTransformation TRANSFORMER =
            ConfigurationTransformation.chain(
                    ConfigurationTransformation.builder().addAction(new Object[] { "tptoggle" },
                            (inputPath, valueAtPath) -> new Object[] { "user-prefs", "nucleus:teleport-targetable" }).build(),
                    ConfigurationTransformation.builder().addAction(new Object[] { "powertoolToggle" },
                            (inputPath, valueAtPath) -> new Object[] { "user-prefs", "nucleus:powertool-toggle" }).build(),
                    ConfigurationTransformation.builder().addAction(new Object[] { "socialspy" },
                            (inputPath, valueAtPath) -> new Object[] { "user-prefs", "nucleus:social-spy" }).build(),
                    ConfigurationTransformation.builder().addAction(new Object[] { "msgtoggle" },
                            (inputPath, valueAtPath) -> new Object[] { "user-prefs", "nucleus:message-receiving-enabled" }).build(),
                    ConfigurationTransformation.builder().addAction(new Object[] { "isCommandSpy" },
                            (inputPath, valueAtPath) -> new Object[] { "user-prefs", "nucleus:command-spy" }).build()
            );

    public ModularUserService(DataProvider<ConfigurationNode> provider, UUID uuid) throws Exception {
        super(provider);
        this.uuid = uuid;
    }

    public UUID getUniqueId() {
        return this.uuid;
    }

    public User getUser() {
        if (uss == null) {
            uss = Sponge.getServiceManager().provideUnchecked(UserStorageService.class);
        }

        Optional<Player> p = getPlayer();
        return p.map(x -> (User) x).orElseGet(() -> uss.get(this.uuid).orElseGet(() -> uss.getOrCreate(GameProfile.of(this.uuid, null))));

    }

    public Optional<Player> getPlayer() {
        return Sponge.getServer().getPlayer(this.uuid);
    }

    @Override protected String serviceName() {
        return "Nucleus Data for user " + this.uuid.toString() + " (" + getUser().getName() + ")";
    }

    @Override <T extends TransientModule<ModularUserService>> Optional<T> tryGetTransient(Class<T> module) {
        return DataModuleFactory.getTransient(module, this);
    }

    @Override <T extends DataModule<ModularUserService>> Optional<T> tryGet(Class<T> module) {
        return DataModuleFactory.get(module, this);
    }

    @Override public void migrate() {
        super.migrate();
        TRANSFORMER.apply(this.data);
    }
}
