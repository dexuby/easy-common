package dev.dexuby.easycommon.serialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Deserializer<T, I> {

    @Nullable
    T deserialize(@NotNull final I input);

}
