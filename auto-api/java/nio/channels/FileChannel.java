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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.107 -0400", hash_original_method = "EC2F86678151C05272A58EBF4D3007B7", hash_generated_method = "CAA1890A7E9ABFD404DD3FE2B64245BB")
    @DSModeled(DSC.SAFE)
    protected FileChannel() {
        // ---------- Original Method ----------
    }

    
    public abstract void force(boolean metadata) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.107 -0400", hash_original_method = "DFAB2BF3C1A891B83AFBA77A43B03809", hash_generated_method = "0BCE2843FDA69C043199698EBE0CE839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final FileLock lock() throws IOException {
        FileLock var8F7F4A008F7D0C3D41DB1A34DB7D92B6_1772465275 = (lock(0L, Long.MAX_VALUE, false));
        return (FileLock)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.108 -0400", hash_original_method = "4118483D5739F1F8B1E72DACCDF365C6", hash_generated_method = "8EA4EBC13708B7C0D58102635109C388")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long read(ByteBuffer[] buffers) throws IOException {
        dsTaint.addTaint(buffers[0].dsTaint);
        long varB258DB7C8148418F66ADC2ADCE9C8A9A_1682156120 = (read(buffers, 0, buffers.length));
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.109 -0400", hash_original_method = "F4B810DA7C3314CA042E76DA336480A9", hash_generated_method = "ECC8FD867AFB3CB4EA561C46BCA692D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final FileLock tryLock() throws IOException {
        FileLock var0526D35520C4C2E1A5807B3882F55C8A_1852964911 = (tryLock(0L, Long.MAX_VALUE, false));
        return (FileLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return tryLock(0L, Long.MAX_VALUE, false);
    }

    
    public abstract FileLock tryLock(long position, long size, boolean shared)
            throws IOException;

    
    public abstract int write(ByteBuffer src) throws IOException;

    
    public abstract int write(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.109 -0400", hash_original_method = "50EBF858502260FDC2F74EB3C865D254", hash_generated_method = "7AD9245A76FD5FD2C10F91D7FB166771")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long write(ByteBuffer[] buffers) throws IOException {
        dsTaint.addTaint(buffers[0].dsTaint);
        long varFE4BD7C9D0B65290FBD04B68812B2310_680788182 = (write(buffers, 0, buffers.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return write(buffers, 0, buffers.length);
    }

    
    public abstract long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;

    
    public static class MapMode {
        private String displayName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.109 -0400", hash_original_method = "CA25667E00C4DE16C856657D4E26E93A", hash_generated_method = "0BC8CCD90E58EFB3AAA14341A7C6CBDF")
        @DSModeled(DSC.SAFE)
        private MapMode(String displayName) {
            dsTaint.addTaint(displayName);
            // ---------- Original Method ----------
            //this.displayName = displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.110 -0400", hash_original_method = "224E04BA70E2891F43254A5C70CBC214", hash_generated_method = "D837335078E6DD928EEB55EABF0119F2")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return displayName;
        }

        
        public static final MapMode PRIVATE = new MapMode("PRIVATE");
        public static final MapMode READ_ONLY = new MapMode("READ_ONLY");
        public static final MapMode READ_WRITE = new MapMode("READ_WRITE");
    }


    
}

