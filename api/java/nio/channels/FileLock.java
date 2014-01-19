package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public abstract class FileLock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.920 -0500", hash_original_field = "606E91E177C017AB22115E5BAB9B1D1A", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private  FileChannel channel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.922 -0500", hash_original_field = "52DF2E6914C34BE1E271C4366CA6267D", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private  long position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.925 -0500", hash_original_field = "298A39EB1E059FD1DCE8DF5205BAB3E6", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private  long size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.927 -0500", hash_original_field = "34293CAAA37E17C8FA8487D55D95082F", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private  boolean shared;

    /**
     * Constructs a new file lock instance for a given channel. The constructor
     * enforces the starting position, length and sharing mode of the lock.
     *
     * @param channel
     *            the underlying file channel that holds the lock.
     * @param position
     *            the starting point for the lock.
     * @param size
     *            the length of the lock in number of bytes.
     * @param shared
     *            the lock's sharing mode of lock; {@code true} is shared,
     *            {@code false} is exclusive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.930 -0500", hash_original_method = "CD9224B029C4E22DF1D36B9A88EF4582", hash_generated_method = "A1F3049F811D2F197D46AA798FCEC4E8")
    
protected FileLock(FileChannel channel, long position, long size, boolean shared) {
        if (position < 0 || size < 0 || position + size < 0) {
            throw new IllegalArgumentException();
        }
        this.channel = channel;
        this.position = position;
        this.size = size;
        this.shared = shared;
    }

    /**
     * Returns the lock's {@link FileChannel}.
     *
     * @return the channel.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.933 -0500", hash_original_method = "51CC76EF226D8C9ED837839CEF3A7EEC", hash_generated_method = "3B81DF277F91EAB739F4722133B81B97")
    
public final FileChannel channel() {
        return channel;
    }

    /**
     * Returns the lock's starting position in the file.
     *
     * @return the lock position.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.935 -0500", hash_original_method = "B51039013FACF3B9BE83986840749101", hash_generated_method = "3A969B8CA48AACD49D61680D9270B0B9")
    
public final long position() {
        return position;
    }

    /**
     * Returns the length of the file lock in bytes.
     *
     * @return the size of the file lock in bytes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.938 -0500", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "6880D4F7C4EA71C45FEAC7C1E3AC5719")
    
public final long size() {
        return size;
    }

    /**
     * Indicates if the file lock is shared with other processes or if it is
     * exclusive.
     *
     * @return {@code true} if the lock is a shared lock, {@code false} if it is
     *         exclusive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.940 -0500", hash_original_method = "9101EDDE96E9CB8A45C7075BA466C705", hash_generated_method = "C5CA60BFCBFC0B387AEAC2879B2A1D50")
    
public final boolean isShared() {
        return shared;
    }

    /**
     * Indicates if the receiver's lock region overlaps the region described
     * in the parameter list.
     *
     * @param start
     *            the starting position for the comparative lock.
     * @param length
     *            the length of the comparative lock.
     * @return {@code true} if there is an overlap, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.943 -0500", hash_original_method = "BD91EA1BF31FE8BEA01F707FE570CF9B", hash_generated_method = "7B3C12D3964E1AC5C0BC9EA9E05C5DF9")
    
public final boolean overlaps(long start, long length) {
        final long end = position + size - 1;
        final long newEnd = start + length - 1;
        if (end < start || position > newEnd) {
            return false;
        }
        return true;
    }

    /**
     * Indicates whether this lock is a valid file lock. The lock is
     * valid unless the underlying channel has been closed or it has been
     * explicitly released.
     *
     * @return {@code true} if the lock is valid, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.945 -0500", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "DEB105C1692FABA897B5C0B0EC6247FE")
    
public abstract boolean isValid();

    /**
     * Releases this particular lock on the file. If the lock is invalid then
     * this method has no effect. Once released, the lock becomes invalid.
     *
     * @throws ClosedChannelException
     *             if the channel is already closed when an attempt to release
     *             the lock is made.
     * @throws IOException
     *             if another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.947 -0500", hash_original_method = "22B65EDA9DAE2C971668345F22156AAE", hash_generated_method = "79128A57A8D9F19E7BCD0E731AF79772")
    
public abstract void release() throws IOException;

    /**
     * Returns a string that shows the details of the lock suitable for display
     * to an end user.
     *
     * @return the display string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.950 -0500", hash_original_method = "1F1F0B30DE920C1569E46FCBBEE46A56", hash_generated_method = "BA2B1869FB958D70BAED03A91339E6B1")
    
@Override
    public final String toString() {
        return "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
    }
    
}

