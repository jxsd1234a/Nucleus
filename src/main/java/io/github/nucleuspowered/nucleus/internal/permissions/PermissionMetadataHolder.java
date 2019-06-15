/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.internal.permissions;

import io.github.nucleuspowered.nucleus.Nucleus;
import org.spongepowered.api.service.permission.Subject;

import java.util.HashMap;
import java.util.Map;

public class PermissionMetadataHolder {

    public final static PermissionMetadataHolder INSTANCE = new PermissionMetadataHolder();

    private PermissionMetadataHolder() {
        throw new AssertionError("No.");
    }

    private static final String PERMISSION_PREFIX = "nucleus.";

    private final Map<String, Metadata> metadataMap = new HashMap<>();
    private final Map<String, Metadata> prefixMetadataMap = new HashMap<>();

    public void register(String permission, PermissionMetadata metadata) {
        Metadata m = new Metadata(permission, metadata);
        if (metadata.isPrefix()) {
            this.prefixMetadataMap.put(permission.toLowerCase(), m);
        } else {
            this.metadataMap.put(permission.toLowerCase(), m);
        }
    }

    public boolean hasPermission(Subject subject, String permission) {
        return false;
    }

    public class Metadata {

        private final String description;
        private final String permission;
        private final SuggestedLevel suggestedLevel;
        private final boolean isPrefix;
        private final String[] replacements;

        Metadata(String permission, PermissionMetadata metadata) {
            this(
                    metadata.descriptionKey(),
                    metadata.replacements(),
                    permission,
                    metadata.level(),
                    metadata.isPrefix()
            );
        }

        Metadata(String description, String[] replacements, String permission, SuggestedLevel suggestedLevel, boolean isPrefix) {
            this.description = description;
            this.replacements = replacements;
            this.permission = PERMISSION_PREFIX + permission.toLowerCase();
            this.suggestedLevel = suggestedLevel;
            this.isPrefix = isPrefix;
        }

        public boolean isPrefix() {
            return this.isPrefix;
        }

        public SuggestedLevel getSuggestedLevel() {
            return this.suggestedLevel;
        }

        public String getDescription() {
            return Nucleus.getNucleus().getMessageProvider().getMessageWithFormat(this.description, this.replacements);
        }

        public String getPermission() {
            return this.permission;
        }

    }

}
