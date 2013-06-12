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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.721 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "4DD300BEAADA2D21167775B35D0D8475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.724 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "B2B7C67A2FB4051E8A81C3A52704C04B")
    @DSModeled(DSC.SAFE)
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.725 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "2359CAD9FFED98CE838A7ABB351F0F3A")
    @DSModeled(DSC.SAFE)
    final void get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.727 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "C3DB2F69307B3C5AE5D4E99236C15AB0")
    @DSModeled(DSC.SAFE)
    final void get(double[] dst, int dstOffset, int doubleCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.729 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "745B1E76CAE23914482D721093089BE3")
    @DSModeled(DSC.SAFE)
    final void get(float[] dst, int dstOffset, int floatCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.730 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "73B52F34672DAC5E2DCF7CF52A39D597")
    @DSModeled(DSC.SAFE)
    final void get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.732 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "CA82BF41E55ECF800A492917538BF68C")
    @DSModeled(DSC.SAFE)
    final void get(long[] dst, int dstOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.734 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "082C04D0FCA82D25A4BA4F1BAAE78BA5")
    @DSModeled(DSC.SAFE)
    final void get(short[] dst, int dstOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.735 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "15C4EEF73F4ACDE62C53073E4E4D380D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        byte varBD0DA4AA3A28468377552D0F8F24449E_608930549 = (this.block.peekByte(offset + position++));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return this.block.peekByte(offset + position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.737 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "4E2C5CCBB069B39E80385EB56E31F798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final byte get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        byte varF2A0CE0AFDDEA9BD548A776384C41D19_359298898 = (this.block.peekByte(offset + index));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return this.block.peekByte(offset + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.741 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "FD95F298AEE6F1CB1FD9E70FEB5F7B3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.743 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "EE3CE2B0AAEF3206DA4EF739F43C5D7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char getChar(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char var06E809BAEE93D026FE8AE452D8BBC7FD_389318545 = ((char) this.block.peekShort(offset + index, order));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.746 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "78A04D2238733F02243E320204278D50")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.747 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "227F13122568525FD32853D24572BCFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.DOUBLE);
        double varA193CCB389182973619685E8625E9532_1782254237 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.749 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "C7A95FCADE8741421F218CDD56C9E7F9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.751 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "3125186A58177CE308565949029143DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.FLOAT);
        float var921F88C60A23C24861AED0C843EBCE9B_430422994 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.753 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "1C604AF40E48F027A9AE5EF557A498E5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.755 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "205B0FEBDD7925B8A1B7A053E8933C5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getInt(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.INT);
        int var137D03B6941BC5C1DF7D41533C3E9389_1096009185 = (this.block.peekInt(offset + index, order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return this.block.peekInt(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.758 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "8CBB80C5EEA9CFCFB529E024549C356A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.760 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "8E7E8878B27D0F1419C2919519345699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final long getLong(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long var5FE9D69D7973A2654B8886176AFE3E9E_1260135625 = (this.block.peekLong(offset + index, order));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return this.block.peekLong(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.762 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "22D7167C231FF6F4E9E4B2B592219EC7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.764 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "42BAEDAA4440ECAF0E8F5C4D2F359906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final short getShort(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var5E9FC208EB19DA73A7901D40B9D92C21_755707555 = (this.block.peekShort(offset + index, order));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.765 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "CFAE09D5467CC5F7FBB31F3041AA3EFF")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.766 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "5EE8575434433D93E37270A15B80FA73")
    @DSModeled(DSC.SAFE)
    public final void free() {
        block.free();
        // ---------- Original Method ----------
        //block.free();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.767 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "BB51DB6D47CB48FF7FE853BEF7E9E89C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.769 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "BF017B9C472E9E133B4D8177770B67E6")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //protectedArray();
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.770 -0400", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "2090E3517CD9EAB14B1788C0B2956DA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean protectedHasArray() {
        boolean var018F21DBC5772CA6D61006F1D966A453_1126515161 = (protectedArray() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedArray() != null;
    }

    
}


