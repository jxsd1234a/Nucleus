/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.configurate.typeserialisers;

import com.google.common.reflect.TypeToken;
import io.github.nucleuspowered.nucleus.services.impl.texttemplatefactory.NucleusTextTemplateImpl;
import io.github.nucleuspowered.nucleus.services.interfaces.INucleusTextTemplateFactory;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;

public class NucleusTextTemplateTypeSerialiser implements TypeSerializer<NucleusTextTemplateImpl> {

    private final INucleusTextTemplateFactory factory;

    public NucleusTextTemplateTypeSerialiser(INucleusTextTemplateFactory factory) {
        this.factory = factory;
    }

    @Override public NucleusTextTemplateImpl deserialize(TypeToken<?> type, ConfigurationNode value) throws ObjectMappingException {
        try {
            return this.factory.createFromString(value.getString());
        } catch (Throwable throwable) {
            throw new ObjectMappingException(throwable);
        }
    }

    @Override public void serialize(TypeToken<?> type, NucleusTextTemplateImpl obj, ConfigurationNode value) {
        value.setValue(obj.getRepresentation());
    }
}
