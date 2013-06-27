package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public abstract class FileChannel extends AbstractInterruptibleChannel implements GatheringByteChannel, ScatteringByteChannel, ByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.466 -0400", hash_original_method = "EC2F86678151C05272A58EBF4D3007B7", hash_generated_method = "CAA1890A7E9ABFD404DD3FE2B64245BB")
    protected  FileChannel() {
        // ---------- Original Method ----------
    }

    
    public abstract void force(boolean metadata) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.466 -0400", hash_original_method = "DFAB2BF3C1A891B83AFBA77A43B03809", hash_generated_method = "83FC15F800A4DDC19B7F04A0FD2A2849")
    public final FileLock lock() throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_1822244128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1822244128 = lock(0L, Long.MAX_VALUE, false);
        varB4EAC82CA7396A68D541C85D26508E83_1822244128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1822244128;
        // ---------- Original Method ----------
        //return lock(0L, Long.MAX_VALUE, false);
    }

    
    public abstract FileLock lock(long position, long size, boolean shared)
            throws IOException;

    
    public abstract MappedByteBuffer map(FileChannel.MapMode mode,
            long position, long size) throws IOException;

    
    public abstract long position() throws IOException;

    
    public abstract FileChannel position(long offset) throws IOException;

    
    public abstract int read(ByteBuffer buffer) throws IOException;

    
    public abstract int read(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.468 -0400", hash_original_method = "4118483D5739F1F8B1E72DACCDF365C6", hash_generated_method = "C4B0C1519DCBEDEDAAB25FFBB0B802C5")
    public final long read(ByteBuffer[] buffers) throws IOException {
        long varB258DB7C8148418F66ADC2ADCE9C8A9A_497089248 = (read(buffers, 0, buffers.length));
        addTaint(buffers[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1735785688 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1735785688;
        // ---------- Original Method ----------
        //return read(buffers, 0, buffers.length);
    }

    
    public abstract long read(ByteBuffer[] buffers, int start, int number)
            throws IOException;

    
    public abstract long size() throws IOException;

    
    public abstract long transferFrom(ReadableByteChannel src, long position,
            long count) throws IOException;

    
    public abstract long transferTo(long position, long count,
            WritableByteChannel target) throws IOException;

    
    public abstract FileChannel truncate(long size) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.469 -0400", hash_original_method = "F4B810DA7C3314CA042E76DA336480A9", hash_generated_method = "BDF12AE3F2186FCD6C1C3CFAF25654A5")
    public final FileLock tryLock() throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_321324928 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_321324928 = tryLock(0L, Long.MAX_VALUE, false);
        varB4EAC82CA7396A68D541C85D26508E83_321324928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_321324928;
        // ---------- Original Method ----------
        //return tryLock(0L, Long.MAX_VALUE, false);
    }

    
    public abstract FileLock tryLock(long position, long size, boolean shared)
            throws IOException;

    
    public abstract int write(ByteBuffer src) throws IOException;

    
    public abstract int write(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.478 -0400", hash_original_method = "50EBF858502260FDC2F74EB3C865D254", hash_generated_method = "BEA36713D56C3BDD20D00717C3B4C370")
    public final long write(ByteBuffer[] buffers) throws IOException {
        long varFE4BD7C9D0B65290FBD04B68812B2310_1602477202 = (write(buffers, 0, buffers.length));
        addTaint(buffers[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_442734297 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_442734297;
        // ---------- Original Method ----------
        //return write(buffers, 0, buffers.length);
    }

    
    public abstract long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;

    
    public static class MapMode {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.478 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "EC3AB759487D6B2DE8D7429A76BFCE45")

        private String displayName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.492 -0400", hash_original_method = "CA25667E00C4DE16C856657D4E26E93A", hash_generated_method = "2A634FD4036420DE1BBF3037D197C63F")
        private  MapMode(String displayName) {
            this.displayName = displayName;
            // ---------- Original Method ----------
            //this.displayName = displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.493 -0400", hash_original_method = "224E04BA70E2891F43254A5C70CBC214", hash_generated_method = "C400CA90CD5126631668327895964040")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_565810522 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_565810522 = displayName;
            varB4EAC82CA7396A68D541C85D26508E83_565810522.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_565810522;
            // ---------- Original Method ----------
            //return displayName;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.493 -0400", hash_original_field = "FD863CE85BB60BD180077553DF3ADDD0", hash_generated_field = "E61C6941861B8B13323795D9F76ADC35")

        public static final MapMode PRIVATE = new MapMode("PRIVATE");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.493 -0400", hash_original_field = "3AF1709EB440624071FEBFA50342364A", hash_generated_field = "73340F0AACAD2D5EA6BC7E1EEA96187B")

        public static final MapMode READ_ONLY = new MapMode("READ_ONLY");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.493 -0400", hash_original_field = "60B5C8C9D124869A385F5C45511EF2DC", hash_generated_field = "04922E3259BB871A02F86B60071A2FD5")

        public static final MapMode READ_WRITE = new MapMode("READ_WRITE");
    }


    
}

