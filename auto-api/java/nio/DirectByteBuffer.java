package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.169 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.170 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "6AD86368A69BEC0067E36D57FC18DCA3")
    protected  DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);
        long baseSize;
        baseSize = block.getSize();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("capacity + offset > baseSize");
        } //End block
        this.offset = offset;
        this.effectiveDirectAddress = block.toInt() + offset;
        addTaint(block.getTaint());
        addTaint(capacity);
        // ---------- Original Method ----------
        //long baseSize = block.getSize();
        //if (baseSize >= 0 && (capacity + offset) > baseSize) {
            //throw new IllegalArgumentException("capacity + offset > baseSize");
        //}
        //this.offset = offset;
        //this.effectiveDirectAddress = block.toInt() + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.179 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "19A31553632BE90FAE47315B1B46BB07")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1103668629 = null; //Variable for return #1
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1103668629 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1103668629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1103668629;
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.180 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "D1CBDDBDC88F85B22DFC98030FDC2911")
    final void get(char[] dst, int dstOffset, int charCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        //this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.192 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "E40D8DBD9BC8EDD77E53465E1EC3CEF6")
    final void get(double[] dst, int dstOffset, int doubleCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.192 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "F0DEA80BA08AF649E3A29937ACCE7BD5")
    final void get(float[] dst, int dstOffset, int floatCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        //this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.193 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "F4D14D39DA684F8BA0ACC48AA86917D1")
    final void get(int[] dst, int dstOffset, int intCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.193 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "8A2BD5780EF6060310CF8B7875A2D58A")
    final void get(long[] dst, int dstOffset, int longCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.193 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "9D791181F6BF2C84313A4B05390DB012")
    final void get(short[] dst, int dstOffset, int shortCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.194 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "41CE0A262507E5BC4EF2A53BFF5A09B4")
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        byte varBD0DA4AA3A28468377552D0F8F24449E_1376259546 = (this.block.peekByte(offset + position++));
        byte var40EA57D3EE3C07BF1C102B466E1C3091_490586404 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_490586404;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return this.block.peekByte(offset + position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.194 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "E186EEBB003B5054F4ECCA63E9691783")
    @Override
    public final byte get(int index) {
        checkIndex(index);
        byte varF2A0CE0AFDDEA9BD548A776384C41D19_483152854 = (this.block.peekByte(offset + index));
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1742077933 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1742077933;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return this.block.peekByte(offset + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.194 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "199C53E38F3EC5E19EBFF73C5DBD030C")
    @Override
    public final char getChar() {
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char result;
        result = (char) this.block.peekShort(offset + position, order);
        position = newPosition;
        char varA87DEB01C5F539E6BDA34829C8EF2368_1652720747 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1652720747;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.206 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "D5B8A1A726CB406FCD841FAEFAA9E21F")
    @Override
    public final char getChar(int index) {
        checkIndex(index, SizeOf.CHAR);
        char var06E809BAEE93D026FE8AE452D8BBC7FD_1529567088 = ((char) this.block.peekShort(offset + index, order));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_2005276399 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2005276399;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.206 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "145F25E0FE8829FB73B802945D17C939")
    @Override
    public final double getDouble() {
        int newPosition;
        newPosition = position + SizeOf.DOUBLE;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        double result;
        result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        position = newPosition;
        double varE8CD7DA078A86726031AD64F35F5A6C0_1179638865 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1179638865;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.207 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "9E3BBC2AB5676199AC5BCA930F81E081")
    @Override
    public final double getDouble(int index) {
        checkIndex(index, SizeOf.DOUBLE);
        double varA193CCB389182973619685E8625E9532_1809060580 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_276041064 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_276041064;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.208 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "A60E7480C9339A3A06E37811D48BE7B4")
    @Override
    public final float getFloat() {
        int newPosition;
        newPosition = position + SizeOf.FLOAT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        float result;
        result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        position = newPosition;
        float var546ADE640B6EDFBC8A086EF31347E768_2075304558 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2075304558;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.209 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "2F66105FA5B8E5DE4D5DE723FF528A8D")
    @Override
    public final float getFloat(int index) {
        checkIndex(index, SizeOf.FLOAT);
        float var921F88C60A23C24861AED0C843EBCE9B_750686869 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1780557315 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1780557315;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.210 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "9381E89F10D7746B1C4D9A83B476B18A")
    @Override
    public final int getInt() {
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int result;
        result = this.block.peekInt(offset + position, order);
        position = newPosition;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878633521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878633521;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = this.block.peekInt(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.210 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "E833E45500E2E220F4A60F977E823AD3")
    @Override
    public final int getInt(int index) {
        checkIndex(index, SizeOf.INT);
        int var137D03B6941BC5C1DF7D41533C3E9389_1327913889 = (this.block.peekInt(offset + index, order));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82332278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82332278;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return this.block.peekInt(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.211 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "EFEA961A0A618E1CB2F316F7E789F1E8")
    @Override
    public final long getLong() {
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        long result;
        result = this.block.peekLong(offset + position, order);
        position = newPosition;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_44212991 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_44212991;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = this.block.peekLong(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.231 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "A8DA6D45136472B700976BFD74C074EA")
    @Override
    public final long getLong(int index) {
        checkIndex(index, SizeOf.LONG);
        long var5FE9D69D7973A2654B8886176AFE3E9E_1023223495 = (this.block.peekLong(offset + index, order));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_330832072 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_330832072;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return this.block.peekLong(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.232 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "A5A18A8903498B9E52C17B07DEC4CF0D")
    @Override
    public final short getShort() {
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        short result;
        result = this.block.peekShort(offset + position, order);
        position = newPosition;
        short var4F09DAA9D95BCB166A302407A0E0BABE_1340459063 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1340459063;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.232 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "573C2A029C22DE09F34ABFBB7FC706E6")
    @Override
    public final short getShort(int index) {
        checkIndex(index, SizeOf.SHORT);
        short var5E9FC208EB19DA73A7901D40B9D92C21_1954412740 = (this.block.peekShort(offset + index, order));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1006722130 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1006722130;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.232 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "2CE1B041FFA71A1105536F206BF987F1")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321422796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_321422796;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.233 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "F9713BDBA9CA6D5B4ADE6EB061597987")
    public final void free() {
        block.free();
        // ---------- Original Method ----------
        //block.free();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.233 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "D56615F74706E762BD83D023D166E66E")
    @Override
    protected byte[] protectedArray() {
        byte[] array;
        array = this.block.array();
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_86151754 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_86151754;
        // ---------- Original Method ----------
        //byte[] array = this.block.array();
        //if (array == null) {
            //throw new UnsupportedOperationException();
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.249 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "AEC18511A697A54C794810082EEB9FF3")
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893513990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893513990;
        // ---------- Original Method ----------
        //protectedArray();
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.249 -0400", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "D1D79462EED2029E97D7B6519B9615FF")
    @Override
    protected boolean protectedHasArray() {
        boolean var018F21DBC5772CA6D61006F1D966A453_401547480 = (protectedArray() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223481732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223481732;
        // ---------- Original Method ----------
        //return protectedArray() != null;
    }

    
}

