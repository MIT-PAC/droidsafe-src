package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.CharBuffer;

public abstract class Reader implements Readable, Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.826 -0500", hash_original_field = "5E7C45D6B25B1E31F92C48548080E9E3", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;

    /**
     * Constructs a new {@code Reader} with {@code this} as the object used to
     * synchronize critical sections.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.829 -0500", hash_original_method = "23BD0F45FCD5744DE183656F7640DB10", hash_generated_method = "71C8FCF9A91B7A5A1526A6B249D29EC8")
    
protected Reader() {
        lock = this;
    }

    /**
     * Constructs a new {@code Reader} with {@code lock} used to synchronize
     * critical sections.
     *
     * @param lock
     *            the {@code Object} used to synchronize critical sections.
     * @throws NullPointerException
     *             if {@code lock} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.832 -0500", hash_original_method = "841CA56D08654DE62644A6941CD75AE9", hash_generated_method = "6F72851AB99894DB9A81607419A3DB91")
    
protected Reader(Object lock) {
        if (lock == null) {
            throw new NullPointerException();
        }
        this.lock = lock;
    }

    /**
     * Closes this reader. Implementations of this method should free any
     * resources associated with the reader.
     *
     * @throws IOException
     *             if an error occurs while closing this reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.834 -0500", hash_original_method = "4E507319564A7E0BFD2A58D57A800811", hash_generated_method = "2228FF14FE1AFC53EB7399AA035D1509")
    
public abstract void close() throws IOException;

    /**
     * Sets a mark position in this reader. The parameter {@code readLimit}
     * indicates how many characters can be read before the mark is invalidated.
     * Calling {@code reset()} will reposition the reader back to the marked
     * position if {@code readLimit} has not been surpassed.
     * <p>
     * This default implementation simply throws an {@code IOException};
     * subclasses must provide their own implementation.
     *
     * @param readLimit
     *            the number of characters that can be read before the mark is
     *            invalidated.
     * @throws IllegalArgumentException
     *             if {@code readLimit < 0}.
     * @throws IOException
     *             if an error occurs while setting a mark in this reader.
     * @see #markSupported()
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.836 -0500", hash_original_method = "2066C142E0E9A9BCC65518E0FCDDA1D6", hash_generated_method = "EBA12DF8A153DF5B9F7C994055D37955")
    
public void mark(int readLimit) throws IOException {
        throw new IOException();
    }

    /**
     * Indicates whether this reader supports the {@code mark()} and
     * {@code reset()} methods. This default implementation returns
     * {@code false}.
     *
     * @return always {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.838 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "68CB0655189E46325916378CAE21EACC")
    
public boolean markSupported() {
        return false;
    }

    /**
     * Reads a single character from this reader and returns it as an integer
     * with the two higher-order bytes set to 0. Returns -1 if the end of the
     * reader has been reached.
     *
     * @return the character read or -1 if the end of the reader has been
     *         reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.841 -0500", hash_original_method = "4B904F9F4843983C12271BC14A375F35", hash_generated_method = "3181BD79906C23198BB1DA8AE2668AD1")
    
public int read() throws IOException {
        synchronized (lock) {
            char[] charArray = new char[1];
            if (read(charArray, 0, 1) != -1) {
                return charArray[0];
            }
            return -1;
        }
    }

    /**
     * Reads characters from this reader and stores them in the character array
     * {@code buf} starting at offset 0. Returns the number of characters
     * actually read or -1 if the end of the reader has been reached.
     *
     * @param buf
     *            character array to store the characters read.
     * @return the number of characters read or -1 if the end of the reader has
     *         been reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.843 -0500", hash_original_method = "E743E3D19B5FD453D0CBC2E5CA424673", hash_generated_method = "F1D6C9070AD8A49F0385879A6200617D")
    
public int read(char[] buf) throws IOException {
        return read(buf, 0, buf.length);
    }

    /**
     * Reads at most {@code count} characters from this reader and stores them
     * at {@code offset} in the character array {@code buf}. Returns the number
     * of characters actually read or -1 if the end of the reader has been
     * reached.
     *
     * @param buf
     *            the character array to store the characters read.
     * @param offset
     *            the initial position in {@code buffer} to store the characters
     *            read from this reader.
     * @param count
     *            the maximum number of characters to read.
     * @return the number of characters read or -1 if the end of the reader has
     *         been reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.846 -0500", hash_original_method = "BAAE620DD47C67A7C9FA2D182BB45EC6", hash_generated_method = "9A8DFEF4E7A8AC2186089662A0C89E20")
    
public abstract int read(char[] buf, int offset, int count) throws IOException;

    /**
     * Indicates whether this reader is ready to be read without blocking.
     * Returns {@code true} if this reader will not block when {@code read} is
     * called, {@code false} if unknown or blocking will occur. This default
     * implementation always returns {@code false}.
     *
     * @return always {@code false}.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     * @see #read()
     * @see #read(char[])
     * @see #read(char[], int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.848 -0500", hash_original_method = "D41EE0434E50B3C6E1AA0E42EDD44E0B", hash_generated_method = "94CE574D8F9043761F4405DCC097C872")
    
public boolean ready() throws IOException {
        return false;
    }

    /**
     * Resets this reader's position to the last {@code mark()} location.
     * Invocations of {@code read()} and {@code skip()} will occur from this new
     * location. If this reader has not been marked, the behavior of
     * {@code reset()} is implementation specific. This default
     * implementation throws an {@code IOException}.
     *
     * @throws IOException
     *             always thrown in this default implementation.
     * @see #mark(int)
     * @see #markSupported()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.850 -0500", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "905AD4216897ED858D0A370D64D237D3")
    
public void reset() throws IOException {
        throw new IOException();
    }

    /**
     * Skips {@code charCount} characters in this reader. Subsequent calls of
     * {@code read} methods will not return these characters unless {@code
     * reset} is used. This method may perform multiple reads to read {@code
     * charCount} characters.
     *
     * @return the number of characters actually skipped.
     * @throws IllegalArgumentException
     *             if {@code charCount < 0}.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     * @see #mark(int)
     * @see #markSupported()
     * @see #reset()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.853 -0500", hash_original_method = "7E8A2F73FB8EAE936D216E90BE91676B", hash_generated_method = "7AD957B0F0168F7BE1674D0299966610")
    
public long skip(long charCount) throws IOException {
        if (charCount < 0) {
            throw new IllegalArgumentException("charCount < 0: " + charCount);
        }
        synchronized (lock) {
            long skipped = 0;
            int toRead = charCount < 512 ? (int) charCount : 512;
            char[] charsSkipped = new char[toRead];
            while (skipped < charCount) {
                int read = read(charsSkipped, 0, toRead);
                if (read == -1) {
                    return skipped;
                }
                skipped += read;
                if (read < toRead) {
                    return skipped;
                }
                if (charCount - skipped < toRead) {
                    toRead = (int) (charCount - skipped);
                }
            }
            return skipped;
        }
    }

    /**
     * Reads characters and puts them into the {@code target} character buffer.
     *
     * @param target
     *            the destination character buffer.
     * @return the number of characters put into {@code target} or -1 if the end
     *         of this reader has been reached before a character has been read.
     * @throws IOException
     *             if any I/O error occurs while reading from this reader.
     * @throws NullPointerException
     *             if {@code target} is {@code null}.
     * @throws ReadOnlyBufferException
     *             if {@code target} is read-only.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.856 -0500", hash_original_method = "3EEA08DE1417537F34B729CF4FE40629", hash_generated_method = "C5940F6106B7BDD695AB535DD92FD3DC")
    
public int read(CharBuffer target) throws IOException {
        int length = target.length();
        char[] buf = new char[length];
        length = Math.min(length, read(buf));
        if (length > 0) {
            target.put(buf, 0, length);
        }
        return length;
    }
    
}

