/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.service;

import org.spongepowered.api.entity.living.player.User;

import java.util.Optional;

public interface NucleusUserPreferenceService {

    /**
     * Gets the user preference keys available for this user.
     *
     * @return An interface that contains {@link Keys}
     */
    Keys keys();

    /**
     * Gets the preference associated with the {@link PreferenceKey} for the
     * supplied {@link User}, if any is set.
     *
     * @param user The {@link User}
     * @param key The {@link PreferenceKey} to check against.
     * @param <T> The type of preference this is
     * @return The value, if one is set.
     */
    <T> Optional<T> getPreferenceFor(User user, PreferenceKey<T> key);

    /**
     * Sets the preference associated with the {@link PreferenceKey} for the
     * supplied {@link User}.
     *
     * @param user The {@link User}
     * @param key The {@link PreferenceKey} value to set
     * @param value The value to set
     * @param <T> The type of preference this is
     */
    <T> void setPreferenceFor(User user, PreferenceKey<T> key, T value);

    /**
     * Removes a preference associated with a user, reverting it to a default
     * value as determined by the consumer of the preference (which will usually
     * take the value of {@link PreferenceKey#getDefaultValue()}, if any is
     * supplied).
     *
     * @param user The {@link User}
     * @param key The {@link PreferenceKey}
     */
    void removePreferenceFor(User user, PreferenceKey<?> key);

    /**
     * Contains {@link PreferenceKey}s
     */
    interface Keys {

        /**
         * If the vanish module is enabled, gets a preference key that indicates whether the user
         * will vanish on login.
         *
         * @return The {@link PreferenceKey}, if the module is loaded.
         */
        Optional<PreferenceKey<Boolean>> vanishOnLogin();

        /**
         * If the teleport module is enabled, gets a preference key that indicates whether the user
         * allows players to teleport to them.
         *
         * @return The {@link PreferenceKey}, if the module is loaded.
         */
        Optional<PreferenceKey<Boolean>> teleportTarget();

        /**
         * If the powertool module is enabled, gets a preference key that indicates whether the user
         * has enabled powertools by attempting to use an object that is assigned to a powertool.
         *
         * @return The {@link PreferenceKey}, if the module is loaded.
         */
        Optional<PreferenceKey<Boolean>> powertoolsEnabled();

        /**
         * If the message module is enabled, gets a preference key that indicates whether the user
         * has enabled social spy. This may be overriden by a force permission.
         *
         * @return The {@link PreferenceKey}, if the module is loaded.
         */
        Optional<PreferenceKey<Boolean>> socialSpyEnabled();

        /**
         * If the message module is enabled, gets a preference key that indicates whether the user
         * has is receiving private messages.
         *
         * @return The {@link PreferenceKey}, if the module is loaded.
         */
        Optional<PreferenceKey<Boolean>> messageReceivingEnabled();

        /**
         * If the command spy module is enabled, gets a preference key that indicates whether the user
         * is receiving messages that indicate commands that are being run by other players.
         *
         * @return The {@link PreferenceKey}, if the module is loaded.
         */
        Optional<PreferenceKey<Boolean>> commandSpyEnabled();

        /**
         * If the staff chat module is enabled, gets a preference key that indicates whether the user
         * is receiving messages on the staff chat channel.
         *
         * @return The {@link PreferenceKey}, if the module is loaded.
         */
        Optional<PreferenceKey<Boolean>> viewStaffChat();
    }

    /**
     * Represents a {@link PreferenceKey}
     *
     * <p>Keys will only be accepted by the Nucleus system that are generated by it.</p>
     *
     * @param <T> The type of key.
     */
    interface PreferenceKey<T> {

        /**
         * The ID of the key. Must be unique amongst all keys.
         *
         * @return The ID
         */
        String getID();

        /**
         * The default value for a preference, if any.
         *
         * @return The default value, if any.
         */
        Optional<T> getDefaultValue();

        /**
         * The type of value.
         *
         * @return The {@link Class}
         */
        Class<T> getValueClass();

        /**
         * Tests whether a user can change their preference.
         *
         * @param user The user to check
         * @return If they have permission
         */
        boolean canAccess(User user);

        /**
         * The description of the preference.
         *
         * @return The description.
         */
        String getDescription();
    }

}
