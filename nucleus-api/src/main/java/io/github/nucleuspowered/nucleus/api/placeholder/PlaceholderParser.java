/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.placeholder;

import org.spongepowered.api.text.Text;

@FunctionalInterface
public interface PlaceholderParser {

    /**
     * Creates a {@link Text} based on the provided {@link Placeholder.Standard}.
     *
     * @param placeholder The {@link Placeholder.Standard}
     * @return The {@link Text}
     */
    Text parse(Placeholder.Standard placeholder);

    /**
     * Validates a {@link Placeholder.Standard} as its being built. Throw an
     * {@link IllegalStateException} if the placeholder will not be valid.
     *
     * @param placeholder The newly built {@link Placeholder.Standard}
     * @throws IllegalStateException if the placeholder is not valid.
     */
    default void validate(Placeholder.Standard placeholder) throws IllegalStateException { }

    interface RequireSender extends PlaceholderParser {

        /**
         * Validates a {@link Placeholder} as its being built. Throw an
         * {@link IllegalStateException} if the placeholder will not be valid.
         *
         * <p>This is default implemented to require {@link Placeholder.Standard#getAssociatedSource()}
         * to contain a source.</p>
         *
         * @param placeholder The newly built {@link Placeholder.Standard}
         * @throws IllegalStateException if the placeholder is not valid.
         */
        default void validate(Placeholder.Standard placeholder) throws IllegalStateException {
            placeholder.getAssociatedSource().orElseThrow(() -> new IllegalStateException("Must contain an associated source!"));
        }

    }

}
