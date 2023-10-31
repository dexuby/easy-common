package dev.dexuby.easycommon.container;

import dev.dexuby.easycommon.Lockable;
import dev.dexuby.easycommon.conditional.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockableValue<T> implements Lockable {

    private final T defaultValue;
    private T value = null;
    private boolean locked = false;

    public LockableValue() {

        this.defaultValue = null;

    }

    public LockableValue(@NotNull final T defaultValue) {

        this.defaultValue = defaultValue;

    }

    /**
     * Sets the internal value that will get prioritised over the default value. If the current instance is already
     * locked it will return <code>false</code> and do nothing. You should check if the instance is already locked
     * before calling this method using the {@link LockableValue#isLocked} method.
     *
     * @param value The value.
     * @return <code>true</code> if the value has been set, <code>false</code> otherwise.
     */

    public boolean setAndLock(@Nullable final T value) {

        if (this.locked) return false;

        this.value = value;
        this.lock();

        return true;

    }

    /**
     * Returns the default value if present.
     *
     * @return The default value or <code>null</code> if it is not present.
     */

    @Nullable
    public T getDefaultValue() {

        return this.defaultValue;

    }

    /**
     * Returns the stored value or the default value if no value has been set. If no value is stored and the default
     * value is <code>null</code> this method will throw an exception.
     *
     * @return The value prioritising the set value.
     * @throws NullPointerException If both values were <code>null</code>.
     */

    @NotNull
    public T get() throws NullPointerException {

        if (this.value == null) {
            Preconditions.checkNotNull(defaultValue);
            return this.defaultValue;
        } else {
            return this.value;
        }

    }

    @Override
    public void lock() {

        this.locked = true;

    }

    @Override
    public boolean isLocked() {

        return this.locked;

    }

    /**
     * Static factory method to create a new instance based on the provided default value.
     *
     * @param defaultValue The default value.
     * @param <T>          The type.
     * @return The created instance.
     */

    public static <T> LockableValue<T> of(@NotNull final T defaultValue) {

        return new LockableValue<>(defaultValue);

    }

    /**
     * Static factory method to create a new instance with no default value.
     *
     * @param <T> The type.
     * @return The created instance.
     */

    public static <T> LockableValue<T> empty() {

        return new LockableValue<>();

    }

}
