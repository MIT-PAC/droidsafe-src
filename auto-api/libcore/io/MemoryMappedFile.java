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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.339 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "A3F92EACCD07E081D12E0C4FE5B97927")

    private long address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.339 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.340 -0400", hash_original_method = "DB7FD4AAB3D9EFEAFD8D0DCEC168BCAA", hash_generated_method = "91C9353EEAEA7638DF5FBFD8454CF94B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.340 -0400", hash_original_method = "306B75FBBEB2593BE41A1551019979E1", hash_generated_method = "310A733C3D0C8637D5AC57EC8A3060C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.341 -0400", hash_original_method = "F5E87BA491C8F9D5AD5FD041B46AF87F", hash_generated_method = "368119A03E6690404114F8A8E995611F")
    public BufferIterator bigEndianIterator() {
        BufferIterator varB4EAC82CA7396A68D541C85D26508E83_530076479 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_530076479 = new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
        varB4EAC82CA7396A68D541C85D26508E83_530076479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_530076479;
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.341 -0400", hash_original_method = "C36F73D80556F0AA7A8914E669A58B4A", hash_generated_method = "47B1B89C538B8BF1FCFB11D49DE2C032")
    public BufferIterator littleEndianIterator() {
        BufferIterator varB4EAC82CA7396A68D541C85D26508E83_582505623 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_582505623 = new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
        varB4EAC82CA7396A68D541C85D26508E83_582505623.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582505623;
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.342 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "309A155ED7878F18DF9F45CD9668FB80")
    public long size() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1944082552 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1944082552;
        // ---------- Original Method ----------
        //return size;
    }

    
}

