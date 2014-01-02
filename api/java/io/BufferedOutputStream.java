package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;




public class BufferedOutputStream extends FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.484 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.486 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;

    /**
     * Constructs a new {@code BufferedOutputStream}, providing {@code out} with a buffer
     * of 8192 bytes.
     *
     * @param out the {@code OutputStream} the buffer writes to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.489 -0500", hash_original_method = "D896F62F17EBF4CCE50C0B823DA78DD6", hash_generated_method = "1DC2D67667A8AA777FEE99B1E87967D5")
    
public BufferedOutputStream(OutputStream out) {
        this(out, 8192);
    }

    /**
     * Constructs a new {@code BufferedOutputStream}, providing {@code out} with {@code size} bytes
     * of buffer.
     *
     * @param out the {@code OutputStream} the buffer writes to.
     * @param size the size of buffer in bytes.
     * @throws IllegalArgumentException if {@code size <= 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.492 -0500", hash_original_method = "D77D548D42DBDD230976FC72C0A9CFDA", hash_generated_method = "4153D9D5D4726C88F7425CFB042587B2")
    
public BufferedOutputStream(OutputStream out, int size) {
        super(out);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        buf = new byte[size];
    }

    /**
     * Flushes this stream to ensure all pending data is written out to the
     * target stream. In addition, the target stream is flushed.
     *
     * @throws IOException
     *             if an error occurs attempting to flush this stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.494 -0500", hash_original_method = "1ACC3FF49FD09C78DA86C982A642A64A", hash_generated_method = "5F360D27F21F0CD30A4027B4D00D5D92")
    
@Override
    public synchronized void flush() throws IOException {
        checkNotClosed();
        flushInternal();
        out.flush();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.497 -0500", hash_original_method = "E23D99313D714FF4FE33BC33C5A12E3B", hash_generated_method = "C56C442DA552754F9DA28F48FD22AD21")
    
private void checkNotClosed() throws IOException {
        if (buf == null) {
            throw new IOException("BufferedOutputStream is closed");
        }
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * {@code offset} to this stream. If there is room in the buffer to hold the
     * bytes, they are copied in. If not, the buffered bytes plus the bytes in
     * {@code buffer} are written to the target stream, the target is flushed,
     * and the buffer is cleared.
     *
     * @param buffer
     *            the buffer to be written.
     * @param offset
     *            the start position in {@code buffer} from where to get bytes.
     * @param length
     *            the number of bytes from {@code buffer} to write to this
     *            stream.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the size of
     *             {@code buffer}.
     * @throws IOException
     *             if an error occurs attempting to write to this stream.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     * @throws ArrayIndexOutOfBoundsException
     *             If offset or count is outside of bounds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.500 -0500", hash_original_method = "EC14898AF1C6D500DEF61C098384315C", hash_generated_method = "0A30862E0D81C221231B60E443A2F762")
    
@Override
    public synchronized void write(byte[] buffer, int offset, int length) throws IOException {
        checkNotClosed();

        if (buffer == null) {
            throw new NullPointerException("buffer == null");
        }

        byte[] internalBuffer = buf;
        if (length >= internalBuffer.length) {
            flushInternal();
            out.write(buffer, offset, length);
            return;
        }

        Arrays.checkOffsetAndCount(buffer.length, offset, length);

        // flush the internal buffer first if we have not enough space left
        if (length > (internalBuffer.length - count)) {
            flushInternal();
        }

        System.arraycopy(buffer, offset, internalBuffer, count, length);
        count += length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.503 -0500", hash_original_method = "C551C170B690A76D4989DEC0BC19E3FB", hash_generated_method = "3506112C9F3C134E3AB9692AB87518B8")
    
@Override public synchronized void close() throws IOException {
        if (buf == null) {
            return;
        }

        try {
            super.close();
        } finally {
            buf = null;
        }
    }

    /**
     * Writes one byte to this stream. Only the low order byte of the integer
     * {@code oneByte} is written. If there is room in the buffer, the byte is
     * copied into the buffer and the count incremented. Otherwise, the buffer
     * plus {@code oneByte} are written to the target stream, the target is
     * flushed, and the buffer is reset.
     *
     * @param oneByte
     *            the byte to be written.
     * @throws IOException
     *             if an error occurs attempting to write to this stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.505 -0500", hash_original_method = "45333A97ED5F96C22A3D88C235B79D5A", hash_generated_method = "5AA7A43BC98370BA14A74751C65BA048")
    
@Override
    public synchronized void write(int oneByte) throws IOException {
        checkNotClosed();
        if (count == buf.length) {
            out.write(buf, 0, count);
            count = 0;
        }
        buf[count++] = (byte) oneByte;
    }

    /**
     * Flushes only internal buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.507 -0500", hash_original_method = "AAC3F75032624F788E22A2E407A017DD", hash_generated_method = "B242174C9AD2D547970527CEFEA5B484")
    
private void flushInternal() throws IOException {
        if (count > 0) {
            out.write(buf, 0, count);
            count = 0;
        }
    }

    
}

