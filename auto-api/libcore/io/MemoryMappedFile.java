package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.481 -0400", hash_original_method = "DB7FD4AAB3D9EFEAFD8D0DCEC168BCAA", hash_generated_method = "3D46530C5E490EAA0561727CD21A8EB2")
    @DSModeled(DSC.SAFE)
    public MemoryMappedFile(long address, long size) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(size);
        this.size = size;
        // ---------- Original Method ----------
        //this.address = address;
        //this.size = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.481 -0400", hash_original_method = "FA3DDF9B94B3CDEBE6839DEC194373B4", hash_generated_method = "CC5C3CF1AA1440CDF3C238739770F717")
    public static MemoryMappedFile mmapRO(String path) throws ErrnoException {
        FileDescriptor fd = Libcore.os.open(path, O_RDONLY, 0);
        long size = Libcore.os.fstat(fd).st_size;
        long address = Libcore.os.mmap(0L, size, PROT_READ, MAP_SHARED, fd, 0);
        Libcore.os.close(fd);
        return new MemoryMappedFile(address, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.481 -0400", hash_original_method = "306B75FBBEB2593BE41A1551019979E1", hash_generated_method = "40573484EBB6C0AA54DC7AA85B252A55")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.481 -0400", hash_original_method = "F5E87BA491C8F9D5AD5FD041B46AF87F", hash_generated_method = "C7C0AB6D3DA642C07A603DC87A4136BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferIterator bigEndianIterator() {
        BufferIterator var4F0879C2209D717E5DA498D6F0C7ED2D_1994733653 = (new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN));
        return (BufferIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.481 -0400", hash_original_method = "C36F73D80556F0AA7A8914E669A58B4A", hash_generated_method = "D5829C15485DF194F9741AFC88454527")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferIterator littleEndianIterator() {
        BufferIterator var977C84CA4F64DD6CA7635D77646BD505_650205701 = (new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN));
        return (BufferIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.481 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "0D317478E1D5FB399BC378941261A405")
    @DSModeled(DSC.SAFE)
    public long size() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
}


