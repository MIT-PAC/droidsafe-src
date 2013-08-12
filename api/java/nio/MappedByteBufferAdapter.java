package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.channels.FileChannel.MapMode;

import libcore.io.SizeOf;




final class MappedByteBufferAdapter extends MappedByteBuffer {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.352 -0400", hash_original_method = "47B29CB1ACCF161EBA65518E27011CFA", hash_generated_method = "EA8865BF6A6608F4EB1C180A9C6E04BC")
    private  MappedByteBufferAdapter(ByteBuffer buffer) {
        super(buffer);
        addTaint(buffer.getTaint());
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.352 -0400", hash_original_method = "A963FFF21E3D96B3784CF402E671AE24", hash_generated_method = "BBA3A968903FCE6A8865AEC1CBB746E1")
    public  MappedByteBufferAdapter(MemoryBlock block, int capacity, int offset, MapMode mode) {
        super(block, capacity, offset, mode);
        addTaint(mode.getTaint());
        addTaint(offset);
        addTaint(capacity);
        addTaint(block.getTaint());
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.352 -0400", hash_original_method = "E1DE3F7336A5099D6DE2B8D867AB9894", hash_generated_method = "E29E3E9B49D459CE41BA4D624A923EE7")
    @Override
     void limitImpl(int newLimit) {
        addTaint(newLimit);
        super.limitImpl(newLimit);
        wrapped.limit(newLimit);
        // ---------- Original Method ----------
        //super.limitImpl(newLimit);
        //wrapped.limit(newLimit);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.353 -0400", hash_original_method = "3B95D10870BE74C82FCFC1DC24594CC6", hash_generated_method = "88304CEE0E900A4EC6B0B239FB5879FF")
    @Override
     void positionImpl(int newPosition) {
        addTaint(newPosition);
        super.positionImpl(newPosition);
        wrapped.position(newPosition);
        // ---------- Original Method ----------
        //super.positionImpl(newPosition);
        //wrapped.position(newPosition);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.353 -0400", hash_original_method = "16DB3977E6E6674C6B8A606792D70852", hash_generated_method = "55F3D6E5B12E21FB5870F3C2A9F64552")
    @Override
    public CharBuffer asCharBuffer() {
CharBuffer var8FB0226A86CEF312A844805022AAFAF2_1017991103 =         wrapped.asCharBuffer();
        var8FB0226A86CEF312A844805022AAFAF2_1017991103.addTaint(taint);
        return var8FB0226A86CEF312A844805022AAFAF2_1017991103;
        // ---------- Original Method ----------
        //return wrapped.asCharBuffer();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.353 -0400", hash_original_method = "4EAAB0CE80265C0EB48FD990BC824325", hash_generated_method = "9ACE0A7A3595A7752059C35B1D8A9116")
    @Override
    public DoubleBuffer asDoubleBuffer() {
DoubleBuffer var58C18DEDC5F75A0E67B2EBB4F569F6D8_1443264616 =         wrapped.asDoubleBuffer();
        var58C18DEDC5F75A0E67B2EBB4F569F6D8_1443264616.addTaint(taint);
        return var58C18DEDC5F75A0E67B2EBB4F569F6D8_1443264616;
        // ---------- Original Method ----------
        //return wrapped.asDoubleBuffer();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.353 -0400", hash_original_method = "FE99D2936DE991C171CA2FD8AF39C092", hash_generated_method = "7401B08843FEA9788E8D9F261922E138")
    @Override
    public FloatBuffer asFloatBuffer() {
FloatBuffer varF0D698D51404AD09706672E8F39BD3EC_933750800 =         wrapped.asFloatBuffer();
        varF0D698D51404AD09706672E8F39BD3EC_933750800.addTaint(taint);
        return varF0D698D51404AD09706672E8F39BD3EC_933750800;
        // ---------- Original Method ----------
        //return wrapped.asFloatBuffer();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.354 -0400", hash_original_method = "0CB92AC22BFEFF23C733A6090C26E78E", hash_generated_method = "36343BB4DDA9E7D6A47F722B3BB30841")
    @Override
    public IntBuffer asIntBuffer() {
IntBuffer varC7BBC0C95FF36E8508E90FEE58BCD5A1_1264333369 =         wrapped.asIntBuffer();
        varC7BBC0C95FF36E8508E90FEE58BCD5A1_1264333369.addTaint(taint);
        return varC7BBC0C95FF36E8508E90FEE58BCD5A1_1264333369;
        // ---------- Original Method ----------
        //return wrapped.asIntBuffer();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.354 -0400", hash_original_method = "FC44E930DB5733336E808BE2E2538E0C", hash_generated_method = "3DF12EC8DBFF322F05D4C33316D14AC1")
    @Override
    public LongBuffer asLongBuffer() {
LongBuffer var5EA97746B9E9EE5ED05706A96211E32E_1961777466 =         wrapped.asLongBuffer();
        var5EA97746B9E9EE5ED05706A96211E32E_1961777466.addTaint(taint);
        return var5EA97746B9E9EE5ED05706A96211E32E_1961777466;
        // ---------- Original Method ----------
        //return wrapped.asLongBuffer();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.354 -0400", hash_original_method = "ACAB46F9C018F1F70B47C0B4E03416FC", hash_generated_method = "A5265E3A43EA35703783CB7245C5936C")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1088924709 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1088924709.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1088924709;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.354 -0400", hash_original_method = "DCD002F56CDE29837C0F9152CB84740D", hash_generated_method = "B234488CFA0C99A78677F2E949DEBE1E")
    @Override
    public ShortBuffer asShortBuffer() {
ShortBuffer varB7B411DDEAEC2388896715D3BDF1C204_568850711 =         wrapped.asShortBuffer();
        varB7B411DDEAEC2388896715D3BDF1C204_568850711.addTaint(taint);
        return varB7B411DDEAEC2388896715D3BDF1C204_568850711;
        // ---------- Original Method ----------
        //return wrapped.asShortBuffer();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.355 -0400", hash_original_method = "F239FF4C13A02315015A1C80B161EA9F", hash_generated_method = "978D451CBC72975B35C0FB939C0E91DF")
    @Override
    public ByteBuffer compact() {
        if(wrapped.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_62231444 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_62231444.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_62231444;
        } //End block
        wrapped.compact();
        limit(capacity);
        position(wrapped.position());
        this.mark = UNSET_MARK;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_66862681 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_66862681.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_66862681;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.355 -0400", hash_original_method = "A3F0B36DB279BC65C52492277F56F581", hash_generated_method = "4C3B6B1ABE793CE557329CE5E7A9F2E9")
    @Override
    public ByteBuffer duplicate() {
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_305687741 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_305687741.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_305687741;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.356 -0400", hash_original_method = "8F272C1A8EF5C2D42C170CDE0D21CB4E", hash_generated_method = "BF86C82D5B03D2BE8C4B44D24E8D7385")
    @Override
    public byte get() {
        wrapped.position(position);
        byte result = wrapped.get();
        ++position;
        byte varB4A88417B3D0170D754C647C30B7216A_2047283906 = (result);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_628172450 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_628172450;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //byte result = wrapped.get();
        //++position;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.356 -0400", hash_original_method = "F734D03FE2C441FAD76B9624A65B1714", hash_generated_method = "2F0E4CE92C87900275D980F8CAD27114")
    @Override
    public byte get(int index) {
        addTaint(index);
        byte var6FB8CE659862C4B4BD7957479C9B466A_1797029357 = (wrapped.get(index));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1327755495 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1327755495;
        // ---------- Original Method ----------
        //return wrapped.get(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.356 -0400", hash_original_method = "D869A1EAE1BFFDE9353D5FA2C49CA99A", hash_generated_method = "C21AB87898AE37234A396D3689724391")
    @Override
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        position += byteCount;
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_2102574044 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2102574044.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2102574044;
        // ---------- Original Method ----------
        //ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        //position += byteCount;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.357 -0400", hash_original_method = "2FE76624FCFB4F7CC6C4D2300FE53EF3", hash_generated_method = "18348D7B22E19766251DC6D3BEDDE081")
    @Override
    public char getChar() {
        wrapped.position(position);
        char result = wrapped.getChar();
        position += SizeOf.CHAR;
        char varB4A88417B3D0170D754C647C30B7216A_942530633 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_865317163 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_865317163;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //char result = wrapped.getChar();
        //position += SizeOf.CHAR;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.357 -0400", hash_original_method = "ADD75E9B5B4606F5A583D8492B5A4C8C", hash_generated_method = "D7ADB27BFD655B84C7D9A98FDD85F3E1")
    @Override
    public char getChar(int index) {
        addTaint(index);
        char varFAE6256E1B5C1F241C3730D46689A968_953852868 = (wrapped.getChar(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1602732767 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1602732767;
        // ---------- Original Method ----------
        //return wrapped.getChar(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.357 -0400", hash_original_method = "A4F231D6AA8D7666BF0B0BDD4770C6A9", hash_generated_method = "328231E4F875F7744947B49538C2D519")
    @Override
    public double getDouble() {
        wrapped.position(position);
        double result = wrapped.getDouble();
        position += SizeOf.DOUBLE;
        double varB4A88417B3D0170D754C647C30B7216A_342439026 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_158524468 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_158524468;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //double result = wrapped.getDouble();
        //position += SizeOf.DOUBLE;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.357 -0400", hash_original_method = "F25BBF5399281D05028250314F004C1E", hash_generated_method = "B23418EC83650B919254DBE7AB40B7F9")
    @Override
    public double getDouble(int index) {
        addTaint(index);
        double varEA47E7E7A076AEE18D5272FA9DCD1221_1525737166 = (wrapped.getDouble(index));
                double varE8CD7DA078A86726031AD64F35F5A6C0_973529366 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_973529366;
        // ---------- Original Method ----------
        //return wrapped.getDouble(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.358 -0400", hash_original_method = "DBE8B29AB435A86755ECBD575D997ADF", hash_generated_method = "DF1369130F3100050655677C205FEB7B")
    @Override
    public float getFloat() {
        wrapped.position(position);
        float result = wrapped.getFloat();
        position += SizeOf.FLOAT;
        float varB4A88417B3D0170D754C647C30B7216A_849879469 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_228454223 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_228454223;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //float result = wrapped.getFloat();
        //position += SizeOf.FLOAT;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.358 -0400", hash_original_method = "0906B1C4D33749C43BCEE5B8E752E76D", hash_generated_method = "E185BC67FE06AB1C71380947CF6C3E13")
    @Override
    public float getFloat(int index) {
        addTaint(index);
        float var0A01FAB151C799147F47ED7C6C12BAEB_1448397299 = (wrapped.getFloat(index));
                float var546ADE640B6EDFBC8A086EF31347E768_2132678974 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2132678974;
        // ---------- Original Method ----------
        //return wrapped.getFloat(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.359 -0400", hash_original_method = "4A2D99413F2A1EA23914893A0D64A22A", hash_generated_method = "6E128A20DBE02EFB4A2ED97481607A84")
    @Override
    public int getInt() {
        wrapped.position(position);
        int result = wrapped.getInt();
        position += SizeOf.INT;
        int varB4A88417B3D0170D754C647C30B7216A_1459199270 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141950675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141950675;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //int result = wrapped.getInt();
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.359 -0400", hash_original_method = "E9A2A300C7F13DE6F6D61CD16FA4E2B8", hash_generated_method = "02548842124BC3AFA429000215B44529")
    @Override
    public int getInt(int index) {
        addTaint(index);
        int var5665843DDB017BACBFAD85D1778B4186_130679555 = (wrapped.getInt(index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353074365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353074365;
        // ---------- Original Method ----------
        //return wrapped.getInt(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.360 -0400", hash_original_method = "EE6ECFBB8B1B6D50C6781665A4A35BBE", hash_generated_method = "36C18D843D08EB5FB20B7A1D5A11F329")
    @Override
    public long getLong() {
        wrapped.position(position);
        long result = wrapped.getLong();
        position += SizeOf.LONG;
        long varB4A88417B3D0170D754C647C30B7216A_1935663523 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_894000027 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_894000027;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //long result = wrapped.getLong();
        //position += SizeOf.LONG;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.360 -0400", hash_original_method = "1A9B308246D4E3F438CE0D7CC24303AD", hash_generated_method = "F8F9FE6E295C1A4F2A92D10819BE292B")
    @Override
    public long getLong(int index) {
        addTaint(index);
        long varC3717D45686A817A18440A0ED14C7FFD_856954982 = (wrapped.getLong(index));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1965411581 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1965411581;
        // ---------- Original Method ----------
        //return wrapped.getLong(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.361 -0400", hash_original_method = "28282D3504D6176EF20C83AE63ADB452", hash_generated_method = "E1385009119352155F659097A687108B")
    @Override
    public short getShort() {
        wrapped.position(position);
        short result = wrapped.getShort();
        position += SizeOf.SHORT;
        short varB4A88417B3D0170D754C647C30B7216A_476871566 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_752960265 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_752960265;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //short result = wrapped.getShort();
        //position += SizeOf.SHORT;
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.361 -0400", hash_original_method = "9C6E629DA45EA36A1B8A70FEF740CC74", hash_generated_method = "D58C7A7984031B188184ED6B407D9208")
    @Override
    public short getShort(int index) {
        addTaint(index);
        short var889B845508B8281E5532549261D3ECCC_1250275775 = (wrapped.getShort(index));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1342947318 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1342947318;
        // ---------- Original Method ----------
        //return wrapped.getShort(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.361 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "B2ED62F76D9F8843CD1DD3B4C06EC443")
    @Override
    public boolean isDirect() {
        boolean varB326B5062B2F0E69046810717534CB09_1038453666 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560229770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560229770;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.361 -0400", hash_original_method = "40C309BCA720C1771AB2C0DB5B2CC056", hash_generated_method = "0595D9AA3620E3ED196BFCF019E792A7")
    @Override
    public boolean isReadOnly() {
        boolean var66292668482D94C55A8B2B1835BFA748_162871975 = (wrapped.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_209947413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_209947413;
        // ---------- Original Method ----------
        //return wrapped.isReadOnly();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.361 -0400", hash_original_method = "D8FBBAF3DBEC96335348C23D9CEFF5FC", hash_generated_method = "674C6D62CF4F55EABEAA7FA12BB7E7E1")
    @Override
     void orderImpl(ByteOrder byteOrder) {
        addTaint(byteOrder.getTaint());
        super.orderImpl(byteOrder);
        wrapped.order(byteOrder);
        // ---------- Original Method ----------
        //super.orderImpl(byteOrder);
        //wrapped.order(byteOrder);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "85F2FC4404251BEDB97DBE6FD4061990", hash_generated_method = "082C65D620B537ADA61360D2F5D0C77B")
    @Override
    public ByteBuffer put(byte b) {
        addTaint(b);
        wrapped.position(this.position);
        wrapped.put(b);
        this.position++;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_910584047 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_910584047.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_910584047;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(b);
        //this.position++;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "3CD6CCD46828403CA377B176C2D2822D", hash_generated_method = "464F7C01F01656923AAA6F717CC2FFD2")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        wrapped.position(this.position);
        wrapped.put(src, srcOffset, byteCount);
        this.position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_635895294 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_635895294.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_635895294;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(src, srcOffset, byteCount);
        //this.position += byteCount;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "8C109C00973445D340589478ED9444F1", hash_generated_method = "132B6B42A37458C9C9DB1D6DBD262AD5")
    @Override
    public ByteBuffer put(int index, byte b) {
        addTaint(b);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.put(index, b);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1656881818 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1656881818.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1656881818;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(index, b);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "E9D4840E562C9BED28BC7A127E1FECE3", hash_generated_method = "E16FB833C08931D71A06EBC7235354EA")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putChar(value);
        this.position += SizeOf.CHAR;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1099133386 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1099133386.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1099133386;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(value);
        //this.position += SizeOf.CHAR;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "0D39EC76965D52C2961B502A18570E70", hash_generated_method = "FDAA558C1FAC06B1CF6412C79ED695FE")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putChar(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_666316087 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_666316087.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_666316087;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(index, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "3C979C12202FD0F21D9261ACBDF563BC", hash_generated_method = "24138D37D208227F5285758A5D8B37C3")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putDouble(value);
        this.position += SizeOf.DOUBLE;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_678799913 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_678799913.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_678799913;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(value);
        //this.position += SizeOf.DOUBLE;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "E9C430B980A496D01100E970AC4FA364", hash_generated_method = "61280D74358B8041D330147AFDA86C55")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putDouble(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1241318575 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1241318575.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1241318575;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(index, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.362 -0400", hash_original_method = "18B49E50A3711B71082812403EE33F26", hash_generated_method = "0716DE6DCC727663DE284AAFE8606088")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putFloat(value);
        this.position += SizeOf.FLOAT;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1132810494 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1132810494.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1132810494;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(value);
        //this.position += SizeOf.FLOAT;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "CF3942EC3FCFAED188350B48958C21EB", hash_generated_method = "A6CD78B6B7F7FCB9FC1C2346D0C2D4AE")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putFloat(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1652027906 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1652027906.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1652027906;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(index, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "488E6CF540077CB262C06D0E20AEF594", hash_generated_method = "A271BB385AC3B000A4D92EC90D5C2F86")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putInt(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_573292637 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_573292637.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_573292637;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(index, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "B61E2BCE20718AB5D9F89E85EFF0C1EE", hash_generated_method = "CE7233C7B6A5406A8D0938EDD7A83DCF")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putInt(value);
        this.position += SizeOf.INT;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1095955948 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1095955948.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1095955948;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(value);
        //this.position += SizeOf.INT;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "71459AF6B6AC0C4B26EB70F2F396DC3A", hash_generated_method = "0B76E294AB9F34FE4E6F25B8FDBBCC38")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putLong(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1112608544 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1112608544.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1112608544;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(index, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "1118E0528407DB1AA30DD23367DFDBDC", hash_generated_method = "07B1A3AB894E45F341915FAADDFBED50")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putLong(value);
        this.position += SizeOf.LONG;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1206645341 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1206645341.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1206645341;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(value);
        //this.position += SizeOf.LONG;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "5B51CDEBF6AB573576FFED982377810B", hash_generated_method = "48DC207760E157EB78EED31D714FC5B5")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putShort(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_983693685 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_983693685.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_983693685;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(index, value);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "EB14AF156A87035F01282D29F445B16B", hash_generated_method = "02AF01E36C8C84E5AAE23AE5146789C5")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putShort(value);
        this.position += SizeOf.SHORT;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1501718418 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1501718418.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1501718418;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(value);
        //this.position += SizeOf.SHORT;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.363 -0400", hash_original_method = "6E049AFA213C3C5078EB6770A9689DFA", hash_generated_method = "AD6E0EFD80E671194FCCDAA482C1D21E")
    @Override
    public ByteBuffer slice() {
        wrapped.position(this.position);
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        wrapped.clear();
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_38585308 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_38585308.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_38585308;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        //wrapped.clear();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.364 -0400", hash_original_method = "33CDC6092C78EAE8E1726040ED7707B5", hash_generated_method = "61C746BC66B8CDAB58E5EFD7F390F4B3")
    @Override
     byte[] protectedArray() {
        byte[] varC1EBE07C497427F029C3FDD9C6FC95CA_1411409672 = (wrapped.protectedArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2083282757 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2083282757;
        // ---------- Original Method ----------
        //return wrapped.protectedArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.364 -0400", hash_original_method = "07409272224D2DCFB9ED6864BAB477CC", hash_generated_method = "38BA9731F4C02018557DA6CF30806AD2")
    @Override
     int protectedArrayOffset() {
        int varEC0F902905CCB8F2A83C43ED3568E21C_1768304511 = (wrapped.protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591168832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591168832;
        // ---------- Original Method ----------
        //return wrapped.protectedArrayOffset();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.364 -0400", hash_original_method = "088F278FB6BC57CD2CF8BD7E84B85911", hash_generated_method = "039AD24207A6A05A0F26F35BF814B5A9")
    @Override
     boolean protectedHasArray() {
        boolean var71F158A0562D0A04E0BC9145FD580E2C_1727468294 = (wrapped.protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1053681649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1053681649;
        // ---------- Original Method ----------
        //return wrapped.protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.364 -0400", hash_original_method = "845658F397739B9672DA207B5DA44048", hash_generated_method = "8D4028D33946A70E90568622E65CD09C")
    public final void free() {
        wrapped.free();
        // ---------- Original Method ----------
        //wrapped.free();
    }

    
}

