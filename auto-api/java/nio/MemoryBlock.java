package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import dalvik.system.VMRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel.MapMode;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

class MemoryBlock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.811 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "2E3B00925A9AD8CC3173924CFBB7B9E6")

    protected int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.811 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "5E81D8D2490BCBC78886FD1ADC5D8740")

    protected long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.811 -0400", hash_original_method = "2736B0514B2AB4564F5D7D5517308E00", hash_generated_method = "7049F40DB4B35A37F28A4478AC10008E")
    private  MemoryBlock(int address, long size) {
        this.address = address;
        this.size = size;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
    public static MemoryBlock allocate(int byteCount) {
        VMRuntime runtime = VMRuntime.getRuntime();
        byte[] array = (byte[]) runtime.newNonMovableArray(byte.class, byteCount);
        int address = (int) runtime.addressOf(array);
        return new NonMovableHeapBlock(array, address, byteCount);
    }

    
    @DSModeled(DSC.SPEC)
    public static MemoryBlock wrapFromJni(int address, long byteCount) {
        return new UnmanagedBlock(address, byteCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.812 -0400", hash_original_method = "0474BFDE3AD81DCD66C16B9CD0EF394B", hash_generated_method = "D7FB9128C75214CB1A47C482AE522B68")
    public byte[] array() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1841263369 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1841263369;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.812 -0400", hash_original_method = "DAA4200658B56FF77DA7170F747BB7D3", hash_generated_method = "5BE07C58F63F85984738B520AF21ADD2")
    public void free() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.812 -0400", hash_original_method = "630226707094FE04DBFFAB9271C599A8", hash_generated_method = "25E33AC35B743C8DE023F43A1985E980")
    public final void pokeByte(int offset, byte value) {
        Memory.pokeByte(address + offset, value);
        addTaint(offset);
        addTaint(value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.812 -0400", hash_original_method = "8A47EAE86C2A9467630864AB102835A2", hash_generated_method = "F0786734F0E203DACF7DC522871E1701")
    public final void pokeByteArray(int offset, byte[] src, int srcOffset, int byteCount) {
        Memory.pokeByteArray(address + offset, src, srcOffset, byteCount);
        addTaint(offset);
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.813 -0400", hash_original_method = "6974150101D3DDA95DB00B1670D11C6B", hash_generated_method = "1AFE67D362AC0325360A36055886E8CA")
    public final void pokeCharArray(int offset, char[] src, int srcOffset, int charCount, boolean swap) {
        Memory.pokeCharArray(address + offset, src, srcOffset, charCount, swap);
        addTaint(offset);
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.813 -0400", hash_original_method = "E9019E6CD21CE2C41575FF8901B1AFF2", hash_generated_method = "A736FF31D5A8BAF8EC8220A42D38A8E9")
    public final void pokeDoubleArray(int offset, double[] src, int srcOffset, int doubleCount, boolean swap) {
        Memory.pokeDoubleArray(address + offset, src, srcOffset, doubleCount, swap);
        addTaint(offset);
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.813 -0400", hash_original_method = "9D3F9CE96F95038259BD55C552E41A3C", hash_generated_method = "E3CC274F9F820A17B44715E34264616E")
    public final void pokeFloatArray(int offset, float[] src, int srcOffset, int floatCount, boolean swap) {
        Memory.pokeFloatArray(address + offset, src, srcOffset, floatCount, swap);
        addTaint(offset);
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.814 -0400", hash_original_method = "E86D1C192084CE5F4375F94D842F71F2", hash_generated_method = "189A943FC5223BD3905DA59ABBB83385")
    public final void pokeIntArray(int offset, int[] src, int srcOffset, int intCount, boolean swap) {
        Memory.pokeIntArray(address + offset, src, srcOffset, intCount, swap);
        addTaint(offset);
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.814 -0400", hash_original_method = "7C81AB7339C181A8CFBE849C39505C24", hash_generated_method = "F99DC14B630EB61982BB42A5E0F9CA84")
    public final void pokeLongArray(int offset, long[] src, int srcOffset, int longCount, boolean swap) {
        Memory.pokeLongArray(address + offset, src, srcOffset, longCount, swap);
        addTaint(offset);
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.815 -0400", hash_original_method = "827B6834AFFDD22123FD738883080EAC", hash_generated_method = "237078199BF757ACDA0B8EC61BCB39AD")
    public final void pokeShortArray(int offset, short[] src, int srcOffset, int shortCount, boolean swap) {
        Memory.pokeShortArray(address + offset, src, srcOffset, shortCount, swap);
        addTaint(offset);
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.815 -0400", hash_original_method = "1735C3DE737C57C440010EE24811D905", hash_generated_method = "A19D75D975023182239CD6F3F1DBD456")
    public final byte peekByte(int offset) {
        byte var0D439E36464350F65C32534D25795783_268920733 = (Memory.peekByte(address + offset));
        addTaint(offset);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_684166697 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_684166697;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.816 -0400", hash_original_method = "4AA3FF18895191EE003F1A2CE1825900", hash_generated_method = "10497733A100E3459EFBE9966C7D84AE")
    public final void peekByteArray(int offset, byte[] dst, int dstOffset, int byteCount) {
        Memory.peekByteArray(address + offset, dst, dstOffset, byteCount);
        addTaint(offset);
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.816 -0400", hash_original_method = "EBF1D5FEEAB6D77B374DCE8330CD224F", hash_generated_method = "772EF58CCEB113FE5B6DFA1932D0DC4B")
    public final void peekCharArray(int offset, char[] dst, int dstOffset, int charCount, boolean swap) {
        Memory.peekCharArray(address + offset, dst, dstOffset, charCount, swap);
        addTaint(offset);
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.816 -0400", hash_original_method = "BFC40CE5A86066650B16C5DDA370D477", hash_generated_method = "E0D3F2919BF0AE8E643DDAD878D05072")
    public final void peekDoubleArray(int offset, double[] dst, int dstOffset, int doubleCount, boolean swap) {
        Memory.peekDoubleArray(address + offset, dst, dstOffset, doubleCount, swap);
        addTaint(offset);
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.817 -0400", hash_original_method = "EAD8AA573222624562CA66AD98451BFE", hash_generated_method = "DF9D62BDE59AEA7F57F98BF5C4AF7D7D")
    public final void peekFloatArray(int offset, float[] dst, int dstOffset, int floatCount, boolean swap) {
        Memory.peekFloatArray(address + offset, dst, dstOffset, floatCount, swap);
        addTaint(offset);
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.817 -0400", hash_original_method = "4844D3E54BA100CE6DA11493B506DD6A", hash_generated_method = "A0B285A91FBD47C9B13B1740ECB8A45F")
    public final void peekIntArray(int offset, int[] dst, int dstOffset, int intCount, boolean swap) {
        Memory.peekIntArray(address + offset, dst, dstOffset, intCount, swap);
        addTaint(offset);
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.817 -0400", hash_original_method = "F2861F288E908F83CFD8FF4C109C3272", hash_generated_method = "BFCE74D6432D14F2887DCB89FE15996F")
    public final void peekLongArray(int offset, long[] dst, int dstOffset, int longCount, boolean swap) {
        Memory.peekLongArray(address + offset, dst, dstOffset, longCount, swap);
        addTaint(offset);
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.818 -0400", hash_original_method = "8A16C923F98D3483F90AB5F32524148E", hash_generated_method = "41A8D968AB89A9675883D4DAB6F3CD28")
    public final void peekShortArray(int offset, short[] dst, int dstOffset, int shortCount, boolean swap) {
        Memory.peekShortArray(address + offset, dst, dstOffset, shortCount, swap);
        addTaint(offset);
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        addTaint(swap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.818 -0400", hash_original_method = "444716504DAB9ACCA4E2D3B12DD0CCBB", hash_generated_method = "FD25CBE6DD72B53AE58134FE470FE870")
    public final void pokeShort(int offset, short value, ByteOrder order) {
        Memory.pokeShort(address + offset, value, order.needsSwap);
        addTaint(offset);
        addTaint(value);
        addTaint(order.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.818 -0400", hash_original_method = "0920CC0D2D3BD80AEBDA06397FB42E2F", hash_generated_method = "8918209F11D6CA1E89879522CC60A98E")
    public final short peekShort(int offset, ByteOrder order) {
        short var1F66A8A3058E8ADBC1D452124A742F19_1793712983 = (Memory.peekShort(address + offset, order.needsSwap));
        addTaint(offset);
        addTaint(order.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_1131563496 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1131563496;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.818 -0400", hash_original_method = "8D35A6C129B8973F744F70B17E946D0A", hash_generated_method = "A682B394A81DF85BF5F16095E8FDE98F")
    public final void pokeInt(int offset, int value, ByteOrder order) {
        Memory.pokeInt(address + offset, value, order.needsSwap);
        addTaint(offset);
        addTaint(value);
        addTaint(order.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.818 -0400", hash_original_method = "58058B7ECD1176582A4EF08C49FAC88D", hash_generated_method = "EC21604D739650341F4C7EFC1086181E")
    public final int peekInt(int offset, ByteOrder order) {
        int var66DF98091EA92ADB30FFFE820D3F0B5E_1279202782 = (Memory.peekInt(address + offset, order.needsSwap));
        addTaint(offset);
        addTaint(order.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050453392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050453392;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.819 -0400", hash_original_method = "398A163C5D40AD88A15B92FCBDCE6284", hash_generated_method = "C540417CB3C2AAD3877584B017543BAE")
    public final void pokeLong(int offset, long value, ByteOrder order) {
        Memory.pokeLong(address + offset, value, order.needsSwap);
        addTaint(offset);
        addTaint(value);
        addTaint(order.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.819 -0400", hash_original_method = "11028C0BB53DC88A0A619583FD5A52BA", hash_generated_method = "30C766AE2603EBB6E10D25028F9012F3")
    public final long peekLong(int offset, ByteOrder order) {
        long var43562883F7D722A1E7FF059817EB076C_1098299885 = (Memory.peekLong(address + offset, order.needsSwap));
        addTaint(offset);
        addTaint(order.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1882078985 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1882078985;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.819 -0400", hash_original_method = "11B5DC04BCE6D59B1BB47A0D96ED6DD0", hash_generated_method = "CA8C63FE3FF108B12ED52F5306B7D361")
    public final int toInt() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118586682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118586682;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.819 -0400", hash_original_method = "831AD59EEB851A828F16911921FE25F3", hash_generated_method = "7B2E0545F303F025E9075784FF0B6BDE")
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_115808128 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_115808128 = getClass().getName() + "[" + address + "]";
        varB4EAC82CA7396A68D541C85D26508E83_115808128.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_115808128;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.820 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "4562D5910273AE296C6189F5582C0C9A")
    public final long getSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_643859748 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_643859748;
        
        
    }

    
    private static class MemoryMappedBlock extends MemoryBlock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.820 -0400", hash_original_method = "4FA1675756D2D9224619666C72B7406C", hash_generated_method = "98C72AE2E375B14A8A1E7B0A6C55FB4E")
        private  MemoryMappedBlock(int address, long byteCount) {
            super(address, byteCount);
            addTaint(address);
            addTaint(byteCount);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.820 -0400", hash_original_method = "97B49F99737474A4204C8F6662B22F05", hash_generated_method = "DA7FF6292276A5D13DBD67A2E3B48A6A")
        @Override
        public void free() {
            {
                try 
                {
                    Libcore.os.munmap(address, size);
                } 
                catch (ErrnoException errnoException)
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
                } 
                address = 0;
            } 
            
            
                
                    
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.820 -0400", hash_original_method = "682006AE60B453BFC574D81B7AB338F6", hash_generated_method = "6DAE24A8C6B904AD51F16D6E3C4A52A2")
        @Override
        protected void finalize() throws Throwable {
            free();
            
            
        }

        
    }


    
    private static class NonMovableHeapBlock extends MemoryBlock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.820 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "9AF64BC00BB5D51223FCF5D879F8268F")

        private byte[] array;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.821 -0400", hash_original_method = "8A7988AD7039E674F46AF68EAF8AE446", hash_generated_method = "9D2537CD65B19615705829313023D1DA")
        private  NonMovableHeapBlock(byte[] array, int address, long byteCount) {
            super(address, byteCount);
            this.array = array;
            addTaint(address);
            addTaint(byteCount);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.821 -0400", hash_original_method = "D17F44ECB38D0894EC4D368C7A4552E2", hash_generated_method = "14C60C4E3414784341A99A60669F2E80")
        @Override
        public byte[] array() {
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_534881579 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_534881579;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.821 -0400", hash_original_method = "7CD7BC202225C0DF2E4B3C563E9F4089", hash_generated_method = "732E056F3D64E4EBE26E88FEB87054A0")
        @Override
        public void free() {
            array = null;
            address = 0;
            
            
            
        }

        
    }


    
    private static class UnmanagedBlock extends MemoryBlock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.821 -0400", hash_original_method = "3FA50BA19E59098968678E710BF90D48", hash_generated_method = "38145290AB22BCE0ADA55E2D71422D6A")
        private  UnmanagedBlock(int address, long byteCount) {
            super(address, byteCount);
            addTaint(address);
            addTaint(byteCount);
            
        }

        
    }


    
}

