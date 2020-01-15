/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.util;

/**
 * A variant of {@link AutoCloseable} with no exception to catch
 */
@FunctionalInterface
public interface NoExceptionAutoClosable extends AutoCloseable {

    /**
     * A {@link NoExceptionAutoClosable} that does nothing.
     */
    NoExceptionAutoClosable EMPTY = () -> {};

    /**
     * Closes resources associated with this closable
     */
    @Override void close();
}
