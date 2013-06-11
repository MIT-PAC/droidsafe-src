package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
    protected final int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.294 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "A2BDB2F7E42B86F013CE79A982797AEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        long baseSize;
        baseSize = block.getSize();
        {
            throw new IllegalArgumentException("capacity + offset > baseSize");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.297 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "B2B7C67A2FB4051E8A81C3A52704C04B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.299 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "2359CAD9FFED98CE838A7ABB351F0F3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.302 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "C3DB2F69307B3C5AE5D4E99236C15AB0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.311 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "745B1E76CAE23914482D721093089BE3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.313 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "73B52F34672DAC5E2DCF7CF52A39D597")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.315 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "CA82BF41E55ECF800A492917538BF68C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.317 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "082C04D0FCA82D25A4BA4F1BAAE78BA5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.319 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "AE4D374F4FB154E36FA664AAB8202F58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final byte get() {
        {
            throw new BufferUnderflowException();
        } //End block
        byte varBD0DA4AA3A28468377552D0F8F24449E_895401211 = (this.block.peekByte(offset + position++));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return this.block.peekByte(offset + position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.321 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "25AF2C8DCEA4C107AE39E3213A4BDA1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final byte get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        byte varF2A0CE0AFDDEA9BD548A776384C41D19_193607649 = (this.block.peekByte(offset + index));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return this.block.peekByte(offset + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.323 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "A6C0689CF2FC474B95F9D41E9C57EF85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char getChar() {
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.328 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "CBA9BA3C14DD0D88A8C5442CB3635EFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char getChar(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char var06E809BAEE93D026FE8AE452D8BBC7FD_1203921303 = ((char) this.block.peekShort(offset + index, order));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.330 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "AAEF3F1F5D2D1D2844075AC88B02808E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble() {
        int newPosition;
        newPosition = position + SizeOf.DOUBLE;
        {
            throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.332 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "F2544E4236B5C38B735E28BA95BD016F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.DOUBLE);
        double varA193CCB389182973619685E8625E9532_1875709224 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.335 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "7B4EC37F59522DEC6451EE2A17519EA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat() {
        int newPosition;
        newPosition = position + SizeOf.FLOAT;
        {
            throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.337 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "03FC26D17BF81AA547DFE01DC874CEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.FLOAT);
        float var921F88C60A23C24861AED0C843EBCE9B_1136247763 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.342 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "40F62ABB3B9C07D6A7523DE88E4F03A4")
    @DSModeled(DSC.SAFE)
    @Override
    public final int getInt() {
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.346 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "3FADDF03188C627D36756F2876A3AE15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getInt(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.INT);
        int var137D03B6941BC5C1DF7D41533C3E9389_821152336 = (this.block.peekInt(offset + index, order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return this.block.peekInt(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.350 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "09386E1503E5A40AE49BDEB9CEDDF3D5")
    @DSModeled(DSC.SAFE)
    @Override
    public final long getLong() {
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.353 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "557FC369BAB268DFF19DFD51E5D4D793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final long getLong(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long var5FE9D69D7973A2654B8886176AFE3E9E_1591723453 = (this.block.peekLong(offset + index, order));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return this.block.peekLong(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.355 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "92A007B66246145C42704E4C29986678")
    @DSModeled(DSC.SAFE)
    @Override
    public final short getShort() {
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.357 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "F8F697643C0A21F399FB455FE7801EC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final short getShort(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var5E9FC208EB19DA73A7901D40B9D92C21_2004976775 = (this.block.peekShort(offset + index, order));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.358 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "CFAE09D5467CC5F7FBB31F3041AA3EFF")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.359 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "5EE8575434433D93E37270A15B80FA73")
    @DSModeled(DSC.SAFE)
    public final void free() {
        block.free();
        // ---------- Original Method ----------
        //block.free();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.361 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "1A00B666D3FEC4BD3F823A635A8A1955")
    @DSModeled(DSC.SAFE)
    @Override
    protected byte[] protectedArray() {
        byte[] array;
        array = this.block.array();
        {
            throw new UnsupportedOperationException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.362 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "BF017B9C472E9E133B4D8177770B67E6")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //protectedArray();
        //return offset;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:32:19.393 -0400",hash_original_method="F879D2589AC497F37E3C882F528D27BC",hash_generated_method="174FCDDE7B38370F513704BD5FE1739F")
@Override
    protected boolean protectedHasArray() {
        boolean var018F21DBC5772CA6D61006F1D966A453_1807287783 = (protectedArray() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedArray() != null;
    }

    
}


