package libcore.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.MAP_SHARED;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.PROT_READ;

import java.io.FileDescriptor;
import java.nio.ByteOrder;






public final class MemoryMappedFile implements AutoCloseable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.641 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "A3F92EACCD07E081D12E0C4FE5B97927")

    private long address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.641 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.641 -0400", hash_original_method = "DB7FD4AAB3D9EFEAFD8D0DCEC168BCAA", hash_generated_method = "91C9353EEAEA7638DF5FBFD8454CF94B")
    public  MemoryMappedFile(long address, long size) {
        this.address = address;
        this.size = size;
        // ---------- Original Method ----------
        //this.address = address;
        //this.size = size;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.641 -0400", hash_original_method = "306B75FBBEB2593BE41A1551019979E1", hash_generated_method = "E02BB407DCCB37CF3FE71FF4852CBF31")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.642 -0400", hash_original_method = "F5E87BA491C8F9D5AD5FD041B46AF87F", hash_generated_method = "12441DE4C92F62DF447D60D13BE8A08B")
    public BufferIterator bigEndianIterator() {
BufferIterator varB4EC9D0E062809A0704546019BCC988B_279174044 =         new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
        varB4EC9D0E062809A0704546019BCC988B_279174044.addTaint(taint);
        return varB4EC9D0E062809A0704546019BCC988B_279174044;
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.642 -0400", hash_original_method = "C36F73D80556F0AA7A8914E669A58B4A", hash_generated_method = "C67638EC448C9E3ABCE3E566E24D06DF")
    public BufferIterator littleEndianIterator() {
BufferIterator var8816B5A8C55B4007EB0ABFE9767037E6_530804442 =         new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
        var8816B5A8C55B4007EB0ABFE9767037E6_530804442.addTaint(taint);
        return var8816B5A8C55B4007EB0ABFE9767037E6_530804442;
        // ---------- Original Method ----------
        //return new NioBufferIterator((int) address, (int) size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.642 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "1B63B1339588399105855BC3CBCBD317")
    public long size() {
        long varF7BD60B75B29D79B660A2859395C1A24_912141151 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1012717690 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1012717690;
        // ---------- Original Method ----------
        //return size;
    }

    
}

