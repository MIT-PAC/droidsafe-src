package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;
import libcore.io.Memory;

public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {
    ByteOrder order = ByteOrder.BIG_ENDIAN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.476 -0400", hash_original_method = "8BF63B2B8E79FA88256074D41FD2061C", hash_generated_method = "DB23DE7714A935F90D49634742B485C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ByteBuffer(int capacity, MemoryBlock block) {
        super(0, capacity, block);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(block.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.476 -0400", hash_original_method = "52AD6B6B7E23BF311D4F636879CBD6FE", hash_generated_method = "78087FDF303403A3D440EB1840BA83C4")
    public static ByteBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteHeapByteBuffer(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.476 -0400", hash_original_method = "19A737D0A382F54D53A0D74CAB245982", hash_generated_method = "D8573714774DBCCDAD59691ED95DB73A")
    public static ByteBuffer allocateDirect(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDirectByteBuffer(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.476 -0400", hash_original_method = "644E067849AFA471C056003EF7410F82", hash_generated_method = "935CA5F599322CC4A3A38C0932293EAC")
    public static ByteBuffer wrap(byte[] array) {
        return new ReadWriteHeapByteBuffer(array);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.476 -0400", hash_original_method = "5D8D0E67F592AD30EDF4A2251BAAF655", hash_generated_method = "6D1AB983F7D25AFAF7CDD62A51C18B49")
    public static ByteBuffer wrap(byte[] array, int start, int byteCount) {
        Arrays.checkOffsetAndCount(array.length, start, byteCount);
        ByteBuffer buf = new ReadWriteHeapByteBuffer(array);
        buf.position = start;
        buf.limit = start + byteCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.476 -0400", hash_original_method = "7344C3769A78C71213763E627C382A16", hash_generated_method = "778C5CA9F96174517E948B56A1D5C24A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] array() {
        byte[] varEA57FBC16B997AC0E679F048893AC79C_2056682830 = (protectedArray());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.476 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "C2DFD60F37E60D77EC81CCCAC560456F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_931288358 = (protectedArrayOffset());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "278C7A58B0643B88C9704D6A9846EFB3", hash_generated_method = "C4C0CB6005936C03FDE8C493BAD47721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(ByteBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1502049046 = ((remaining() < otherBuffer.remaining()));
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
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_728780556 = (remaining() - otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "D3C1AD6F8182660C2A5A272A59569D9E", hash_generated_method = "3286FC0935B0F2A2AD9E9293FA95F1C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        ByteBuffer otherBuffer;
        otherBuffer = (ByteBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_872449331 = (remaining() != otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "9A475FF9B92E938C1B69F2A1BC2AE724", hash_generated_method = "EB995F690A1C7D320FA7E894403B02D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer get(byte[] dst) {
        dsTaint.addTaint(dst);
        ByteBuffer var54C52896C1D21D17FF99C7DFE6939F7B_1366793072 = (get(dst, 0, dst.length));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "1D8E1FFC265A4E71218B8D81ECBD99D1", hash_generated_method = "ED2ACADC36035275426EEC1A993EAF4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1401606057 = (byteCount > remaining());
        if (DroidSafeAndroidRuntime.control) {
                throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "915E9E12884358C9DFD4C2FA1408FA3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_498605254 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "363034E27E0AFE4833C7CE1DB3D1C651")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "65B1A3EBEA253AF86057FAE15F6D4DB5", hash_generated_method = "03AD45D630A7DCC3D37A44FCCF1E747B")
    @DSModeled(DSC.SAFE)
    public final ByteOrder order() {
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "56B1D3E8961AB315D57FF8A49B63D4AB", hash_generated_method = "C0DC5F05460D4584FC478DCA1F963A43")
    @DSModeled(DSC.SAFE)
    public final ByteBuffer order(ByteOrder byteOrder) {
        dsTaint.addTaint(byteOrder.dsTaint);
        orderImpl(byteOrder);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //orderImpl(byteOrder);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.477 -0400", hash_original_method = "00AA16AC102512E5E69E8EC846E58DBE", hash_generated_method = "C4730E7A9DAD5BB91BE9F9557753360C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.478 -0400", hash_original_method = "D20A20C1C5EFB26E81C8757F39019CA4", hash_generated_method = "D6391E83EC66DE87A631A3378A48EB8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer put(byte[] src) {
        dsTaint.addTaint(src);
        ByteBuffer var974D367CEDA780433BF9CC5389A430C6_762962028 = (put(src, 0, src.length));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.478 -0400", hash_original_method = "D0316A3A41AD4E9576A2DF2983507374", hash_generated_method = "D360576D27796864E5046A0F2CDAC529")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_188303003 = (byteCount > remaining());
            if (DroidSafeAndroidRuntime.control) {
                throw new BufferOverflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.478 -0400", hash_original_method = "9C697C4B592697CC08FD298666C0BB54", hash_generated_method = "F4772D9F18043DC6F149EFE2928EA51E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteBuffer put(ByteBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("src == this");
        } //End block
        int srcByteCount;
        srcByteCount = src.remaining();
        {
            boolean varCE4A021E07A97089C6014AA3511B8F36_899819015 = (srcByteCount > remaining());
            if (DroidSafeAndroidRuntime.control) {
                throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        Object srcObject;
        boolean varD7E9FB3A2DECCDB62F76A615253FB1A1_980701769 = (src.isDirect());
        srcObject = src;
        srcObject = NioUtils.unsafeArray(src);
        int srcOffset;
        srcOffset = src.position();
        {
            boolean var1DFA7AB241497C396502EC557F1030A3_576519392 = (!src.isDirect());
            {
                srcOffset += NioUtils.unsafeArrayOffset(src);
            } //End block
        } //End collapsed parenthetic
        ByteBuffer dst;
        dst = this;
        Object dstObject;
        boolean varFB248104C4AFD3B4F5EE7FB8E52A3F44_864268328 = (dst.isDirect());
        dstObject = dst;
        dstObject = NioUtils.unsafeArray(dst);
        int dstOffset;
        dstOffset = dst.position();
        {
            boolean var9F26322EFA2F4B8EF5FF17D9F6511613_794099052 = (!dst.isDirect());
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


