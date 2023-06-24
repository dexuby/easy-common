package dev.dexuby.easycommon;

import org.jetbrains.annotations.NotNull;

public interface Builder<T> {

    @NotNull
    T build();

}
