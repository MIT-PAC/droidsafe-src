package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.io.Memory;
import libcore.io.SizeOf;

final class ReadWriteHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.171 -0400", hash_original_method = "698A4093B5D08261CD10BBA0DD254D03", hash_generated_method = "7756D1F29F9F9FC140DF9D48F9915E81")
      ReadWriteHeapByteBuffer(byte[] backingArray) {
        super(backingArray);
        addTaint(backingArray[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.172 -0400", hash_original_method = "39FF2878164033A82C16A4024A20F407", hash_generated_method = "AD1FEB69B137DF12FC0B9C8A7EE53C15")
      ReadWriteHeapByteBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.172 -0400", hash_original_method = "705DEFE9EE10EC6D3F5F785589C89AC0", hash_generated_method = "D5EFC0DF72015123ECA1089E82F18863")
      ReadWriteHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
        ReadWriteHeapByteBuffer buf =
                new ReadWriteHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.172 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "AC66B2C34988CCF1039F1008BEB9C3D4")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_889353121 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_889353121 = ReadOnlyHeapByteBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_889353121.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_889353121;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.173 -0400", hash_original_method = "E8B47769CA0E36E125D00B7BF0C31D0B", hash_generated_method = "7010E66927BF4D05581C2938187367A8")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1420905707 = null; 
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1420905707 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1420905707.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1420905707;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.173 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "421A825AB2FA5B66AF3D6D6071745795")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1578222886 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1578222886 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1578222886.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1578222886;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.173 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1B8C8BD520128F89961D9D7A81F3B65C")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099757392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099757392;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.173 -0400", hash_original_method = "DFA49F6DA30AF833A3263BE3EE9CD5BB", hash_generated_method = "28B11DF17DAA79AB27E0039A68BF52D6")
    @Override
    protected byte[] protectedArray() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1486276977 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1486276977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.174 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B3AD1E36D6DA0AC94C6E613B38530ACB")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210753933 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210753933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.174 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "D71DC747907B3F7DE5CB3DABCF325B6F")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281213333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281213333;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.175 -0400", hash_original_method = "72E0A22D7133932D83149D22C98F13AD", hash_generated_method = "6F31F5CB0CE93037A71F311E253B02A1")
    @Override
    public ByteBuffer put(byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_979978187 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        backingArray[offset + position++] = b;
        varB4EAC82CA7396A68D541C85D26508E83_979978187 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_979978187.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_979978187;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.176 -0400", hash_original_method = "78F8125A8164FE61A30FAF2DC4593DB0", hash_generated_method = "C7513B2775BD6B0455A1D66305274AFC")
    @Override
    public ByteBuffer put(int index, byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1299446602 = null; 
        checkIndex(index);
        backingArray[offset + index] = b;
        varB4EAC82CA7396A68D541C85D26508E83_1299446602 = this;
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1299446602.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1299446602;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.177 -0400", hash_original_method = "B19EE749C09ADF1A37CE1094243997D4", hash_generated_method = "0675897D59E02B33217B975DEB0F24CD")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_58703567 = null; 
        checkPutBounds(1, src.length, srcOffset, byteCount);
        System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_58703567 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_58703567.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_58703567;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.177 -0400", hash_original_method = "45B8F2F72971D070F593434F2D8E9160", hash_generated_method = "8BECB5BF4204F47E21A98CAE828D1741")
    final void put(char[] src, int srcOffset, int charCount) {
        int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.178 -0400", hash_original_method = "9ABCB25C494E5D0A0EE76A30D8E8B283", hash_generated_method = "4DE5E33ADD71DF7203AF7D96B32B9076")
    final void put(double[] src, int srcOffset, int doubleCount) {
        int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.178 -0400", hash_original_method = "0A59724EAC29A22512857FADB561826F", hash_generated_method = "C2FE7C4374D245701E2635E2E499B3E2")
    final void put(float[] src, int srcOffset, int floatCount) {
        int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.179 -0400", hash_original_method = "5866478CCFA9AC7EB5AD084734CBE2FD", hash_generated_method = "454E0AAB095698D4D45E2378E552E07D")
    final void put(int[] src, int srcOffset, int intCount) {
        int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.180 -0400", hash_original_method = "4DE3C17BC2F6A0E6284BCBDEFF4353E5", hash_generated_method = "89D046AD389F16E49809A2BC6B275D91")
    final void put(long[] src, int srcOffset, int longCount) {
        int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.180 -0400", hash_original_method = "77593A6CF9C8DAF6764F897CF6EC2842", hash_generated_method = "BE2942AE24EF8EA53FDE38E6C1615DEB")
    final void put(short[] src, int srcOffset, int shortCount) {
        int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.181 -0400", hash_original_method = "82EE1C0866E5BEF2C6330A6E38277E0B", hash_generated_method = "94C35C29BD52F1688D06C3B59E5BC362")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_232913264 = null; 
        checkIndex(index, SizeOf.CHAR);
        Memory.pokeShort(backingArray, offset + index, (short) value, order);
        varB4EAC82CA7396A68D541C85D26508E83_232913264 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_232913264.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_232913264;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.182 -0400", hash_original_method = "15F32C27634A3E86C7051E2D179448EE", hash_generated_method = "8B761819B817FB47798500A6D595106C")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1043474065 = null; 
        int newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        Memory.pokeShort(backingArray, offset + position, (short) value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1043474065 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1043474065.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1043474065;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.183 -0400", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "87DEEBB4B75551210E63A91E00E95B68")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2009353658 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2009353658 = putLong(Double.doubleToRawLongBits(value));
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2009353658.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2009353658;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.184 -0400", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "B84DBF7BCA597F7C7173A8D561918C11")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_108755120 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_108755120 = putLong(index, Double.doubleToRawLongBits(value));
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_108755120.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_108755120;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.184 -0400", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "F2A160AD1BF915F03D8F767A7BFC8243")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1333160828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1333160828 = putInt(Float.floatToRawIntBits(value));
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1333160828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1333160828;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.185 -0400", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "7239F30D34A0888E0B88465E77E30E19")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1082652918 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1082652918 = putInt(index, Float.floatToRawIntBits(value));
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1082652918.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1082652918;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.186 -0400", hash_original_method = "5F1F62F303EDB135D2A78931AEAB6972", hash_generated_method = "D516A4686C4042EE28F199ABA857DB9C")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_431757365 = null; 
        int newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        Memory.pokeInt(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_431757365 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_431757365.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_431757365;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.187 -0400", hash_original_method = "D1A78DDD0C9ED6E4483E1AE7C4872A32", hash_generated_method = "136E543F86135F4F787428C4E4E3FC35")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1440756846 = null; 
        checkIndex(index, SizeOf.INT);
        Memory.pokeInt(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1440756846 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1440756846.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1440756846;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.187 -0400", hash_original_method = "1EDA1D6C4FBFEC9DA3CAFFF9583F4A7A", hash_generated_method = "10C3CB1D5F400B0CFE6E94E813A4966B")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_945822572 = null; 
        checkIndex(index, SizeOf.LONG);
        Memory.pokeLong(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_945822572 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_945822572.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_945822572;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.188 -0400", hash_original_method = "9648BBCB2FCB23C0FEFFC646460FB4AC", hash_generated_method = "A090F24379C1485D1D193546C4992669")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1953539255 = null; 
        int newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        Memory.pokeLong(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_1953539255 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1953539255.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1953539255;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.189 -0400", hash_original_method = "8DD945BCFB457C15F47AA89E5C45F024", hash_generated_method = "DE7D987133854BC23718B22CE022FFA2")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1989101987 = null; 
        checkIndex(index, SizeOf.SHORT);
        Memory.pokeShort(backingArray, offset + index, value, order);
        varB4EAC82CA7396A68D541C85D26508E83_1989101987 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1989101987.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1989101987;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.190 -0400", hash_original_method = "D29A208D139CC962C11C8258F595C612", hash_generated_method = "2FC43966A5E54C9A25BF59EFE6750015")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2012744788 = null; 
        int newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        Memory.pokeShort(backingArray, offset + position, value, order);
        position = newPosition;
        varB4EAC82CA7396A68D541C85D26508E83_2012744788 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2012744788.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2012744788;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.190 -0400", hash_original_method = "510A931F94808139B1B1492FD0FC70A6", hash_generated_method = "DC7C6DA8FAE362EF103C2EC8AB5E1FF8")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_634413006 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_634413006 = new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_634413006.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_634413006;
        
        
    }

    
}

