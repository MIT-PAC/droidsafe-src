package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.986 -0400", hash_original_method = "01590DEAE9E3D05BD420F8A41610BAB0", hash_generated_method = "53490D8F4D44CC295B4DAA33131F5117")
      ReadOnlyIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadOnlyIntArrayBuffer buf =
                new ReadOnlyIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.987 -0400", hash_original_method = "6813C80E6F33BB643F69D9471CD54ED3", hash_generated_method = "5946BD255881E097101E1444DF08CC56")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_203006520 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_203006520 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_203006520.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_203006520;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.006 -0400", hash_original_method = "95709EC066A435B9AA3687E160003D5F", hash_generated_method = "2E07CDDA83623EEEC20C06CAAB20BF24")
    @Override
    public IntBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.007 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "FD2AB78C5FABCAA6731D33A3EE8B15BE")
    @Override
    public IntBuffer duplicate() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_43925342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_43925342 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_43925342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_43925342;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.007 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "9F17EB8F660B7D4992C84D9FD2B21AF9")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292478779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292478779;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.016 -0400", hash_original_method = "0A06910467E88EE62CDFBCBE0CB802DA", hash_generated_method = "88F7551B0AA10747DE49535695A3862A")
    @Override
    protected int[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_444381668 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_444381668;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.016 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "6456B38385B1D19C5D340D74C2288F0B")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930250402 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930250402;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.016 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "3F2D96610D5E1C5F6819E346BB1817D7")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129032679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129032679;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.017 -0400", hash_original_method = "09ED0F57CBC06365DA988C0313F02515", hash_generated_method = "892777327ACCB9CDC5B78355F374F2E1")
    @Override
    public IntBuffer put(int c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.017 -0400", hash_original_method = "72974DF4DE68C45A0CAEDB3056BAFC34", hash_generated_method = "6226D1A0AF1AED0C3E3ACC43EB47CAC3")
    @Override
    public IntBuffer put(int index, int c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.018 -0400", hash_original_method = "0AE015769B07B9A1C6447FCD87483B4D", hash_generated_method = "69A05A33F2A6F78FD706A717405F48E9")
    @Override
    public IntBuffer put(IntBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.018 -0400", hash_original_method = "4CDCCEB43894118BDB0755D2BC3EFD49", hash_generated_method = "36764FD3BF28FC916C4540CFF482A5FD")
    @Override
    public final IntBuffer put(int[] src, int srcOffset, int intCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.018 -0400", hash_original_method = "7D836F4D3C901F2E02BB73C6A2A966F7", hash_generated_method = "925863E3E0B90BC64E3CB241AE5B3981")
    @Override
    public IntBuffer slice() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1892793923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1892793923 = new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1892793923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1892793923;
        // ---------- Original Method ----------
        //return new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

