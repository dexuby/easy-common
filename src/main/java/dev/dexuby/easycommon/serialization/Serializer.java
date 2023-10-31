package dev.dexuby.easycommon.serialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Serializer<T, I> {

    @Nullable
    T serialize(@NotNull final I Input);

}
