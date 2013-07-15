package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.725 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "A3F92EACCD07E081D12E0C4FE5B97927")

    private long address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.725 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.726 -0400", hash_original_method = "DB7FD4AAB3D9EFEAFD8D0DCEC168BCAA", hash_generated_method = "91C9353EEAEA7638DF5FBFD8454CF94B")
    public  MemoryMappedFile(long address, long size) {
        this.address = address;
        this.size = size;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.726 -0400", hash_original_method = "306B75FBBEB2593BE41A1551019979E1", hash_generated_method = "E02BB407DCCB37CF3FE71FF4852CBF31")
    public synchronized void close() throws ErrnoException {
    if(address != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.727 -0400", hash_original_method = "F5E87BA491C8F9D5AD5FD041B46AF87F", hash_generated_method = "4D9CDA6A5F21A2504AE9425FD308CCF5")
    public BufferIterator bigEndianIterator() {
BufferIterator varB4EC9D0E062809A0704546019BCC988B_505650062 =         new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
        varB4EC9D0E062809A0704546019BCC988B_505650062.addTaint(taint);
        return varB4EC9D0E062809A0704546019BCC988B_505650062;
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.727 -0400", hash_original_method = "C36F73D80556F0AA7A8914E669A58B4A", hash_generated_method = "8891D4D21CBD94BDB507C3B3494EF7DC")
    public BufferIterator littleEndianIterator() {
BufferIterator var8816B5A8C55B4007EB0ABFE9767037E6_553419223 =         new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
        var8816B5A8C55B4007EB0ABFE9767037E6_553419223.addTaint(taint);
        return var8816B5A8C55B4007EB0ABFE9767037E6_553419223;
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.728 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "D3247D815F5371A3E33C4345469EB940")
    public long size() {
        long varF7BD60B75B29D79B660A2859395C1A24_2136677933 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1117965246 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1117965246;
        // ---------- Original Method ----------
        //return size;
    }

    
}

