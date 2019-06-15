/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.modules.note;

import io.github.nucleuspowered.nucleus.annotationprocessor.RegisterPermissions;
import io.github.nucleuspowered.nucleus.internal.permissions.PermissionMetadata;
import io.github.nucleuspowered.nucleus.internal.permissions.SuggestedLevel;

@RegisterPermissions
public class NotePermissions {
    private NotePermissions() {
        throw new AssertionError("Nope");
    }

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "checknotes" }, level = SuggestedLevel.MOD)
    public static final String BASE_CHECKNOTES = "checknotes.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "clearnotes" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_CLEARNOTES = "clearnotes.base";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "note" }, level = SuggestedLevel.MOD)
    public static final String BASE_NOTE = "note.base";

    @PermissionMetadata(descriptionKey = "permission.note.notify", level = SuggestedLevel.MOD)
    public static final String NOTE_NOTIFY = "note.notify";

    @PermissionMetadata(descriptionKey = "permission.note.showonlogin", level = SuggestedLevel.MOD)
    public static final String NOTE_SHOWONLOGIN = "note.showonlogin";

    @PermissionMetadata(descriptionKey = "permission.base", replacements = { "removenote" }, level = SuggestedLevel.ADMIN)
    public static final String BASE_REMOVENOTE = "removenote.base";

}
