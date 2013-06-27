package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.134 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.135 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "6AD86368A69BEC0067E36D57FC18DCA3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.149 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "605FE08CC6D678FECE112E04EEC250B4")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1587521289 = null; //Variable for return #1
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1587521289 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1587521289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1587521289;
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.149 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "D1CBDDBDC88F85B22DFC98030FDC2911")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.150 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "E40D8DBD9BC8EDD77E53465E1EC3CEF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.150 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "F0DEA80BA08AF649E3A29937ACCE7BD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.150 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "F4D14D39DA684F8BA0ACC48AA86917D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.151 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "8A2BD5780EF6060310CF8B7875A2D58A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.151 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "9D791181F6BF2C84313A4B05390DB012")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.161 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "A53CB0CDF88082BA3316B05F81B675F7")
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        byte varBD0DA4AA3A28468377552D0F8F24449E_1944348049 = (this.block.peekByte(offset + position++));
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1429844418 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1429844418;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return this.block.peekByte(offset + position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.164 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "C668C0EFC25477FCED5918A3C353BD18")
    @Override
    public final byte get(int index) {
        checkIndex(index);
        byte varF2A0CE0AFDDEA9BD548A776384C41D19_267763495 = (this.block.peekByte(offset + index));
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_588844774 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_588844774;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return this.block.peekByte(offset + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.179 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "8FB30E6599869AFC664999BEE1C856D6")
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
        char varA87DEB01C5F539E6BDA34829C8EF2368_224589901 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_224589901;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.179 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "717B0B534A207B622832B811E6B4B7EF")
    @Override
    public final char getChar(int index) {
        checkIndex(index, SizeOf.CHAR);
        char var06E809BAEE93D026FE8AE452D8BBC7FD_1254930376 = ((char) this.block.peekShort(offset + index, order));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1156138102 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1156138102;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.180 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "9FB7708299CCF48AA001CDFCEAC9F945")
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
        double varE8CD7DA078A86726031AD64F35F5A6C0_237340599 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_237340599;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.180 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "CDA7C9DBC98244220012F7ED8258036F")
    @Override
    public final double getDouble(int index) {
        checkIndex(index, SizeOf.DOUBLE);
        double varA193CCB389182973619685E8625E9532_1570266793 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1223680203 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1223680203;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.180 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "3E7C0DBEA19C23E299EA09E42A0D7B1A")
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
        float var546ADE640B6EDFBC8A086EF31347E768_664005438 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_664005438;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.187 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "E9BF68B5EF38A390417F3CF96EAADF36")
    @Override
    public final float getFloat(int index) {
        checkIndex(index, SizeOf.FLOAT);
        float var921F88C60A23C24861AED0C843EBCE9B_329936210 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1043710577 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1043710577;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.187 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "8CC0FFA90FB633475E32007EE7A5666F")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698617378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1698617378;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = this.block.peekInt(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.187 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "F4B1BF262DC84BC43F8AB6BF151EA0B3")
    @Override
    public final int getInt(int index) {
        checkIndex(index, SizeOf.INT);
        int var137D03B6941BC5C1DF7D41533C3E9389_2099915595 = (this.block.peekInt(offset + index, order));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835057620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835057620;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return this.block.peekInt(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.188 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "678946C824E7D27098FB47B933B9B588")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_808733002 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_808733002;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = this.block.peekLong(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.188 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "89F5B596919A2594EAB659AA6309DCE8")
    @Override
    public final long getLong(int index) {
        checkIndex(index, SizeOf.LONG);
        long var5FE9D69D7973A2654B8886176AFE3E9E_1117908257 = (this.block.peekLong(offset + index, order));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_596288153 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_596288153;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return this.block.peekLong(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.189 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "0213C2BCDFEA59E8E551EFB970B1D4CA")
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
        short var4F09DAA9D95BCB166A302407A0E0BABE_1726948545 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1726948545;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.189 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "C21B0ED73D06A2467327502CD1AFEF2D")
    @Override
    public final short getShort(int index) {
        checkIndex(index, SizeOf.SHORT);
        short var5E9FC208EB19DA73A7901D40B9D92C21_568616986 = (this.block.peekShort(offset + index, order));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1475231057 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1475231057;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.190 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "CBA7628B4A00EB8DD733CC020A1D9B66")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399990003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_399990003;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.206 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "F9713BDBA9CA6D5B4ADE6EB061597987")
    public final void free() {
        block.free();
        // ---------- Original Method ----------
        //block.free();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.207 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "64F3F91A9422B552E42EC8C62AD4A933")
    @Override
    protected byte[] protectedArray() {
        byte[] array;
        array = this.block.array();
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1681957117 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1681957117;
        // ---------- Original Method ----------
        //byte[] array = this.block.array();
        //if (array == null) {
            //throw new UnsupportedOperationException();
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.207 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "8D2BC2B1CAE09C14DFF8E487FC8DF9B1")
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1478385106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1478385106;
        // ---------- Original Method ----------
        //protectedArray();
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.211 -0400", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "0343A7DB5F68E6D99E79AE0F06E84FC9")
    @Override
    protected boolean protectedHasArray() {
        boolean var018F21DBC5772CA6D61006F1D966A453_1601590916 = (protectedArray() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940717909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940717909;
        // ---------- Original Method ----------
        //return protectedArray() != null;
    }

    
}

