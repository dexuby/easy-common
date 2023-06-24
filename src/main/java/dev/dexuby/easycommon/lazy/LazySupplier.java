package dev.dexuby.easycommon.lazy;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class LazySupplier<T> {

    private final Supplier<T> supplier;
    private T value = null;

    public LazySupplier(@NotNull final Supplier<T> supplier) {

        this.supplier = supplier;

    }

    public T getValue() {

        return this.value == null ? (this.value = this.supplier.get()) : this.value;

    }

    public static <T> LazySupplier<T> of(@NotNull final Supplier<T> supplier) {

        return new LazySupplier<>(supplier);

    }

}
