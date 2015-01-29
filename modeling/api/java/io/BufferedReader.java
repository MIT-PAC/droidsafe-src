package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class BufferedReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.770 -0500", hash_original_field = "905D4A99F191C55F09924512539E6D8F", hash_generated_field = "D82948BDB5B1A4AE5A3AFAB6DC9986E6")

    private Reader in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.772 -0500", hash_original_field = "40514AFF00B14ABD40D54C723F22A0B4", hash_generated_field = "29466223C47F8B8BB1DFDB9869023C70")

    private char[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.775 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.777 -0500", hash_original_field = "302E5A3147803830441A79AED31F4022", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.780 -0500", hash_original_field = "0000817AC2603B47AF2835983C585870", hash_generated_field = "7486F438FD6BACD8803ADD46E32EFC8C")

    private int mark = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.782 -0500", hash_original_field = "75A2423C827798DC27E81DD12A7578BB", hash_generated_field = "D78FB5CB883E6ED18FF304428EA74785")

    private int markLimit = -1;

    /**
     * Constructs a new {@code BufferedReader}, providing {@code in} with a buffer
     * of 8192 characters.
     *
     * @param in the {@code Reader} the buffer reads from.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.785 -0500", hash_original_method = "942CB30D704BB0D453BC7285AF3F8F63", hash_generated_method = "C875FF71AF33FE067958C813F8D30031")
    
public BufferedReader(Reader in) {
        this(in, 8192);
    }

    /**
     * Constructs a new {@code BufferedReader}, providing {@code in} with {@code size} characters
     * of buffer.
     *
     * @param in the {@code InputStream} the buffer reads from.
     * @param size the size of buffer in characters.
     * @throws IllegalArgumentException if {@code size <= 0}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.788 -0500", hash_original_method = "14FDA92282030C83FA853ED51BF21EF3", hash_generated_method = "606113C73DB54594A0B938E27DBC855E")
    
public BufferedReader(Reader in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.in = in;
        buf = new char[size];
    }

    /**
     * Closes this reader. This implementation closes the buffered source reader
     * and releases the buffer. Nothing is done if this reader has already been
     * closed.
     *
     * @throws IOException
     *             if an error occurs while closing this reader.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.790 -0500", hash_original_method = "B09EB233D31BD7460B333EC44F947FB5", hash_generated_method = "E7CB9BC1806291A715CC7DD98DB83FD9")
    
@Override
    public void close() throws IOException {
        synchronized (lock) {
            if (!isClosed()) {
                in.close();
                buf = null;
            }
        }
    }

    /**
     * Populates the buffer with data. It is an error to call this method when
     * the buffer still contains data; ie. if {@code pos < end}.
     *
     * @return the number of bytes read into the buffer, or -1 if the end of the
     *      source stream has been reached.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.793 -0500", hash_original_method = "CF9579814E96BB14759649D94186035A", hash_generated_method = "A5B09B701CF70EC579E890FDD3F967A4")
    
private int fillBuf() throws IOException {
        // assert(pos == end);

        if (mark == -1 || (pos - mark >= markLimit)) {
            /* mark isn't set or has exceeded its limit. use the whole buffer */
            int result = in.read(buf, 0, buf.length);
            if (result > 0) {
                mark = -1;
                pos = 0;
                end = result;
            }
            return result;
        }

        if (mark == 0 && markLimit > buf.length) {
            /* the only way to make room when mark=0 is by growing the buffer */
            int newLength = buf.length * 2;
            if (newLength > markLimit) {
                newLength = markLimit;
            }
            char[] newbuf = new char[newLength];
            System.arraycopy(buf, 0, newbuf, 0, buf.length);
            buf = newbuf;
        } else if (mark > 0) {
            /* make room by shifting the buffered data to left mark positions */
            System.arraycopy(buf, mark, buf, 0, buf.length - mark);
            pos -= mark;
            end -= mark;
            mark = 0;
        }

        /* Set the new position and mark position */
        int count = in.read(buf, pos, buf.length - pos);
        if (count != -1) {
            end += count;
        }
        return count;
    }

    /**
     * Indicates whether or not this reader is closed.
     *
     * @return {@code true} if this reader is closed, {@code false}
     *         otherwise.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.797 -0500", hash_original_method = "1E545822701FEAEF52AB68BFB73351A8", hash_generated_method = "67B0DB4F7332E1551B3772D6F1B4F707")
    
private boolean isClosed() {
        //return buf == null;
        return buf.getTaintBoolean();
    }

    /**
     * Sets a mark position in this reader. The parameter {@code markLimit}
     * indicates how many characters can be read before the mark is invalidated.
     * Calling {@code reset()} will reposition the reader back to the marked
     * position if {@code markLimit} has not been surpassed.
     *
     * @param markLimit
     *            the number of characters that can be read before the mark is
     *            invalidated.
     * @throws IllegalArgumentException
     *             if {@code markLimit < 0}.
     * @throws IOException
     *             if an error occurs while setting a mark in this reader.
     * @see #markSupported()
     * @see #reset()
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.799 -0500", hash_original_method = "EDD7C6600C30549E606135C51354C55D", hash_generated_method = "CAABEFE942DFA274FF2672C1771C1A9C")
    
@Override
    public void mark(int markLimit) throws IOException {
        if (markLimit < 0) {
            throw new IllegalArgumentException();
        }
        synchronized (lock) {
            checkNotClosed();
            this.markLimit = markLimit;
            mark = pos;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.801 -0500", hash_original_method = "DB9CD04B651C70299E4D82CCA50FA441", hash_generated_method = "9DDB8F58B4353B4CA656716199D36B12")
    
private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("BufferedReader is closed");
        }
    }

    /**
     * Indicates whether this reader supports the {@code mark()} and
     * {@code reset()} methods. This implementation returns {@code true}.
     *
     * @return {@code true} for {@code BufferedReader}.
     * @see #mark(int)
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.804 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
    
@Override
    public boolean markSupported() {
        return true;
    }

    /**
     * Reads a single character from this reader and returns it with the two
     * higher-order bytes set to 0. If possible, BufferedReader returns a
     * character from the buffer. If there are no characters available in the
     * buffer, it fills the buffer and then returns a character. It returns -1
     * if there are no more characters in the source reader.
     *
     * @return the character read or -1 if the end of the source reader has been
     *         reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSSource({DSSourceKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.807 -0500", hash_original_method = "434E790CE8DCEADB6D081C3AE915A829", hash_generated_method = "BD51F80B0E1483CC290DA4C926697DD8")
    
@Override
    public int read() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            /* Are there buffered characters available? */
            if (pos < end || fillBuf() != -1) {
                return buf[pos++];
            }
            return -1;
        }
    }

    /**
     * Reads at most {@code length} characters from this reader and stores them
     * at {@code offset} in the character array {@code buffer}. Returns the
     * number of characters actually read or -1 if the end of the source reader
     * has been reached. If all the buffered characters have been used, a mark
     * has not been set and the requested number of characters is larger than
     * this readers buffer size, BufferedReader bypasses the buffer and simply
     * places the results directly into {@code buffer}.
     *
     * @param buffer
     *            the character array to store the characters read.
     * @param offset
     *            the initial position in {@code buffer} to store the bytes read
     *            from this reader.
     * @param length
     *            the maximum number of characters to read, must be
     *            non-negative.
     * @return number of characters read or -1 if the end of the source reader
     *         has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the size of
     *             {@code buffer}.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSSource({DSSourceKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.810 -0500", hash_original_method = "EFCE29DD70FA840EFC7C884DCFC84327", hash_generated_method = "D9AE1B55A0510DB080BA6CE3B1DC1A90")
    
@Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            int outstanding = length;
            while (outstanding > 0) {

                /*
                 * If there are bytes in the buffer, grab those first.
                 */
                int available = end - pos;
                if (available > 0) {
                    int count = available >= outstanding ? outstanding : available;
                    System.arraycopy(buf, pos, buffer, offset, count);
                    pos += count;
                    offset += count;
                    outstanding -= count;
                }

                /*
                 * Before attempting to read from the underlying stream, make
                 * sure we really, really want to. We won't bother if we're
                 * done, or if we've already got some bytes and reading from the
                 * underlying stream would block.
                 */
                if (outstanding == 0 || (outstanding < length && !in.ready())) {
                    break;
                }

                // assert(pos == end);

                /*
                 * If we're unmarked and the requested size is greater than our
                 * buffer, read the bytes directly into the caller's buffer. We
                 * don't read into smaller buffers because that could result in
                 * a many reads.
                 */
                if ((mark == -1 || (pos - mark >= markLimit)) && outstanding >= buf.length) {
                    int count = in.read(buffer, offset, outstanding);
                    if (count > 0) {
                        outstanding -= count;
                        mark = -1;
                    }
                    break; // assume the source stream gave us all that it could
                }

                if (fillBuf() == -1) {
                    break; // source is exhausted
                }
            }

            int count = length - outstanding;
            return (count > 0 || count == length) ? count : -1;
        }
    }

    /**
     * Peeks at the next input character, refilling the buffer if necessary. If
     * this character is a newline character ("\n"), it is discarded.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.812 -0500", hash_original_method = "5E2706ACF0BEEE9ADCFD58329E615807", hash_generated_method = "28E9B033F43A6657D4E841C5908095A9")
    
final void chompNewline() throws IOException {
        if ((pos != end || fillBuf() != -1)
                && buf[pos] == '\n') {
            pos++;
        }
    }

    /**
     * Returns the next line of text available from this reader. A line is
     * represented by zero or more characters followed by {@code '\n'},
     * {@code '\r'}, {@code "\r\n"} or the end of the reader. The string does
     * not include the newline sequence.
     *
     * @return the contents of the line or {@code null} if no characters were
     *         read before the end of the reader has been reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSSource({DSSourceKind.IO})
    @DSComment("From safe class list")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.816 -0500", hash_original_method = "2E7624AE82CF066587D6991C8B167359", hash_generated_method = "4EED909B4B3AA6607F4DB5B32DA059E8")
    
public String readLine() throws IOException {
        return new String();
        /*
        synchronized (lock) {
            checkNotClosed();

            if (pos == end && fillBuf() == -1) {
                return null;
            }
            for (int charPos = pos; charPos < end; charPos++) {
                char ch = buf[charPos];
                if (ch > '\r') {
                    continue;
                }
                if (ch == '\n') {
                    String res = new String(buf, pos, charPos - pos);
                    pos = charPos + 1;
                    return res;
                } else if (ch == '\r') {
                    String res = new String(buf, pos, charPos - pos);
                    pos = charPos + 1;
                    if (((pos < end) || (fillBuf() != -1))
                            && (buf[pos] == '\n')) {
                        pos++;
                    }
                    return res;
                }
            }

            char eol = '\0';
            StringBuilder result = new StringBuilder(80);
            
            result.append(buf, pos, end - pos);
            while (true) {
                pos = end;

                // Are there buffered characters available? 
                if (eol == '\n') {
                    return result.toString();
                }
                // attempt to fill buffer
                if (fillBuf() == -1) {
                    // characters or null.
                    return result.length() > 0 || eol != '\0'
                            ? result.toString()
                            : null;
                }
                for (int charPos = pos; charPos < end; charPos++) {
                    char c = buf[charPos];
                    if (eol == '\0') {
                        if ((c == '\n' || c == '\r')) {
                            eol = c;
                        }
                    } else if (eol == '\r' && c == '\n') {
                        if (charPos > pos) {
                            result.append(buf, pos, charPos - pos - 1);
                        }
                        pos = charPos + 1;
                        return result.toString();
                    } else {
                        if (charPos > pos) {
                            result.append(buf, pos, charPos - pos - 1);
                        }
                        pos = charPos;
                        return result.toString();
                    }
                }
                if (eol == '\0') {
                    result.append(buf, pos, end - pos);
                } else {
                    result.append(buf, pos, end - pos - 1);
                }
            }
        }
    */
    }

    /**
     * Indicates whether this reader is ready to be read without blocking.
     *
     * @return {@code true} if this reader will not block when {@code read} is
     *         called, {@code false} if unknown or blocking will occur.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     * @see #read()
     * @see #read(char[], int, int)
     * @see #readLine()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.818 -0500", hash_original_method = "8DBFD5F046457CCDE72CB0FF01FB7E1A", hash_generated_method = "3EBE27587D105331186151656D37C486")
    
@Override
    public boolean ready() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            return 1 == ((end - pos) + (((in.ready())) ? 1 : 0));
        }
    }

    /**
     * Resets this reader's position to the last {@code mark()} location.
     * Invocations of {@code read()} and {@code skip()} will occur from this new
     * location.
     *
     * @throws IOException
     *             if this reader is closed or no mark has been set.
     * @see #mark(int)
     * @see #markSupported()
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.822 -0500", hash_original_method = "CFE9F55B11CEBEA9E9DFCD46210902F2", hash_generated_method = "5A668F668B96C14B8161823E07BB19C4")
    
@Override
    public void reset() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (mark == -1) {
                throw new IOException("Invalid mark");
            }
            pos = mark;
        }
    }

    /**
     * Skips {@code byteCount} bytes in this stream. Subsequent calls to
     * {@code read} will not return these bytes unless {@code reset} is
     * used.
     * Skipping characters may invalidate a mark if {@code markLimit}
     * is surpassed.
     *
     * @param byteCount
     *            the maximum number of characters to skip.
     * @return the number of characters actually skipped.
     * @throws IllegalArgumentException
     *             if {@code byteCount < 0}.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     * @see #mark(int)
     * @see #markSupported()
     * @see #reset()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.825 -0500", hash_original_method = "6635225943CAECFE84E5456D76E9313A", hash_generated_method = "D469B8C92A4DD0CAC2335E1C956715AA")
    
@Override
    public long skip(long byteCount) throws IOException {
        if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        }
        synchronized (lock) {
            checkNotClosed();
            if (byteCount < 1) {
                return 0;
            }
            if (end - pos >= byteCount) {
                pos += byteCount;
                return byteCount;
            }

            long read = end - pos;
            pos = end;
            while (read < byteCount) {
                if (fillBuf() == -1) {
                    return read;
                }
                if (end - pos >= byteCount - read) {
                    pos += byteCount - read;
                    return byteCount;
                }
                // Couldn't get all the characters, skip what we read
                read += (end - pos);
                pos = end;
            }
            return byteCount;
        }
    }
    
}

