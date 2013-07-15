package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.Memory;
import libcore.io.SizeOf;

final class ReadWriteHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.136 -0400", hash_original_method = "698A4093B5D08261CD10BBA0DD254D03", hash_generated_method = "7756D1F29F9F9FC140DF9D48F9915E81")
      ReadWriteHeapByteBuffer(byte[] backingArray) {
        super(backingArray);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.136 -0400", hash_original_method = "39FF2878164033A82C16A4024A20F407", hash_generated_method = "AD1FEB69B137DF12FC0B9C8A7EE53C15")
      ReadWriteHeapByteBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.137 -0400", hash_original_method = "705DEFE9EE10EC6D3F5F785589C89AC0", hash_generated_method = "87E61EE54F686DC8122E95F515CB805C")
      ReadWriteHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        addTaint(arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.137 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "943127DA673B78458720956BFE84FD77")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer varCA612679CD85B02158BA6D776D286658_1272513261 =         ReadOnlyHeapByteBuffer.copy(this, mark);
        varCA612679CD85B02158BA6D776D286658_1272513261.addTaint(taint);
        return varCA612679CD85B02158BA6D776D286658_1272513261;
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.138 -0400", hash_original_method = "E8B47769CA0E36E125D00B7BF0C31D0B", hash_generated_method = "550FDD1B1AFFAFB81BAFDD37C7B077D8")
    @Override
    public ByteBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1691602505 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1691602505.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1691602505;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.138 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "46B469E32E15E29D016F43156DA31B98")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_1145590272 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1145590272.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1145590272;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.139 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1FF391C9A7AC5A4A5E76EEB0EF6A9EBB")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_348850690 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1343044670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1343044670;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.139 -0400", hash_original_method = "DFA49F6DA30AF833A3263BE3EE9CD5BB", hash_generated_method = "8CD40D4989BCC79BF328A107DE650A95")
    @Override
    protected byte[] protectedArray() {
        byte[] var8D50CD27AA8B6BEC65C484FFCC5B2334_526025860 = (backingArray);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_13282777 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_13282777;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.139 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "65200BD09829E8AB92CCAB021C0C1B7F")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_2114936899 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673837722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673837722;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.140 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "4ACECBAAD35ED3B9D91459743B20063C")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_278342163 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908887341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_908887341;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.140 -0400", hash_original_method = "72E0A22D7133932D83149D22C98F13AD", hash_generated_method = "9DA6D813DB8033F0DD1C1544B998B0EB")
    @Override
    public ByteBuffer put(byte b) {
        addTaint(b);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1271465419 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1271465419.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1271465419;
        } //End block
        backingArray[offset + position++] = b;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1802358115 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1802358115.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1802358115;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.141 -0400", hash_original_method = "78F8125A8164FE61A30FAF2DC4593DB0", hash_generated_method = "6CD20632AC8E847AD9EF641571D801D5")
    @Override
    public ByteBuffer put(int index, byte b) {
        addTaint(b);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = b;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1160394353 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1160394353.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1160394353;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.141 -0400", hash_original_method = "B19EE749C09ADF1A37CE1094243997D4", hash_generated_method = "DCA2B01116852DF8BECE3B443112A5B1")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        checkPutBounds(1, src.length, srcOffset, byteCount);
        System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_227180124 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_227180124.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_227180124;
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.142 -0400", hash_original_method = "45B8F2F72971D070F593434F2D8E9160", hash_generated_method = "F3C96E67E434B350A4E88C1F3C95116A")
    final void put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.142 -0400", hash_original_method = "9ABCB25C494E5D0A0EE76A30D8E8B283", hash_generated_method = "EDF5B4EC8B12D8C0DE9506BB02877998")
    final void put(double[] src, int srcOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.143 -0400", hash_original_method = "0A59724EAC29A22512857FADB561826F", hash_generated_method = "058180DBBB7F7B8130D0DE416DB7ADF9")
    final void put(float[] src, int srcOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.143 -0400", hash_original_method = "5866478CCFA9AC7EB5AD084734CBE2FD", hash_generated_method = "60F491C9901AA13C82E7ED0E863C2F6B")
    final void put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.144 -0400", hash_original_method = "4DE3C17BC2F6A0E6284BCBDEFF4353E5", hash_generated_method = "D20F00F472A22199B3703EC87EF3A568")
    final void put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.145 -0400", hash_original_method = "77593A6CF9C8DAF6764F897CF6EC2842", hash_generated_method = "D865B3274F9715B068B5D9CEC6220CA8")
    final void put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.145 -0400", hash_original_method = "82EE1C0866E5BEF2C6330A6E38277E0B", hash_generated_method = "D371E29CAA396EAE4DDD234BD01B5CD7")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        Memory.pokeShort(backingArray, offset + index, (short) value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1446913032 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1446913032.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1446913032;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //Memory.pokeShort(backingArray, offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.146 -0400", hash_original_method = "15F32C27634A3E86C7051E2D179448EE", hash_generated_method = "75B425B5C55BD835316E404EF68964DC")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
        int newPosition = position + SizeOf.CHAR;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1363827464 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1363827464.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1363827464;
        } //End block
        Memory.pokeShort(backingArray, offset + position, (short) value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_146724042 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_146724042.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_146724042;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.146 -0400", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "9C0CFE2C493CB3FBE4D6424F61E613EF")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
ByteBuffer var63397BCAAEE2019B2CC5B91EEC51F456_1754832615 =         putLong(Double.doubleToRawLongBits(value));
        var63397BCAAEE2019B2CC5B91EEC51F456_1754832615.addTaint(taint);
        return var63397BCAAEE2019B2CC5B91EEC51F456_1754832615;
        // ---------- Original Method ----------
        //return putLong(Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.146 -0400", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "ABF2BF193BFA2FC72A4A92A43AF0C5B5")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
ByteBuffer var6491A3A673D52DB090173DD7A20E49B1_1217309887 =         putLong(index, Double.doubleToRawLongBits(value));
        var6491A3A673D52DB090173DD7A20E49B1_1217309887.addTaint(taint);
        return var6491A3A673D52DB090173DD7A20E49B1_1217309887;
        // ---------- Original Method ----------
        //return putLong(index, Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.147 -0400", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "6D59D59958AB302A8A606E0AE935E634")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
ByteBuffer var39EC110718D506AC0EE03962D152DF4D_1059597338 =         putInt(Float.floatToRawIntBits(value));
        var39EC110718D506AC0EE03962D152DF4D_1059597338.addTaint(taint);
        return var39EC110718D506AC0EE03962D152DF4D_1059597338;
        // ---------- Original Method ----------
        //return putInt(Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.147 -0400", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "E727832D9A46EF0BB539A41A0B254DAB")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
ByteBuffer var05FEC9A4FF20D528C8C59B99E0BA7DAA_2018005534 =         putInt(index, Float.floatToRawIntBits(value));
        var05FEC9A4FF20D528C8C59B99E0BA7DAA_2018005534.addTaint(taint);
        return var05FEC9A4FF20D528C8C59B99E0BA7DAA_2018005534;
        // ---------- Original Method ----------
        //return putInt(index, Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.148 -0400", hash_original_method = "5F1F62F303EDB135D2A78931AEAB6972", hash_generated_method = "B7248FF3CD9BD8A3D5D827120CD3BFC9")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        int newPosition = position + SizeOf.INT;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_60117259 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_60117259.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_60117259;
        } //End block
        Memory.pokeInt(backingArray, offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1376079400 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1376079400.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1376079400;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeInt(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.148 -0400", hash_original_method = "D1A78DDD0C9ED6E4483E1AE7C4872A32", hash_generated_method = "ECE5D5B8142DB04F1BA76D751CAA67CA")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        Memory.pokeInt(backingArray, offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1276435410 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1276435410.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1276435410;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //Memory.pokeInt(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.148 -0400", hash_original_method = "1EDA1D6C4FBFEC9DA3CAFFF9583F4A7A", hash_generated_method = "D2CBE113D60162A47A33A05739F526D9")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        Memory.pokeLong(backingArray, offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_505454388 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_505454388.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_505454388;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //Memory.pokeLong(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.149 -0400", hash_original_method = "9648BBCB2FCB23C0FEFFC646460FB4AC", hash_generated_method = "7FBFF8C770DA92B151E712D9550E6BEC")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        int newPosition = position + SizeOf.LONG;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_669005641 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_669005641.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_669005641;
        } //End block
        Memory.pokeLong(backingArray, offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1996044916 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1996044916.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1996044916;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeLong(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.149 -0400", hash_original_method = "8DD945BCFB457C15F47AA89E5C45F024", hash_generated_method = "E5082801A0004C1BB02BB05DE62421C3")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        Memory.pokeShort(backingArray, offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_891647420 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_891647420.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_891647420;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //Memory.pokeShort(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.150 -0400", hash_original_method = "D29A208D139CC962C11C8258F595C612", hash_generated_method = "EA91062D921B90887BA958690F3F5571")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        int newPosition = position + SizeOf.SHORT;
    if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1681423823 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1681423823.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1681423823;
        } //End block
        Memory.pokeShort(backingArray, offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1542385746 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1542385746.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1542385746;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.150 -0400", hash_original_method = "510A931F94808139B1B1492FD0FC70A6", hash_generated_method = "B65D5BDE30D0D77F769621CF276F9AF2")
    @Override
    public ByteBuffer slice() {
ByteBuffer var86225C40A96095E9D938EE6FBC93E446_876533061 =         new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
        var86225C40A96095E9D938EE6FBC93E446_876533061.addTaint(taint);
        return var86225C40A96095E9D938EE6FBC93E446_876533061;
        // ---------- Original Method ----------
        //return new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

