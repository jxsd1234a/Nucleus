/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.internal.userprefs;

import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.api.service.NucleusUserPreferenceService;
import io.github.nucleuspowered.nucleus.argumentparsers.TargetHasPermissionArgument;
import io.github.nucleuspowered.nucleus.internal.command.NucleusParameters;
import io.github.nucleuspowered.nucleus.modules.core.datamodules.PreferencesUserModule;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

public class UserPreferenceService implements NucleusUserPreferenceService {

    private final NucleusKeysProvider provider = new NucleusKeysProvider();

    private final Map<String, NucleusUserPreferenceService.PreferenceKey<?>> registered = new HashMap<>();
    private final Element element = new Element();
    private final List<CommandElement> elements = new ArrayList<>();

    public static final Text PREFERENCE_ARG = Text.of("preference");
    public static final Text VALUE_ARG = Text.of("value");

    public CommandElement getElement() {
        return this.element;
    }

    public void postInit() {
        // Get fields
        Arrays.stream(NucleusKeysProvider.class.getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(TargetID.class))
                .forEach(field -> {
                    TargetID id = field.getAnnotation(TargetID.class);
                    NucleusUserPreferenceService.PreferenceKey<?> key = this.registered.get(id.value());
                    if (key != null) {
                        try {
                            field.setAccessible(true);
                            field.set(this.provider, key);
                        } catch (IllegalAccessException e) {
                            Nucleus.getNucleus().getLogger().error("Could not set " + id.value() + " in the User Preference Service", e);
                        }
                    }
                });
    }

    public void register(io.github.nucleuspowered.nucleus.internal.userprefs.PreferenceKey<?> key) {
        this.registered.put(key.getID(), key);

        CommandElement lit = GenericArguments.literal(PREFERENCE_ARG, key, key.getID().replaceAll("^nucleus:", ""));
        Class<?> clazz = key.getValueClass();
        if (clazz == Boolean.class || clazz == boolean.class) {
            this.elements.add(new TargetHasPermissionArgument(
                    GenericArguments.seq(lit, GenericArguments.optional(GenericArguments.bool(VALUE_ARG))),
                    NucleusParameters.Keys.USER,
                    user -> !(user instanceof User) || key.canAccess((User) user))
            );
        } else if (clazz == Integer.class || clazz == int.class) {
            this.elements.add(new TargetHasPermissionArgument(
                    GenericArguments.seq(lit, GenericArguments.optional(GenericArguments.integer(VALUE_ARG))),
                    NucleusParameters.Keys.USER,
                    user -> !(user instanceof User) || key.canAccess((User) user))
            );
        } else if (clazz == Double.class || clazz == double.class) {
            this.elements.add(new TargetHasPermissionArgument(
                    GenericArguments.seq(lit, GenericArguments.optional(GenericArguments.doubleNum(VALUE_ARG))),
                    NucleusParameters.Keys.USER,
                    user -> !(user instanceof User) || key.canAccess((User) user))
            );
        } else {
            this.elements.add(new TargetHasPermissionArgument(
                    GenericArguments.seq(lit, GenericArguments.optional(GenericArguments.remainingRawJoinedStrings(VALUE_ARG))),
                    NucleusParameters.Keys.USER,
                    user -> !(user instanceof User) || key.canAccess((User) user))
            );
        }

        this.element.setReferencedElement(GenericArguments.firstParsing(this.elements.toArray(new CommandElement[0])));
    }

    public <T> void set(UUID uuid, NucleusUserPreferenceService.PreferenceKey<T> key, @Nullable T value) {
        Nucleus.getNucleus().getUserDataManager().get(uuid, true)
                .orElseThrow(IllegalStateException::new)
                .get(PreferencesUserModule.class)
                .set(key.getID(), value);
    }

    public Map<NucleusUserPreferenceService.PreferenceKey<?>, Object> get(User user) {
        Map<NucleusUserPreferenceService.PreferenceKey<?>, Object> ret = new HashMap<>();
        for (NucleusUserPreferenceService.PreferenceKey<?> key : this.registered.values()) {
            if (key.canAccess(user)) {
                ret.put(key, get(user.getUniqueId(), key).orElse(null));
            }
        }

        return ret;
    }

    public <T> Optional<T> get(UUID uuid, NucleusUserPreferenceService.PreferenceKey<T> key) {
        if (!this.registered.containsValue(key)) {
            throw new IllegalArgumentException("Key is not registered.");
        }

        Optional<T> ot = Optional.empty();
        try {
            ot = Nucleus.getNucleus().getUserDataManager().get(uuid)
                    .map(x -> (T) x.get(PreferencesUserModule.class).get(key.getID()));
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        if (ot.isPresent()) {
            return ot;
        }

        return key.getDefaultValue();
    }

    public <T> T getUnwrapped(UUID uuid, NucleusUserPreferenceService.PreferenceKey<T> key) {
        return get(uuid, key).orElse(null);
    }

    @Override
    public Keys keys() {
        return this.provider;
    }

    public NucleusKeysProvider keysImpl() {
        return this.provider;
    }

    @Override
    public <T> Optional<T> getPreferenceFor(User user, NucleusUserPreferenceService.PreferenceKey<T> key) {
        return get(user.getUniqueId(), key);
    }

    @Override
    public <T> void setPreferenceFor(User user, NucleusUserPreferenceService.PreferenceKey<T> key, T value) {
        set(user.getUniqueId(), key, value);
    }

    @Override
    public void removePreferenceFor(User user, NucleusUserPreferenceService.PreferenceKey<?> key) {
        set(user.getUniqueId(), key, null);
    }

    public class Element extends CommandElement {

        Element() {
            super(null);
        }

        CommandElement referencedElement = GenericArguments.none();

        void setReferencedElement(CommandElement e) {
            this.referencedElement = e;
        }

        @Nullable @Override public Text getKey() {
            return this.referencedElement.getKey();
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            this.referencedElement.parse(source, args, context);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return this.referencedElement.complete(src, args, context);
        }

        @Override public Text getUsage(CommandSource src) {
            return this.referencedElement.getUsage(src);
        }
    }

    Map<String, NucleusUserPreferenceService.PreferenceKey<?>> getRegistered() {
        return this.registered;
    }

}
