package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public abstract class FileChannel extends AbstractInterruptibleChannel implements GatheringByteChannel, ScatteringByteChannel, ByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.623 -0400", hash_original_method = "EC2F86678151C05272A58EBF4D3007B7", hash_generated_method = "CAA1890A7E9ABFD404DD3FE2B64245BB")
    protected  FileChannel() {
        
    }

    
    public abstract void force(boolean metadata) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.624 -0400", hash_original_method = "DFAB2BF3C1A891B83AFBA77A43B03809", hash_generated_method = "CF0794A8244CFF1C39ADFF1A0BD03B11")
    public final FileLock lock() throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_1334336074 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1334336074 = lock(0L, Long.MAX_VALUE, false);
        varB4EAC82CA7396A68D541C85D26508E83_1334336074.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1334336074;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.625 -0400", hash_original_method = "4118483D5739F1F8B1E72DACCDF365C6", hash_generated_method = "54F5D0B8BC2712CF1E6EE89C1AACEB8F")
    public final long read(ByteBuffer[] buffers) throws IOException {
        long varB258DB7C8148418F66ADC2ADCE9C8A9A_2029155913 = (read(buffers, 0, buffers.length));
        addTaint(buffers[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1296841667 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1296841667;
        
        
    }

    
    public abstract long read(ByteBuffer[] buffers, int start, int number)
            throws IOException;

    
    public abstract long size() throws IOException;

    
    public abstract long transferFrom(ReadableByteChannel src, long position,
            long count) throws IOException;

    
    public abstract long transferTo(long position, long count,
            WritableByteChannel target) throws IOException;

    
    public abstract FileChannel truncate(long size) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.626 -0400", hash_original_method = "F4B810DA7C3314CA042E76DA336480A9", hash_generated_method = "23CFB4EC4FC59D93BE2DEE23C73A5BBF")
    public final FileLock tryLock() throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_2087223553 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2087223553 = tryLock(0L, Long.MAX_VALUE, false);
        varB4EAC82CA7396A68D541C85D26508E83_2087223553.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2087223553;
        
        
    }

    
    public abstract FileLock tryLock(long position, long size, boolean shared)
            throws IOException;

    
    public abstract int write(ByteBuffer src) throws IOException;

    
    public abstract int write(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.627 -0400", hash_original_method = "50EBF858502260FDC2F74EB3C865D254", hash_generated_method = "B9B748BBF2F40164CB1ADB21E88B526E")
    public final long write(ByteBuffer[] buffers) throws IOException {
        long varFE4BD7C9D0B65290FBD04B68812B2310_90062902 = (write(buffers, 0, buffers.length));
        addTaint(buffers[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_754144828 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_754144828;
        
        
    }

    
    public abstract long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;

    
    public static class MapMode {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.627 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "EC3AB759487D6B2DE8D7429A76BFCE45")

        private String displayName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.627 -0400", hash_original_method = "CA25667E00C4DE16C856657D4E26E93A", hash_generated_method = "2A634FD4036420DE1BBF3037D197C63F")
        private  MapMode(String displayName) {
            this.displayName = displayName;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.628 -0400", hash_original_method = "224E04BA70E2891F43254A5C70CBC214", hash_generated_method = "106C54ADD84AFAE7B75CEDFAFF4384A9")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_157359741 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_157359741 = displayName;
            varB4EAC82CA7396A68D541C85D26508E83_157359741.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_157359741;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.628 -0400", hash_original_field = "FD863CE85BB60BD180077553DF3ADDD0", hash_generated_field = "E61C6941861B8B13323795D9F76ADC35")

        public static final MapMode PRIVATE = new MapMode("PRIVATE");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.628 -0400", hash_original_field = "3AF1709EB440624071FEBFA50342364A", hash_generated_field = "73340F0AACAD2D5EA6BC7E1EEA96187B")

        public static final MapMode READ_ONLY = new MapMode("READ_ONLY");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.628 -0400", hash_original_field = "60B5C8C9D124869A385F5C45511EF2DC", hash_generated_field = "04922E3259BB871A02F86B60071A2FD5")

        public static final MapMode READ_WRITE = new MapMode("READ_WRITE");
    }


    
}

