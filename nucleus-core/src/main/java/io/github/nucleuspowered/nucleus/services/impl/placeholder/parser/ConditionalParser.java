/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.services.impl.placeholder.parser;

import io.github.nucleuspowered.nucleus.api.placeholder.Placeholder;
import io.github.nucleuspowered.nucleus.api.placeholder.PlaceholderParser;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.function.Predicate;

public class ConditionalParser implements PlaceholderParser {

    private final Text text;
    private final Predicate<Placeholder.Standard> predicate;

    public ConditionalParser(Text text, Predicate<Placeholder.Standard> predicate) {
        this.text = text;
        this.predicate = predicate;
    }

    @Override
    public Text parse(Placeholder.Standard placeholder) {
        if (this.predicate.test(placeholder)) {
            return this.text;
        }

        return Text.EMPTY;
    }

    public static class PlayerCondition extends ConditionalParser {

        public PlayerCondition(Text text, Predicate<Player> predicate) {
            super(text, p -> p.getAssociatedSource()
                    .filter(x -> x instanceof Player)
                    .map(x -> predicate.test((Player) x))
                    .orElse(false));
        }
    }
}
