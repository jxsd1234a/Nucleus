/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.rtp;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class RTPPermissions {
    private RTPPermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "rtp" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_RTP = "rtp.base";

    @PermissionMetadata(descriptionKey = "permission.exempt.cooldown", replacements = { "rtp" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COOLDOWN_RTP = "rtp.exempt.cooldown";

    @PermissionMetadata(descriptionKey = "permission.exempt.cost", replacements = { "rtp" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_COST_RTP = "rtp.exempt.cost";

    @PermissionMetadata(descriptionKey = "permission.exempt.warmup", replacements = { "rtp" }, level = SuggestedLevel.ADMIN)
    public static final String EXEMPT_WARMUP_RTP = "rtp.exempt.warmup";

    @PermissionMetadata(descriptionKey = "permission.others", replacements = { "rtp" }, level = SuggestedLevel.ADMIN)
    public static final String OTHERS_RTP = "rtp.others";

    @PermissionMetadata(descriptionKey = "permission.rtp.worlds", level = SuggestedLevel.ADMIN)
    public static final String RTP_WORLDS = "rtp.worlds";

}
