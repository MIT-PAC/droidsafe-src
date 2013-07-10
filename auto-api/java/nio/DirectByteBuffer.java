package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.086 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.086 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "425878ED720D7C2B482B11FD2CF548F2")
    protected  DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);
        long baseSize = block.getSize();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("capacity + offset > baseSize");
        } 
        this.offset = offset;
        this.effectiveDirectAddress = block.toInt() + offset;
        addTaint(block.getTaint());
        addTaint(capacity);
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.087 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "9E5E6861D99A458773C1C8210B1DDC5E")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_853983075 = null; 
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_853983075 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_853983075.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_853983075;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.087 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "8176FF208A4F0C5AA386C22739DA971F")
    final void get(char[] dst, int dstOffset, int charCount) {
        int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.087 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "1809B29B0D09F87015FFF86D3DA74257")
    final void get(double[] dst, int dstOffset, int doubleCount) {
        int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.088 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "94103B447FC60F7E9C6FC3B0D64F4E4E")
    final void get(float[] dst, int dstOffset, int floatCount) {
        int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.088 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "0B045AE7E5BEFA9EC5BB1357F54A3A48")
    final void get(int[] dst, int dstOffset, int intCount) {
        int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.089 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "10808C06B4FF3D05751B9E80FF308511")
    final void get(long[] dst, int dstOffset, int longCount) {
        int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.090 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "D11BE2DDDFD5B9F9D0EBE5D67E614C6F")
    final void get(short[] dst, int dstOffset, int shortCount) {
        int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.090 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "F6ED0C33ED8BA1B2E48BADC5BCFF155F")
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        byte varBD0DA4AA3A28468377552D0F8F24449E_268600193 = (this.block.peekByte(offset + position++));
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1970299043 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1970299043;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.091 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "43CE321179220C4A22DC2187395DF719")
    @Override
    public final byte get(int index) {
        checkIndex(index);
        byte varF2A0CE0AFDDEA9BD548A776384C41D19_402535770 = (this.block.peekByte(offset + index));
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1967907066 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1967907066;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.091 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "A6A1666FEAC7F201076D45C80F58ECCD")
    @Override
    public final char getChar() {
        int newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        char result = (char) this.block.peekShort(offset + position, order);
        position = newPosition;
        char varA87DEB01C5F539E6BDA34829C8EF2368_854766145 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_854766145;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.092 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "A463AE399ED445B82854BDAA10FEE3E4")
    @Override
    public final char getChar(int index) {
        checkIndex(index, SizeOf.CHAR);
        char var06E809BAEE93D026FE8AE452D8BBC7FD_265811453 = ((char) this.block.peekShort(offset + index, order));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1561738047 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1561738047;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.092 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "D05F8B925242E64705CE59F337BFCB0E")
    @Override
    public final double getDouble() {
        int newPosition = position + SizeOf.DOUBLE;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        position = newPosition;
        double varE8CD7DA078A86726031AD64F35F5A6C0_1925764009 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1925764009;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.092 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "15F73ED8E5FD87047B845D9AFE93F9DD")
    @Override
    public final double getDouble(int index) {
        checkIndex(index, SizeOf.DOUBLE);
        double varA193CCB389182973619685E8625E9532_945264298 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1589353882 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1589353882;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.093 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "50AB190D4D04F2A0EF6A45F30A4DCB4C")
    @Override
    public final float getFloat() {
        int newPosition = position + SizeOf.FLOAT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        position = newPosition;
        float var546ADE640B6EDFBC8A086EF31347E768_1071961122 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1071961122;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.093 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "ED61CE559887B75966DD2B350EC8AB9D")
    @Override
    public final float getFloat(int index) {
        checkIndex(index, SizeOf.FLOAT);
        float var921F88C60A23C24861AED0C843EBCE9B_953893747 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_2099456288 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2099456288;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.094 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "81382197435C85C3056243824050B39E")
    @Override
    public final int getInt() {
        int newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        int result = this.block.peekInt(offset + position, order);
        position = newPosition;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133656655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133656655;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.094 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "29B1C63F97730DB690909CF86E21C172")
    @Override
    public final int getInt(int index) {
        checkIndex(index, SizeOf.INT);
        int var137D03B6941BC5C1DF7D41533C3E9389_188245238 = (this.block.peekInt(offset + index, order));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454935436 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454935436;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.095 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "9655FB883299E2BC6CC3106EDB1EDEBD")
    @Override
    public final long getLong() {
        int newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        long result = this.block.peekLong(offset + position, order);
        position = newPosition;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1536168873 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1536168873;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.095 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "3914EB4FE7D7B4402AB8FB8F32623FCC")
    @Override
    public final long getLong(int index) {
        checkIndex(index, SizeOf.LONG);
        long var5FE9D69D7973A2654B8886176AFE3E9E_681496819 = (this.block.peekLong(offset + index, order));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_161098829 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_161098829;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.095 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "CCEA173074AC0EB364127586F71386A0")
    @Override
    public final short getShort() {
        int newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        short result = this.block.peekShort(offset + position, order);
        position = newPosition;
        short var4F09DAA9D95BCB166A302407A0E0BABE_1160069092 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1160069092;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.096 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "DBF42ECCB49C17582269CCCC14802599")
    @Override
    public final short getShort(int index) {
        checkIndex(index, SizeOf.SHORT);
        short var5E9FC208EB19DA73A7901D40B9D92C21_1053377012 = (this.block.peekShort(offset + index, order));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_966328364 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_966328364;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.096 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "30C4CB40BA67E2FADD230D9BB17977EE")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1133394516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1133394516;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.096 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "F9713BDBA9CA6D5B4ADE6EB061597987")
    public final void free() {
        block.free();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.097 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "8B039F78227B7AE2A9692E9F3E33708A")
    @Override
    protected byte[] protectedArray() {
        byte[] array = this.block.array();
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_593138160 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_593138160;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.097 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "7B5DA5C4D164CCF04A78E6732FFA5A30")
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157256429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157256429;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.097 -0400", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "18E5F0CAB68E855B6CC17A178DE28899")
    @Override
    protected boolean protectedHasArray() {
        boolean var018F21DBC5772CA6D61006F1D966A453_1060493214 = (protectedArray() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208396593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208396593;
        
        
    }

    
}

