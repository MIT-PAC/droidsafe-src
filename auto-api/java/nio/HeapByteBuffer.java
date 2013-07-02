package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.io.SizeOf;
import libcore.io.Memory;

abstract class HeapByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.445 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "09D04850ECF89DF686CB8B497D53F4F4")

    byte[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.445 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.446 -0400", hash_original_method = "E17EA7652E4F5A67C65770DE13DD4AE3", hash_generated_method = "4FA8540A9DD1600A999EF445349CC6BD")
      HeapByteBuffer(byte[] backingArray) {
        this(backingArray, backingArray.length, 0);
        addTaint(backingArray[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.446 -0400", hash_original_method = "720B251A66EBAD61E39D94F5757C7908", hash_generated_method = "64F667538DCF04571002FE958EFD5EA7")
      HeapByteBuffer(int capacity) {
        this(new byte[capacity], capacity, 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.446 -0400", hash_original_method = "7E0C48043B88A8991A81994678604015", hash_generated_method = "5F8B3E7D3A8FDB1725AD4DDBD1FFC027")
      HeapByteBuffer(byte[] backingArray, int capacity, int offset) {
        super(capacity, null);
        this.backingArray = backingArray;
        this.offset = offset;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    ", capacity=" + capacity + ", offset=" + offset);
        } 
        addTaint(capacity);
        
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.447 -0400", hash_original_method = "A92B26D30665425608E93AFD3985B529", hash_generated_method = "980984C4CAF295BB3CC9080900A90219")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1975640691 = null; 
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1975640691 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1975640691.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1975640691;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.447 -0400", hash_original_method = "ADCC30D9FE17E9265DD10F45753F8D68", hash_generated_method = "588BA7476577AF4311FDFD9AAAC8938D")
    final void get(char[] dst, int dstOffset, int charCount) {
        int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.448 -0400", hash_original_method = "83F82E1C4D1B0FECE4775D0F7331C2A9", hash_generated_method = "2259536DCDED9A457C85B9249DA7621D")
    final void get(double[] dst, int dstOffset, int doubleCount) {
        int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.448 -0400", hash_original_method = "28783106EE8F5B0602DB80B1FE3018CE", hash_generated_method = "281318AD821F0F8BF304517E7BAAD61F")
    final void get(float[] dst, int dstOffset, int floatCount) {
        int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.448 -0400", hash_original_method = "8AC7AD179B2BD3799E5966071FB1A6E9", hash_generated_method = "CF361BAD4B289708C182482C12F393CD")
    final void get(int[] dst, int dstOffset, int intCount) {
        int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.449 -0400", hash_original_method = "3C880FD9EFF1926FF9582E7F1291E034", hash_generated_method = "16855A68781378DA640441012A045381")
    final void get(long[] dst, int dstOffset, int longCount) {
        int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.450 -0400", hash_original_method = "89F4F4A0F85F41D910E8D20C3ACD7123", hash_generated_method = "0C236E9DFD28570421143CA7332780E4")
    final void get(short[] dst, int dstOffset, int shortCount) {
        int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.450 -0400", hash_original_method = "CB9AAD8BA04B2044061C99EDA53631A5", hash_generated_method = "B7145AF0EEA242F3F8E216541E2C67BC")
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        byte var40EA57D3EE3C07BF1C102B466E1C3091_45470936 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_45470936;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.451 -0400", hash_original_method = "9AAE834531B3F44ED7B8F1D4ABA54327", hash_generated_method = "6D294CE9996AE4D973E2E403B6F81E50")
    @Override
    public final byte get(int index) {
        checkIndex(index);
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_721736728 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_721736728;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.451 -0400", hash_original_method = "A30CF2DCEAEB1ADBE9659D1E77D9D3A8", hash_generated_method = "CFC3FBE8927A996D6A761AF3903D94E7")
    @Override
    public final char getChar() {
        int newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        char result = (char) Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        char varA87DEB01C5F539E6BDA34829C8EF2368_1754217470 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1754217470;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.453 -0400", hash_original_method = "9FC96B9C645980EC4C42FC8A098BD17B", hash_generated_method = "3A75E130467AED756D856BAE1951B5D2")
    @Override
    public final char getChar(int index) {
        checkIndex(index, SizeOf.CHAR);
        char var44B2D896472A7BC850649A142494D4A7_529964458 = ((char) Memory.peekShort(backingArray, offset + index, order));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1963677644 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1963677644;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.454 -0400", hash_original_method = "15CD222F9D1D43117CE6FF35DE1821E1", hash_generated_method = "46439DF091861F7CA982315AA57D10EF")
    @Override
    public final double getDouble() {
        double varB9071C4F97A9550F857A40DA064024FB_1386159102 = (Double.longBitsToDouble(getLong()));
        double varE8CD7DA078A86726031AD64F35F5A6C0_566318799 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_566318799;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.455 -0400", hash_original_method = "2A94C74E4D47B2870E4CD8E58AB3C61D", hash_generated_method = "B157EBFE9530D9F13DC6AE4A775607F7")
    @Override
    public final double getDouble(int index) {
        double var9F522FDD8FB2086A480FD3F6145C1CC7_561594389 = (Double.longBitsToDouble(getLong(index)));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1046615526 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1046615526;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.456 -0400", hash_original_method = "47893679DF29F9C7305C0FEFB94D5263", hash_generated_method = "F1A2F1259A2A3FFAD260419E0483C8E1")
    @Override
    public final float getFloat() {
        float varB77056307B6A57ADBF03074310271972_1795862146 = (Float.intBitsToFloat(getInt()));
        float var546ADE640B6EDFBC8A086EF31347E768_1595772153 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1595772153;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.456 -0400", hash_original_method = "416C4BCEE10AD6D26C3C84E2597AE8E2", hash_generated_method = "A3861439D4DA65BAC1FF9EEDD2BADECD")
    @Override
    public final float getFloat(int index) {
        float varA8B5FEE8BE655D5CAA8E3C9A92B8AA36_1569689673 = (Float.intBitsToFloat(getInt(index)));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1575352349 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1575352349;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.457 -0400", hash_original_method = "915288BFB7584CF14BE85156D3784045", hash_generated_method = "3374E0AEFF774922BBE942A1F04727AD")
    @Override
    public final int getInt() {
        int newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        int result = Memory.peekInt(backingArray, offset + position, order);
        position = newPosition;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973184410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973184410;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.458 -0400", hash_original_method = "458AAE21B6E3B170135E629CE400B5BC", hash_generated_method = "C5749F4C6A5719811CFADC1A799A6B2C")
    @Override
    public final int getInt(int index) {
        checkIndex(index, SizeOf.INT);
        int varDE558B6E48E3F147349E9E1C74D10296_1122927229 = (Memory.peekInt(backingArray, offset + index, order));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223903316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223903316;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.458 -0400", hash_original_method = "8649950490E02A38495D16EDE99C5440", hash_generated_method = "D56684285BC2231BBAA813BADF662C3A")
    @Override
    public final long getLong() {
        int newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        long result = Memory.peekLong(backingArray, offset + position, order);
        position = newPosition;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_633512105 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_633512105;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.459 -0400", hash_original_method = "DA73492717D47126159C560DCCEA76B8", hash_generated_method = "349D95C1C6A11035539F84A7C5DBFDF1")
    @Override
    public final long getLong(int index) {
        checkIndex(index, SizeOf.LONG);
        long varF10F7DFA0512D91505296DEEA7FDB36E_1744156207 = (Memory.peekLong(backingArray, offset + index, order));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_551023432 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_551023432;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.460 -0400", hash_original_method = "D81DB9BF3EF98746269534EE74DB9F13", hash_generated_method = "D3635E2E50CFA91F46E7FB58029B8A77")
    @Override
    public final short getShort() {
        int newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        short result = Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        short var4F09DAA9D95BCB166A302407A0E0BABE_900590765 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_900590765;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.460 -0400", hash_original_method = "1734D425058DF9CB5EF1DD869B4BCEDF", hash_generated_method = "DB3BD4DBA080639473738DB1C0827B72")
    @Override
    public final short getShort(int index) {
        checkIndex(index, SizeOf.SHORT);
        short var3F6DA237402FA6C9FD635374C5CE6DE1_418281015 = (Memory.peekShort(backingArray, offset + index, order));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_842530731 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_842530731;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.460 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "74562950EAB8A15600173B4DFD3C42AA")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076173315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076173315;
        
        
    }

    
}

