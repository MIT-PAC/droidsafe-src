package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.619 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "50BC4104560FA709EFC802983104F1AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(offset);
        long baseSize;
        baseSize = block.getSize();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("capacity + offset > baseSize");
        } //End block
        this.effectiveDirectAddress = block.toInt() + offset;
        // ---------- Original Method ----------
        //long baseSize = block.getSize();
        //if (baseSize >= 0 && (capacity + offset) > baseSize) {
            //throw new IllegalArgumentException("capacity + offset > baseSize");
        //}
        //this.offset = offset;
        //this.effectiveDirectAddress = block.toInt() + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.620 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "DF1D24C00CF8EACA6285D721200C5C45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.620 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "6B6A37EA78BDA7D37CD05FDAC1906E10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(charCount);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        //this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.620 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "36357465E48D464C0F8CD2D0C9AD1C6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(double[] dst, int dstOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.620 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "192B6743F03E5C91C0BECAE113356357")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(float[] dst, int dstOffset, int floatCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(floatCount);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        //this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.621 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "6C777F01A7FBF0A4CC27529F28FCD59E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.621 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "A353AA1B07F4AAF202CC30ABC7293305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(long[] dst, int dstOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.621 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "7E1A37967250D1A7F2CAEF9A3BF5A0DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(short[] dst, int dstOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.621 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "5EE77A6B2A2916C334204C21620CC3E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        byte varBD0DA4AA3A28468377552D0F8F24449E_477298176 = (this.block.peekByte(offset + position++));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return this.block.peekByte(offset + position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.621 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "C3472FFED6371BD12863D22CCF1C91E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final byte get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        byte varF2A0CE0AFDDEA9BD548A776384C41D19_1003741248 = (this.block.peekByte(offset + index));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return this.block.peekByte(offset + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.622 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "19FC3795ED3BC903CAEC5243EFEC2A2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.622 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "DF0F3E4F3E4BDE0D2924B880435065D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char getChar(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char var06E809BAEE93D026FE8AE452D8BBC7FD_591797570 = ((char) this.block.peekShort(offset + index, order));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.622 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "C995F6E5877A4D0892D709E073C5D4F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.622 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "F3BBCC7391CDBF55FA38B479E789B1D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.DOUBLE);
        double varA193CCB389182973619685E8625E9532_1857032535 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.622 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "78027D4E268F5877E4081A289F804B4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.623 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "D75E02D1FF25F5AF1D5714195C64510B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.FLOAT);
        float var921F88C60A23C24861AED0C843EBCE9B_244952641 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.623 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "0B010F56B428B34213906FE57660DF0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = this.block.peekInt(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.623 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "546E2B2AABC9281D5A231887F0C517E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getInt(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.INT);
        int var137D03B6941BC5C1DF7D41533C3E9389_781875498 = (this.block.peekInt(offset + index, order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return this.block.peekInt(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.623 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "66CDAEE7996DBEF6F67C188CD3A3ECA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = this.block.peekLong(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.623 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "DEA5F743FF05097F1F990FD168E41117")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final long getLong(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long var5FE9D69D7973A2654B8886176AFE3E9E_1471383736 = (this.block.peekLong(offset + index, order));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return this.block.peekLong(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.624 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "3F4CB9D2135ED7E1DAF21C296DF62BB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.624 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "EBAB30D7147B0828D61C5272739457DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final short getShort(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var5E9FC208EB19DA73A7901D40B9D92C21_536881904 = (this.block.peekShort(offset + index, order));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.624 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "DC75FD8834783747B4631E05850E5754")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.624 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "F9713BDBA9CA6D5B4ADE6EB061597987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void free() {
        block.free();
        // ---------- Original Method ----------
        //block.free();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.624 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "E643F4983B42413EEB1271D9150C62C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected byte[] protectedArray() {
        byte[] array;
        array = this.block.array();
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] array = this.block.array();
        //if (array == null) {
            //throw new UnsupportedOperationException();
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.624 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "CBA26267D13DEE1A79D185588EE68CDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //protectedArray();
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.625 -0400", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "3B842C76813918C4DB2E757660B8044D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean protectedHasArray() {
        boolean var018F21DBC5772CA6D61006F1D966A453_2057580184 = (protectedArray() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedArray() != null;
    }

    
}

