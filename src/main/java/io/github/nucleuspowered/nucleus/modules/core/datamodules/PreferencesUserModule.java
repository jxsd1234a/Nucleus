/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.core.datamodules;

import io.github.nucleuspowered.nucleus.dataservices.modular.DataKey;
import io.github.nucleuspowered.nucleus.dataservices.modular.DataModule;
import io.github.nucleuspowered.nucleus.dataservices.modular.ModularUserService;
import ninja.leaping.configurate.ConfigurationNode;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

// TODO: change to key with new storage system
public class PreferencesUserModule extends DataModule<ModularUserService> {

    @DataKey("user-prefs")
    private Map<String, Object> prefs = new HashMap<>();

    public void set(String key, Object value) {
        this.prefs.put(key, value);
    }

    @Nullable public Object get(String key) {
        return this.prefs.get(key);
    }

    public void remove(String key) {
        this.prefs.remove(key);
    }

    @Override protected void saveTo(ConfigurationNode node) {
        this.prefs.forEach((key, value) -> node.getNode("user-prefs", key).setValue(value));
    }

    @Override protected void loadFrom(ConfigurationNode node) {
        this.prefs.clear();
        node.getNode("user-prefs").getChildrenMap().forEach((key, n) -> {
            this.prefs.put(String.valueOf(key), n.getValue());
        });
    }
}
