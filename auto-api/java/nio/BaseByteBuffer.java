package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class BaseByteBuffer extends ByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.445 -0400", hash_original_method = "ACB8CCD9F99597647E3D3BC8A43B28AD", hash_generated_method = "80962B6E2D6659E1283C9A3F72EF7459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected BaseByteBuffer(int capacity, MemoryBlock block) {
        super(capacity, block);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.446 -0400", hash_original_method = "80EFC3A1779CF131380EFF26FCE5482E", hash_generated_method = "7A013D345BFDDB084642AC542CFAAB4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final CharBuffer asCharBuffer() {
        CharBuffer var6259CFE263F3A22D4BFD2FB142FCE264_2105180458 = (CharToByteBufferAdapter.asCharBuffer(this));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return CharToByteBufferAdapter.asCharBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.446 -0400", hash_original_method = "676CABDBD56BBA6DBE1153112316712F", hash_generated_method = "5557F12E000B2E3336594912311625B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final DoubleBuffer asDoubleBuffer() {
        DoubleBuffer var701548FE5E4C90AF1F4AE04EAEC55473_1775563909 = (DoubleToByteBufferAdapter.asDoubleBuffer(this));
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return DoubleToByteBufferAdapter.asDoubleBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.446 -0400", hash_original_method = "E6E0734AE3CA82DC17ABAD04A18A214C", hash_generated_method = "005E993DD313A5A923F0BD64BB71F886")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final FloatBuffer asFloatBuffer() {
        FloatBuffer var3EFA688D75AD15A9DB4DFC84E32DDBEC_383405419 = (FloatToByteBufferAdapter.asFloatBuffer(this));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return FloatToByteBufferAdapter.asFloatBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.446 -0400", hash_original_method = "75D241C3AC04B03A5C5326F3F52D5EBD", hash_generated_method = "C84DF18EE7F2BD73EAB5DA331F3913F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final IntBuffer asIntBuffer() {
        IntBuffer var8203E0E215BB26C6E1774E75801C58CF_1618371995 = (IntToByteBufferAdapter.asIntBuffer(this));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return IntToByteBufferAdapter.asIntBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.446 -0400", hash_original_method = "C2685C128BEE4B4F2F0C5CCB69376C4A", hash_generated_method = "F16A8002DFE22ECB4A07F1F8D01BE9E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final LongBuffer asLongBuffer() {
        LongBuffer var98605AF43790A67B4C5BE25386607144_1396733736 = (LongToByteBufferAdapter.asLongBuffer(this));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return LongToByteBufferAdapter.asLongBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.448 -0400", hash_original_method = "8367A215E740624E7DE96EAA789F4593", hash_generated_method = "B228FB43048EF53F405E7A6CF5506A05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ShortBuffer asShortBuffer() {
        ShortBuffer var9C765131BF91173145330B2991FC67A3_1686323452 = (ShortToByteBufferAdapter.asShortBuffer(this));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ShortToByteBufferAdapter.asShortBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.449 -0400", hash_original_method = "306435823B7F4BDA0B79FE4AAC38458D", hash_generated_method = "727DB434647E55EEC7548DA3195DA75F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char getChar() {
        char varC06E01CDF2DC85261301AC1F4A99D747_738434275 = ((char) getShort());
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (char) getShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.449 -0400", hash_original_method = "DB5974BF42C2F1DAF0453A45ABD3A97B", hash_generated_method = "B23F34AF7BAC761026A3B273DADBE030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char getChar(int index) {
        dsTaint.addTaint(index);
        char var98D19085662A7EAD466940526CE82D21_49567865 = ((char) getShort(index));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (char) getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.449 -0400", hash_original_method = "11E610FEEDDA6595692D69FA56D6E79E", hash_generated_method = "9410ADF3543D41BFB0E4A922ED35F64B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(char value) {
        dsTaint.addTaint(value);
        ByteBuffer varF23B672D3F8909E77B831E8AD05E339A_1812963331 = (putShort((short) value));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putShort((short) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.449 -0400", hash_original_method = "7A936B8362BD945536C67F821DC17E9C", hash_generated_method = "079429027AB6D2B91D78EA7DFBC3B68A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(int index, char value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        ByteBuffer var2AB6C79538DED161688BC8E4D576813B_1676460270 = (putShort(index, (short) value));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return putShort(index, (short) value);
    }

    
}

