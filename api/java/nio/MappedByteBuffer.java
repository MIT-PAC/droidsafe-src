package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.MS_SYNC;
import static libcore.io.OsConstants._SC_PAGE_SIZE;

import java.nio.channels.FileChannel.MapMode;

import libcore.io.ErrnoException;
import libcore.io.Libcore;



public abstract class MappedByteBuffer extends ByteBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.976 -0500", hash_original_field = "D7679EF467A9ABFED1C67E3C246585AB", hash_generated_field = "D7679EF467A9ABFED1C67E3C246585AB")


     DirectByteBuffer wrapped;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.978 -0500", hash_original_field = "69A89BCA3281DEEA25D69F491FD7863B", hash_generated_field = "2A1F112DD9317D05E828544B748EF0B7")


    private  MapMode mapMode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.981 -0500", hash_original_method = "B4624F88D9C5C045F8BDE794FFD519CF", hash_generated_method = "B4624F88D9C5C045F8BDE794FFD519CF")
    
MappedByteBuffer(ByteBuffer directBuffer) {
        super(directBuffer.capacity, directBuffer.block);
        if (!directBuffer.isDirect()) {
            throw new IllegalArgumentException();
        }
        this.wrapped = (DirectByteBuffer) directBuffer;
        this.mapMode = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.984 -0500", hash_original_method = "638BC1993DAD17C2741F99B13CBD8BD7", hash_generated_method = "638BC1993DAD17C2741F99B13CBD8BD7")
    
MappedByteBuffer(MemoryBlock block, int capacity, int offset, MapMode mapMode) {
        super(capacity, block);
        this.mapMode = mapMode;
        if (mapMode == MapMode.READ_ONLY) {
            wrapped = new ReadOnlyDirectByteBuffer(block, capacity, offset);
        } else {
            wrapped = new ReadWriteDirectByteBuffer(block, capacity, offset);
        }
    }

    /**
     * Returns true if there is a high probability that every page of this buffer is currently
     * loaded in RAM, meaning that accesses will not cause a page fault. It is impossible to give
     * a strong guarantee since this is only a snapshot of a dynamic situation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.987 -0500", hash_original_method = "C9D4A4A6949ED0E6DB022AC73D44B615", hash_generated_method = "D263783BE5FD569E4E8AC9FC9E4E51FA")
    
public final boolean isLoaded() {
        long address = block.toInt();
        long size = block.getSize();
        if (size == 0) {
            return true;
        }

        try {
            int pageSize = (int) Libcore.os.sysconf(_SC_PAGE_SIZE);
            int pageOffset = (int) (address % pageSize);
            address -= pageOffset;
            size += pageOffset;
            int pageCount = (int) ((size + pageSize - 1) / pageSize);
            byte[] vector = new byte[pageCount];
            Libcore.os.mincore(address, size, vector);
            for (int i = 0; i < vector.length; ++i) {
                if ((vector[i] & 1) != 1) {
                    return false;
                }
            }
            return true;
        } catch (ErrnoException errnoException) {
            return false;
        }
    }

    /**
     * Attempts to load every page of this buffer into RAM. See {@link #isLoaded}.
     * @return this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.990 -0500", hash_original_method = "61E403E118E1A4E788B2CC284AD4ABD1", hash_generated_method = "55C467158E827884BC44D98E25B16C6A")
    
public final MappedByteBuffer load() {
        try {
            Libcore.os.mlock(block.toInt(), block.getSize());
            Libcore.os.munlock(block.toInt(), block.getSize());
        } catch (ErrnoException ignored) {
        }
        return this;
    }

    /**
     * Writes all changes of the buffer to the mapped file. If the mapped file
     * is stored on a local device, it is guaranteed that the changes are
     * written to the file. No such guarantee is given if the file is located on
     * a remote device.
     *
     * @return this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.993 -0500", hash_original_method = "F84161825A8E4C54BC8547EBE9290572", hash_generated_method = "93A4FA549F2F63403E088CAD0E99EFFE")
    
public final MappedByteBuffer force() {
        if (mapMode == MapMode.READ_WRITE) {
            try {
                Libcore.os.msync(block.toInt(), block.getSize(), MS_SYNC);
            } catch (ErrnoException errnoException) {
                // The RI doesn't throw, presumably on the assumption that you can't get into
                // a state where msync(2) could return an error.
                throw new AssertionError(errnoException);
            }
        }
        return this;
    }

    
}

