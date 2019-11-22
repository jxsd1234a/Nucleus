package io.github.nucleuspowered.nucleus.services.impl.compatibility;

import com.google.common.collect.ImmutableSet;
import io.github.nucleuspowered.nucleus.services.interfaces.ICompatibilityService;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;

public class Message implements ICompatibilityService.CompatibilityMessages {

    private final String modId;
    private final ICompatibilityService.Severity severity;
    private final String symptom;
    private final String message;
    private final String resolution;
    private final Collection<String> modules;

    public Message(String modId,
            ICompatibilityService.Severity severity,
            String symptom,
            String message,
            String resolution,
            @Nullable Collection<String> modules) {
        this.modId = modId;
        this.severity = severity;
        this.symptom = symptom;
        this.message = message;
        this.resolution = resolution;
        this.modules = modules == null ? ImmutableSet.of() : ImmutableSet.copyOf(modules);
    }

    @Override
    public String getModId() {
        return this.modId;
    }

    @Override public Collection<String> getModules() {
        return this.modules;
    }

    @Override
    public ICompatibilityService.Severity getSeverity() {
        return this.severity;
    }

    @Override
    public String getSymptom() {
        return this.symptom;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getResolution() {
        return this.resolution;
    }
}
