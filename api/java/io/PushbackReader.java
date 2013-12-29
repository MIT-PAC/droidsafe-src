package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;






public class PushbackReader extends FilterReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.717 -0500", hash_original_field = "40514AFF00B14ABD40D54C723F22A0B4", hash_generated_field = "40514AFF00B14ABD40D54C723F22A0B4")

    char[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.718 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

    int pos;

    /**
     * Constructs a new {@code PushbackReader} with the specified reader as
     * source. The size of the pushback buffer is set to the default value of 1
     * character.
     *
     * @param in
     *            the source reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.719 -0500", hash_original_method = "B6B01CC88320509C49CCBB3EC0CBE41F", hash_generated_method = "6730B2B68C67C67A679F031CA28A9667")
    public PushbackReader(Reader in) {
        super(in);
        buf = new char[1];
        pos = 1;
    }

    /**
     * Constructs a new {@code PushbackReader} with {@code in} as source reader.
     * The size of the pushback buffer is set to {@code size}.
     *
     * @param in
     *            the source reader.
     * @param size
     *            the size of the pushback buffer.
     * @throws IllegalArgumentException
     *             if {@code size} is negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.720 -0500", hash_original_method = "9E5ACD5C81BD224F75A81C9C066E599D", hash_generated_method = "CECF6E8D14BA8A124B031577F81C794F")
    public PushbackReader(Reader in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        buf = new char[size];
        pos = size;
    }

    /**
     * Closes this reader. This implementation closes the source reader
     * and releases the pushback buffer.
     *
     * @throws IOException
     *             if an error occurs while closing this reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.721 -0500", hash_original_method = "298F8792979BB77A625D9BD803A02F79", hash_generated_method = "D53EEDA736AC930526CFF55855BFF7DB")
    @Override
public void close() throws IOException {
        synchronized (lock) {
            buf = null;
            in.close();
        }
    }

    /**
     * Marks the current position in this stream. Setting a mark is not
     * supported in this class; this implementation always throws an
     * {@code IOException}.
     *
     * @param readAheadLimit
     *            the number of character that can be read from this reader
     *            before the mark is invalidated; this parameter is ignored.
     * @throws IOException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.722 -0500", hash_original_method = "4DEDB50585DFE7302612A8E4FFBB0FA9", hash_generated_method = "33F66E413F98C371EB73FBC11B0EDB6A")
    @Override
public void mark(int readAheadLimit) throws IOException {
        throw new IOException("mark/reset not supported");
    }

    /**
     * Indicates whether this reader supports the {@code mark(int)} and
     * {@code reset()} methods. {@code PushbackReader} does not support them, so
     * it returns {@code false}.
     *
     * @return always {@code false}.
     * @see #mark(int)
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.723 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "98834879561C7504F012DD22F86DCE30")
    @Override
public boolean markSupported() {
        return false;
    }

    /**
     * Reads a single character from this reader and returns it as an integer
     * with the two higher-order bytes set to 0. Returns -1 if the end of the
     * reader has been reached. If the pushback buffer does not contain any
     * available characters then a character from the source reader is returned.
     * Blocks until one character has been read, the end of the source reader is
     * detected or an exception is thrown.
     *
     * @return the character read or -1 if the end of the source reader has been
     *         reached.
     * @throws IOException
     *             if this reader is closed or an I/O error occurs while reading
     *             from this reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.724 -0500", hash_original_method = "CE14A4FF29D58642FE2BEF405E27FE95", hash_generated_method = "B663E5509391218D52F5860CEB3FAC99")
    @Override
public int read() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            /* Is there a pushback character available? */
            if (pos < buf.length) {
                return buf[pos++];
            }
            /**
             * Assume read() in the InputStream will return 2 lowest-order bytes
             * or -1 if end of stream.
             */
            return in.read();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.725 -0500", hash_original_method = "168C295624DB201B6537BA6FAD6078C2", hash_generated_method = "EE001FDCF08EFC7B78324344604B3E3E")
    private void checkNotClosed() throws IOException {
        if (buf == null) {
            throw new IOException("PushbackReader is closed");
        }
    }

    /**
     * Reads at most {@code length} bytes from this reader and stores them in
     * byte array {@code buffer} starting at {@code offset}. Characters are
     * read from the pushback buffer first, then from the source reader if more
     * bytes are required. Blocks until {@code count} characters have been read,
     * the end of the source reader is detected or an exception is thrown.
     *
     * @param buffer
     *            the array in which to store the characters read from this
     *            reader.
     * @param offset
     *            the initial position in {@code buffer} to store the characters
     *            read from this reader.
     * @param count
     *            the maximum number of bytes to store in {@code buffer}.
     * @return the number of bytes read or -1 if the end of the source reader
     *         has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is greater than the length of
     *             {@code buffer}.
     * @throws IOException
     *             if this reader is closed or another I/O error occurs while
     *             reading from this reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.726 -0500", hash_original_method = "B9190ABDE3B10CB37A8EAB2FF74A1B25", hash_generated_method = "C43BFCB5C469DA2B73FD120B13D3B5E0")
    @Override
public int read(char[] buffer, int offset, int count) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buffer.length, offset, count);

            int copiedChars = 0;
            int copyLength = 0;
            int newOffset = offset;
            /* Are there pushback chars available? */
            if (pos < buf.length) {
                copyLength = (buf.length - pos >= count) ? count : buf.length
                        - pos;
                System.arraycopy(buf, pos, buffer, newOffset, copyLength);
                newOffset += copyLength;
                copiedChars += copyLength;
                /* Use up the chars in the local buffer */
                pos += copyLength;
            }
            /* Have we copied enough? */
            if (copyLength == count) {
                return count;
            }
            int inCopied = in.read(buffer, newOffset, count - copiedChars);
            if (inCopied > 0) {
                return inCopied + copiedChars;
            }
            if (copiedChars == 0) {
                return inCopied;
            }
            return copiedChars;
        }
    }

    /**
     * Indicates whether this reader is ready to be read without blocking.
     * Returns {@code true} if this reader will not block when {@code read} is
     * called, {@code false} if unknown or blocking will occur.
     *
     * @return {@code true} if the receiver will not block when
     *         {@code read()} is called, {@code false} if unknown
     *         or blocking will occur.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     * @see #read()
     * @see #read(char[], int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.727 -0500", hash_original_method = "D62FC241A8B58B8EF1EBB387C319130D", hash_generated_method = "7AE65CBF665E1FACF94870E16095D856")
    @Override
public boolean ready() throws IOException {
        synchronized (lock) {
            if (buf == null) {
                throw new IOException("Reader is closed");
            }
            return (buf.length - pos > 0 || in.ready());
        }
    }

    /**
     * Resets this reader to the last marked position. Resetting the reader is
     * not supported in this class; this implementation always throws an
     * {@code IOException}.
     *
     * @throws IOException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.728 -0500", hash_original_method = "6BB6003CEE550FAD13C0147210CF490A", hash_generated_method = "C567D957B336E39E1D1EF2680B7BEF0C")
    @Override
public void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    /**
     * Pushes all the characters in {@code buffer} back to this reader. The
     * characters are pushed back in such a way that the next character read
     * from this reader is buffer[0], then buffer[1] and so on.
     * <p>
     * If this reader's internal pushback buffer cannot store the entire
     * contents of {@code buffer}, an {@code IOException} is thrown. Parts of
     * {@code buffer} may have already been copied to the pushback buffer when
     * the exception is thrown.
     *
     * @param buffer
     *            the buffer containing the characters to push back to this
     *            reader.
     * @throws IOException
     *             if this reader is closed or the free space in the internal
     *             pushback buffer is not sufficient to store the contents of
     *             {@code buffer}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.728 -0500", hash_original_method = "3A71863D4D33CC0B41E243A7D99AFC6A", hash_generated_method = "6822D8AB7F17ED9CDD029D20FB09AA8B")
    public void unread(char[] buffer) throws IOException {
        unread(buffer, 0, buffer.length);
    }

    /**
     * Pushes a subset of the characters in {@code buffer} back to this reader.
     * The subset is defined by the start position {@code offset} within
     * {@code buffer} and the number of characters specified by {@code length}.
     * The bytes are pushed back in such a way that the next byte read from this
     * stream is {@code buffer[offset]}, then {@code buffer[1]} and so on.
     * <p>
     * If this stream's internal pushback buffer cannot store the selected
     * subset of {@code buffer}, an {@code IOException} is thrown. Parts of
     * {@code buffer} may have already been copied to the pushback buffer when
     * the exception is thrown.
     *
     * @param buffer
     *            the buffer containing the characters to push back to this
     *            reader.
     * @param offset
     *            the index of the first byte in {@code buffer} to push back.
     * @param length
     *            the number of bytes to push back.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is greater than the length of
     *             {@code buffer}.
     * @throws IOException
     *             if this reader is closed or the free space in the internal
     *             pushback buffer is not sufficient to store the selected
     *             contents of {@code buffer}.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.729 -0500", hash_original_method = "D820ACC6B7460811082E4447561A1371", hash_generated_method = "938F12667C4183ED486E1AE8AD3171A7")
    public void unread(char[] buffer, int offset, int length) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (length > pos) {
                throw new IOException("Pushback buffer full");
            }
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            for (int i = offset + length - 1; i >= offset; i--) {
                unread(buffer[i]);
            }
        }
    }

    /**
     * Pushes the specified character {@code oneChar} back to this reader. This
     * is done in such a way that the next character read from this reader is
     * {@code (char) oneChar}.
     * <p>
     * If this reader's internal pushback buffer cannot store the character, an
     * {@code IOException} is thrown.
     *
     * @param oneChar
     *            the character to push back to this stream.
     * @throws IOException
     *             if this reader is closed or the internal pushback buffer is
     *             full.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.731 -0500", hash_original_method = "778C661227F8B678AE3F6B841DAAEACD", hash_generated_method = "DED29060FB3081DF9D596E1E0350CEF2")
    public void unread(int oneChar) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (pos == 0) {
                throw new IOException("Pushback buffer full");
            }
            buf[--pos] = (char) oneChar;
        }
    }

    /**
     * Skips {@code charCount} characters in this reader. This implementation skips
     * characters in the pushback buffer first and then in the source reader if
     * necessary.
     *
     * @return the number of characters actually skipped.
     * @throws IllegalArgumentException if {@code charCount < 0}.
     * @throws IOException
     *             if this reader is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.732 -0500", hash_original_method = "7C49E5AFA8C1711AAA62DBD76CA3EFA0", hash_generated_method = "CC49269608829A6B594C6D398CC46A8E")
    @Override
public long skip(long charCount) throws IOException {
        if (charCount < 0) {
            throw new IllegalArgumentException("charCount < 0: " + charCount);
        }
        synchronized (lock) {
            checkNotClosed();
            if (charCount == 0) {
                return 0;
            }
            long inSkipped;
            int availableFromBuffer = buf.length - pos;
            if (availableFromBuffer > 0) {
                long requiredFromIn = charCount - availableFromBuffer;
                if (requiredFromIn <= 0) {
                    pos += charCount;
                    return charCount;
                }
                pos += availableFromBuffer;
                inSkipped = in.skip(requiredFromIn);
            } else {
                inSkipped = in.skip(charCount);
            }
            return inSkipped + availableFromBuffer;
        }
    }

    
}

