package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class PipedOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.402 -0500", hash_original_field = "C5F37FC8F219C9036D7EDF0FA7D29973", hash_generated_field = "FFCF22CBA6829D46F4F004A31261042A")

    private PipedInputStream target;

    /**
     * Constructs a new unconnected {@code PipedOutputStream}. The resulting
     * stream must be connected to a {@link PipedInputStream} before data can be
     * written to it.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.405 -0500", hash_original_method = "E4156F592468799387F97AC767717CEE", hash_generated_method = "2D2802C47FF4B77E0138846DE35E266E")
    
public PipedOutputStream() {
    }

    /**
     * Constructs a new {@code PipedOutputStream} connected to the
     * {@link PipedInputStream} {@code target}. Any data written to this stream
     * can be read from the target stream.
     *
     * @param target
     *            the piped input stream to connect to.
     * @throws IOException
     *             if this stream or {@code target} are already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.408 -0500", hash_original_method = "EDB6E26C0B783EE736D00B46ADBCAF6A", hash_generated_method = "340283C501A4B0957EF62BE3EC0097B7")
    
public PipedOutputStream(PipedInputStream target) throws IOException {
        connect(target);
    }

    /**
     * Closes this stream. If this stream is connected to an input stream, the
     * input stream is closed and the pipe is disconnected.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.411 -0500", hash_original_method = "3142FC22E0231F063D6673F4E3EF281C", hash_generated_method = "058144D82C5711D4E5D6FAF50756AB26")
    
@Override
    public void close() throws IOException {
        // Is the pipe connected?
        PipedInputStream stream = target;
        if (stream != null) {
            stream.done();
            target = null;
        }
    }

    /**
     * Connects this stream to a {@link PipedInputStream}. Any data written to
     * this output stream becomes readable in the input stream.
     *
     * @param stream
     *            the piped input stream to connect to.
     * @throws IOException
     *             if either stream is already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.413 -0500", hash_original_method = "962D17DAB77DCC2B5B99A6C84B8F4998", hash_generated_method = "AA10F66108A3D5ACEA5401B4123151D4")
    
public void connect(PipedInputStream stream) throws IOException {
        if (stream == null) {
            throw new NullPointerException();
        }
        synchronized (stream) {
            if (this.target != null) {
                throw new IOException("Already connected");
            }
            if (stream.isConnected) {
                throw new IOException("Pipe already connected");
            }
            stream.establishConnection();
            this.target = stream;
        }
    }

    /**
     * Notifies the readers of this {@link PipedInputStream} that bytes can be
     * read. This method does nothing if this stream is not connected.
     *
     * @throws IOException
     *             if an I/O error occurs while flushing this stream.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.416 -0500", hash_original_method = "4767B865A10590C82F9C2F7878251CCF", hash_generated_method = "19F49905412D13C590146D62FF26E936")
    
@Override
    public void flush() throws IOException {
        PipedInputStream stream = target;
        if (stream == null) {
            return;
        }

        synchronized (stream) {
            stream.notifyAll();
        }
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * {@code offset} to this stream. The written data can then be read from the
     * connected input stream.
     * <p>
     * Separate threads should be used to write to a {@code PipedOutputStream}
     * and to read from the connected {@link PipedInputStream}. If the same
     * thread is used, a deadlock may occur.
     *
     * @param buffer
     *            the buffer to write.
     * @param offset
     *            the index of the first byte in {@code buffer} to write.
     * @param count
     *            the number of bytes from {@code buffer} to write to this
     *            stream.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is bigger than the length of {@code buffer}.
     * @throws InterruptedIOException
     *             if the pipe is full and the current thread is interrupted
     *             waiting for space to write data. This case is not currently
     *             handled correctly.
     * @throws IOException
     *             if this stream is not connected, if the target stream is
     *             closed or if the thread reading from the target stream is no
     *             longer alive. This case is currently not handled correctly.
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.418 -0500", hash_original_method = "2AED6D37E619AA85421BF0C9628FA8FE", hash_generated_method = "D6706B0027B05DB7EDA828B6EAA50110")
    
@Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        super.write(buffer, offset, count);
    }

    /**
     * Writes a single byte to this stream. Only the least significant byte of
     * the integer {@code oneByte} is written. The written byte can then be read
     * from the connected input stream.
     * <p>
     * Separate threads should be used to write to a {@code PipedOutputStream}
     * and to read from the connected {@link PipedInputStream}. If the same
     * thread is used, a deadlock may occur.
     *
     * @param oneByte
     *            the byte to write.
     * @throws InterruptedIOException
     *             if the pipe is full and the current thread is interrupted
     *             waiting for space to write data. This case is not currently
     *             handled correctly.
     * @throws IOException
     *             if this stream is not connected, if the target stream is
     *             closed or if the thread reading from the target stream is no
     *             longer alive. This case is currently not handled correctly.
     */
    @DSSink({DSSinkKind.IO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.421 -0500", hash_original_method = "BFD8A7C0A63758DDB744E4CC4F7CF855", hash_generated_method = "F5F1191513F8689106647CDF8D5965FD")
    
@Override
    public void write(int oneByte) throws IOException {
        PipedInputStream stream = target;
        if (stream == null) {
            throw new IOException("Pipe not connected");
        }
        stream.receive(oneByte);
    }
    
}

