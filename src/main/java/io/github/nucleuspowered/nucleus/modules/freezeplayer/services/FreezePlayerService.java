/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.freezeplayer.services;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.api.service.NucleusFreezePlayerService;
import io.github.nucleuspowered.nucleus.internal.annotations.APIService;
import io.github.nucleuspowered.nucleus.internal.interfaces.ServiceBase;
import io.github.nucleuspowered.nucleus.modules.freezeplayer.datamodules.FreezePlayerUserDataModule;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@APIService(NucleusFreezePlayerService.class)
public class FreezePlayerService implements ServiceBase, NucleusFreezePlayerService {

    private final Map<UUID, Boolean> cache = new HashMap<>();

    public void clear() {
        this.cache.clear();
    }

    public void invalidate(UUID uuid) {
        this.cache.remove(uuid);
    }

    @Override
    public boolean isFrozen(UUID uuid) {
        return this.cache.computeIfAbsent(uuid, key ->
                Nucleus.getNucleus().getUserDataManager().getUnchecked(uuid)
                    .get(FreezePlayerUserDataModule.class)
                    .isFrozen());
    }

    @Override
    public void setFrozen(UUID uuid, boolean freeze) {
        FreezePlayerUserDataModule nu = Nucleus.getNucleus().getUserDataManager().getUnchecked(uuid)
                .get(FreezePlayerUserDataModule.class);
        nu.setFrozen(freeze);
        this.cache.put(uuid, freeze);
    }

}
