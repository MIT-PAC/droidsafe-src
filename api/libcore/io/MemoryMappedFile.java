package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.MAP_SHARED;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.PROT_READ;

import java.io.FileDescriptor;
import java.nio.ByteOrder;






public final class MemoryMappedFile implements AutoCloseable {

    /**
     * Use this to mmap the whole file read-only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.380 -0500", hash_original_method = "FA3DDF9B94B3CDEBE6839DEC194373B4", hash_generated_method = "CC5C3CF1AA1440CDF3C238739770F717")
    
public static MemoryMappedFile mmapRO(String path) throws ErrnoException {
        FileDescriptor fd = Libcore.os.open(path, O_RDONLY, 0);
        long size = Libcore.os.fstat(fd).st_size;
        long address = Libcore.os.mmap(0L, size, PROT_READ, MAP_SHARED, fd, 0);
        Libcore.os.close(fd);
        return new MemoryMappedFile(address, size);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.372 -0500", hash_original_field = "98E46D2F5C8C426EF3AADF170DF60277", hash_generated_field = "A3F92EACCD07E081D12E0C4FE5B97927")

    private long address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.375 -0500", hash_original_field = "298A39EB1E059FD1DCE8DF5205BAB3E6", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private  long size;

    /**
     * Use this if you've called {@code mmap} yourself.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.378 -0500", hash_original_method = "DB7FD4AAB3D9EFEAFD8D0DCEC168BCAA", hash_generated_method = "53D7BD36BF43AE5D98CBE4AD53159000")
    
public MemoryMappedFile(long address, long size) {
        this.address = address;
        this.size = size;
    }

    /**
     * Unmaps this memory-mapped file using munmap(2). This is a no-op if close has already been
     * called. Note that this class does <i>not</i> use finalization; you must call {@code close}
     * yourself.
     *
     * Calling this method invalidates any iterators over this {@code MemoryMappedFile}. It is an
     * error to use such an iterator after calling {@code close}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.383 -0500", hash_original_method = "306B75FBBEB2593BE41A1551019979E1", hash_generated_method = "9740CC12F640C268AF7D4CDD85564DD0")
    
public synchronized void close() throws ErrnoException {
        if (address != 0) {
            Libcore.os.munmap(address, size);
            address = 0;
        }
    }

    /**
     * Returns a new iterator that treats the mapped data as big-endian.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.385 -0500", hash_original_method = "F5E87BA491C8F9D5AD5FD041B46AF87F", hash_generated_method = "DCAEB9ADE838E5674B56B22DABAFC4F3")
    
public BufferIterator bigEndianIterator() {
        return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    }

    /**
     * Returns a new iterator that treats the mapped data as little-endian.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.387 -0500", hash_original_method = "C36F73D80556F0AA7A8914E669A58B4A", hash_generated_method = "93CE7279FC564F96637EFF721C7474AD")
    
public BufferIterator littleEndianIterator() {
        return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
    }

    /**
     * Returns the size in bytes of the memory-mapped region.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.389 -0500", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "CBDD520D6DB2631112CE08685ED4E80A")
    
public long size() {
        return size;
    }

    
}

