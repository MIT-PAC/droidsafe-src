package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteOrder;
import libcore.io.Memory;

public final class HeapBufferIterator extends BufferIterator {
    private final byte[] buffer;
    private final int offset;
    private final int byteCount;
    private final ByteOrder order;
    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.434 -0400", hash_original_method = "A6C30EED25CCFD2AB62FEA4E16ACBAB8", hash_generated_method = "08798E32B45119ECF7E3557EE9582BC9")
    @DSModeled(DSC.SAFE)
     HeapBufferIterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.buffer = buffer;
        //this.offset = offset;
        //this.byteCount = byteCount;
        //this.order = order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "E36D4B83C08A879BB369FD4BF3E743B5", hash_generated_method = "36C4833EE09B638F986DC76641959CE2")
    @DSModeled(DSC.SAFE)
    public void seek(int offset) {
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //position = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "5C6BD475B81B38C95ED571F8A0E18EDC", hash_generated_method = "35AAC2E3BEDCA6DE4735D9FD7C89C78C")
    @DSModeled(DSC.SAFE)
    public void skip(int byteCount) {
        dsTaint.addTaint(byteCount);
        // ---------- Original Method ----------
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "3E61A2FCBE8F1A085EF50016EDA93C91", hash_generated_method = "850EA7BFC78D2F14A9F0B371F784BCA0")
    @DSModeled(DSC.SAFE)
    public void readByteArray(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        System.arraycopy(buffer, offset + position, dst, dstOffset, byteCount);
        // ---------- Original Method ----------
        //System.arraycopy(buffer, offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "7E225AB4906C9181CA855352CCAC2289", hash_generated_method = "852C822B8488C7CCD1B45022BA90CC86")
    @DSModeled(DSC.SAFE)
    public byte readByte() {
        byte result;
        result = buffer[offset + position];
        ++position;
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //byte result = buffer[offset + position];
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "DB59E455EA40BB4A6ED9DEE68F53B94D", hash_generated_method = "A1F547237BEAEACFDB6B665662EA4841")
    @DSModeled(DSC.SAFE)
    public int readInt() {
        int result;
        result = Memory.peekInt(buffer, offset + position, order);
        position += SizeOf.INT;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = Memory.peekInt(buffer, offset + position, order);
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "329E16A9527E1EB7B49C2B3423D775A3", hash_generated_method = "257BD240CC0079204119DE74142A1561")
    @DSModeled(DSC.SAFE)
    public void readIntArray(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        final int byteCount;
        byteCount = intCount * SizeOf.INT;
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, buffer, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //final int byteCount = intCount * SizeOf.INT;
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, buffer, offset + position, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "DE8A7EDE581D91941B0B91B035994D93", hash_generated_method = "9CAE3ACCE2B05A3DA31831CE3532DCAA")
    @DSModeled(DSC.SAFE)
    public short readShort() {
        short result;
        result = Memory.peekShort(buffer, offset + position, order);
        position += SizeOf.SHORT;
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //short result = Memory.peekShort(buffer, offset + position, order);
        //position += SizeOf.SHORT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.435 -0400", hash_original_method = "50DDBF65236F6B74CE26E4FFEB599E26", hash_generated_method = "1C6F16E9EC71C8983BCCE2335895A333")
    public static BufferIterator iterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        return new HeapBufferIterator(buffer, offset, byteCount, order);
    }

    
}


