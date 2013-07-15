package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.Memory;

public final class NioBufferIterator extends BufferIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.733 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.733 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.733 -0400", hash_original_field = "F0A1DFDC675B0A14A64099F7AC1CEE83", hash_generated_field = "A6B25CFBA8585537085014684252B717")

    private boolean swap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.733 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.734 -0400", hash_original_method = "1851358DA9BE5B3D125F1A8CE59A39B7", hash_generated_method = "0424634FEE076B20A42B61ECA5D4A252")
      NioBufferIterator(int address, int size, boolean swap) {
        this.address = address;
        this.size = size;
        this.swap = swap;
        // ---------- Original Method ----------
        //this.address = address;
        //this.size = size;
        //this.swap = swap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.734 -0400", hash_original_method = "E36D4B83C08A879BB369FD4BF3E743B5", hash_generated_method = "D66EB936D868E838CC6FBF758BD016A1")
    public void seek(int offset) {
        position = offset;
        // ---------- Original Method ----------
        //position = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.735 -0400", hash_original_method = "5C6BD475B81B38C95ED571F8A0E18EDC", hash_generated_method = "940E96887BCB1FBE664555A63C820A3C")
    public void skip(int byteCount) {
        position += byteCount;
        // ---------- Original Method ----------
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.735 -0400", hash_original_method = "AF50505279F6805CCFBDD6FA7CF3687B", hash_generated_method = "1B3C42FB9872A5DA84CB54FF89C7B26F")
    public void readByteArray(byte[] dst, int dstOffset, int byteCount) {
        addTaint(dstOffset);
        addTaint(dst[0]);
        Memory.peekByteArray(address + position, dst, dstOffset, byteCount);
        position += byteCount;
        // ---------- Original Method ----------
        //Memory.peekByteArray(address + position, dst, dstOffset, byteCount);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.736 -0400", hash_original_method = "47AEAAA269BE342FCE4A8C8B269BAED8", hash_generated_method = "70C02BFDA185887502737D90DB7DF0B9")
    public byte readByte() {
        byte result = Memory.peekByte(address + position);
        ++position;
        byte varB4A88417B3D0170D754C647C30B7216A_1883366273 = (result);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_2041324570 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2041324570;
        // ---------- Original Method ----------
        //byte result = Memory.peekByte(address + position);
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.736 -0400", hash_original_method = "F3BC6F7E073908C181908589CEF0FEA1", hash_generated_method = "B6D82AD2C30A4A8ED96776BFBF0EF372")
    public int readInt() {
        int result = Memory.peekInt(address + position, swap);
        position += SizeOf.INT;
        int varB4A88417B3D0170D754C647C30B7216A_880729049 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197114696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197114696;
        // ---------- Original Method ----------
        //int result = Memory.peekInt(address + position, swap);
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.737 -0400", hash_original_method = "61F99480AF42C401222A5DDE05D611E9", hash_generated_method = "9D264C8747233403E14A7FFCF1C7C4A5")
    public void readIntArray(int[] dst, int dstOffset, int intCount) {
        addTaint(dstOffset);
        addTaint(dst[0]);
        Memory.peekIntArray(address + position, dst, dstOffset, intCount, swap);
        position += SizeOf.INT * intCount;
        // ---------- Original Method ----------
        //Memory.peekIntArray(address + position, dst, dstOffset, intCount, swap);
        //position += SizeOf.INT * intCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.737 -0400", hash_original_method = "34473D83268F7BAA3E1410708A3FD84F", hash_generated_method = "312D537282725E5FF8A735DD4B5F896B")
    public short readShort() {
        short result = Memory.peekShort(address + position, swap);
        position += SizeOf.SHORT;
        short varB4A88417B3D0170D754C647C30B7216A_392692790 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1770016524 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1770016524;
        // ---------- Original Method ----------
        //short result = Memory.peekShort(address + position, swap);
        //position += SizeOf.SHORT;
        //return result;
    }

    
}

