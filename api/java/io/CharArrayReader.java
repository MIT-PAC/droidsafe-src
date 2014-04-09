package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class CharArrayReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.608 -0500", hash_original_field = "40514AFF00B14ABD40D54C723F22A0B4", hash_generated_field = "F3184E7FC423A3DB65CA949884DB59BD")

    protected char[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.611 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.614 -0500", hash_original_field = "A493E715019DE33A6D249A1FBAD22F2F", hash_generated_field = "1DA4646E2C60EE9C934D6CF17180F1D1")

    protected int markedPos = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.616 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;

    /**
     * Constructs a CharArrayReader on the char array {@code buf}. The size of
     * the reader is set to the length of the buffer and the object to to read
     * from is set to {@code buf}.
     *
     * @param buf
     *            the char array from which to read.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.619 -0500", hash_original_method = "6DA04233D2F41366A5B785CAFAB5785D", hash_generated_method = "5548F526C166AF95111D29EB16A551B3")
    
public CharArrayReader(char[] buf) {
        this.buf = buf;
        this.count = buf.length;
    }

    /**
     * Constructs a CharArrayReader on the char array {@code buf}. The size of
     * the reader is set to {@code length} and the start position from which to
     * read the buffer is set to {@code offset}.
     *
     * @param buf
     *            the char array from which to read.
     * @param offset
     *            the index of the first character in {@code buf} to read.
     * @param length
     *            the number of characters that can be read from {@code buf}.
     * @throws IllegalArgumentException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset} is greater than the size of {@code buf} .
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.622 -0500", hash_original_method = "1EBD72186921B7C86A5F89F0B57C5DD7", hash_generated_method = "A19EA670BDEA387D054A5F82A65C8D47")
    
public CharArrayReader(char[] buf, int offset, int length) {
        /*
         * The spec of this constructor is broken. In defining the legal values
         * of offset and length, it doesn't consider buffer's length. And to be
         * compatible with the broken spec, we must also test whether
         * (offset + length) overflows.
         */
        if (offset < 0 || offset > buf.length || length < 0 || offset + length < 0) {
            throw new IllegalArgumentException();
        }
        this.buf = buf;
        this.pos = offset;
        this.markedPos = offset;

        /* This is according to spec */
        int bufferLength = buf.length;
        this.count = offset + length < bufferLength ? length : bufferLength;
    }

    /**
     * This method closes this CharArrayReader. Once it is closed, you can no
     * longer read from it. Only the first invocation of this method has any
     * effect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.624 -0500", hash_original_method = "D1485373461621933BC43F45AD6A923E", hash_generated_method = "0EFF8C92C50C1B5DB93451D6413713EA")
    
@Override
    public void close() {
        synchronized (lock) {
            if (isOpen()) {
                buf = null;
            }
        }
    }

    /**
     * Indicates whether this reader is open.
     *
     * @return {@code true} if the reader is open, {@code false} otherwise.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.627 -0500", hash_original_method = "F0DC6C1F8DBE67146FDB19D4375AE051", hash_generated_method = "7D3E0CB9D461E3294FC5AE0F436AD4DE")
    
private boolean isOpen() {
        //return buf != null;
        return buf.getTaintBoolean();
    }

    /**
     * Indicates whether this reader is closed.
     *
     * @return {@code true} if the reader is closed, {@code false} otherwise.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.629 -0500", hash_original_method = "1E545822701FEAEF52AB68BFB73351A8", hash_generated_method = "67B0DB4F7332E1551B3772D6F1B4F707")
    
private boolean isClosed() {
        //return buf == null;
        return buf.getTaintBoolean();
    }

    /**
     * Sets a mark position in this reader. The parameter {@code readLimit} is
     * ignored for CharArrayReaders. Calling {@code reset()} will reposition the
     * reader back to the marked position provided the mark has not been
     * invalidated.
     *
     * @param readLimit
     *            ignored for CharArrayReaders.
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.631 -0500", hash_original_method = "364865576D00D1903D5FAEF3F67610B8", hash_generated_method = "36EE61A1D02AB8888D1A40A074AC6758")
    
@Override
    public void mark(int readLimit) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            markedPos = pos;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.634 -0500", hash_original_method = "DD3D03D90C3AA2556C16493577BC59FF", hash_generated_method = "604F415A4F07E5ADEAE4F0C01CDF5D68")
    
private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("CharArrayReader is closed");
        }
    }

    /**
     * Indicates whether this reader supports the {@code mark()} and
     * {@code reset()} methods.
     *
     * @return {@code true} for CharArrayReader.
     * @see #mark(int)
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.636 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
    
@Override
    public boolean markSupported() {
        return true;
    }

    /**
     * Reads a single character from this reader and returns it as an integer
     * with the two higher-order bytes set to 0. Returns -1 if no more
     * characters are available from this reader.
     *
     * @return the character read as an int or -1 if the end of the reader has
     *         been reached.
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.639 -0500", hash_original_method = "81B0DFE29130C0DF55A1485815BBFE58", hash_generated_method = "2E4A91C77885F6A2D94903B9A8579026")
    
@Override
    public int read() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (pos == count) {
                return -1;
            }
            return buf[pos++];
        }
    }

    /**
     * Reads at most {@code count} characters from this CharArrayReader and
     * stores them at {@code offset} in the character array {@code buf}.
     * Returns the number of characters actually read or -1 if the end of reader
     * was encountered.
     *
     * @param buffer
     *            the character array to store the characters read.
     * @param offset
     *            the initial position in {@code buffer} to store the characters
     *            read from this reader.
     * @param len
     *            the maximum number of characters to read.
     * @return number of characters read or -1 if the end of the reader has been
     *         reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code len < 0}, or if
     *             {@code offset + len} is bigger than the size of
     *             {@code buffer}.
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.642 -0500", hash_original_method = "D326846A8F32FE2907A115981466F659", hash_generated_method = "7649D3039C957740A4B1218A512321CB")
    
@Override
    public int read(char[] buffer, int offset, int len) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        synchronized (lock) {
            checkNotClosed();
            if (pos < this.count) {
                int bytesRead = pos + len > this.count ? this.count - pos : len;
                System.arraycopy(this.buf, pos, buffer, offset, bytesRead);
                pos += bytesRead;
                return bytesRead;
            }
            return -1;
        }
    }

    /**
     * Indicates whether this reader is ready to be read without blocking.
     * Returns {@code true} if the next {@code read} will not block. Returns
     * {@code false} if this reader may or may not block when {@code read} is
     * called. The implementation in CharArrayReader always returns {@code true}
     * even when it has been closed.
     *
     * @return {@code true} if this reader will not block when {@code read} is
     *         called, {@code false} if unknown or blocking will occur.
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.644 -0500", hash_original_method = "ACF01B5A9581EC6A7FB489059F8F6839", hash_generated_method = "40837C4522132137E81E153F73F4205C")
    
@Override
    public boolean ready() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            return toTaintBoolean(pos + count);
        }
    }

    /**
     * Resets this reader's position to the last {@code mark()} location.
     * Invocations of {@code read()} and {@code skip()} will occur from this new
     * location. If this reader has not been marked, it is reset to the
     * beginning of the string.
     *
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.646 -0500", hash_original_method = "8831F819121D6F1C65C36C6F61A61062", hash_generated_method = "6E38B5E8CAEA1723A8800C22D79464C7")
    
@Override
    public void reset() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            pos = markedPos != -1 ? markedPos : 0;
        }
    }

    /**
     * Skips {@code charCount} characters in this reader. Subsequent calls to
     * {@code read} will not return these characters unless {@code reset}
     * is used. This method does nothing and returns 0 if {@code charCount <= 0}.
     *
     * @return the number of characters actually skipped.
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.649 -0500", hash_original_method = "204384BC4BAAF8636F71AE068D63C20F", hash_generated_method = "2E80CFDB190C80238DA2DBA0445B572E")
    
@Override
    public long skip(long charCount) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (charCount <= 0) {
                return 0;
            }
            long skipped = 0;
            if (charCount < this.count - pos) {
                pos = pos + (int) charCount;
                skipped = charCount;
            } else {
                skipped = this.count - pos;
                pos = this.count;
            }
            return skipped;
        }
    }
    
}

