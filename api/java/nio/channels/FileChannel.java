package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public abstract class FileChannel extends AbstractInterruptibleChannel implements GatheringByteChannel, ScatteringByteChannel, ByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.607 -0400", hash_original_method = "EC2F86678151C05272A58EBF4D3007B7", hash_generated_method = "CAA1890A7E9ABFD404DD3FE2B64245BB")
    protected  FileChannel() {
        // ---------- Original Method ----------
    }

    
    public abstract void force(boolean metadata) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.608 -0400", hash_original_method = "DFAB2BF3C1A891B83AFBA77A43B03809", hash_generated_method = "560E464661C678574EC6073894301C9C")
    public final FileLock lock() throws IOException {
FileLock var50D39AE14A9D021DC54487D5C205800C_821788459 =         lock(0L, Long.MAX_VALUE, false);
        var50D39AE14A9D021DC54487D5C205800C_821788459.addTaint(taint);
        return var50D39AE14A9D021DC54487D5C205800C_821788459;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.609 -0400", hash_original_method = "4118483D5739F1F8B1E72DACCDF365C6", hash_generated_method = "CCBA97AE7DAB71A0A8CA913E88B4F730")
    public final long read(ByteBuffer[] buffers) throws IOException {
        addTaint(buffers[0].getTaint());
        long varF50B85F0CEDE8E0171EBF27F540A9B6D_1379225148 = (read(buffers, 0, buffers.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1100239744 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1100239744;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.611 -0400", hash_original_method = "F4B810DA7C3314CA042E76DA336480A9", hash_generated_method = "4E55891BC037A654598605FB505A3FC1")
    public final FileLock tryLock() throws IOException {
FileLock varF5D9544336A16D8E74D4CBEA85C52705_1811543885 =         tryLock(0L, Long.MAX_VALUE, false);
        varF5D9544336A16D8E74D4CBEA85C52705_1811543885.addTaint(taint);
        return varF5D9544336A16D8E74D4CBEA85C52705_1811543885;
        // ---------- Original Method ----------
        //return tryLock(0L, Long.MAX_VALUE, false);
    }

    
    public abstract FileLock tryLock(long position, long size, boolean shared)
            throws IOException;

    
    public abstract int write(ByteBuffer src) throws IOException;

    
    public abstract int write(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.612 -0400", hash_original_method = "50EBF858502260FDC2F74EB3C865D254", hash_generated_method = "324FF06F323DA8EF3A8747EB05B750C8")
    public final long write(ByteBuffer[] buffers) throws IOException {
        addTaint(buffers[0].getTaint());
        long var99BCEFD3555ECFD925E957F2DF0A6C07_462922858 = (write(buffers, 0, buffers.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_967817702 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_967817702;
        // ---------- Original Method ----------
        //return write(buffers, 0, buffers.length);
    }

    
    public abstract long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;

    
    public static class MapMode {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.612 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "EC3AB759487D6B2DE8D7429A76BFCE45")

        private String displayName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.612 -0400", hash_original_method = "CA25667E00C4DE16C856657D4E26E93A", hash_generated_method = "2A634FD4036420DE1BBF3037D197C63F")
        private  MapMode(String displayName) {
            this.displayName = displayName;
            // ---------- Original Method ----------
            //this.displayName = displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.612 -0400", hash_original_method = "224E04BA70E2891F43254A5C70CBC214", hash_generated_method = "902BFE0B77FE98FD5AA39A0785D4B2DF")
        @Override
        public String toString() {
String var850CACFC55D2C2C5428453BF9853A088_939207423 =             displayName;
            var850CACFC55D2C2C5428453BF9853A088_939207423.addTaint(taint);
            return var850CACFC55D2C2C5428453BF9853A088_939207423;
            // ---------- Original Method ----------
            //return displayName;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.612 -0400", hash_original_field = "FD863CE85BB60BD180077553DF3ADDD0", hash_generated_field = "E61C6941861B8B13323795D9F76ADC35")

        public static final MapMode PRIVATE = new MapMode("PRIVATE");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.612 -0400", hash_original_field = "3AF1709EB440624071FEBFA50342364A", hash_generated_field = "73340F0AACAD2D5EA6BC7E1EEA96187B")

        public static final MapMode READ_ONLY = new MapMode("READ_ONLY");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.613 -0400", hash_original_field = "60B5C8C9D124869A385F5C45511EF2DC", hash_generated_field = "04922E3259BB871A02F86B60071A2FD5")

        public static final MapMode READ_WRITE = new MapMode("READ_WRITE");
    }


    
}

