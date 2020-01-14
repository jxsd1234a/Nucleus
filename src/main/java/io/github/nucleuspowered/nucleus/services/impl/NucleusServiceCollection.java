/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl;

import com.google.inject.Injector;
import io.github.nucleuspowered.nucleus.guice.ConfigDirectory;
import io.github.nucleuspowered.nucleus.guice.DataDirectory;
import io.github.nucleuspowered.nucleus.services.INucleusServiceCollection;
import io.github.nucleuspowered.nucleus.services.interfaces.IChatMessageFormatterService;
import io.github.nucleuspowered.nucleus.services.interfaces.ICommandElementSupplier;
import io.github.nucleuspowered.nucleus.services.interfaces.ICommandMetadataService;
import io.github.nucleuspowered.nucleus.services.interfaces.ICompatibilityService;
import io.github.nucleuspowered.nucleus.services.interfaces.IConfigurateHelper;
import io.github.nucleuspowered.nucleus.services.interfaces.ICooldownService;
import io.github.nucleuspowered.nucleus.services.interfaces.IEconomyServiceProvider;
import io.github.nucleuspowered.nucleus.services.interfaces.IMessageProviderService;
import io.github.nucleuspowered.nucleus.services.interfaces.IMessageTokenService;
import io.github.nucleuspowered.nucleus.services.interfaces.IModuleDataProvider;
import io.github.nucleuspowered.nucleus.services.interfaces.INucleusTeleportService;
import io.github.nucleuspowered.nucleus.services.interfaces.INucleusTextTemplateFactory;
import io.github.nucleuspowered.nucleus.services.interfaces.IPermissionService;
import io.github.nucleuspowered.nucleus.services.interfaces.IPlatformService;
import io.github.nucleuspowered.nucleus.services.interfaces.IPlayerDisplayNameService;
import io.github.nucleuspowered.nucleus.services.interfaces.IPlayerInformationService;
import io.github.nucleuspowered.nucleus.services.interfaces.IPlayerOnlineService;
import io.github.nucleuspowered.nucleus.services.interfaces.IReloadableService;
import io.github.nucleuspowered.nucleus.services.interfaces.IStorageManager;
import io.github.nucleuspowered.nucleus.services.interfaces.ITextFileControllerCollection;
import io.github.nucleuspowered.nucleus.services.interfaces.ITextStyleService;
import io.github.nucleuspowered.nucleus.services.interfaces.IUserCacheService;
import io.github.nucleuspowered.nucleus.services.interfaces.IUserPreferenceService;
import io.github.nucleuspowered.nucleus.services.interfaces.IWarmupService;
import org.slf4j.Logger;
import org.spongepowered.api.plugin.PluginContainer;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class NucleusServiceCollection implements INucleusServiceCollection {

    private final Map<Class<?>, Object> instances = new HashMap<>();
    private final Map<Class<?>, Supplier<?>> suppliers = new HashMap<>();

    private final Provider<IMessageProviderService> messageProviderService;
    private final Provider<IEconomyServiceProvider> economyServiceProvider;
    private final Provider<IWarmupService> warmupService;
    private final Provider<ICooldownService> cooldownService;
    private final Provider<IPermissionService> permissionCheckService;
    private final Provider<IReloadableService> reloadableService;
    private final Provider<IPlayerOnlineService> playerOnlineService;
    private final Provider<IMessageTokenService> messageTokenService;
    private final Provider<IStorageManager> storageManager;
    private final Provider<IUserPreferenceService> userPreferenceService;
    private final Provider<ICommandMetadataService> commandMetadataService;
    private final Provider<IPlayerDisplayNameService> playerDisplayNameService;
    private final Provider<IModuleDataProvider> moduleConfigProvider;
    private final Provider<INucleusTeleportService> nucleusTeleportServiceProvider;
    private final Provider<ICommandElementSupplier> commandElementSupplierProvider;
    private final Provider<INucleusTextTemplateFactory> nucleusTextTemplateFactoryProvider;
    private final Provider<ITextFileControllerCollection> textFileControllerCollectionProvider;
    private final Provider<IUserCacheService> userCacheServiceProvider;
    private final Provider<IPlayerInformationService> playerInformationServiceProvider;
    private final Provider<IConfigurateHelper> configurateHelperProvider;
    private final Provider<IPlatformService> platformServiceProvider;
    private final Provider<ICompatibilityService> compatibilityServiceProvider;
    private final Provider<IChatMessageFormatterService> chatMessageFormatterProvider;
    private final Injector injector;
    private final PluginContainer pluginContainer;
    private final Logger logger;
    private final Provider<ITextStyleService> textStyleServiceProvider;
    private final Supplier<Path> dataDir;
    private final Path configPath;

    @Inject
    public NucleusServiceCollection(
            Injector injector,
            PluginContainer pluginContainer,
            Logger logger,
            @DataDirectory Supplier<Path> dataPath,
            @ConfigDirectory Path configPath) {
        this.messageProviderService = new LazyLoad<>(injector, IMessageProviderService.class);
        this.economyServiceProvider = new LazyLoad<>(injector, IEconomyServiceProvider.class);
        this.warmupService = new LazyLoad<>(injector, IWarmupService.class);
        this.cooldownService = new LazyLoad<>(injector, ICooldownService.class);
        this.userPreferenceService = new LazyLoad<>(injector, IUserPreferenceService.class);
        this.permissionCheckService = new LazyLoad<>(injector, IPermissionService.class);
        this.reloadableService = new LazyLoad<>(injector, IReloadableService.class);
        this.playerOnlineService = new LazyLoad<>(injector, IPlayerOnlineService.class);
        this.messageTokenService = new LazyLoad<>(injector, IMessageTokenService.class);
        this.storageManager = new LazyLoad<>(injector, IStorageManager.class);
        this.commandMetadataService = new LazyLoad<>(injector, ICommandMetadataService.class);
        this.playerDisplayNameService = new LazyLoad<>(injector, IPlayerDisplayNameService.class);
        this.moduleConfigProvider = new LazyLoad<>(injector, IModuleDataProvider.class);
        this.nucleusTeleportServiceProvider = new LazyLoad<>(injector, INucleusTeleportService.class);
        this.textStyleServiceProvider = new LazyLoad<>(injector, ITextStyleService.class);
        this.commandElementSupplierProvider = new LazyLoad<>(injector, ICommandElementSupplier.class);
        this.nucleusTextTemplateFactoryProvider = new LazyLoad<>(injector, INucleusTextTemplateFactory.class);
        this.textFileControllerCollectionProvider = new LazyLoad<>(injector, ITextFileControllerCollection.class);
        this.userCacheServiceProvider = new LazyLoad<>(injector, IUserCacheService.class);
        this.playerInformationServiceProvider = new LazyLoad<>(injector, IPlayerInformationService.class);
        this.configurateHelperProvider = new LazyLoad<>(injector, IConfigurateHelper.class);
        this.platformServiceProvider = new LazyLoad<>(injector, IPlatformService.class);
        this.compatibilityServiceProvider = new LazyLoad<>(injector, ICompatibilityService.class);
        this.chatMessageFormatterProvider = new LazyLoad<>(injector, IChatMessageFormatterService.class);
        this.injector = injector;
        this.pluginContainer = pluginContainer;
        this.logger = logger;
        this.dataDir = dataPath;
        this.configPath = configPath;
    }

    @Override
    public IMessageProviderService messageProvider() {
        return this.messageProviderService.get();
    }

    @Override
    public IPermissionService permissionService() {
        return this.permissionCheckService.get();
    }

    @Override
    public IEconomyServiceProvider economyServiceProvider() {
        return this.economyServiceProvider.get();
    }

    @Override
    public IWarmupService warmupService() {
        return this.warmupService.get();
    }

    @Override
    public ICooldownService cooldownService() {
        return this.cooldownService.get();
    }

    @Override
    public IUserPreferenceService userPreferenceService() {
        return this.userPreferenceService.get();
    }

    @Override
    public IReloadableService reloadableService() {
        return this.reloadableService.get();
    }

    @Override public IPlayerOnlineService playerOnlineService() {
        return this.playerOnlineService.get();
    }

    @Override public IMessageTokenService messageTokenService() {
        return this.messageTokenService.get();
    }

    @Override public IStorageManager storageManager() {
        return this.storageManager.get();
    }

    @Override public ICommandMetadataService commandMetadataService() {
        return this.commandMetadataService.get();
    }

    @Override public IPlayerDisplayNameService playerDisplayNameService() {
        return this.playerDisplayNameService.get();
    }

    @Override public IModuleDataProvider moduleDataProvider() {
        return this.moduleConfigProvider.get();
    }

    @Override public INucleusTeleportService teleportService() {
        return this.nucleusTeleportServiceProvider.get();
    }

    @Override public ICommandElementSupplier commandElementSupplier() {
        return this.commandElementSupplierProvider.get();
    }

    @Override public INucleusTextTemplateFactory textTemplateFactory() {
        return this.nucleusTextTemplateFactoryProvider.get();
    }

    @Override public ITextFileControllerCollection textFileControllerCollection() {
        return this.textFileControllerCollectionProvider.get();
    }

    @Override public ITextStyleService textStyleService() {
        return this.textStyleServiceProvider.get();
    }

    @Override public IPlayerInformationService playerInformationService() {
        return this.playerInformationServiceProvider.get();
    }

    @Override public IConfigurateHelper configurateHelper() {
        return this.configurateHelperProvider.get();
    }

    @Override public ICompatibilityService compatibilityService() {
        return this.compatibilityServiceProvider.get();
    }

    @Override public IUserCacheService userCacheService() {
        return this.userCacheServiceProvider.get();
    }

    @Override public IPlatformService platformService() {
        return this.platformServiceProvider.get();
    }

    @Override public IChatMessageFormatterService chatMessageFormatter() {
        return this.chatMessageFormatterProvider.get();
    }

    @Override
    public Injector injector() {
        return this.injector;
    }

    @Override
    public PluginContainer pluginContainer() {
        return this.pluginContainer;
    }

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public <I, C extends I> void registerService(Class<I> key, C service, boolean rereg) {
        if (!rereg && (this.instances.containsKey(key) || this.suppliers.containsKey(key))) {
            return;
        }

        this.suppliers.remove(key);
        this.instances.put(key, service);
    }

    @Override @SuppressWarnings("unchecked")
    public <I> Optional<I> getService(Class<I> key) {
        if (this.instances.containsKey(key)) {
            return Optional.of((I) this.instances.get(key));
        } else if (this.suppliers.containsKey(key)) {
            return Optional.of((I) this.suppliers.get(key).get());
        }

        return Optional.empty();
    }

    @Override @SuppressWarnings("unchecked")
    public <I> I getServiceUnchecked(Class<I> key) {
        if (this.instances.containsKey(key)) {
            return (I) this.instances.get(key);
        } else if (this.suppliers.containsKey(key)) {
            return (I) this.suppliers.get(key).get();
        }

        throw new NoSuchElementException(key.getName());
    }

    @Override public Path configDir() {
        return this.configPath;
    }

    @Override public Supplier<Path> dataDir() {
        return this.dataDir;
    }

    private static class LazyLoad<T> implements Provider<T> {
        private final Class<T> clazz;
        private final Injector injector;
        private T instance;

        LazyLoad(Injector injector, Class<T> clazz) {
            this.injector = injector;
            this.clazz = clazz;
        }

        @Override public T get() {
            if (this.instance == null) {
                this.instance = this.injector.getInstance(this.clazz);
            }
            return this.instance;
        }
    }

}
