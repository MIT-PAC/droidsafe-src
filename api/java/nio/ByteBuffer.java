package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;

import libcore.io.Memory;





public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.259 -0400", hash_original_field = "3539D1CAFCC5B7EC414F93F28B5BB3B4", hash_generated_field = "E62C78D2A6D46FD1B0DD1DF9D3201034")

    ByteOrder order = ByteOrder.BIG_ENDIAN;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.259 -0400", hash_original_method = "8BF63B2B8E79FA88256074D41FD2061C", hash_generated_method = "B1FB9B21998280D6987895DE380D1F33")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.261 -0400", hash_original_method = "7344C3769A78C71213763E627C382A16", hash_generated_method = "85C2D518D94CD35D397F5476986E4025")
    public final byte[] array() {
        byte[] var68B89E48382A0AA51B25AC59599E2EB0_633114288 = (protectedArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_604706126 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_604706126;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.262 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "E7FD797B9044DEDD8225037A6B1E7D43")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_1726503359 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053624145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053624145;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract CharBuffer asCharBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract DoubleBuffer asDoubleBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract FloatBuffer asFloatBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract IntBuffer asIntBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract LongBuffer asLongBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer asReadOnlyBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract ShortBuffer asShortBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer compact();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.265 -0400", hash_original_method = "278C7A58B0643B88C9704D6A9846EFB3", hash_generated_method = "35C73CA86B5F71C69CD7EE52C67DAAB9")
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
                int var0D4D283E60262FF52C1A7D956005837E_1657881186 = (thisByte < otherByte ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248015178 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248015178;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_1818350626 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651731295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651731295;
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

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer duplicate();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.268 -0400", hash_original_method = "D3C1AD6F8182660C2A5A272A59569D9E", hash_generated_method = "02A90DFB9A26380929CF626A8095F22E")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof ByteBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_835800788 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912039103 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_912039103;
        } //End block
        ByteBuffer otherBuffer = (ByteBuffer) other;
        if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1509618085 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755120671 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_755120671;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_3783532 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910297381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910297381;
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

    
    @DSModeled(DSC.SAFE)
    public abstract byte get();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.269 -0400", hash_original_method = "9A475FF9B92E938C1B69F2A1BC2AE724", hash_generated_method = "E44FD848B07FFB4CAA3EDBA9DFE1132F")
    public ByteBuffer get(byte[] dst) {
        addTaint(dst[0]);
ByteBuffer varAF8F268F60258FE30F192DE78F11CD4A_1554884409 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_1554884409.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_1554884409;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.270 -0400", hash_original_method = "1D8E1FFC265A4E71218B8D81ECBD99D1", hash_generated_method = "FF5E46E3D9717BA801FBC7455AA46258")
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
        if(byteCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_775118444 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_775118444.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_775118444;
        } //End block
for(int i = dstOffset;i < dstOffset + byteCount;++i)
        {
            dst[i] = get();
        } //End block
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1829228306 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1829228306.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1829228306;
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

    
    @DSModeled(DSC.SAFE)
    public abstract byte get(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract char getChar();

    
    @DSModeled(DSC.SAFE)
    public abstract char getChar(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract double getDouble();

    
    @DSModeled(DSC.SAFE)
    public abstract double getDouble(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract float getFloat();

    
    @DSModeled(DSC.SAFE)
    public abstract float getFloat(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract int getInt();

    
    @DSModeled(DSC.SAFE)
    public abstract int getInt(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract long getLong();

    
    @DSModeled(DSC.SAFE)
    public abstract long getLong(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract short getShort();

    
    @DSModeled(DSC.SAFE)
    public abstract short getShort(int index);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.273 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "B2FF06B6E6C9D9541DC1A623E8D787B2")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_662991332 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216112919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216112919;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.274 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "75B45972F0212AE7E8E4C684B99A4635")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1309218143 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513962522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513962522;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isDirect();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.274 -0400", hash_original_method = "65B1A3EBEA253AF86057FAE15F6D4DB5", hash_generated_method = "57A7496EA23AF55A274CF296CC88D7AC")
    public final ByteOrder order() {
ByteOrder var23C56E10BB5D9B298C705EBA6A502E06_1381362824 =         order;
        var23C56E10BB5D9B298C705EBA6A502E06_1381362824.addTaint(taint);
        return var23C56E10BB5D9B298C705EBA6A502E06_1381362824;
        // ---------- Original Method ----------
        //return order;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.275 -0400", hash_original_method = "56B1D3E8961AB315D57FF8A49B63D4AB", hash_generated_method = "320DBC1BBDD53E2D4302779C4285AE40")
    public final ByteBuffer order(ByteOrder byteOrder) {
        addTaint(byteOrder.getTaint());
        orderImpl(byteOrder);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_524078327 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_524078327.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_524078327;
        // ---------- Original Method ----------
        //orderImpl(byteOrder);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.275 -0400", hash_original_method = "00AA16AC102512E5E69E8EC846E58DBE", hash_generated_method = "EEE8ADFFC18A9307F1FC3AED3CFCDD49")
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

    
    @DSModeled(DSC.SAFE)
    abstract byte[] protectedArray();

    
    @DSModeled(DSC.SAFE)
    abstract int protectedArrayOffset();

    
    @DSModeled(DSC.SAFE)
    abstract boolean protectedHasArray();

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer put(byte b);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.276 -0400", hash_original_method = "D20A20C1C5EFB26E81C8757F39019CA4", hash_generated_method = "837F97DD7C1D1249BAE0EAB536C48B7F")
    public final ByteBuffer put(byte[] src) {
        addTaint(src[0]);
ByteBuffer var7D505613BED257805463C43ADCB4DBAD_1294616309 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1294616309.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1294616309;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.276 -0400", hash_original_method = "D0316A3A41AD4E9576A2DF2983507374", hash_generated_method = "830A133BCC95CA94657162C40ABA27A8")
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
        if(byteCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_83178066 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_83178066.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_83178066;
        } //End block
for(int i = srcOffset;i < srcOffset + byteCount;++i)
        {
            put(src[i]);
        } //End block
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1651752996 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1651752996.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1651752996;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.277 -0400", hash_original_method = "9C697C4B592697CC08FD298666C0BB54", hash_generated_method = "16FF060953FCA04DCD3626E43269FE34")
    public ByteBuffer put(ByteBuffer src) {
        addTaint(src.getTaint());
        if(src == this)        
        {
            IllegalArgumentException var479F56667826C83D81840AC62422458B_1295148788 = new IllegalArgumentException("src == this");
            var479F56667826C83D81840AC62422458B_1295148788.addTaint(taint);
            throw var479F56667826C83D81840AC62422458B_1295148788;
        } //End block
        int srcByteCount = src.remaining();
        if(srcByteCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1692585411 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1692585411.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1692585411;
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
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_512558538 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_512558538.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_512558538;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer put(int index, byte b);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putChar(char value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putChar(int index, char value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putDouble(double value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putDouble(int index, double value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putFloat(float value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putFloat(int index, float value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putInt(int value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putInt(int index, int value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putLong(long value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putLong(int index, long value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putShort(short value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer putShort(int index, short value);

    
    @DSModeled(DSC.SAFE)
    public abstract ByteBuffer slice();

    
}

