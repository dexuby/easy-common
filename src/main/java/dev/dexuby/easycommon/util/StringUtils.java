package dev.dexuby.easycommon.util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class StringUtils {

    public static List<String> split(@NotNull final String input, final char splitChar) {

        final List<String> output = new ArrayList<>(5);
        final StringBuilder partBuilder = new StringBuilder();
        for (final char c : input.toCharArray()) {
            if (c == splitChar) {
                output.add(partBuilder.toString());
                partBuilder.setLength(0);
            } else {
                partBuilder.append(c);
            }
        }
        output.add(partBuilder.toString());

        return output;

    }

}
