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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.851 -0400", hash_original_field = "3539D1CAFCC5B7EC414F93F28B5BB3B4", hash_generated_field = "E62C78D2A6D46FD1B0DD1DF9D3201034")

    ByteOrder order = ByteOrder.BIG_ENDIAN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.864 -0400", hash_original_method = "8BF63B2B8E79FA88256074D41FD2061C", hash_generated_method = "0D307DD26739736DA127F4398862B5AB")
      ByteBuffer(int capacity, MemoryBlock block) {
        super(0, capacity, block);
        addTaint(capacity);
        addTaint(block.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.865 -0400", hash_original_method = "7344C3769A78C71213763E627C382A16", hash_generated_method = "A7879E56D55BA65BE34A58BCB064B724")
    public final byte[] array() {
        byte[] varEA57FBC16B997AC0E679F048893AC79C_597987024 = (protectedArray());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2036656291 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2036656291;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.866 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "DFF5557E4A1771CF463F84C4C4E9F96A")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_932067643 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38420086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38420086;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.873 -0400", hash_original_method = "278C7A58B0643B88C9704D6A9846EFB3", hash_generated_method = "A8FDEBB1C17A7C4CAFABC296850A8B2F")
    public int compareTo(ByteBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_729491084 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1773936875 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272031200 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272031200;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.878 -0400", hash_original_method = "D3C1AD6F8182660C2A5A272A59569D9E", hash_generated_method = "F67331FAB4DADB6B953E59E46B674D59")
    @Override
    public boolean equals(Object other) {
        ByteBuffer otherBuffer;
        otherBuffer = (ByteBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_2110683747 = (remaining() != otherBuffer.remaining());
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
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623359139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_623359139;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.891 -0400", hash_original_method = "9A475FF9B92E938C1B69F2A1BC2AE724", hash_generated_method = "870C527146DE080FF727342A0CB4F829")
    public ByteBuffer get(byte[] dst) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1860257595 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1860257595 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1860257595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1860257595;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.892 -0400", hash_original_method = "1D8E1FFC265A4E71218B8D81ECBD99D1", hash_generated_method = "68B63E305D5F5EE124F03BAB082FABB1")
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_588645107 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_322258451 = (byteCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_588645107 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_588645107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_588645107;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.907 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "90B18FF2B99F8D03AECB74B405AFF136")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_199667035 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780600220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780600220;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.908 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "8759AEA75732F0243F4D206A8CBE803C")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_831476935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_831476935;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.908 -0400", hash_original_method = "65B1A3EBEA253AF86057FAE15F6D4DB5", hash_generated_method = "9E20B069F20F2F1D765B8223079C2CFE")
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1206201675 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1206201675 = order;
        varB4EAC82CA7396A68D541C85D26508E83_1206201675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206201675;
        // ---------- Original Method ----------
        //return order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.909 -0400", hash_original_method = "56B1D3E8961AB315D57FF8A49B63D4AB", hash_generated_method = "CE1F2FA7F9B122337E115D361FD2021C")
    public final ByteBuffer order(ByteOrder byteOrder) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1539117647 = null; //Variable for return #1
        orderImpl(byteOrder);
        varB4EAC82CA7396A68D541C85D26508E83_1539117647 = this;
        addTaint(byteOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1539117647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539117647;
        // ---------- Original Method ----------
        //orderImpl(byteOrder);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.909 -0400", hash_original_method = "00AA16AC102512E5E69E8EC846E58DBE", hash_generated_method = "08E106664A5456E01256652C9F2EC95A")
     void orderImpl(ByteOrder byteOrder) {
        {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } //End block
        order = byteOrder;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.913 -0400", hash_original_method = "D20A20C1C5EFB26E81C8757F39019CA4", hash_generated_method = "BE96EA733E317E9AA9F0B60ED43161C0")
    public final ByteBuffer put(byte[] src) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1135254465 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1135254465 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1135254465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1135254465;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.931 -0400", hash_original_method = "D0316A3A41AD4E9576A2DF2983507374", hash_generated_method = "067C697E066474F73DC88ADE4B6E003E")
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_589995531 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_401384256 = (byteCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_589995531 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_589995531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_589995531;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.933 -0400", hash_original_method = "9C697C4B592697CC08FD298666C0BB54", hash_generated_method = "93E27A2DEF38389EA3635783B9BA3996")
    public ByteBuffer put(ByteBuffer src) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1505731071 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_12014103 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("src == this");
            } //End block
        } //End collapsed parenthetic
        int srcByteCount;
        srcByteCount = src.remaining();
        {
            boolean varCE4A021E07A97089C6014AA3511B8F36_524354914 = (srcByteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        Object srcObject;
        boolean varD7E9FB3A2DECCDB62F76A615253FB1A1_36895855 = (src.isDirect());
        srcObject = src;
        srcObject = NioUtils.unsafeArray(src);
        int srcOffset;
        srcOffset = src.position();
        {
            boolean var1DFA7AB241497C396502EC557F1030A3_1772299651 = (!src.isDirect());
            {
                srcOffset += NioUtils.unsafeArrayOffset(src);
            } //End block
        } //End collapsed parenthetic
        ByteBuffer dst;
        dst = this;
        Object dstObject;
        boolean varFB248104C4AFD3B4F5EE7FB8E52A3F44_737382510 = (dst.isDirect());
        dstObject = dst;
        dstObject = NioUtils.unsafeArray(dst);
        int dstOffset;
        dstOffset = dst.position();
        {
            boolean var9F26322EFA2F4B8EF5FF17D9F6511613_1316466927 = (!dst.isDirect());
            {
                dstOffset += NioUtils.unsafeArrayOffset(dst);
            } //End block
        } //End collapsed parenthetic
        Memory.memmove(dstObject, dstOffset, srcObject, srcOffset, srcByteCount);
        src.position(src.limit());
        dst.position(dst.position() + srcByteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1505731071 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1505731071.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1505731071;
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

