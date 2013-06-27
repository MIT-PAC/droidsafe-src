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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.047 -0400", hash_original_method = "698A4093B5D08261CD10BBA0DD254D03", hash_generated_method = "7756D1F29F9F9FC140DF9D48F9915E81")
      ReadWriteHeapByteBuffer(byte[] backingArray) {
        super(backingArray);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.048 -0400", hash_original_method = "39FF2878164033A82C16A4024A20F407", hash_generated_method = "AD1FEB69B137DF12FC0B9C8A7EE53C15")
      ReadWriteHeapByteBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.048 -0400", hash_original_method = "705DEFE9EE10EC6D3F5F785589C89AC0", hash_generated_method = "D5EFC0DF72015123ECA1089E82F18863")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.060 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "41B5055D115CE910B3BAA3FBE0C468E7")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1669197376 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1669197376 = ReadOnlyHeapByteBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1669197376.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1669197376;
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.061 -0400", hash_original_method = "E8B47769CA0E36E125D00B7BF0C31D0B", hash_generated_method = "B9516DA33377554C08B2BD8313D9B2D4")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_441243967 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_441243967 = this;
        varB4EAC82CA7396A68D541C85D26508E83_441243967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_441243967;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.061 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "482D51C38DCFFF8A9491E921904C171B")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1895665494 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1895665494 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1895665494.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895665494;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.062 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "5E58DD344E0354A5537FA6969A5FA68E")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188545599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188545599;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.062 -0400", hash_original_method = "DFA49F6DA30AF833A3263BE3EE9CD5BB", hash_generated_method = "84BD4FB128E43B2161F926A16C4A863E")
    @Override
    protected byte[] protectedArray() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1699524782 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1699524782;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.062 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "909F4A9F6B367839F26601BCDA2CF63A")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901474620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901474620;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.063 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "19D90F96BCEC464DCBF863A2718F3089")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970550237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_970550237;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.066 -0400", hash_original_method = "72E0A22D7133932D83149D22C98F13AD", hash_generated_method = "02BA710862920D188FDAE0138093DEE9")
    @Override
    public ByteBuffer put(byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1762830862 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = b;
        varB4EAC82CA7396A68D541C85D26508E83_1762830862 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1762830862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1762830862;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.067 -0400", hash_original_method = "78F8125A8164FE61A30FAF2DC4593DB0", hash_generated_method = "DBCF4737151F10CA92C88809B47E4659")
    @Override
    public ByteBuffer put(int index, byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1410427339 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = b;
        varB4EAC82CA7396A68D541C85D26508E83_1410427339 = this;
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1410427339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1410427339;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.076 -0400", hash_original_method = "B19EE749C09ADF1A37CE1094243997D4", hash_generated_method = "E39350ABD96B29E8EB9427639263415A")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1939630475 = null; //Variable for return #1
        checkPutBounds(1, src.length, srcOffset, byteCount);
        System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1939630475 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1939630475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1939630475;
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.076 -0400", hash_original_method = "45B8F2F72971D070F593434F2D8E9160", hash_generated_method = "F7C7466F8C81F5F3C70F583E7F8C335B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.079 -0400", hash_original_method = "9ABCB25C494E5D0A0EE76A30D8E8B283", hash_generated_method = "32096E3BD32F95C23CB7EB10C081677A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.090 -0400", hash_original_method = "0A59724EAC29A22512857FADB561826F", hash_generated_method = "ED80EB8ED5EB9244B6F895C06278B1B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.091 -0400", hash_original_method = "5866478CCFA9AC7EB5AD084734CBE2FD", hash_generated_method = "BC93836B763222941E999BC9E58A9849")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.092 -0400", hash_original_method = "4DE3C17BC2F6A0E6284BCBDEFF4353E5", hash_generated_method = "003101942B01939CE8D42EF7E49C7FEE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.092 -0400", hash_original_method = "77593A6CF9C8DAF6764F897CF6EC2842", hash_generated_method = "AEF28D0FB0C8FE06A6B927A2DFF3E00A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.092 -0400", hash_original_method = "82EE1C0866E5BEF2C6330A6E38277E0B", hash_generated_method = "A358D0F0F33696038962925182B22E54")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_754908585 = null; //Variable for return #1
        checkIndex(index, SizeOf.CHAR);
        Memory.pokeShort(backingArray, offset + index, (short) value, order);
        varB4EAC82CA7396A68D541C85D26508E83_754908585 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_754908585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_754908585;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //Memory.pokeShort(backingArray, offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.102 -0400", hash_original_method = "15F32C27634A3E86C7051E2D179448EE", hash_generated_method = "01854665B5A3202F5F52EAD56AA6F0A0")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_395805833 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeShort(backingArray, offset + position, (short) value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_395805833 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_395805833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_395805833;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.102 -0400", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "3E836350964B592F12532AEF23D1DD9C")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1526849217 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1526849217 = putLong(Double.doubleToRawLongBits(value));
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1526849217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1526849217;
        // ---------- Original Method ----------
        //return putLong(Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.103 -0400", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "AC12C51A89C1D3EB7AA1BF5B0284AED9")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1764278216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1764278216 = putLong(index, Double.doubleToRawLongBits(value));
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1764278216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1764278216;
        // ---------- Original Method ----------
        //return putLong(index, Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.103 -0400", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "304A5F60648D43978CFA3818A1EF2C7E")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1522580383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1522580383 = putInt(Float.floatToRawIntBits(value));
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1522580383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1522580383;
        // ---------- Original Method ----------
        //return putInt(Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.105 -0400", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "6294B91B8200591345B0F24239D1664D")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_791508718 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_791508718 = putInt(index, Float.floatToRawIntBits(value));
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_791508718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_791508718;
        // ---------- Original Method ----------
        //return putInt(index, Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.135 -0400", hash_original_method = "5F1F62F303EDB135D2A78931AEAB6972", hash_generated_method = "ECBCF3CB788880B245D6CE40CD7380B9")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1003543057 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeInt(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1003543057 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1003543057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1003543057;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeInt(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.136 -0400", hash_original_method = "D1A78DDD0C9ED6E4483E1AE7C4872A32", hash_generated_method = "CC2A66FDF23CA973A64BD6D3913BF089")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1341497253 = null; //Variable for return #1
        checkIndex(index, SizeOf.INT);
        Memory.pokeInt(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1341497253 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1341497253.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1341497253;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //Memory.pokeInt(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.136 -0400", hash_original_method = "1EDA1D6C4FBFEC9DA3CAFFF9583F4A7A", hash_generated_method = "CE6ECAF1330FC812F2418D73A20A16FC")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2096607953 = null; //Variable for return #1
        checkIndex(index, SizeOf.LONG);
        Memory.pokeLong(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_2096607953 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2096607953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2096607953;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //Memory.pokeLong(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.137 -0400", hash_original_method = "9648BBCB2FCB23C0FEFFC646460FB4AC", hash_generated_method = "8738DB3758A4A747925B05169D302116")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_57730305 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeLong(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_57730305 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_57730305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_57730305;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeLong(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.139 -0400", hash_original_method = "8DD945BCFB457C15F47AA89E5C45F024", hash_generated_method = "BE1B4D98B759F6D41058F75977D570D9")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1188848607 = null; //Variable for return #1
        checkIndex(index, SizeOf.SHORT);
        Memory.pokeShort(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1188848607 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1188848607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1188848607;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //Memory.pokeShort(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.149 -0400", hash_original_method = "D29A208D139CC962C11C8258F595C612", hash_generated_method = "B0F0774287356BBA48C82EB01BED847A")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1082905866 = null; //Variable for return #1
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeShort(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1082905866 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1082905866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1082905866;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.149 -0400", hash_original_method = "510A931F94808139B1B1492FD0FC70A6", hash_generated_method = "5691F78D9DE97B264981ABF35D9BBC8F")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1868447085 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1868447085 = new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1868447085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868447085;
        // ---------- Original Method ----------
        //return new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

