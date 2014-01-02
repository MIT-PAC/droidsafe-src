package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




final class ReadOnlyDirectByteBuffer extends DirectByteBuffer {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.155 -0500", hash_original_method = "5E6A89B0C0F0E4E70CB99EAC68AD2CAC", hash_generated_method = "CDC852E68D158F951897410D08444896")
    
static ReadOnlyDirectByteBuffer copy(DirectByteBuffer other, int markOfOther) {
        ReadOnlyDirectByteBuffer buf = new ReadOnlyDirectByteBuffer(other.block, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.157 -0500", hash_original_method = "1715B2F560D367598620CD9007B078BC", hash_generated_method = "F05BD45A4A669995B39BD18D70459ADA")
    
protected ReadOnlyDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.160 -0500", hash_original_method = "2BD76B330996D00438E1C4822CA878DE", hash_generated_method = "E9745E849DF15E04E1A5A6F222DE5E5A")
    
@Override
    public ByteBuffer asReadOnlyBuffer() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.162 -0500", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "077F04774A20C0082DD03C3E2A797A75")
    
@Override
    public ByteBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.164 -0500", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "ED4EF02B9858C417E9309F42C851963A")
    
@Override
    public ByteBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.168 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
    
@Override
    public boolean isReadOnly() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.170 -0500", hash_original_method = "7260EDFD38A12D119BC6271ED3EA27DF", hash_generated_method = "E9BC339AACB9A8E7D763DEE303F6039F")
    
@Override
    public ByteBuffer put(byte value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.172 -0500", hash_original_method = "1C2CBE90B4E9D1A3B1F660933A2EE69D", hash_generated_method = "F5F6C3399D7EB712FB5C764445F1F84C")
    
@Override
    public ByteBuffer put(int index, byte value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.175 -0500", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "D831EC916321DB52F3301DB5CD73F5BC")
    
@Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.177 -0500", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "500142933DBF90738A4C8B8E723B3FD8")
    
@Override
    public ByteBuffer putDouble(double value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.180 -0500", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "25D87BF619D9A032E4C6E37081D3BE62")
    
@Override
    public ByteBuffer putDouble(int index, double value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.183 -0500", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "42A0CD0CCFB6AC96CE2EFD7E58C675DB")
    
@Override
    public ByteBuffer putFloat(float value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.185 -0500", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "565D0D9F5C7022BFF1A842A5DE683C81")
    
@Override
    public ByteBuffer putFloat(int index, float value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.187 -0500", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "14CCA7A20DA7D5549659417F7415D506")
    
@Override
    public ByteBuffer putInt(int value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.191 -0500", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "B007FD7EF205E7C38B39788290D7C31B")
    
@Override
    public ByteBuffer putInt(int index, int value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.193 -0500", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "F9756E5053DFED99410C20BD46BC79DE")
    
@Override
    public ByteBuffer putLong(int index, long value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.196 -0500", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "2054D951AA79E2D2781A2ADE108069E1")
    
@Override
    public ByteBuffer putLong(long value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.198 -0500", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "11BAA8664AAE5B9374F256E78204A00A")
    
@Override
    public ByteBuffer putShort(int index, short value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.201 -0500", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "879817F88E6064FC080E2F8BDD54F069")
    
@Override
    public ByteBuffer putShort(short value) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.203 -0500", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "69DF853CF3CDE579BA901FAE444AE4A5")
    
@Override
    public ByteBuffer put(ByteBuffer buf) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.205 -0500", hash_original_method = "A324C872B4E541735F8503145991A120", hash_generated_method = "31DFA0078CC8CA32B9B2243627B810E5")
    
@Override
    public ByteBuffer slice() {
        return new ReadOnlyDirectByteBuffer(block, remaining(), offset + position);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.208 -0500", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "2DB086672856E18F41212E7A3F2DAB23")
    
@Override protected byte[] protectedArray() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.211 -0500", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "74EBBCBD37A62C7AD6A8876E571480EF")
    
@Override protected int protectedArrayOffset() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:59.213 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override protected boolean protectedHasArray() {
        return false;
    }

    
}

