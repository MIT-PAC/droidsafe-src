package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.881 -0400", hash_original_method = "45CC985A35F0F1494520573D6ACE292A", hash_generated_method = "DF437A528D95C52D346BC9EB6C3A5357")
      ReadOnlyCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadOnlyCharArrayBuffer buf =
                new ReadOnlyCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.883 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "35F68310533560FFC26841E3C574C82A")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_2095017026 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2095017026 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_2095017026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2095017026;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.891 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "FDB048D4EFBE0B834B0B887336BCFF0E")
    @Override
    public CharBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.893 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "5ACAC4AAF536D281A6ADC4E37CD7C2EB")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_627985805 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_627985805 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_627985805.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_627985805;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.907 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "FC20EBEB3F510B135004DC158F59B0EE")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185456324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185456324;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.907 -0400", hash_original_method = "0F9E5668E984B4901FBF78711C9DAE7C", hash_generated_method = "CACAA68BB7A2AF5EB9736EFF70843142")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_139241524 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_139241524;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.907 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "B3C1AAA6BC13141E7314F978D00DB002")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413544070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413544070;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.908 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4F0AE8BE5058B696D3D406E180F22896")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590419385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590419385;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.908 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "3A85A20458CD46C3155C147F6F048806")
    @Override
    public CharBuffer put(char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.909 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "E150AA8DCB8978B57C618C5428A755CD")
    @Override
    public CharBuffer put(int index, char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.909 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "18EBBD5FFFA53649B304121971BF9CEA")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.922 -0400", hash_original_method = "FB6FEA0A32E7A03D5D90CE6B495DAC9B", hash_generated_method = "41BBA8D35D08A1CA6355F037B035805D")
    @Override
    public final CharBuffer put(CharBuffer src) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.923 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "29F4042A72DFAB1AB12EB8C658A3318C")
    @Override
    public CharBuffer put(String src, int start, int end) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.924 -0400", hash_original_method = "B45CBDD156981DE98E6537855A7A214E", hash_generated_method = "147651590966FC732443539E8B28EAF8")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_428819459 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_428819459 = new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_428819459.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_428819459;
        // ---------- Original Method ----------
        //return new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

