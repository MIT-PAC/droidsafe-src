package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.MAP_PRIVATE;
import static libcore.io.OsConstants.MAP_SHARED;
import static libcore.io.OsConstants.PROT_READ;
import static libcore.io.OsConstants.PROT_WRITE;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel.MapMode;

import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.Memory;
import dalvik.system.VMRuntime;

public class MemoryBlock {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.581 -0500", hash_original_method = "BBFC8D551652AD3EEF096B28F6078288", hash_generated_method = "53AC51F00CCC1D4BC33D48CC3566EB3D")
    
public static MemoryBlock mmap(FileDescriptor fd, long offset, long size, MapMode mapMode) throws IOException {
        if (size == 0) {
            // You can't mmap(2) a zero-length region, but Java allows it.
            return new MemoryBlock(0, 0);
        }
        // Check just those errors mmap(2) won't detect.
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
        } else { // mapMode == MapMode.READ_WRITE
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.584 -0500", hash_original_method = "56DDFE22DC488A83D33875899E9EA40C", hash_generated_method = "1A4EC581E24D29DE1AC751CFCF7A8D37")
    
public static MemoryBlock allocate(int byteCount) {
        VMRuntime runtime = VMRuntime.getRuntime();
        byte[] array = (byte[]) runtime.newNonMovableArray(byte.class, byteCount);
        int address = (int) runtime.addressOf(array);
        return new NonMovableHeapBlock(array, address, byteCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.587 -0500", hash_original_method = "35A857D419D4DD178A91B9DC653CB6CB", hash_generated_method = "C35D34EE174DF64CEE7DF59F264603C5")
    
public static MemoryBlock wrapFromJni(int address, long byteCount) {
        return new UnmanagedBlock(address, byteCount);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.575 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "2E3B00925A9AD8CC3173924CFBB7B9E6")

    protected int address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.578 -0500", hash_original_field = "298A39EB1E059FD1DCE8DF5205BAB3E6", hash_generated_field = "5E81D8D2490BCBC78886FD1ADC5D8740")

    protected  long size;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.589 -0500", hash_original_method = "2736B0514B2AB4564F5D7D5517308E00", hash_generated_method = "895DABAE3F84982D3ABFD9EFBBE405E3")
    
private MemoryBlock(int address, long size) {
        this.address = address;
        this.size = size;
    }

    // Used to support array/arrayOffset/hasArray for direct buffers.
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.592 -0500", hash_original_method = "0474BFDE3AD81DCD66C16B9CD0EF394B", hash_generated_method = "56CDDF1385663904FB336DC08D59208F")
    
public byte[] array() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.595 -0500", hash_original_method = "DAA4200658B56FF77DA7170F747BB7D3", hash_generated_method = "84E671943960861460418CB39152CB16")
    
public void free() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.597 -0500", hash_original_method = "630226707094FE04DBFFAB9271C599A8", hash_generated_method = "6D809200A3DCE1F7B8F852875767D7B2")
    
public final void pokeByte(int offset, byte value) {
        Memory.pokeByte(address + offset, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.600 -0500", hash_original_method = "8A47EAE86C2A9467630864AB102835A2", hash_generated_method = "3AC4A8F248CDAC504288D0D0ECD42A64")
    
public final void pokeByteArray(int offset, byte[] src, int srcOffset, int byteCount) {
        Memory.pokeByteArray(address + offset, src, srcOffset, byteCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.636 -0500", hash_original_method = "6974150101D3DDA95DB00B1670D11C6B", hash_generated_method = "504A5E497CCFD53178B3ED4CE056361A")
    
public final void pokeCharArray(int offset, char[] src, int srcOffset, int charCount, boolean swap) {
        Memory.pokeCharArray(address + offset, src, srcOffset, charCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.641 -0500", hash_original_method = "E9019E6CD21CE2C41575FF8901B1AFF2", hash_generated_method = "9F1C02F6EF527AF9FE882E011D2AF090")
    
public final void pokeDoubleArray(int offset, double[] src, int srcOffset, int doubleCount, boolean swap) {
        Memory.pokeDoubleArray(address + offset, src, srcOffset, doubleCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.645 -0500", hash_original_method = "9D3F9CE96F95038259BD55C552E41A3C", hash_generated_method = "AC2F976C3C5D71A8EDFA2FDBC890A0B1")
    
public final void pokeFloatArray(int offset, float[] src, int srcOffset, int floatCount, boolean swap) {
        Memory.pokeFloatArray(address + offset, src, srcOffset, floatCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.649 -0500", hash_original_method = "E86D1C192084CE5F4375F94D842F71F2", hash_generated_method = "2E2BA7E4485A4740044B2F8D810C6B77")
    
public final void pokeIntArray(int offset, int[] src, int srcOffset, int intCount, boolean swap) {
        Memory.pokeIntArray(address + offset, src, srcOffset, intCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.654 -0500", hash_original_method = "7C81AB7339C181A8CFBE849C39505C24", hash_generated_method = "475F1EE709289CBBD74A00E777305A6A")
    
public final void pokeLongArray(int offset, long[] src, int srcOffset, int longCount, boolean swap) {
        Memory.pokeLongArray(address + offset, src, srcOffset, longCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.659 -0500", hash_original_method = "827B6834AFFDD22123FD738883080EAC", hash_generated_method = "2A941BA55462079F7C1451DE5A66F05C")
    
public final void pokeShortArray(int offset, short[] src, int srcOffset, int shortCount, boolean swap) {
        Memory.pokeShortArray(address + offset, src, srcOffset, shortCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.662 -0500", hash_original_method = "1735C3DE737C57C440010EE24811D905", hash_generated_method = "8D310713A5A3806065186662FFCE381A")
    
public final byte peekByte(int offset) {
        return Memory.peekByte(address + offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.666 -0500", hash_original_method = "4AA3FF18895191EE003F1A2CE1825900", hash_generated_method = "5A583A880D8A7ECB3EFD4121A172BD0F")
    
public final void peekByteArray(int offset, byte[] dst, int dstOffset, int byteCount) {
        Memory.peekByteArray(address + offset, dst, dstOffset, byteCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.670 -0500", hash_original_method = "EBF1D5FEEAB6D77B374DCE8330CD224F", hash_generated_method = "7A2E48F4F694D24ACC71EBD5CEEF5779")
    
public final void peekCharArray(int offset, char[] dst, int dstOffset, int charCount, boolean swap) {
        Memory.peekCharArray(address + offset, dst, dstOffset, charCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.674 -0500", hash_original_method = "BFC40CE5A86066650B16C5DDA370D477", hash_generated_method = "A0C75E195B256DBA63C565155F95D9C1")
    
public final void peekDoubleArray(int offset, double[] dst, int dstOffset, int doubleCount, boolean swap) {
        Memory.peekDoubleArray(address + offset, dst, dstOffset, doubleCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.677 -0500", hash_original_method = "EAD8AA573222624562CA66AD98451BFE", hash_generated_method = "BF64B4D516D7633C111493F69C38F00C")
    
public final void peekFloatArray(int offset, float[] dst, int dstOffset, int floatCount, boolean swap) {
        Memory.peekFloatArray(address + offset, dst, dstOffset, floatCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.682 -0500", hash_original_method = "4844D3E54BA100CE6DA11493B506DD6A", hash_generated_method = "B352E485B6C7CADA4B996266AA34A656")
    
public final void peekIntArray(int offset, int[] dst, int dstOffset, int intCount, boolean swap) {
        Memory.peekIntArray(address + offset, dst, dstOffset, intCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.686 -0500", hash_original_method = "F2861F288E908F83CFD8FF4C109C3272", hash_generated_method = "BE66FE7BA6E0D67034B35E1669CF424B")
    
public final void peekLongArray(int offset, long[] dst, int dstOffset, int longCount, boolean swap) {
        Memory.peekLongArray(address + offset, dst, dstOffset, longCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.691 -0500", hash_original_method = "8A16C923F98D3483F90AB5F32524148E", hash_generated_method = "1742C7F0C06A89491F0C43575113AECF")
    
public final void peekShortArray(int offset, short[] dst, int dstOffset, int shortCount, boolean swap) {
        Memory.peekShortArray(address + offset, dst, dstOffset, shortCount, swap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.695 -0500", hash_original_method = "444716504DAB9ACCA4E2D3B12DD0CCBB", hash_generated_method = "94F82BEBA7A89D31E3DB97E4ADF2E32C")
    
public final void pokeShort(int offset, short value, ByteOrder order) {
        Memory.pokeShort(address + offset, value, order.needsSwap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.699 -0500", hash_original_method = "0920CC0D2D3BD80AEBDA06397FB42E2F", hash_generated_method = "62B678E88856B19DA3EA06D69C01A5F5")
    
public final short peekShort(int offset, ByteOrder order) {
        return Memory.peekShort(address + offset, order.needsSwap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.703 -0500", hash_original_method = "8D35A6C129B8973F744F70B17E946D0A", hash_generated_method = "6831B2422278E843EC3CEF84378DF61E")
    
public final void pokeInt(int offset, int value, ByteOrder order) {
        Memory.pokeInt(address + offset, value, order.needsSwap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.707 -0500", hash_original_method = "58058B7ECD1176582A4EF08C49FAC88D", hash_generated_method = "7C0C4A46EE5E2BEC932B53BE20586DF7")
    
public final int peekInt(int offset, ByteOrder order) {
        return Memory.peekInt(address + offset, order.needsSwap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.711 -0500", hash_original_method = "398A163C5D40AD88A15B92FCBDCE6284", hash_generated_method = "66B91ABCAB7C64CF10B31AA7212C5EBA")
    
public final void pokeLong(int offset, long value, ByteOrder order) {
        Memory.pokeLong(address + offset, value, order.needsSwap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.715 -0500", hash_original_method = "11028C0BB53DC88A0A619583FD5A52BA", hash_generated_method = "43475FC4DDA638AABCF8C59818F32C36")
    
public final long peekLong(int offset, ByteOrder order) {
        return Memory.peekLong(address + offset, order.needsSwap);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.718 -0500", hash_original_method = "11B5DC04BCE6D59B1BB47A0D96ED6DD0", hash_generated_method = "7BD64E1867FEA6950727C48A7D0B6D44")
    
public final int toInt() {
        return address;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.722 -0500", hash_original_method = "831AD59EEB851A828F16911921FE25F3", hash_generated_method = "635987D0F5BB37EE5B983D4F8465673A")
    
public final String toString() {
        return getClass().getName() + "[" + address + "]";
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.726 -0500", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "5BE0CBEF2D6C72C3611828559F4A0E5F")
    
public final long getSize() {
        return size;
    }
    
    private static class MemoryMappedBlock extends MemoryBlock {
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.547 -0500", hash_original_method = "4FA1675756D2D9224619666C72B7406C", hash_generated_method = "4D2AEDD1DBA920621345704854C9A78E")
        
private MemoryMappedBlock(int address, long byteCount) {
            super(address, byteCount);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.550 -0500", hash_original_method = "97B49F99737474A4204C8F6662B22F05", hash_generated_method = "DBDE826F488AF413BC73700BF723B8BC")
        
@Override public void free() {
            if (address != 0) {
                try {
                    Libcore.os.munmap(address, size);
                } catch (ErrnoException errnoException) {
                    // The RI doesn't throw, presumably on the assumption that you can't get into
                    // a state where munmap(2) could return an error.
                    throw new AssertionError(errnoException);
                }
                address = 0;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.553 -0500", hash_original_method = "682006AE60B453BFC574D81B7AB338F6", hash_generated_method = "0C02CDB7A5599DFD54C4DD9B1F422FEF")
        
@Override protected void finalize() throws Throwable {
            free();
        }
        
    }
    
    private static class NonMovableHeapBlock extends MemoryBlock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.558 -0500", hash_original_field = "69A2529F36E7342616D51635092704F7", hash_generated_field = "9AF64BC00BB5D51223FCF5D879F8268F")

        private byte[] array;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.561 -0500", hash_original_method = "8A7988AD7039E674F46AF68EAF8AE446", hash_generated_method = "2AFD7BF182B722CA09632A7E191624C6")
        
private NonMovableHeapBlock(byte[] array, int address, long byteCount) {
            super(address, byteCount);
            this.array = array;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.563 -0500", hash_original_method = "D17F44ECB38D0894EC4D368C7A4552E2", hash_generated_method = "610FC94A7BA68ABC123A09941C0E33EE")
        
@Override public byte[] array() {
            return array;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.566 -0500", hash_original_method = "7CD7BC202225C0DF2E4B3C563E9F4089", hash_generated_method = "0C9AD01862ADA3A71011ABC72DFE22AD")
        
@Override public void free() {
            array = null;
            address = 0;
        }
        
    }
    
    private static class UnmanagedBlock extends MemoryBlock {
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:54.571 -0500", hash_original_method = "3FA50BA19E59098968678E710BF90D48", hash_generated_method = "EFCCC746EA157D42714603255D748B72")
        
private UnmanagedBlock(int address, long byteCount) {
            super(address, byteCount);
        }
        
    }
    
}

