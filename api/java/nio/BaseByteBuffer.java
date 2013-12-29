package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;


abstract class BaseByteBuffer extends ByteBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.771 -0500", hash_original_method = "ACB8CCD9F99597647E3D3BC8A43B28AD", hash_generated_method = "559DEE476801E22FC8883C8995691F8A")
    protected BaseByteBuffer(int capacity, MemoryBlock block) {
        super(capacity, block);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.772 -0500", hash_original_method = "80EFC3A1779CF131380EFF26FCE5482E", hash_generated_method = "90157020D27D5619B7076368980FC008")
    @Override
public final CharBuffer asCharBuffer() {
        return CharToByteBufferAdapter.asCharBuffer(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.773 -0500", hash_original_method = "676CABDBD56BBA6DBE1153112316712F", hash_generated_method = "519545DFF1FDACE764946FEB8C5955D1")
    @Override
public final DoubleBuffer asDoubleBuffer() {
        return DoubleToByteBufferAdapter.asDoubleBuffer(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.774 -0500", hash_original_method = "E6E0734AE3CA82DC17ABAD04A18A214C", hash_generated_method = "28FC073F0F7E1A61CD01123494AD6D40")
    @Override
public final FloatBuffer asFloatBuffer() {
        return FloatToByteBufferAdapter.asFloatBuffer(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.775 -0500", hash_original_method = "75D241C3AC04B03A5C5326F3F52D5EBD", hash_generated_method = "237F60B7E70295F41C4C7958F23B71D5")
    @Override
public final IntBuffer asIntBuffer() {
        return IntToByteBufferAdapter.asIntBuffer(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.776 -0500", hash_original_method = "C2685C128BEE4B4F2F0C5CCB69376C4A", hash_generated_method = "F0E138344435BD40BADF58FEB459C8D3")
    @Override
public final LongBuffer asLongBuffer() {
        return LongToByteBufferAdapter.asLongBuffer(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.777 -0500", hash_original_method = "8367A215E740624E7DE96EAA789F4593", hash_generated_method = "5A345A23D69E211900F2EAA391713AF9")
    @Override
public final ShortBuffer asShortBuffer() {
        return ShortToByteBufferAdapter.asShortBuffer(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.777 -0500", hash_original_method = "306435823B7F4BDA0B79FE4AAC38458D", hash_generated_method = "0D8064FA180AF944DF7C552568B33D2A")
    @Override
public char getChar() {
        return (char) getShort();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.778 -0500", hash_original_method = "DB5974BF42C2F1DAF0453A45ABD3A97B", hash_generated_method = "7FB28C5ADDAC33ED7A773252D79D32D1")
    @Override
public char getChar(int index) {
        return (char) getShort(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.779 -0500", hash_original_method = "11E610FEEDDA6595692D69FA56D6E79E", hash_generated_method = "6E078F5B9ED8EEEF18F5993BDFD5E6D0")
    @Override
public ByteBuffer putChar(char value) {
        return putShort((short) value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.780 -0500", hash_original_method = "7A936B8362BD945536C67F821DC17E9C", hash_generated_method = "CF1CD0E1E4441B12731DCD15DED68162")
    @Override
public ByteBuffer putChar(int index, char value) {
        return putShort(index, (short) value);
    }

    
}

