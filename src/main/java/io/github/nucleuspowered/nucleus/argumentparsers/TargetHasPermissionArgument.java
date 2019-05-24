/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.argumentparsers;

import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.collect.ImmutableList;
import io.github.nucleuspowered.nucleus.Nucleus;
import io.github.nucleuspowered.nucleus.argumentparsers.util.WrappedElement;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

public class TargetHasPermissionArgument extends WrappedElement {

    private final String userTextKey;
    private final Predicate<Subject> canAccess;

    public TargetHasPermissionArgument(CommandElement key, String userTextKey, @Nullable String permission) {
        this(key, userTextKey, permission == null ? subject -> true : subject ->
                Nucleus.getNucleus().getPermissionResolver().hasPermission(subject, permission));
    }

    public TargetHasPermissionArgument(CommandElement key, String userTextKey, Predicate<Subject> canAccess) {
        super(key);
        this.userTextKey = userTextKey;
        this.canAccess = canAccess;
    }

    @Override public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
        Subject subject = context.<Subject>getOne(this.userTextKey).orElse(source);
        if (this.canAccess.test(subject)) {
            this.getWrappedElement().parse(source, args, context);
        } else {
            throw args.createError(t("You do not have permission to use the unknown argument"));
        }
    }

    @Nullable @Override protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        return null;
    }

    @Override public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        Subject subject = context.<Subject>getOne(this.userTextKey).orElse(src);
        if (this.canAccess.test(subject)) {
            return this.getWrappedElement().complete(src, args, context);
        }

        return ImmutableList.of();
    }

    @Override public Text getUsage(CommandSource src) {
        return Text.of("[<key> [value]]");
    }
}
