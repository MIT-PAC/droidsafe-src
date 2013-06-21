package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.channels.FileChannel.MapMode;
import libcore.io.SizeOf;

final class MappedByteBufferAdapter extends MappedByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.829 -0400", hash_original_method = "47B29CB1ACCF161EBA65518E27011CFA", hash_generated_method = "3B45CC01B789B6FC29B2FB22324C6026")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private MappedByteBufferAdapter(ByteBuffer buffer) {
        super(buffer);
        dsTaint.addTaint(buffer.dsTaint);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.829 -0400", hash_original_method = "A963FFF21E3D96B3784CF402E671AE24", hash_generated_method = "36C4F02365EC674AB9F3426FE09A44C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MappedByteBufferAdapter(MemoryBlock block, int capacity, int offset, MapMode mode) {
        super(block, capacity, offset, mode);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(mode.dsTaint);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.830 -0400", hash_original_method = "E1DE3F7336A5099D6DE2B8D867AB9894", hash_generated_method = "12DE5363A7EDF73C641CA2AC9AE89C93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void limitImpl(int newLimit) {
        dsTaint.addTaint(newLimit);
        super.limitImpl(newLimit);
        wrapped.limit(newLimit);
        // ---------- Original Method ----------
        //super.limitImpl(newLimit);
        //wrapped.limit(newLimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.830 -0400", hash_original_method = "3B95D10870BE74C82FCFC1DC24594CC6", hash_generated_method = "0A46BC1FDC06ABC3A8EA5139C97CB4D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void positionImpl(int newPosition) {
        dsTaint.addTaint(newPosition);
        super.positionImpl(newPosition);
        wrapped.position(newPosition);
        // ---------- Original Method ----------
        //super.positionImpl(newPosition);
        //wrapped.position(newPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.830 -0400", hash_original_method = "16DB3977E6E6674C6B8A606792D70852", hash_generated_method = "5F2134AC5E43E0DAA654E9667C5745EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer asCharBuffer() {
        CharBuffer var651C8E3FD589502AD7FBDD82F54F004A_1989256570 = (wrapped.asCharBuffer());
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.asCharBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.830 -0400", hash_original_method = "4EAAB0CE80265C0EB48FD990BC824325", hash_generated_method = "A97056988AC2C4EA4B54864980D7B851")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DoubleBuffer asDoubleBuffer() {
        DoubleBuffer var30B56CFFCC337E2C2A368E8022C64D4F_1848179334 = (wrapped.asDoubleBuffer());
        return (DoubleBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.asDoubleBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.830 -0400", hash_original_method = "FE99D2936DE991C171CA2FD8AF39C092", hash_generated_method = "4F1A83F9495E97751D3222CCE2D554FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer asFloatBuffer() {
        FloatBuffer var84AEA83664651C5FC3E570039ECA248A_1665187818 = (wrapped.asFloatBuffer());
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.asFloatBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.830 -0400", hash_original_method = "0CB92AC22BFEFF23C733A6090C26E78E", hash_generated_method = "C2CF06C73005800BF499346065E76097")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public IntBuffer asIntBuffer() {
        IntBuffer var0DBC4C90C1B9E5570E0B8B7D986FCB58_931774742 = (wrapped.asIntBuffer());
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.asIntBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.831 -0400", hash_original_method = "FC44E930DB5733336E808BE2E2538E0C", hash_generated_method = "9837769DAB252BC9CA02F6176CB24998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer asLongBuffer() {
        LongBuffer varADF511B074EB937D28AE61EE63DE2901_282261121 = (wrapped.asLongBuffer());
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.asLongBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.831 -0400", hash_original_method = "ACAB46F9C018F1F70B47C0B4E03416FC", hash_generated_method = "3E62B6A446FCD95B9CFC77C0D7CC119E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.831 -0400", hash_original_method = "DCD002F56CDE29837C0F9152CB84740D", hash_generated_method = "E03C84455497ED4AE4E25F10320ECB90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer asShortBuffer() {
        ShortBuffer varB5E19B20995D70F5312D3480178E89F0_470345106 = (wrapped.asShortBuffer());
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.asShortBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.831 -0400", hash_original_method = "F239FF4C13A02315015A1C80B161EA9F", hash_generated_method = "C062FDCBCF613EEDD76F7A0DB9F8E6A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer compact() {
        {
            boolean varDC8EF2821996F2F059CAD4060C326AFB_450741884 = (wrapped.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        wrapped.compact();
        limit(capacity);
        position(wrapped.position());
        this.mark = UNSET_MARK;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (wrapped.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //wrapped.compact();
        //limit(capacity);
        //position(wrapped.position());
        //this.mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.831 -0400", hash_original_method = "A3F0B36DB279BC65C52492277F56F581", hash_generated_method = "50D9336BA6C87415B1EBB5EFBD082CE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer duplicate() {
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.duplicate());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.831 -0400", hash_original_method = "8F272C1A8EF5C2D42C170CDE0D21CB4E", hash_generated_method = "1819AB575BEFB87CC30CD03BDB219FE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte get() {
        wrapped.position(position);
        byte result;
        result = wrapped.get();
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //wrapped.position(position);
        //byte result = wrapped.get();
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.832 -0400", hash_original_method = "F734D03FE2C441FAD76B9624A65B1714", hash_generated_method = "F25EE9A2F712DADD1EC4E0FDE1F8B027")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte get(int index) {
        dsTaint.addTaint(index);
        byte varFE4A1C0A821877EBF58C49F410944748_661278934 = (wrapped.get(index));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return wrapped.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.832 -0400", hash_original_method = "D869A1EAE1BFFDE9353D5FA2C49CA99A", hash_generated_method = "993288AD187F5512B085B142ECE103EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        ByteBuffer result;
        result = wrapped.get(dst, dstOffset, byteCount);
        position += byteCount;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        //position += byteCount;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.832 -0400", hash_original_method = "2FE76624FCFB4F7CC6C4D2300FE53EF3", hash_generated_method = "130131653BC995604A99CDE6245A52F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char getChar() {
        wrapped.position(position);
        char result;
        result = wrapped.getChar();
        position += SizeOf.CHAR;
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //wrapped.position(position);
        //char result = wrapped.getChar();
        //position += SizeOf.CHAR;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.832 -0400", hash_original_method = "ADD75E9B5B4606F5A583D8492B5A4C8C", hash_generated_method = "5373E82FB5324BF6E807F9493341A9AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public char getChar(int index) {
        dsTaint.addTaint(index);
        char var76ECBB1853D7D302BA82A0387DB176DC_1012187557 = (wrapped.getChar(index));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return wrapped.getChar(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.832 -0400", hash_original_method = "A4F231D6AA8D7666BF0B0BDD4770C6A9", hash_generated_method = "71E1FD2FA8B50BC79DAB9EB08BEF2BD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double getDouble() {
        wrapped.position(position);
        double result;
        result = wrapped.getDouble();
        position += SizeOf.DOUBLE;
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //wrapped.position(position);
        //double result = wrapped.getDouble();
        //position += SizeOf.DOUBLE;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.832 -0400", hash_original_method = "F25BBF5399281D05028250314F004C1E", hash_generated_method = "081D9A873029D1BE37A938C77D0DC263")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double getDouble(int index) {
        dsTaint.addTaint(index);
        double varF1695710A32235F7D63DA5316B877FF4_1553416917 = (wrapped.getDouble(index));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return wrapped.getDouble(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.833 -0400", hash_original_method = "DBE8B29AB435A86755ECBD575D997ADF", hash_generated_method = "B87C349DABA019343036D98671B0F0CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float getFloat() {
        wrapped.position(position);
        float result;
        result = wrapped.getFloat();
        position += SizeOf.FLOAT;
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //wrapped.position(position);
        //float result = wrapped.getFloat();
        //position += SizeOf.FLOAT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.833 -0400", hash_original_method = "0906B1C4D33749C43BCEE5B8E752E76D", hash_generated_method = "8A0C061694A8DF02B52F847DFC411CB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float getFloat(int index) {
        dsTaint.addTaint(index);
        float var583F4AB6BAE893C265892DF76111890F_1514128841 = (wrapped.getFloat(index));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return wrapped.getFloat(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.833 -0400", hash_original_method = "4A2D99413F2A1EA23914893A0D64A22A", hash_generated_method = "0BE3B4844FA5740D87B227F93EEAC5D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getInt() {
        wrapped.position(position);
        int result;
        result = wrapped.getInt();
        position += SizeOf.INT;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //wrapped.position(position);
        //int result = wrapped.getInt();
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.833 -0400", hash_original_method = "E9A2A300C7F13DE6F6D61CD16FA4E2B8", hash_generated_method = "6AD310302D382A160D46418E1B02421B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getInt(int index) {
        dsTaint.addTaint(index);
        int var70F50CA3E48D011662ADE5E5BC0996C2_1295450847 = (wrapped.getInt(index));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.getInt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.833 -0400", hash_original_method = "EE6ECFBB8B1B6D50C6781665A4A35BBE", hash_generated_method = "DBCC3BE77641E944AE1CFF7A507AEDFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getLong() {
        wrapped.position(position);
        long result;
        result = wrapped.getLong();
        position += SizeOf.LONG;
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //wrapped.position(position);
        //long result = wrapped.getLong();
        //position += SizeOf.LONG;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.833 -0400", hash_original_method = "1A9B308246D4E3F438CE0D7CC24303AD", hash_generated_method = "A27583C861538B848255ADB368D60678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getLong(int index) {
        dsTaint.addTaint(index);
        long varEB7E04F4D6F253B65CFADFA2EE3332FC_76249430 = (wrapped.getLong(index));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return wrapped.getLong(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.834 -0400", hash_original_method = "28282D3504D6176EF20C83AE63ADB452", hash_generated_method = "95436608C5A834A4394CBEBE202BC1EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short getShort() {
        wrapped.position(position);
        short result;
        result = wrapped.getShort();
        position += SizeOf.SHORT;
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //wrapped.position(position);
        //short result = wrapped.getShort();
        //position += SizeOf.SHORT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.834 -0400", hash_original_method = "9C6E629DA45EA36A1B8A70FEF740CC74", hash_generated_method = "3E3B384A4FA0550E2A99486AD05B3287")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short getShort(int index) {
        dsTaint.addTaint(index);
        short varC6902BC62EB65AA743BA49AAB6DE2B17_1657714180 = (wrapped.getShort(index));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return wrapped.getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.834 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "4ECBE0FD358E64762C0A413E289A46AA")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.834 -0400", hash_original_method = "40C309BCA720C1771AB2C0DB5B2CC056", hash_generated_method = "8C8904B4ACD16ED8CC6D4615EAD357ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isReadOnly() {
        boolean var49D0DFB058540E26126BCAC9F0668C11_551830159 = (wrapped.isReadOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return wrapped.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.834 -0400", hash_original_method = "D8FBBAF3DBEC96335348C23D9CEFF5FC", hash_generated_method = "7CD942E688AA27207E7F7E4222C3CAD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void orderImpl(ByteOrder byteOrder) {
        dsTaint.addTaint(byteOrder.dsTaint);
        super.orderImpl(byteOrder);
        wrapped.order(byteOrder);
        // ---------- Original Method ----------
        //super.orderImpl(byteOrder);
        //wrapped.order(byteOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.834 -0400", hash_original_method = "85F2FC4404251BEDB97DBE6FD4061990", hash_generated_method = "BE1F8AC2D9FD9CEB9CB946B8D081F8B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte b) {
        dsTaint.addTaint(b);
        wrapped.position(this.position);
        wrapped.put(b);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(b);
        //this.position++;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.834 -0400", hash_original_method = "3CD6CCD46828403CA377B176C2D2822D", hash_generated_method = "5FA84CE4C4452777250A3BF96571798A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        wrapped.position(this.position);
        wrapped.put(src, srcOffset, byteCount);
        this.position += byteCount;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(src, srcOffset, byteCount);
        //this.position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.835 -0400", hash_original_method = "8C109C00973445D340589478ED9444F1", hash_generated_method = "D205DB1F1FEFEA64F69189DAEDE796D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer put(int index, byte b) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(b);
        wrapped.position(this.position);
        wrapped.put(index, b);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(index, b);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.835 -0400", hash_original_method = "E9D4840E562C9BED28BC7A127E1FECE3", hash_generated_method = "7C485649678199ED464A51049D7E835E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(char value) {
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putChar(value);
        this.position += SizeOf.CHAR;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(value);
        //this.position += SizeOf.CHAR;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.835 -0400", hash_original_method = "0D39EC76965D52C2961B502A18570E70", hash_generated_method = "B5AD18D41BA38AAC83F8F86F93550614")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putChar(int index, char value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putChar(index, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.835 -0400", hash_original_method = "3C979C12202FD0F21D9261ACBDF563BC", hash_generated_method = "12E0193EB5F0DB9D47ACE4CAE912B6D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(double value) {
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putDouble(value);
        this.position += SizeOf.DOUBLE;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(value);
        //this.position += SizeOf.DOUBLE;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.835 -0400", hash_original_method = "E9C430B980A496D01100E970AC4FA364", hash_generated_method = "71E5303216B6DEFA0349B5DD006D7264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putDouble(int index, double value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putDouble(index, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.836 -0400", hash_original_method = "18B49E50A3711B71082812403EE33F26", hash_generated_method = "5ED44D7DB404B90699A54DD21B9EE9AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(float value) {
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putFloat(value);
        this.position += SizeOf.FLOAT;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(value);
        //this.position += SizeOf.FLOAT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.836 -0400", hash_original_method = "CF3942EC3FCFAED188350B48958C21EB", hash_generated_method = "ED973ACE833646F01F8332DE4705977F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putFloat(int index, float value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putFloat(index, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.836 -0400", hash_original_method = "488E6CF540077CB262C06D0E20AEF594", hash_generated_method = "B3792346F37FDAE9AC91CF80650A8102")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int index, int value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putInt(index, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.836 -0400", hash_original_method = "B61E2BCE20718AB5D9F89E85EFF0C1EE", hash_generated_method = "9B250161151E5FCBF54B88ABBB59F64D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putInt(int value) {
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putInt(value);
        this.position += SizeOf.INT;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(value);
        //this.position += SizeOf.INT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.836 -0400", hash_original_method = "71459AF6B6AC0C4B26EB70F2F396DC3A", hash_generated_method = "F4D7BB83A17EE21E487DBFB0AF557739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(int index, long value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putLong(index, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.836 -0400", hash_original_method = "1118E0528407DB1AA30DD23367DFDBDC", hash_generated_method = "13C6AADA02E90158C1CE330EC5371E63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putLong(long value) {
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putLong(value);
        this.position += SizeOf.LONG;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(value);
        //this.position += SizeOf.LONG;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.836 -0400", hash_original_method = "5B51CDEBF6AB573576FFED982377810B", hash_generated_method = "AD9A0F97A4779CFE0F54A5CC6EADF4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(int index, short value) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putShort(index, value);
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.837 -0400", hash_original_method = "EB14AF156A87035F01282D29F445B16B", hash_generated_method = "6A04CFCE7FD41717D205B61E5F737E3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer putShort(short value) {
        dsTaint.addTaint(value);
        wrapped.position(this.position);
        wrapped.putShort(value);
        this.position += SizeOf.SHORT;
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(value);
        //this.position += SizeOf.SHORT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.837 -0400", hash_original_method = "6E049AFA213C3C5078EB6770A9689DFA", hash_generated_method = "6FFDC9A8A7C51EC63C06DB0E98C637D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteBuffer slice() {
        wrapped.position(this.position);
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.slice());
        wrapped.clear();
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        //wrapped.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.837 -0400", hash_original_method = "33CDC6092C78EAE8E1726040ED7707B5", hash_generated_method = "AC9848C42E807FF40B393AD0FD8B87F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     byte[] protectedArray() {
        byte[] varB32035EFAFDB5C8550949E6F1C3C11C7_1455739683 = (wrapped.protectedArray());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return wrapped.protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.837 -0400", hash_original_method = "07409272224D2DCFB9ED6864BAB477CC", hash_generated_method = "6205F7C65E096609F4472707B0AE312E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     int protectedArrayOffset() {
        int var4123A6B3CA7E4599E7545E9209CB3C28_262498392 = (wrapped.protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.protectedArrayOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.837 -0400", hash_original_method = "088F278FB6BC57CD2CF8BD7E84B85911", hash_generated_method = "83269C2EF9600055EA8DF7A964BDF43F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     boolean protectedHasArray() {
        boolean var79038B0DD03771BCEBDB4CD9DA4BEDBC_2137581477 = (wrapped.protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return wrapped.protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.837 -0400", hash_original_method = "845658F397739B9672DA207B5DA44048", hash_generated_method = "8D4028D33946A70E90568622E65CD09C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void free() {
        wrapped.free();
        // ---------- Original Method ----------
        //wrapped.free();
    }

    
}

