package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.278 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "A3F92EACCD07E081D12E0C4FE5B97927")

    private long address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.278 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.278 -0400", hash_original_method = "DB7FD4AAB3D9EFEAFD8D0DCEC168BCAA", hash_generated_method = "91C9353EEAEA7638DF5FBFD8454CF94B")
    public  MemoryMappedFile(long address, long size) {
        this.address = address;
        this.size = size;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static MemoryMappedFile mmapRO(String path) throws ErrnoException {
        FileDescriptor fd = Libcore.os.open(path, O_RDONLY, 0);
        long size = Libcore.os.fstat(fd).st_size;
        long address = Libcore.os.mmap(0L, size, PROT_READ, MAP_SHARED, fd, 0);
        Libcore.os.close(fd);
        return new MemoryMappedFile(address, size);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.279 -0400", hash_original_method = "306B75FBBEB2593BE41A1551019979E1", hash_generated_method = "310A733C3D0C8637D5AC57EC8A3060C8")
    public synchronized void close() throws ErrnoException {
        {
            Libcore.os.munmap(address, size);
            address = 0;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.280 -0400", hash_original_method = "F5E87BA491C8F9D5AD5FD041B46AF87F", hash_generated_method = "34E97794F92E4CCF4DED16D984F4794A")
    public BufferIterator bigEndianIterator() {
        BufferIterator varB4EAC82CA7396A68D541C85D26508E83_1803111243 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1803111243 = new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
        varB4EAC82CA7396A68D541C85D26508E83_1803111243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1803111243;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.280 -0400", hash_original_method = "C36F73D80556F0AA7A8914E669A58B4A", hash_generated_method = "0345919D1B31FC76A497C68F1868B62B")
    public BufferIterator littleEndianIterator() {
        BufferIterator varB4EAC82CA7396A68D541C85D26508E83_306169152 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_306169152 = new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
        varB4EAC82CA7396A68D541C85D26508E83_306169152.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_306169152;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.281 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "CEEFD32CA299451C93941D5BD1B280C3")
    public long size() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_390646114 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_390646114;
        
        
    }

    
}

