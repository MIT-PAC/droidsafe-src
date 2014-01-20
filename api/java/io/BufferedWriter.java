package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

import libcore.util.SneakyThrow;

public class BufferedWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.393 -0500", hash_original_field = "EBCE22DD0E30FF0E4040ABB2E7F29C97", hash_generated_field = "0251D9C19BD1379B95D6A9A5D4A8C80D")

    private Writer out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.396 -0500", hash_original_field = "40514AFF00B14ABD40D54C723F22A0B4", hash_generated_field = "29466223C47F8B8BB1DFDB9869023C70")

    private char[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.398 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;

    /**
     * Constructs a new {@code BufferedWriter}, providing {@code out} with a buffer
     * of 8192 bytes.
     *
     * @param out the {@code Writer} the buffer writes to.
     */
    @DSComment("Spec is marked when opening raw stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.401 -0500", hash_original_method = "D0AF799B17153797A8965CAE82858C8B", hash_generated_method = "FAED49220CE1BA4E9A3247C527651C59")
    
public BufferedWriter(Writer out) {
        this(out, 8192);
    }

    /**
     * Constructs a new {@code BufferedWriter}, providing {@code out} with {@code size} bytes
     * of buffer.
     *
     * @param out the {@code OutputStream} the buffer writes to.
     * @param size the size of buffer in bytes.
     * @throws IllegalArgumentException if {@code size <= 0}.
     */
    @DSComment("Spec is marked when opening raw stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.404 -0500", hash_original_method = "BD90CD6D32AE7EB9B6CCE31F3688E0F2", hash_generated_method = "F1E03926A4E3DA844CAF0FC8D59F2B35")
    
public BufferedWriter(Writer out, int size) {
        super(out);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.out = out;
        this.buf = new char[size];
    }

    /**
     * Closes this writer. The contents of the buffer are flushed, the target
     * writer is closed, and the buffer is released. Only the first invocation
     * of close has any effect.
     *
     * @throws IOException
     *             if an error occurs while closing this writer.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.407 -0500", hash_original_method = "1FFBADE50F933DAEBE6B8AB97A0787F1", hash_generated_method = "127F1A20360C713C7F1AB5B9AF7B63D3")
    
@Override
    public void close() throws IOException {
        synchronized (lock) {
            if (isClosed()) {
                return;
            }

            Throwable thrown = null;
            try {
                flushInternal();
            } catch (Throwable e) {
                thrown = e;
            }
            buf = null;

            try {
                out.close();
            } catch (Throwable e) {
                if (thrown == null) {
                    thrown = e;
                }
            }
            out = null;

            if (thrown != null) {
                SneakyThrow.sneakyThrow(thrown);
            }
        }
    }

    /**
     * Flushes this writer. The contents of the buffer are committed to the
     * target writer and it is then flushed.
     *
     * @throws IOException
     *             if an error occurs while flushing this writer.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.410 -0500", hash_original_method = "CDBC99BDF3D706FE5CF6000E4273C9D9", hash_generated_method = "EE62E3FF899BD2828946937B2BAF16E5")
    
@Override
    public void flush() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            flushInternal();
            out.flush();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.413 -0500", hash_original_method = "023D06F961F755F2334356A83B61D7A7", hash_generated_method = "5E7823C8E0E8B576442E72FE23F39A88")
    
private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("BufferedWriter is closed");
        }
    }

    /**
     * Flushes the internal buffer.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.415 -0500", hash_original_method = "56ED8A50252CAA4A163E554237CE5ACA", hash_generated_method = "44F53CF6742339CE56733D4953AB5880")
    
private void flushInternal() throws IOException {
        if (pos > 0) {
            out.write(buf, 0, pos);
        }
        pos = 0;
    }

    /**
     * Indicates whether this writer is closed.
     *
     * @return {@code true} if this writer is closed, {@code false} otherwise.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.418 -0500", hash_original_method = "65F785E5C7A072182DBDFA4385D9D27B", hash_generated_method = "49B5D6BDDF3744E41E97B3326CF144AB")
    
private boolean isClosed() {
        return out == null;
    }

    /**
     * Writes a newline to this writer. On Android, this is {@code "\n"}.
     * The target writer may or may not be flushed when a newline is written.
     *
     * @throws IOException
     *             if an error occurs attempting to write to this writer.
     */
    @DSComment("new info makes to destination")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.420 -0500", hash_original_method = "2B3D7D602A7E63B6C09E849C2D681C65", hash_generated_method = "3A13DB33FEE4E58AA5B65F7DD55F0264")
    
public void newLine() throws IOException {
        write(System.lineSeparator());
    }

    /**
     * Writes {@code count} characters starting at {@code offset} in
     * {@code cbuf} to this writer. If {@code count} is greater than this
     * writer's buffer, then the buffer is flushed and the characters are
     * written directly to the target writer.
     *
     * @param cbuf
     *            the array containing characters to write.
     * @param offset
     *            the start position in {@code cbuf} for retrieving characters.
     * @param count
     *            the maximum number of characters to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is greater than the size of
     *             {@code cbuf}.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.424 -0500", hash_original_method = "2ACD1A4D73C211D3299604BDD7AD25D9", hash_generated_method = "210CE2FA3BEB7A9654223F17CE4CC4B5")
    
@Override
    public void write(char[] cbuf, int offset, int count) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (cbuf == null) {
                throw new NullPointerException("buffer == null");
            }
            Arrays.checkOffsetAndCount(cbuf.length, offset, count);
            if (pos == 0 && count >= this.buf.length) {
                out.write(cbuf, offset, count);
                return;
            }
            int available = this.buf.length - pos;
            if (count < available) {
                available = count;
            }
            if (available > 0) {
                System.arraycopy(cbuf, offset, this.buf, pos, available);
                pos += available;
            }
            if (pos == this.buf.length) {
                out.write(this.buf, 0, this.buf.length);
                pos = 0;
                if (count > available) {
                    offset += available;
                    available = count - available;
                    if (available >= this.buf.length) {
                        out.write(cbuf, offset, available);
                        return;
                    }

                    System.arraycopy(cbuf, offset, this.buf, pos, available);
                    pos += available;
                }
            }
        }
    }

    /**
     * Writes the character {@code oneChar} to this writer. If the buffer
     * gets full by writing this character, this writer is flushed. Only the
     * lower two bytes of the integer {@code oneChar} are written.
     *
     * @param oneChar
     *            the character to write.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.427 -0500", hash_original_method = "C57AC7B5490B3E246FD3E407701AE232", hash_generated_method = "5754A8963C9C380CBB2742943A30E3F9")
    
@Override
    public void write(int oneChar) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (pos >= buf.length) {
                out.write(buf, 0, buf.length);
                pos = 0;
            }
            buf[pos++] = (char) oneChar;
        }
    }

    /**
     * Writes {@code count} characters starting at {@code offset} in {@code str}
     * to this writer. If {@code count} is greater than this writer's buffer,
     * then this writer is flushed and the remaining characters are written
     * directly to the target writer. If count is negative no characters are
     * written to the buffer. This differs from the behavior of the superclass.
     *
     * @param str
     *            the non-null String containing characters to write.
     * @param offset
     *            the start position in {@code str} for retrieving characters.
     * @param count
     *            maximum number of characters to write.
     * @throws IOException
     *             if this writer has already been closed or another I/O error
     *             occurs.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code offset + count} is greater
     *             than the length of {@code str}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.432 -0500", hash_original_method = "AE740E7607559E2B849C6855BC31C773", hash_generated_method = "CC19827EBE9A9C4E7EA3C6B136BC89B1")
    
@Override
    public void write(String str, int offset, int count) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (count <= 0) {
                return;
            }
            if (offset < 0 || offset > str.length() - count) {
                throw new StringIndexOutOfBoundsException(str, offset, count);
            }
            if (pos == 0 && count >= buf.length) {
                char[] chars = new char[count];
                str.getChars(offset, offset + count, chars, 0);
                out.write(chars, 0, count);
                return;
            }
            int available = buf.length - pos;
            if (count < available) {
                available = count;
            }
            if (available > 0) {
                str.getChars(offset, offset + available, buf, pos);
                pos += available;
            }
            if (pos == buf.length) {
                out.write(this.buf, 0, this.buf.length);
                pos = 0;
                if (count > available) {
                    offset += available;
                    available = count - available;
                    if (available >= buf.length) {
                        char[] chars = new char[count];
                        str.getChars(offset, offset + available, chars, 0);
                        out.write(chars, 0, available);
                        return;
                    }
                    str.getChars(offset, offset + available, buf, pos);
                    pos += available;
                }
            }
        }
    }
    
}

