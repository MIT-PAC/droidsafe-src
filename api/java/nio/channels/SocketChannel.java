package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {

    /**
     * Creates an open and unconnected socket channel.
     * <p>
     * This channel is created by calling {@code openSocketChannel()} of the
     * default {@link SelectorProvider} instance.
     *
     * @return the new channel which is open but unconnected.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.628 -0500", hash_original_method = "1C22500DDD1A1C4CBFF296D433984138", hash_generated_method = "BD5E389F8FE3DF580E59B07FBB199E75")
    
public static SocketChannel open() throws IOException {
        return SelectorProvider.provider().openSocketChannel();
    }

    /**
     * Creates a socket channel and connects it to a socket address.
     * <p>
     * This method performs a call to {@code open()} followed by a call to
     * {@code connect(SocketAddress)}.
     *
     * @param address
     *            the socket address to be connected to.
     * @return the new connected channel.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is executing.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is executing. The calling thread will have the
     *             interrupt state set and the channel will be closed.
     * @throws UnresolvedAddressException
     *             if the address is not resolved.
     * @throws UnsupportedAddressTypeException
     *             if the address type is not supported.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.630 -0500", hash_original_method = "AC2B95C5BDC217F19851C0632D37B5EC", hash_generated_method = "034337553752947731A0C6353DC0D7E3")
    
public static SocketChannel open(SocketAddress address) throws IOException {
        SocketChannel socketChannel = open();
        if (socketChannel != null) {
            socketChannel.connect(address);
        }
        return socketChannel;
    }

    /**
     * Constructs a new {@code SocketChannel}.
     *
     * @param selectorProvider
     *            an instance of SelectorProvider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.625 -0500", hash_original_method = "2E5B32673A9DF9A621D8F99910F278C2", hash_generated_method = "6761A3A6167403F79607C19EA6E441EE")
    
protected SocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
    }

    /**
     * Gets the valid operations of this channel. Socket channels support
     * connect, read and write operation, so this method returns
     * {@code SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE}.
     *
     * @return the operations supported by this channel.
     * @see java.nio.channels.SelectableChannel#validOps()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.633 -0500", hash_original_method = "329D33F04038C44D432D32526ECC7D14", hash_generated_method = "8FA2845B599AAD6756C1718F012079B6")
    
@Override
    public final int validOps() {
        return (SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    /**
     * Returns the socket assigned to this channel, which does not declare any public
     * methods that are not declared in {@code Socket}.
     *
     * @return the socket assigned to this channel.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.636 -0500", hash_original_method = "D13CC21BE3BC4EA472CA63F894296CE7", hash_generated_method = "9838D871440061866DFAA20C4E5401B9")
    
public abstract Socket socket();

    /**
     * Indicates whether this channel's socket is connected.
     *
     * @return {@code true} if this channel's socket is connected, {@code false}
     *         otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.638 -0500", hash_original_method = "EF2DCF0240DCDAB71A78C6BD0371BA93", hash_generated_method = "640ACF0B46AF152682CD460E4AF1D091")
    
public abstract boolean isConnected();

    /**
     * Indicates whether this channel's socket is still trying to connect.
     *
     * @return {@code true} if the connection is initiated but not finished;
     *         {@code false} otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.641 -0500", hash_original_method = "BE9EA5DF5228F76E2C0F080F812385E5", hash_generated_method = "516528913B2C11CF701C827F6429BDAE")
    
public abstract boolean isConnectionPending();

    /**
     * Connects this channel's socket with a remote address.
     * <p>
     * If this channel is blocking, this method will suspend until connecting is
     * finished or an I/O exception occurs. If the channel is non-blocking,
     * this method will return {@code true} if the connection is finished at
     * once or return {@code false} when the connection must be finished later
     * by calling {@code finishConnect()}.
     * <p>
     * This method can be called at any moment and can block other read and
     * write operations while connecting. It executes the same security checks
     * as the connect method of the {@code Socket} class.
     *
     * @param address
     *            the address to connect with.
     * @return {@code true} if the connection is finished, {@code false}
     *         otherwise.
     * @throws AlreadyConnectedException
     *             if the channel is already connected.
     * @throws ConnectionPendingException
     *             a non-blocking connecting operation is already executing on
     *             this channel.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is executing.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The calling thread will have the
     *             interrupt state set and this channel will be closed.
     * @throws UnresolvedAddressException
     *             if the address is not resolved.
     * @throws UnsupportedAddressTypeException
     *             if the address type is not supported.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.644 -0500", hash_original_method = "EF042CD430999BAF5A1AF2158097F6BB", hash_generated_method = "84563A591A56E321A1FB21BE663EFF3F")
    
public abstract boolean connect(SocketAddress address) throws IOException;

    /**
     * Completes the connection process initiated by a call of {@code
     * connect(SocketAddress)}.
     * <p>
     * This method returns {@code true} if the connection is finished already
     * and returns {@code false} if the channel is non-blocking and the
     * connection is not finished yet.
     * <p>
     * If this channel is in blocking mode, this method will suspend and return
     * {@code true} when the connection is finished. It closes this channel and
     * throws an exception if the connection fails.
     * <p>
     * This method can be called at any moment and it can block other {@code
     * read} and {@code write} operations while connecting.
     *
     * @return {@code true} if the connection is successfully finished, {@code
     *         false} otherwise.
     * @throws NoConnectionPendingException
     *             if the channel is not connected and the connection process
     *             has not been initiated.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is executing.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The calling thread has the
     *             interrupt state set, and this channel is closed.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.646 -0500", hash_original_method = "81C54D102AA55CD30CE0569D1C7BBF90", hash_generated_method = "16F3CFA8A040FF11376537FFBD2C2C0C")
    
public abstract boolean finishConnect() throws IOException;

    /**
     * Reads bytes from this socket channel into the given buffer.
     * <p>
     * The maximum number of bytes that will be read is the remaining number of
     * bytes in the buffer when the method is invoked. The bytes will be copied
     * into the buffer starting at the buffer's current position.
     * <p>
     * The call may block if other threads are also attempting to read from this
     * channel.
     * <p>
     * Upon completion, the buffer's position is set to the end of the bytes
     * that have been read. The buffer's limit is not changed.
     *
     * @param target
     *            the byte buffer to receive the bytes.
     * @return the number of bytes actually read.
     * @throws AsynchronousCloseException
     *             if another thread closes the channel during the read.
     * @throws NotYetConnectedException
     *             if this channel is not yet connected.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs.
     * @see java.nio.channels.ReadableByteChannel#read(java.nio.ByteBuffer)
     */
    
    @DSSourceTaintArgs()
    @DSSource(DSSourceKind.NETWORK_INFORMATION)
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.649 -0500", hash_original_method = "84FBB9D1BC5805EDADF4DE7016C44EDC", hash_generated_method = "5540495000FF3F1891B3C274FE56D027")
    
public abstract int read(ByteBuffer target) throws IOException;

    /**
     * Reads bytes from this socket channel into a subset of the given buffers.
     * This method attempts to read all {@code remaining()} bytes from {@code
     * length} byte buffers, in order, starting at {@code targets[offset]}. The
     * number of bytes actually read is returned.
     * <p>
     * If a read operation is in progress, subsequent threads will block until
     * the read is completed and will then contend for the ability to read.
     *
     * @param targets
     *            the array of byte buffers into which the bytes will be copied.
     * @param offset
     *            the index of the first buffer to store bytes in.
     * @param length
     *            the maximum number of buffers to store bytes in.
     * @return the number of bytes actually read.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread during this read
     *             operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if {@code
     *             offset + length} is greater than the size of {@code targets}.
     * @throws IOException
     *             if another I/O error occurs.
     * @throws NotYetConnectedException
     *             if this channel is not yet connected.
     * @see java.nio.channels.ScatteringByteChannel#read(java.nio.ByteBuffer[],
     *      int, int)
     */
    @DSSourceTaintArgs()
    @DSSource(DSSourceKind.NETWORK_INFORMATION)
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.651 -0500", hash_original_method = "D81AA9F357BA1FF198462A59CEE5AF8B", hash_generated_method = "8EE18FA83203D9DC776A8A418E68592C")
    
public abstract long read(ByteBuffer[] targets, int offset, int length) throws IOException;

    /**
     * Reads bytes from this socket channel and stores them in the specified
     * array of buffers. This method attempts to read as many bytes as can be
     * stored in the buffer array from this channel and returns the number of
     * bytes actually read.
     * <p>
     * If a read operation is in progress, subsequent threads will block until
     * the read is completed and will then contend for the ability to read.
     * <p>
     * Calling this method is equivalent to calling {@code read(targets, 0,
     * targets.length);}
     *
     * @param targets
     *            the array of byte buffers into which the bytes will be copied.
     * @return the number of bytes actually read.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread during this read
     *             operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs.
     * @throws NotYetConnectedException
     *             if this channel is not yet connected.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSourceTaintArgs()
    @DSSource(DSSourceKind.NETWORK_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.654 -0500", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "ED00F097F990FA72EFB9F785613CC911")
    
public synchronized final long read(ByteBuffer[] targets) throws IOException {
        return read(targets, 0, targets.length);
    }

    /**
     * Writes bytes from the given byte buffer to this socket channel. The
     * maximum number of bytes that are written is the remaining number of bytes
     * in the buffer when this method is invoked. The bytes are taken from the
     * buffer starting at the buffer's position.
     * <p>
     * The call may block if other threads are also attempting to write to the
     * same channel.
     * <p>
     * Upon completion, the buffer's position is updated to the end of the bytes
     * that have been written. The buffer's limit is not changed.
     *
     * @param source
     *            the byte buffer containing the bytes to be written.
     * @return the number of bytes actually written.
     * @throws AsynchronousCloseException
     *             if another thread closes the channel during the write.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws ClosedChannelException
     *             if the channel was already closed.
     * @throws IOException
     *             if another I/O error occurs.
     * @throws NotYetConnectedException
     *             if this channel is not connected yet.
     * @see java.nio.channels.WritableByteChannel#write(java.nio.ByteBuffer)
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.657 -0500", hash_original_method = "1C9E91C0F072B678D6E4CA1EF7282EDC", hash_generated_method = "CBB72B52B431F1EA5E7EE6413675146F")
    
public abstract int write(ByteBuffer source) throws IOException;

    /**
     * Attempts to write a subset of the given bytes from the buffers to this
     * socket channel. This method attempts to write all {@code remaining()}
     * bytes from {@code length} byte buffers, in order, starting at {@code
     * sources[offset]}. The number of bytes actually written is returned.
     * <p>
     * If a write operation is in progress, subsequent threads will block until
     * the write is completed and then contend for the ability to write.
     *
     * @param sources
     *            the array of byte buffers that is the source for bytes written
     *            to this channel.
     * @param offset
     *            the index of the first buffer in {@code buffers }to get bytes
     *            from.
     * @param length
     *            the number of buffers to get bytes from.
     * @return the number of bytes actually written to this channel.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread during this write
     *             operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if {@code
     *             offset + length} is greater than the size of {@code sources}.
     * @throws IOException
     *             if another I/O error occurs.
     * @throws NotYetConnectedException
     *             if this channel is not yet connected.
     * @see java.nio.channels.GatheringByteChannel#write(java.nio.ByteBuffer[],
     *      int, int)
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.659 -0500", hash_original_method = "0318A187146637F0F5913A32559EC3D8", hash_generated_method = "57D37CA3F87B9F42073B88D7CA95CEF6")
    
public abstract long write(ByteBuffer[] sources, int offset, int length) throws IOException;

    /**
     * Writes bytes from all the given byte buffers to this socket channel.
     * <p>
     * Calling this method is equivalent to calling {@code write(sources, 0,
     * sources.length);}
     *
     * @param sources
     *            the buffers containing bytes to write.
     * @return the number of bytes actually written.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread during this write
     *             operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs.
     * @throws NotYetConnectedException
     *             if this channel is not yet connected.
     * @see java.nio.channels.GatheringByteChannel#write(java.nio.ByteBuffer[])
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.662 -0500", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "80AEBA66643B1ECF4D7AF6ADCD7A806E")
    
public synchronized final long write(ByteBuffer[] sources) throws IOException {
        return write(sources, 0, sources.length);
    }
    
}

