/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.environment;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class EnvironmentPermissions {
    private EnvironmentPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "lockweather" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_LOCKWEATHER = "lockweather.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "time" }, level = SuggestedLevel.USER)
    public static final String BASE_TIME = "time.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "time" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_TIME = "time.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "time" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_TIME = "time.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "time" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_TIME = "time.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "time set" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_TIME_SET = "time.set.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "time set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_TIME_SET = "time.set.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "time set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_TIME_SET = "time.set.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "time set" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_TIME_SET = "time.set.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "weather" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_WEATHER = "weather.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "weather" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_WEATHER = "weather.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "weather" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_WEATHER = "weather.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.weather.exempt.length", level = SuggestedLevel.ADMIN)
    public static final String WEATHER_EXEMPT_LENGTH = "weather.exempt.length";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "weather" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_WEATHER = "weather.exempt.warmup";

}
