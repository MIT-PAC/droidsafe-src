package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.channels.FileChannel.MapMode;

import libcore.io.SizeOf;




final class MappedByteBufferAdapter extends MappedByteBuffer {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.106 -0500", hash_original_method = "47B29CB1ACCF161EBA65518E27011CFA", hash_generated_method = "08692C527830894E4F49717D9EB3713E")
    private MappedByteBufferAdapter(ByteBuffer buffer) {
        super(buffer);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.107 -0500", hash_original_method = "A963FFF21E3D96B3784CF402E671AE24", hash_generated_method = "B139EDDDE2D6E5320DF8864C50D9365D")
    public MappedByteBufferAdapter(MemoryBlock block, int capacity, int offset, MapMode mode) {
        super(block, capacity, offset, mode);
        effectiveDirectAddress = wrapped.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.108 -0500", hash_original_method = "E1DE3F7336A5099D6DE2B8D867AB9894", hash_generated_method = "7CAB282A010BB2CE036E62EBB1E1E08E")
    @Override
void limitImpl(int newLimit) {
        super.limitImpl(newLimit);
        wrapped.limit(newLimit);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.110 -0500", hash_original_method = "3B95D10870BE74C82FCFC1DC24594CC6", hash_generated_method = "B564E458FD8FB3A1F157424530A3EC13")
    @Override
void positionImpl(int newPosition) {
        super.positionImpl(newPosition);
        wrapped.position(newPosition);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.110 -0500", hash_original_method = "16DB3977E6E6674C6B8A606792D70852", hash_generated_method = "2E86FB28284DFA0BD243BA3DB9BC771E")
    @Override
public CharBuffer asCharBuffer() {
        return wrapped.asCharBuffer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.111 -0500", hash_original_method = "4EAAB0CE80265C0EB48FD990BC824325", hash_generated_method = "4E7950E872907254EAF82B899D0FC9A2")
    @Override
public DoubleBuffer asDoubleBuffer() {
        return wrapped.asDoubleBuffer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.112 -0500", hash_original_method = "FE99D2936DE991C171CA2FD8AF39C092", hash_generated_method = "AC16D5C55D71CCDA7B338BFD4AB9F45D")
    @Override
public FloatBuffer asFloatBuffer() {
        return wrapped.asFloatBuffer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.113 -0500", hash_original_method = "0CB92AC22BFEFF23C733A6090C26E78E", hash_generated_method = "30739F623A942EEEA20FB49A9CCA4D87")
    @Override
public IntBuffer asIntBuffer() {
        return wrapped.asIntBuffer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.114 -0500", hash_original_method = "FC44E930DB5733336E808BE2E2538E0C", hash_generated_method = "45720A435269FFC965DB07214D6197B7")
    @Override
public LongBuffer asLongBuffer() {
        return wrapped.asLongBuffer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.115 -0500", hash_original_method = "ACAB46F9C018F1F70B47C0B4E03416FC", hash_generated_method = "311DE490278549EB0AE5D1EDCB5D2BD9")
    @Override
public ByteBuffer asReadOnlyBuffer() {
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.asReadOnlyBuffer());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.116 -0500", hash_original_method = "DCD002F56CDE29837C0F9152CB84740D", hash_generated_method = "675FE037A3E27F0E85BF12565A0F9EF8")
    @Override
public ShortBuffer asShortBuffer() {
        return wrapped.asShortBuffer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.117 -0500", hash_original_method = "F239FF4C13A02315015A1C80B161EA9F", hash_generated_method = "2D816A635B84914C776A83CE81A7327E")
    @Override
public ByteBuffer compact() {
        if (wrapped.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        wrapped.compact();
        limit(capacity);
        position(wrapped.position());
        this.mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.117 -0500", hash_original_method = "A3F0B36DB279BC65C52492277F56F581", hash_generated_method = "62AD45755795B860A71895FB9A8022CB")
    @Override
public ByteBuffer duplicate() {
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.duplicate());
        result.limit(limit);
        result.position(position);
        result.mark = mark;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.118 -0500", hash_original_method = "8F272C1A8EF5C2D42C170CDE0D21CB4E", hash_generated_method = "B511F194A3B107591D48FCA0AE141411")
    @Override
public byte get() {
        wrapped.position(position);
        byte result = wrapped.get();
        ++position;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.119 -0500", hash_original_method = "F734D03FE2C441FAD76B9624A65B1714", hash_generated_method = "78FD507CCBAC23243D449929B168EE67")
    @Override
public byte get(int index) {
        return wrapped.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.120 -0500", hash_original_method = "D869A1EAE1BFFDE9353D5FA2C49CA99A", hash_generated_method = "CFC421A35C8DAF2241DF18097FE5EBF1")
    @Override
public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        ByteBuffer result = wrapped.get(dst, dstOffset, byteCount);
        position += byteCount;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.121 -0500", hash_original_method = "2FE76624FCFB4F7CC6C4D2300FE53EF3", hash_generated_method = "03D4D23DE58D3C2A7C7148FC0A0EFEEE")
    @Override
public char getChar() {
        wrapped.position(position);
        char result = wrapped.getChar();
        position += SizeOf.CHAR;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.122 -0500", hash_original_method = "ADD75E9B5B4606F5A583D8492B5A4C8C", hash_generated_method = "31D310529F597EA3D1F49C85948DCE27")
    @Override
public char getChar(int index) {
        return wrapped.getChar(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.123 -0500", hash_original_method = "A4F231D6AA8D7666BF0B0BDD4770C6A9", hash_generated_method = "5CCB99334B63A07A46816EAA920D4FC3")
    @Override
public double getDouble() {
        wrapped.position(position);
        double result = wrapped.getDouble();
        position += SizeOf.DOUBLE;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.124 -0500", hash_original_method = "F25BBF5399281D05028250314F004C1E", hash_generated_method = "1D87FA8F2428AC3640FF5E08D227D059")
    @Override
public double getDouble(int index) {
        return wrapped.getDouble(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.124 -0500", hash_original_method = "DBE8B29AB435A86755ECBD575D997ADF", hash_generated_method = "A5E5C8B08DEF5F1AE70DE76A6DFEDA64")
    @Override
public float getFloat() {
        wrapped.position(position);
        float result = wrapped.getFloat();
        position += SizeOf.FLOAT;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.125 -0500", hash_original_method = "0906B1C4D33749C43BCEE5B8E752E76D", hash_generated_method = "6400B96038EDFBC93263C7DBB3A774DA")
    @Override
public float getFloat(int index) {
        return wrapped.getFloat(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.126 -0500", hash_original_method = "4A2D99413F2A1EA23914893A0D64A22A", hash_generated_method = "B22C009779E8CF8D090643D3FB7BFAF5")
    @Override
public int getInt() {
        wrapped.position(position);
        int result = wrapped.getInt();
        position += SizeOf.INT;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.128 -0500", hash_original_method = "E9A2A300C7F13DE6F6D61CD16FA4E2B8", hash_generated_method = "1630031D574620F813698C4D5A02BA7C")
    @Override
public int getInt(int index) {
        return wrapped.getInt(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.128 -0500", hash_original_method = "EE6ECFBB8B1B6D50C6781665A4A35BBE", hash_generated_method = "D45201D1A109D1901FE9DEB361CE25AA")
    @Override
public long getLong() {
        wrapped.position(position);
        long result = wrapped.getLong();
        position += SizeOf.LONG;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.129 -0500", hash_original_method = "1A9B308246D4E3F438CE0D7CC24303AD", hash_generated_method = "C303D477D56C3664C972EBC3F5C8F66C")
    @Override
public long getLong(int index) {
        return wrapped.getLong(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.130 -0500", hash_original_method = "28282D3504D6176EF20C83AE63ADB452", hash_generated_method = "226F23FD78CEA33132DED9011D0239C5")
    @Override
public short getShort() {
        wrapped.position(position);
        short result = wrapped.getShort();
        position += SizeOf.SHORT;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.131 -0500", hash_original_method = "9C6E629DA45EA36A1B8A70FEF740CC74", hash_generated_method = "BCBE66772371A841DEEC51D629198235")
    @Override
public short getShort(int index) {
        return wrapped.getShort(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.132 -0500", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "6F6736E7BB119DA22CD7EFE26A2F33A2")
    @Override
public boolean isDirect() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.133 -0500", hash_original_method = "40C309BCA720C1771AB2C0DB5B2CC056", hash_generated_method = "C347F167852EFCC96B5B69F15E7F8CB5")
    @Override
public boolean isReadOnly() {
        return wrapped.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.134 -0500", hash_original_method = "D8FBBAF3DBEC96335348C23D9CEFF5FC", hash_generated_method = "28571ECAB3C3046434453ADC24F3959D")
    @Override
void orderImpl(ByteOrder byteOrder) {
        super.orderImpl(byteOrder);
        wrapped.order(byteOrder);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.135 -0500", hash_original_method = "85F2FC4404251BEDB97DBE6FD4061990", hash_generated_method = "FDCA26633FC0D75ABF17D3E952255096")
    @Override
public ByteBuffer put(byte b) {
        wrapped.position(this.position);
        wrapped.put(b);
        this.position++;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.135 -0500", hash_original_method = "3CD6CCD46828403CA377B176C2D2822D", hash_generated_method = "37BD0EA019B0467636F7BF3B40E3D7A8")
    @Override
public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        wrapped.position(this.position);
        wrapped.put(src, srcOffset, byteCount);
        this.position += byteCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.136 -0500", hash_original_method = "8C109C00973445D340589478ED9444F1", hash_generated_method = "B49A54D95C69D45D456D77C4100B0142")
    @Override
public ByteBuffer put(int index, byte b) {
        wrapped.position(this.position);
        wrapped.put(index, b);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.137 -0500", hash_original_method = "E9D4840E562C9BED28BC7A127E1FECE3", hash_generated_method = "F8E1458BEDE21FD4BEED668A13715519")
    @Override
public ByteBuffer putChar(char value) {
        wrapped.position(this.position);
        wrapped.putChar(value);
        this.position += SizeOf.CHAR;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.138 -0500", hash_original_method = "0D39EC76965D52C2961B502A18570E70", hash_generated_method = "CDFC05F652B4799E47F70331600F0501")
    @Override
public ByteBuffer putChar(int index, char value) {
        wrapped.position(this.position);
        wrapped.putChar(index, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.139 -0500", hash_original_method = "3C979C12202FD0F21D9261ACBDF563BC", hash_generated_method = "48849F95F168F6C00631655462A8482C")
    @Override
public ByteBuffer putDouble(double value) {
        wrapped.position(this.position);
        wrapped.putDouble(value);
        this.position += SizeOf.DOUBLE;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.140 -0500", hash_original_method = "E9C430B980A496D01100E970AC4FA364", hash_generated_method = "AECC5BEC0BB418D6F224C9ADEE4146E9")
    @Override
public ByteBuffer putDouble(int index, double value) {
        wrapped.position(this.position);
        wrapped.putDouble(index, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.141 -0500", hash_original_method = "18B49E50A3711B71082812403EE33F26", hash_generated_method = "0448D2119A94973C7097864BD61E6023")
    @Override
public ByteBuffer putFloat(float value) {
        wrapped.position(this.position);
        wrapped.putFloat(value);
        this.position += SizeOf.FLOAT;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.142 -0500", hash_original_method = "CF3942EC3FCFAED188350B48958C21EB", hash_generated_method = "AC922FF56B3B639ADC712C50BE222ED8")
    @Override
public ByteBuffer putFloat(int index, float value) {
        wrapped.position(this.position);
        wrapped.putFloat(index, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.143 -0500", hash_original_method = "488E6CF540077CB262C06D0E20AEF594", hash_generated_method = "ABFE6E753E5C419B17E0DC6DA2971938")
    @Override
public ByteBuffer putInt(int index, int value) {
        wrapped.position(this.position);
        wrapped.putInt(index, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.144 -0500", hash_original_method = "B61E2BCE20718AB5D9F89E85EFF0C1EE", hash_generated_method = "F8725B4B3E62D24B8D4AF65121BFDE49")
    @Override
public ByteBuffer putInt(int value) {
        wrapped.position(this.position);
        wrapped.putInt(value);
        this.position += SizeOf.INT;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.145 -0500", hash_original_method = "71459AF6B6AC0C4B26EB70F2F396DC3A", hash_generated_method = "30EC73F60EFFE96266F62AA92EE0ED5A")
    @Override
public ByteBuffer putLong(int index, long value) {
        wrapped.position(this.position);
        wrapped.putLong(index, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.145 -0500", hash_original_method = "1118E0528407DB1AA30DD23367DFDBDC", hash_generated_method = "EAD479C56521DC09E255AFAD8763DECD")
    @Override
public ByteBuffer putLong(long value) {
        wrapped.position(this.position);
        wrapped.putLong(value);
        this.position += SizeOf.LONG;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.146 -0500", hash_original_method = "5B51CDEBF6AB573576FFED982377810B", hash_generated_method = "EAF98165E3F7C110C3DB9ED056DEA90C")
    @Override
public ByteBuffer putShort(int index, short value) {
        wrapped.position(this.position);
        wrapped.putShort(index, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.147 -0500", hash_original_method = "EB14AF156A87035F01282D29F445B16B", hash_generated_method = "38F207756377A3F12037AD0563C266A1")
    @Override
public ByteBuffer putShort(short value) {
        wrapped.position(this.position);
        wrapped.putShort(value);
        this.position += SizeOf.SHORT;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.148 -0500", hash_original_method = "6E049AFA213C3C5078EB6770A9689DFA", hash_generated_method = "F3474A422DAC99EB162331AA8D10E148")
    @Override
public ByteBuffer slice() {
        wrapped.position(this.position);
        MappedByteBufferAdapter result = new MappedByteBufferAdapter(wrapped.slice());
        wrapped.clear();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.149 -0500", hash_original_method = "33CDC6092C78EAE8E1726040ED7707B5", hash_generated_method = "767CA2682DBBD640DCFB530C005D761B")
    @Override
byte[] protectedArray() {
        return wrapped.protectedArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.149 -0500", hash_original_method = "07409272224D2DCFB9ED6864BAB477CC", hash_generated_method = "134B0097441C3DA2147356AF627E4718")
    @Override
int protectedArrayOffset() {
        return wrapped.protectedArrayOffset();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.150 -0500", hash_original_method = "088F278FB6BC57CD2CF8BD7E84B85911", hash_generated_method = "24049EBE4EF2A45ED9500C2EFFE43C20")
    @Override
boolean protectedHasArray() {
        return wrapped.protectedHasArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:35.151 -0500", hash_original_method = "845658F397739B9672DA207B5DA44048", hash_generated_method = "116462157B1262F6A3DDBF167E4AAA08")
    public final void free() {
        wrapped.free();
    }

    
}

