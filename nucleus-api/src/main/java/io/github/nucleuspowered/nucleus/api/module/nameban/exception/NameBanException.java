/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.api.module.nameban.exception;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.text.Text;

public class NameBanException extends CommandException {

    private final Reason reason;

    public NameBanException(Text message, Reason reason) {
        super(message);
        this.reason = reason;
    }

    public Reason getReason() {
        return this.reason;
    }

    public enum Reason {
        DISALLOWED_NAME,
        DOES_NOT_EXIST
    }
}
