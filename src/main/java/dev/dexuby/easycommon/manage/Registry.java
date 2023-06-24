package dev.dexuby.easycommon.manage;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Registry<K, V> {

    private final Map<K, V> registered = new LinkedHashMap<>();

    public void register(@NotNull final K key, @Nullable final V value) {

        this.registered.put(key, value);

    }

    public void unregister(@NotNull final K key) {

        this.registered.remove(key);

    }

    @Nullable
    public V get(@NotNull final K key) {

        return this.registered.get(key);

    }

    public boolean containsKey(@NotNull final K key) {

        return this.registered.containsKey(key);

    }

    public boolean containsValue(@NotNull final V value) {

        return this.registered.containsValue(value);

    }

    public Map<K, V> getInternalMapCopy() {

        return new LinkedHashMap<>(registered);

    }

    public void clear() {

        registered.clear();

    }

}
