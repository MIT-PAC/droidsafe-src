package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
import libcore.io.Memory;

public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.954 -0400", hash_original_field = "3539D1CAFCC5B7EC414F93F28B5BB3B4", hash_generated_field = "E62C78D2A6D46FD1B0DD1DF9D3201034")

    ByteOrder order = ByteOrder.BIG_ENDIAN;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.955 -0400", hash_original_method = "8BF63B2B8E79FA88256074D41FD2061C", hash_generated_method = "B1FB9B21998280D6987895DE380D1F33")
      ByteBuffer(int capacity, MemoryBlock block) {
        super(0, capacity, block);
        addTaint(block.getTaint());
        addTaint(capacity);
        // ---------- Original Method ----------
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.956 -0400", hash_original_method = "7344C3769A78C71213763E627C382A16", hash_generated_method = "AA4770225C324455B81580F797F84D25")
    public final byte[] array() {
        byte[] var68B89E48382A0AA51B25AC59599E2EB0_1152179693 = (protectedArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_104300312 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_104300312;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.956 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "2A012B2F0D77775BD3C7534482ACA964")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_944309757 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729281203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729281203;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.959 -0400", hash_original_method = "278C7A58B0643B88C9704D6A9846EFB3", hash_generated_method = "FD43E8FFFB891D849CD08851282BA034")
    public int compareTo(ByteBuffer otherBuffer) {
        addTaint(otherBuffer.getTaint());
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        byte thisByte;
        byte otherByte;
        while
(compareRemaining > 0)        
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
    if(thisByte != otherByte)            
            {
                int var0D4D283E60262FF52C1A7D956005837E_2029151191 = (thisByte < otherByte ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466546260 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466546260;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_556133156 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039915133 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039915133;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.960 -0400", hash_original_method = "D3C1AD6F8182660C2A5A272A59569D9E", hash_generated_method = "7665817FBD2A3EA064641235AE76235B")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof ByteBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_839744814 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281843326 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281843326;
        } //End block
        ByteBuffer otherBuffer = (ByteBuffer) other;
    if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_517654058 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2027364525 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2027364525;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_1490626516 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298332701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298332701;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.961 -0400", hash_original_method = "9A475FF9B92E938C1B69F2A1BC2AE724", hash_generated_method = "6EAA770EB0172E36630BCB0C79C498F7")
    public ByteBuffer get(byte[] dst) {
        addTaint(dst[0]);
ByteBuffer varAF8F268F60258FE30F192DE78F11CD4A_358581275 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_358581275.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_358581275;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.962 -0400", hash_original_method = "1D8E1FFC265A4E71218B8D81ECBD99D1", hash_generated_method = "1C6C344EE57F2AEEF96873B6B4041FF6")
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
    if(byteCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1789751521 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1789751521.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1789751521;
        } //End block
for(int i = dstOffset;i < dstOffset + byteCount;++i)
        {
            dst[i] = get();
        } //End block
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_187515551 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_187515551.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_187515551;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.965 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "5D71D42715B37C113636B0322631C6BE")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1691644099 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023297597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023297597;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.965 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "8FA7DE7ABE4181E763264C66421CBD27")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1596674481 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30405431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30405431;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.966 -0400", hash_original_method = "65B1A3EBEA253AF86057FAE15F6D4DB5", hash_generated_method = "26EFE2856C2C96E1DD50892EBC058263")
    public final ByteOrder order() {
ByteOrder var23C56E10BB5D9B298C705EBA6A502E06_96160417 =         order;
        var23C56E10BB5D9B298C705EBA6A502E06_96160417.addTaint(taint);
        return var23C56E10BB5D9B298C705EBA6A502E06_96160417;
        // ---------- Original Method ----------
        //return order;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.966 -0400", hash_original_method = "56B1D3E8961AB315D57FF8A49B63D4AB", hash_generated_method = "077DFED14BE8F8A763CC66B26BC8042F")
    public final ByteBuffer order(ByteOrder byteOrder) {
        addTaint(byteOrder.getTaint());
        orderImpl(byteOrder);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1430488684 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1430488684.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1430488684;
        // ---------- Original Method ----------
        //orderImpl(byteOrder);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.967 -0400", hash_original_method = "00AA16AC102512E5E69E8EC846E58DBE", hash_generated_method = "EEE8ADFFC18A9307F1FC3AED3CFCDD49")
     void orderImpl(ByteOrder byteOrder) {
    if(byteOrder == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.968 -0400", hash_original_method = "D20A20C1C5EFB26E81C8757F39019CA4", hash_generated_method = "4A96C7C027E1E2C01F58D812C1F7CD55")
    public final ByteBuffer put(byte[] src) {
        addTaint(src[0]);
ByteBuffer var7D505613BED257805463C43ADCB4DBAD_1760799234 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1760799234.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1760799234;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.969 -0400", hash_original_method = "D0316A3A41AD4E9576A2DF2983507374", hash_generated_method = "3F65F636383EA5C5A36F8A79CC681DB0")
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
    if(byteCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_2042124396 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_2042124396.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_2042124396;
        } //End block
for(int i = srcOffset;i < srcOffset + byteCount;++i)
        {
            put(src[i]);
        } //End block
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_357134210 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_357134210.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_357134210;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.970 -0400", hash_original_method = "9C697C4B592697CC08FD298666C0BB54", hash_generated_method = "30A346412C71FB195A8FB6C4A208457F")
    public ByteBuffer put(ByteBuffer src) {
        addTaint(src.getTaint());
    if(src == this)        
        {
            IllegalArgumentException var479F56667826C83D81840AC62422458B_1567434804 = new IllegalArgumentException("src == this");
            var479F56667826C83D81840AC62422458B_1567434804.addTaint(taint);
            throw var479F56667826C83D81840AC62422458B_1567434804;
        } //End block
        int srcByteCount = src.remaining();
    if(srcByteCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_813346446 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_813346446.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_813346446;
        } //End block
        Object srcObject = src.isDirect() ? src : NioUtils.unsafeArray(src);
        int srcOffset = src.position();
    if(!src.isDirect())        
        {
            srcOffset += NioUtils.unsafeArrayOffset(src);
        } //End block
        ByteBuffer dst = this;
        Object dstObject = dst.isDirect() ? dst : NioUtils.unsafeArray(dst);
        int dstOffset = dst.position();
    if(!dst.isDirect())        
        {
            dstOffset += NioUtils.unsafeArrayOffset(dst);
        } //End block
        Memory.memmove(dstObject, dstOffset, srcObject, srcOffset, srcByteCount);
        src.position(src.limit());
        dst.position(dst.position() + srcByteCount);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1716899012 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1716899012.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1716899012;
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

