package dev.dexuby.easycommon.util;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class UUIDUtils {

    public static InputStream uuidToStream(final UUID uuid) {

        final byte[] bytes = new byte[16];
        ByteBuffer.wrap(bytes)
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits());

        return new ByteArrayInputStream(bytes);

    }

    public static UUID streamToUUID(final InputStream stream) {

        final ByteBuffer buffer = ByteBuffer.allocate(16);

        try {
            final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(Math.max(stream.available(), 32));
            final byte[] byteBuffer = new byte[16];
            int read;
            while (true) {
                read = stream.read(byteBuffer);
                if (read == -1) break;
                outputStream.write(byteBuffer, 0, read);
            }

            buffer.put(outputStream.toByteArray());
            buffer.flip();
            return new UUID(buffer.getLong(), buffer.getLong());
        } catch (final IOException ex) {
            return null;
        }

    }

    public static UUID fromUnformattedString(@NotNull final String input) {

        return UUID.fromString(input.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));

    }

}
