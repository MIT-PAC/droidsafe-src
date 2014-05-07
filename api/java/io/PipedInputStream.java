package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class PipedInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.835 -0500", hash_original_field = "32272A849EA457522206621DB7551BDB", hash_generated_field = "98981E77F477BF5BC6052D8850C465A7")

    protected static final int PIPE_SIZE = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.821 -0500", hash_original_field = "0C274599D1E182E9646E850B1F54838C", hash_generated_field = "F5A62F451E05D22096D6EE6BA212D601")

    private Thread lastReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.823 -0500", hash_original_field = "11B82934C1097E36AA09E79AB8952C5D", hash_generated_field = "276A7969C85F5DE4B1F84464F2E355FA")

    private Thread lastWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.825 -0500", hash_original_field = "FF1318BD7B381B7887A6EEC627EFEF6C", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.828 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.830 -0500", hash_original_field = "6C2A488AC6B0C698A8607CEA3B0A6CD5", hash_generated_field = "58862AB4E2B0CB5FD1377E7AA508B6BA")

    protected int in = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.832 -0500", hash_original_field = "F336AD514990B0A382A01CD56F41BE74", hash_generated_field = "B9DAD1FC7D32BD3FCCD6EA20CBE64C1B")

    protected int out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.837 -0500", hash_original_field = "63EA3415F69DFBAE1E285FCFD4110E54", hash_generated_field = "63EA3415F69DFBAE1E285FCFD4110E54")

    boolean isConnected;

    /**
     * Constructs a new unconnected {@code PipedInputStream}. The resulting
     * stream must be connected to a {@link PipedOutputStream} before data may
     * be read from it.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.840 -0500", hash_original_method = "EAE18C87236155EAE738625B0EE95D6C", hash_generated_method = "E7FB40C6AB2C8096523A1C2B218A59B4")
    
public PipedInputStream() {}

    /**
     * Constructs a new {@code PipedInputStream} connected to the
     * {@link PipedOutputStream} {@code out}. Any data written to the output
     * stream can be read from the this input stream.
     *
     * @param out
     *            the piped output stream to connect to.
     * @throws IOException
     *             if this stream or {@code out} are already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.843 -0500", hash_original_method = "5C6A295DEF226D787CAB21BFAF549F52", hash_generated_method = "496B6F83C7A477341F9D7519173DCAB3")
    
public PipedInputStream(PipedOutputStream out) throws IOException {
        connect(out);
    }

    /**
     * Constructs a new unconnected {@code PipedInputStream} with the given
     * buffer size. The resulting stream must be connected to a
     * {@code PipedOutputStream} before data may be read from it.
     *
     * @param pipeSize the size of the buffer in bytes.
     * @throws IllegalArgumentException if pipeSize is less than or equal to zero.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.846 -0500", hash_original_method = "E71321ED2FFA70E9F11724EE1BE224BC", hash_generated_method = "579223054415B6B88118728AB8960597")
    
public PipedInputStream(int pipeSize) {
        if (pipeSize <= 0) {
            throw new IllegalArgumentException("pipe size " + pipeSize + " too small");
        }
        buffer = new byte[pipeSize];
    }

    /**
     * Constructs a new {@code PipedInputStream} connected to the given {@code PipedOutputStream},
     * with the given buffer size. Any data written to the output stream can be read from this
     * input stream.
     *
     * @param out the {@code PipedOutputStream} to connect to.
     * @param pipeSize the size of the buffer in bytes.
     * @throws IOException if an I/O error occurs.
     * @throws IllegalArgumentException if pipeSize is less than or equal to zero.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.849 -0500", hash_original_method = "A3EF9AC77ADE8608AA265A4D24E9A500", hash_generated_method = "5B25F97E3955958762693BDD25DF1DD4")
    
public PipedInputStream(PipedOutputStream out, int pipeSize) throws IOException {
        this(pipeSize);
        connect(out);
    }

    /**
     * {@inheritDoc}
     *
     * <p>Unlike most streams, {@code PipedInputStream} returns 0 rather than throwing
     * {@code IOException} if the stream has been closed. Unconnected and broken pipes also
     * return 0.
     *
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.852 -0500", hash_original_method = "2A98E1CFDF4B9A3EC436EF3BA87395EB", hash_generated_method = "55B947A3E612BD1E29ED2B3E8790B567")
    
@Override
    public synchronized int available() throws IOException {
        if (buffer == null || in == -1) {
            return 0;
        }
        return in <= out ? buffer.length - out + in : in - out;
    }

    /**
     * Closes this stream. This implementation releases the buffer used for the
     * pipe and notifies all threads waiting to read or write.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.855 -0500", hash_original_method = "3F663E82A2EB3C95CA9BF0AFC9912DC8", hash_generated_method = "DBB377E63B1D8B44DF2588167E13233A")
    
@Override
    public synchronized void close() throws IOException {
        buffer = null;
        notifyAll();
    }

    /**
     * Connects this {@code PipedInputStream} to a {@link PipedOutputStream}.
     * Any data written to the output stream becomes readable in this input
     * stream.
     *
     * @param src
     *            the source output stream.
     * @throws IOException
     *             if either stream is already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.857 -0500", hash_original_method = "577007FA4B30A526722BCCB2926E190B", hash_generated_method = "C353233A3672428C8E74F3B8D253DC73")
    
public void connect(PipedOutputStream src) throws IOException {
        src.connect(this);
    }

    /**
     * Establishes the connection to the PipedOutputStream.
     *
     * @throws IOException
     *             If this Reader is already connected.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.859 -0500", hash_original_method = "5C9219C47AC485F782454E337FD705F5", hash_generated_method = "9EC41D60B9E82340DD96551BF7F48F3A")
    
synchronized void establishConnection() throws IOException {
        if (isConnected) {
            throw new IOException("Pipe already connected");
        }
        if (buffer == null) { // We may already have allocated the buffer.
            buffer = new byte[PipedInputStream.PIPE_SIZE];
        }
        isConnected = true;
    }

    /**
     * Reads a single byte from this stream and returns it as an integer in the
     * range from 0 to 255. Returns -1 if the end of this stream has been
     * reached. If there is no data in the pipe, this method blocks until data
     * is available, the end of the stream is detected or an exception is
     * thrown.
     * <p>
     * Separate threads should be used to read from a {@code PipedInputStream}
     * and to write to the connected {@link PipedOutputStream}. If the same
     * thread is used, a deadlock may occur.
     *
     * @return the byte read or -1 if the end of the source stream has been
     *         reached.
     * @throws IOException
     *             if this stream is closed or not connected to an output
     *             stream, or if the thread writing to the connected output
     *             stream is no longer alive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.863 -0500", hash_original_method = "2CE52A22634017D3B9A1E29444B8338A", hash_generated_method = "6B35C78925AC44ADD51236A6E5FEBB2D")
    
@Override
    public synchronized int read() throws IOException {
        if (!isConnected) {
            throw new IOException("Not connected");
        }
        if (buffer == null) {
            throw new IOException("InputStream is closed");
        }

        /**
         * Set the last thread to be reading on this PipedInputStream. If
         * lastReader dies while someone is waiting to write an IOException of
         * "Pipe broken" will be thrown in receive()
         */
        lastReader = Thread.currentThread();
        try {
            int attempts = 3;
            while (in == -1) {
                // Are we at end of stream?
                if (isClosed) {
                    return -1;
                }
                if ((attempts-- <= 0) && lastWriter != null && !lastWriter.isAlive()) {
                    throw new IOException("Pipe broken");
                }
                // Notify callers of receive()
                notifyAll();
                wait(1000);
            }
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }

        int result = buffer[out++] & 0xff;
        if (out == buffer.length) {
            out = 0;
        }
        if (out == in) {
            // empty buffer
            in = -1;
            out = 0;
        }

        // let blocked writers write to the newly available buffer space
        notifyAll();

        return result;
    }

    /**
     * Reads at most {@code byteCount} bytes from this stream and stores them in the
     * byte array {@code bytes} starting at {@code offset}. Blocks until at
     * least one byte has been read, the end of the stream is detected or an
     * exception is thrown.
     * <p>
     * Separate threads should be used to read from a {@code PipedInputStream}
     * and to write to the connected {@link PipedOutputStream}. If the same
     * thread is used, a deadlock may occur.
     *
     * @return the number of bytes actually read or -1 if the end of the stream
     *         has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code byteCount < 0}, or if {@code
     *             offset + byteCount} is greater than the size of {@code bytes}.
     * @throws InterruptedIOException
     *             if the thread reading from this stream is interrupted.
     * @throws IOException
     *             if this stream is closed or not connected to an output
     *             stream, or if the thread writing to the connected output
     *             stream is no longer alive.
     * @throws NullPointerException
     *             if {@code bytes} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.866 -0500", hash_original_method = "D28D662CAD3AC901637BA85FDFEE5B3E", hash_generated_method = "4EB375BFE4DC1AB0442C4397A7F58490")
    
@Override
    public synchronized int read(byte[] bytes, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(bytes.length, offset, byteCount);
        if (byteCount == 0) {
            return 0;
        }

        if (!isConnected) {
            throw new IOException("Not connected");
        }

        if (buffer == null) {
            throw new IOException("InputStream is closed");
        }

        /*
         * Set the last thread to be reading on this PipedInputStream. If
         * lastReader dies while someone is waiting to write an IOException of
         * "Pipe broken" will be thrown in receive()
         */
        lastReader = Thread.currentThread();
        try {
            int attempts = 3;
            while (in == -1) {
                // Are we at end of stream?
                if (isClosed) {
                    return -1;
                }
                if ((attempts-- <= 0) && lastWriter != null && !lastWriter.isAlive()) {
                    throw new IOException("Pipe broken");
                }
                // Notify callers of receive()
                notifyAll();
                wait(1000);
            }
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }

        int totalCopied = 0;

        // copy bytes from out thru the end of buffer
        if (out >= in) {
            int leftInBuffer = buffer.length - out;
            int length = leftInBuffer < byteCount ? leftInBuffer : byteCount;
            System.arraycopy(buffer, out, bytes, offset, length);
            out += length;
            if (out == buffer.length) {
                out = 0;
            }
            if (out == in) {
                // empty buffer
                in = -1;
                out = 0;
            }
            totalCopied += length;
        }

        // copy bytes from out thru in
        if (totalCopied < byteCount && in != -1) {
            int leftInBuffer = in - out;
            int leftToCopy = byteCount - totalCopied;
            int length = leftToCopy < leftInBuffer ? leftToCopy : leftInBuffer;
            System.arraycopy(buffer, out, bytes, offset + totalCopied, length);
            out += length;
            if (out == in) {
                // empty buffer
                in = -1;
                out = 0;
            }
            totalCopied += length;
        }

        // let blocked writers write to the newly available buffer space
        notifyAll();

        return totalCopied;
    }

    /**
     * Receives a byte and stores it in this stream's {@code buffer}. This
     * method is called by {@link PipedOutputStream#write(int)}. The least
     * significant byte of the integer {@code oneByte} is stored at index
     * {@code in} in the {@code buffer}.
     * <p>
     * This method blocks as long as {@code buffer} is full.
     *
     * @param oneByte
     *            the byte to store in this pipe.
     * @throws InterruptedIOException
     *             if the {@code buffer} is full and the thread that has called
     *             this method is interrupted.
     * @throws IOException
     *             if this stream is closed or the thread that has last read
     *             from this stream is no longer alive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.869 -0500", hash_original_method = "F1DDF844B79F62E2699AFB2EF26553A3", hash_generated_method = "D65DF3570488C96DD21CDC4BE59E708C")
    
protected synchronized void receive(int oneByte) throws IOException {
        if (buffer == null || isClosed) {
            throw new IOException("Pipe is closed");
        }

        /*
         * Set the last thread to be writing on this PipedInputStream. If
         * lastWriter dies while someone is waiting to read an IOException of
         * "Pipe broken" will be thrown in read()
         */
        lastWriter = Thread.currentThread();
        try {
            while (buffer != null && out == in) {
                if (lastReader != null && !lastReader.isAlive()) {
                    throw new IOException("Pipe broken");
                }
                notifyAll();
                wait(1000);
            }
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
        if (buffer == null) {
            throw new IOException("Pipe is closed");
        }
        if (in == -1) {
            in = 0;
        }
        buffer[in++] = (byte) oneByte;
        if (in == buffer.length) {
            in = 0;
        }

        // let blocked readers read the newly available data
        notifyAll();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.872 -0500", hash_original_method = "19BFAB2AD4E1A13AD9CB12419968F5AB", hash_generated_method = "0B05E6B5D4DC4B6BD624E8CCC3D31FDE")
    
synchronized void done() {
        isClosed = true;
        notifyAll();
    }
}

