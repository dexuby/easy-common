package dev.dexuby.easycommon.context;

import org.jetbrains.annotations.NotNull;

public interface PlaceholderProcessor {

    @NotNull
    String process(@NotNull final String input);

}
