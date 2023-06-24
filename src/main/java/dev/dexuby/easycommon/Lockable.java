package dev.dexuby.easycommon;

public interface Lockable {

    boolean lock();

    default boolean unlock() {
        return false;
    }

}
