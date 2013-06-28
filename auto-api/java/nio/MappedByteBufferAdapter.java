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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.737 -0400", hash_original_method = "47B29CB1ACCF161EBA65518E27011CFA", hash_generated_method = "E97EF60937168FDF0F2A670EEE6C499B")
    private  MappedByteBufferAdapter(ByteBuffer buffer) {
        super(buffer);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.737 -0400", hash_original_method = "A963FFF21E3D96B3784CF402E671AE24", hash_generated_method = "E4F4140C016EDEE4D4F809C31E25625E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.737 -0400", hash_original_method = "E1DE3F7336A5099D6DE2B8D867AB9894", hash_generated_method = "986A6B5E68F0A2B3B7848EB4A7E8B1B6")
    @Override
     void limitImpl(int newLimit) {
        super.limitImpl(newLimit);
        wrapped.limit(newLimit);
        addTaint(newLimit);
        // ---------- Original Method ----------
        //super.limitImpl(newLimit);
        //wrapped.limit(newLimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.738 -0400", hash_original_method = "3B95D10870BE74C82FCFC1DC24594CC6", hash_generated_method = "2E20B046D03B7CA15068B439F5D27DFB")
    @Override
     void positionImpl(int newPosition) {
        super.positionImpl(newPosition);
        wrapped.position(newPosition);
        addTaint(newPosition);
        // ---------- Original Method ----------
        //super.positionImpl(newPosition);
        //wrapped.position(newPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.738 -0400", hash_original_method = "16DB3977E6E6674C6B8A606792D70852", hash_generated_method = "C1C52406E5432C63EEBD285C1F0767DF")
    @Override
    public CharBuffer asCharBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1996737433 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1996737433 = wrapped.asCharBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1996737433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1996737433;
        // ---------- Original Method ----------
        //return wrapped.asCharBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.738 -0400", hash_original_method = "4EAAB0CE80265C0EB48FD990BC824325", hash_generated_method = "0A64557A7BB5211A411F860AE2FD9032")
    @Override
    public DoubleBuffer asDoubleBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_316824749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_316824749 = wrapped.asDoubleBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_316824749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_316824749;
        // ---------- Original Method ----------
        //return wrapped.asDoubleBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.739 -0400", hash_original_method = "FE99D2936DE991C171CA2FD8AF39C092", hash_generated_method = "0B439BA6FC75C78D69F707BCF35109F5")
    @Override
    public FloatBuffer asFloatBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_278382273 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_278382273 = wrapped.asFloatBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_278382273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_278382273;
        // ---------- Original Method ----------
        //return wrapped.asFloatBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.739 -0400", hash_original_method = "0CB92AC22BFEFF23C733A6090C26E78E", hash_generated_method = "168BF8C81EDFB44447E9A46846C308A3")
    @Override
    public IntBuffer asIntBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_615578391 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_615578391 = wrapped.asIntBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_615578391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_615578391;
        // ---------- Original Method ----------
        //return wrapped.asIntBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.740 -0400", hash_original_method = "FC44E930DB5733336E808BE2E2538E0C", hash_generated_method = "7D95CEE5ADB3F797D278AACD58E3B1E5")
    @Override
    public LongBuffer asLongBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_737389754 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_737389754 = wrapped.asLongBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_737389754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_737389754;
        // ---------- Original Method ----------
        //return wrapped.asLongBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.741 -0400", hash_original_method = "ACAB46F9C018F1F70B47C0B4E03416FC", hash_generated_method = "1A19AF79C2F772B773FFB16F2E03B4F7")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2033991001 = null; //Variable for return #1
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_2033991001 = result;
        varB4EAC82CA7396A68D541C85D26508E83_2033991001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2033991001;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.742 -0400", hash_original_method = "DCD002F56CDE29837C0F9152CB84740D", hash_generated_method = "4747199BD683FFA3801629B579C4D295")
    @Override
    public ShortBuffer asShortBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1042775703 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1042775703 = wrapped.asShortBuffer();
        varB4EAC82CA7396A68D541C85D26508E83_1042775703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1042775703;
        // ---------- Original Method ----------
        //return wrapped.asShortBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.742 -0400", hash_original_method = "F239FF4C13A02315015A1C80B161EA9F", hash_generated_method = "67AB6429AB245D1627236C77B82576F4")
    @Override
    public ByteBuffer compact() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_697969203 = null; //Variable for return #1
        {
            boolean varDC8EF2821996F2F059CAD4060C326AFB_64135121 = (wrapped.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        wrapped.compact();
        limit(capacity);
        position(wrapped.position());
        this.mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_697969203 = this;
        varB4EAC82CA7396A68D541C85D26508E83_697969203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697969203;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.743 -0400", hash_original_method = "A3F0B36DB279BC65C52492277F56F581", hash_generated_method = "6757165C37FA2AE6F181673E745A9B13")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2041627206 = null; //Variable for return #1
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_2041627206 = result;
        varB4EAC82CA7396A68D541C85D26508E83_2041627206.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2041627206;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.743 -0400", hash_original_method = "8F272C1A8EF5C2D42C170CDE0D21CB4E", hash_generated_method = "467B5D5C6952C2ACFF3902C2DC82ED20")
    @Override
    public byte get() {
        wrapped.position(position);
        byte result = wrapped.get();
        byte var40EA57D3EE3C07BF1C102B466E1C3091_392130213 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_392130213;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //byte result = wrapped.get();
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.743 -0400", hash_original_method = "F734D03FE2C441FAD76B9624A65B1714", hash_generated_method = "AB35AF337FAFD75C033E6F7100D07BA3")
    @Override
    public byte get(int index) {
        byte varFE4A1C0A821877EBF58C49F410944748_933088020 = (wrapped.get(index));
        addTaint(index);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1123822490 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1123822490;
        // ---------- Original Method ----------
        //return wrapped.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.744 -0400", hash_original_method = "D869A1EAE1BFFDE9353D5FA2C49CA99A", hash_generated_method = "1DE5E9DF3B768A29CFA335C4FAB3DC2C")
    @Override
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2125077002 = null; //Variable for return #1
        ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_2125077002 = result;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_2125077002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2125077002;
        // ---------- Original Method ----------
        //ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        //position += byteCount;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.744 -0400", hash_original_method = "2FE76624FCFB4F7CC6C4D2300FE53EF3", hash_generated_method = "EB3A70C5873FC8E3BBF879ABB284E8FF")
    @Override
    public char getChar() {
        wrapped.position(position);
        char result = wrapped.getChar();
        position += SizeOf.CHAR;
        char varA87DEB01C5F539E6BDA34829C8EF2368_2121189824 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2121189824;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //char result = wrapped.getChar();
        //position += SizeOf.CHAR;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.745 -0400", hash_original_method = "ADD75E9B5B4606F5A583D8492B5A4C8C", hash_generated_method = "5B225A714125E4473B397B0114829E2B")
    @Override
    public char getChar(int index) {
        char var76ECBB1853D7D302BA82A0387DB176DC_1707760332 = (wrapped.getChar(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_36988804 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_36988804;
        // ---------- Original Method ----------
        //return wrapped.getChar(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.745 -0400", hash_original_method = "A4F231D6AA8D7666BF0B0BDD4770C6A9", hash_generated_method = "63E265B420790243C801156B615D66A3")
    @Override
    public double getDouble() {
        wrapped.position(position);
        double result = wrapped.getDouble();
        position += SizeOf.DOUBLE;
        double varE8CD7DA078A86726031AD64F35F5A6C0_1346453541 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1346453541;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //double result = wrapped.getDouble();
        //position += SizeOf.DOUBLE;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.745 -0400", hash_original_method = "F25BBF5399281D05028250314F004C1E", hash_generated_method = "DBE61CB356910AC8470255D0C56E29F8")
    @Override
    public double getDouble(int index) {
        double varF1695710A32235F7D63DA5316B877FF4_141359192 = (wrapped.getDouble(index));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_589397307 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_589397307;
        // ---------- Original Method ----------
        //return wrapped.getDouble(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.746 -0400", hash_original_method = "DBE8B29AB435A86755ECBD575D997ADF", hash_generated_method = "6B087D56AC568C8ADEC6009A5180CD90")
    @Override
    public float getFloat() {
        wrapped.position(position);
        float result = wrapped.getFloat();
        position += SizeOf.FLOAT;
        float var546ADE640B6EDFBC8A086EF31347E768_923526219 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_923526219;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //float result = wrapped.getFloat();
        //position += SizeOf.FLOAT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.746 -0400", hash_original_method = "0906B1C4D33749C43BCEE5B8E752E76D", hash_generated_method = "B2F4E144E844BE4E859F3FC927149EF0")
    @Override
    public float getFloat(int index) {
        float var583F4AB6BAE893C265892DF76111890F_149127078 = (wrapped.getFloat(index));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1177259595 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1177259595;
        // ---------- Original Method ----------
        //return wrapped.getFloat(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.747 -0400", hash_original_method = "4A2D99413F2A1EA23914893A0D64A22A", hash_generated_method = "FD51C3A30ACE37E96DCD18265049C5EA")
    @Override
    public int getInt() {
        wrapped.position(position);
        int result = wrapped.getInt();
        position += SizeOf.INT;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361075509 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361075509;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //int result = wrapped.getInt();
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.747 -0400", hash_original_method = "E9A2A300C7F13DE6F6D61CD16FA4E2B8", hash_generated_method = "997D130D891A07025259B0AB89CAE395")
    @Override
    public int getInt(int index) {
        int var70F50CA3E48D011662ADE5E5BC0996C2_1068236330 = (wrapped.getInt(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111259610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111259610;
        // ---------- Original Method ----------
        //return wrapped.getInt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.748 -0400", hash_original_method = "EE6ECFBB8B1B6D50C6781665A4A35BBE", hash_generated_method = "A3935BDC771B0D5BC3B1E07C55150B55")
    @Override
    public long getLong() {
        wrapped.position(position);
        long result = wrapped.getLong();
        position += SizeOf.LONG;
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1800632694 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1800632694;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //long result = wrapped.getLong();
        //position += SizeOf.LONG;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.748 -0400", hash_original_method = "1A9B308246D4E3F438CE0D7CC24303AD", hash_generated_method = "776D2FC584219E34C5E7344E1AEFA008")
    @Override
    public long getLong(int index) {
        long varEB7E04F4D6F253B65CFADFA2EE3332FC_510289248 = (wrapped.getLong(index));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1884582798 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1884582798;
        // ---------- Original Method ----------
        //return wrapped.getLong(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.749 -0400", hash_original_method = "28282D3504D6176EF20C83AE63ADB452", hash_generated_method = "53E28B6B83423882A25B1C0F19B764BC")
    @Override
    public short getShort() {
        wrapped.position(position);
        short result = wrapped.getShort();
        position += SizeOf.SHORT;
        short var4F09DAA9D95BCB166A302407A0E0BABE_1170721298 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1170721298;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //short result = wrapped.getShort();
        //position += SizeOf.SHORT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.749 -0400", hash_original_method = "9C6E629DA45EA36A1B8A70FEF740CC74", hash_generated_method = "EB08F4536F2C7439C120EE6E4FAD16D9")
    @Override
    public short getShort(int index) {
        short varC6902BC62EB65AA743BA49AAB6DE2B17_1444750835 = (wrapped.getShort(index));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1651398075 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1651398075;
        // ---------- Original Method ----------
        //return wrapped.getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.750 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "853EA0360EEB1BC0E63163851B4D54A4")
    @Override
    public boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443399918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443399918;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.750 -0400", hash_original_method = "40C309BCA720C1771AB2C0DB5B2CC056", hash_generated_method = "01079F3B3D9B3BC79D3CDCF3EB707994")
    @Override
    public boolean isReadOnly() {
        boolean var49D0DFB058540E26126BCAC9F0668C11_216338649 = (wrapped.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568230097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568230097;
        // ---------- Original Method ----------
        //return wrapped.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.751 -0400", hash_original_method = "D8FBBAF3DBEC96335348C23D9CEFF5FC", hash_generated_method = "942D98C6B85D28A85C129C9832B3DA08")
    @Override
     void orderImpl(ByteOrder byteOrder) {
        super.orderImpl(byteOrder);
        wrapped.order(byteOrder);
        addTaint(byteOrder.getTaint());
        // ---------- Original Method ----------
        //super.orderImpl(byteOrder);
        //wrapped.order(byteOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.752 -0400", hash_original_method = "85F2FC4404251BEDB97DBE6FD4061990", hash_generated_method = "0CE2B1CA0F51E41AA0C3B620B0457A0E")
    @Override
    public ByteBuffer put(byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1808343357 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(b);
        varB4EAC82CA7396A68D541C85D26508E83_1808343357 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1808343357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1808343357;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(b);
        //this.position++;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.753 -0400", hash_original_method = "3CD6CCD46828403CA377B176C2D2822D", hash_generated_method = "4ADEC91087A8E44F076C9E537EEE384B")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_742762645 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(src, srcOffset, byteCount);
        this.position += byteCount;
        varB4EAC82CA7396A68D541C85D26508E83_742762645 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        varB4EAC82CA7396A68D541C85D26508E83_742762645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_742762645;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(src, srcOffset, byteCount);
        //this.position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.757 -0400", hash_original_method = "8C109C00973445D340589478ED9444F1", hash_generated_method = "EA03ABAB21E168A3CF63CC06683C58F0")
    @Override
    public ByteBuffer put(int index, byte b) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1642311816 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.put(index, b);
        varB4EAC82CA7396A68D541C85D26508E83_1642311816 = this;
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1642311816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1642311816;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(index, b);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.759 -0400", hash_original_method = "E9D4840E562C9BED28BC7A127E1FECE3", hash_generated_method = "FD598E03BDB97983DF75924AA6766B33")
    @Override
    public ByteBuffer putChar(char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_939826124 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putChar(value);
        this.position += SizeOf.CHAR;
        varB4EAC82CA7396A68D541C85D26508E83_939826124 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_939826124.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_939826124;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(value);
        //this.position += SizeOf.CHAR;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.761 -0400", hash_original_method = "0D39EC76965D52C2961B502A18570E70", hash_generated_method = "289886BEAC9E8B1378D328B51C987D9F")
    @Override
    public ByteBuffer putChar(int index, char value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_193239242 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putChar(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_193239242 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_193239242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_193239242;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.762 -0400", hash_original_method = "3C979C12202FD0F21D9261ACBDF563BC", hash_generated_method = "9757F736B6E8AD392A7D53AD24C7727E")
    @Override
    public ByteBuffer putDouble(double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1098861778 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putDouble(value);
        this.position += SizeOf.DOUBLE;
        varB4EAC82CA7396A68D541C85D26508E83_1098861778 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1098861778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1098861778;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(value);
        //this.position += SizeOf.DOUBLE;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.763 -0400", hash_original_method = "E9C430B980A496D01100E970AC4FA364", hash_generated_method = "FEF2D2BE00DAEE706EED76D5F80B01AB")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_766712058 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putDouble(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_766712058 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_766712058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_766712058;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.764 -0400", hash_original_method = "18B49E50A3711B71082812403EE33F26", hash_generated_method = "04C2066C94635F180170EDBF22938775")
    @Override
    public ByteBuffer putFloat(float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_83177289 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putFloat(value);
        this.position += SizeOf.FLOAT;
        varB4EAC82CA7396A68D541C85D26508E83_83177289 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_83177289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_83177289;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(value);
        //this.position += SizeOf.FLOAT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.765 -0400", hash_original_method = "CF3942EC3FCFAED188350B48958C21EB", hash_generated_method = "43BB6E3120BD961021105B59A878BB10")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1425200055 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putFloat(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1425200055 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1425200055.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1425200055;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.766 -0400", hash_original_method = "488E6CF540077CB262C06D0E20AEF594", hash_generated_method = "F4629B72ACCCCE608D7D7EBC276679AD")
    @Override
    public ByteBuffer putInt(int index, int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_831763183 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putInt(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_831763183 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_831763183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_831763183;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.767 -0400", hash_original_method = "B61E2BCE20718AB5D9F89E85EFF0C1EE", hash_generated_method = "1B647E6BD726C0058AEBB20BA418B2C4")
    @Override
    public ByteBuffer putInt(int value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_866389886 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putInt(value);
        this.position += SizeOf.INT;
        varB4EAC82CA7396A68D541C85D26508E83_866389886 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_866389886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_866389886;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(value);
        //this.position += SizeOf.INT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.769 -0400", hash_original_method = "71459AF6B6AC0C4B26EB70F2F396DC3A", hash_generated_method = "F4648CF31A4AAA63294B5E7498FF8F44")
    @Override
    public ByteBuffer putLong(int index, long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_237927105 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putLong(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_237927105 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_237927105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_237927105;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.770 -0400", hash_original_method = "1118E0528407DB1AA30DD23367DFDBDC", hash_generated_method = "FEB269A4A1D950C603C1BD4A70A31577")
    @Override
    public ByteBuffer putLong(long value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_410952225 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putLong(value);
        this.position += SizeOf.LONG;
        varB4EAC82CA7396A68D541C85D26508E83_410952225 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_410952225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_410952225;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(value);
        //this.position += SizeOf.LONG;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.771 -0400", hash_original_method = "5B51CDEBF6AB573576FFED982377810B", hash_generated_method = "E78D27F395987520C4820DCE990211DD")
    @Override
    public ByteBuffer putShort(int index, short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1838992305 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putShort(index, value);
        varB4EAC82CA7396A68D541C85D26508E83_1838992305 = this;
        addTaint(index);
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_1838992305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1838992305;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.772 -0400", hash_original_method = "EB14AF156A87035F01282D29F445B16B", hash_generated_method = "A17E62725986E57DC83F284573101A88")
    @Override
    public ByteBuffer putShort(short value) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_932584199 = null; //Variable for return #1
        wrapped.position(this.position);
        wrapped.putShort(value);
        this.position += SizeOf.SHORT;
        varB4EAC82CA7396A68D541C85D26508E83_932584199 = this;
        addTaint(value);
        varB4EAC82CA7396A68D541C85D26508E83_932584199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_932584199;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(value);
        //this.position += SizeOf.SHORT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.774 -0400", hash_original_method = "6E049AFA213C3C5078EB6770A9689DFA", hash_generated_method = "AEA8AC9CA29A1469EF2E9745D3390F11")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_183023969 = null; //Variable for return #1
        wrapped.position(this.position);
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        wrapped.clear();
        varB4EAC82CA7396A68D541C85D26508E83_183023969 = result;
        varB4EAC82CA7396A68D541C85D26508E83_183023969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183023969;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        //wrapped.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.774 -0400", hash_original_method = "33CDC6092C78EAE8E1726040ED7707B5", hash_generated_method = "67E6819A767A2CC7C8F99B5680F93D79")
    @Override
     byte[] protectedArray() {
        byte[] varB32035EFAFDB5C8550949E6F1C3C11C7_887810870 = (wrapped.protectedArray());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_294229121 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_294229121;
        // ---------- Original Method ----------
        //return wrapped.protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.775 -0400", hash_original_method = "07409272224D2DCFB9ED6864BAB477CC", hash_generated_method = "EEED219CADD23E4ACE4DAA23ED2F77D7")
    @Override
     int protectedArrayOffset() {
        int var4123A6B3CA7E4599E7545E9209CB3C28_1131666013 = (wrapped.protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236325377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236325377;
        // ---------- Original Method ----------
        //return wrapped.protectedArrayOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.776 -0400", hash_original_method = "088F278FB6BC57CD2CF8BD7E84B85911", hash_generated_method = "7571047DEBBFC128A82E47C019E2E6EC")
    @Override
     boolean protectedHasArray() {
        boolean var79038B0DD03771BCEBDB4CD9DA4BEDBC_1832897825 = (wrapped.protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353726649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353726649;
        // ---------- Original Method ----------
        //return wrapped.protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.777 -0400", hash_original_method = "845658F397739B9672DA207B5DA44048", hash_generated_method = "8D4028D33946A70E90568622E65CD09C")
    public final void free() {
        wrapped.free();
        // ---------- Original Method ----------
        //wrapped.free();
    }

    
}

