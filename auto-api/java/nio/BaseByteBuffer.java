package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class BaseByteBuffer extends ByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.719 -0400", hash_original_method = "ACB8CCD9F99597647E3D3BC8A43B28AD", hash_generated_method = "4FD7C0754C5303237F85C3EA5D59A578")
    protected  BaseByteBuffer(int capacity, MemoryBlock block) {
        super(capacity, block);
        addTaint(capacity);
        addTaint(block.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.719 -0400", hash_original_method = "80EFC3A1779CF131380EFF26FCE5482E", hash_generated_method = "302AB611D81644D6F180F35621F11ED0")
    @Override
    public final CharBuffer asCharBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1020969555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1020969555 = CharToByteBufferAdapter.asCharBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1020969555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1020969555;
        // ---------- Original Method ----------
        //return CharToByteBufferAdapter.asCharBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.720 -0400", hash_original_method = "676CABDBD56BBA6DBE1153112316712F", hash_generated_method = "BA6D1130759271A88C9863147246A0B2")
    @Override
    public final DoubleBuffer asDoubleBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1396717387 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1396717387 = DoubleToByteBufferAdapter.asDoubleBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1396717387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1396717387;
        // ---------- Original Method ----------
        //return DoubleToByteBufferAdapter.asDoubleBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.721 -0400", hash_original_method = "E6E0734AE3CA82DC17ABAD04A18A214C", hash_generated_method = "54E1C80308EFEC8079FF133692FC6571")
    @Override
    public final FloatBuffer asFloatBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1002382514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1002382514 = FloatToByteBufferAdapter.asFloatBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1002382514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1002382514;
        // ---------- Original Method ----------
        //return FloatToByteBufferAdapter.asFloatBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.721 -0400", hash_original_method = "75D241C3AC04B03A5C5326F3F52D5EBD", hash_generated_method = "05DA6CEC7C701F56F79E2D225B9BC715")
    @Override
    public final IntBuffer asIntBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_336861652 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_336861652 = IntToByteBufferAdapter.asIntBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_336861652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_336861652;
        // ---------- Original Method ----------
        //return IntToByteBufferAdapter.asIntBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.721 -0400", hash_original_method = "C2685C128BEE4B4F2F0C5CCB69376C4A", hash_generated_method = "0024A8F590F402778DFC0AA4CB5F940D")
    @Override
    public final LongBuffer asLongBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1576568929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1576568929 = LongToByteBufferAdapter.asLongBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_1576568929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576568929;
        // ---------- Original Method ----------
        //return LongToByteBufferAdapter.asLongBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.722 -0400", hash_original_method = "8367A215E740624E7DE96EAA789F4593", hash_generated_method = "520324A29A9ECF1485D9E307C7166EA0")
    @Override
    public final ShortBuffer asShortBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_2035781847 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2035781847 = ShortToByteBufferAdapter.asShortBuffer(this);
        varB4EAC82CA7396A68D541C85D26508E83_2035781847.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2035781847;
        // ---------- Original Method ----------
        //return ShortToByteBufferAdapter.asShortBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.722 -0400", hash_original_method = "306435823B7F4BDA0B79FE4AAC38458D", hash_generated_method = "9669B93919B20312BEA267144A4B5F0E")
    @Override
    public char getChar() {
        char varC06E01CDF2DC85261301AC1F4A99D747_1602850058 = ((char) getShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_1310768850 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1310768850;
        // ---------- Original Method ----------
        //return (char) getShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.722 -0400", hash_original_method = "DB5974BF42C2F1DAF0453A45ABD3A97B", hash_generated_method = "63FF8EAA0495758027EF23002346E97C")
    @Override
    public char getChar(int index) {
        char var98D19085662A7EAD466940526CE82D21_1524997222 = ((char) getShort(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_505358261 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_505358261;
        // ---------- Original Method ----------
        //return (char) getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.732 -0400", hash_original_method = "11E610FEEDDA6595692D69FA56D6E79E", hash_generated_method = "E4DAB0C39D0715EB1685A10004A2B58C")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1406527510 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1406527510 = putShort((short) value);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1406527510.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1406527510;
        // ---------- Original Method ----------
        //return putShort((short) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.734 -0400", hash_original_method = "7A936B8362BD945536C67F821DC17E9C", hash_generated_method = "B8977FCD7CC29BC6595589F7A95F7854")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_802858725 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_802858725 = putShort(index, (short) value);
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_802858725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_802858725;
        // ---------- Original Method ----------
        //return putShort(index, (short) value);
    }

    
}

