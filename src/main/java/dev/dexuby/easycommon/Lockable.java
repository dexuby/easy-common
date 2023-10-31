package dev.dexuby.easycommon;

public interface Lockable {

    void lock();

    default void unlock() {
    }

    boolean isLocked();

}
