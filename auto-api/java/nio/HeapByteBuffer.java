package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;
import libcore.io.Memory;

abstract class HeapByteBuffer extends BaseByteBuffer {
    byte[] backingArray;
    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.927 -0400", hash_original_method = "E17EA7652E4F5A67C65770DE13DD4AE3", hash_generated_method = "EA4F87507D3BAC0C4C543FB1AF95A227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HeapByteBuffer(byte[] backingArray) {
        this(backingArray, backingArray.length, 0);
        dsTaint.addTaint(backingArray);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.929 -0400", hash_original_method = "720B251A66EBAD61E39D94F5757C7908", hash_generated_method = "C81E57AC8CEB08963DAF333E3DC8A2FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HeapByteBuffer(int capacity) {
        this(new byte[capacity], capacity, 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.931 -0400", hash_original_method = "7E0C48043B88A8991A81994678604015", hash_generated_method = "D441AB7F8D24F12B617ABF44100DF82D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HeapByteBuffer(byte[] backingArray, int capacity, int offset) {
        super(capacity, null);
        dsTaint.addTaint(backingArray);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    ", capacity=" + capacity + ", offset=" + offset);
        } //End block
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
        //if (offset + capacity > backingArray.length) {
            //throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    //", capacity=" + capacity + ", offset=" + offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.937 -0400", hash_original_method = "A92B26D30665425608E93AFD3985B529", hash_generated_method = "1E042492B82BF11B316FC4C7F297030B")
    @DSModeled(DSC.SAFE)
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.945 -0400", hash_original_method = "ADCC30D9FE17E9265DD10F45753F8D68", hash_generated_method = "EFCFB1B939E98F2E555E6A646B110AB7")
    @DSModeled(DSC.SAFE)
    final void get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(charCount);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.CHAR, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.948 -0400", hash_original_method = "83F82E1C4D1B0FECE4775D0F7331C2A9", hash_generated_method = "EADF3322F4A869C89BAA97519EF3570A")
    @DSModeled(DSC.SAFE)
    final void get(double[] dst, int dstOffset, int doubleCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.950 -0400", hash_original_method = "28783106EE8F5B0602DB80B1FE3018CE", hash_generated_method = "BD88AA61E43CE460AEC7DB512EA0942A")
    @DSModeled(DSC.SAFE)
    final void get(float[] dst, int dstOffset, int floatCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(floatCount);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.FLOAT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.957 -0400", hash_original_method = "8AC7AD179B2BD3799E5966071FB1A6E9", hash_generated_method = "168B57D93B7641DE61576F2359FE52C8")
    @DSModeled(DSC.SAFE)
    final void get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.959 -0400", hash_original_method = "3C880FD9EFF1926FF9582E7F1291E034", hash_generated_method = "49FAC589370B3BD6B348DE6B5499883D")
    @DSModeled(DSC.SAFE)
    final void get(long[] dst, int dstOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.964 -0400", hash_original_method = "89F4F4A0F85F41D910E8D20C3ACD7123", hash_generated_method = "FDB35B02107255D200C73ADAAA331286")
    @DSModeled(DSC.SAFE)
    final void get(short[] dst, int dstOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.967 -0400", hash_original_method = "CB9AAD8BA04B2044061C99EDA53631A5", hash_generated_method = "A045D89EE8C755A4720F93FBACB91F24")
    @DSModeled(DSC.SAFE)
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.973 -0400", hash_original_method = "9AAE834531B3F44ED7B8F1D4ABA54327", hash_generated_method = "A074F29C16C89456E022174ACA8DDB1E")
    @DSModeled(DSC.SAFE)
    @Override
    public final byte get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.975 -0400", hash_original_method = "A30CF2DCEAEB1ADBE9659D1E77D9D3A8", hash_generated_method = "0FB04BB899BCB9BF7D270ACCEE21858C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char getChar() {
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char result;
        result = (char) Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.976 -0400", hash_original_method = "9FC96B9C645980EC4C42FC8A098BD17B", hash_generated_method = "E8B7417685F1E0422CF2198736EA1813")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char getChar(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char var44B2D896472A7BC850649A142494D4A7_923870391 = ((char) Memory.peekShort(backingArray, offset + index, order));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.979 -0400", hash_original_method = "15CD222F9D1D43117CE6FF35DE1821E1", hash_generated_method = "226618023022BA17A64CBC559EF3316B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble() {
        double varB9071C4F97A9550F857A40DA064024FB_1574677788 = (Double.longBitsToDouble(getLong()));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.980 -0400", hash_original_method = "2A94C74E4D47B2870E4CD8E58AB3C61D", hash_generated_method = "F55AB9D9DFB0E15F24118659C13B2F6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble(int index) {
        dsTaint.addTaint(index);
        double var9F522FDD8FB2086A480FD3F6145C1CC7_613154260 = (Double.longBitsToDouble(getLong(index)));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.982 -0400", hash_original_method = "47893679DF29F9C7305C0FEFB94D5263", hash_generated_method = "40C70777F7B9D7614F8F53BBDF5D193B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat() {
        float varB77056307B6A57ADBF03074310271972_701083210 = (Float.intBitsToFloat(getInt()));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.984 -0400", hash_original_method = "416C4BCEE10AD6D26C3C84E2597AE8E2", hash_generated_method = "C94F40C10EA1CF04ABB343D3DB6094A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat(int index) {
        dsTaint.addTaint(index);
        float varA8B5FEE8BE655D5CAA8E3C9A92B8AA36_149107175 = (Float.intBitsToFloat(getInt(index)));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.987 -0400", hash_original_method = "915288BFB7584CF14BE85156D3784045", hash_generated_method = "C428A44AC46261D1FC4A8A80522C123B")
    @DSModeled(DSC.SAFE)
    @Override
    public final int getInt() {
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int result;
        result = Memory.peekInt(backingArray, offset + position, order);
        position = newPosition;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = Memory.peekInt(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.990 -0400", hash_original_method = "458AAE21B6E3B170135E629CE400B5BC", hash_generated_method = "6F6F63A4A2AA5B9E72A18496B996DBC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getInt(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.INT);
        int varDE558B6E48E3F147349E9E1C74D10296_1462940094 = (Memory.peekInt(backingArray, offset + index, order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return Memory.peekInt(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.992 -0400", hash_original_method = "8649950490E02A38495D16EDE99C5440", hash_generated_method = "E05A239C714277BD077DA184A7C1E005")
    @DSModeled(DSC.SAFE)
    @Override
    public final long getLong() {
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        long result;
        result = Memory.peekLong(backingArray, offset + position, order);
        position = newPosition;
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = Memory.peekLong(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.994 -0400", hash_original_method = "DA73492717D47126159C560DCCEA76B8", hash_generated_method = "10023680956FB4827C277CE0308075CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final long getLong(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long varF10F7DFA0512D91505296DEEA7FDB36E_656529010 = (Memory.peekLong(backingArray, offset + index, order));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return Memory.peekLong(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.996 -0400", hash_original_method = "D81DB9BF3EF98746269534EE74DB9F13", hash_generated_method = "44555A367D51817BFA26B5359858F38F")
    @DSModeled(DSC.SAFE)
    @Override
    public final short getShort() {
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        short result;
        result = Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.999 -0400", hash_original_method = "1734D425058DF9CB5EF1DD869B4BCEDF", hash_generated_method = "893FDB91D966707BC8FCBECD384C90D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final short getShort(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var3F6DA237402FA6C9FD635374C5CE6DE1_1306853048 = (Memory.peekShort(backingArray, offset + index, order));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.000 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "4E653F534A1A7B4B11306437DD6A5129")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}


