package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public abstract class FileChannel extends AbstractInterruptibleChannel implements GatheringByteChannel, ScatteringByteChannel, ByteChannel {

    /**
     * Protected default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.358 -0500", hash_original_method = "EC2F86678151C05272A58EBF4D3007B7", hash_generated_method = "720775B864FB24C368C95FD654F70448")
    
protected FileChannel() {
    }

    /**
     * Requests that all updates to this channel are committed to the storage
     * device.
     * <p>
     * When this method returns, all modifications made to the platform file
     * underlying this channel have been committed if the file resides on a
     * local storage device. If the file is not hosted locally, for example on a
     * networked file system, then applications cannot be certain that the
     * modifications have been committed.
     * <p>
     * There are no assurances given that changes made to the file using methods
     * defined elsewhere will be committed. For example, changes made via a
     * mapped byte buffer may not be committed.
     * <p>
     * The <code>metadata</code> parameter indicates whether the update should
     * include the file's metadata such as last modification time, last access
     * time, etc. Note that passing <code>true</code> may invoke an underlying
     * write to the operating system (if the platform is maintaining metadata
     * such as last access time), even if the channel is opened read-only.
     *
     * @param metadata
     *            {@code true} if the file metadata should be flushed in
     *            addition to the file content, {@code false} otherwise.
     * @throws ClosedChannelException
     *             if this channel is already closed.
     * @throws IOException
     *             if another I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.361 -0500", hash_original_method = "61EBCEF4B94A7459672132AD7811DADE", hash_generated_method = "2B9F346152C011E3B65F2DAB75EBEB19")
    
public abstract void force(boolean metadata) throws IOException;

    /**
     * Obtains an exclusive lock on this file.
     * <p>
     * This is a convenience method for acquiring a maximum length lock on a
     * file. It is equivalent to:
     * {@code fileChannel.lock(0L, Long.MAX_VALUE, false);}
     *
     * @return the lock object representing the locked file area.
     * @throws ClosedChannelException
     *             the file channel is closed.
     * @throws NonWritableChannelException
     *             this channel was not opened for writing.
     * @throws OverlappingFileLockException
     *             either a lock is already held that overlaps this lock
     *             request, or another thread is waiting to acquire a lock that
     *             will overlap with this request.
     * @throws FileLockInterruptionException
     *             the calling thread was interrupted while waiting to acquire
     *             the lock.
     * @throws AsynchronousCloseException
     *             the channel was closed while the calling thread was waiting
     *             to acquire the lock.
     * @throws IOException
     *             if another I/O error occurs while obtaining the requested
     *             lock.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.363 -0500", hash_original_method = "DFAB2BF3C1A891B83AFBA77A43B03809", hash_generated_method = "A870032A5BE185398477C92B02CAC7A3")
    
public final FileLock lock() throws IOException {
        return lock(0L, Long.MAX_VALUE, false);
    }

    /**
     * Obtains a lock on a specified region of the file.
     * <p>
     * This is the blocking version of lock acquisition, see also the
     * <code>tryLock()</code> methods.
     * <p>
     * Attempts to acquire an overlapping lock region will fail. The attempt
     * will fail if the overlapping lock has already been obtained, or if
     * another thread is currently waiting to acquire the overlapping lock.
     * <p>
     * If the request is not for an overlapping lock, the thread calling this
     * method will block until the lock is obtained (likely by no contention or
     * another process releasing a lock), or until this thread is interrupted or
     * the channel is closed.
     * <p>
     * If the lock is obtained successfully then the {@link FileLock} object
     * returned represents the lock for subsequent operations on the locked
     * region.
     * <p>
     * If the thread is interrupted while waiting for the lock, the thread is
     * set to the interrupted state and throws a
     * {@link FileLockInterruptionException}. If this channel is closed while
     * the thread is waiting to obtain the lock then the thread throws a
     * {@link AsynchronousCloseException}.
     * <p>
     * There is no requirement for the position and size to be within the
     * current start and length of the file.
     * <p>
     * Some platforms do not support shared locks, and if a request is made for
     * a shared lock on such a platform, this method will attempt to acquire an
     * exclusive lock instead. It is undefined whether the lock obtained is
     * advisory or mandatory.
     *
     * @param position
     *            the starting position for the locked region.
     * @param size
     *            the length of the locked region in bytes.
     * @param shared
     *            a flag indicating whether an attempt should be made to acquire
     *            a shared lock.
     * @return the file lock object.
     * @throws IllegalArgumentException
     *             if {@code position} or {@code size} is negative.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws OverlappingFileLockException
     *             if the requested region overlaps an existing lock or pending
     *             lock request.
     * @throws NonReadableChannelException
     *             if the channel is not opened in read-mode but shared is true.
     * @throws NonWritableChannelException
     *             if the channel is not opened in write mode but shared is
     *             false.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is executing.
     * @throws FileLockInterruptionException
     *             if the thread is interrupted while in the state of waiting on
     *             the desired file lock.
     * @throws IOException
     *             if another I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.366 -0500", hash_original_method = "36155CCD191879126D8E713581E24518", hash_generated_method = "1A1268EF9581FF52B1081F47DCBD7FA2")
    
public abstract FileLock lock(long position, long size, boolean shared)
            throws IOException;

    /**
     * Maps the file into memory. There can be three modes: read-only,
     * read/write and private. After mapping, changes made to memory or the file
     * channel do not affect the other storage place.
     * <p>
     * Note: mapping a file into memory is usually expensive.
     *
     * @param mode
     *            one of the three mapping modes.
     * @param position
     *            the starting position of the file.
     * @param size
     *            the size of the region to map into memory.
     * @return the mapped byte buffer.
     * @throws NonReadableChannelException
     *             if the FileChannel is not opened for reading but the given
     *             mode is "READ_ONLY".
     * @throws NonWritableChannelException
     *             if the FileChannel is not opened for writing but the given
     *             mode is not "READ_ONLY".
     * @throws IllegalArgumentException
     *             if the given parameters of position and size are not correct.
     *             Both must be non negative. {@code size} also must not be
     *             bigger than max integer.
     * @throws IOException
     *             if any I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.368 -0500", hash_original_method = "A2BC4DBD035FEED75CAEA3D2096F8492", hash_generated_method = "53F009F81C3DAABB500D969C8E37BD55")
    
public abstract MappedByteBuffer map(FileChannel.MapMode mode,
            long position, long size) throws IOException;

    /**
     * Returns the current value of the file position pointer.
     *
     * @return the current position as a positive integer number of bytes from
     *         the start of the file.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.371 -0500", hash_original_method = "86318E3FB80940F1AAA533B2ACED4DF9", hash_generated_method = "095B82116960CE70F3D88FD85E36DEEC")
    
public abstract long position() throws IOException;

    /**
     * Sets the file position pointer to a new value.
     * <p>
     * The argument is the number of bytes counted from the start of the file.
     * The position cannot be set to a value that is negative. The new position
     * can be set beyond the current file size. If set beyond the current file
     * size, attempts to read will return end of file. Write operations will
     * succeed but they will fill the bytes between the current end of file and
     * the new position with the required number of (unspecified) byte values.
     *
     * @param offset
     *            the new file position, in bytes.
     * @return the receiver.
     * @throws IllegalArgumentException
     *             if the new position is negative.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.373 -0500", hash_original_method = "50275360EE0083C7C1733212A0550AD4", hash_generated_method = "8702A40A60C04552BC429A1BAAB729AB")
    
public abstract FileChannel position(long offset) throws IOException;

    /**
     * Reads bytes from this file channel into the given buffer.
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
     * @param buffer
     *            the byte buffer to receive the bytes.
     * @return the number of bytes actually read.
     * @throws AsynchronousCloseException
     *             if another thread closes the channel during the read.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread during the
     *             read.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs, details are in the message.
     * @throws NonReadableChannelException
     *             if the channel has not been opened in a mode that permits
     *             reading.
     */
    @DSSource({DSSourceKind.FILE})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.375 -0500", hash_original_method = "DE356E2CF3D3B7BE8C5411B6AE364543", hash_generated_method = "E4614D8711BA6249DDF8157E192C267E")
    
public abstract int read(ByteBuffer buffer) throws IOException;

    /**
     * Reads bytes from this file channel into the given buffer starting from
     * the specified file position.
     * <p>
     * The bytes are read starting at the given file position (up to the
     * remaining number of bytes in the buffer). The number of bytes actually
     * read is returned.
     * <p>
     * If {@code position} is beyond the current end of file, then no bytes are
     * read.
     * <p>
     * Note that the file position is unmodified by this method.
     *
     * @param buffer
     *            the buffer to receive the bytes.
     * @param position
     *            the (non-negative) position at which to read the bytes.
     * @return the number of bytes actually read.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is executing.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The calling thread will have the
     *             interrupt state set, and the channel will be closed.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IllegalArgumentException
     *             if <code>position</code> is less than 0.
     * @throws IOException
     *             if another I/O error occurs.
     * @throws NonReadableChannelException
     *             if the channel has not been opened in a mode that permits
     *             reading.
     */
    @DSSource({DSSourceKind.FILE})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.378 -0500", hash_original_method = "19A1A80A2A8297FB8F1FB19A576CD97B", hash_generated_method = "5D6844A43D3ECFC11747B3DA9689C100")
    
public abstract int read(ByteBuffer buffer, long position)
            throws IOException;

    /**
     * Reads bytes from this file channel and stores them in the specified array
     * of buffers. This method attempts to read as many bytes as can be stored
     * in the buffer array from this channel and returns the number of bytes
     * actually read. It also increases the file position by the number of bytes
     * read.
     * <p>
     * If a read operation is in progress, subsequent threads will block until
     * the read is completed and will then contend for the ability to read.
     * <p>
     * Calling this method is equivalent to calling
     * {@code read(buffers, 0, buffers.length);}
     *
     * @param buffers
     *            the array of byte buffers into which the bytes will be copied.
     * @return the number of bytes actually read.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread during this read
     *             operation.
     * @throws ClosedByInterruptException
     *             if the thread is interrupted by another thread during this
     *             read operation.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs; details are in the message.
     * @throws NonReadableChannelException
     *             if the channel has not been opened in a mode that permits
     *             reading.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.381 -0500", hash_original_method = "4118483D5739F1F8B1E72DACCDF365C6", hash_generated_method = "5E3DE9B53B261351875D534317A11FE9")
    
public final long read(ByteBuffer[] buffers) throws IOException {
        return read(buffers, 0, buffers.length);
    }

    /**
     * Reads bytes from this file channel into a subset of the given buffers.
     * This method attempts to read all {@code remaining()} bytes from {@code
     * length} byte buffers, in order, starting at {@code targets[offset]}. It
     * increases the file position by the number of bytes actually read. The
     * number of bytes actually read is returned.
     * <p>
     * If a read operation is in progress, subsequent threads will block until
     * the read is completed and will then contend for the ability to read.
     *
     * @param buffers
     *            the array of byte buffers into which the bytes will be copied.
     * @param start
     *            the index of the first buffer to store bytes in.
     * @param number
     *            the maximum number of buffers to store bytes in.
     * @return the number of bytes actually read.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread during this read
     *             operation.
     * @throws ClosedByInterruptException
     *             if the thread is interrupted by another thread during this
     *             read operation.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IndexOutOfBoundsException
     *             if {@code start < 0} or {@code number < 0}, or if
     *             {@code start + number} is greater than the size of
     *             {@code buffers}.
     * @throws IOException
     *             if another I/O error occurs; details are in the message.
     * @throws NonReadableChannelException
     *             if the channel has not been opened in a mode that permits
     *             reading.
     */
    @DSSource({DSSourceKind.FILE})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.384 -0500", hash_original_method = "7B96FC6FAB2F090D69C3DCBFF89C815B", hash_generated_method = "B0149C348230C332CE6BEFBA3208C156")
    
public abstract long read(ByteBuffer[] buffers, int start, int number)
            throws IOException;

    /**
     * Returns the size of the file underlying this channel in bytes.
     *
     * @return the size of the file in bytes.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if an I/O error occurs while getting the size of the file.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.386 -0500", hash_original_method = "533E99DC61BBBC696C27BAAAE618F5D9", hash_generated_method = "CDF3B561CA5CAE9E5BFB6F445BEFCE76")
    
public abstract long size() throws IOException;

    /**
     * Reads up to {@code count} bytes from {@code src} and stores them in this
     * channel's file starting at {@code position}. No bytes are transferred if
     * {@code position} is larger than the size of this channel's file. Less
     * than {@code count} bytes are transferred if there are less bytes
     * remaining in the source channel or if the source channel is non-blocking
     * and has less than {@code count} bytes immediately available in its output
     * buffer.
     * <p>
     * Note that this channel's position is not modified.
     *
     * @param src
     *            the source channel to read bytes from.
     * @param position
     *            the non-negative start position.
     * @param count
     *            the non-negative number of bytes to transfer.
     * @return the number of bytes that are transferred.
     * @throws IllegalArgumentException
     *             if the parameters are invalid.
     * @throws NonReadableChannelException
     *             if the source channel is not readable.
     * @throws NonWritableChannelException
     *             if this channel is not writable.
     * @throws ClosedChannelException
     *             if either channel has already been closed.
     * @throws AsynchronousCloseException
     *             if either channel is closed by other threads during this
     *             operation.
     * @throws ClosedByInterruptException
     *             if the thread is interrupted during this operation.
     * @throws IOException
     *             if any I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.388 -0500", hash_original_method = "BF5C523214ACE0203C5F07D23BFB5334", hash_generated_method = "CB134CE9BEDA7D9D6F4CDE2E7ADDD06B")
    
public abstract long transferFrom(ReadableByteChannel src, long position,
            long count) throws IOException;

    /**
     * Reads up to {@code count} bytes from this channel's file starting at
     * {@code position} and writes them to {@code target}. No bytes are
     * transferred if {@code position} is larger than the size of this channel's
     * file. Less than {@code count} bytes are transferred if there less bytes
     * available from this channel's file or if the target channel is
     * non-blocking and has less than {@code count} bytes free in its input
     * buffer.
     * <p>
     * Note that this channel's position is not modified.
     *
     * @param position
     *            the non-negative position to begin.
     * @param count
     *            the non-negative number of bytes to transfer.
     * @param target
     *            the target channel to write to.
     * @return the number of bytes that were transferred.
     * @throws IllegalArgumentException
     *             if the parameters are invalid.
     * @throws NonReadableChannelException
     *             if this channel is not readable.
     * @throws NonWritableChannelException
     *             if the target channel is not writable.
     * @throws ClosedChannelException
     *             if either channel has already been closed.
     * @throws AsynchronousCloseException
     *             if either channel is closed by other threads during this
     *             operation.
     * @throws ClosedByInterruptException
     *             if the thread is interrupted during this operation.
     * @throws IOException
     *             if any I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.391 -0500", hash_original_method = "7DCEB5A88D5F4847CF78A45513AA406A", hash_generated_method = "52B302591A2C8323208E0F6D44BED1D3")
    
public abstract long transferTo(long position, long count,
            WritableByteChannel target) throws IOException;

    /**
     * Truncates the file underlying this channel to a given size. Any bytes
     * beyond the given size are removed from the file. If there are no bytes
     * beyond the given size then the file contents are unmodified.
     * <p>
     * If the file position is currently greater than the given size, then it is
     * set to the new size.
     *
     * @param size
     *            the maximum size of the underlying file.
     * @throws IllegalArgumentException
     *             if the requested size is negative.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws NonWritableChannelException
     *             if the channel cannot be written to.
     * @throws IOException
     *             if another I/O error occurs.
     * @return this channel.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.393 -0500", hash_original_method = "D825937878D60F01461C9636076BDCF3", hash_generated_method = "C8C6F1AB8869E88DAD37A0C419CF170D")
    
public abstract FileChannel truncate(long size) throws IOException;

    /**
     * Attempts to acquire an exclusive lock on this file without blocking.
     * <p>
     * This is a convenience method for attempting to acquire a maximum length
     * lock on the file. It is equivalent to:
     * {@code fileChannel.tryLock(0L, Long.MAX_VALUE, false);}
     * <p>
     * The method returns {@code null} if the acquisition would result in an
     * overlapped lock with another OS process.
     *
     * @return the file lock object, or {@code null} if the lock would overlap
     *         with an existing exclusive lock in another OS process.
     * @throws ClosedChannelException
     *             if the file channel is closed.
     * @throws OverlappingFileLockException
     *             if a lock already exists that overlaps this lock request or
     *             another thread is waiting to acquire a lock that will overlap
     *             with this request.
     * @throws IOException
     *             if any I/O error occurs.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.397 -0500", hash_original_method = "F4B810DA7C3314CA042E76DA336480A9", hash_generated_method = "765B70727AF6AE5E4DD4630CCB15527C")
    
public final FileLock tryLock() throws IOException {
        return tryLock(0L, Long.MAX_VALUE, false);
    }

    /**
     * Attempts to acquire an exclusive lock on this file without blocking. The
     * method returns {@code null} if the acquisition would result in an
     * overlapped lock with another OS process.
     * <p>
     * It is possible to acquire a lock for any region even if it's completely
     * outside of the file's size. The size of the lock is fixed. If the file
     * grows outside of the lock that region of the file won't be locked by this
     * lock.
     *
     * @param position
     *            the starting position.
     * @param size
     *            the size of file to lock.
     * @param shared
     *            true if the lock is shared.
     * @return the file lock object, or {@code null} if the lock would overlap
     *         with an existing exclusive lock in another OS process.
     * @throws IllegalArgumentException
     *             if any parameters are invalid.
     * @throws ClosedChannelException
     *             if the file channel is closed.
     * @throws OverlappingFileLockException
     *             if a lock is already held that overlaps this lock request or
     *             another thread is waiting to acquire a lock that will overlap
     *             with this request.
     * @throws IOException
     *             if any I/O error occurs.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.399 -0500", hash_original_method = "069917A2201DF3B10F8F8DD124DA59AD", hash_generated_method = "82031EE4A79726435431B4685008646B")
    
public abstract FileLock tryLock(long position, long size, boolean shared)
            throws IOException;

    /**
     * Writes bytes from the given byte buffer to this file channel.
     * <p>
     * The bytes are written starting at the current file position, and after
     * some number of bytes are written (up to the remaining number of bytes in
     * the buffer) the file position is increased by the number of bytes
     * actually written.
     *
     * @param src
     *            the byte buffer containing the bytes to be written.
     * @return the number of bytes actually written.
     * @throws NonWritableChannelException
     *             if the channel was not opened for writing.
     * @throws ClosedChannelException
     *             if the channel was already closed.
     * @throws AsynchronousCloseException
     *             if another thread closes the channel during the write.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws IOException
     *             if another I/O error occurs, details are in the message.
     * @see java.nio.channels.WritableByteChannel#write(java.nio.ByteBuffer)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.401 -0500", hash_original_method = "D87BCA67F95D1FD6B9CB7D4E4ADD1B2A", hash_generated_method = "FA9F2388453D6D813A2368038E57E8FD")
    
public abstract int write(ByteBuffer src) throws IOException;

    /**
     * Writes bytes from the given buffer to this file channel starting at the
     * given file position.
     * <p>
     * The bytes are written starting at the given file position (up to the
     * remaining number of bytes in the buffer). The number of bytes actually
     * written is returned.
     * <p>
     * If the position is beyond the current end of file, then the file is first
     * extended up to the given position by the required number of unspecified
     * byte values.
     * <p>
     * Note that the file position is not modified by this method.
     *
     * @param buffer
     *            the buffer containing the bytes to be written.
     * @param position
     *            the (non-negative) position at which to write the bytes.
     * @return the number of bytes actually written.
     * @throws IllegalArgumentException
     *             if <code>position</code> is less than 0.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws NonWritableChannelException
     *             if the channel was not opened in write-mode.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is executing.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws IOException
     *             if another I/O error occurs.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.404 -0500", hash_original_method = "FE44E4912270B085CA3AFC2E6840559E", hash_generated_method = "10862CCEADBBE800DF252131F9DE485B")
    
public abstract int write(ByteBuffer buffer, long position)
            throws IOException;

    /**
     * Writes bytes from all the given byte buffers to this file channel.
     * <p>
     * The bytes are written starting at the current file position, and after
     * the bytes are written (up to the remaining number of bytes in all the
     * buffers), the file position is increased by the number of bytes actually
     * written.
     * <p>
     * Calling this method is equivalent to calling
     * {@code write(buffers, 0, buffers.length);}
     *
     * @param buffers
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
     *             if another I/O error occurs; details are in the message.
     * @throws NonWritableChannelException
     *             if this channel was not opened for writing.
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.407 -0500", hash_original_method = "50EBF858502260FDC2F74EB3C865D254", hash_generated_method = "7AA1B97F418BF33310818DAF604E2235")
    
public final long write(ByteBuffer[] buffers) throws IOException {
        return write(buffers, 0, buffers.length);
    }

    /**
     * Attempts to write a subset of the given bytes from the buffers to this
     * file channel. This method attempts to write all {@code remaining()}
     * bytes from {@code length} byte buffers, in order, starting at {@code
     * sources[offset]}. The number of bytes actually written is returned.
     * <p>
     * If a write operation is in progress, subsequent threads will block until
     * the write is completed and then contend for the ability to write.
     *
     * @param buffers
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
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the size of
     *             {@code buffers}.
     * @throws IOException
     *             if another I/O error occurs; details are in the message.
     * @throws NonWritableChannelException
     *             if this channel was not opened for writing.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.409 -0500", hash_original_method = "AC372293C8ABAB0E308F0F7E86460068", hash_generated_method = "5194FA121EAA05CA674317B28600EE9B")
    
public abstract long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;
    
    public static class MapMode {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.340 -0500", hash_original_field = "F54DBA0E8003D347C0E5FC6C7F122070", hash_generated_field = "E61C6941861B8B13323795D9F76ADC35")

        public static final MapMode PRIVATE = new MapMode("PRIVATE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.343 -0500", hash_original_field = "588F18139B210A02885B9518CF5887F4", hash_generated_field = "73340F0AACAD2D5EA6BC7E1EEA96187B")

        public static final MapMode READ_ONLY = new MapMode("READ_ONLY");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.346 -0500", hash_original_field = "09D539976C591A7E03DD6B373983E8AE", hash_generated_field = "04922E3259BB871A02F86B60071A2FD5")

        public static final MapMode READ_WRITE = new MapMode("READ_WRITE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.349 -0500", hash_original_field = "BB0F3128C925598F592DB9E6926FCA25", hash_generated_field = "EC3AB759487D6B2DE8D7429A76BFCE45")

        private  String displayName;

        /*
         * Private constructor prevents others creating new modes.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.351 -0500", hash_original_method = "CA25667E00C4DE16C856657D4E26E93A", hash_generated_method = "79A3B4CE250D4F31DAF740FFA9928F62")
        
private MapMode(String displayName) {
            this.displayName = displayName;
        }

        /**
         * Returns a string version of the mapping mode.
         *
         * @return this map mode as string.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.354 -0500", hash_original_method = "224E04BA70E2891F43254A5C70CBC214", hash_generated_method = "867852FDF30FD3913C1FC1BFB210F9EE")
        
@Override
        public String toString() {
            return displayName;
        }
    }
    
}

