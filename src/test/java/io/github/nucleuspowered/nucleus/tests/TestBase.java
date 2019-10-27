/*
 * This file is part of Nucleus, licensed under the MIT License (MIT). See the LICENSE.txt file
 * at the root of this project for more details.
 */
package io.github.nucleuspowered.nucleus.tests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.FormattingCodeTextSerializer;
import org.spongepowered.api.text.serializer.SafeTextSerializer;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Sponge.class)
public abstract class TestBase {

    private static boolean complete = false;

    private static void setFinalStatic(Field field) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    }

    private static void setFinalStaticPlain(Field field) throws Exception {
        setFinalStatic(field);
        SafeTextSerializer sts = Mockito.mock(SafeTextSerializer.class);
        Mockito.when(sts.serialize(Mockito.any())).thenReturn("key");
        Mockito.when(sts.deserialize(Mockito.any())).thenReturn(Text.of("key"));
        field.set(null, sts);
    }

    private static void setFinalStaticFormatters(Field field) throws Exception {
        setFinalStatic(field);
        FormattingCodeTextSerializer sts = Mockito.mock(FormattingCodeTextSerializer.class);
        Mockito.when(sts.serialize(Mockito.any())).thenReturn("key");
        Mockito.when(sts.deserialize(Mockito.any())).thenReturn(Text.of("key"));
        Mockito.when(sts.stripCodes(Mockito.anyString())).thenReturn("test");
        Mockito.when(sts.replaceCodes(Mockito.anyString(), Mockito.anyChar())).thenReturn("test");
        field.set(null, sts);
    }

    @BeforeClass
    public static void testSetup() throws Exception {
        if (complete) {
            return;
        }

        complete = true;
        setFinalStaticPlain(TextSerializers.class.getField("PLAIN"));
        setFinalStaticFormatters(TextSerializers.class.getField("FORMATTING_CODE"));
        setFinalStaticFormatters(TextSerializers.class.getField("LEGACY_FORMATTING_CODE"));
    }

    public static void setupSpongeMock() {
        Cause mockCause = Cause.of(EventContext.empty(), "test");
        CauseStackManager csm = Mockito.mock(CauseStackManager.class);
        Mockito.when(csm.getCurrentCause()).thenReturn(mockCause);
        PowerMockito.mockStatic(Sponge.class);
        PowerMockito.when(Sponge.getCauseStackManager()).thenReturn(csm);
    }

    private static class NucleusTest {

    }
}
