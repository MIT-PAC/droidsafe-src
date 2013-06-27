package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class BaseByteBuffer extends ByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.716 -0400", hash_original_method = "ACB8CCD9F99597647E3D3BC8A43B28AD", hash_generated_method = "4FD7C0754C5303237F85C3EA5D59A578")
    protected  BaseByteBuffer(int capacity, MemoryBlock block) {
        super(capacity, block);
        addTaint(capacity);
        addTaint(block.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.720 -0400", hash_original_method = "80EFC3A1779CF131380EFF26FCE5482E", hash_generated_method = "8ACCEF17FA17431575AB9E472B55EAE2")
    @Override
    public final CharBuffer asCharBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1511605274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1511605274 = CharToByteBufferAdapter.asCharBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1511605274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1511605274;
        // ---------- Original Method ----------
        //return CharToByteBufferAdapter.asCharBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.723 -0400", hash_original_method = "676CABDBD56BBA6DBE1153112316712F", hash_generated_method = "7027934E77CB8EF17F0759A4B9CA065C")
    @Override
    public final DoubleBuffer asDoubleBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1987772163 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1987772163 = DoubleToByteBufferAdapter.asDoubleBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1987772163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1987772163;
        // ---------- Original Method ----------
        //return DoubleToByteBufferAdapter.asDoubleBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.723 -0400", hash_original_method = "E6E0734AE3CA82DC17ABAD04A18A214C", hash_generated_method = "FFCBDDC8CF57610C743E581C84FC3B62")
    @Override
    public final FloatBuffer asFloatBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_582794726 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_582794726 = FloatToByteBufferAdapter.asFloatBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_582794726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582794726;
        // ---------- Original Method ----------
        //return FloatToByteBufferAdapter.asFloatBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.724 -0400", hash_original_method = "75D241C3AC04B03A5C5326F3F52D5EBD", hash_generated_method = "B7ED5705058E4A8A6BBE288A93E30C31")
    @Override
    public final IntBuffer asIntBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1533085493 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1533085493 = IntToByteBufferAdapter.asIntBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1533085493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1533085493;
        // ---------- Original Method ----------
        //return IntToByteBufferAdapter.asIntBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.724 -0400", hash_original_method = "C2685C128BEE4B4F2F0C5CCB69376C4A", hash_generated_method = "6F66BC23673901886FC5DE5AC71ECB7D")
    @Override
    public final LongBuffer asLongBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1262635882 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1262635882 = LongToByteBufferAdapter.asLongBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1262635882.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1262635882;
        // ---------- Original Method ----------
        //return LongToByteBufferAdapter.asLongBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.742 -0400", hash_original_method = "8367A215E740624E7DE96EAA789F4593", hash_generated_method = "DE2497E1AB0400184E5A6080050B1F4C")
    @Override
    public final ShortBuffer asShortBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_45264185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_45264185 = ShortToByteBufferAdapter.asShortBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_45264185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_45264185;
        // ---------- Original Method ----------
        //return ShortToByteBufferAdapter.asShortBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.742 -0400", hash_original_method = "306435823B7F4BDA0B79FE4AAC38458D", hash_generated_method = "281EB4C820A881D2963D461826833F29")
    @Override
    public char getChar() {
        char varC06E01CDF2DC85261301AC1F4A99D747_287110166 = ((char) getShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_359274189 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_359274189;
        // ---------- Original Method ----------
        //return (char) getShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.742 -0400", hash_original_method = "DB5974BF42C2F1DAF0453A45ABD3A97B", hash_generated_method = "08E98D279F7D574EC5DB20E81B81FDFE")
    @Override
    public char getChar(int index) {
        char var98D19085662A7EAD466940526CE82D21_1622638666 = ((char) getShort(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_78518418 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_78518418;
        // ---------- Original Method ----------
        //return (char) getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.743 -0400", hash_original_method = "11E610FEEDDA6595692D69FA56D6E79E", hash_generated_method = "FB7301E4094BA9FDC71F8F63A9DDCE19")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_503774076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_503774076 = putShort((short) value);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_503774076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_503774076;
        // ---------- Original Method ----------
        //return putShort((short) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.743 -0400", hash_original_method = "7A936B8362BD945536C67F821DC17E9C", hash_generated_method = "DB5094D434ED029EE551C14E8827F2CC")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2128405904 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2128405904 = putShort(index, (short) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2128405904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2128405904;
        // ---------- Original Method ----------
        //return putShort(index, (short) value);
    }

    
}

