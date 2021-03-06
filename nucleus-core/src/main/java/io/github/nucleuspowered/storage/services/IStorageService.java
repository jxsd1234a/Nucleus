/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.storage.services;

import io.github.nucleuspowered.nucleus.services.impl.storage.dataobjects.configurate.AbstractConfigurateBackedDataObject;
import io.github.nucleuspowered.storage.dataobjects.IDataObject;
import io.github.nucleuspowered.storage.queryobjects.IQueryObject;
import io.github.nucleuspowered.storage.util.KeyedObject;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

/**
 * The entry point into the storage system. All storage checks are not dependent on the main thread,
 * that is, they should never use game objects.
 */
public interface IStorageService<D extends IDataObject> {

    /**
     * Creates a new {@link D} object.
     *
     * @return A new {@link D}
     */
    D createNew();

    /**
     * Provides a hint to the storage engine that anything that has been not yet been
     * saved must now be saved.
     */
    CompletableFuture<Void> ensureSaved();

    /**
     * Provides a hint to the storage engine that anything that has been cached
     * should be cleared. Implementors may not do anything.
     */
    CompletableFuture<Void> clearCache();

    /**
     * A service where there is one data point.
     *
     * @param <D> The data object type
     */
    interface Single<D extends IDataObject> extends IStorageService<D> {

        /**
         * Gets the data.
         *
         * @return A {@link CompletableFuture} that contains the data, if it exists.
         */
        CompletableFuture<Optional<D>> get();

        /**
         * Gets the data on thread.
         *
         * @return The data, if it exists.
         */
        Optional<D> getOnThread();

        /**
         * Gets the data, or a new {@link D}.
         *
         * @return The {@link D}
         */
        default CompletableFuture<D> getOrNew() {
            return get().thenApply(d -> d.orElseGet(() -> {
                D result = createNew();
                save(result);
                return result;
            }));
        }

        /**
         * Gets the data on thread, or creates a new {@link D}.
         *
         * @return The data.
         */
        default D getOrNewOnThread() {
            return getOnThread().orElseGet(() -> {
                D result = createNew();
                save(result);
                return result;
            });
        }

        /**
         * Save the data.
         *
         * @param value The data to save.
         * @return A {@link CompletableFuture} that may contain an exception.
         */
        CompletableFuture<Void> save(@Nonnull D value);
    }

    /**
     * A service where there is one data point that can be cached.
     *
     * @param <D> The data object type
     */
    interface SingleCached<D extends IDataObject> extends IStorageService.Single<D> {

        /**
         * Reloads the data from persistence, only clearing the
         * cache if successful.
         */
        CompletableFuture<Void> reload();

        /**
         * Saves the cached version if it exists.
         */
        void saveCached();

        /**
         * Get the cached object, if it exists.
         *
         * @return The object.
         */
        Optional<D> getCached();
    }

    /**
     * A service where multiple data objects may be retured based on a query.
     *
     * <p>Note that while a query object may be provided, the storage engine
     * backing the service <em>may not</em> support them. An exception will be
     * returned in this scenario.</p>
     *
     * <p>Users should check {@link #supportsNonPrimaryKeyQueries()} before using
     * query objects.</p>
     *
     * @param <K> The primary key type
     * @param <Q> The {@link IQueryObject} that can contain query parameters
     * @param <D> The {@link AbstractConfigurateBackedDataObject} that this service deals with.
     */
    interface Keyed<K, Q extends IQueryObject<K, Q>, D extends IDataObject> extends IStorageService<D> {

        /**
         * Whether the backing storage engine supports queries that is not simply
         * the primary key.
         *
         * @return true if non-primary key queries are supported.
         */
        default boolean supportsNonPrimaryKeyQueries() {
            return false;
        }

        /**
         * Gets the object based on the provided key, if it exists.
         *
         * @param key The key
         * @return The object, if it exists
         */
        CompletableFuture<Optional<D>> get(@Nonnull K key);

        /**
         * Gets the object based on the provided key, if it exists.
         *
         * @param key The key
         * @return The object, if it exists
         */
        Optional<D> getOnThread(@Nonnull K key);

        /**
         * Gets the data, or a new {@link D}.
         *
         * @param key The key
         * @return The {@link D}
         */
        default CompletableFuture<D> getOrNew(@Nonnull K key) {
            return get(key).thenApply(d -> d.orElseGet(() -> {
                D result = createNew();
                save(key, result);
                return result;
            }));
        }

        /**
         * Gets the object based on the provided key, if it exists.
         *
         * @param key The key
         * @return The object, if it exists
         */
        default D getOrNewOnThread(@Nonnull K key) {
            return getOnThread(key).orElseGet(() -> {
                D result = createNew();
                save(key, result);
                return result;
            });
        }

        /**
         * Gets an object based on the supplied query, if one can be uniquely identified.
         *
         * <p>If {@link #supportsNonPrimaryKeyQueries()} and {@link Q#restrictedToKeys()} are both false,
         * the future will contain an error.</p>
         *
         * @param query The query
         * @return The {@link CompletableFuture} containing the result, or an exception.
         */
        CompletableFuture<Optional<KeyedObject<K, D>>> get(@Nonnull Q query);

        /**
         * Gets all objects that match the specified query.
         *
         * <p>If {@link #supportsNonPrimaryKeyQueries()} and {@link Q#restrictedToKeys()} are both false,
         * the future will contain an error.</p>
         *
         * @param query The query
         * @return The {@link CompletableFuture} containing the results, if any
         */
        CompletableFuture<Map<K, D>> getAll(@Nonnull Q query);

        /**
         * Gets whether the object with the associated key exists.
         *
         * @param key The key
         * @return The {@link CompletableFuture} containing the whether the object exists
         */
        CompletableFuture<Boolean> exists(@Nonnull K key);

        /**
         * Gets whether at least one result can be returned by the associated query.
         *
         * <p>If {@link #supportsNonPrimaryKeyQueries()} and {@link Q#restrictedToKeys()} are both false,
         * the future will contain an error.</p>
         *
         * @param query The query
         * @return The {@link CompletableFuture} containing the whether an object exists
         */
        default CompletableFuture<Boolean> exists(@Nonnull Q query) {
            return count(query).thenApply(x -> x > 0);
        }

        /**
         * Gets the number of results can be returned by the associated query.
         *
         * <p>If {@link #supportsNonPrimaryKeyQueries()} and {@link Q#restrictedToKeys()} are both false,
         * the future will contain an error.</p>
         *
         * @param query The query
         * @return The {@link CompletableFuture} containing the count
         */
        CompletableFuture<Integer> count(@Nonnull Q query);

        /**
         * Saves an object of type {@link D} against the primary key of type {@link K}.
         *
         * @param key The key to save the object under
         * @param value The value of the object
         * @return A {@link CompletableFuture} that will contain an exception if there was a failure
         */
        CompletableFuture<Void> save(@Nonnull K key, @Nonnull D value);

        /**
         * Deletes the object associated with the key {@link K}.
         *
         * @param key The key to delete the object for
         * @return A {@link CompletableFuture} that will contain an exception if there was a failure
         */
        CompletableFuture<Void> delete(@Nonnull K key);
    }

}
