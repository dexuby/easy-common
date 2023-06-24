package dev.dexuby.easycommon.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EnumUtils {

    @NotNull
    public static <T extends Enum<T>> T parseSafe(@NotNull final Class<T> type, @Nullable final String input, @NotNull final T defaultValue) {

        if (input == null || input.isEmpty()) return defaultValue;

        for (final T value : type.getEnumConstants()) {
            if (value.name().equals(input))
                return value;
        }

        return defaultValue;

    }

}
