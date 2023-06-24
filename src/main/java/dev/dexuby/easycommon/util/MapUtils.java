package dev.dexuby.easycommon.util;

import dev.dexuby.easycommon.tuple.KeyValuePair;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MapUtils {

    @SafeVarargs
    public static <K, V> Map<K, V> newMap(@NotNull final KeyValuePair<K, V>... pairs) {

        return fillMap(new HashMap<>(), pairs);

    }

    @SafeVarargs
    public static <K, V> Map<K, V> newLinkedMap(@NotNull final KeyValuePair<K, V>... pairs) {

        return fillMap(new LinkedHashMap<>(), pairs);

    }

    @SafeVarargs
    public static <K, V> Map<K, V> newConcurrentMap(@NotNull final KeyValuePair<K, V>... pairs) {

        return fillMap(new ConcurrentHashMap<>(), pairs);

    }

    @SafeVarargs
    public static <K, V> Map<K, V> fillMap(@NotNull final Map<K, V> map, @NotNull final KeyValuePair<K, V>... pairs) {

        for (final KeyValuePair<K, V> pair : pairs)
            map.put(pair.getKey(), pair.getValue());

        return map;

    }

}
