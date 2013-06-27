package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.838 -0400", hash_original_method = "45CC985A35F0F1494520573D6ACE292A", hash_generated_method = "DF437A528D95C52D346BC9EB6C3A5357")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.839 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "307896C0482F8CFA9194A6F159265E93")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1574246507 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1574246507 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_1574246507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1574246507;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.839 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "FDB048D4EFBE0B834B0B887336BCFF0E")
    @Override
    public CharBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.839 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "0EA5FC1D233BF93108D2D9188E6995C7")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1941551327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1941551327 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1941551327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1941551327;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.840 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "0424269769EF303E5FADB6E17C0585D7")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156389583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156389583;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.840 -0400", hash_original_method = "0F9E5668E984B4901FBF78711C9DAE7C", hash_generated_method = "EF4B553B72EC96A63B4126F117DEB711")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1946144486 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1946144486;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.840 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "C62F070622C6AD27556F58649488CDE7")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545060725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545060725;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.864 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "3CD8E9822504E8B380B52839AC0F46E8")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_294218723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_294218723;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.865 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "3A85A20458CD46C3155C147F6F048806")
    @Override
    public CharBuffer put(char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.865 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "E150AA8DCB8978B57C618C5428A755CD")
    @Override
    public CharBuffer put(int index, char c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.865 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "18EBBD5FFFA53649B304121971BF9CEA")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.866 -0400", hash_original_method = "FB6FEA0A32E7A03D5D90CE6B495DAC9B", hash_generated_method = "41BBA8D35D08A1CA6355F037B035805D")
    @Override
    public final CharBuffer put(CharBuffer src) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.866 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "29F4042A72DFAB1AB12EB8C658A3318C")
    @Override
    public CharBuffer put(String src, int start, int end) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.867 -0400", hash_original_method = "B45CBDD156981DE98E6537855A7A214E", hash_generated_method = "C4DA96017B4A12B38A7155FE2660D83B")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1923264884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1923264884 = new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1923264884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1923264884;
        // ---------- Original Method ----------
        //return new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

