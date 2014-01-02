package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteOrder;






public final class HeapBufferIterator extends BufferIterator {

    /**
     * Returns a new iterator over {@code buffer}, starting at {@code offset} and continuing for
     * {@code byteCount} bytes. Items larger than a byte are interpreted using the given byte order.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.596 -0500", hash_original_method = "50DDBF65236F6B74CE26E4FFEB599E26", hash_generated_method = "1C6F16E9EC71C8983BCCE2335895A333")
    
public static BufferIterator iterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        return new HeapBufferIterator(buffer, offset, byteCount, order);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.565 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private  byte[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.567 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private  int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.570 -0500", hash_original_field = "FC1D512EB5A05C1E1E196E59E2DEC859", hash_generated_field = "DC277C639F48D7E94DBBE3413CDE414C")

    private  int byteCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.572 -0500", hash_original_field = "E082DA3C44F503226ED810D6BA3A24C0", hash_generated_field = "5EA306A71C575DAB9547A05F7BED60EB")

    private  ByteOrder order;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.574 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "312206EA2404526B7BBC621459C87A80")


    private int position;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.577 -0500", hash_original_method = "A6C30EED25CCFD2AB62FEA4E16ACBAB8", hash_generated_method = "A6C30EED25CCFD2AB62FEA4E16ACBAB8")
    
HeapBufferIterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        this.buffer = buffer;
        this.offset = offset;
        this.byteCount = byteCount;
        this.order = order;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.579 -0500", hash_original_method = "E36D4B83C08A879BB369FD4BF3E743B5", hash_generated_method = "89EF647B0FB134CB7088C8FC04ED9705")
    
public void seek(int offset) {
        position = offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.581 -0500", hash_original_method = "5C6BD475B81B38C95ED571F8A0E18EDC", hash_generated_method = "C71B63B55A78ABE126A2084325A3BF14")
    
public void skip(int byteCount) {
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.583 -0500", hash_original_method = "3E61A2FCBE8F1A085EF50016EDA93C91", hash_generated_method = "B04DA2391690FAC6443414964BD05355")
    
public void readByteArray(byte[] dst, int dstOffset, int byteCount) {
        System.arraycopy(buffer, offset + position, dst, dstOffset, byteCount);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.586 -0500", hash_original_method = "7E225AB4906C9181CA855352CCAC2289", hash_generated_method = "A1801187CC0C135B81530FBE3F56BD6E")
    
public byte readByte() {
        byte result = buffer[offset + position];
        ++position;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.588 -0500", hash_original_method = "DB59E455EA40BB4A6ED9DEE68F53B94D", hash_generated_method = "5523EA7EBBA3701703A6ECB156B3D0B0")
    
public int readInt() {
        int result = Memory.peekInt(buffer, offset + position, order);
        position += SizeOf.INT;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.591 -0500", hash_original_method = "329E16A9527E1EB7B49C2B3423D775A3", hash_generated_method = "87CE23AEB6ED153D49ED54CDFB1D7681")
    
public void readIntArray(int[] dst, int dstOffset, int intCount) {
        final int byteCount = intCount * SizeOf.INT;
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, buffer, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.594 -0500", hash_original_method = "DE8A7EDE581D91941B0B91B035994D93", hash_generated_method = "52CA29CF8633B1B8AC3C914C142C277D")
    
public short readShort() {
        short result = Memory.peekShort(buffer, offset + position, order);
        position += SizeOf.SHORT;
        return result;
    }

    
}

