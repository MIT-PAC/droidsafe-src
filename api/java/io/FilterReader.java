package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public abstract class FilterReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.732 -0500", hash_original_field = "905D4A99F191C55F09924512539E6D8F", hash_generated_field = "F15B9A182F31EEA4A8B216C74398FC35")

    protected Reader in;

    /**
     * Constructs a new FilterReader on the Reader {@code in}.
     *
     * @param in
     *            The non-null Reader to filter reads on.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.735 -0500", hash_original_method = "F3D1BE373A56A0B558A4F2E00F8B10E0", hash_generated_method = "BFBF6AB2757D6E74C4636A913F75AC99")
    
protected FilterReader(Reader in) {
        super(in);
        this.in = in;
    }

    /**
     * Closes this reader. This implementation closes the filtered reader.
     *
     * @throws IOException
     *             if an error occurs while closing this reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.737 -0500", hash_original_method = "501891754658354231C7815C688E4921", hash_generated_method = "85E094A6A08FD6A70ED7A5BA82B082AB")
    
@Override
    public void close() throws IOException {
        synchronized (lock) {
            in.close();
        }
    }

    /**
     * Sets a mark position in this reader. The parameter {@code readlimit}
     * indicates how many bytes can be read before the mark is invalidated.
     * Sending {@code reset()} will reposition this reader back to the marked
     * position, provided that {@code readlimit} has not been surpassed.
     * <p>
     * This implementation sets a mark in the filtered reader.
     *
     * @param readlimit
     *            the number of bytes that can be read from this reader before
     *            the mark is invalidated.
     * @throws IOException
     *             if an error occurs while marking this reader.
     * @see #markSupported()
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.740 -0500", hash_original_method = "CF9F5D7515858833C08423EA9B6FCE6A", hash_generated_method = "7C667CAEB3C9BCA0FC2EE590F2869EE8")
    
@Override
    public synchronized void mark(int readlimit) throws IOException {
        synchronized (lock) {
            in.mark(readlimit);
        }
    }

    /**
     * Indicates whether this reader supports {@code mark()} and {@code reset()}.
     * This implementation returns whether the filtered reader supports marking.
     *
     * @return {@code true} if {@code mark()} and {@code reset()} are supported
     *         by the filtered reader, {@code false} otherwise.
     * @see #mark(int)
     * @see #reset()
     * @see #skip(long)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.743 -0500", hash_original_method = "2ED4924508737903A79CF3129A066F71", hash_generated_method = "46CCBDD5DA43A5F260E60DA236758383")
    
@Override
    public boolean markSupported() {
        synchronized (lock) {
            return in.markSupported();
        }
    }

    /**
     * Reads a single character from the filtered reader and returns it as an
     * integer with the two higher-order bytes set to 0. Returns -1 if the end
     * of the filtered reader has been reached.
     *
     * @return The character read or -1 if the end of the filtered reader has
     *         been reached.
     * @throws IOException
     *             if an error occurs while reading from this reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.745 -0500", hash_original_method = "25E05A20196B2EF8776FA69AEA6A01AB", hash_generated_method = "9FAED940D6E9DE757EDACE377DD026C4")
    
@Override
    public int read() throws IOException {
        synchronized (lock) {
            return in.read();
        }
    }

    /**
     * Reads at most {@code count} characters from the filtered reader and stores them
     * in the byte array {@code buffer} starting at {@code offset}. Returns the
     * number of characters actually read or -1 if no characters were read and
     * the end of the filtered reader was encountered.
     *
     * @param buffer
     *            the char array in which to store the characters read.
     * @param offset
     *            the initial position in {@code buffer} to store the characters
     *            read from this reader.
     * @param count
     *            the maximum number of characters to store in {@code buffer}.
     * @return the number of characters actually read or -1 if the end of the
     *         filtered reader has been reached while reading.
     * @throws IOException
     *             if an error occurs while reading from this reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.747 -0500", hash_original_method = "1EA26595B36EBCA6FE882CBA9CA8B025", hash_generated_method = "A09318D3ECE09D405808F8418F559DC7")
    
@Override
    public int read(char[] buffer, int offset, int count) throws IOException {
        synchronized (lock) {
            return in.read(buffer, offset, count);
        }
    }

    /**
     * Indicates whether this reader is ready to be read without blocking. If
     * the result is {@code true}, the next {@code read()} will not block. If
     * the result is {@code false}, this reader may or may not block when
     * {@code read()} is sent.
     *
     * @return {@code true} if this reader will not block when {@code read()}
     *         is called, {@code false} if unknown or blocking will occur.
     * @throws IOException
     *             if the reader is closed or some other I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.750 -0500", hash_original_method = "3B619AD38F7F67E79C5355301607CFA3", hash_generated_method = "1FC48FAB01187FFABEB19B2DF5FE943E")
    
@Override
    public boolean ready() throws IOException {
        synchronized (lock) {
            return in.ready();
        }
    }

    /**
     * Resets this reader's position to the last marked location. Invocations of
     * {@code read()} and {@code skip()} will occur from this new location. If
     * this reader was not marked, the behavior depends on the implementation of
     * {@code reset()} in the Reader subclass that is filtered by this reader.
     * The default behavior for Reader is to throw an {@code IOException}.
     *
     * @throws IOException
     *             if a problem occurred or the filtered reader does not support
     *             {@code mark()} and {@code reset()}.
     * @see #mark(int)
     * @see #markSupported()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.752 -0500", hash_original_method = "14FB3B3EA5640BFE7D124E930BE279E7", hash_generated_method = "374C33C0BB50CAEE0408CCB15057E524")
    
@Override
    public void reset() throws IOException {
        synchronized (lock) {
            in.reset();
        }
    }

    /**
     * Skips {@code charCount} characters in this reader. Subsequent calls to {@code read}
     * will not return these characters unless {@code reset} is used. The
     * default implementation is to skip characters in the filtered reader.
     *
     * @return the number of characters actually skipped.
     * @throws IOException
     *             if the filtered reader is closed or some other I/O error
     *             occurs.
     * @see #mark(int)
     * @see #markSupported()
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.756 -0500", hash_original_method = "1B3BA6A4C9DAFF7D8DBE3635EB5F6FB9", hash_generated_method = "6DCC3DD56F1BD540D7D1363F0EF114FD")
    
@Override
    public long skip(long charCount) throws IOException {
        synchronized (lock) {
            return in.skip(charCount);
        }
    }

    
}

