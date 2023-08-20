package dev.dexuby.easycommon.context;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class MapPlaceholderProcessor implements PlaceholderProcessor {

    private final static char PLACEHOLDER_IDENTIFIER = '%';
    private final static char ESCAPE_IDENTIFIER = '\\';

    private final Map<String, String> placeholders;

    public MapPlaceholderProcessor(@NotNull final Map<String, String> placeholders) {

        this.placeholders = placeholders;

    }

    public void addPlaceholder(@NotNull final String key, @NotNull final String value) {

        placeholders.put(key, value);

    }

    @NotNull
    @Override
    public String process(@NotNull final String input) {

        final char[] chars = input.toCharArray();
        final StringBuilder builder = new StringBuilder();

        boolean readingName = false;
        StringBuilder name = new StringBuilder();

        char previousChar = ' ';
        for (final char c : chars) {
            if (c == ESCAPE_IDENTIFIER) {
                previousChar = c;
                continue;
            }

            if (c == PLACEHOLDER_IDENTIFIER && previousChar != ESCAPE_IDENTIFIER) {
                name.append(c);
                if (readingName) {
                    final String value = placeholders.get(name.toString());
                    if (value != null) builder.append(value);
                    name = new StringBuilder();
                    readingName = false;
                } else {
                    readingName = true;
                }
            } else {
                if (readingName) name.append(c);
                else builder.append(c);
            }

            previousChar = c;
        }

        return builder.toString();

    }

}
