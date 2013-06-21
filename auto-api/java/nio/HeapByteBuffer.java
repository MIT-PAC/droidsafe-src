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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.739 -0400", hash_original_method = "E17EA7652E4F5A67C65770DE13DD4AE3", hash_generated_method = "9FC72BC0DD11A2F06FFC9D443D9BD952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HeapByteBuffer(byte[] backingArray) {
        this(backingArray, backingArray.length, 0);
        dsTaint.addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.739 -0400", hash_original_method = "720B251A66EBAD61E39D94F5757C7908", hash_generated_method = "DF8211B0B6C0CB72AF7B5E919D2A8B4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HeapByteBuffer(int capacity) {
        this(new byte[capacity], capacity, 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.740 -0400", hash_original_method = "7E0C48043B88A8991A81994678604015", hash_generated_method = "48D009DA6F2B8096D196333EF6DC0A07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HeapByteBuffer(byte[] backingArray, int capacity, int offset) {
        super(capacity, null);
        dsTaint.addTaint(backingArray[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.740 -0400", hash_original_method = "A92B26D30665425608E93AFD3985B529", hash_generated_method = "7BE14EFA4F5B53D6712BA9139D936581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.740 -0400", hash_original_method = "ADCC30D9FE17E9265DD10F45753F8D68", hash_generated_method = "763D20C8704C889D9DDF70022C376F5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.740 -0400", hash_original_method = "83F82E1C4D1B0FECE4775D0F7331C2A9", hash_generated_method = "4757C1697155D9448B6542989D9D7053")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(double[] dst, int dstOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.740 -0400", hash_original_method = "28783106EE8F5B0602DB80B1FE3018CE", hash_generated_method = "D119B0813DC5D7FC5D7D121F8E9741F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(float[] dst, int dstOffset, int floatCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.741 -0400", hash_original_method = "8AC7AD179B2BD3799E5966071FB1A6E9", hash_generated_method = "DF26374CE2339A891543B1983B5E9D24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.741 -0400", hash_original_method = "3C880FD9EFF1926FF9582E7F1291E034", hash_generated_method = "48B7B21DD80BF54B6F3B9C1FA657A603")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(long[] dst, int dstOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.741 -0400", hash_original_method = "89F4F4A0F85F41D910E8D20C3ACD7123", hash_generated_method = "65B6F85F64E64B9D3FE90178572C0CB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void get(short[] dst, int dstOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        int byteCount;
        byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.741 -0400", hash_original_method = "CB9AAD8BA04B2044061C99EDA53631A5", hash_generated_method = "5B7A36D25C9D630866F4A05637B262D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.741 -0400", hash_original_method = "9AAE834531B3F44ED7B8F1D4ABA54327", hash_generated_method = "CADDB4F02225350F8AF866710702D553")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final byte get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.742 -0400", hash_original_method = "A30CF2DCEAEB1ADBE9659D1E77D9D3A8", hash_generated_method = "3BEDDDA2D1B4866313232756726A33B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.742 -0400", hash_original_method = "9FC96B9C645980EC4C42FC8A098BD17B", hash_generated_method = "9C90AEA10D20974EEA06C962FAE592A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char getChar(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char var44B2D896472A7BC850649A142494D4A7_232190060 = ((char) Memory.peekShort(backingArray, offset + index, order));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.742 -0400", hash_original_method = "15CD222F9D1D43117CE6FF35DE1821E1", hash_generated_method = "6F7FD21528FE33613C73C9C342C91B63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble() {
        double varB9071C4F97A9550F857A40DA064024FB_2082848488 = (Double.longBitsToDouble(getLong()));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.742 -0400", hash_original_method = "2A94C74E4D47B2870E4CD8E58AB3C61D", hash_generated_method = "7C32B8F4E8DBD2F10F6468FA1C8802D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final double getDouble(int index) {
        dsTaint.addTaint(index);
        double var9F522FDD8FB2086A480FD3F6145C1CC7_241457268 = (Double.longBitsToDouble(getLong(index)));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.742 -0400", hash_original_method = "47893679DF29F9C7305C0FEFB94D5263", hash_generated_method = "85CF4A10DF03B65A010BD1BA88DE4321")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat() {
        float varB77056307B6A57ADBF03074310271972_1344538315 = (Float.intBitsToFloat(getInt()));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.742 -0400", hash_original_method = "416C4BCEE10AD6D26C3C84E2597AE8E2", hash_generated_method = "EFCD8B7DA18B83B6A94BFDCB2BE2D6D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final float getFloat(int index) {
        dsTaint.addTaint(index);
        float varA8B5FEE8BE655D5CAA8E3C9A92B8AA36_1517743155 = (Float.intBitsToFloat(getInt(index)));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.743 -0400", hash_original_method = "915288BFB7584CF14BE85156D3784045", hash_generated_method = "A0D1B73969B907361A90707DC99AABEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.743 -0400", hash_original_method = "458AAE21B6E3B170135E629CE400B5BC", hash_generated_method = "31DA796630BE23CBD11D27B37A1172D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getInt(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.INT);
        int varDE558B6E48E3F147349E9E1C74D10296_615160593 = (Memory.peekInt(backingArray, offset + index, order));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return Memory.peekInt(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.743 -0400", hash_original_method = "8649950490E02A38495D16EDE99C5440", hash_generated_method = "10F693997F4E8EA1FF254F42CC252DCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.743 -0400", hash_original_method = "DA73492717D47126159C560DCCEA76B8", hash_generated_method = "8B085ACCD334ABFEDB0ACAB3DDC7EE0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final long getLong(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long varF10F7DFA0512D91505296DEEA7FDB36E_1040163475 = (Memory.peekLong(backingArray, offset + index, order));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return Memory.peekLong(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.743 -0400", hash_original_method = "D81DB9BF3EF98746269534EE74DB9F13", hash_generated_method = "28B933F830797CD4A5AAE967A9D9012E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.744 -0400", hash_original_method = "1734D425058DF9CB5EF1DD869B4BCEDF", hash_generated_method = "92DEDFDB4E09E76B1D624B32540C4019")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final short getShort(int index) {
        dsTaint.addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var3F6DA237402FA6C9FD635374C5CE6DE1_1732352429 = (Memory.peekShort(backingArray, offset + index, order));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.744 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7E7C9B3B0EC5D6CFC1C636F6242D264A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}

