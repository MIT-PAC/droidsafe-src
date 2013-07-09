package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadOnlyIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.959 -0400", hash_original_method = "01590DEAE9E3D05BD420F8A41610BAB0", hash_generated_method = "53490D8F4D44CC295B4DAA33131F5117")
      ReadOnlyIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadOnlyIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadOnlyIntArrayBuffer buf =
                new ReadOnlyIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.960 -0400", hash_original_method = "6813C80E6F33BB643F69D9471CD54ED3", hash_generated_method = "02C856D2885C56BEAF2D8D955F84BDE6")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_343076514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_343076514 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_343076514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_343076514;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.961 -0400", hash_original_method = "95709EC066A435B9AA3687E160003D5F", hash_generated_method = "2E07CDDA83623EEEC20C06CAAB20BF24")
    @Override
    public IntBuffer compact() {
throw new ReadOnlyBufferException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.961 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "81A1A6AD33D6A5C85D7456D95C2CE37F")
    @Override
    public IntBuffer duplicate() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1089930379 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1089930379 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1089930379.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1089930379;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.962 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "5E625D052DA99D01BC3E7D00D25759D9")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581934140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581934140;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.962 -0400", hash_original_method = "0A06910467E88EE62CDFBCBE0CB802DA", hash_generated_method = "D669170F7C3FA9C4E812AA36DB803B49")
    @Override
    protected int[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_911746882 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_911746882;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.962 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "9BF1A1261F3504D0E6E797EF67AE5879")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324019015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324019015;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.962 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "0CA72AF0EF32F54BAA6E08AB8B21C277")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648694174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648694174;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.963 -0400", hash_original_method = "09ED0F57CBC06365DA988C0313F02515", hash_generated_method = "892777327ACCB9CDC5B78355F374F2E1")
    @Override
    public IntBuffer put(int c) {
        throw new ReadOnlyBufferException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.964 -0400", hash_original_method = "72974DF4DE68C45A0CAEDB3056BAFC34", hash_generated_method = "6226D1A0AF1AED0C3E3ACC43EB47CAC3")
    @Override
    public IntBuffer put(int index, int c) {
        throw new ReadOnlyBufferException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.964 -0400", hash_original_method = "0AE015769B07B9A1C6447FCD87483B4D", hash_generated_method = "69A05A33F2A6F78FD706A717405F48E9")
    @Override
    public IntBuffer put(IntBuffer buf) {
         throw new ReadOnlyBufferException();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.965 -0400", hash_original_method = "4CDCCEB43894118BDB0755D2BC3EFD49", hash_generated_method = "36764FD3BF28FC916C4540CFF482A5FD")
    @Override
    public final IntBuffer put(int[] src, int srcOffset, int intCount) {
         throw new ReadOnlyBufferException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.966 -0400", hash_original_method = "7D836F4D3C901F2E02BB73C6A2A966F7", hash_generated_method = "1C794CEC20F3E00488A6F98DBF7C0D15")
    @Override
    public IntBuffer slice() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1399962507 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1399962507 = new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1399962507.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1399962507;
        
        
    }

    
}

