package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteOrder;
import libcore.io.Memory;

public final class HeapBufferIterator extends BufferIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.594 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.594 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.594 -0400", hash_original_field = "A43EF6D60A83013EA1A61A23BDB16029", hash_generated_field = "DC277C639F48D7E94DBBE3413CDE414C")

    private int byteCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.594 -0400", hash_original_field = "70A17FFA722A3985B86D30B034AD06D7", hash_generated_field = "5EA306A71C575DAB9547A05F7BED60EB")

    private ByteOrder order;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.594 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.595 -0400", hash_original_method = "A6C30EED25CCFD2AB62FEA4E16ACBAB8", hash_generated_method = "823E99C85FB6B418E4A8B14A07E9B962")
      HeapBufferIterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        this.buffer = buffer;
        this.offset = offset;
        this.byteCount = byteCount;
        this.order = order;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.596 -0400", hash_original_method = "E36D4B83C08A879BB369FD4BF3E743B5", hash_generated_method = "D66EB936D868E838CC6FBF758BD016A1")
    public void seek(int offset) {
        position = offset;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.596 -0400", hash_original_method = "5C6BD475B81B38C95ED571F8A0E18EDC", hash_generated_method = "940E96887BCB1FBE664555A63C820A3C")
    public void skip(int byteCount) {
        position += byteCount;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.596 -0400", hash_original_method = "3E61A2FCBE8F1A085EF50016EDA93C91", hash_generated_method = "F2A972725E0F950EABF7D46C2A9BF48F")
    public void readByteArray(byte[] dst, int dstOffset, int byteCount) {
        addTaint(dstOffset);
        addTaint(dst[0]);
        System.arraycopy(buffer, offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.597 -0400", hash_original_method = "7E225AB4906C9181CA855352CCAC2289", hash_generated_method = "4AF441FAF10419D72EF7B098C7024387")
    public byte readByte() {
        byte result = buffer[offset + position];
        ++position;
        byte varB4A88417B3D0170D754C647C30B7216A_1060194737 = (result);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_143539001 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_143539001;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.597 -0400", hash_original_method = "DB59E455EA40BB4A6ED9DEE68F53B94D", hash_generated_method = "0196E147C8B66E92A0F33A7F52D321C1")
    public int readInt() {
        int result = Memory.peekInt(buffer, offset + position, order);
        position += SizeOf.INT;
        int varB4A88417B3D0170D754C647C30B7216A_403228984 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501559492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501559492;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.598 -0400", hash_original_method = "329E16A9527E1EB7B49C2B3423D775A3", hash_generated_method = "F9498F674AF7E8E07D616E60E23ACF01")
    public void readIntArray(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        final int byteCount = intCount * SizeOf.INT;
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, buffer, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.598 -0400", hash_original_method = "DE8A7EDE581D91941B0B91B035994D93", hash_generated_method = "1710BFD0DDECCCD743900FA584417568")
    public short readShort() {
        short result = Memory.peekShort(buffer, offset + position, order);
        position += SizeOf.SHORT;
        short varB4A88417B3D0170D754C647C30B7216A_886627172 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1332008732 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1332008732;
        
        
        
        
    }

    
        public static BufferIterator iterator(byte[] buffer, int offset, int byteCount, ByteOrder order) {
        return new HeapBufferIterator(buffer, offset, byteCount, order);
    }

    
}

