package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class BaseByteBuffer extends ByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.705 -0400", hash_original_method = "ACB8CCD9F99597647E3D3BC8A43B28AD", hash_generated_method = "4FD7C0754C5303237F85C3EA5D59A578")
    protected  BaseByteBuffer(int capacity, MemoryBlock block) {
        super(capacity, block);
        addTaint(capacity);
        addTaint(block.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.705 -0400", hash_original_method = "80EFC3A1779CF131380EFF26FCE5482E", hash_generated_method = "F4D319CAC4773C8503A2FB96E3C8F66B")
    @Override
    public final CharBuffer asCharBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1497447987 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1497447987 = CharToByteBufferAdapter.asCharBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1497447987.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1497447987;
        // ---------- Original Method ----------
        //return CharToByteBufferAdapter.asCharBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.706 -0400", hash_original_method = "676CABDBD56BBA6DBE1153112316712F", hash_generated_method = "3BBA01E14CC832E9DE84ACF0BC4EC2EF")
    @Override
    public final DoubleBuffer asDoubleBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1355787638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1355787638 = DoubleToByteBufferAdapter.asDoubleBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1355787638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1355787638;
        // ---------- Original Method ----------
        //return DoubleToByteBufferAdapter.asDoubleBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.706 -0400", hash_original_method = "E6E0734AE3CA82DC17ABAD04A18A214C", hash_generated_method = "6310BFD0C56E4B34C09A86538DD0439B")
    @Override
    public final FloatBuffer asFloatBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1013934389 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1013934389 = FloatToByteBufferAdapter.asFloatBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1013934389.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1013934389;
        // ---------- Original Method ----------
        //return FloatToByteBufferAdapter.asFloatBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.707 -0400", hash_original_method = "75D241C3AC04B03A5C5326F3F52D5EBD", hash_generated_method = "77DCD78B6F49E23F20C2EFABCC9B0FCD")
    @Override
    public final IntBuffer asIntBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1317635485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1317635485 = IntToByteBufferAdapter.asIntBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1317635485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1317635485;
        // ---------- Original Method ----------
        //return IntToByteBufferAdapter.asIntBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.707 -0400", hash_original_method = "C2685C128BEE4B4F2F0C5CCB69376C4A", hash_generated_method = "B02B5E657E3150FB0449D8E6DB191150")
    @Override
    public final LongBuffer asLongBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1479237902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1479237902 = LongToByteBufferAdapter.asLongBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1479237902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1479237902;
        // ---------- Original Method ----------
        //return LongToByteBufferAdapter.asLongBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.708 -0400", hash_original_method = "8367A215E740624E7DE96EAA789F4593", hash_generated_method = "E10CE28C6B5E7C5B0C029F68CDA7B319")
    @Override
    public final ShortBuffer asShortBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1142164628 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1142164628 = ShortToByteBufferAdapter.asShortBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1142164628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1142164628;
        // ---------- Original Method ----------
        //return ShortToByteBufferAdapter.asShortBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.708 -0400", hash_original_method = "306435823B7F4BDA0B79FE4AAC38458D", hash_generated_method = "52CA4EC7DD0C5D6852F35509972D5F67")
    @Override
    public char getChar() {
        char varC06E01CDF2DC85261301AC1F4A99D747_522169346 = ((char) getShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_1002637062 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1002637062;
        // ---------- Original Method ----------
        //return (char) getShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.708 -0400", hash_original_method = "DB5974BF42C2F1DAF0453A45ABD3A97B", hash_generated_method = "FC52CE014883E0CC74FBB971CB19FA56")
    @Override
    public char getChar(int index) {
        char var98D19085662A7EAD466940526CE82D21_131922832 = ((char) getShort(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1702291405 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1702291405;
        // ---------- Original Method ----------
        //return (char) getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.709 -0400", hash_original_method = "11E610FEEDDA6595692D69FA56D6E79E", hash_generated_method = "6E2C70C9D53E767E89CED198F245697B")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1129788778 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1129788778 = putShort((short) value);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1129788778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1129788778;
        // ---------- Original Method ----------
        //return putShort((short) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.709 -0400", hash_original_method = "7A936B8362BD945536C67F821DC17E9C", hash_generated_method = "B318B9234BF3401CA13FE2361E5486AD")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1889008794 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1889008794 = putShort(index, (short) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1889008794.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1889008794;
        // ---------- Original Method ----------
        //return putShort(index, (short) value);
    }

    
}

