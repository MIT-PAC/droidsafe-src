package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    protected int address;
    protected long size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.848 -0400", hash_original_method = "2736B0514B2AB4564F5D7D5517308E00", hash_generated_method = "BFAE64F6885AEC6293697A3B05D3DE44")
    @DSModeled(DSC.SAFE)
    private MemoryBlock(int address, long size) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //this.address = address;
        //this.size = size;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.849 -0400", hash_original_method = "0474BFDE3AD81DCD66C16B9CD0EF394B", hash_generated_method = "17ACAC6562EA6A8E3468060A1EFE3999")
    @DSModeled(DSC.SAFE)
    public byte[] array() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.849 -0400", hash_original_method = "DAA4200658B56FF77DA7170F747BB7D3", hash_generated_method = "5BE07C58F63F85984738B520AF21ADD2")
    @DSModeled(DSC.SAFE)
    public void free() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.849 -0400", hash_original_method = "630226707094FE04DBFFAB9271C599A8", hash_generated_method = "96842182AC87930EC4F2C08860EEFCF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeByte(int offset, byte value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeByte(address + offset, value);
        // ---------- Original Method ----------
        //Memory.pokeByte(address + offset, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.849 -0400", hash_original_method = "8A47EAE86C2A9467630864AB102835A2", hash_generated_method = "4A327B6DF796B6EE292513267DA6A5EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeByteArray(int offset, byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(offset);
        Memory.pokeByteArray(address + offset, src, srcOffset, byteCount);
        // ---------- Original Method ----------
        //Memory.pokeByteArray(address + offset, src, srcOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.850 -0400", hash_original_method = "6974150101D3DDA95DB00B1670D11C6B", hash_generated_method = "48B6F91B5216445D54AD588F93348C56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeCharArray(int offset, char[] src, int srcOffset, int charCount, boolean swap) {
        dsTaint.addTaint(swap);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        Memory.pokeCharArray(address + offset, src, srcOffset, charCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeCharArray(address + offset, src, srcOffset, charCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.850 -0400", hash_original_method = "E9019E6CD21CE2C41575FF8901B1AFF2", hash_generated_method = "6A44E392A832538B6EAC70E9A549E680")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeDoubleArray(int offset, double[] src, int srcOffset, int doubleCount, boolean swap) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(offset);
        Memory.pokeDoubleArray(address + offset, src, srcOffset, doubleCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeDoubleArray(address + offset, src, srcOffset, doubleCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.850 -0400", hash_original_method = "9D3F9CE96F95038259BD55C552E41A3C", hash_generated_method = "36A8E0B5C56064AF2B48661A2633EB1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeFloatArray(int offset, float[] src, int srcOffset, int floatCount, boolean swap) {
        dsTaint.addTaint(swap);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(floatCount);
        Memory.pokeFloatArray(address + offset, src, srcOffset, floatCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeFloatArray(address + offset, src, srcOffset, floatCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.850 -0400", hash_original_method = "E86D1C192084CE5F4375F94D842F71F2", hash_generated_method = "4121BC50A4E09F718DD2BC151AD20BC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeIntArray(int offset, int[] src, int srcOffset, int intCount, boolean swap) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(offset);
        Memory.pokeIntArray(address + offset, src, srcOffset, intCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeIntArray(address + offset, src, srcOffset, intCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.850 -0400", hash_original_method = "7C81AB7339C181A8CFBE849C39505C24", hash_generated_method = "E9CD0E9E1FF554D42D56E329065A15D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeLongArray(int offset, long[] src, int srcOffset, int longCount, boolean swap) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(offset);
        Memory.pokeLongArray(address + offset, src, srcOffset, longCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeLongArray(address + offset, src, srcOffset, longCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.851 -0400", hash_original_method = "827B6834AFFDD22123FD738883080EAC", hash_generated_method = "48BED705F6DDD62EBC4453E8BCDDDAC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeShortArray(int offset, short[] src, int srcOffset, int shortCount, boolean swap) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(offset);
        Memory.pokeShortArray(address + offset, src, srcOffset, shortCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeShortArray(address + offset, src, srcOffset, shortCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.851 -0400", hash_original_method = "1735C3DE737C57C440010EE24811D905", hash_generated_method = "A0B88419C590E9231F369581709D74F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte peekByte(int offset) {
        dsTaint.addTaint(offset);
        byte var0D439E36464350F65C32534D25795783_1565569985 = (Memory.peekByte(address + offset));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return Memory.peekByte(address + offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.851 -0400", hash_original_method = "4AA3FF18895191EE003F1A2CE1825900", hash_generated_method = "76E196932F13FE742529D2363B6BD01C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void peekByteArray(int offset, byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        Memory.peekByteArray(address + offset, dst, dstOffset, byteCount);
        // ---------- Original Method ----------
        //Memory.peekByteArray(address + offset, dst, dstOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.852 -0400", hash_original_method = "EBF1D5FEEAB6D77B374DCE8330CD224F", hash_generated_method = "B8F941908E8F2814E639ABE9DE959045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void peekCharArray(int offset, char[] dst, int dstOffset, int charCount, boolean swap) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        Memory.peekCharArray(address + offset, dst, dstOffset, charCount, swap);
        // ---------- Original Method ----------
        //Memory.peekCharArray(address + offset, dst, dstOffset, charCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.853 -0400", hash_original_method = "BFC40CE5A86066650B16C5DDA370D477", hash_generated_method = "68E0FCA25B6ED6CE603827E962A307F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void peekDoubleArray(int offset, double[] dst, int dstOffset, int doubleCount, boolean swap) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        Memory.peekDoubleArray(address + offset, dst, dstOffset, doubleCount, swap);
        // ---------- Original Method ----------
        //Memory.peekDoubleArray(address + offset, dst, dstOffset, doubleCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.853 -0400", hash_original_method = "EAD8AA573222624562CA66AD98451BFE", hash_generated_method = "85F03163F4BB9074BCB6904FCCBC7F36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void peekFloatArray(int offset, float[] dst, int dstOffset, int floatCount, boolean swap) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(floatCount);
        Memory.peekFloatArray(address + offset, dst, dstOffset, floatCount, swap);
        // ---------- Original Method ----------
        //Memory.peekFloatArray(address + offset, dst, dstOffset, floatCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.853 -0400", hash_original_method = "4844D3E54BA100CE6DA11493B506DD6A", hash_generated_method = "833DA52BCA8B86832D939CF903348ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void peekIntArray(int offset, int[] dst, int dstOffset, int intCount, boolean swap) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        Memory.peekIntArray(address + offset, dst, dstOffset, intCount, swap);
        // ---------- Original Method ----------
        //Memory.peekIntArray(address + offset, dst, dstOffset, intCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.853 -0400", hash_original_method = "F2861F288E908F83CFD8FF4C109C3272", hash_generated_method = "9315E3EA556DC1102ED38FC689C28698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void peekLongArray(int offset, long[] dst, int dstOffset, int longCount, boolean swap) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        Memory.peekLongArray(address + offset, dst, dstOffset, longCount, swap);
        // ---------- Original Method ----------
        //Memory.peekLongArray(address + offset, dst, dstOffset, longCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.853 -0400", hash_original_method = "8A16C923F98D3483F90AB5F32524148E", hash_generated_method = "CFF81B91B325955316469AC1622CF97B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void peekShortArray(int offset, short[] dst, int dstOffset, int shortCount, boolean swap) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        Memory.peekShortArray(address + offset, dst, dstOffset, shortCount, swap);
        // ---------- Original Method ----------
        //Memory.peekShortArray(address + offset, dst, dstOffset, shortCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.854 -0400", hash_original_method = "444716504DAB9ACCA4E2D3B12DD0CCBB", hash_generated_method = "253432727013B506021920A98E195449")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeShort(int offset, short value, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeShort(address + offset, value, order.needsSwap);
        // ---------- Original Method ----------
        //Memory.pokeShort(address + offset, value, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.854 -0400", hash_original_method = "0920CC0D2D3BD80AEBDA06397FB42E2F", hash_generated_method = "CA50450ABC308B28960CA23FFB8096C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final short peekShort(int offset, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(offset);
        short var1F66A8A3058E8ADBC1D452124A742F19_1521025983 = (Memory.peekShort(address + offset, order.needsSwap));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Memory.peekShort(address + offset, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.854 -0400", hash_original_method = "8D35A6C129B8973F744F70B17E946D0A", hash_generated_method = "F044379FB4ABA8A39E9728ED407B15BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeInt(int offset, int value, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeInt(address + offset, value, order.needsSwap);
        // ---------- Original Method ----------
        //Memory.pokeInt(address + offset, value, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.854 -0400", hash_original_method = "58058B7ECD1176582A4EF08C49FAC88D", hash_generated_method = "57EA9CE1695551E12DEF2DA5AD2FEABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int peekInt(int offset, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(offset);
        int var66DF98091EA92ADB30FFFE820D3F0B5E_626232370 = (Memory.peekInt(address + offset, order.needsSwap));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Memory.peekInt(address + offset, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.854 -0400", hash_original_method = "398A163C5D40AD88A15B92FCBDCE6284", hash_generated_method = "E2F07B2DCD637166B7921FB101300597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pokeLong(int offset, long value, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeLong(address + offset, value, order.needsSwap);
        // ---------- Original Method ----------
        //Memory.pokeLong(address + offset, value, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.854 -0400", hash_original_method = "11028C0BB53DC88A0A619583FD5A52BA", hash_generated_method = "24838D83232BB99C288BA5237A2C3793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long peekLong(int offset, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(offset);
        long var43562883F7D722A1E7FF059817EB076C_570977823 = (Memory.peekLong(address + offset, order.needsSwap));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return Memory.peekLong(address + offset, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.855 -0400", hash_original_method = "11B5DC04BCE6D59B1BB47A0D96ED6DD0", hash_generated_method = "DC3437E2A3DBF3EABD2A92007737550C")
    @DSModeled(DSC.SAFE)
    public final int toInt() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.855 -0400", hash_original_method = "831AD59EEB851A828F16911921FE25F3", hash_generated_method = "2518A2540AD5395CF5C13038AD1C1ABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String toString() {
        String varB97D970BE3F199B74E18140921609079_1480338407 = (getClass().getName() + "[" + address + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + address + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.855 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "F88E2037B87AE8066F0C3D6F8797D6B9")
    @DSModeled(DSC.SAFE)
    public final long getSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
    private static class MemoryMappedBlock extends MemoryBlock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.855 -0400", hash_original_method = "4FA1675756D2D9224619666C72B7406C", hash_generated_method = "CD794025CB816A4641E6B2F3A9EEABFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private MemoryMappedBlock(int address, long byteCount) {
            super(address, byteCount);
            dsTaint.addTaint(address);
            dsTaint.addTaint(byteCount);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.855 -0400", hash_original_method = "97B49F99737474A4204C8F6662B22F05", hash_generated_method = "DA7FF6292276A5D13DBD67A2E3B48A6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void free() {
            {
                try 
                {
                    Libcore.os.munmap(address, size);
                } //End block
                catch (ErrnoException errnoException)
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
                } //End block
                address = 0;
            } //End block
            // ---------- Original Method ----------
            //if (address != 0) {
                //try {
                    //Libcore.os.munmap(address, size);
                //} catch (ErrnoException errnoException) {
                    //throw new AssertionError(errnoException);
                //}
                //address = 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.855 -0400", hash_original_method = "682006AE60B453BFC574D81B7AB338F6", hash_generated_method = "6DAE24A8C6B904AD51F16D6E3C4A52A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void finalize() throws Throwable {
            free();
            // ---------- Original Method ----------
            //free();
        }

        
    }


    
    private static class NonMovableHeapBlock extends MemoryBlock {
        private byte[] array;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.856 -0400", hash_original_method = "8A7988AD7039E674F46AF68EAF8AE446", hash_generated_method = "5800C7EBAB1ABF651BA5C31F2B692018")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private NonMovableHeapBlock(byte[] array, int address, long byteCount) {
            super(address, byteCount);
            dsTaint.addTaint(address);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(array[0]);
            // ---------- Original Method ----------
            //this.array = array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.856 -0400", hash_original_method = "D17F44ECB38D0894EC4D368C7A4552E2", hash_generated_method = "3D29893FC648840DC8D04CCBF190860C")
        @DSModeled(DSC.SAFE)
        @Override
        public byte[] array() {
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.856 -0400", hash_original_method = "7CD7BC202225C0DF2E4B3C563E9F4089", hash_generated_method = "732E056F3D64E4EBE26E88FEB87054A0")
        @DSModeled(DSC.SAFE)
        @Override
        public void free() {
            array = null;
            address = 0;
            // ---------- Original Method ----------
            //array = null;
            //address = 0;
        }

        
    }


    
    private static class UnmanagedBlock extends MemoryBlock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.856 -0400", hash_original_method = "3FA50BA19E59098968678E710BF90D48", hash_generated_method = "F53E8EA6E7DFD3DBD1B90CF405F7852D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private UnmanagedBlock(int address, long byteCount) {
            super(address, byteCount);
            dsTaint.addTaint(address);
            dsTaint.addTaint(byteCount);
            // ---------- Original Method ----------
        }

        
    }


    
}

