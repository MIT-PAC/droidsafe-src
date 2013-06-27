package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.960 -0400", hash_original_method = "2F2ACF3B9ABB2D0DAB5827DF665B4EAD", hash_generated_method = "9423D30F9DF81CE7C9A24AE261E339B9")
      ReadOnlyHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
        ReadOnlyHeapByteBuffer buf =
                new ReadOnlyHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.960 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "54CDE1613EACD967B9BDBD6E52AFA326")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_13854227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_13854227 = ReadOnlyHeapByteBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_13854227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_13854227;
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.961 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "D5E46093681AF6A8F8AD951CFA704E70")
    @Override
    public ByteBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.962 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "24CAD0273CA58EE1FACA1380416943A7")
    @Override
    public ByteBuffer duplicate() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1228784944 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1228784944 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1228784944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1228784944;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.962 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "87137B1E661AAEA6E350816BEAEEC5C1")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1343874149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1343874149;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.962 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "0749A969E937467A66589CECA891A59D")
    @Override
    protected byte[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_806510213 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_806510213;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.962 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "782D433FFC371A3DE7CCF7ABF0723601")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882860665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882860665;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.965 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "442A16C6D8CDDBEBA1B3A65A041B8216")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362616813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362616813;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.973 -0400", hash_original_method = "F6BE9BC005619EB0DCAA2A874D1401FC", hash_generated_method = "A932AABF0DE153C2BDF3652CE90417A3")
    @Override
    public ByteBuffer put(byte b) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(b);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.973 -0400", hash_original_method = "3C5952D8FAADE293E2AA7CAEA3FBDFDE", hash_generated_method = "96F0CDBCB30B153A5E85C990445D020B")
    @Override
    public ByteBuffer put(int index, byte b) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(b);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.974 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "FDF56450842EBED47B98E414D691AC0C")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.980 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "D70859699741A6891DCEA0F5409BEFC2")
    @Override
    public ByteBuffer putDouble(double value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.992 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "1C7A537CC802D3829D7FC4A928A62556")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.993 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "7FBAE86B9FFB68D33B671BDD9D245E19")
    @Override
    public ByteBuffer putFloat(float value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.993 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "0AFEFAA6FED13154E3C147AD9EB2A042")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.994 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "CB96D7D28156A59A32CFEB7A913328E7")
    @Override
    public ByteBuffer putInt(int value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.994 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "A16FBFAB90E8A7D3AA329600BBB1BBF6")
    @Override
    public ByteBuffer putInt(int index, int value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.995 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "801A42EFD5AB018EC4D38A73586C4D6D")
    @Override
    public ByteBuffer putLong(int index, long value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.995 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "4C2A2570CCABB47FB826876A8A454017")
    @Override
    public ByteBuffer putLong(long value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.996 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "0BF978FBE2613C05BA52A754063443D2")
    @Override
    public ByteBuffer putShort(int index, short value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.008 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "415AD4B6ED60213B12BB212CE2906F94")
    @Override
    public ByteBuffer putShort(short value) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(value);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.008 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "3C60D238D34B91E8F4288E5C1E8E295A")
    @Override
    public ByteBuffer put(ByteBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.008 -0400", hash_original_method = "6FE9FDD30B055D5D0C17F2FBAA978884", hash_generated_method = "D6F9DF77728192D3E1AC5E4EA216C5FE")
    @Override
    public ByteBuffer slice() {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1965664535 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1965664535 = new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1965664535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1965664535;
        // ---------- Original Method ----------
        //return new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

