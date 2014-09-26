package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class PushbackInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.544 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.546 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;

    /**
     * Constructs a new {@code PushbackInputStream} with the specified input
     * stream as source. The size of the pushback buffer is set to the default
     * value of 1 byte.
     *
     * <p><strong>Warning:</strong> passing a null source creates an invalid
     * {@code PushbackInputStream}. All read operations on such a stream will
     * fail.
     *
     * @param in
     *            the source input stream.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.549 -0500", hash_original_method = "AC9553B1FAFFB4A8FBFF65B03BBACC5E", hash_generated_method = "D360854ACE2AA0CA85C5491A466A340C")
    
public PushbackInputStream(InputStream in) {
        super(in);
        buf = (in == null) ? null : new byte[1];
        pos = 1;
    }

    /**
     * Constructs a new {@code PushbackInputStream} with {@code in} as source
     * input stream. The size of the pushback buffer is set to {@code size}.
     *
     * <p><strong>Warning:</strong> passing a null source creates an invalid
     * {@code PushbackInputStream}. All read operations on such a stream will
     * fail.
     *
     * @param in
     *            the source input stream.
     * @param size
     *            the size of the pushback buffer.
     * @throws IllegalArgumentException
     *             if {@code size} is negative.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.552 -0500", hash_original_method = "5FC607CA483EF0D15EF5263D4BBC83BA", hash_generated_method = "CA99E296F05811C04CC8506980310862")
    
public PushbackInputStream(InputStream in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        buf = (in == null) ? null : new byte[size];
        pos = size;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.555 -0500", hash_original_method = "446E244C062F8716B384D306C558B705", hash_generated_method = "70B65E77014A2AD13CE7E13AC69CAE3A")
    
@Override
    public int available() throws IOException {
        if (buf == null) {
            throw new IOException();
        }
        return buf.length - pos + in.available();
    }

    /**
     * Closes this stream. This implementation closes the source stream
     * and releases the pushback buffer.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.557 -0500", hash_original_method = "74DA7764B5809B26A354DD7668DF4A77", hash_generated_method = "E8F8B044021BD44FB7B4A0DB83968990")
    
@Override
    public void close() throws IOException {
        if (in != null) {
            in.close();
            in = null;
            buf = null;
        }
    }

    /**
     * Indicates whether this stream supports the {@code mark(int)} and
     * {@code reset()} methods. {@code PushbackInputStream} does not support
     * them, so it returns {@code false}.
     *
     * @return always {@code false}.
     * @see #mark(int)
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.560 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "98834879561C7504F012DD22F86DCE30")
    
@Override
    public boolean markSupported() {
        return false;
    }

    /**
     * Reads a single byte from this stream and returns it as an integer in the
     * range from 0 to 255. If the pushback buffer does not contain any
     * available bytes then a byte from the source input stream is returned.
     * Blocks until one byte has been read, the end of the source stream is
     * detected or an exception is thrown.
     *
     * @return the byte read or -1 if the end of the source stream has been
     *         reached.
     * @throws IOException
     *             if this stream is closed or an I/O error occurs while reading
     *             from this stream.
     */
    @DSSource({DSSourceKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.563 -0500", hash_original_method = "146BBECA823F7801A366293B4A5C7497", hash_generated_method = "ABC96A72A8ADD58AE2E0786F9FC8E24B")
    
@Override
    public int read() throws IOException {
        if (buf == null) {
            throw new IOException();
        }
        // Is there a pushback byte available?
        if (pos < buf.length) {
            return (buf[pos++] & 0xFF);
        }
        // Assume read() in the InputStream will return low-order byte or -1
        // if end of stream.
        return in.read();
    }

    /**
     * Reads at most {@code length} bytes from this stream and stores them in
     * the byte array {@code buffer} starting at {@code offset}. Bytes are read
     * from the pushback buffer first, then from the source stream if more bytes
     * are required. Blocks until {@code count} bytes have been read, the end of
     * the source stream is detected or an exception is thrown.
     *
     * @param buffer
     *            the array in which to store the bytes read from this stream.
     * @param offset
     *            the initial position in {@code buffer} to store the bytes read
     *            from this stream.
     * @param length
     *            the maximum number of bytes to store in {@code buffer}.
     * @return the number of bytes read or -1 if the end of the source stream
     *         has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the length of
     *             {@code buffer}.
     * @throws IOException
     *             if this stream is closed or another I/O error occurs while
     *             reading from this stream.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     */
    @DSSource({DSSourceKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.566 -0500", hash_original_method = "1B53276B26E96C9AEFE2F3C951EF5EAE", hash_generated_method = "8166BEB41CDADC014E3C1918E6FB3725")
    
@Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        if (buf == null) {
            throw streamClosed();
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        int copiedBytes = 0, copyLength = 0, newOffset = offset;
        // Are there pushback bytes available?
        if (pos < buf.length) {
            copyLength = (buf.length - pos >= length) ? length : buf.length
                    - pos;
            System.arraycopy(buf, pos, buffer, newOffset, copyLength);
            newOffset += copyLength;
            copiedBytes += copyLength;
            // Use up the bytes in the local buffer
            pos += copyLength;
        }
        // Have we copied enough?
        if (copyLength == length) {
            return length;
        }
        int inCopied = in.read(buffer, newOffset, length - copiedBytes);
        if (inCopied > 0) {
            return inCopied + copiedBytes;
        }
        if (copiedBytes == 0) {
            return inCopied;
        }
        return copiedBytes;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.568 -0500", hash_original_method = "2E2FBA951DCC3C9DB1EDAE98D88B8EBD", hash_generated_method = "69313A2FE135E1A632378547FD715C13")
    
private IOException streamClosed() throws IOException  {
        throw new IOException("PushbackInputStream is closed");
    }

    /**
     * Skips {@code byteCount} bytes in this stream. This implementation skips bytes
     * in the pushback buffer first and then in the source stream if necessary.
     *
     * @return the number of bytes actually skipped.
     * @throws IOException
     *             if this stream is closed or another I/O error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.570 -0500", hash_original_method = "640B22F7B00DCEA150CE7BE86C25A8AB", hash_generated_method = "5943182388EB20F5DDA697A803583DA5")
    
@Override
    public long skip(long byteCount) throws IOException {
        if (in == null) {
            throw streamClosed();
        }
        if (byteCount <= 0) {
            return 0;
        }
        int numSkipped = 0;
        if (pos < buf.length) {
            numSkipped += (byteCount < buf.length - pos) ? byteCount : buf.length - pos;
            pos += numSkipped;
        }
        if (numSkipped < byteCount) {
            numSkipped += in.skip(byteCount - numSkipped);
        }
        return numSkipped;
    }

    /**
     * Pushes all the bytes in {@code buffer} back to this stream. The bytes are
     * pushed back in such a way that the next byte read from this stream is
     * buffer[0], then buffer[1] and so on.
     * <p>
     * If this stream's internal pushback buffer cannot store the entire
     * contents of {@code buffer}, an {@code IOException} is thrown. Parts of
     * {@code buffer} may have already been copied to the pushback buffer when
     * the exception is thrown.
     *
     * @param buffer
     *            the buffer containing the bytes to push back to this stream.
     * @throws IOException
     *             if the free space in the internal pushback buffer is not
     *             sufficient to store the contents of {@code buffer}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.573 -0500", hash_original_method = "C8192A3011924069F2B71E7D3088F3DC", hash_generated_method = "E3B26592E9220AEE0471A023816C1918")
   @DSSpec(DSCat.IO)
public void unread(byte[] buffer) throws IOException {
        unread(buffer, 0, buffer.length);
    }

    /**
     * Pushes a subset of the bytes in {@code buffer} back to this stream. The
     * subset is defined by the start position {@code offset} within
     * {@code buffer} and the number of bytes specified by {@code length}. The
     * bytes are pushed back in such a way that the next byte read from this
     * stream is {@code buffer[offset]}, then {@code buffer[1]} and so on.
     * <p>
     * If this stream's internal pushback buffer cannot store the selected
     * subset of {@code buffer}, an {@code IOException} is thrown. Parts of
     * {@code buffer} may have already been copied to the pushback buffer when
     * the exception is thrown.
     *
     * @param buffer
     *            the buffer containing the bytes to push back to this stream.
     * @param offset
     *            the index of the first byte in {@code buffer} to push back.
     * @param length
     *            the number of bytes to push back.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the length of
     *             {@code buffer}.
     * @throws IOException
     *             if the free space in the internal pushback buffer is not
     *             sufficient to store the selected contents of {@code buffer}.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.575 -0500", hash_original_method = "DF65BDEADDE37C8EC8A6D2405E9B2E68", hash_generated_method = "9CAD033DFC15BA84921E61D8ED94391D")
    
public void unread(byte[] buffer, int offset, int length) throws IOException {
        if (length > pos) {
            throw new IOException("Pushback buffer full");
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        if (buf == null) {
            throw streamClosed();
        }

        System.arraycopy(buffer, offset, buf, pos - length, length);
        pos = pos - length;
    }

    /**
     * Pushes the specified byte {@code oneByte} back to this stream. Only the
     * least significant byte of the integer {@code oneByte} is pushed back.
     * This is done in such a way that the next byte read from this stream is
     * {@code (byte) oneByte}.
     * <p>
     * If this stream's internal pushback buffer cannot store the byte, an
     * {@code IOException} is thrown.
     *
     * @param oneByte
     *            the byte to push back to this stream.
     * @throws IOException
     *             if this stream is closed or the internal pushback buffer is
     *             full.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.578 -0500", hash_original_method = "98848F28DD25FD585D8212E035CA9267", hash_generated_method = "BA3E56535EE8E6396EAC1C1F27A9326F")
    
public void unread(int oneByte) throws IOException {
        if (buf == null) {
            throw new IOException();
        }
        if (pos == 0) {
            throw new IOException("Pushback buffer full");
        }
        buf[--pos] = (byte) oneByte;
    }

    /**
     * Marks the current position in this stream. Setting a mark is not
     * supported in this class; this implementation does nothing.
     *
     * @param readlimit
     *            the number of bytes that can be read from this stream before
     *            the mark is invalidated; this parameter is ignored.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.580 -0500", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "3661B9E6F99225CA9976B419D6E2DE03")
    
@Override public void mark(int readlimit) {
    }

    /**
     * Resets this stream to the last marked position. Resetting the stream is
     * not supported in this class; this implementation always throws an
     * {@code IOException}.
     *
     * @throws IOException
     *             if this method is called.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.583 -0500", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "982040414CDBED77657D44B5E5A8ACAA")
    
@Override
    public void reset() throws IOException {
        throw new IOException();
    }
    
}

