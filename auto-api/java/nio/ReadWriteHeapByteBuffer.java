package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.Memory;
import libcore.io.SizeOf;

final class ReadWriteHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.941 -0400", hash_original_method = "698A4093B5D08261CD10BBA0DD254D03", hash_generated_method = "F8AB5A89BDB057607341264680670F3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteHeapByteBuffer(byte[] backingArray) {
        super(backingArray);
        dsTaint.addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.941 -0400", hash_original_method = "39FF2878164033A82C16A4024A20F407", hash_generated_method = "98AF8F39ABEA467C19B1074F73958F04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteHeapByteBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.942 -0400", hash_original_method = "705DEFE9EE10EC6D3F5F785589C89AC0", hash_generated_method = "59DF09FAD9C4B832E501E81A28F77C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.942 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "57927B9BCDB02D9F7A4EE5BBBD755D3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer var836CC2C6F807A1CF0BF7584D216D298F_620831513 = (ReadOnlyHeapByteBuffer.copy(this, mark));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.943 -0400", hash_original_method = "E8B47769CA0E36E125D00B7BF0C31D0B", hash_generated_method = "20F93A93AA8FD5A45862DEEC763DF950")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.943 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "785FDDCEAD770B96F443BE6EFE67C2BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer var8C82ED9E4FDE12C9486E1252174918B6_840012906 = (copy(this, mark));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.943 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.943 -0400", hash_original_method = "DFA49F6DA30AF833A3263BE3EE9CD5BB", hash_generated_method = "AF78072CE94015B9E79972585A376514")
    @DSModeled(DSC.SAFE)
    @Override
    protected byte[] protectedArray() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.943 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B6AF1441163DC81E5A7523DBEAED19DC")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.943 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F14C0EBC785314AEABBE7CBCFAB3FB1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.943 -0400", hash_original_method = "72E0A22D7133932D83149D22C98F13AD", hash_generated_method = "F51A7A6E26D070D8A93D0310538C6B38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte b) {
        dsTaint.addTaint(b);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = b;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.944 -0400", hash_original_method = "78F8125A8164FE61A30FAF2DC4593DB0", hash_generated_method = "D7E0A844F5EAF61EE2FBDAD13E35C735")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(int index, byte b) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(b);
        checkIndex(index);
        backingArray[offset + index] = b;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = b;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.944 -0400", hash_original_method = "B19EE749C09ADF1A37CE1094243997D4", hash_generated_method = "66E4C5822F2B6795731D99CCD60DBE81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        checkPutBounds(1, src.length, srcOffset, byteCount);
        System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        position += byteCount;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkPutBounds(1, src.length, srcOffset, byteCount);
        //System.arraycopy(src, srcOffset, backingArray, offset + position, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.944 -0400", hash_original_method = "45B8F2F72971D070F593434F2D8E9160", hash_generated_method = "971E5DA062DEAFE7C5961C686FE4DCE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(charCount);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.CHAR, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.944 -0400", hash_original_method = "9ABCB25C494E5D0A0EE76A30D8E8B283", hash_generated_method = "D50F089EBCE6E896F95B5CDCD4391C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(double[] src, int srcOffset, int doubleCount) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.DOUBLE, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.944 -0400", hash_original_method = "0A59724EAC29A22512857FADB561826F", hash_generated_method = "A8C508E0388583AC3644475B65FD1D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(float[] src, int srcOffset, int floatCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(floatCount);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.FLOAT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.945 -0400", hash_original_method = "5866478CCFA9AC7EB5AD084734CBE2FD", hash_generated_method = "C283EE322F47D8F406F79346A9120CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(int[] src, int srcOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.945 -0400", hash_original_method = "4DE3C17BC2F6A0E6284BCBDEFF4353E5", hash_generated_method = "430AE1FE9A293FDEF657D53528F2DAFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(long[] src, int srcOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.LONG, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.945 -0400", hash_original_method = "77593A6CF9C8DAF6764F897CF6EC2842", hash_generated_method = "E0C07A64EBFB8CB48F65DDF3E207DDBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void put(short[] src, int srcOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        int byteCount;
        byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        //Memory.unsafeBulkPut(backingArray, offset + position, byteCount, src, srcOffset, SizeOf.SHORT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.945 -0400", hash_original_method = "82EE1C0866E5BEF2C6330A6E38277E0B", hash_generated_method = "EAD4EA89C01E5BC285612E7589E40B72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(int index, char value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.CHAR);
        Memory.pokeShort(backingArray, offset + index, (short) value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //Memory.pokeShort(backingArray, offset + index, (short) value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.945 -0400", hash_original_method = "15F32C27634A3E86C7051E2D179448EE", hash_generated_method = "D1E169A774E09F9CBE2B46E816348F00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(char value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.CHAR;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeShort(backingArray, offset + position, (short) value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, (short) value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.946 -0400", hash_original_method = "D3D66F8ECD97953078E15D88E3210D7C", hash_generated_method = "9523EC6555B8D8CA11A3F9C8E8721781")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(double value) {
        dsTaint.addTaint(value);
        ByteBuffer varFC9459A85CD9CCCDAAE5F4F473421980_82557904 = (putLong(Double.doubleToRawLongBits(value)));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putLong(Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.946 -0400", hash_original_method = "FE6D03BC4C20DB28CF1BCC78BA5DBE78", hash_generated_method = "716C386AED9E0C65AA2A4A8F252D8364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        ByteBuffer var60A167B27069E692A07892C7B1879E95_1769868426 = (putLong(index, Double.doubleToRawLongBits(value)));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putLong(index, Double.doubleToRawLongBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.946 -0400", hash_original_method = "E45ECD1B48C76B33C550D1D3ABE8CF24", hash_generated_method = "720ECE99D782CCC8828CC245805C8EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(float value) {
        dsTaint.addTaint(value);
        ByteBuffer var2CC7AF8680CE8F521CE5FA0FB2DFD0DC_610083642 = (putInt(Float.floatToRawIntBits(value)));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putInt(Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.946 -0400", hash_original_method = "9AFB8F5FE765C8CDC0ED3C930ED840C0", hash_generated_method = "5B7F46662C6551953051E0114C0E3660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(int index, float value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        ByteBuffer var418DEFF231C1F7E8E00F2C9D4CD5E444_389456782 = (putInt(index, Float.floatToRawIntBits(value)));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putInt(index, Float.floatToRawIntBits(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.946 -0400", hash_original_method = "5F1F62F303EDB135D2A78931AEAB6972", hash_generated_method = "A43B3026BB620D596CE2F59B4879B9CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.INT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeInt(backingArray, offset + position, value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeInt(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.946 -0400", hash_original_method = "D1A78DDD0C9ED6E4483E1AE7C4872A32", hash_generated_method = "5634DBC4B30D739F07FC74DC3A3C1E55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int index, int value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.INT);
        Memory.pokeInt(backingArray, offset + index, value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //Memory.pokeInt(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.947 -0400", hash_original_method = "1EDA1D6C4FBFEC9DA3CAFFF9583F4A7A", hash_generated_method = "C11A14B863E7163CE70733EB44EE09EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.LONG);
        Memory.pokeLong(backingArray, offset + index, value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //Memory.pokeLong(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.947 -0400", hash_original_method = "9648BBCB2FCB23C0FEFFC646460FB4AC", hash_generated_method = "A719CF541512BB0A1908C645090961E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(long value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.LONG;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeLong(backingArray, offset + position, value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeLong(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.947 -0400", hash_original_method = "8DD945BCFB457C15F47AA89E5C45F024", hash_generated_method = "5E1A6E3A3C7E22414F760F4CD7B69D48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(int index, short value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        checkIndex(index, SizeOf.SHORT);
        Memory.pokeShort(backingArray, offset + index, value, order);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //Memory.pokeShort(backingArray, offset + index, value, order);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.947 -0400", hash_original_method = "D29A208D139CC962C11C8258F595C612", hash_generated_method = "D1829347FB29D2AABD5F8FFB1498557C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(short value) {
        dsTaint.addTaint(value);
        int newPosition;
        newPosition = position + SizeOf.SHORT;
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        Memory.pokeShort(backingArray, offset + position, value, order);
        position = newPosition;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferOverflowException();
        //}
        //Memory.pokeShort(backingArray, offset + position, value, order);
        //position = newPosition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.947 -0400", hash_original_method = "510A931F94808139B1B1492FD0FC70A6", hash_generated_method = "6DBB80F8D77E06D6FE905F446A08DD1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer slice() {
        ByteBuffer var7D1F14359DE5BB012B27153F0A371612_1500452057 = (new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

