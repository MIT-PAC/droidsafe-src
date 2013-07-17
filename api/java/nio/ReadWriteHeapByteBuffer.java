package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.Memory;
import libcore.io.SizeOf;

final class ReadWriteHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.735 -0400", hash_original_method = "698A4093B5D08261CD10BBA0DD254D03", hash_generated_method = "7756D1F29F9F9FC140DF9D48F9915E81")
      ReadWriteHeapByteBuffer(byte[] backingArray) {
        super(backingArray);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.736 -0400", hash_original_method = "39FF2878164033A82C16A4024A20F407", hash_generated_method = "AD1FEB69B137DF12FC0B9C8A7EE53C15")
      ReadWriteHeapByteBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.736 -0400", hash_original_method = "705DEFE9EE10EC6D3F5F785589C89AC0", hash_generated_method = "87E61EE54F686DC8122E95F515CB805C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.736 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "4A7F88DC1EEDEA18335D243CFD898D09")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer varCA612679CD85B02158BA6D776D286658_716426796 =         ReadOnlyHeapByteBuffer.copy(this, mark);
        varCA612679CD85B02158BA6D776D286658_716426796.addTaint(taint);
        return varCA612679CD85B02158BA6D776D286658_716426796;
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.737 -0400", hash_original_method = "E8B47769CA0E36E125D00B7BF0C31D0B", hash_generated_method = "65E55A50112A8667211E7BBD76098326")
    @Override
    public ByteBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1862990694 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1862990694.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1862990694;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.737 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "81B94061C421477C57437EE1192760ED")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_1585204882 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1585204882.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1585204882;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.738 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "61EF2FDA258F7308CD6D5BC9AA3A6478")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1747055401 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2055962613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2055962613;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.738 -0400", hash_original_method = "DFA49F6DA30AF833A3263BE3EE9CD5BB", hash_generated_method = "29BDEEA32DD0BE2EB921030F725AA173")
    @Override
    protected byte[] protectedArray() {
        byte[] var8D50CD27AA8B6BEC65C484FFCC5B2334_1870022021 = (backingArray);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1445368947 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1445368947;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.738 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "E3051B8EA8EDE61574BE3E5C45A7FFB1")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1315071897 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437545455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437545455;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.738 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "0FE9F605A92EC5A707EE23ED1C06EC5F")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_2030949122 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763045720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763045720;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.739 -0400", hash_original_method = "72E0A22D7133932D83149D22C98F13AD", hash_generated_method = "8BC018B7B1CC0FF2379B8FA4E9D7DBC1")
    @Override
    public ByteBuffer put(byte b) {
        addTaint(b);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1271943864 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1271943864.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1271943864;
        } //End block
        backingArray[offset + position++] = b;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1242953220 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1242953220.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1242953220;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.739 -0400", hash_original_method = "78F8125A8164FE61A30FAF2DC4593DB0", hash_generated_method = "56D5596A4B9BE1CA23BFAE4902420AF8")
    @Override
    public ByteBuffer put(int index, byte b) {
        addTaint(b);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = b;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1808839362 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1808839362.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1808839362;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.740 -0400", hash_original_method = "B19EE749C09ADF1A37CE1094243997D4", hash_generated_method = "29426A25DA0C33A73A917D517779FCA0")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        checkPutBounds(1, src.length, srcOffset, byteCount);
        System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_2127484241 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2127484241.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2127484241;
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.740 -0400", hash_original_method = "45B8F2F72971D070F593434F2D8E9160", hash_generated_method = "F3C96E67E434B350A4E88C1F3C95116A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.741 -0400", hash_original_method = "9ABCB25C494E5D0A0EE76A30D8E8B283", hash_generated_method = "EDF5B4EC8B12D8C0DE9506BB02877998")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.741 -0400", hash_original_method = "0A59724EAC29A22512857FADB561826F", hash_generated_method = "058180DBBB7F7B8130D0DE416DB7ADF9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.742 -0400", hash_original_method = "5866478CCFA9AC7EB5AD084734CBE2FD", hash_generated_method = "60F491C9901AA13C82E7ED0E863C2F6B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.743 -0400", hash_original_method = "4DE3C17BC2F6A0E6284BCBDEFF4353E5", hash_generated_method = "D20F00F472A22199B3703EC87EF3A568")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.743 -0400", hash_original_method = "77593A6CF9C8DAF6764F897CF6EC2842", hash_generated_method = "D865B3274F9715B068B5D9CEC6220CA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.744 -0400", hash_original_method = "82EE1C0866E5BEF2C6330A6E38277E0B", hash_generated_method = "3BA06DB91286F4DC62F14CDC1540BB9C")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        Memory.pokeShort(backingArray, offset + index, (short) value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1905410517 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1905410517.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1905410517;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //Memory.pokeShort(backingArray, offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.744 -0400", hash_original_method = "15F32C27634A3E86C7051E2D179448EE", hash_generated_method = "8074D1447523F1C47406EE615EFE6395")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
        int newPosition = position + SizeOf.CHAR;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_981613210 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_981613210.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_981613210;
        } //End block
        Memory.pokeShort(backingArray, offset + position, (short) value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1738759293 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1738759293.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1738759293;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.744 -0400", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "2146E3D5FEDBD367FB157D3C912248B2")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
ByteBuffer var63397BCAAEE2019B2CC5B91EEC51F456_537243871 =         putLong(Double.doubleToRawLongBits(value));
        var63397BCAAEE2019B2CC5B91EEC51F456_537243871.addTaint(taint);
        return var63397BCAAEE2019B2CC5B91EEC51F456_537243871;
        // ---------- Original Method ----------
        //return putLong(Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "076102071BEEE8593311F6EB75F8748F")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
ByteBuffer var6491A3A673D52DB090173DD7A20E49B1_1815741476 =         putLong(index, Double.doubleToRawLongBits(value));
        var6491A3A673D52DB090173DD7A20E49B1_1815741476.addTaint(taint);
        return var6491A3A673D52DB090173DD7A20E49B1_1815741476;
        // ---------- Original Method ----------
        //return putLong(index, Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "FDF243A1AF456DBE84A77D375DB1F665")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
ByteBuffer var39EC110718D506AC0EE03962D152DF4D_238657615 =         putInt(Float.floatToRawIntBits(value));
        var39EC110718D506AC0EE03962D152DF4D_238657615.addTaint(taint);
        return var39EC110718D506AC0EE03962D152DF4D_238657615;
        // ---------- Original Method ----------
        //return putInt(Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "D8ECBF7407706F7CBBFB4FA920102C04")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
ByteBuffer var05FEC9A4FF20D528C8C59B99E0BA7DAA_442371905 =         putInt(index, Float.floatToRawIntBits(value));
        var05FEC9A4FF20D528C8C59B99E0BA7DAA_442371905.addTaint(taint);
        return var05FEC9A4FF20D528C8C59B99E0BA7DAA_442371905;
        // ---------- Original Method ----------
        //return putInt(index, Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "5F1F62F303EDB135D2A78931AEAB6972", hash_generated_method = "199B3C197AAEFD6F25D1A2BE1FC3515C")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        int newPosition = position + SizeOf.INT;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1090440247 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1090440247.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1090440247;
        } //End block
        Memory.pokeInt(backingArray, offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1341785838 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1341785838.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1341785838;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeInt(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "D1A78DDD0C9ED6E4483E1AE7C4872A32", hash_generated_method = "55CD412B28F71575CCB0A0500E9F8F30")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        Memory.pokeInt(backingArray, offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_69620039 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_69620039.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_69620039;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //Memory.pokeInt(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "1EDA1D6C4FBFEC9DA3CAFFF9583F4A7A", hash_generated_method = "FDE60DB5439C7EF5059DF32E0529CBDF")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        Memory.pokeLong(backingArray, offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_427415771 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_427415771.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_427415771;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //Memory.pokeLong(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "9648BBCB2FCB23C0FEFFC646460FB4AC", hash_generated_method = "6BAFC2F9AE6009E03C4369BF0A7326AD")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        int newPosition = position + SizeOf.LONG;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1419529435 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1419529435.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1419529435;
        } //End block
        Memory.pokeLong(backingArray, offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_740089004 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_740089004.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_740089004;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeLong(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.745 -0400", hash_original_method = "8DD945BCFB457C15F47AA89E5C45F024", hash_generated_method = "AAEB92A35F7646AC3121BC9C84B6C300")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        Memory.pokeShort(backingArray, offset + index, value, order);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1869297054 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1869297054.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1869297054;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //Memory.pokeShort(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.746 -0400", hash_original_method = "D29A208D139CC962C11C8258F595C612", hash_generated_method = "4E1DF016FD504C508032119C5F11E69E")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        int newPosition = position + SizeOf.SHORT;
        if(newPosition > limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1884545014 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1884545014.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1884545014;
        } //End block
        Memory.pokeShort(backingArray, offset + position, value, order);
        position = newPosition;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1263321303 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1263321303.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1263321303;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.746 -0400", hash_original_method = "510A931F94808139B1B1492FD0FC70A6", hash_generated_method = "29D2CDBED74B94F9B624BFA2CF03FF10")
    @Override
    public ByteBuffer slice() {
ByteBuffer var86225C40A96095E9D938EE6FBC93E446_1117215356 =         new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
        var86225C40A96095E9D938EE6FBC93E446_1117215356.addTaint(taint);
        return var86225C40A96095E9D938EE6FBC93E446_1117215356;
        // ---------- Original Method ----------
        //return new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

