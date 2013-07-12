package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.VMRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel.MapMode;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

class MemoryBlock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.875 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "2E3B00925A9AD8CC3173924CFBB7B9E6")

    protected int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.875 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "5E81D8D2490BCBC78886FD1ADC5D8740")

    protected long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.875 -0400", hash_original_method = "2736B0514B2AB4564F5D7D5517308E00", hash_generated_method = "7049F40DB4B35A37F28A4478AC10008E")
    private  MemoryBlock(int address, long size) {
        this.address = address;
        this.size = size;
        
        
        
    }

    
        public static MemoryBlock mmap(FileDescriptor fd, long offset, long size, MapMode mapMode) throws IOException {
        if (size == 0) {
            return new MemoryBlock(0, 0);
        }
        if (offset < 0 || size < 0 || offset > Integer.MAX_VALUE || size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("offset=" + offset + " size=" + size);
        }
        int prot;
        int flags;
        if (mapMode == MapMode.PRIVATE) {
            prot = PROT_READ|PROT_WRITE;
            flags = MAP_PRIVATE;
        } else if (mapMode == MapMode.READ_ONLY) {
            prot = PROT_READ;
            flags = MAP_SHARED;
        } else { 
            prot = PROT_READ|PROT_WRITE;
            flags = MAP_SHARED;
        }
        try {
            int address = (int) Libcore.os.mmap(0L, size, prot, flags, fd, offset);
            return new MemoryMappedBlock(address, size);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    
        public static MemoryBlock allocate(int byteCount) {
        VMRuntime runtime = VMRuntime.getRuntime();
        byte[] array = (byte[]) runtime.newNonMovableArray(byte.class, byteCount);
        int address = (int) runtime.addressOf(array);
        return new NonMovableHeapBlock(array, address, byteCount);
    }

    
        public static MemoryBlock wrapFromJni(int address, long byteCount) {
        return new UnmanagedBlock(address, byteCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.877 -0400", hash_original_method = "0474BFDE3AD81DCD66C16B9CD0EF394B", hash_generated_method = "43CB35035F131465C65FE5F69E42CE91")
    public byte[] array() {
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_462899351 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1144604400 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1144604400;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.877 -0400", hash_original_method = "DAA4200658B56FF77DA7170F747BB7D3", hash_generated_method = "5BE07C58F63F85984738B520AF21ADD2")
    public void free() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.877 -0400", hash_original_method = "630226707094FE04DBFFAB9271C599A8", hash_generated_method = "0FF61504C53CE2352FBA64110800995B")
    public final void pokeByte(int offset, byte value) {
        addTaint(value);
        addTaint(offset);
        Memory.pokeByte(address + offset, value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.878 -0400", hash_original_method = "8A47EAE86C2A9467630864AB102835A2", hash_generated_method = "1AB08186B108F66E1B5C5D617DB7D8E5")
    public final void pokeByteArray(int offset, byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        addTaint(offset);
        Memory.pokeByteArray(address + offset, src, srcOffset, byteCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.878 -0400", hash_original_method = "6974150101D3DDA95DB00B1670D11C6B", hash_generated_method = "21A76CFAD127E4447C39B701189C7CD5")
    public final void pokeCharArray(int offset, char[] src, int srcOffset, int charCount, boolean swap) {
        addTaint(swap);
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        addTaint(offset);
        Memory.pokeCharArray(address + offset, src, srcOffset, charCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.879 -0400", hash_original_method = "E9019E6CD21CE2C41575FF8901B1AFF2", hash_generated_method = "EE3D920B15CB7E918A9C521DF06B0E21")
    public final void pokeDoubleArray(int offset, double[] src, int srcOffset, int doubleCount, boolean swap) {
        addTaint(swap);
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        addTaint(offset);
        Memory.pokeDoubleArray(address + offset, src, srcOffset, doubleCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.879 -0400", hash_original_method = "9D3F9CE96F95038259BD55C552E41A3C", hash_generated_method = "6D33D1C6551C5D4EA6972B915A5F099E")
    public final void pokeFloatArray(int offset, float[] src, int srcOffset, int floatCount, boolean swap) {
        addTaint(swap);
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        addTaint(offset);
        Memory.pokeFloatArray(address + offset, src, srcOffset, floatCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.880 -0400", hash_original_method = "E86D1C192084CE5F4375F94D842F71F2", hash_generated_method = "5603A2B9501D007EF6CB9583144E4060")
    public final void pokeIntArray(int offset, int[] src, int srcOffset, int intCount, boolean swap) {
        addTaint(swap);
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        addTaint(offset);
        Memory.pokeIntArray(address + offset, src, srcOffset, intCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.880 -0400", hash_original_method = "7C81AB7339C181A8CFBE849C39505C24", hash_generated_method = "2FAE98FD05DC7B9FDE665F5B0AA33D35")
    public final void pokeLongArray(int offset, long[] src, int srcOffset, int longCount, boolean swap) {
        addTaint(swap);
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        addTaint(offset);
        Memory.pokeLongArray(address + offset, src, srcOffset, longCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.881 -0400", hash_original_method = "827B6834AFFDD22123FD738883080EAC", hash_generated_method = "0395A3DE85884B9CAD559995FF8EA293")
    public final void pokeShortArray(int offset, short[] src, int srcOffset, int shortCount, boolean swap) {
        addTaint(swap);
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        addTaint(offset);
        Memory.pokeShortArray(address + offset, src, srcOffset, shortCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.881 -0400", hash_original_method = "1735C3DE737C57C440010EE24811D905", hash_generated_method = "1EA7AF7C81C9350F721DBF03A4B6FB9D")
    public final byte peekByte(int offset) {
        addTaint(offset);
        byte varBF69BD39DB3E6BC5E54BE37FDD52CEC8_1314597470 = (Memory.peekByte(address + offset));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1667213789 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1667213789;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.882 -0400", hash_original_method = "4AA3FF18895191EE003F1A2CE1825900", hash_generated_method = "44D4196A6519325A5487ED84E37D16E5")
    public final void peekByteArray(int offset, byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        addTaint(offset);
        Memory.peekByteArray(address + offset, dst, dstOffset, byteCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.882 -0400", hash_original_method = "EBF1D5FEEAB6D77B374DCE8330CD224F", hash_generated_method = "1D9E14BFE79485FAFDB050E50ECA4085")
    public final void peekCharArray(int offset, char[] dst, int dstOffset, int charCount, boolean swap) {
        addTaint(swap);
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        addTaint(offset);
        Memory.peekCharArray(address + offset, dst, dstOffset, charCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.883 -0400", hash_original_method = "BFC40CE5A86066650B16C5DDA370D477", hash_generated_method = "4C3EB4E56CE07452BCE6277DC4C7F635")
    public final void peekDoubleArray(int offset, double[] dst, int dstOffset, int doubleCount, boolean swap) {
        addTaint(swap);
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        addTaint(offset);
        Memory.peekDoubleArray(address + offset, dst, dstOffset, doubleCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.883 -0400", hash_original_method = "EAD8AA573222624562CA66AD98451BFE", hash_generated_method = "00A569BA1630F207A9A4DD9E8C52C2D7")
    public final void peekFloatArray(int offset, float[] dst, int dstOffset, int floatCount, boolean swap) {
        addTaint(swap);
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        addTaint(offset);
        Memory.peekFloatArray(address + offset, dst, dstOffset, floatCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.884 -0400", hash_original_method = "4844D3E54BA100CE6DA11493B506DD6A", hash_generated_method = "9DA3B797C7B904A8322C27205A44BCC5")
    public final void peekIntArray(int offset, int[] dst, int dstOffset, int intCount, boolean swap) {
        addTaint(swap);
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        addTaint(offset);
        Memory.peekIntArray(address + offset, dst, dstOffset, intCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.884 -0400", hash_original_method = "F2861F288E908F83CFD8FF4C109C3272", hash_generated_method = "771A0231F385BEF0FC3C0530D8FB63BD")
    public final void peekLongArray(int offset, long[] dst, int dstOffset, int longCount, boolean swap) {
        addTaint(swap);
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        addTaint(offset);
        Memory.peekLongArray(address + offset, dst, dstOffset, longCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.885 -0400", hash_original_method = "8A16C923F98D3483F90AB5F32524148E", hash_generated_method = "EE3F05AECD015C7F574239F6EC34A655")
    public final void peekShortArray(int offset, short[] dst, int dstOffset, int shortCount, boolean swap) {
        addTaint(swap);
        addTaint(shortCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        addTaint(offset);
        Memory.peekShortArray(address + offset, dst, dstOffset, shortCount, swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.885 -0400", hash_original_method = "444716504DAB9ACCA4E2D3B12DD0CCBB", hash_generated_method = "8E7D0AD7A46DE69E9960D5D2026282F1")
    public final void pokeShort(int offset, short value, ByteOrder order) {
        addTaint(order.getTaint());
        addTaint(value);
        addTaint(offset);
        Memory.pokeShort(address + offset, value, order.needsSwap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.886 -0400", hash_original_method = "0920CC0D2D3BD80AEBDA06397FB42E2F", hash_generated_method = "88F9614994DC04D5FE9DBA6AB5FDDEEF")
    public final short peekShort(int offset, ByteOrder order) {
        addTaint(order.getTaint());
        addTaint(offset);
        short var561CA6F3639999A5BFA4E72B6DD34397_1502347008 = (Memory.peekShort(address + offset, order.needsSwap));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1144681690 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1144681690;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.886 -0400", hash_original_method = "8D35A6C129B8973F744F70B17E946D0A", hash_generated_method = "3E3AD191B0DC7DEDE1DA6097B760BFA7")
    public final void pokeInt(int offset, int value, ByteOrder order) {
        addTaint(order.getTaint());
        addTaint(value);
        addTaint(offset);
        Memory.pokeInt(address + offset, value, order.needsSwap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.887 -0400", hash_original_method = "58058B7ECD1176582A4EF08C49FAC88D", hash_generated_method = "50376F9E141F59BEE4DA2F2EE09FFB5F")
    public final int peekInt(int offset, ByteOrder order) {
        addTaint(order.getTaint());
        addTaint(offset);
        int var5D7A81FC0D8D6BDAFEFB0DB8D6DFF6EC_1383129822 = (Memory.peekInt(address + offset, order.needsSwap));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867507049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867507049;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.887 -0400", hash_original_method = "398A163C5D40AD88A15B92FCBDCE6284", hash_generated_method = "3CF9B2F73DF841E546762BC68EC1CAA2")
    public final void pokeLong(int offset, long value, ByteOrder order) {
        addTaint(order.getTaint());
        addTaint(value);
        addTaint(offset);
        Memory.pokeLong(address + offset, value, order.needsSwap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.887 -0400", hash_original_method = "11028C0BB53DC88A0A619583FD5A52BA", hash_generated_method = "E3981631981F7F0F8A78EDB96229F0D3")
    public final long peekLong(int offset, ByteOrder order) {
        addTaint(order.getTaint());
        addTaint(offset);
        long varC641E7B348990B52C2BD579831060188_1134747810 = (Memory.peekLong(address + offset, order.needsSwap));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2084987964 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2084987964;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.888 -0400", hash_original_method = "11B5DC04BCE6D59B1BB47A0D96ED6DD0", hash_generated_method = "2B97D03125E094E7160ABA7F6887B88F")
    public final int toInt() {
        int var884D9804999FC47A3C2694E49AD2536A_245838606 = (address);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329939397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329939397;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.888 -0400", hash_original_method = "831AD59EEB851A828F16911921FE25F3", hash_generated_method = "F2CDC5AEE92A4267EDF5EF34B7690636")
    public final String toString() {
String var9B6496D1EFD2B56F2C6FB54568E0E325_1057645725 =         getClass().getName() + "[" + address + "]";
        var9B6496D1EFD2B56F2C6FB54568E0E325_1057645725.addTaint(taint);
        return var9B6496D1EFD2B56F2C6FB54568E0E325_1057645725;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.888 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "C356C1F7E4CD53A6B17DF6C9A73E8919")
    public final long getSize() {
        long varF7BD60B75B29D79B660A2859395C1A24_2063238588 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_349268609 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_349268609;
        
        
    }

    
    private static class MemoryMappedBlock extends MemoryBlock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.889 -0400", hash_original_method = "4FA1675756D2D9224619666C72B7406C", hash_generated_method = "61963BA16BCA38A2617F88B05F1CF586")
        private  MemoryMappedBlock(int address, long byteCount) {
            super(address, byteCount);
            addTaint(byteCount);
            addTaint(address);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.889 -0400", hash_original_method = "97B49F99737474A4204C8F6662B22F05", hash_generated_method = "DEF13A19ACB59104EEAF083185B57F82")
        @Override
        public void free() {
    if(address != 0)            
            {
                try 
                {
                    Libcore.os.munmap(address, size);
                } 
                catch (ErrnoException errnoException)
                {
                    AssertionError var8D75DBC63153835F7D08A31E99200A1F_9962030 = new AssertionError(errnoException);
                    var8D75DBC63153835F7D08A31E99200A1F_9962030.addTaint(taint);
                    throw var8D75DBC63153835F7D08A31E99200A1F_9962030;
                } 
                address = 0;
            } 
            
            
                
                    
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.890 -0400", hash_original_method = "682006AE60B453BFC574D81B7AB338F6", hash_generated_method = "6DAE24A8C6B904AD51F16D6E3C4A52A2")
        @Override
        protected void finalize() throws Throwable {
            free();
            
            
        }

        
    }


    
    private static class NonMovableHeapBlock extends MemoryBlock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.890 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "9AF64BC00BB5D51223FCF5D879F8268F")

        private byte[] array;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.890 -0400", hash_original_method = "8A7988AD7039E674F46AF68EAF8AE446", hash_generated_method = "C06BB50E8D6E4AF2DECA0F3FAC47B3B8")
        private  NonMovableHeapBlock(byte[] array, int address, long byteCount) {
            super(address, byteCount);
            addTaint(byteCount);
            addTaint(address);
            this.array = array;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.891 -0400", hash_original_method = "D17F44ECB38D0894EC4D368C7A4552E2", hash_generated_method = "163892CD627642C4913F1A71B6D4E971")
        @Override
        public byte[] array() {
            byte[] varF1F713C9E000F5D3F280ADBD124DF4F5_1434362757 = (array);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1170775679 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1170775679;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.891 -0400", hash_original_method = "7CD7BC202225C0DF2E4B3C563E9F4089", hash_generated_method = "732E056F3D64E4EBE26E88FEB87054A0")
        @Override
        public void free() {
            array = null;
            address = 0;
            
            
            
        }

        
    }


    
    private static class UnmanagedBlock extends MemoryBlock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.891 -0400", hash_original_method = "3FA50BA19E59098968678E710BF90D48", hash_generated_method = "81E2C13CD1B80A44BB60960108992316")
        private  UnmanagedBlock(int address, long byteCount) {
            super(address, byteCount);
            addTaint(byteCount);
            addTaint(address);
            
        }

        
    }


    
}

