/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.back.datamodules;

import com.flowpowered.math.vector.Vector3d;
import io.github.nucleuspowered.nucleus.dataservices.modular.ModularUserService;
import io.github.nucleuspowered.nucleus.dataservices.modular.TransientModule;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.world.World;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

public class BackUserTransientModule extends TransientModule<ModularUserService> {

    @Nullable
    private Vector3d lastPosition;

    @Nullable
    private Vector3d lastRotation;

    @Nullable
    private UUID lastWorld;

    private boolean logLastLocation = true;

    public Optional<Transform<World>> getLastLocation() {
        if (this.lastWorld == null || this.lastRotation == null || this.lastPosition == null) {
            return Optional.empty();
        }

        return Sponge.getServer().getWorld(this.lastWorld)
                .map(world -> new Transform<>(world, this.lastPosition, this.lastRotation));
    }

    public void setLastLocation(@Nullable Transform<World> location) {
        if (location == null) {
            this.lastWorld = null;
            this.lastPosition =  null;
            this.lastRotation = null;
        } else {
            this.lastWorld = location.getExtent().getUniqueId();
            this.lastPosition = location.getPosition();
            this.lastRotation = location.getRotation();
        }
    }

    public boolean isLogLastLocation() {
        return this.logLastLocation;
    }

    public void setLogLastLocation(boolean logLastLocation) {
        this.logLastLocation = logLastLocation;
    }
}
