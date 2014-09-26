package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.EAGAIN;
import static libcore.io.OsConstants.EINVAL;
import static libcore.io.OsConstants.ENOSYS;
import static libcore.io.OsConstants.F_RDLCK;
import static libcore.io.OsConstants.F_SETLK64;
import static libcore.io.OsConstants.F_SETLKW64;
import static libcore.io.OsConstants.F_UNLCK;
import static libcore.io.OsConstants.F_WRLCK;
import static libcore.io.OsConstants.O_ACCMODE;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.O_WRONLY;
import static libcore.io.OsConstants.SEEK_CUR;
import static libcore.io.OsConstants.SEEK_SET;
import static libcore.io.OsConstants._SC_PAGE_SIZE;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.StructFlock;
import libcore.util.MutableLong;

final class FileChannelImpl extends FileChannel {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.512 -0500", hash_original_method = "C892B9EA3C98B5FB0FB2A090E1347610", hash_generated_method = "B32E4875AF7CFD2CDEA1E1EF5BB166E1")
    
private static long translateLockLength(long byteCount) {
        // FileChannel uses Long.MAX_VALUE to mean "lock the whole file" where POSIX uses 0.
        return (byteCount == Long.MAX_VALUE) ? 0 : byteCount;
    }

    /**
     * @param copyingIn true if we're copying data into the buffers (typically
     * because the caller is a file/network read operation), false if we're
     * copying data out of the buffers (for a file/network write operation).
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.587 -0500", hash_original_method = "CC8EF642A7E7880A25F803B71E120073", hash_generated_method = "084EEE3AD0FC53AA4DA4FD5A2EC6A78E")
    
static int calculateTotalRemaining(ByteBuffer[] buffers, int offset, int length, boolean copyingIn) {
        int count = 0;
        for (int i = offset; i < offset + length; ++i) {
            count += buffers[i].remaining();
            if (copyingIn) {
                buffers[i].checkWritable();
            }
        }
        return count;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.298 -0400", hash_original_field = "214EF2C30F414C8FDB98024F4777CF3E", hash_generated_field = "B942C76CBADD07E46C36C598F3CE8A93")

    private static final Comparator<FileLock> LOCK_COMPARATOR = new Comparator<FileLock>() {
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.298 -0400", hash_original_method = "BAD31C1963B2F965BA94839291F4C17C", hash_generated_method = "09544778190497FCE22242F527472A85")
        public int compare(FileLock lock1, FileLock lock2) {
            long position1 = lock1.position();
            long position2 = lock2.position();
            addTaint(lock1.getTaint());
            addTaint(lock2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230991941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230991941;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.485 -0500", hash_original_field = "441430C2BFB387D21BEB92146729BB52", hash_generated_field = "6DF85966286B5A79BC125BD24D7FC97F")

    private  Object stream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.487 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private  FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.490 -0500", hash_original_field = "462D02655D7DD7DF6E5BA12D65851DD2", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private  int mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.493 -0500", hash_original_field = "E823CE0628309F47FC2C1B76874876DF", hash_generated_field = "41CABECFE29C1BC14C56B2F0C987CEF1")

    private final SortedSet<FileLock> locks = new TreeSet<FileLock>(LOCK_COMPARATOR);

    /**
     * Create a new file channel implementation class that wraps the given
     * fd and operates in the specified mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.495 -0500", hash_original_method = "2735A1029D285B5D3DE10DB0E230E666", hash_generated_method = "14AD51EE24F52D76DEA85DCFD1BF0956")
    
public FileChannelImpl(Object stream, FileDescriptor fd, int mode) {
        this.fd = fd;
        this.stream = stream;
        this.mode = mode;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.497 -0500", hash_original_method = "6E6D3E88914C52E71D3EAF93EC51DF72", hash_generated_method = "EAD3E99B497BB5C7F2AA8E02811E691E")
    
private void checkOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.500 -0500", hash_original_method = "48C6D0CA0A11D20CF44BD79CC21BDD35", hash_generated_method = "E623D67D319BE599F94C82D8898CC8E6")
    
private void checkReadable() {
        if ((mode & O_ACCMODE) == O_WRONLY) {
            throw new NonReadableChannelException();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.502 -0500", hash_original_method = "B5384AE1DC067BB9B7371F695174CE9F", hash_generated_method = "C1239697E9EE610FCF515245599952B1")
    
private void checkWritable() {
        if ((mode & O_ACCMODE) == O_RDONLY) {
            throw new NonWritableChannelException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.504 -0500", hash_original_method = "906DDDB64CDCD744F2CC12CE5FEEB0F8", hash_generated_method = "5E428E9B037667F1956DAFFFB13763E2")
    
protected void implCloseChannel() throws IOException {
        if (stream instanceof Closeable) {
            ((Closeable) stream).close();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.508 -0500", hash_original_method = "7E2D5FC994D104072ED63DC91E4C8FE1", hash_generated_method = "698352901D8AF7F322690A35B3ECDA70")
    
private FileLock basicLock(long position, long size, boolean shared, boolean wait) throws IOException {
        int accessMode = (mode & O_ACCMODE);
        if (accessMode == O_RDONLY) {
            if (!shared) {
                throw new NonWritableChannelException();
            }
        } else if (accessMode == O_WRONLY) {
            if (shared) {
                throw new NonReadableChannelException();
            }
        }

        if (position < 0 || size < 0) {
            throw new IllegalArgumentException("position=" + position + " size=" + size);
        }

        FileLock pendingLock = new FileLockImpl(this, position, size, shared);
        addLock(pendingLock);

        StructFlock flock = new StructFlock();
        flock.l_type = (short) (shared ? F_RDLCK : F_WRLCK);
        flock.l_whence = (short) SEEK_SET;
        flock.l_start = position;
        flock.l_len = translateLockLength(size);

        boolean success = false;
        try {
            success = (Libcore.os.fcntlFlock(fd, wait ? F_SETLKW64 : F_SETLK64, flock) != -1);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        } finally {
            if (!success) {
                removeLock(pendingLock);
            }
        }
        return success ? pendingLock : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.528 -0500", hash_original_method = "2D9781ECA7693E91068070ABFFE1E1EC", hash_generated_method = "976F9899B5C2DC0F8D46AF69291C8903")
    
public final FileLock lock(long position, long size, boolean shared) throws IOException {
        checkOpen();
        FileLock resultLock = null;
        {
            boolean completed = false;
            try {
                begin();
                resultLock = basicLock(position, size, shared, true);
                completed = true;
            } finally {
                end(completed);
            }
        }
        return resultLock;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.531 -0500", hash_original_method = "EEB7B11B25906F0628185BB3DA938264", hash_generated_method = "05A81211E7475F69BAED770F4FDEEFBC")
    
public final FileLock tryLock(long position, long size, boolean shared) throws IOException {
        checkOpen();
        return basicLock(position, size, shared, false);
    }

    /**
     * Non-API method to release a given lock on a file channel. Assumes that
     * the lock will mark itself invalid after successful unlocking.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.533 -0500", hash_original_method = "62214805062DB6ECE1A1C9B69D272F36", hash_generated_method = "26A00544EB52F6F007616F3D38D09FA5")
    
public void release(FileLock lock) throws IOException {
        checkOpen();

        StructFlock flock = new StructFlock();
        flock.l_type = (short) F_UNLCK;
        flock.l_whence = (short) SEEK_SET;
        flock.l_start = lock.position();
        flock.l_len = translateLockLength(lock.size());
        try {
            Libcore.os.fcntlFlock(fd, F_SETLKW64, flock);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }

        removeLock(lock);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.536 -0500", hash_original_method = "66F727B932913E59560F8F92301E4A0B", hash_generated_method = "7EE9FE2006AA2367DBCD39B808EE00FB")
    
public void force(boolean metadata) throws IOException {
        checkOpen();
        if ((mode & O_ACCMODE) != O_RDONLY) {
            try {
                if (metadata) {
                    Libcore.os.fsync(fd);
                } else {
                    Libcore.os.fdatasync(fd);
                }
            } catch (ErrnoException errnoException) {
                throw errnoException.rethrowAsIOException();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.539 -0500", hash_original_method = "5452C18A8AEE816635F14172EC065A87", hash_generated_method = "144FE0AD55A511289AF3E55C4998EF45")
    
public final MappedByteBuffer map(MapMode mapMode, long position, long size) throws IOException {
        checkOpen();
        if (mapMode == null) {
            throw new NullPointerException("mapMode == null");
        }
        if (position < 0 || size < 0 || size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("position=" + position + " size=" + size);
        }
        int accessMode = (mode & O_ACCMODE);
        if (accessMode == O_RDONLY) {
            if (mapMode != MapMode.READ_ONLY) {
                throw new NonWritableChannelException();
            }
        } else if (accessMode == O_WRONLY) {
            throw new NonReadableChannelException();
        }
        if (position + size > size()) {
            // We can't defer to FileChannel.truncate because that will only make a file shorter,
            // and we only care about making our backing file longer here.
            try {
                Libcore.os.ftruncate(fd, position + size);
            } catch (ErrnoException errnoException) {
                throw errnoException.rethrowAsIOException();
            }
        }
        long alignment = position - position % Libcore.os.sysconf(_SC_PAGE_SIZE);
        int offset = (int) (position - alignment);
        MemoryBlock block = MemoryBlock.mmap(fd, alignment, size + offset, mapMode);
        return new MappedByteBufferAdapter(block, (int) size, offset, mapMode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.541 -0500", hash_original_method = "2294C6BEF1501D1EBDDF8CC0BA1CBE45", hash_generated_method = "C957F2E4AED64AB5DEA1ED688F71329E")
    
public long position() throws IOException {
        checkOpen();
        try {
            return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.544 -0500", hash_original_method = "38E87DF17F47600879F85DE74B488325", hash_generated_method = "2E656BCD930B9ECF77D2F404740EDDA1")
    
public FileChannel position(long newPosition) throws IOException {
        checkOpen();
        if (newPosition < 0) {
            throw new IllegalArgumentException("position: " + newPosition);
        }
        try {
            Libcore.os.lseek(fd, newPosition, SEEK_SET);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
        return this;
    }

    @DSSource({DSSourceKind.FILE})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.546 -0500", hash_original_method = "CBC403D41CEC137F7E33592DD6647C43", hash_generated_method = "3FADB3ED7EBD78A3F57915DFA9C3A0E0")
    
public int read(ByteBuffer buffer, long position) throws IOException {
        if (position < 0) {
            throw new IllegalArgumentException("position: " + position);
        }
        return readImpl(buffer, position);
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.548 -0500", hash_original_method = "5BE7BADF8838BD61276F9CD3980F7CA7", hash_generated_method = "54A47B7BA1FF3C8CDFA763B26A6EAB46")
    
public int read(ByteBuffer buffer) throws IOException {
        return readImpl(buffer, -1);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.552 -0500", hash_original_method = "B09A36EC89FDAA97AACE4894ACCEC4C2", hash_generated_method = "3AF7B7D3F9D74A7024FFE2B4E24D7ACD")
    
private int readImpl(ByteBuffer buffer, long position) throws IOException {
        buffer.checkWritable();
        checkOpen();
        checkReadable();
        if (!buffer.hasRemaining()) {
            return 0;
        }
        int bytesRead = 0;
        boolean completed = false;
        try {
            begin();
            try {
                if (position == -1) {
                    bytesRead = Libcore.os.read(fd, buffer);
                } else {
                    bytesRead = Libcore.os.pread(fd, buffer, position);
                }
                if (bytesRead == 0) {
                    bytesRead = -1;
                }
            } catch (ErrnoException errnoException) {
                if (errnoException.errno == EAGAIN) {
                    // We don't throw if we try to read from an empty non-blocking pipe.
                    bytesRead = 0;
                } else {
                    throw errnoException.rethrowAsIOException();
                }
            }
            completed = true;
        } finally {
            end(completed && bytesRead >= 0);
        }
        if (bytesRead > 0) {
            buffer.position(buffer.position() + bytesRead);
        }
        return bytesRead;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.555 -0500", hash_original_method = "4AF9CF697EB56447960A29F46F724C12", hash_generated_method = "E603EEFAA438D42EA2302D2E708EB2B3")
    
private int transferIoVec(IoVec ioVec) throws IOException {
        if (ioVec.init() == 0) {
            return 0;
        }
        int bytesTransferred = 0;
        boolean completed = false;
        try {
            begin();
            bytesTransferred = ioVec.doTransfer(fd);
            completed = true;
        } finally {
            end(completed);
        }
        ioVec.didTransfer(bytesTransferred);
        return bytesTransferred;
    }

    @DSSource({DSSourceKind.FILE})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.557 -0500", hash_original_method = "C19453CFF2AA37841406A95ED2CF0809", hash_generated_method = "C7CD3E7850A60244C4542120CF24B952")
    
public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkReadable();
        return transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV));
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.560 -0500", hash_original_method = "BF0F3D7AEFAA2AFACA7A21CBB184DE89", hash_generated_method = "26F7C8C25E81F04259EDA281AEDBBF47")
    
public long size() throws IOException {
        checkOpen();
        try {
            return Libcore.os.fstat(fd).st_size;
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.563 -0500", hash_original_method = "80C3AD203B1B9D1C1064C9E60FE9152A", hash_generated_method = "EF38F694EAC0C8D0E96F3AEAACC0B776")
    
public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        checkOpen();
        if (!src.isOpen()) {
            throw new ClosedChannelException();
        }
        checkWritable();
        if (position < 0 || count < 0 || count > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("position=" + position + " count=" + count);
        }
        if (position > size()) {
            return 0;
        }

        // Although sendfile(2) originally supported writing to a regular file.
        // In Linux 2.6 and later, it only supports writing to sockets.

        // If our source is a regular file, mmap(2) rather than reading.
        // Callers should only be using transferFrom for large transfers,
        // so the mmap(2) overhead isn't a concern.
        if (src instanceof FileChannel) {
            FileChannel fileSrc = (FileChannel) src;
            long size = fileSrc.size();
            long filePosition = fileSrc.position();
            count = Math.min(count, size - filePosition);
            ByteBuffer buffer = fileSrc.map(MapMode.READ_ONLY, filePosition, count);
            try {
                fileSrc.position(filePosition + count);
                return write(buffer, position);
            } finally {
                NioUtils.freeDirectBuffer(buffer);
            }
        }

        // For non-file channels, all we can do is read and write via userspace.
        ByteBuffer buffer = ByteBuffer.allocate((int) count);
        src.read(buffer);
        buffer.flip();
        return write(buffer, position);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.566 -0500", hash_original_method = "66697B5A4B32B4AD2132D8B7D53DF0CD", hash_generated_method = "E6AFCDF6EC62C6E6A2C6ED051A91F89E")
    
public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        checkOpen();
        if (!target.isOpen()) {
            throw new ClosedChannelException();
        }
        checkReadable();
        if (target instanceof FileChannelImpl) {
            ((FileChannelImpl) target).checkWritable();
        }
        if (position < 0 || count < 0) {
            throw new IllegalArgumentException("position=" + position + " count=" + count);
        }

        if (count == 0 || position >= size()) {
            return 0;
        }
        count = Math.min(count, size() - position);

        // Try sendfile(2) first...
        boolean completed = false;
        if (target instanceof SocketChannelImpl) {
            FileDescriptor outFd = ((SocketChannelImpl) target).getFD();
            try {
                begin();
                try {
                    MutableLong offset = new MutableLong(position);
                    long rc = Libcore.os.sendfile(outFd, fd, offset, count);
                    completed = true;
                    return rc;
                } catch (ErrnoException errnoException) {
                    // If the OS doesn't support what we asked for, we want to fall through and
                    // try a different approach. If it does support it, but it failed, we're done.
                    if (errnoException.errno != ENOSYS && errnoException.errno != EINVAL) {
                        throw errnoException.rethrowAsIOException();
                    }
                }
            } finally {
                end(completed);
            }
        }
        // ...fall back to write(2).
        ByteBuffer buffer = null;
        try {
            buffer = map(MapMode.READ_ONLY, position, count);
            return target.write(buffer);
        } finally {
            NioUtils.freeDirectBuffer(buffer);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.568 -0500", hash_original_method = "062BFFD7E484D8312E945E8E43437F48", hash_generated_method = "225A4B596A2F73D2F953544EBC66BFA8")
    
public FileChannel truncate(long size) throws IOException {
        checkOpen();
        if (size < 0) {
            throw new IllegalArgumentException("size: " + size);
        }
        checkWritable();
        if (size < size()) {
            try {
                Libcore.os.ftruncate(fd, size);
            } catch (ErrnoException errnoException) {
                throw errnoException.rethrowAsIOException();
            }
        }
        return this;
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.577 -0500", hash_original_method = "D694A533B6DF57B5FA961A08FD2C2C8C", hash_generated_method = "F62991CF6F6B47FAB30CBB4D6EEB8317")
    
public int write(ByteBuffer buffer, long position) throws IOException {
        if (position < 0) {
            throw new IllegalArgumentException("position: " + position);
        }
        return writeImpl(buffer, position);
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.580 -0500", hash_original_method = "50D91170AD5AAA80BF5888A2631505BE", hash_generated_method = "D23FCD9ADA11EB30655F72711AF5856C")
    
public int write(ByteBuffer buffer) throws IOException {
        return writeImpl(buffer, -1);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.583 -0500", hash_original_method = "B7C7E18920DBBA232C5F1428FFA4A3EB", hash_generated_method = "BFFA84CCBFE736ECF3F5F74048CD492D")
    
private int writeImpl(ByteBuffer buffer, long position) throws IOException {
        checkOpen();
        checkWritable();
        if (buffer == null) {
            throw new NullPointerException("buffer == null");
        }
        if (!buffer.hasRemaining()) {
            return 0;
        }
        int bytesWritten = 0;
        boolean completed = false;
        try {
            begin();
            try {
                if (position == -1) {
                    bytesWritten = Libcore.os.write(fd, buffer);
                } else {
                    bytesWritten = Libcore.os.pwrite(fd, buffer, position);
                }
            } catch (ErrnoException errnoException) {
                throw errnoException.rethrowAsIOException();
            }
            completed = true;
        } finally {
            end(completed);
        }
        if (bytesWritten > 0) {
            buffer.position(buffer.position() + bytesWritten);
        }
        return bytesWritten;
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.585 -0500", hash_original_method = "066AEC24C5D5FCB3A90F301EFD66C198", hash_generated_method = "170D957CAA2B032796384D62B267941B")
    
public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkWritable();
        return transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.WRITEV));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.589 -0500", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "8F9C1BA6B62D105E8F557BE8D56765AF")
    
public FileDescriptor getFD() {
        return fd;
    }

    /**
     * Add a new pending lock to the manager. Throws an exception if the lock
     * would overlap an existing lock. Once the lock is acquired it remains in
     * this set as an acquired lock.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.592 -0500", hash_original_method = "F902144182B3E2AF28D0016B48F7903B", hash_generated_method = "A5CFF847D9766B0A2C3B4C2401D2B43A")
    
private synchronized void addLock(FileLock lock) throws OverlappingFileLockException {
        long lockEnd = lock.position() + lock.size();
        for (FileLock existingLock : locks) {
            if (existingLock.position() > lockEnd) {
                // This, and all remaining locks, start beyond our end (so
                // cannot overlap).
                break;
            }
            if (existingLock.overlaps(lock.position(), lock.size())) {
                throw new OverlappingFileLockException();
            }
        }
        locks.add(lock);
    }
    
    private static final class FileLockImpl extends FileLock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.516 -0500", hash_original_field = "BCA505FA920127776E1B249264DA69AA", hash_generated_field = "4E02554B0BEBB8127D76AE5D5E6B5FAD")

        private boolean isReleased = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.519 -0500", hash_original_method = "DBB23F8476AE80F00EB4C7CF229EA4B9", hash_generated_method = "4C35C3EE6EC8D01A05011EFBDC1C4DBA")
        
public FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
            super(channel, position, size, shared);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.521 -0500", hash_original_method = "AAE954E5885EFA2B8D6D7679145B1DEF", hash_generated_method = "D3C531F556FDA65CC71624FDD87502B2")
        
public boolean isValid() {
            return !isReleased && channel().isOpen();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.524 -0500", hash_original_method = "7DF971FEA31B34CE257DD1638735950E", hash_generated_method = "71323F0D135AD9C3D5DDD691B4217C95")
        
public void release() throws IOException {
            if (!channel().isOpen()) {
                throw new ClosedChannelException();
            }
            if (!isReleased) {
                ((FileChannelImpl) channel()).release(this);
                isReleased = true;
            }
        }
        
    }

    /**
     * Removes an acquired lock from the lock manager. If the lock did not exist
     * in the lock manager the operation is a no-op.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.595 -0500", hash_original_method = "AE9E3F40D0EE8D3948C9955DBE0083E8", hash_generated_method = "A6F7211F8C2AA2A9B3B54DEA24E658A3")
    
private synchronized void removeLock(FileLock lock) {
        locks.remove(lock);
    }
}

