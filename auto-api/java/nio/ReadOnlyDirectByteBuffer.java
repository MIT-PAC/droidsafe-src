package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyDirectByteBuffer extends DirectByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.881 -0400", hash_original_method = "1715B2F560D367598620CD9007B078BC", hash_generated_method = "410B2FFB91AF34A32DB64BFD196E7948")
    protected  ReadOnlyDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
        addTaint(block.getTaint());
        addTaint(capacity);
        addTaint(offset);
        // ---------- Original Method ----------
    }

    
    static ReadOnlyDirectByteBuffer copy(DirectByteBuffer other, int markOfOther) {
        ReadOnlyDirectByteBuffer buf = new ReadOnlyDirectByteBuffer(other.block, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.883 -0400", hash_original_method = "2BD76B330996D00438E1C4822CA878DE", hash_generated_method = "A234495DA8AB827AE7A16DC47AF12D1B")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1537653555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1537653555 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1537653555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1537653555;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.884 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "D5E46093681AF6A8F8AD951CFA704E70")
    @Override
    public ByteBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.885 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "B562FC281214281583C776FE269C8511")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_2073487 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2073487 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_2073487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2073487;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.886 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "585F91F6CF4768827FCE1389A39C5C4D")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099210352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099210352;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.887 -0400", hash_original_method = "7260EDFD38A12D119BC6271ED3EA27DF", hash_generated_method = "2C6BD91056AC353F93B58588DABF2E82")
    @Override
    public ByteBuffer put(byte value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.888 -0400", hash_original_method = "1C2CBE90B4E9D1A3B1F660933A2EE69D", hash_generated_method = "02C99795A90A724D78B7854ECEF3A2CC")
    @Override
    public ByteBuffer put(int index, byte value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.889 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "FDF56450842EBED47B98E414D691AC0C")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.890 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "D70859699741A6891DCEA0F5409BEFC2")
    @Override
    public ByteBuffer putDouble(double value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.890 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "1C7A537CC802D3829D7FC4A928A62556")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.891 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "7FBAE86B9FFB68D33B671BDD9D245E19")
    @Override
    public ByteBuffer putFloat(float value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.892 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "0AFEFAA6FED13154E3C147AD9EB2A042")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.892 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "CB96D7D28156A59A32CFEB7A913328E7")
    @Override
    public ByteBuffer putInt(int value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.893 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "A16FBFAB90E8A7D3AA329600BBB1BBF6")
    @Override
    public ByteBuffer putInt(int index, int value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.893 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "801A42EFD5AB018EC4D38A73586C4D6D")
    @Override
    public ByteBuffer putLong(int index, long value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.894 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "4C2A2570CCABB47FB826876A8A454017")
    @Override
    public ByteBuffer putLong(long value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.894 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "0BF978FBE2613C05BA52A754063443D2")
    @Override
    public ByteBuffer putShort(int index, short value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.895 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "415AD4B6ED60213B12BB212CE2906F94")
    @Override
    public ByteBuffer putShort(short value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.895 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "3C60D238D34B91E8F4288E5C1E8E295A")
    @Override
    public ByteBuffer put(ByteBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.896 -0400", hash_original_method = "A324C872B4E541735F8503145991A120", hash_generated_method = "4E05B60DA9A05E56CCDE7C7A4DF9FFE5")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1773899219 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1773899219 = new ReadOnlyDirectByteBuffer(block, remaining(), offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1773899219.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1773899219;
        // ---------- Original Method ----------
        //return new ReadOnlyDirectByteBuffer(block, remaining(), offset + position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.896 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "F1CC33F2E1CA093377D75D9E971E7ADB")
    @Override
    protected byte[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1568975248 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1568975248;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.896 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "51CD6087EE49D73D85B03CA15F272FE4")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283007507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283007507;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.897 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "15C0AB652623F00B65E54BC1E5CB1579")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723662760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723662760;
        // ---------- Original Method ----------
        //return false;
    }

    
}

