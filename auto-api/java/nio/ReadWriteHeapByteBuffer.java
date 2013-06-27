package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.Memory;
import libcore.io.SizeOf;

final class ReadWriteHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.107 -0400", hash_original_method = "698A4093B5D08261CD10BBA0DD254D03", hash_generated_method = "7756D1F29F9F9FC140DF9D48F9915E81")
      ReadWriteHeapByteBuffer(byte[] backingArray) {
        super(backingArray);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.107 -0400", hash_original_method = "39FF2878164033A82C16A4024A20F407", hash_generated_method = "AD1FEB69B137DF12FC0B9C8A7EE53C15")
      ReadWriteHeapByteBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.107 -0400", hash_original_method = "705DEFE9EE10EC6D3F5F785589C89AC0", hash_generated_method = "D5EFC0DF72015123ECA1089E82F18863")
      ReadWriteHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadWriteHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
        ReadWriteHeapByteBuffer buf =
                new ReadWriteHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.123 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "606E8D912B6B663AB45FEEA6AF9E5209")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_841125892 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_841125892 = ReadOnlyHeapByteBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_841125892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_841125892;
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.126 -0400", hash_original_method = "E8B47769CA0E36E125D00B7BF0C31D0B", hash_generated_method = "B2ADE9105E7A65EDC25522EB0F17A4BC")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_796749493 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_796749493 = this;
        varB4EAC82CA7396A68D541C85D26508E83_796749493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_796749493;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.127 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "1E04C2D21FEA8745BB075667012C92F7")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1444336243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1444336243 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1444336243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1444336243;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.127 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "72D6830486008CE0BD810C3686955A7A")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615933060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615933060;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.128 -0400", hash_original_method = "DFA49F6DA30AF833A3263BE3EE9CD5BB", hash_generated_method = "CE31C2B58B02C33E66B20350142CFB51")
    @Override
    protected byte[] protectedArray() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_849978561 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_849978561;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.128 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "58B561754EB810ADB575DC3F55D24F7C")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589365094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589365094;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.150 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "D586D645FD8F50B7466FE127E7A135AE")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945092911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945092911;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.151 -0400", hash_original_method = "72E0A22D7133932D83149D22C98F13AD", hash_generated_method = "9C6BEF852A2386B8C6536F00A4C9E57E")
    @Override
    public ByteBuffer put(byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1343523448 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = b;
        varB4EAC82CA7396A68D541C85D26508E83_1343523448 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1343523448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1343523448;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.154 -0400", hash_original_method = "78F8125A8164FE61A30FAF2DC4593DB0", hash_generated_method = "2D0EFD723E07CD8A7D85739BAE0DE598")
    @Override
    public ByteBuffer put(int index, byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2041060185 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = b;
        varB4EAC82CA7396A68D541C85D26508E83_2041060185 = this;
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_2041060185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2041060185;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.154 -0400", hash_original_method = "B19EE749C09ADF1A37CE1094243997D4", hash_generated_method = "C1A5771D6443A1AA3230B67F5BD5CA40")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2093845691 = null; //Variable for return #1
        checkPutBounds(1, src.length, srcOffset, byteCount);
        System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_2093845691 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_2093845691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2093845691;
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.155 -0400", hash_original_method = "45B8F2F72971D070F593434F2D8E9160", hash_generated_method = "F7C7466F8C81F5F3C70F583E7F8C335B")
    final void put(char[] src, int srcOffset, int charCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.155 -0400", hash_original_method = "9ABCB25C494E5D0A0EE76A30D8E8B283", hash_generated_method = "32096E3BD32F95C23CB7EB10C081677A")
    final void put(double[] src, int srcOffset, int doubleCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.156 -0400", hash_original_method = "0A59724EAC29A22512857FADB561826F", hash_generated_method = "ED80EB8ED5EB9244B6F895C06278B1B6")
    final void put(float[] src, int srcOffset, int floatCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.157 -0400", hash_original_method = "5866478CCFA9AC7EB5AD084734CBE2FD", hash_generated_method = "BC93836B763222941E999BC9E58A9849")
    final void put(int[] src, int srcOffset, int intCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.157 -0400", hash_original_method = "4DE3C17BC2F6A0E6284BCBDEFF4353E5", hash_generated_method = "003101942B01939CE8D42EF7E49C7FEE")
    final void put(long[] src, int srcOffset, int longCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.159 -0400", hash_original_method = "77593A6CF9C8DAF6764F897CF6EC2842", hash_generated_method = "AEF28D0FB0C8FE06A6B927A2DFF3E00A")
    final void put(short[] src, int srcOffset, int shortCount) {
        int byteCount;
        byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.169 -0400", hash_original_method = "82EE1C0866E5BEF2C6330A6E38277E0B", hash_generated_method = "097BAC57C60F7EC51F95DB204FA67D2A")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_318745544 = null; //Variable for return #1
        checkIndex(index, SizeOf.CHAR);
        Memory.pokeShort(backingArray, offset + index, (short) value, order);
        varB4EAC82CA7396A68D541C85D26508E83_318745544 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_318745544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_318745544;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //Memory.pokeShort(backingArray, offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.170 -0400", hash_original_method = "15F32C27634A3E86C7051E2D179448EE", hash_generated_method = "E863A0A525B528B8FCD85972BAE224D8")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1158848654 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeShort(backingArray, offset + position, (short) value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1158848654 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1158848654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1158848654;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.170 -0400", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "7F405A1B2E36BED3F52D5CC00B5B49F4")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1375152541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1375152541 = putLong(Double.doubleToRawLongBits(value));
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1375152541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1375152541;
        // ---------- Original Method ----------
        //return putLong(Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.171 -0400", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "15491433950E435D8E8FC107ECC3E8DD")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1321330516 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1321330516 = putLong(index, Double.doubleToRawLongBits(value));
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1321330516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1321330516;
        // ---------- Original Method ----------
        //return putLong(index, Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.180 -0400", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "E91EDDA038BF42CAA7D4A4FBB4495EF7")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_506951308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_506951308 = putInt(Float.floatToRawIntBits(value));
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_506951308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_506951308;
        // ---------- Original Method ----------
        //return putInt(Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.180 -0400", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "9B08D1CB8E4E133451C6BCE26BC6839E")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_947588189 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_947588189 = putInt(index, Float.floatToRawIntBits(value));
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_947588189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_947588189;
        // ---------- Original Method ----------
        //return putInt(index, Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.181 -0400", hash_original_method = "5F1F62F303EDB135D2A78931AEAB6972", hash_generated_method = "46F1E19441F8F345C733569F72149853")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1126545657 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeInt(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1126545657 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1126545657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126545657;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeInt(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.195 -0400", hash_original_method = "D1A78DDD0C9ED6E4483E1AE7C4872A32", hash_generated_method = "E362F7528EAE55AA80183A53252283CE")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1989283165 = null; //Variable for return #1
        checkIndex(index, SizeOf.INT);
        Memory.pokeInt(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1989283165 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1989283165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1989283165;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //Memory.pokeInt(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.195 -0400", hash_original_method = "1EDA1D6C4FBFEC9DA3CAFFF9583F4A7A", hash_generated_method = "6A3375A22E6AE66B34A7E66B43EDF5B3")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_189615097 = null; //Variable for return #1
        checkIndex(index, SizeOf.LONG);
        Memory.pokeLong(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_189615097 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_189615097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_189615097;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //Memory.pokeLong(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.196 -0400", hash_original_method = "9648BBCB2FCB23C0FEFFC646460FB4AC", hash_generated_method = "17DDA5E40F7BE7575336C3F5637807B0")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1456481269 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeLong(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1456481269 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1456481269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456481269;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeLong(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.196 -0400", hash_original_method = "8DD945BCFB457C15F47AA89E5C45F024", hash_generated_method = "2B359EAE1736E5CA7E402FB598F49A1F")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1825321586 = null; //Variable for return #1
        checkIndex(index, SizeOf.SHORT);
        Memory.pokeShort(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1825321586 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1825321586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1825321586;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //Memory.pokeShort(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.197 -0400", hash_original_method = "D29A208D139CC962C11C8258F595C612", hash_generated_method = "593CF2DF8706F11337FB2EC54C673091")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1130783839 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeShort(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1130783839 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1130783839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1130783839;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.197 -0400", hash_original_method = "510A931F94808139B1B1492FD0FC70A6", hash_generated_method = "7919F1092DC9BB0AB597B4251BFED53C")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_861525762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_861525762 = new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_861525762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861525762;
        // ---------- Original Method ----------
        //return new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

