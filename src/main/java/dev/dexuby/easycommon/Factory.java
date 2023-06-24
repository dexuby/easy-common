package dev.dexuby.easycommon;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface Factory<I, O> {

    @Nullable
    O create(@NotNull final I input);

}
