package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteOrder;
import libcore.io.Memory;

public final class HeapBufferIterator extends BufferIterator {
    private byte[] buffer;
    private int offset;
    private int byteCount;
    private ByteOrder order;
    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.894 -0400", hash_original_method = "A6C30EED25CCFD2AB62FEA4E16ACBAB8", hash_generated_method = "958007770149E517F9392721ABBA3959")
    @DSModeled(DSC.SAFE)
     HeapBufferIterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.buffer = buffer;
        //this.offset = offset;
        //this.byteCount = byteCount;
        //this.order = order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.894 -0400", hash_original_method = "E36D4B83C08A879BB369FD4BF3E743B5", hash_generated_method = "F8B859F1E52FD5E547C55C87002C7508")
    @DSModeled(DSC.SAFE)
    public void seek(int offset) {
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //position = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.895 -0400", hash_original_method = "5C6BD475B81B38C95ED571F8A0E18EDC", hash_generated_method = "9905B39D257D33824B56812EDA1528CB")
    @DSModeled(DSC.SAFE)
    public void skip(int byteCount) {
        dsTaint.addTaint(byteCount);
        // ---------- Original Method ----------
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.895 -0400", hash_original_method = "3E61A2FCBE8F1A085EF50016EDA93C91", hash_generated_method = "7867ECB0ED59E7208C0EE9969B2ADF49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readByteArray(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        System.arraycopy(buffer, offset + position, dst, dstOffset, byteCount);
        // ---------- Original Method ----------
        //System.arraycopy(buffer, offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.895 -0400", hash_original_method = "7E225AB4906C9181CA855352CCAC2289", hash_generated_method = "31004E72FA8C80EF9983FDEA2E220095")
    @DSModeled(DSC.SAFE)
    public byte readByte() {
        byte result;
        result = buffer[offset + position];
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //byte result = buffer[offset + position];
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.895 -0400", hash_original_method = "DB59E455EA40BB4A6ED9DEE68F53B94D", hash_generated_method = "DA3C281AEFD8BDE71F1476C77C0CBE3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.895 -0400", hash_original_method = "329E16A9527E1EB7B49C2B3423D775A3", hash_generated_method = "C9339B83FE78472630FBCDC0417947FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readIntArray(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = intCount * SizeOf.INT;
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, buffer, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //final int byteCount = intCount * SizeOf.INT;
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, buffer, offset + position, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.895 -0400", hash_original_method = "DE8A7EDE581D91941B0B91B035994D93", hash_generated_method = "312F4A575993DA64EFBCD7BF744A5B69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        public static BufferIterator iterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        return new HeapBufferIterator(buffer, offset, byteCount, order);
    }

    
}

