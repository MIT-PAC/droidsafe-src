package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import libcore.io.Libcore;
import libcore.io.ErrnoException;

final class IoVec {
    private ByteBuffer[] byteBuffers;
    private int offset;
    private int bufferCount;
    private Object[] ioBuffers;
    private int[] offsets;
    private int[] byteCounts;
    private Direction direction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.780 -0400", hash_original_method = "79FA89440D1C6736393E7E6CE16B2553", hash_generated_method = "CC194EE02F72994126CDE54ADD9F6F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IoVec(ByteBuffer[] byteBuffers, int offset, int bufferCount, Direction direction) {
        dsTaint.addTaint(byteBuffers[0].dsTaint);
        dsTaint.addTaint(direction.dsTaint);
        dsTaint.addTaint(bufferCount);
        dsTaint.addTaint(offset);
        this.ioBuffers = new Object[bufferCount];
        this.offsets = new int[bufferCount];
        this.byteCounts = new int[bufferCount];
        // ---------- Original Method ----------
        //this.byteBuffers = byteBuffers;
        //this.offset = offset;
        //this.bufferCount = bufferCount;
        //this.direction = direction;
        //this.ioBuffers = new Object[bufferCount];
        //this.offsets = new int[bufferCount];
        //this.byteCounts = new int[bufferCount];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.781 -0400", hash_original_method = "0C69B202E78D62C368E6E03D03D6C92B", hash_generated_method = "A0BDB75B81F16C4EDF10AABACE7D8830")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int init() {
        int totalRemaining;
        totalRemaining = 0;
        {
            int i;
            i = 0;
            {
                ByteBuffer b;
                b = byteBuffers[i + offset];
                {
                    b.checkWritable();
                } //End block
                int remaining;
                remaining = b.remaining();
                {
                    boolean var485497B2C9BE8560C87D0DBBE26ABBEA_432820763 = (b.isDirect());
                    {
                        ioBuffers[i] = b;
                        offsets[i] = b.position();
                    } //End block
                    {
                        ioBuffers[i] = NioUtils.unsafeArray(b);
                        offsets[i] = NioUtils.unsafeArrayOffset(b) + b.position();
                    } //End block
                } //End collapsed parenthetic
                byteCounts[i] = remaining;
                totalRemaining += remaining;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int totalRemaining = 0;
        //for (int i = 0; i < bufferCount; ++i) {
            //ByteBuffer b = byteBuffers[i + offset];
            //if (direction == Direction.READV) {
                //b.checkWritable();
            //}
            //int remaining = b.remaining();
            //if (b.isDirect()) {
                //ioBuffers[i] = b;
                //offsets[i] = b.position();
            //} else {
                //ioBuffers[i] = NioUtils.unsafeArray(b);
                //offsets[i] = NioUtils.unsafeArrayOffset(b) + b.position();
            //}
            //byteCounts[i] = remaining;
            //totalRemaining += remaining;
        //}
        //return totalRemaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.781 -0400", hash_original_method = "A7EE0836183CE06C4386DE620F235FAB", hash_generated_method = "3E5F5161953E783DCF4ECED0C9F074CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int doTransfer(FileDescriptor fd) throws IOException {
        dsTaint.addTaint(fd.dsTaint);
        try 
        {
            {
                int result;
                result = Libcore.os.readv(fd, ioBuffers, offsets, byteCounts);
                {
                    result = -1;
                } //End block
            } //End block
            {
                int var74139DC41892DAA1E1523A68BE0BA9F9_2066506017 = (Libcore.os.writev(fd, ioBuffers, offsets, byteCounts));
            } //End block
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //if (direction == Direction.READV) {
                //int result = Libcore.os.readv(fd, ioBuffers, offsets, byteCounts);
                //if (result == 0) {
                    //result = -1;
                //}
                //return result;
            //} else {
                //return Libcore.os.writev(fd, ioBuffers, offsets, byteCounts);
            //}
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.782 -0400", hash_original_method = "EBAF870E907233DA47B6BC3AD10EE875", hash_generated_method = "6F67A1A21494787D2024D31030290586")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void didTransfer(int byteCount) {
        dsTaint.addTaint(byteCount);
        {
            int i;
            i = 0;
            {
                ByteBuffer b;
                b = byteBuffers[i + offset];
                {
                    b.position(b.limit());
                    byteCount -= byteCounts[i];
                } //End block
                {
                    b.position((direction == Direction.WRITEV ? b.position() : 0) + byteCount);
                    byteCount = 0;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; byteCount > 0 && i < bufferCount; ++i) {
            //ByteBuffer b = byteBuffers[i + offset];
            //if (byteCounts[i] < byteCount) {
                //b.position(b.limit());
                //byteCount -= byteCounts[i];
            //} else {
                //b.position((direction == Direction.WRITEV ? b.position() : 0) + byteCount);
                //byteCount = 0;
            //}
        //}
    }

    
    enum Direction { READV, WRITEV }

    
}

