package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;
import libcore.io.Memory;

public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.784 -0400", hash_original_field = "3539D1CAFCC5B7EC414F93F28B5BB3B4", hash_generated_field = "E62C78D2A6D46FD1B0DD1DF9D3201034")

    ByteOrder order = ByteOrder.BIG_ENDIAN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.785 -0400", hash_original_method = "8BF63B2B8E79FA88256074D41FD2061C", hash_generated_method = "0D307DD26739736DA127F4398862B5AB")
      ByteBuffer(int capacity, MemoryBlock block) {
        super(0, capacity, block);
        addTaint(capacity);
        addTaint(block.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ByteBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteHeapByteBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static ByteBuffer allocateDirect(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDirectByteBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static ByteBuffer wrap(byte[] array) {
        return new ReadWriteHeapByteBuffer(array);
    }

    
    @DSModeled(DSC.SAFE)
    public static ByteBuffer wrap(byte[] array, int start, int byteCount) {
        Arrays.checkOffsetAndCount(array.length, start, byteCount);
        ByteBuffer buf = new ReadWriteHeapByteBuffer(array);
        buf.position = start;
        buf.limit = start + byteCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.787 -0400", hash_original_method = "7344C3769A78C71213763E627C382A16", hash_generated_method = "64E5F96049B4373206819CBF5CE92176")
    public final byte[] array() {
        byte[] varEA57FBC16B997AC0E679F048893AC79C_1914817549 = (protectedArray());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1873817506 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1873817506;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.787 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "76DA3C0BC2449A3C2DB094D9065648DA")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_766517203 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916012046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916012046;
        
        
    }

    
    public abstract CharBuffer asCharBuffer();

    
    public abstract DoubleBuffer asDoubleBuffer();

    
    public abstract FloatBuffer asFloatBuffer();

    
    public abstract IntBuffer asIntBuffer();

    
    public abstract LongBuffer asLongBuffer();

    
    public abstract ByteBuffer asReadOnlyBuffer();

    
    public abstract ShortBuffer asShortBuffer();

    
    public abstract ByteBuffer compact();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.789 -0400", hash_original_method = "278C7A58B0643B88C9704D6A9846EFB3", hash_generated_method = "25254FECAAA9E8EAF7E43901C3A38B2A")
    public int compareTo(ByteBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_652583229 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        byte thisByte;
        byte otherByte;
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
        } 
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1781773502 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301587248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301587248;
        
        
                
        
        
        
        
            
            
            
                
            
            
            
            
        
        
    }

    
    public abstract ByteBuffer duplicate();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.790 -0400", hash_original_method = "D3C1AD6F8182660C2A5A272A59569D9E", hash_generated_method = "A5891DA7110C94CA5D168303E0B31E0F")
    @Override
    public boolean equals(Object other) {
        ByteBuffer otherBuffer = (ByteBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_160896260 = (remaining() != otherBuffer.remaining());
        } 
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773887617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773887617;
        
        
            
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    public abstract byte get();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.791 -0400", hash_original_method = "9A475FF9B92E938C1B69F2A1BC2AE724", hash_generated_method = "A5BE59FAA3A72F2A31A07CDE6FF194D6")
    public ByteBuffer get(byte[] dst) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1244202492 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1244202492 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1244202492.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1244202492;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.791 -0400", hash_original_method = "1D8E1FFC265A4E71218B8D81ECBD99D1", hash_generated_method = "F23476A24CB3E38095B67C2E3D6253BA")
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1393876820 = null; 
        Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1027311214 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } 
        } 
        {
            int i = dstOffset;
            {
                dst[i] = get();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1393876820 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1393876820.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1393876820;
        
        
        
            
        
        
            
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.794 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "27030C09689D1082FB70113A946589EE")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_20936160 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510278839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510278839;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.794 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "5155D341AD8DA15E519A4661A712B8E9")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        {
            hash = hash + get(myPosition++);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371235901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371235901;
        
        
        
        
            
        
        
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.795 -0400", hash_original_method = "65B1A3EBEA253AF86057FAE15F6D4DB5", hash_generated_method = "D74B187560F74E206C60A109B5499B90")
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1232732291 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1232732291 = order;
        varB4EAC82CA7396A68D541C85D26508E83_1232732291.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1232732291;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.796 -0400", hash_original_method = "56B1D3E8961AB315D57FF8A49B63D4AB", hash_generated_method = "C4021993BB208F73F6CDFB02122CAFD2")
    public final ByteBuffer order(ByteOrder byteOrder) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_875444205 = null; 
        orderImpl(byteOrder);
        varB4EAC82CA7396A68D541C85D26508E83_875444205 = this;
        addTaint(byteOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_875444205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_875444205;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.796 -0400", hash_original_method = "00AA16AC102512E5E69E8EC846E58DBE", hash_generated_method = "08E106664A5456E01256652C9F2EC95A")
     void orderImpl(ByteOrder byteOrder) {
        {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } 
        order = byteOrder;
        
        
            
        
        
    }

    
    abstract byte[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract ByteBuffer put(byte b);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.798 -0400", hash_original_method = "D20A20C1C5EFB26E81C8757F39019CA4", hash_generated_method = "8F87291653800CB3F2A2372AC1FF08CA")
    public final ByteBuffer put(byte[] src) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2099506689 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2099506689 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_2099506689.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2099506689;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.800 -0400", hash_original_method = "D0316A3A41AD4E9576A2DF2983507374", hash_generated_method = "94CD4F49E1DDFDB44FB5E76B329F4FC4")
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_214422281 = null; 
        Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1186455737 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        {
            int i = srcOffset;
            {
                put(src[i]);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_214422281 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_214422281.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_214422281;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.805 -0400", hash_original_method = "9C697C4B592697CC08FD298666C0BB54", hash_generated_method = "4A5AF04B94FCD1F7C6339E402F400EB2")
    public ByteBuffer put(ByteBuffer src) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_219260352 = null; 
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1592404848 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("src == this");
            } 
        } 
        int srcByteCount = src.remaining();
        {
            boolean varCE4A021E07A97089C6014AA3511B8F36_1229932995 = (srcByteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        Object srcObject;
        boolean varD7E9FB3A2DECCDB62F76A615253FB1A1_664656656 = (src.isDirect());
        srcObject = src;
        srcObject = NioUtils.unsafeArray(src);
        int srcOffset = src.position();
        {
            boolean var1DFA7AB241497C396502EC557F1030A3_478694324 = (!src.isDirect());
            {
                srcOffset += NioUtils.unsafeArrayOffset(src);
            } 
        } 
        ByteBuffer dst = this;
        Object dstObject;
        boolean varFB248104C4AFD3B4F5EE7FB8E52A3F44_18295700 = (dst.isDirect());
        dstObject = dst;
        dstObject = NioUtils.unsafeArray(dst);
        int dstOffset = dst.position();
        {
            boolean var9F26322EFA2F4B8EF5FF17D9F6511613_2084524707 = (!dst.isDirect());
            {
                dstOffset += NioUtils.unsafeArrayOffset(dst);
            } 
        } 
        Memory.memmove(dstObject, dstOffset, srcObject, srcOffset, srcByteCount);
        src.position(src.limit());
        dst.position(dst.position() + srcByteCount);
        varB4EAC82CA7396A68D541C85D26508E83_219260352 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_219260352.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_219260352;
        
        
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

