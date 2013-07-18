package java.nio.channels;

// Droidsafe Imports
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class FileChannel extends AbstractInterruptibleChannel implements GatheringByteChannel, ScatteringByteChannel, ByteChannel {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.172 -0400", hash_original_method = "EC2F86678151C05272A58EBF4D3007B7", hash_generated_method = "CAA1890A7E9ABFD404DD3FE2B64245BB")
    protected  FileChannel() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void force(boolean metadata) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.173 -0400", hash_original_method = "DFAB2BF3C1A891B83AFBA77A43B03809", hash_generated_method = "305B70F9C5BF22E186A8AE6108C44FA5")
    public final FileLock lock() throws IOException {
FileLock var50D39AE14A9D021DC54487D5C205800C_1252566143 =         lock(0L, Long.MAX_VALUE, false);
        var50D39AE14A9D021DC54487D5C205800C_1252566143.addTaint(taint);
        return var50D39AE14A9D021DC54487D5C205800C_1252566143;
        // ---------- Original Method ----------
        //return lock(0L, Long.MAX_VALUE, false);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract FileLock lock(long position, long size, boolean shared)
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract MappedByteBuffer map(FileChannel.MapMode mode,
            long position, long size) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract long position() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract FileChannel position(long offset) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract int read(ByteBuffer buffer) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract int read(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.175 -0400", hash_original_method = "4118483D5739F1F8B1E72DACCDF365C6", hash_generated_method = "BC5002E6F5156105723E63F8AD97A528")
    public final long read(ByteBuffer[] buffers) throws IOException {
        addTaint(buffers[0].getTaint());
        long varF50B85F0CEDE8E0171EBF27F540A9B6D_1667026618 = (read(buffers, 0, buffers.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1179641389 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1179641389;
        // ---------- Original Method ----------
        //return read(buffers, 0, buffers.length);
    }

    
    public abstract long read(ByteBuffer[] buffers, int start, int number)
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract long size() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract long transferFrom(ReadableByteChannel src, long position,
            long count) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract long transferTo(long position, long count,
            WritableByteChannel target) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract FileChannel truncate(long size) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.176 -0400", hash_original_method = "F4B810DA7C3314CA042E76DA336480A9", hash_generated_method = "F14073D8395A89426E949890870D2B8A")
    public final FileLock tryLock() throws IOException {
FileLock varF5D9544336A16D8E74D4CBEA85C52705_1747660477 =         tryLock(0L, Long.MAX_VALUE, false);
        varF5D9544336A16D8E74D4CBEA85C52705_1747660477.addTaint(taint);
        return varF5D9544336A16D8E74D4CBEA85C52705_1747660477;
        // ---------- Original Method ----------
        //return tryLock(0L, Long.MAX_VALUE, false);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract FileLock tryLock(long position, long size, boolean shared)
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract int write(ByteBuffer src) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract int write(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.178 -0400", hash_original_method = "50EBF858502260FDC2F74EB3C865D254", hash_generated_method = "F970143A68C17B45C51FDF5E26C6DFC5")
    public final long write(ByteBuffer[] buffers) throws IOException {
        addTaint(buffers[0].getTaint());
        long var99BCEFD3555ECFD925E957F2DF0A6C07_603192529 = (write(buffers, 0, buffers.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1873507131 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1873507131;
        // ---------- Original Method ----------
        //return write(buffers, 0, buffers.length);
    }

    
    public abstract long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;

    
    public static class MapMode {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.179 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "EC3AB759487D6B2DE8D7429A76BFCE45")

        private String displayName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.179 -0400", hash_original_method = "CA25667E00C4DE16C856657D4E26E93A", hash_generated_method = "2A634FD4036420DE1BBF3037D197C63F")
        private  MapMode(String displayName) {
            this.displayName = displayName;
            // ---------- Original Method ----------
            //this.displayName = displayName;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.179 -0400", hash_original_method = "224E04BA70E2891F43254A5C70CBC214", hash_generated_method = "04FC9D1CE76ABF51A982E38C6004726E")
        @Override
        public String toString() {
String var850CACFC55D2C2C5428453BF9853A088_767436304 =             displayName;
            var850CACFC55D2C2C5428453BF9853A088_767436304.addTaint(taint);
            return var850CACFC55D2C2C5428453BF9853A088_767436304;
            // ---------- Original Method ----------
            //return displayName;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.179 -0400", hash_original_field = "FD863CE85BB60BD180077553DF3ADDD0", hash_generated_field = "E61C6941861B8B13323795D9F76ADC35")

        public static final MapMode PRIVATE = new MapMode("PRIVATE");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.179 -0400", hash_original_field = "3AF1709EB440624071FEBFA50342364A", hash_generated_field = "73340F0AACAD2D5EA6BC7E1EEA96187B")

        public static final MapMode READ_ONLY = new MapMode("READ_ONLY");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.180 -0400", hash_original_field = "60B5C8C9D124869A385F5C45511EF2DC", hash_generated_field = "04922E3259BB871A02F86B60071A2FD5")

        public static final MapMode READ_WRITE = new MapMode("READ_WRITE");
    }


    
}

