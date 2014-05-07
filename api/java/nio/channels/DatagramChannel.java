package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class DatagramChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {

    /**
     * Creates an opened and not-connected datagram channel.
     * <p>
     * This channel is created by calling the <code>openDatagramChannel</code>
     * method of the default {@link SelectorProvider} instance.
     *
     * @return the new channel which is open but not connected.
     * @throws IOException
     *             if some I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.920 -0500", hash_original_method = "FF19FCAA1AEEA14F76CE4D3DFB2AA57C", hash_generated_method = "9FAF3ABF2C27F02B828E01EB0D389166")
    
public static DatagramChannel open() throws IOException {
        return SelectorProvider.provider().openDatagramChannel();
    }

    /**
     * Constructs a new {@code DatagramChannel}.
     *
     * @param selectorProvider
     *            an instance of SelectorProvider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.917 -0500", hash_original_method = "CB53873E4EB950556D4A1D46A395181D", hash_generated_method = "29FA237341F05A5965CAC8483EE8F415")
    
protected DatagramChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
    }

    /**
     * Gets the valid operations of this channel. Datagram channels support read
     * and write operations, so this method returns (
     * <code>SelectionKey.OP_READ</code> | <code>SelectionKey.OP_WRITE</code> ).
     *
     * @see java.nio.channels.SelectableChannel#validOps()
     * @return valid operations in bit-set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.927 -0500", hash_original_method = "389104566E9179427B49B1E6618B4C60", hash_generated_method = "38EA401FA74CEAC162FDD56053D91382")
    
@Override
    public final int validOps() {
        return (SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    /**
     * Returns the related datagram socket of this channel, which does not
     * define additional public methods to those defined by
     * {@link DatagramSocket}.
     *
     * @return the related DatagramSocket instance.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.929 -0500", hash_original_method = "2C680381B2A0B364EA275FD0233249E2", hash_generated_method = "7C0A48313FA8CEA7B17B7E452A98F7DE")
    
public abstract DatagramSocket socket();

    /**
     * Returns whether this channel's socket is connected or not.
     *
     * @return <code>true</code> if this channel's socket is connected;
     *         <code>false</code> otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.932 -0500", hash_original_method = "EF2DCF0240DCDAB71A78C6BD0371BA93", hash_generated_method = "640ACF0B46AF152682CD460E4AF1D091")
    
public abstract boolean isConnected();

    /**
     * Connects the socket of this channel to a remote address, which is the
     * only communication peer for getting and sending datagrams after being
     * connected.
     * <p>
     * This method can be called at any time without affecting the read and
     * write operations being processed at the time the method is called. The
     * connection status does not change until the channel is disconnected or
     * closed.
     * <p>
     * This method executes the same security checks as the connect method of
     * the {@link DatagramSocket} class.
     *
     * @param address
     *            the address to be connected to.
     * @return this channel.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             if some other I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.934 -0500", hash_original_method = "0E4CC7391FC9E92A64FAEFA761F4AAC5", hash_generated_method = "1CE4307E43A0C02A4C52A1D038C4A2B1")
    
public abstract DatagramChannel connect(SocketAddress address)
            throws IOException;

    /**
     * Disconnects the socket of this channel, which has been connected before
     * in order to send and receive datagrams.
     * <p>
     * This method can be called at any time without affecting the read and
     * write operations being underway. It does not have any effect if the
     * socket is not connected or the channel is closed.
     *
     * @return this channel.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.936 -0500", hash_original_method = "9AFA5E12D12D53FA9DBFCD022CA98D9B", hash_generated_method = "7BE8E7106E65749D5B400F04F6E52E0D")
    
public abstract DatagramChannel disconnect() throws IOException;

    /**
     * Gets a datagram from this channel.
     * <p>
     * This method transfers a datagram from the channel into the target byte
     * buffer. If this channel is in blocking mode, it waits for the datagram
     * and returns its address when it is available. If this channel is in
     * non-blocking mode and no datagram is available, it returns {@code null}
     * immediately. The transfer starts at the current position of the buffer,
     * and if there is not enough space remaining in the buffer to store the
     * datagram then the part of the datagram that does not fit is discarded.
     * <p>
     * This method can be called at any time and it will block if there is
     * another thread that has started a read operation on the channel.
     * <p>
     * This method executes the same security checks as the receive method of
     * the {@link DatagramSocket} class.
     *
     * @param target
     *            the byte buffer to store the received datagram.
     * @return the address of the datagram if the transfer is performed, or null
     *         if the channel is in non-blocking mode and no datagram is
     *         available.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.939 -0500", hash_original_method = "B41EF45D98E15F133EA4E8FF99F0E4E8", hash_generated_method = "BAEA6C7BCEB17A7C3D9E4EBF76E62D5D")
    
public abstract SocketAddress receive(ByteBuffer target) throws IOException;

    /**
     * Sends a datagram through this channel. The datagram consists of the
     * remaining bytes in {@code source}.
     * <p>
     * If this channel is in blocking mode then the datagram is sent as soon as
     * there is enough space in the underlying output buffer. If this channel is
     * in non-blocking mode then the datagram is only sent if there is enough
     * space in the underlying output buffer at that moment. The transfer action
     * is just like a regular write operation.
     * <p>
     * This method can be called at any time and it will block if another thread
     * has started a send operation on this channel.
     * <p>
     * This method executes the same security checks as the send method of the
     * {@link DatagramSocket} class.
     *
     * @param source
     *            the byte buffer with the datagram to be sent.
     * @param address
     *            the destination address for the datagram.
     * @return the number of bytes sent. This is the number of bytes remaining
     *         in {@code source} or zero if the channel is in non-blocking mode
     *         and there is not enough space for the datagram in the underlying
     *         output buffer.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.941 -0500", hash_original_method = "E3E32B28E031752D65B6134794224EFD", hash_generated_method = "918195DEDBE3EE1A477A192CDBF1BF97")
    
public abstract int send(ByteBuffer source, SocketAddress address) throws IOException;

    /**
     * Reads a datagram from this channel into the byte buffer.
     * <p>
     * The precondition for calling this method is that the channel is connected
     * and the incoming datagram is from the connected address. If the buffer is
     * not big enough to store the datagram, the part of the datagram that does
     * not fit in the buffer is discarded. Otherwise, this method has the same
     * behavior as the {@code read} method in the {@link ReadableByteChannel}
     * interface.
     *
     * @see java.nio.channels.ReadableByteChannel#read(java.nio.ByteBuffer)
     * @param target
     *            the byte buffer to store the received datagram.
     * @return a non-negative number as the number of bytes read, or -1 as the
     *         read operation reaches the end of stream.
     * @throws NotYetConnectedException
     *             if the channel is not connected yet.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSSource(DSSourceKind.IO)
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.943 -0500", hash_original_method = "84FBB9D1BC5805EDADF4DE7016C44EDC", hash_generated_method = "5540495000FF3F1891B3C274FE56D027")
    
public abstract int read(ByteBuffer target) throws IOException;

    /**
     * Reads a datagram from this channel into an array of byte buffers.
     * <p>
     * The precondition for calling this method is that the channel is connected
     * and the incoming datagram is from the connected address. If the buffers
     * do not have enough remaining space to store the datagram, the part of the
     * datagram that does not fit in the buffers is discarded. Otherwise, this
     * method has the same behavior as the {@code read} method in the
     * {@link ScatteringByteChannel} interface.
     *
     * @see java.nio.channels.ScatteringByteChannel#read(java.nio.ByteBuffer[],
     *      int, int)
     * @param targets
     *            the byte buffers to store the received datagram.
     * @param offset
     *            a non-negative offset in the array of buffers, pointing to the
     *            starting buffer to store the bytes transferred, must not be
     *            bigger than {@code targets.length}.
     * @param length
     *            a non-negative length to indicate the maximum number of
     *            buffers to be filled, must not be bigger than
     *            {@code targets.length - offset}.
     * @return a non-negative number as the number of bytes read, or -1 if the
     *         read operation reaches the end of stream.
     * @throws NotYetConnectedException
     *             if the channel is not connected yet.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.946 -0500", hash_original_method = "D81AA9F357BA1FF198462A59CEE5AF8B", hash_generated_method = "8EE18FA83203D9DC776A8A418E68592C")
    
public abstract long read(ByteBuffer[] targets, int offset, int length)
            throws IOException;

    /**
     * Reads a datagram from this channel into an array of byte buffers.
     * <p>
     * The precondition for calling this method is that the channel is connected
     * and the incoming datagram is from the connected address. If the buffers
     * do not have enough remaining space to store the datagram, the part of the
     * datagram that does not fit in the buffers is discarded. Otherwise, this
     * method has the same behavior as the {@code read} method in the
     * {@link ScatteringByteChannel} interface.
     *
     * @see java.nio.channels.ScatteringByteChannel#read(java.nio.ByteBuffer[])
     * @param targets
     *            the byte buffers to store the received datagram.
     * @return a non-negative number as the number of bytes read, or -1 if the
     *         read operation reaches the end of stream.
     * @throws NotYetConnectedException
     *             if the channel is not connected yet.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.949 -0500", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "ED00F097F990FA72EFB9F785613CC911")
    
public synchronized final long read(ByteBuffer[] targets)
            throws IOException {
        return read(targets, 0, targets.length);
    }

    /**
     * Writes a datagram from the byte buffer to this channel.
     * <p>
     * The precondition of calling this method is that the channel is connected
     * and the datagram is sent to the connected address. Otherwise, this method
     * has the same behavior as the {@code write} method in the
     * {@link WritableByteChannel} interface.
     *
     * @see java.nio.channels.WritableByteChannel#write(java.nio.ByteBuffer)
     * @param source
     *            the byte buffer as the source of the datagram.
     * @return a non-negative number of bytes written.
     * @throws NotYetConnectedException
     *             if the channel is not connected yet.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSSink(DSSinkKind.IO)
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.951 -0500", hash_original_method = "1C9E91C0F072B678D6E4CA1EF7282EDC", hash_generated_method = "CBB72B52B431F1EA5E7EE6413675146F")
    
public abstract int write(ByteBuffer source) throws IOException;

    /**
     * Writes a datagram from the byte buffers to this channel.
     * <p>
     * The precondition of calling this method is that the channel is connected
     * and the datagram is sent to the connected address. Otherwise, this method
     * has the same behavior as the {@code write} method in the
     * {@link GatheringByteChannel} interface.
     *
     * @see java.nio.channels.GatheringByteChannel#write(java.nio.ByteBuffer[],
     *      int, int)
     * @param sources
     *            the byte buffers as the source of the datagram.
     * @param offset
     *            a non-negative offset in the array of buffers, pointing to the
     *            starting buffer to be retrieved, must be no larger than
     *            {@code sources.length}.
     * @param length
     *            a non-negative length to indicate the maximum number of
     *            buffers to be submitted, must be no bigger than
     *            {@code sources.length - offset}.
     * @return the number of bytes written. If this method is called, it returns
     *         the number of bytes that where remaining in the byte buffers. If
     *         the channel is in non-blocking mode and there was not enough
     *         space for the datagram in the buffer, it may return zero.
     * @throws NotYetConnectedException
     *             if the channel is not connected yet.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.954 -0500", hash_original_method = "0318A187146637F0F5913A32559EC3D8", hash_generated_method = "57D37CA3F87B9F42073B88D7CA95CEF6")
    
public abstract long write(ByteBuffer[] sources, int offset, int length)
            throws IOException;

    /**
     * Writes a datagram from the byte buffers to this channel.
     * <p>
     * The precondition of calling this method is that the channel is connected
     * and the datagram is sent to the connected address. Otherwise, this method
     * has the same behavior as the write method in the
     * {@link GatheringByteChannel} interface.
     *
     * @see java.nio.channels.GatheringByteChannel#write(java.nio.ByteBuffer[])
     * @param sources
     *            the byte buffers as the source of the datagram.
     * @return the number of bytes written. If this method is called, it returns
     *         the number of bytes that where remaining in the byte buffer. If
     *         the channel is in non-blocking mode and there was not enough
     *         space for the datagram in the buffer, it may return zero.
     * @throws NotYetConnectedException
     *             if the channel is not connected yet.
     * @throws ClosedChannelException
     *             if the channel is already closed.
     * @throws AsynchronousCloseException
     *             if the channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while the
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws IOException
     *             some other I/O error occurs.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.956 -0500", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "80AEBA66643B1ECF4D7AF6ADCD7A806E")
    
public synchronized final long write(ByteBuffer[] sources)
            throws IOException {
        return write(sources, 0, sources.length);
    }
    
}

