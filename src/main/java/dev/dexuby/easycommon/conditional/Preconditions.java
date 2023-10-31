package dev.dexuby.easycommon.conditional;

import org.jetbrains.annotations.Nullable;

public final class Preconditions {

    public static <T> void checkNotNull(@Nullable final T reference) throws NullPointerException {

        if (reference == null) throw new NullPointerException("Reference was null.");

    }

    public static <T> void checkNull(@Nullable final T reference) throws IllegalArgumentException {

        if (reference != null) throw new IllegalArgumentException("Reference was not null.");

    }

    public static void checkState(final boolean state) throws IllegalStateException {

        if (!state) throw new IllegalStateException("State was false.");

    }

}
