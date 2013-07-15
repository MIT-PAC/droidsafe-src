package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.channels.FileChannel.MapMode;
import libcore.io.SizeOf;

final class MappedByteBufferAdapter extends MappedByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.830 -0400", hash_original_method = "47B29CB1ACCF161EBA65518E27011CFA", hash_generated_method = "EA8865BF6A6608F4EB1C180A9C6E04BC")
    private  MappedByteBufferAdapter(ByteBuffer buffer) {
        super(buffer);
        addTaint(buffer.getTaint());
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
        // ---------- Original Method ----------
        //effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.830 -0400", hash_original_method = "A963FFF21E3D96B3784CF402E671AE24", hash_generated_method = "BBA3A968903FCE6A8865AEC1CBB746E1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.831 -0400", hash_original_method = "E1DE3F7336A5099D6DE2B8D867AB9894", hash_generated_method = "E29E3E9B49D459CE41BA4D624A923EE7")
    @Override
     void limitImpl(int newLimit) {
        addTaint(newLimit);
        super.limitImpl(newLimit);
        wrapped.limit(newLimit);
        // ---------- Original Method ----------
        //super.limitImpl(newLimit);
        //wrapped.limit(newLimit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.831 -0400", hash_original_method = "3B95D10870BE74C82FCFC1DC24594CC6", hash_generated_method = "88304CEE0E900A4EC6B0B239FB5879FF")
    @Override
     void positionImpl(int newPosition) {
        addTaint(newPosition);
        super.positionImpl(newPosition);
        wrapped.position(newPosition);
        // ---------- Original Method ----------
        //super.positionImpl(newPosition);
        //wrapped.position(newPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.831 -0400", hash_original_method = "16DB3977E6E6674C6B8A606792D70852", hash_generated_method = "E31A42A298E8F59B318FE27705866122")
    @Override
    public CharBuffer asCharBuffer() {
CharBuffer var8FB0226A86CEF312A844805022AAFAF2_214862090 =         wrapped.asCharBuffer();
        var8FB0226A86CEF312A844805022AAFAF2_214862090.addTaint(taint);
        return var8FB0226A86CEF312A844805022AAFAF2_214862090;
        // ---------- Original Method ----------
        //return wrapped.asCharBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.832 -0400", hash_original_method = "4EAAB0CE80265C0EB48FD990BC824325", hash_generated_method = "808C4BAB511A7B1A051DA08A4F55FD40")
    @Override
    public DoubleBuffer asDoubleBuffer() {
DoubleBuffer var58C18DEDC5F75A0E67B2EBB4F569F6D8_1059747445 =         wrapped.asDoubleBuffer();
        var58C18DEDC5F75A0E67B2EBB4F569F6D8_1059747445.addTaint(taint);
        return var58C18DEDC5F75A0E67B2EBB4F569F6D8_1059747445;
        // ---------- Original Method ----------
        //return wrapped.asDoubleBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.832 -0400", hash_original_method = "FE99D2936DE991C171CA2FD8AF39C092", hash_generated_method = "8DA9CE7E2BEB915263E3156D0CA6AED0")
    @Override
    public FloatBuffer asFloatBuffer() {
FloatBuffer varF0D698D51404AD09706672E8F39BD3EC_733903279 =         wrapped.asFloatBuffer();
        varF0D698D51404AD09706672E8F39BD3EC_733903279.addTaint(taint);
        return varF0D698D51404AD09706672E8F39BD3EC_733903279;
        // ---------- Original Method ----------
        //return wrapped.asFloatBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.832 -0400", hash_original_method = "0CB92AC22BFEFF23C733A6090C26E78E", hash_generated_method = "15697F527D4AEE9C77BFF55A9CC62AA6")
    @Override
    public IntBuffer asIntBuffer() {
IntBuffer varC7BBC0C95FF36E8508E90FEE58BCD5A1_566177407 =         wrapped.asIntBuffer();
        varC7BBC0C95FF36E8508E90FEE58BCD5A1_566177407.addTaint(taint);
        return varC7BBC0C95FF36E8508E90FEE58BCD5A1_566177407;
        // ---------- Original Method ----------
        //return wrapped.asIntBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.833 -0400", hash_original_method = "FC44E930DB5733336E808BE2E2538E0C", hash_generated_method = "DFBA6F10179D80FD3A7B12F2DB4FD66F")
    @Override
    public LongBuffer asLongBuffer() {
LongBuffer var5EA97746B9E9EE5ED05706A96211E32E_677619536 =         wrapped.asLongBuffer();
        var5EA97746B9E9EE5ED05706A96211E32E_677619536.addTaint(taint);
        return var5EA97746B9E9EE5ED05706A96211E32E_677619536;
        // ---------- Original Method ----------
        //return wrapped.asLongBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.833 -0400", hash_original_method = "ACAB46F9C018F1F70B47C0B4E03416FC", hash_generated_method = "7149D80A2F60F668315DB1FEA2C985AF")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_854603006 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_854603006.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_854603006;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.833 -0400", hash_original_method = "DCD002F56CDE29837C0F9152CB84740D", hash_generated_method = "ADAEB79E30980A6D192B5CFD9936D280")
    @Override
    public ShortBuffer asShortBuffer() {
ShortBuffer varB7B411DDEAEC2388896715D3BDF1C204_1984733868 =         wrapped.asShortBuffer();
        varB7B411DDEAEC2388896715D3BDF1C204_1984733868.addTaint(taint);
        return varB7B411DDEAEC2388896715D3BDF1C204_1984733868;
        // ---------- Original Method ----------
        //return wrapped.asShortBuffer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.834 -0400", hash_original_method = "F239FF4C13A02315015A1C80B161EA9F", hash_generated_method = "CAF679BF6B91F6A257270E8536C6E5F2")
    @Override
    public ByteBuffer compact() {
    if(wrapped.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1598430013 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_1598430013.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_1598430013;
        } //End block
        wrapped.compact();
        limit(capacity);
        position(wrapped.position());
        this.mark = UNSET_MARK;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_596337927 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_596337927.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_596337927;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.834 -0400", hash_original_method = "A3F0B36DB279BC65C52492277F56F581", hash_generated_method = "AB9A1B0BAE1AAB1849EF9EB9E16BD6D1")
    @Override
    public ByteBuffer duplicate() {
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_406022236 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_406022236.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_406022236;
        // ---------- Original Method ----------
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        //result.limit(limit);
        //result.position(position);
        //result.mark = mark;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.835 -0400", hash_original_method = "8F272C1A8EF5C2D42C170CDE0D21CB4E", hash_generated_method = "CAC0FC385389E372858E61270990E017")
    @Override
    public byte get() {
        wrapped.position(position);
        byte result = wrapped.get();
        ++position;
        byte varB4A88417B3D0170D754C647C30B7216A_1531316353 = (result);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_661570703 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_661570703;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //byte result = wrapped.get();
        //++position;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.835 -0400", hash_original_method = "F734D03FE2C441FAD76B9624A65B1714", hash_generated_method = "7CA03C36FFFB53B139DAFCDB81CEE16A")
    @Override
    public byte get(int index) {
        addTaint(index);
        byte var6FB8CE659862C4B4BD7957479C9B466A_1584965894 = (wrapped.get(index));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1362945737 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1362945737;
        // ---------- Original Method ----------
        //return wrapped.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.836 -0400", hash_original_method = "D869A1EAE1BFFDE9353D5FA2C49CA99A", hash_generated_method = "59AE6E3D3373F8A5EB3DAD9B8BB2B73A")
    @Override
    public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        position += byteCount;
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_598524431 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_598524431.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_598524431;
        // ---------- Original Method ----------
        //ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        //position += byteCount;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.836 -0400", hash_original_method = "2FE76624FCFB4F7CC6C4D2300FE53EF3", hash_generated_method = "C97AA84A7940CF6F1F610F47323F6EBF")
    @Override
    public char getChar() {
        wrapped.position(position);
        char result = wrapped.getChar();
        position += SizeOf.CHAR;
        char varB4A88417B3D0170D754C647C30B7216A_184648696 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1676306899 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1676306899;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //char result = wrapped.getChar();
        //position += SizeOf.CHAR;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.837 -0400", hash_original_method = "ADD75E9B5B4606F5A583D8492B5A4C8C", hash_generated_method = "645A898AB445C9FF939AAFA373E3E765")
    @Override
    public char getChar(int index) {
        addTaint(index);
        char varFAE6256E1B5C1F241C3730D46689A968_2122175006 = (wrapped.getChar(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1844159051 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1844159051;
        // ---------- Original Method ----------
        //return wrapped.getChar(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.837 -0400", hash_original_method = "A4F231D6AA8D7666BF0B0BDD4770C6A9", hash_generated_method = "A6E799E2217BEF7036C29A0A4CB51486")
    @Override
    public double getDouble() {
        wrapped.position(position);
        double result = wrapped.getDouble();
        position += SizeOf.DOUBLE;
        double varB4A88417B3D0170D754C647C30B7216A_1610343244 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1281088972 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1281088972;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //double result = wrapped.getDouble();
        //position += SizeOf.DOUBLE;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.838 -0400", hash_original_method = "F25BBF5399281D05028250314F004C1E", hash_generated_method = "B3F5D4B129A7398207CB305F94C7003E")
    @Override
    public double getDouble(int index) {
        addTaint(index);
        double varEA47E7E7A076AEE18D5272FA9DCD1221_1191187319 = (wrapped.getDouble(index));
                double varE8CD7DA078A86726031AD64F35F5A6C0_422274822 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_422274822;
        // ---------- Original Method ----------
        //return wrapped.getDouble(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.838 -0400", hash_original_method = "DBE8B29AB435A86755ECBD575D997ADF", hash_generated_method = "1396C612802BA21D9D20D667A1E86D8E")
    @Override
    public float getFloat() {
        wrapped.position(position);
        float result = wrapped.getFloat();
        position += SizeOf.FLOAT;
        float varB4A88417B3D0170D754C647C30B7216A_584183240 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_508865452 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_508865452;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //float result = wrapped.getFloat();
        //position += SizeOf.FLOAT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.838 -0400", hash_original_method = "0906B1C4D33749C43BCEE5B8E752E76D", hash_generated_method = "481FE87A279FD03971E2C50E93316BC2")
    @Override
    public float getFloat(int index) {
        addTaint(index);
        float var0A01FAB151C799147F47ED7C6C12BAEB_352754289 = (wrapped.getFloat(index));
                float var546ADE640B6EDFBC8A086EF31347E768_136539442 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_136539442;
        // ---------- Original Method ----------
        //return wrapped.getFloat(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.839 -0400", hash_original_method = "4A2D99413F2A1EA23914893A0D64A22A", hash_generated_method = "8D4491DAC3AFA4E600FD37F4B4BCD944")
    @Override
    public int getInt() {
        wrapped.position(position);
        int result = wrapped.getInt();
        position += SizeOf.INT;
        int varB4A88417B3D0170D754C647C30B7216A_627968455 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98487355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98487355;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //int result = wrapped.getInt();
        //position += SizeOf.INT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.839 -0400", hash_original_method = "E9A2A300C7F13DE6F6D61CD16FA4E2B8", hash_generated_method = "A26F8ADA9E502F0DB19BE55F02FEE444")
    @Override
    public int getInt(int index) {
        addTaint(index);
        int var5665843DDB017BACBFAD85D1778B4186_2048752744 = (wrapped.getInt(index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628107855 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628107855;
        // ---------- Original Method ----------
        //return wrapped.getInt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.840 -0400", hash_original_method = "EE6ECFBB8B1B6D50C6781665A4A35BBE", hash_generated_method = "F1AE93B026E708A27A9B4CE76CEA4E53")
    @Override
    public long getLong() {
        wrapped.position(position);
        long result = wrapped.getLong();
        position += SizeOf.LONG;
        long varB4A88417B3D0170D754C647C30B7216A_1417176396 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_42046520 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_42046520;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //long result = wrapped.getLong();
        //position += SizeOf.LONG;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.840 -0400", hash_original_method = "1A9B308246D4E3F438CE0D7CC24303AD", hash_generated_method = "7D45E6B8E5F1704C630EEC08253B78FE")
    @Override
    public long getLong(int index) {
        addTaint(index);
        long varC3717D45686A817A18440A0ED14C7FFD_1002316135 = (wrapped.getLong(index));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1406609893 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1406609893;
        // ---------- Original Method ----------
        //return wrapped.getLong(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.840 -0400", hash_original_method = "28282D3504D6176EF20C83AE63ADB452", hash_generated_method = "3885E6E12BF1B48F5BAFB49BBEA3F78E")
    @Override
    public short getShort() {
        wrapped.position(position);
        short result = wrapped.getShort();
        position += SizeOf.SHORT;
        short varB4A88417B3D0170D754C647C30B7216A_772484130 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_20019764 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_20019764;
        // ---------- Original Method ----------
        //wrapped.position(position);
        //short result = wrapped.getShort();
        //position += SizeOf.SHORT;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.841 -0400", hash_original_method = "9C6E629DA45EA36A1B8A70FEF740CC74", hash_generated_method = "AE7FD28003BA23028669617980FEC904")
    @Override
    public short getShort(int index) {
        addTaint(index);
        short var889B845508B8281E5532549261D3ECCC_448846757 = (wrapped.getShort(index));
                short var4F09DAA9D95BCB166A302407A0E0BABE_849979479 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_849979479;
        // ---------- Original Method ----------
        //return wrapped.getShort(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.841 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "2FC4B1BF98DE9366FFBCBB2A42738311")
    @Override
    public boolean isDirect() {
        boolean varB326B5062B2F0E69046810717534CB09_290919217 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_727495732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_727495732;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.841 -0400", hash_original_method = "40C309BCA720C1771AB2C0DB5B2CC056", hash_generated_method = "26418C4B7C10A7B15659CB559F0D20FE")
    @Override
    public boolean isReadOnly() {
        boolean var66292668482D94C55A8B2B1835BFA748_765083983 = (wrapped.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098945272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098945272;
        // ---------- Original Method ----------
        //return wrapped.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.842 -0400", hash_original_method = "D8FBBAF3DBEC96335348C23D9CEFF5FC", hash_generated_method = "674C6D62CF4F55EABEAA7FA12BB7E7E1")
    @Override
     void orderImpl(ByteOrder byteOrder) {
        addTaint(byteOrder.getTaint());
        super.orderImpl(byteOrder);
        wrapped.order(byteOrder);
        // ---------- Original Method ----------
        //super.orderImpl(byteOrder);
        //wrapped.order(byteOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.842 -0400", hash_original_method = "85F2FC4404251BEDB97DBE6FD4061990", hash_generated_method = "0CDAFD4706ECCAFEF6FD803EC3C99329")
    @Override
    public ByteBuffer put(byte b) {
        addTaint(b);
        wrapped.position(this.position);
        wrapped.put(b);
        this.position++;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1766537966 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1766537966.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1766537966;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(b);
        //this.position++;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.843 -0400", hash_original_method = "3CD6CCD46828403CA377B176C2D2822D", hash_generated_method = "6E1B0D215E6933615183C8AB47DA2D12")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        wrapped.position(this.position);
        wrapped.put(src, srcOffset, byteCount);
        this.position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1646003549 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1646003549.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1646003549;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(src, srcOffset, byteCount);
        //this.position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.843 -0400", hash_original_method = "8C109C00973445D340589478ED9444F1", hash_generated_method = "C2AA3DC325AA15E110F0A89740E586B5")
    @Override
    public ByteBuffer put(int index, byte b) {
        addTaint(b);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.put(index, b);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1702725724 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1702725724.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1702725724;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.put(index, b);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.844 -0400", hash_original_method = "E9D4840E562C9BED28BC7A127E1FECE3", hash_generated_method = "F30F5D337F2264B78DFE9E2380C87416")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putChar(value);
        this.position += SizeOf.CHAR;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_286257123 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_286257123.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_286257123;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(value);
        //this.position += SizeOf.CHAR;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.844 -0400", hash_original_method = "0D39EC76965D52C2961B502A18570E70", hash_generated_method = "AB5A74F332A29803BD1B734EBA735D0B")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putChar(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1434977252 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1434977252.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1434977252;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putChar(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.845 -0400", hash_original_method = "3C979C12202FD0F21D9261ACBDF563BC", hash_generated_method = "290AF55ACDCD89D9C3D655612BD276A8")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putDouble(value);
        this.position += SizeOf.DOUBLE;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1926151457 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1926151457.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1926151457;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(value);
        //this.position += SizeOf.DOUBLE;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.845 -0400", hash_original_method = "E9C430B980A496D01100E970AC4FA364", hash_generated_method = "F8D386EC7566861847D0B8622F5C17FF")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putDouble(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1198914630 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1198914630.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1198914630;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putDouble(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.846 -0400", hash_original_method = "18B49E50A3711B71082812403EE33F26", hash_generated_method = "9A75ED9FFAAEB684B3D93DFBDAD41074")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putFloat(value);
        this.position += SizeOf.FLOAT;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1872264396 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1872264396.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1872264396;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(value);
        //this.position += SizeOf.FLOAT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.846 -0400", hash_original_method = "CF3942EC3FCFAED188350B48958C21EB", hash_generated_method = "9962ADC91168C48A4C647D1616D1AAD1")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putFloat(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1370319776 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1370319776.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1370319776;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putFloat(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.846 -0400", hash_original_method = "488E6CF540077CB262C06D0E20AEF594", hash_generated_method = "30CD53275E32345EA67F4561E3082C00")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putInt(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1180368623 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1180368623.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1180368623;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.847 -0400", hash_original_method = "B61E2BCE20718AB5D9F89E85EFF0C1EE", hash_generated_method = "500E9A762D782102EBA95B5934AC508F")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putInt(value);
        this.position += SizeOf.INT;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_2134895695 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2134895695.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2134895695;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putInt(value);
        //this.position += SizeOf.INT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.847 -0400", hash_original_method = "71459AF6B6AC0C4B26EB70F2F396DC3A", hash_generated_method = "22B74CD48567FB6E431A6EBD1EEBF568")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putLong(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_125035618 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_125035618.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_125035618;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.848 -0400", hash_original_method = "1118E0528407DB1AA30DD23367DFDBDC", hash_generated_method = "CD2AFA9C0574CBA2750BEE0557FF3E43")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putLong(value);
        this.position += SizeOf.LONG;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_291355094 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_291355094.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_291355094;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putLong(value);
        //this.position += SizeOf.LONG;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.848 -0400", hash_original_method = "5B51CDEBF6AB573576FFED982377810B", hash_generated_method = "BABA8C758A178BACC7089BF53C83FD0C")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        wrapped.position(this.position);
        wrapped.putShort(index, value);
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_995581230 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_995581230.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_995581230;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.849 -0400", hash_original_method = "EB14AF156A87035F01282D29F445B16B", hash_generated_method = "D73C42EE321EDE23C5B4AE34F814EB88")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        wrapped.position(this.position);
        wrapped.putShort(value);
        this.position += SizeOf.SHORT;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1267345321 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1267345321.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1267345321;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //wrapped.putShort(value);
        //this.position += SizeOf.SHORT;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.849 -0400", hash_original_method = "6E049AFA213C3C5078EB6770A9689DFA", hash_generated_method = "50CB5B95FA38E81B3BD9EF0608850F4B")
    @Override
    public ByteBuffer slice() {
        wrapped.position(this.position);
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        wrapped.clear();
ByteBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_370360416 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_370360416.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_370360416;
        // ---------- Original Method ----------
        //wrapped.position(this.position);
        //MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        //wrapped.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.849 -0400", hash_original_method = "33CDC6092C78EAE8E1726040ED7707B5", hash_generated_method = "7453C2215B1C77001B78B7922DA727E2")
    @Override
     byte[] protectedArray() {
        byte[] varC1EBE07C497427F029C3FDD9C6FC95CA_2090422934 = (wrapped.protectedArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_994137478 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_994137478;
        // ---------- Original Method ----------
        //return wrapped.protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.850 -0400", hash_original_method = "07409272224D2DCFB9ED6864BAB477CC", hash_generated_method = "E726578C4246EA08E217F930A60F5F56")
    @Override
     int protectedArrayOffset() {
        int varEC0F902905CCB8F2A83C43ED3568E21C_1941956791 = (wrapped.protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815192698 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815192698;
        // ---------- Original Method ----------
        //return wrapped.protectedArrayOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.850 -0400", hash_original_method = "088F278FB6BC57CD2CF8BD7E84B85911", hash_generated_method = "F655EE02459A9DF2E4DE4B2C2B1EED35")
    @Override
     boolean protectedHasArray() {
        boolean var71F158A0562D0A04E0BC9145FD580E2C_772775525 = (wrapped.protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724022945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724022945;
        // ---------- Original Method ----------
        //return wrapped.protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.850 -0400", hash_original_method = "845658F397739B9672DA207B5DA44048", hash_generated_method = "8D4028D33946A70E90568622E65CD09C")
    public final void free() {
        wrapped.free();
        // ---------- Original Method ----------
        //wrapped.free();
    }

    
}

