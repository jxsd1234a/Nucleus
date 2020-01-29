/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.storage.dataobjects.standard;

import com.google.common.collect.ImmutableMap;
import io.github.nucleuspowered.nucleus.api.module.kit.data.Kit;
import io.github.nucleuspowered.nucleus.modules.kit.serialiser.SingleKitTypeSerilaiser;
import io.github.nucleuspowered.nucleus.services.impl.storage.dataobjects.configurate.AbstractConfigurateBackedDataObject;
import ninja.leaping.configurate.ConfigurationNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KitDataObject extends AbstractConfigurateBackedDataObject implements IKitDataObject {

    private ImmutableMap<String, Kit> cached;

    @Override
    public ImmutableMap<String, Kit> getKitMap() {
        if (this.cached == null) {
            try {
                Map<String, Kit> map = SingleKitTypeSerilaiser.INSTANCE.deserialize(this.backingNode);
                if (map == null) {
                    this.cached = ImmutableMap.of();
                } else {
                    this.cached = ImmutableMap.copyOf(map);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ImmutableMap.of();
            }
        }
        return this.cached;
    }

    @Override
    public void setKitMap(Map<String, Kit> map) throws Exception {
        SingleKitTypeSerilaiser.INSTANCE.serialize(map, this.backingNode);
        this.cached = ImmutableMap.copyOf(map);
    }

    @Override
    public boolean hasKit(String name) {
        return this.getKitMap().containsKey(name.toLowerCase());
    }

    @Override
    public Optional<Kit> getKit(String name) {
        return Optional.ofNullable(this.getKitMap().get(name.toLowerCase()));
    }

    @Override
    public void setKit(Kit kit) throws Exception {
        Map<String, Kit> m = new HashMap<>(getKitMap());
        m.put(kit.getName().toLowerCase(), kit);
        setKitMap(m);
    }

    @Override
    public boolean removeKit(String name) throws Exception {
        Map<String, Kit> m = new HashMap<>(getKitMap());
        boolean b = m.remove(name.toLowerCase()) != null;
        setKitMap(m);
        return b;
    }

    @Override
    public void setBackingNode(ConfigurationNode node) {
        super.setBackingNode(node);
        this.cached = null;
    }

}
