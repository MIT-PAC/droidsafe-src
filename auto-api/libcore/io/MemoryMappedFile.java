package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

public final class MemoryMappedFile implements AutoCloseable {
    private long address;
    private long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.963 -0400", hash_original_method = "DB7FD4AAB3D9EFEAFD8D0DCEC168BCAA", hash_generated_method = "9B2491A609FB0B797AC923D1F9B59D71")
    @DSModeled(DSC.SAFE)
    public MemoryMappedFile(long address, long size) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //this.address = address;
        //this.size = size;
    }

    
        public static MemoryMappedFile mmapRO(String path) throws ErrnoException {
        FileDescriptor fd = Libcore.os.open(path, O_RDONLY, 0);
        long size = Libcore.os.fstat(fd).st_size;
        long address = Libcore.os.mmap(0L, size, PROT_READ, MAP_SHARED, fd, 0);
        Libcore.os.close(fd);
        return new MemoryMappedFile(address, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.963 -0400", hash_original_method = "306B75FBBEB2593BE41A1551019979E1", hash_generated_method = "310A733C3D0C8637D5AC57EC8A3060C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void close() throws ErrnoException {
        {
            Libcore.os.munmap(address, size);
            address = 0;
        } //End block
        // ---------- Original Method ----------
        //if (address != 0) {
            //Libcore.os.munmap(address, size);
            //address = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.963 -0400", hash_original_method = "F5E87BA491C8F9D5AD5FD041B46AF87F", hash_generated_method = "46C2E8C40588C6413E6BFF0F6917B8A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferIterator bigEndianIterator() {
        BufferIterator var4F0879C2209D717E5DA498D6F0C7ED2D_3721773 = (new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN));
        return (BufferIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.964 -0400", hash_original_method = "C36F73D80556F0AA7A8914E669A58B4A", hash_generated_method = "6FFEAFCDD43EFC76CD4E72B4579812F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferIterator littleEndianIterator() {
        BufferIterator var977C84CA4F64DD6CA7635D77646BD505_1794362005 = (new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN));
        return (BufferIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.964 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "7A3BAA9D4718067A6C0B38C0178C4ED5")
    @DSModeled(DSC.SAFE)
    public long size() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
}

