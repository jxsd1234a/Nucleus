/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.kit.events;

import com.google.common.collect.ImmutableList;
import io.github.nucleuspowered.nucleus.api.events.NucleusKitEvent;
import io.github.nucleuspowered.nucleus.api.exceptions.KitRedeemException;
import io.github.nucleuspowered.nucleus.api.nucleusdata.Kit;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.impl.AbstractEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nullable;

@NonnullByDefault
public abstract class KitEvent extends AbstractEvent implements NucleusKitEvent {

    public static abstract class Redeem extends KitEvent implements NucleusKitEvent.Redeem {

        private final Cause cause;
        private final Kit kit;
        @Nullable private final Instant lastTime;
        private final Player targetPlayer;
        private final Collection<ItemStackSnapshot> original;

        public Redeem(Cause cause, @Nullable Instant lastTime, Kit kit, Player targetPlayer, Collection<ItemStackSnapshot> original) {
            this.cause = cause;
            this.kit = kit;
            this.targetPlayer = targetPlayer;
            this.lastTime = lastTime;
            this.original = original;
        }

        @Override public Optional<Instant> getLastRedeemedTime() {
            return Optional.ofNullable(this.lastTime);
        }

        @Override public String getName() {
            return this.kit.getName();
        }

        @Override public Kit getRedeemedKit() {
            return this.kit;
        }

        @Override public Collection<ItemStackSnapshot> getOriginalStacksToRedeem() {
            return this.original;
        }

        @Override public Player getTargetEntity() {
            return this.targetPlayer;
        }

        @Override public Cause getCause() {
            return this.cause;
        }
    }

    public static class PreRedeem extends Redeem implements NucleusKitEvent.Redeem.Pre {

        @Nullable private Text cancelMessage = null;
        private boolean isCancelled;
        @Nullable private Collection<ItemStackSnapshot> toRedeem = null;

        public PreRedeem(Cause cause, @Nullable Instant lastTime, Kit kit, Player targetPlayer, Collection<ItemStackSnapshot> original) {
            super(cause, lastTime, kit, targetPlayer, original);
        }

        @Override public boolean isCancelled() {
            return this.isCancelled;
        }

        @Override public void setCancelled(boolean cancel) {
            this.isCancelled = cancel;
        }

        @Override public Optional<Text> getCancelMessage() {
            return Optional.ofNullable(this.cancelMessage);
        }

        @Override public void setCancelMessage(@Nullable Text message) {
            this.cancelMessage = message;
        }

        @Override public Optional<Collection<ItemStackSnapshot>> getStacksToRedeem() {
            return Optional.ofNullable(this.toRedeem);
        }

        @Override public void setStacksToRedeem(@Nullable Collection<ItemStackSnapshot> stacksToRedeem) {
            if (stacksToRedeem == null) {
                this.toRedeem = null;
            } else {
                this.toRedeem = ImmutableList.copyOf(stacksToRedeem);
            }
        }
    }

    public static class PostRedeem extends Redeem implements NucleusKitEvent.Redeem.Post {

        @Nullable private final Collection<ItemStackSnapshot> redeemed;

        public PostRedeem(Cause cause, @Nullable Instant lastTime, Kit kit, Player targetPlayer, Collection<ItemStackSnapshot> original,
                @Nullable Collection<ItemStackSnapshot> redeemed) {
            super(cause, lastTime, kit, targetPlayer, original);
            this.redeemed = redeemed;
        }

        @Override public Optional<Collection<ItemStackSnapshot>> getStacksToRedeem() {
            return Optional.ofNullable(this.redeemed);
        }
    }

    public static class FailedRedeem extends Redeem implements NucleusKitEvent.Redeem.Failed {

        @Nullable private final Collection<ItemStackSnapshot> redeemed;
        private final KitRedeemException.Reason ex;

        public FailedRedeem(Cause cause, @Nullable Instant lastTime, Kit kit, Player targetPlayer, Collection<ItemStackSnapshot> original,
                @Nullable Collection<ItemStackSnapshot> redeemed, KitRedeemException.Reason ex) {
            super(cause, lastTime, kit, targetPlayer, original);
            this.redeemed = redeemed;
            this.ex = ex;
        }

        @Override public Optional<Collection<ItemStackSnapshot>> getStacksToRedeem() {
            return Optional.ofNullable(this.redeemed);
        }

        @Override public KitRedeemException.Reason getReason() {
            return this.ex;
        }
    }
}
