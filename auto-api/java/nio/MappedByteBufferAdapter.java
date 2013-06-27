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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.758 -0400", hash_original_method = "47B29CB1ACCF161EBA65518E27011CFA", hash_generated_method = "E97EF60937168FDF0F2A670EEE6C499B")
    private  MappedByteBufferAdapter(ByteBuffer buffer) {
        super(buffer);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.761 -0400", hash_original_method = "A963FFF21E3D96B3784CF402E671AE24", hash_generated_method = "E4F4140C016EDEE4D4F809C31E25625E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.762 -0400", hash_original_method = "E1DE3F7336A5099D6DE2B8D867AB9894", hash_generated_method = "986A6B5E68F0A2B3B7848EB4A7E8B1B6")
    @Override
     void limitImpl(int newLimit) {
        super.limitImpl(newLimit);
        wrapped.limit(newLimit);
        addTaint(newLimit);
        // ---------- Original Method ----------
        //super.limitImpl(newLimit);
        //wrapped.limit(newLimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.763 -0400", hash_original_method = "3B95D10870BE74C82FCFC1DC24594CC6", hash_generated_method = "2E20B046D03B7CA15068B439F5D27DFB")
    @Override
     void positionImpl(int newPosition) {
        super.positionImpl(newPosition);
        wrapped.position(newPosition);
        addTaint(newPosition);
        // ---------- Original Method ----------
        //super.positionImpl(newPosition);
        //wrapped.position(newPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.763 -0400", hash_original_method = "16DB3977E6E6674C6B8A606792D70852", hash_generated_method = "A6D417D8A424E1450C929556684F57CE")
    @Override
    public CharBuffer asCharBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1512359271 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512359271 = wrapped.asCharBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1512359271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512359271;
        // ---------- Original Method ----------
        //return wrapped.asCharBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.778 -0400", hash_original_method = "4EAAB0CE80265C0EB48FD990BC824325", hash_generated_method = "D9CFE211146A39F58D90F6EA91F1BEDE")
    @Override
    public DoubleBuffer asDoubleBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_928637319 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_928637319 = wrapped.asDoubleBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_928637319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_928637319;
        // ---------- Original Method ----------
        //return wrapped.asDoubleBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.778 -0400", hash_original_method = "FE99D2936DE991C171CA2FD8AF39C092", hash_generated_method = "039BED005AFD507304504F1C912F877D")
    @Override
    public FloatBuffer asFloatBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1093019954 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1093019954 = wrapped.asFloatBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1093019954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1093019954;
        // ---------- Original Method ----------
        //return wrapped.asFloatBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.778 -0400", hash_original_method = "0CB92AC22BFEFF23C733A6090C26E78E", hash_generated_method = "F4B93BFB5BBE9F18D3504CE2D921CAAB")
    @Override
    public IntBuffer asIntBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1917237018 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1917237018 = wrapped.asIntBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1917237018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1917237018;
        // ---------- Original Method ----------
        //return wrapped.asIntBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.779 -0400", hash_original_method = "FC44E930DB5733336E808BE2E2538E0C", hash_generated_method = "D57A00BD090EEC23239A571866DFFE17")
    @Override
    public LongBuffer asLongBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1786666044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1786666044 = wrapped.asLongBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1786666044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1786666044;
        // ---------- Original Method ----------
        //return wrapped.asLongBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.786 -0400", hash_original_method = "ACAB46F9C018F1F70B47C0B4E03416FC", hash_generated_method = "5888EBD9919FA578DD91DF9E09EFBAB5")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2054593633 = null; //Variable for return #1
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_2054593633 = result;
        varB4EAC82CA7396A68D541C85D26508E83_2054593633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2054593633;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.786 -0400", hash_original_method = "DCD002F56CDE29837C0F9152CB84740D", hash_generated_method = "B08FB854C7A925557A0C137422013258")
    @Override
    public ShortBuffer asShortBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1555936962 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1555936962 = wrapped.asShortBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1555936962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1555936962;
        // ---------- Original Method ----------
        //return wrapped.asShortBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.795 -0400", hash_original_method = "F239FF4C13A02315015A1C80B161EA9F", hash_generated_method = "1973DB645DBC2B7BAE7CC761920195A7")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_130512460 = null; //Variable for return #1
        {
            boolean varDC8EF2821996F2F059CAD4060C326AFB_1454223982 = (wrapped.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        wrapped.compact();
        limit(capacity);
        position(wrapped.position());
        this.mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_130512460 = this;
        varB4EAC82CA7396A68D541C85D26508E83_130512460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_130512460;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.796 -0400", hash_original_method = "A3F0B36DB279BC65C52492277F56F581", hash_generated_method = "A448E674F7023D1797BDD6648BD87CA0")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_400803098 = null; //Variable for return #1
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.duplicate());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_400803098 = result;
        varB4EAC82CA7396A68D541C85D26508E83_400803098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_400803098;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.796 -0400", hash_original_method = "8F272C1A8EF5C2D42C170CDE0D21CB4E", hash_generated_method = "0DAF858CC660E41C72FABE061A5B89DC")
    @Override
    public byte get() {
        wrapped.position(position);
        byte result;
        result = wrapped.get();
        byte var40EA57D3EE3C07BF1C102B466E1C3091_558522400 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_558522400;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //byte result = wrapped.get();
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.796 -0400", hash_original_method = "F734D03FE2C441FAD76B9624A65B1714", hash_generated_method = "589003D79A847BB0716E35EF58E4A147")
    @Override
    public byte get(int index) {
        byte varFE4A1C0A821877EBF58C49F410944748_1863728507 = (wrapped.get(index));
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1421039022 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1421039022;
        // ---------- Original Method ----------
        //return wrapped.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.808 -0400", hash_original_method = "D869A1EAE1BFFDE9353D5FA2C49CA99A", hash_generated_method = "ECB12CA4B7A8D00B0CA77AB7F5814D93")
    @Override
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1286314088 = null; //Variable for return #1
        ByteBuffer result;
        result = wrapped.get(dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1286314088 = result;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1286314088.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1286314088;
        // ---------- Original Method ----------
        //ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        //position += byteCount;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.809 -0400", hash_original_method = "2FE76624FCFB4F7CC6C4D2300FE53EF3", hash_generated_method = "6754694EC7CC960DA6AA1534BBC9959B")
    @Override
    public char getChar() {
        wrapped.position(position);
        char result;
        result = wrapped.getChar();
        position += SizeOf.CHAR;
        char varA87DEB01C5F539E6BDA34829C8EF2368_1824719633 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1824719633;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //char result = wrapped.getChar();
        //position += SizeOf.CHAR;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.809 -0400", hash_original_method = "ADD75E9B5B4606F5A583D8492B5A4C8C", hash_generated_method = "F4C8C435BD6DA4E5B5A2301321B9DD08")
    @Override
    public char getChar(int index) {
        char var76ECBB1853D7D302BA82A0387DB176DC_268975957 = (wrapped.getChar(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_99940049 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_99940049;
        // ---------- Original Method ----------
        //return wrapped.getChar(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.811 -0400", hash_original_method = "A4F231D6AA8D7666BF0B0BDD4770C6A9", hash_generated_method = "08E624A920B24D711549B3FE0732318A")
    @Override
    public double getDouble() {
        wrapped.position(position);
        double result;
        result = wrapped.getDouble();
        position += SizeOf.DOUBLE;
        double varE8CD7DA078A86726031AD64F35F5A6C0_1999672141 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1999672141;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //double result = wrapped.getDouble();
        //position += SizeOf.DOUBLE;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.812 -0400", hash_original_method = "F25BBF5399281D05028250314F004C1E", hash_generated_method = "512C1290BFEEDD527D6B76218DA0356E")
    @Override
    public double getDouble(int index) {
        double varF1695710A32235F7D63DA5316B877FF4_463044516 = (wrapped.getDouble(index));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_498417853 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_498417853;
        // ---------- Original Method ----------
        //return wrapped.getDouble(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.813 -0400", hash_original_method = "DBE8B29AB435A86755ECBD575D997ADF", hash_generated_method = "AF2F59041A201B48AD338E17176FA492")
    @Override
    public float getFloat() {
        wrapped.position(position);
        float result;
        result = wrapped.getFloat();
        position += SizeOf.FLOAT;
        float var546ADE640B6EDFBC8A086EF31347E768_1539300745 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1539300745;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //float result = wrapped.getFloat();
        //position += SizeOf.FLOAT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.813 -0400", hash_original_method = "0906B1C4D33749C43BCEE5B8E752E76D", hash_generated_method = "4C3940B69E3E21822D18308136DE3C68")
    @Override
    public float getFloat(int index) {
        float var583F4AB6BAE893C265892DF76111890F_1094634310 = (wrapped.getFloat(index));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1037661112 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1037661112;
        // ---------- Original Method ----------
        //return wrapped.getFloat(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.814 -0400", hash_original_method = "4A2D99413F2A1EA23914893A0D64A22A", hash_generated_method = "F73268E2C6609DD846632D0AA5C645C2")
    @Override
    public int getInt() {
        wrapped.position(position);
        int result;
        result = wrapped.getInt();
        position += SizeOf.INT;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070149436 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070149436;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //int result = wrapped.getInt();
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.821 -0400", hash_original_method = "E9A2A300C7F13DE6F6D61CD16FA4E2B8", hash_generated_method = "C256FC5C80DBC4A2CF32534FCFDF47A8")
    @Override
    public int getInt(int index) {
        int var70F50CA3E48D011662ADE5E5BC0996C2_1498557266 = (wrapped.getInt(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208464425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208464425;
        // ---------- Original Method ----------
        //return wrapped.getInt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.821 -0400", hash_original_method = "EE6ECFBB8B1B6D50C6781665A4A35BBE", hash_generated_method = "BDEA098DE0F68B5E532894E2810BC3FD")
    @Override
    public long getLong() {
        wrapped.position(position);
        long result;
        result = wrapped.getLong();
        position += SizeOf.LONG;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1172337676 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1172337676;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //long result = wrapped.getLong();
        //position += SizeOf.LONG;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.833 -0400", hash_original_method = "1A9B308246D4E3F438CE0D7CC24303AD", hash_generated_method = "F462350D6A80345EC00FF4B42269EEE7")
    @Override
    public long getLong(int index) {
        long varEB7E04F4D6F253B65CFADFA2EE3332FC_2007076295 = (wrapped.getLong(index));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1379538161 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1379538161;
        // ---------- Original Method ----------
        //return wrapped.getLong(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.833 -0400", hash_original_method = "28282D3504D6176EF20C83AE63ADB452", hash_generated_method = "69100519181A6365E44334D916A074F7")
    @Override
    public short getShort() {
        wrapped.position(position);
        short result;
        result = wrapped.getShort();
        position += SizeOf.SHORT;
        short var4F09DAA9D95BCB166A302407A0E0BABE_692967647 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_692967647;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //short result = wrapped.getShort();
        //position += SizeOf.SHORT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.836 -0400", hash_original_method = "9C6E629DA45EA36A1B8A70FEF740CC74", hash_generated_method = "59B56C7FD3D3FCBB25B87B6930417A32")
    @Override
    public short getShort(int index) {
        short varC6902BC62EB65AA743BA49AAB6DE2B17_1962042532 = (wrapped.getShort(index));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1893936664 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1893936664;
        // ---------- Original Method ----------
        //return wrapped.getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.836 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "BB2DEFBA4774731A3E249394F692574D")
    @Override
    public boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844740282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844740282;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.836 -0400", hash_original_method = "40C309BCA720C1771AB2C0DB5B2CC056", hash_generated_method = "AFD42977E4704D316653EAB6F5F96886")
    @Override
    public boolean isReadOnly() {
        boolean var49D0DFB058540E26126BCAC9F0668C11_1581611363 = (wrapped.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991951658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_991951658;
        // ---------- Original Method ----------
        //return wrapped.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.838 -0400", hash_original_method = "D8FBBAF3DBEC96335348C23D9CEFF5FC", hash_generated_method = "942D98C6B85D28A85C129C9832B3DA08")
    @Override
     void orderImpl(ByteOrder byteOrder) {
        super.orderImpl(byteOrder);
        wrapped.order(byteOrder);
        addTaint(byteOrder.getTaint());
        // ---------- Original Method ----------
        //super.orderImpl(byteOrder);
        //wrapped.order(byteOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.848 -0400", hash_original_method = "85F2FC4404251BEDB97DBE6FD4061990", hash_generated_method = "AFBBC83652CC2E57316DE80E7E9CAB19")
    @Override
    public ByteBuffer put(byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1618621630 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(b);
        varB4EAC82CA7396A68D541C85D26508E83_1618621630 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1618621630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1618621630;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(b);
        //this.position++;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.854 -0400", hash_original_method = "3CD6CCD46828403CA377B176C2D2822D", hash_generated_method = "73F5E9811D30074C6CD3ABF72ECC511B")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1580195245 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(src, srcOffset, byteCount);
        this.position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_1580195245 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_1580195245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1580195245;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(src, srcOffset, byteCount);
        //this.position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.855 -0400", hash_original_method = "8C109C00973445D340589478ED9444F1", hash_generated_method = "2A896633D2FC6B1E7EA49ADA46F84E3C")
    @Override
    public ByteBuffer put(int index, byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_57703408 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(index, b);
        varB4EAC82CA7396A68D541C85D26508E83_57703408 = this;
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_57703408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_57703408;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(index, b);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.855 -0400", hash_original_method = "E9D4840E562C9BED28BC7A127E1FECE3", hash_generated_method = "7800961B60B053D1C628E193FF2398B7")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_920231052 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putChar(value);
        this.position += SizeOf.CHAR;
        varB4EAC82CA7396A68D541C85D26508E83_920231052 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_920231052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_920231052;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(value);
        //this.position += SizeOf.CHAR;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.856 -0400", hash_original_method = "0D39EC76965D52C2961B502A18570E70", hash_generated_method = "EA1915B29912E9096ACC26B88C3618FB")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_580648159 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putChar(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_580648159 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_580648159.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_580648159;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.856 -0400", hash_original_method = "3C979C12202FD0F21D9261ACBDF563BC", hash_generated_method = "771848ED774BCAB47465F364239A7D12")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1862783125 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putDouble(value);
        this.position += SizeOf.DOUBLE;
        varB4EAC82CA7396A68D541C85D26508E83_1862783125 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1862783125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1862783125;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(value);
        //this.position += SizeOf.DOUBLE;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.870 -0400", hash_original_method = "E9C430B980A496D01100E970AC4FA364", hash_generated_method = "AD9207E3AF9E0BD90706DD8B1B87C421")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1650740155 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putDouble(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1650740155 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1650740155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1650740155;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.871 -0400", hash_original_method = "18B49E50A3711B71082812403EE33F26", hash_generated_method = "7F9E1FE2E34579BC8F9F2976E2B5622B")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2034517728 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putFloat(value);
        this.position += SizeOf.FLOAT;
        varB4EAC82CA7396A68D541C85D26508E83_2034517728 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_2034517728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2034517728;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(value);
        //this.position += SizeOf.FLOAT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.877 -0400", hash_original_method = "CF3942EC3FCFAED188350B48958C21EB", hash_generated_method = "BC6721457C531599DF778CE37C1794A3")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_59381183 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putFloat(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_59381183 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_59381183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_59381183;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.883 -0400", hash_original_method = "488E6CF540077CB262C06D0E20AEF594", hash_generated_method = "A94675D83073CD9BE37FA22756F855E0")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_36142966 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putInt(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_36142966 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_36142966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_36142966;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.886 -0400", hash_original_method = "B61E2BCE20718AB5D9F89E85EFF0C1EE", hash_generated_method = "AB5CF87BD51F5C3CA24E9336192CFFFD")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_878547981 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putInt(value);
        this.position += SizeOf.INT;
        varB4EAC82CA7396A68D541C85D26508E83_878547981 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_878547981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_878547981;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(value);
        //this.position += SizeOf.INT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.886 -0400", hash_original_method = "71459AF6B6AC0C4B26EB70F2F396DC3A", hash_generated_method = "B66FA41A42E930C4688AF04949350C0C")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1454798628 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putLong(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1454798628 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1454798628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1454798628;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.900 -0400", hash_original_method = "1118E0528407DB1AA30DD23367DFDBDC", hash_generated_method = "F22089C54B32CAC6408659592FD9916B")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1460951525 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putLong(value);
        this.position += SizeOf.LONG;
        varB4EAC82CA7396A68D541C85D26508E83_1460951525 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1460951525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1460951525;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(value);
        //this.position += SizeOf.LONG;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.900 -0400", hash_original_method = "5B51CDEBF6AB573576FFED982377810B", hash_generated_method = "84E9B8B935BBD24D68A47A92B9E1C01A")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1706523229 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putShort(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1706523229 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1706523229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1706523229;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.901 -0400", hash_original_method = "EB14AF156A87035F01282D29F445B16B", hash_generated_method = "4D4A23811F8B5ECBC7CA081374C63AEB")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1281054581 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putShort(value);
        this.position += SizeOf.SHORT;
        varB4EAC82CA7396A68D541C85D26508E83_1281054581 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1281054581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1281054581;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(value);
        //this.position += SizeOf.SHORT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.915 -0400", hash_original_method = "6E049AFA213C3C5078EB6770A9689DFA", hash_generated_method = "1D1599352DC428018390DDDAE41ED4AB")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_952003269 = null; //Variable for return #1
        wrapped.position(this.position);
        MappedByteBufferAdapter result;
        result = new MappedByteBufferAdapter(wrapped.slice());
        wrapped.clear();
        varB4EAC82CA7396A68D541C85D26508E83_952003269 = result;
        varB4EAC82CA7396A68D541C85D26508E83_952003269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_952003269;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        //wrapped.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.922 -0400", hash_original_method = "33CDC6092C78EAE8E1726040ED7707B5", hash_generated_method = "7BCFA854627677AEE85BC2C8571A9FC7")
    @Override
     byte[] protectedArray() {
        byte[] varB32035EFAFDB5C8550949E6F1C3C11C7_1980190014 = (wrapped.protectedArray());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1296042662 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1296042662;
        // ---------- Original Method ----------
        //return wrapped.protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.923 -0400", hash_original_method = "07409272224D2DCFB9ED6864BAB477CC", hash_generated_method = "CCD8D5CC46D9A7D3331F3477A6C4A804")
    @Override
     int protectedArrayOffset() {
        int var4123A6B3CA7E4599E7545E9209CB3C28_1714410373 = (wrapped.protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611235789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611235789;
        // ---------- Original Method ----------
        //return wrapped.protectedArrayOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.923 -0400", hash_original_method = "088F278FB6BC57CD2CF8BD7E84B85911", hash_generated_method = "476A7E0EF49BBD95EB3C82D0C35C87C9")
    @Override
     boolean protectedHasArray() {
        boolean var79038B0DD03771BCEBDB4CD9DA4BEDBC_1105812540 = (wrapped.protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700097370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_700097370;
        // ---------- Original Method ----------
        //return wrapped.protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.923 -0400", hash_original_method = "845658F397739B9672DA207B5DA44048", hash_generated_method = "8D4028D33946A70E90568622E65CD09C")
    public final void free() {
        wrapped.free();
        // ---------- Original Method ----------
        //wrapped.free();
    }

    
}

