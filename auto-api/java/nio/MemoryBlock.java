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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.366 -0400", hash_original_method = "2736B0514B2AB4564F5D7D5517308E00", hash_generated_method = "3ECA452523CD2D384407164F18C32177")
    @DSModeled(DSC.SAFE)
    private MemoryBlock(int address, long size) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //this.address = address;
        //this.size = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.375 -0400", hash_original_method = "BBFC8D551652AD3EEF096B28F6078288", hash_generated_method = "78B0A4FA3EF4379A2CC68B557F598DDB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.377 -0400", hash_original_method = "56DDFE22DC488A83D33875899E9EA40C", hash_generated_method = "1A4EC581E24D29DE1AC751CFCF7A8D37")
    public static MemoryBlock allocate(int byteCount) {
        VMRuntime runtime = VMRuntime.getRuntime();
        byte[] array = (byte[]) runtime.newNonMovableArray(byte.class, byteCount);
        int address = (int) runtime.addressOf(array);
        return new NonMovableHeapBlock(array, address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.379 -0400", hash_original_method = "35A857D419D4DD178A91B9DC653CB6CB", hash_generated_method = "C35D34EE174DF64CEE7DF59F264603C5")
    public static MemoryBlock wrapFromJni(int address, long byteCount) {
        return new UnmanagedBlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.380 -0400", hash_original_method = "0474BFDE3AD81DCD66C16B9CD0EF394B", hash_generated_method = "3BEBC339D8C9AD106480E5CFEC1A84A9")
    @DSModeled(DSC.SAFE)
    public byte[] array() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.381 -0400", hash_original_method = "DAA4200658B56FF77DA7170F747BB7D3", hash_generated_method = "0077E89192A01C4AEE3117D147E3976F")
    @DSModeled(DSC.SAFE)
    public void free() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.383 -0400", hash_original_method = "630226707094FE04DBFFAB9271C599A8", hash_generated_method = "0FA9001AC4B363DECAF26225A3355429")
    @DSModeled(DSC.SAFE)
    public final void pokeByte(int offset, byte value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeByte(address + offset, value);
        // ---------- Original Method ----------
        //Memory.pokeByte(address + offset, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.384 -0400", hash_original_method = "8A47EAE86C2A9467630864AB102835A2", hash_generated_method = "EA0E29918FF7EA9F6AC9734AF2561638")
    @DSModeled(DSC.SAFE)
    public final void pokeByteArray(int offset, byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(offset);
        Memory.pokeByteArray(address + offset, src, srcOffset, byteCount);
        // ---------- Original Method ----------
        //Memory.pokeByteArray(address + offset, src, srcOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.386 -0400", hash_original_method = "6974150101D3DDA95DB00B1670D11C6B", hash_generated_method = "6BA3C94DD9C95BECC79FBC2D5BE855B4")
    @DSModeled(DSC.SAFE)
    public final void pokeCharArray(int offset, char[] src, int srcOffset, int charCount, boolean swap) {
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        Memory.pokeCharArray(address + offset, src, srcOffset, charCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeCharArray(address + offset, src, srcOffset, charCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.387 -0400", hash_original_method = "E9019E6CD21CE2C41575FF8901B1AFF2", hash_generated_method = "F3A919DDAD3E67D934CC35F5459ADC89")
    @DSModeled(DSC.SAFE)
    public final void pokeDoubleArray(int offset, double[] src, int srcOffset, int doubleCount, boolean swap) {
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.pokeDoubleArray(address + offset, src, srcOffset, doubleCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeDoubleArray(address + offset, src, srcOffset, doubleCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.395 -0400", hash_original_method = "9D3F9CE96F95038259BD55C552E41A3C", hash_generated_method = "888C33A0D1716CA95E9247A05DB0BEC9")
    @DSModeled(DSC.SAFE)
    public final void pokeFloatArray(int offset, float[] src, int srcOffset, int floatCount, boolean swap) {
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(floatCount);
        Memory.pokeFloatArray(address + offset, src, srcOffset, floatCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeFloatArray(address + offset, src, srcOffset, floatCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.398 -0400", hash_original_method = "E86D1C192084CE5F4375F94D842F71F2", hash_generated_method = "A1BF4ACE046033AAA63FF4E3609FAE55")
    @DSModeled(DSC.SAFE)
    public final void pokeIntArray(int offset, int[] src, int srcOffset, int intCount, boolean swap) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.pokeIntArray(address + offset, src, srcOffset, intCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeIntArray(address + offset, src, srcOffset, intCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.401 -0400", hash_original_method = "7C81AB7339C181A8CFBE849C39505C24", hash_generated_method = "0910CD67644C1C46AF2305D600AB6A2D")
    @DSModeled(DSC.SAFE)
    public final void pokeLongArray(int offset, long[] src, int srcOffset, int longCount, boolean swap) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.pokeLongArray(address + offset, src, srcOffset, longCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeLongArray(address + offset, src, srcOffset, longCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.402 -0400", hash_original_method = "827B6834AFFDD22123FD738883080EAC", hash_generated_method = "EB29015F1A60C6C61EC4CA444B6EB3AF")
    @DSModeled(DSC.SAFE)
    public final void pokeShortArray(int offset, short[] src, int srcOffset, int shortCount, boolean swap) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.pokeShortArray(address + offset, src, srcOffset, shortCount, swap);
        // ---------- Original Method ----------
        //Memory.pokeShortArray(address + offset, src, srcOffset, shortCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.404 -0400", hash_original_method = "1735C3DE737C57C440010EE24811D905", hash_generated_method = "B229BF03A7CD3EC973FF08D7D6C32E9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte peekByte(int offset) {
        dsTaint.addTaint(offset);
        byte var0D439E36464350F65C32534D25795783_1331946498 = (Memory.peekByte(address + offset));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return Memory.peekByte(address + offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.406 -0400", hash_original_method = "4AA3FF18895191EE003F1A2CE1825900", hash_generated_method = "66018EC4103608A33FBAEED385831B50")
    @DSModeled(DSC.SAFE)
    public final void peekByteArray(int offset, byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(offset);
        Memory.peekByteArray(address + offset, dst, dstOffset, byteCount);
        // ---------- Original Method ----------
        //Memory.peekByteArray(address + offset, dst, dstOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.407 -0400", hash_original_method = "EBF1D5FEEAB6D77B374DCE8330CD224F", hash_generated_method = "265D740763AF24E8FB4FF0D69DA0C26A")
    @DSModeled(DSC.SAFE)
    public final void peekCharArray(int offset, char[] dst, int dstOffset, int charCount, boolean swap) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(charCount);
        Memory.peekCharArray(address + offset, dst, dstOffset, charCount, swap);
        // ---------- Original Method ----------
        //Memory.peekCharArray(address + offset, dst, dstOffset, charCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.409 -0400", hash_original_method = "BFC40CE5A86066650B16C5DDA370D477", hash_generated_method = "0BD3B433A884CCF074084F8469268A47")
    @DSModeled(DSC.SAFE)
    public final void peekDoubleArray(int offset, double[] dst, int dstOffset, int doubleCount, boolean swap) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(doubleCount);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.peekDoubleArray(address + offset, dst, dstOffset, doubleCount, swap);
        // ---------- Original Method ----------
        //Memory.peekDoubleArray(address + offset, dst, dstOffset, doubleCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.411 -0400", hash_original_method = "EAD8AA573222624562CA66AD98451BFE", hash_generated_method = "C439A8EFC6197ABEEBDC88AD15591D84")
    @DSModeled(DSC.SAFE)
    public final void peekFloatArray(int offset, float[] dst, int dstOffset, int floatCount, boolean swap) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(floatCount);
        Memory.peekFloatArray(address + offset, dst, dstOffset, floatCount, swap);
        // ---------- Original Method ----------
        //Memory.peekFloatArray(address + offset, dst, dstOffset, floatCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.412 -0400", hash_original_method = "4844D3E54BA100CE6DA11493B506DD6A", hash_generated_method = "4AA83B3E12CDF84556A10486E657F908")
    @DSModeled(DSC.SAFE)
    public final void peekIntArray(int offset, int[] dst, int dstOffset, int intCount, boolean swap) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.peekIntArray(address + offset, dst, dstOffset, intCount, swap);
        // ---------- Original Method ----------
        //Memory.peekIntArray(address + offset, dst, dstOffset, intCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.414 -0400", hash_original_method = "F2861F288E908F83CFD8FF4C109C3272", hash_generated_method = "3B9E636C35D0D9182A5F08FD286F75FB")
    @DSModeled(DSC.SAFE)
    public final void peekLongArray(int offset, long[] dst, int dstOffset, int longCount, boolean swap) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.peekLongArray(address + offset, dst, dstOffset, longCount, swap);
        // ---------- Original Method ----------
        //Memory.peekLongArray(address + offset, dst, dstOffset, longCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.416 -0400", hash_original_method = "8A16C923F98D3483F90AB5F32524148E", hash_generated_method = "71749C7BC4498FEE791775A6705A07EE")
    @DSModeled(DSC.SAFE)
    public final void peekShortArray(int offset, short[] dst, int dstOffset, int shortCount, boolean swap) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(offset);
        Memory.peekShortArray(address + offset, dst, dstOffset, shortCount, swap);
        // ---------- Original Method ----------
        //Memory.peekShortArray(address + offset, dst, dstOffset, shortCount, swap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.417 -0400", hash_original_method = "444716504DAB9ACCA4E2D3B12DD0CCBB", hash_generated_method = "F7F60A0119E360A361521B8FF80C97C4")
    @DSModeled(DSC.SAFE)
    public final void pokeShort(int offset, short value, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeShort(address + offset, value, order.needsSwap);
        // ---------- Original Method ----------
        //Memory.pokeShort(address + offset, value, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.419 -0400", hash_original_method = "0920CC0D2D3BD80AEBDA06397FB42E2F", hash_generated_method = "B1913083541A79CF99433015ACD7F58A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final short peekShort(int offset, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(offset);
        short var1F66A8A3058E8ADBC1D452124A742F19_634737514 = (Memory.peekShort(address + offset, order.needsSwap));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Memory.peekShort(address + offset, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.422 -0400", hash_original_method = "8D35A6C129B8973F744F70B17E946D0A", hash_generated_method = "22646D0E80CD238DA2134DE3DE030543")
    @DSModeled(DSC.SAFE)
    public final void pokeInt(int offset, int value, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeInt(address + offset, value, order.needsSwap);
        // ---------- Original Method ----------
        //Memory.pokeInt(address + offset, value, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.425 -0400", hash_original_method = "58058B7ECD1176582A4EF08C49FAC88D", hash_generated_method = "3DF1DBB2CD20D4E780C346AE6FB9499C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int peekInt(int offset, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(offset);
        int var66DF98091EA92ADB30FFFE820D3F0B5E_1765744655 = (Memory.peekInt(address + offset, order.needsSwap));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Memory.peekInt(address + offset, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.426 -0400", hash_original_method = "398A163C5D40AD88A15B92FCBDCE6284", hash_generated_method = "C8C36D8DE21ACD9B5721AF51E8E172C7")
    @DSModeled(DSC.SAFE)
    public final void pokeLong(int offset, long value, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(value);
        dsTaint.addTaint(offset);
        Memory.pokeLong(address + offset, value, order.needsSwap);
        // ---------- Original Method ----------
        //Memory.pokeLong(address + offset, value, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.429 -0400", hash_original_method = "11028C0BB53DC88A0A619583FD5A52BA", hash_generated_method = "6DDB03D3E77EEC2D9E3E8371FBB9656F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long peekLong(int offset, ByteOrder order) {
        dsTaint.addTaint(order.dsTaint);
        dsTaint.addTaint(offset);
        long var43562883F7D722A1E7FF059817EB076C_536875440 = (Memory.peekLong(address + offset, order.needsSwap));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return Memory.peekLong(address + offset, order.needsSwap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.430 -0400", hash_original_method = "11B5DC04BCE6D59B1BB47A0D96ED6DD0", hash_generated_method = "56702A49A770561429075F0B10D6843E")
    @DSModeled(DSC.SAFE)
    public final int toInt() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.432 -0400", hash_original_method = "831AD59EEB851A828F16911921FE25F3", hash_generated_method = "B8A1268B47E096E34F460760CF1308FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String toString() {
        String varB97D970BE3F199B74E18140921609079_1334661255 = (getClass().getName() + "[" + address + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + address + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.439 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "DEF0660E1F6B8220578D6F67AE5A870D")
    @DSModeled(DSC.SAFE)
    public final long getSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
    private static class MemoryMappedBlock extends MemoryBlock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.440 -0400", hash_original_method = "4FA1675756D2D9224619666C72B7406C", hash_generated_method = "A5DA44D6D8A82266F968D67D483E129E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private MemoryMappedBlock(int address, long byteCount) {
            super(address, byteCount);
            dsTaint.addTaint(address);
            dsTaint.addTaint(byteCount);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.442 -0400", hash_original_method = "97B49F99737474A4204C8F6662B22F05", hash_generated_method = "971ABB066F1DF0DD831E995372C045C2")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.443 -0400", hash_original_method = "682006AE60B453BFC574D81B7AB338F6", hash_generated_method = "09C28AC786CA95D159AE209F0D860654")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            free();
            // ---------- Original Method ----------
            //free();
        }

        
    }


    
    private static class NonMovableHeapBlock extends MemoryBlock {
        private byte[] array;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.450 -0400", hash_original_method = "8A7988AD7039E674F46AF68EAF8AE446", hash_generated_method = "3DB08623CFFAE19C7B13D8B95A9D367A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private NonMovableHeapBlock(byte[] array, int address, long byteCount) {
            super(address, byteCount);
            dsTaint.addTaint(address);
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(array);
            // ---------- Original Method ----------
            //this.array = array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.452 -0400", hash_original_method = "D17F44ECB38D0894EC4D368C7A4552E2", hash_generated_method = "F118EECBF9BBD816916613D295850F0C")
        @DSModeled(DSC.SAFE)
        @Override
        public byte[] array() {
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.453 -0400", hash_original_method = "7CD7BC202225C0DF2E4B3C563E9F4089", hash_generated_method = "806A4AD0EE0BB2083D0468D067D11364")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.455 -0400", hash_original_method = "3FA50BA19E59098968678E710BF90D48", hash_generated_method = "903F05BF55AAD69830A0FF43D735452C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private UnmanagedBlock(int address, long byteCount) {
            super(address, byteCount);
            dsTaint.addTaint(address);
            dsTaint.addTaint(byteCount);
            // ---------- Original Method ----------
        }

        
    }


    
}


