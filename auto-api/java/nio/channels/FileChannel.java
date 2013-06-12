package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public abstract class FileChannel extends AbstractInterruptibleChannel implements GatheringByteChannel, ScatteringByteChannel, ByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.483 -0400", hash_original_method = "EC2F86678151C05272A58EBF4D3007B7", hash_generated_method = "20D060C929A9D311DB694C9FC401BF53")
    @DSModeled(DSC.SAFE)
    protected FileChannel() {
        // ---------- Original Method ----------
    }

    
    public abstract void force(boolean metadata) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.483 -0400", hash_original_method = "DFAB2BF3C1A891B83AFBA77A43B03809", hash_generated_method = "BDCA792229904FC05CF09E2F7EA53D39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final FileLock lock() throws IOException {
        FileLock var8F7F4A008F7D0C3D41DB1A34DB7D92B6_1544404169 = (lock(0L, Long.MAX_VALUE, false));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.483 -0400", hash_original_method = "4118483D5739F1F8B1E72DACCDF365C6", hash_generated_method = "F4D17C89F1BB34823497911D291FE64F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long read(ByteBuffer[] buffers) throws IOException {
        dsTaint.addTaint(buffers);
        long varB258DB7C8148418F66ADC2ADCE9C8A9A_2009982714 = (read(buffers, 0, buffers.length));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.483 -0400", hash_original_method = "F4B810DA7C3314CA042E76DA336480A9", hash_generated_method = "7952C93841A22E1E7A86E1DE805674EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final FileLock tryLock() throws IOException {
        FileLock var0526D35520C4C2E1A5807B3882F55C8A_1933695977 = (tryLock(0L, Long.MAX_VALUE, false));
        return (FileLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return tryLock(0L, Long.MAX_VALUE, false);
    }

    
    public abstract FileLock tryLock(long position, long size, boolean shared)
            throws IOException;

    
    public abstract int write(ByteBuffer src) throws IOException;

    
    public abstract int write(ByteBuffer buffer, long position)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.483 -0400", hash_original_method = "50EBF858502260FDC2F74EB3C865D254", hash_generated_method = "80E7AEC4E66EA91123C7C004AA67CAB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long write(ByteBuffer[] buffers) throws IOException {
        dsTaint.addTaint(buffers);
        long varFE4BD7C9D0B65290FBD04B68812B2310_991285902 = (write(buffers, 0, buffers.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return write(buffers, 0, buffers.length);
    }

    
    public abstract long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;

    
    public static class MapMode {
        public static final MapMode PRIVATE = new MapMode("PRIVATE");
        public static final MapMode READ_ONLY = new MapMode("READ_ONLY");
        public static final MapMode READ_WRITE = new MapMode("READ_WRITE");
        private String displayName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.483 -0400", hash_original_method = "CA25667E00C4DE16C856657D4E26E93A", hash_generated_method = "EE91ECC843853F64CC308F3AD60762A3")
        @DSModeled(DSC.SAFE)
        private MapMode(String displayName) {
            dsTaint.addTaint(displayName);
            // ---------- Original Method ----------
            //this.displayName = displayName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.483 -0400", hash_original_method = "224E04BA70E2891F43254A5C70CBC214", hash_generated_method = "6D66D0A694508C42F7F69C82317766E2")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return displayName;
        }

        
    }


    
}


