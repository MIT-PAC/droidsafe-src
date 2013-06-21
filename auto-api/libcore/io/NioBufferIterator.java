package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.Memory;

public final class NioBufferIterator extends BufferIterator {
    private int address;
    private int size;
    private boolean swap;
    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.966 -0400", hash_original_method = "1851358DA9BE5B3D125F1A8CE59A39B7", hash_generated_method = "2898CA8E87D2F3698B7EDE812CD22313")
    @DSModeled(DSC.SAFE)
     NioBufferIterator(int address, int size, boolean swap) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(swap);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //this.address = address;
        //this.size = size;
        //this.swap = swap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.966 -0400", hash_original_method = "E36D4B83C08A879BB369FD4BF3E743B5", hash_generated_method = "F8B859F1E52FD5E547C55C87002C7508")
    @DSModeled(DSC.SAFE)
    public void seek(int offset) {
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //position = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.966 -0400", hash_original_method = "5C6BD475B81B38C95ED571F8A0E18EDC", hash_generated_method = "9905B39D257D33824B56812EDA1528CB")
    @DSModeled(DSC.SAFE)
    public void skip(int byteCount) {
        dsTaint.addTaint(byteCount);
        // ---------- Original Method ----------
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.966 -0400", hash_original_method = "AF50505279F6805CCFBDD6FA7CF3687B", hash_generated_method = "E7D659EE40FC7741DA952F1BC641BE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readByteArray(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        Memory.peekByteArray(address + position, dst, dstOffset, byteCount);
        // ---------- Original Method ----------
        //Memory.peekByteArray(address + position, dst, dstOffset, byteCount);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.966 -0400", hash_original_method = "47AEAAA269BE342FCE4A8C8B269BAED8", hash_generated_method = "11534438BB23D8D860D16309CCBE03E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte readByte() {
        byte result;
        result = Memory.peekByte(address + position);
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //byte result = Memory.peekByte(address + position);
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.967 -0400", hash_original_method = "F3BC6F7E073908C181908589CEF0FEA1", hash_generated_method = "128B45236067B30837B6DE18797356D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readInt() {
        int result;
        result = Memory.peekInt(address + position, swap);
        position += SizeOf.INT;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = Memory.peekInt(address + position, swap);
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.967 -0400", hash_original_method = "61F99480AF42C401222A5DDE05D611E9", hash_generated_method = "CCF0F2461792F3C1D73311065F618CC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readIntArray(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        Memory.peekIntArray(address + position, dst, dstOffset, intCount, swap);
        position += SizeOf.INT * intCount;
        // ---------- Original Method ----------
        //Memory.peekIntArray(address + position, dst, dstOffset, intCount, swap);
        //position += SizeOf.INT * intCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.967 -0400", hash_original_method = "34473D83268F7BAA3E1410708A3FD84F", hash_generated_method = "9C4734884F18E9DD59F4305B17B59160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short readShort() {
        short result;
        result = Memory.peekShort(address + position, swap);
        position += SizeOf.SHORT;
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //short result = Memory.peekShort(address + position, swap);
        //position += SizeOf.SHORT;
        //return result;
    }

    
}

