package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class Streams {

    /**
     * Implements InputStream.read(int) in terms of InputStream.read(byte[], int, int).
     * InputStream assumes that you implement InputStream.read(int) and provides default
     * implementations of the others, but often the opposite is more efficient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.758 -0500", hash_original_method = "ED7A18359C5B9AABC2BE5A464505FE51", hash_generated_method = "BD2B820681D76473966AF9335AF89156")
    
public static int readSingleByte(InputStream in) throws IOException {
        byte[] buffer = new byte[1];
        int result = in.read(buffer, 0, 1);
        return (result != -1) ? buffer[0] & 0xff : -1;
    }

    /**
     * Implements OutputStream.write(int) in terms of OutputStream.write(byte[], int, int).
     * OutputStream assumes that you implement OutputStream.write(int) and provides default
     * implementations of the others, but often the opposite is more efficient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.760 -0500", hash_original_method = "1BD6D2C194F851AADBFBC2F46E042CD3", hash_generated_method = "951EBC62540AA0526AE0DE45989413A3")
    
public static void writeSingleByte(OutputStream out, int b) throws IOException {
        byte[] buffer = new byte[1];
        buffer[0] = (byte) (b & 0xff);
        out.write(buffer);
    }

    /**
     * Fills 'dst' with bytes from 'in', throwing EOFException if insufficient bytes are available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.763 -0500", hash_original_method = "966FBE43F59146DA25370229D644162D", hash_generated_method = "449D50967D3C44E68E9D69DD7F9BFA95")
    
public static void readFully(InputStream in, byte[] dst) throws IOException {
        readFully(in, dst, 0, dst.length);
    }

    /**
     * Reads exactly 'byteCount' bytes from 'in' (into 'dst' at offset 'offset'), and throws
     * EOFException if insufficient bytes are available.
     *
     * Used to implement {@link java.io.DataInputStream#readFully(byte[], int, int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.766 -0500", hash_original_method = "3A7F8B01D1EB11BC96CA38F7132B96CD", hash_generated_method = "EB348D9E0E7BD5F4511607F7D25EB8A5")
    
public static void readFully(InputStream in, byte[] dst, int offset, int byteCount) throws IOException {
        if (byteCount == 0) {
            return;
        }
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        if (dst == null) {
            throw new NullPointerException("dst == null");
        }
        Arrays.checkOffsetAndCount(dst.length, offset, byteCount);
        while (byteCount > 0) {
            int bytesRead = in.read(dst, offset, byteCount);
            if (bytesRead < 0) {
                throw new EOFException();
            }
            offset += bytesRead;
            byteCount -= bytesRead;
        }
    }

    /**
     * Returns a byte[] containing the remainder of 'in', closing it when done.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.769 -0500", hash_original_method = "A9F8B5B0AC3E4C318EC1793646D70D6E", hash_generated_method = "AB5A4F9637989EE47AC99185BEB75E6F")
    
public static byte[] readFully(InputStream in) throws IOException {
        try {
            return readFullyNoClose(in);
        } finally {
            in.close();
        }
    }

    /**
     * Returns a byte[] containing the remainder of 'in'.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.772 -0500", hash_original_method = "778ABE3A69AA8FF60B65094F75FB879B", hash_generated_method = "D1720953CA111AD0C30DE369B4C6B058")
    
public static byte[] readFullyNoClose(InputStream in) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int count;
        while ((count = in.read(buffer)) != -1) {
            bytes.write(buffer, 0, count);
        }
        return bytes.toByteArray();
    }

    /**
     * Returns the remainder of 'reader' as a string, closing it when done.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.774 -0500", hash_original_method = "4E5704FEDE8F5CB4F4DD07601A88E91F", hash_generated_method = "03CA403F85885102137BFBAC5377436F")
    
public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter writer = new StringWriter();
            char[] buffer = new char[1024];
            int count;
            while ((count = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, count);
            }
            return writer.toString();
        } finally {
            reader.close();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.777 -0500", hash_original_method = "C2861931CE38B341D5997429997153A8", hash_generated_method = "C5BECFC39321D99642E1747E51F3DD77")
    
public static void skipAll(InputStream in) throws IOException {
        do {
            in.skip(Long.MAX_VALUE);
        } while (in.read() != -1);
    }

    /**
     * Call {@code in.read()} repeatedly until either the stream is exhausted or
     * {@code byteCount} bytes have been read.
     *
     * <p>This method reuses the skip buffer but is careful to never use it at
     * the same time that another stream is using it. Otherwise streams that use
     * the caller's buffer for consistency checks like CRC could be clobbered by
     * other threads. A thread-local buffer is also insufficient because some
     * streams may call other streams in their skip() method, also clobbering the
     * buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.780 -0500", hash_original_method = "5CB9B9CD233E20FC52735AD417089027", hash_generated_method = "4B50BB7B32A5606ECE9D9E4A4CCD1C85")
    
public static long skipByReading(InputStream in, long byteCount) throws IOException {
        // acquire the shared skip buffer.
        byte[] buffer = skipBuffer.getAndSet(null);
        if (buffer == null) {
            buffer = new byte[4096];
        }

        long skipped = 0;
        while (skipped < byteCount) {
            int toRead = (int) Math.min(byteCount - skipped, buffer.length);
            int read = in.read(buffer, 0, toRead);
            if (read == -1) {
                break;
            }
            skipped += read;
            if (read < toRead) {
                break;
            }
        }

        // release the shared skip buffer.
        skipBuffer.set(buffer);

        return skipped;
    }

    /**
     * Copies all of the bytes from {@code in} to {@code out}. Neither stream is closed.
     * Returns the total number of bytes transferred.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.783 -0500", hash_original_method = "84261C86365A1E69BA24A6D8C01BF1E2", hash_generated_method = "977B6E2AF6C8CAAF351E987CAF8FE4D7")
    
public static int copy(InputStream in, OutputStream out) throws IOException {
        int total = 0;
        byte[] buffer = new byte[8192];
        int c;
        while ((c = in.read(buffer)) != -1) {
            total += c;
            out.write(buffer, 0, c);
        }
        return total;
    }

    /**
     * Returns the ASCII characters up to but not including the next "\r\n", or
     * "\n".
     *
     * @throws java.io.EOFException if the stream is exhausted before the next newline
     *     character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.785 -0500", hash_original_method = "109E9B4E15544A79F6C06A99B1C7962C", hash_generated_method = "F8A29B37E60DA9F012391F770E71A270")
    
public static String readAsciiLine(InputStream in) throws IOException {
        // TODO: support UTF-8 here instead

        StringBuilder result = new StringBuilder(80);
        while (true) {
            int c = in.read();
            if (c == -1) {
                throw new EOFException();
            } else if (c == '\n') {
                break;
            }

            result.append((char) c);
        }
        int length = result.length();
        if (length > 0 && result.charAt(length - 1) == '\r') {
            result.setLength(length - 1);
        }
        return result.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.753 -0500", hash_original_field = "BC4E566FC02FEB5BAB3223E68C61F7C4", hash_generated_field = "A1B1A5BE6021D69F6851622BFC79A5B3")

    private static AtomicReference<byte[]> skipBuffer = new AtomicReference<byte[]>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.756 -0500", hash_original_method = "C77AFB36715A9D022AA555F8E2CA0E65", hash_generated_method = "AF0F5237329DC5D339267768437D298E")
    
private Streams() {}
}

