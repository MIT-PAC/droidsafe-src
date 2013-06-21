package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import libcore.io.Memory;

public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {
    ByteOrder order = ByteOrder.BIG_ENDIAN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.480 -0400", hash_original_method = "8BF63B2B8E79FA88256074D41FD2061C", hash_generated_method = "8298BC765FF5F95EEAF5C94DA3C38A18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ByteBuffer(int capacity, MemoryBlock block) {
        super(0, capacity, block);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static ByteBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteHeapByteBuffer(capacity);
    }

    
        public static ByteBuffer allocateDirect(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDirectByteBuffer(capacity);
    }

    
        public static ByteBuffer wrap(byte[] array) {
        return new ReadWriteHeapByteBuffer(array);
    }

    
        public static ByteBuffer wrap(byte[] array, int start, int byteCount) {
        Arrays.checkOffsetAndCount(array.length, start, byteCount);
        ByteBuffer buf = new ReadWriteHeapByteBuffer(array);
        buf.position = start;
        buf.limit = start + byteCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.481 -0400", hash_original_method = "7344C3769A78C71213763E627C382A16", hash_generated_method = "9780B1A37EEBE2B5E1591D113072C098")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] array() {
        byte[] varEA57FBC16B997AC0E679F048893AC79C_918962553 = (protectedArray());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.481 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "7C31037E8263F77CB1907308D63A015B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_452967311 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract CharBuffer asCharBuffer();

    
    public abstract DoubleBuffer asDoubleBuffer();

    
    public abstract FloatBuffer asFloatBuffer();

    
    public abstract IntBuffer asIntBuffer();

    
    public abstract LongBuffer asLongBuffer();

    
    public abstract ByteBuffer asReadOnlyBuffer();

    
    public abstract ShortBuffer asShortBuffer();

    
    public abstract ByteBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.483 -0400", hash_original_method = "278C7A58B0643B88C9704D6A9846EFB3", hash_generated_method = "9EE2354B83F363E4835A349E0C75FB06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(ByteBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_602144581 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        byte thisByte, otherByte;
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_294471274 = (remaining() - otherBuffer.remaining());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //byte thisByte, otherByte;
        //while (compareRemaining > 0) {
            //thisByte = get(thisPos);
            //otherByte = otherBuffer.get(otherPos);
            //if (thisByte != otherByte) {
                //return thisByte < otherByte ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    public abstract ByteBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.483 -0400", hash_original_method = "D3C1AD6F8182660C2A5A272A59569D9E", hash_generated_method = "98B2886F00ED1B053E5CCBFD8A9EBF63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        ByteBuffer otherBuffer;
        otherBuffer = (ByteBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_721817200 = (remaining() != otherBuffer.remaining());
        } //End collapsed parenthetic
        int myPosition;
        myPosition = position;
        int otherPosition;
        otherPosition = otherBuffer.position;
        boolean equalSoFar;
        equalSoFar = true;
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(other instanceof ByteBuffer)) {
            //return false;
        //}
        //ByteBuffer otherBuffer = (ByteBuffer) other;
        //if (remaining() != otherBuffer.remaining()) {
            //return false;
        //}
        //int myPosition = position;
        //int otherPosition = otherBuffer.position;
        //boolean equalSoFar = true;
        //while (equalSoFar && (myPosition < limit)) {
            //equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        //}
        //return equalSoFar;
    }

    
    public abstract byte get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.483 -0400", hash_original_method = "9A475FF9B92E938C1B69F2A1BC2AE724", hash_generated_method = "333439F8B61B3626C09FB3BD2E737D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer get(byte[] dst) {
        dsTaint.addTaint(dst[0]);
        ByteBuffer var54C52896C1D21D17FF99C7DFE6939F7B_2052494956 = (get(dst, 0, dst.length));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.484 -0400", hash_original_method = "1D8E1FFC265A4E71218B8D81ECBD99D1", hash_generated_method = "1929F07E5B9AD3966407C5ED15CC665D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_2102548841 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = dstOffset;
            {
                dst[i] = get();
            } //End block
        } //End collapsed parenthetic
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
        //if (byteCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + byteCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract byte get(int index);

    
    public abstract char getChar();

    
    public abstract char getChar(int index);

    
    public abstract double getDouble();

    
    public abstract double getDouble(int index);

    
    public abstract float getFloat();

    
    public abstract float getFloat(int index);

    
    public abstract int getInt();

    
    public abstract int getInt(int index);

    
    public abstract long getLong();

    
    public abstract long getLong(int index);

    
    public abstract short getShort();

    
    public abstract short getShort(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.486 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "E67A0C0D7F98BE2E09546E59A49B02E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1052691408 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.486 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "48881135A5C55AA9F3B219BF71BEF483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.487 -0400", hash_original_method = "65B1A3EBEA253AF86057FAE15F6D4DB5", hash_generated_method = "4B38B5AF70B5E2A6D1FF8C73A1F4599D")
    @DSModeled(DSC.SAFE)
    public final ByteOrder order() {
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.487 -0400", hash_original_method = "56B1D3E8961AB315D57FF8A49B63D4AB", hash_generated_method = "7C3CB163E025FAACDE7273F3C920E3F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer order(ByteOrder byteOrder) {
        dsTaint.addTaint(byteOrder.dsTaint);
        orderImpl(byteOrder);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //orderImpl(byteOrder);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.487 -0400", hash_original_method = "00AA16AC102512E5E69E8EC846E58DBE", hash_generated_method = "FD91E007A90BEA8BF0D79C6C18696774")
    @DSModeled(DSC.SAFE)
     void orderImpl(ByteOrder byteOrder) {
        dsTaint.addTaint(byteOrder.dsTaint);
        {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } //End block
        // ---------- Original Method ----------
        //if (byteOrder == null) {
            //byteOrder = ByteOrder.LITTLE_ENDIAN;
        //}
        //order = byteOrder;
    }

    
    abstract byte[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract ByteBuffer put(byte b);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.488 -0400", hash_original_method = "D20A20C1C5EFB26E81C8757F39019CA4", hash_generated_method = "E42E653ACC5589173CBBDC52D8F9FD5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer put(byte[] src) {
        dsTaint.addTaint(src[0]);
        ByteBuffer var974D367CEDA780433BF9CC5389A430C6_655865029 = (put(src, 0, src.length));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.488 -0400", hash_original_method = "D0316A3A41AD4E9576A2DF2983507374", hash_generated_method = "92847AD114154519EEDA7152D9E6C608")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1424376523 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = srcOffset;
            {
                put(src[i]);
            } //End block
        } //End collapsed parenthetic
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
        //if (byteCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + byteCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.488 -0400", hash_original_method = "9C697C4B592697CC08FD298666C0BB54", hash_generated_method = "BFB28BDAAB01ABE2F434842F367B611A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer put(ByteBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_305786120 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("src == this");
            } //End block
        } //End collapsed parenthetic
        int srcByteCount;
        srcByteCount = src.remaining();
        {
            boolean varCE4A021E07A97089C6014AA3511B8F36_238550090 = (srcByteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        Object srcObject;
        boolean varD7E9FB3A2DECCDB62F76A615253FB1A1_622076583 = (src.isDirect());
        srcObject = src;
        srcObject = NioUtils.unsafeArray(src);
        int srcOffset;
        srcOffset = src.position();
        {
            boolean var1DFA7AB241497C396502EC557F1030A3_1315146078 = (!src.isDirect());
            {
                srcOffset += NioUtils.unsafeArrayOffset(src);
            } //End block
        } //End collapsed parenthetic
        ByteBuffer dst;
        dst = this;
        Object dstObject;
        boolean varFB248104C4AFD3B4F5EE7FB8E52A3F44_555054407 = (dst.isDirect());
        dstObject = dst;
        dstObject = NioUtils.unsafeArray(dst);
        int dstOffset;
        dstOffset = dst.position();
        {
            boolean var9F26322EFA2F4B8EF5FF17D9F6511613_278515240 = (!dst.isDirect());
            {
                dstOffset += NioUtils.unsafeArrayOffset(dst);
            } //End block
        } //End collapsed parenthetic
        Memory.memmove(dstObject, dstOffset, srcObject, srcOffset, srcByteCount);
        src.position(src.limit());
        dst.position(dst.position() + srcByteCount);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract ByteBuffer put(int index, byte b);

    
    public abstract ByteBuffer putChar(char value);

    
    public abstract ByteBuffer putChar(int index, char value);

    
    public abstract ByteBuffer putDouble(double value);

    
    public abstract ByteBuffer putDouble(int index, double value);

    
    public abstract ByteBuffer putFloat(float value);

    
    public abstract ByteBuffer putFloat(int index, float value);

    
    public abstract ByteBuffer putInt(int value);

    
    public abstract ByteBuffer putInt(int index, int value);

    
    public abstract ByteBuffer putLong(long value);

    
    public abstract ByteBuffer putLong(int index, long value);

    
    public abstract ByteBuffer putShort(short value);

    
    public abstract ByteBuffer putShort(int index, short value);

    
    public abstract ByteBuffer slice();

    
}

