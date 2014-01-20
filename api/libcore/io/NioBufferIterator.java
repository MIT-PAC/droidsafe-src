package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class NioBufferIterator extends BufferIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.321 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private  int address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.323 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private  int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.326 -0500", hash_original_field = "FFB1C6AC308D0B8505CFC89260B9BCC0", hash_generated_field = "A6B25CFBA8585537085014684252B717")

    private  boolean swap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.328 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

    private int position;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.331 -0500", hash_original_method = "1851358DA9BE5B3D125F1A8CE59A39B7", hash_generated_method = "1851358DA9BE5B3D125F1A8CE59A39B7")
    
NioBufferIterator(int address, int size, boolean swap) {
        this.address = address;
        this.size = size;
        this.swap = swap;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.333 -0500", hash_original_method = "E36D4B83C08A879BB369FD4BF3E743B5", hash_generated_method = "89EF647B0FB134CB7088C8FC04ED9705")
    
public void seek(int offset) {
        position = offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.335 -0500", hash_original_method = "5C6BD475B81B38C95ED571F8A0E18EDC", hash_generated_method = "C71B63B55A78ABE126A2084325A3BF14")
    
public void skip(int byteCount) {
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.337 -0500", hash_original_method = "AF50505279F6805CCFBDD6FA7CF3687B", hash_generated_method = "DB43238D94FB9C98B37C7A57F0F0AD8E")
    
public void readByteArray(byte[] dst, int dstOffset, int byteCount) {
        Memory.peekByteArray(address + position, dst, dstOffset, byteCount);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.339 -0500", hash_original_method = "47AEAAA269BE342FCE4A8C8B269BAED8", hash_generated_method = "26558C3EE874AE74D0D9FD70D9B77CD4")
    
public byte readByte() {
        byte result = Memory.peekByte(address + position);
        ++position;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.341 -0500", hash_original_method = "F3BC6F7E073908C181908589CEF0FEA1", hash_generated_method = "B0EF16BF7B855D8211A812EEEB379009")
    
public int readInt() {
        int result = Memory.peekInt(address + position, swap);
        position += SizeOf.INT;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.343 -0500", hash_original_method = "61F99480AF42C401222A5DDE05D611E9", hash_generated_method = "54FDB242BAF74BE6156D1B221057947C")
    
public void readIntArray(int[] dst, int dstOffset, int intCount) {
        Memory.peekIntArray(address + position, dst, dstOffset, intCount, swap);
        position += SizeOf.INT * intCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.346 -0500", hash_original_method = "34473D83268F7BAA3E1410708A3FD84F", hash_generated_method = "93C5F8B85F113B6E980B55887463BB92")
    
public short readShort() {
        short result = Memory.peekShort(address + position, swap);
        position += SizeOf.SHORT;
        return result;
    }
    
}

