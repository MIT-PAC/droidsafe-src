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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.580 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "09D04850ECF89DF686CB8B497D53F4F4")

    byte[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.580 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.580 -0400", hash_original_method = "E17EA7652E4F5A67C65770DE13DD4AE3", hash_generated_method = "4FA8540A9DD1600A999EF445349CC6BD")
      HeapByteBuffer(byte[] backingArray) {
        this(backingArray, backingArray.length, 0);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.580 -0400", hash_original_method = "720B251A66EBAD61E39D94F5757C7908", hash_generated_method = "64F667538DCF04571002FE958EFD5EA7")
      HeapByteBuffer(int capacity) {
        this(new byte[capacity], capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.582 -0400", hash_original_method = "7E0C48043B88A8991A81994678604015", hash_generated_method = "5F8B3E7D3A8FDB1725AD4DDBD1FFC027")
      HeapByteBuffer(byte[] backingArray, int capacity, int offset) {
        super(capacity, null);
        this.backingArray = backingArray;
        this.offset = offset;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    ", capacity=" + capacity + ", offset=" + offset);
        } //End block
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
        //if (offset + capacity > backingArray.length) {
            //throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    //", capacity=" + capacity + ", offset=" + offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.582 -0400", hash_original_method = "A92B26D30665425608E93AFD3985B529", hash_generated_method = "8F752287EF26A732F6B0F96EDCF53F34")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_906625425 = null; //Variable for return #1
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_906625425 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_906625425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_906625425;
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.584 -0400", hash_original_method = "ADCC30D9FE17E9265DD10F45753F8D68", hash_generated_method = "BA4486E2E47C7CAFED64B9A585435D0B")
    final void get(char[] dst, int dstOffset, int charCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.CHAR, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.595 -0400", hash_original_method = "83F82E1C4D1B0FECE4775D0F7331C2A9", hash_generated_method = "17A1F747C84758B037981DB78B8A3BF4")
    final void get(double[] dst, int dstOffset, int doubleCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.595 -0400", hash_original_method = "28783106EE8F5B0602DB80B1FE3018CE", hash_generated_method = "5B8EEF9E692AC9B53BCDB9E3566F211B")
    final void get(float[] dst, int dstOffset, int floatCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.FLOAT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.595 -0400", hash_original_method = "8AC7AD179B2BD3799E5966071FB1A6E9", hash_generated_method = "003D64FF271EBA16E7D41A561AA170A8")
    final void get(int[] dst, int dstOffset, int intCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.596 -0400", hash_original_method = "3C880FD9EFF1926FF9582E7F1291E034", hash_generated_method = "E079D01DE7595F663E0AE4306C4C00BA")
    final void get(long[] dst, int dstOffset, int longCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.596 -0400", hash_original_method = "89F4F4A0F85F41D910E8D20C3ACD7123", hash_generated_method = "C5909FD61DFAD18C0313B9477EF5D0A2")
    final void get(short[] dst, int dstOffset, int shortCount) {
        int byteCount;
        byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.596 -0400", hash_original_method = "CB9AAD8BA04B2044061C99EDA53631A5", hash_generated_method = "8FD8E83FED16BB5EE5823486055CDDCE")
    @Override
    public final byte get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1211385495 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1211385495;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.610 -0400", hash_original_method = "9AAE834531B3F44ED7B8F1D4ABA54327", hash_generated_method = "57417FD35CFBED76C9CBB22A231E75F5")
    @Override
    public final byte get(int index) {
        checkIndex(index);
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_2007556077 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2007556077;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.610 -0400", hash_original_method = "A30CF2DCEAEB1ADBE9659D1E77D9D3A8", hash_generated_method = "FD18550FE46E04286ADE1BA93A7E141D")
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
        char varA87DEB01C5F539E6BDA34829C8EF2368_550262012 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_550262012;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.611 -0400", hash_original_method = "9FC96B9C645980EC4C42FC8A098BD17B", hash_generated_method = "4CC9E9075D10B96B1634D6137B035A5C")
    @Override
    public final char getChar(int index) {
        checkIndex(index, SizeOf.CHAR);
        char var44B2D896472A7BC850649A142494D4A7_999462223 = ((char) Memory.peekShort(backingArray, offset + index, order));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_748609428 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_748609428;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.612 -0400", hash_original_method = "15CD222F9D1D43117CE6FF35DE1821E1", hash_generated_method = "47E38472720915618C0DB0E4B5232608")
    @Override
    public final double getDouble() {
        double varB9071C4F97A9550F857A40DA064024FB_332523395 = (Double.longBitsToDouble(getLong()));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1496242527 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1496242527;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.612 -0400", hash_original_method = "2A94C74E4D47B2870E4CD8E58AB3C61D", hash_generated_method = "505D63CC5B46ACEF8FA747AA38BE37DC")
    @Override
    public final double getDouble(int index) {
        double var9F522FDD8FB2086A480FD3F6145C1CC7_623121135 = (Double.longBitsToDouble(getLong(index)));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1340079977 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1340079977;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.612 -0400", hash_original_method = "47893679DF29F9C7305C0FEFB94D5263", hash_generated_method = "3F15C972022C814075C9099DCE504A41")
    @Override
    public final float getFloat() {
        float varB77056307B6A57ADBF03074310271972_1533404361 = (Float.intBitsToFloat(getInt()));
        float var546ADE640B6EDFBC8A086EF31347E768_1959473167 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1959473167;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.613 -0400", hash_original_method = "416C4BCEE10AD6D26C3C84E2597AE8E2", hash_generated_method = "B66C52D965F7EE28909101205803FA92")
    @Override
    public final float getFloat(int index) {
        float varA8B5FEE8BE655D5CAA8E3C9A92B8AA36_497367782 = (Float.intBitsToFloat(getInt(index)));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_874922821 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_874922821;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.613 -0400", hash_original_method = "915288BFB7584CF14BE85156D3784045", hash_generated_method = "5394A0FBEE2BAB3F11D67F8C884D8F1C")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831857359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831857359;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = Memory.peekInt(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.613 -0400", hash_original_method = "458AAE21B6E3B170135E629CE400B5BC", hash_generated_method = "47816D61C32886263EE6C4618E3C0949")
    @Override
    public final int getInt(int index) {
        checkIndex(index, SizeOf.INT);
        int varDE558B6E48E3F147349E9E1C74D10296_193878582 = (Memory.peekInt(backingArray, offset + index, order));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574366410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574366410;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return Memory.peekInt(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.616 -0400", hash_original_method = "8649950490E02A38495D16EDE99C5440", hash_generated_method = "F9EE53DC6D57851F54FB359E1C62A493")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1870940890 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1870940890;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = Memory.peekLong(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.617 -0400", hash_original_method = "DA73492717D47126159C560DCCEA76B8", hash_generated_method = "DA27EEA98D40872A6DC2DD7D950BC9EC")
    @Override
    public final long getLong(int index) {
        checkIndex(index, SizeOf.LONG);
        long varF10F7DFA0512D91505296DEEA7FDB36E_877103582 = (Memory.peekLong(backingArray, offset + index, order));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1377194543 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1377194543;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return Memory.peekLong(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.629 -0400", hash_original_method = "D81DB9BF3EF98746269534EE74DB9F13", hash_generated_method = "4ADCD55E960AA3619C4BD2EA54BB0134")
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
        short var4F09DAA9D95BCB166A302407A0E0BABE_1919044170 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1919044170;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.629 -0400", hash_original_method = "1734D425058DF9CB5EF1DD869B4BCEDF", hash_generated_method = "2475B9E4EBB907A2A657D57F37B8661A")
    @Override
    public final short getShort(int index) {
        checkIndex(index, SizeOf.SHORT);
        short var3F6DA237402FA6C9FD635374C5CE6DE1_1887791574 = (Memory.peekShort(backingArray, offset + index, order));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1103349456 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1103349456;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.629 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "9F069B6452489BA6C67FCEC48FC77357")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151775551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151775551;
        // ---------- Original Method ----------
        //return false;
    }

    
}

