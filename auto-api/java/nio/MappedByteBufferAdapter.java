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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.778 -0400", hash_original_method = "47B29CB1ACCF161EBA65518E27011CFA", hash_generated_method = "E97EF60937168FDF0F2A670EEE6C499B")
    private  MappedByteBufferAdapter(ByteBuffer buffer) {
        super(buffer);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.778 -0400", hash_original_method = "A963FFF21E3D96B3784CF402E671AE24", hash_generated_method = "E4F4140C016EDEE4D4F809C31E25625E")
    public  MappedByteBufferAdapter(MemoryBlock block, int capacity, int offset, MapMode mode) {
        super(block, capacity, offset, mode);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        addTaint(block.getTaint());
        addTaint(capacity);
        addTaint(offset);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.778 -0400", hash_original_method = "E1DE3F7336A5099D6DE2B8D867AB9894", hash_generated_method = "986A6B5E68F0A2B3B7848EB4A7E8B1B6")
    @Override
     void limitImpl(int newLimit) {
        super.limitImpl(newLimit);
        wrapped.limit(newLimit);
        addTaint(newLimit);
        // ---------- Original Method ----------
        //super.limitImpl(newLimit);
        //wrapped.limit(newLimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.779 -0400", hash_original_method = "3B95D10870BE74C82FCFC1DC24594CC6", hash_generated_method = "2E20B046D03B7CA15068B439F5D27DFB")
    @Override
     void positionImpl(int newPosition) {
        super.positionImpl(newPosition);
        wrapped.position(newPosition);
        addTaint(newPosition);
        // ---------- Original Method ----------
        //super.positionImpl(newPosition);
        //wrapped.position(newPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.779 -0400", hash_original_method = "16DB3977E6E6674C6B8A606792D70852", hash_generated_method = "1631987AD753C6FC68954FB1BD85B0D8")
    @Override
    public CharBuffer asCharBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1660762021 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1660762021 = wrapped.asCharBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1660762021.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1660762021;
        // ---------- Original Method ----------
        //return wrapped.asCharBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.793 -0400", hash_original_method = "4EAAB0CE80265C0EB48FD990BC824325", hash_generated_method = "1DF59DAD22464981B0E7BE74624FEE3A")
    @Override
    public DoubleBuffer asDoubleBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1111268963 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1111268963 = wrapped.asDoubleBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1111268963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1111268963;
        // ---------- Original Method ----------
        //return wrapped.asDoubleBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.805 -0400", hash_original_method = "FE99D2936DE991C171CA2FD8AF39C092", hash_generated_method = "CE3A9ED9814FCEF2496A4E2D72793F13")
    @Override
    public FloatBuffer asFloatBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_852860886 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_852860886 = wrapped.asFloatBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_852860886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_852860886;
        // ---------- Original Method ----------
        //return wrapped.asFloatBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.806 -0400", hash_original_method = "0CB92AC22BFEFF23C733A6090C26E78E", hash_generated_method = "355BCCE5417FBB8D5EDACE9503A50D1C")
    @Override
    public IntBuffer asIntBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1995089075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1995089075 = wrapped.asIntBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1995089075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1995089075;
        // ---------- Original Method ----------
        //return wrapped.asIntBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.806 -0400", hash_original_method = "FC44E930DB5733336E808BE2E2538E0C", hash_generated_method = "755D369CC241CC8DD1339290EA68F5D1")
    @Override
    public LongBuffer asLongBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1846593691 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1846593691 = wrapped.asLongBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1846593691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1846593691;
        // ---------- Original Method ----------
        //return wrapped.asLongBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.807 -0400", hash_original_method = "ACAB46F9C018F1F70B47C0B4E03416FC", hash_generated_method = "7327D2EB5DE459C56C9AE41269CF7EFE")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_994312061 = null; //Variable for return #1
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_994312061 = result;
        varB4EAC82CA7396A68D541C85D26508E83_994312061.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_994312061;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.820 -0400", hash_original_method = "DCD002F56CDE29837C0F9152CB84740D", hash_generated_method = "06743DE268FB52902C7F0659C91B5C32")
    @Override
    public ShortBuffer asShortBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_98703107 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_98703107 = wrapped.asShortBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_98703107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_98703107;
        // ---------- Original Method ----------
        //return wrapped.asShortBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.821 -0400", hash_original_method = "F239FF4C13A02315015A1C80B161EA9F", hash_generated_method = "FB86A34A86CD877076C4DF010D791341")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_163170128 = null; //Variable for return #1
        {
            boolean varDC8EF2821996F2F059CAD4060C326AFB_1594218175 = (wrapped.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        wrapped.compact();
        limit(capacity);
        position(wrapped.position());
        this.mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_163170128 = this;
        varB4EAC82CA7396A68D541C85D26508E83_163170128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_163170128;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.822 -0400", hash_original_method = "A3F0B36DB279BC65C52492277F56F581", hash_generated_method = "79E05EBF0CEF2BA8C8EDB83C6DC4141A")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_652583141 = null; //Variable for return #1
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.duplicate());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_652583141 = result;
        varB4EAC82CA7396A68D541C85D26508E83_652583141.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_652583141;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.822 -0400", hash_original_method = "8F272C1A8EF5C2D42C170CDE0D21CB4E", hash_generated_method = "700D50C13C31579A2E833FBF7A629EF1")
    @Override
    public byte get() {
        wrapped.position(position);
        byte result;
        result = wrapped.get();
        byte var40EA57D3EE3C07BF1C102B466E1C3091_257192567 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_257192567;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //byte result = wrapped.get();
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.823 -0400", hash_original_method = "F734D03FE2C441FAD76B9624A65B1714", hash_generated_method = "3BF73E3387FED51A5567822769CFFCE7")
    @Override
    public byte get(int index) {
        byte varFE4A1C0A821877EBF58C49F410944748_276752377 = (wrapped.get(index));
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1190427669 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1190427669;
        // ---------- Original Method ----------
        //return wrapped.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.823 -0400", hash_original_method = "D869A1EAE1BFFDE9353D5FA2C49CA99A", hash_generated_method = "16A9047DF2F73C0C06837C8AACA2CD13")
    @Override
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_385154309 = null; //Variable for return #1
        ByteBuffer result;
        result = wrapped.get(dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_385154309 = result;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_385154309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_385154309;
        // ---------- Original Method ----------
        //ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        //position += byteCount;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.824 -0400", hash_original_method = "2FE76624FCFB4F7CC6C4D2300FE53EF3", hash_generated_method = "9F3252EBF5ABFF8C959043901F03047F")
    @Override
    public char getChar() {
        wrapped.position(position);
        char result;
        result = wrapped.getChar();
        position += SizeOf.CHAR;
        char varA87DEB01C5F539E6BDA34829C8EF2368_1674337244 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1674337244;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //char result = wrapped.getChar();
        //position += SizeOf.CHAR;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.825 -0400", hash_original_method = "ADD75E9B5B4606F5A583D8492B5A4C8C", hash_generated_method = "B8D054DABFE02548CAC12DA4C7043C75")
    @Override
    public char getChar(int index) {
        char var76ECBB1853D7D302BA82A0387DB176DC_1966122630 = (wrapped.getChar(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1840320820 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1840320820;
        // ---------- Original Method ----------
        //return wrapped.getChar(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.840 -0400", hash_original_method = "A4F231D6AA8D7666BF0B0BDD4770C6A9", hash_generated_method = "113C364059DC428B6474DEE00D1A060E")
    @Override
    public double getDouble() {
        wrapped.position(position);
        double result;
        result = wrapped.getDouble();
        position += SizeOf.DOUBLE;
        double varE8CD7DA078A86726031AD64F35F5A6C0_1705066150 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1705066150;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //double result = wrapped.getDouble();
        //position += SizeOf.DOUBLE;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.845 -0400", hash_original_method = "F25BBF5399281D05028250314F004C1E", hash_generated_method = "810D3D1D46202E03D47A8C505BC2B8DF")
    @Override
    public double getDouble(int index) {
        double varF1695710A32235F7D63DA5316B877FF4_1791466542 = (wrapped.getDouble(index));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_457503931 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_457503931;
        // ---------- Original Method ----------
        //return wrapped.getDouble(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.846 -0400", hash_original_method = "DBE8B29AB435A86755ECBD575D997ADF", hash_generated_method = "A1E9DD514F734B05B393BE854F247DC9")
    @Override
    public float getFloat() {
        wrapped.position(position);
        float result;
        result = wrapped.getFloat();
        position += SizeOf.FLOAT;
        float var546ADE640B6EDFBC8A086EF31347E768_302525454 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_302525454;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //float result = wrapped.getFloat();
        //position += SizeOf.FLOAT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.846 -0400", hash_original_method = "0906B1C4D33749C43BCEE5B8E752E76D", hash_generated_method = "A22BA089DD8A4E14B8D7F3288B6F9A6C")
    @Override
    public float getFloat(int index) {
        float var583F4AB6BAE893C265892DF76111890F_1716487315 = (wrapped.getFloat(index));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1744543532 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1744543532;
        // ---------- Original Method ----------
        //return wrapped.getFloat(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.847 -0400", hash_original_method = "4A2D99413F2A1EA23914893A0D64A22A", hash_generated_method = "FB26DC9DA29828695572228395F27A2F")
    @Override
    public int getInt() {
        wrapped.position(position);
        int result;
        result = wrapped.getInt();
        position += SizeOf.INT;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725428079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725428079;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //int result = wrapped.getInt();
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.847 -0400", hash_original_method = "E9A2A300C7F13DE6F6D61CD16FA4E2B8", hash_generated_method = "85DA0EB31A032E8AE01E04499AB8C759")
    @Override
    public int getInt(int index) {
        int var70F50CA3E48D011662ADE5E5BC0996C2_19483070 = (wrapped.getInt(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897739352 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897739352;
        // ---------- Original Method ----------
        //return wrapped.getInt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.847 -0400", hash_original_method = "EE6ECFBB8B1B6D50C6781665A4A35BBE", hash_generated_method = "26B5C4F0A25D7257851A2FF8F49B6C80")
    @Override
    public long getLong() {
        wrapped.position(position);
        long result;
        result = wrapped.getLong();
        position += SizeOf.LONG;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_313185696 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_313185696;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //long result = wrapped.getLong();
        //position += SizeOf.LONG;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.850 -0400", hash_original_method = "1A9B308246D4E3F438CE0D7CC24303AD", hash_generated_method = "340C765A1C6BA479B602A3BE127A6F05")
    @Override
    public long getLong(int index) {
        long varEB7E04F4D6F253B65CFADFA2EE3332FC_2022762539 = (wrapped.getLong(index));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1374899466 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1374899466;
        // ---------- Original Method ----------
        //return wrapped.getLong(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.851 -0400", hash_original_method = "28282D3504D6176EF20C83AE63ADB452", hash_generated_method = "5E2B9145396A3A6F65ADE1145A01E096")
    @Override
    public short getShort() {
        wrapped.position(position);
        short result;
        result = wrapped.getShort();
        position += SizeOf.SHORT;
        short var4F09DAA9D95BCB166A302407A0E0BABE_182906488 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_182906488;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //short result = wrapped.getShort();
        //position += SizeOf.SHORT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.851 -0400", hash_original_method = "9C6E629DA45EA36A1B8A70FEF740CC74", hash_generated_method = "32831A564E2334AEED7DFFA1F983D324")
    @Override
    public short getShort(int index) {
        short varC6902BC62EB65AA743BA49AAB6DE2B17_1027027564 = (wrapped.getShort(index));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_895705951 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_895705951;
        // ---------- Original Method ----------
        //return wrapped.getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.851 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "7727C9E51233F882F0A077BFC4082630")
    @Override
    public boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1744170237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1744170237;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.854 -0400", hash_original_method = "40C309BCA720C1771AB2C0DB5B2CC056", hash_generated_method = "98D3DAE896AB23C84112F07B1F8BD896")
    @Override
    public boolean isReadOnly() {
        boolean var49D0DFB058540E26126BCAC9F0668C11_2058977097 = (wrapped.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537327483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_537327483;
        // ---------- Original Method ----------
        //return wrapped.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.855 -0400", hash_original_method = "D8FBBAF3DBEC96335348C23D9CEFF5FC", hash_generated_method = "942D98C6B85D28A85C129C9832B3DA08")
    @Override
     void orderImpl(ByteOrder byteOrder) {
        super.orderImpl(byteOrder);
        wrapped.order(byteOrder);
        addTaint(byteOrder.getTaint());
        // ---------- Original Method ----------
        //super.orderImpl(byteOrder);
        //wrapped.order(byteOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.855 -0400", hash_original_method = "85F2FC4404251BEDB97DBE6FD4061990", hash_generated_method = "0A2A5B328971780D697B1FAE86FFA799")
    @Override
    public ByteBuffer put(byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1542309202 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(b);
        varB4EAC82CA7396A68D541C85D26508E83_1542309202 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1542309202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542309202;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(b);
        //this.position++;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.857 -0400", hash_original_method = "3CD6CCD46828403CA377B176C2D2822D", hash_generated_method = "890DD719D1D41138E5CC523F39A5E6AB")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_361184439 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(src, srcOffset, byteCount);
        this.position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_361184439 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_361184439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_361184439;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(src, srcOffset, byteCount);
        //this.position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.876 -0400", hash_original_method = "8C109C00973445D340589478ED9444F1", hash_generated_method = "77EF8939654472D337D0C83BC56476FF")
    @Override
    public ByteBuffer put(int index, byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_763771136 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(index, b);
        varB4EAC82CA7396A68D541C85D26508E83_763771136 = this;
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_763771136.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_763771136;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(index, b);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.881 -0400", hash_original_method = "E9D4840E562C9BED28BC7A127E1FECE3", hash_generated_method = "AC10632399A7E2D0253EC0C986936F96")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_653736727 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putChar(value);
        this.position += SizeOf.CHAR;
        varB4EAC82CA7396A68D541C85D26508E83_653736727 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_653736727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_653736727;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(value);
        //this.position += SizeOf.CHAR;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.883 -0400", hash_original_method = "0D39EC76965D52C2961B502A18570E70", hash_generated_method = "1B7D84AF971C7D8793DF63C526E7EB84")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_609106922 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putChar(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_609106922 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_609106922.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609106922;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.884 -0400", hash_original_method = "3C979C12202FD0F21D9261ACBDF563BC", hash_generated_method = "5EAF71C584C14B48F7364D4415266C3B")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1957542065 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putDouble(value);
        this.position += SizeOf.DOUBLE;
        varB4EAC82CA7396A68D541C85D26508E83_1957542065 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1957542065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1957542065;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(value);
        //this.position += SizeOf.DOUBLE;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.884 -0400", hash_original_method = "E9C430B980A496D01100E970AC4FA364", hash_generated_method = "EFCF6B84AA2CB04F8D1D80A0793B2C49")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_328004400 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putDouble(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_328004400 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_328004400.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328004400;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.885 -0400", hash_original_method = "18B49E50A3711B71082812403EE33F26", hash_generated_method = "D5958305DA0A9D014D89E61127990CAC")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1470846458 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putFloat(value);
        this.position += SizeOf.FLOAT;
        varB4EAC82CA7396A68D541C85D26508E83_1470846458 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1470846458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470846458;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(value);
        //this.position += SizeOf.FLOAT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.885 -0400", hash_original_method = "CF3942EC3FCFAED188350B48958C21EB", hash_generated_method = "EF4EA0FA41A5C8E7EAAD70228DAC791A")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_670190264 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putFloat(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_670190264 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_670190264.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_670190264;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.886 -0400", hash_original_method = "488E6CF540077CB262C06D0E20AEF594", hash_generated_method = "86C33B743365B1F5C228EC0A5E29F741")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_933647589 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putInt(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_933647589 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_933647589.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_933647589;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.886 -0400", hash_original_method = "B61E2BCE20718AB5D9F89E85EFF0C1EE", hash_generated_method = "2FC8E50EE1DF3368423D5AB74FB682EC")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_168385738 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putInt(value);
        this.position += SizeOf.INT;
        varB4EAC82CA7396A68D541C85D26508E83_168385738 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_168385738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_168385738;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(value);
        //this.position += SizeOf.INT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.914 -0400", hash_original_method = "71459AF6B6AC0C4B26EB70F2F396DC3A", hash_generated_method = "0520FD5048FD1E84E70C786DC2A856DC")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1219991148 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putLong(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1219991148 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1219991148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219991148;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.915 -0400", hash_original_method = "1118E0528407DB1AA30DD23367DFDBDC", hash_generated_method = "562CC163DEB2CF6E1819471056FA5BAC")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_11028167 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putLong(value);
        this.position += SizeOf.LONG;
        varB4EAC82CA7396A68D541C85D26508E83_11028167 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_11028167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11028167;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(value);
        //this.position += SizeOf.LONG;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.915 -0400", hash_original_method = "5B51CDEBF6AB573576FFED982377810B", hash_generated_method = "04F82C5C13BAE865C6BE9201E639802C")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_90146090 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putShort(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_90146090 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_90146090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90146090;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.916 -0400", hash_original_method = "EB14AF156A87035F01282D29F445B16B", hash_generated_method = "4F5B6EE88A977CF136CDE31727C3A911")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_488354648 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putShort(value);
        this.position += SizeOf.SHORT;
        varB4EAC82CA7396A68D541C85D26508E83_488354648 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_488354648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_488354648;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(value);
        //this.position += SizeOf.SHORT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.916 -0400", hash_original_method = "6E049AFA213C3C5078EB6770A9689DFA", hash_generated_method = "B2A8F722E5C7E84F4F022D7CB9420F2A")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2015210399 = null; //Variable for return #1
        wrapped.position(this.position);
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.slice());
        wrapped.clear();
        varB4EAC82CA7396A68D541C85D26508E83_2015210399 = result;
        varB4EAC82CA7396A68D541C85D26508E83_2015210399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015210399;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        //wrapped.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.922 -0400", hash_original_method = "33CDC6092C78EAE8E1726040ED7707B5", hash_generated_method = "63A199DCF85C169E7116FC39E813B3BB")
    @Override
     byte[] protectedArray() {
        byte[] varB32035EFAFDB5C8550949E6F1C3C11C7_1844247410 = (wrapped.protectedArray());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_395241497 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_395241497;
        // ---------- Original Method ----------
        //return wrapped.protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.922 -0400", hash_original_method = "07409272224D2DCFB9ED6864BAB477CC", hash_generated_method = "65ACC1FAA5177C6689AA29734EB7013E")
    @Override
     int protectedArrayOffset() {
        int var4123A6B3CA7E4599E7545E9209CB3C28_670405817 = (wrapped.protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936418072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936418072;
        // ---------- Original Method ----------
        //return wrapped.protectedArrayOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.929 -0400", hash_original_method = "088F278FB6BC57CD2CF8BD7E84B85911", hash_generated_method = "2D3C9B4651CC06302D3856E37DBA1D8A")
    @Override
     boolean protectedHasArray() {
        boolean var79038B0DD03771BCEBDB4CD9DA4BEDBC_200633521 = (wrapped.protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970481447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_970481447;
        // ---------- Original Method ----------
        //return wrapped.protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.929 -0400", hash_original_method = "845658F397739B9672DA207B5DA44048", hash_generated_method = "8D4028D33946A70E90568622E65CD09C")
    public final void free() {
        wrapped.free();
        // ---------- Original Method ----------
        //wrapped.free();
    }

    
}

