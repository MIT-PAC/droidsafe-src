package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.111 -0400", hash_original_method = "8D9DDDEFB3AB21DD4A0254B750731D70", hash_generated_method = "FBE6D4444647FC0D91F17CC3B3839210")
      ReadWriteIntArrayBuffer(int[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.115 -0400", hash_original_method = "43CEDB64CCBA692E544DE7CD0AC198FC", hash_generated_method = "D5824848B8F8069FF2A536AD7318DD6E")
      ReadWriteIntArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.120 -0400", hash_original_method = "A26E8A674EF0ED3D9F3331CA6DE93799", hash_generated_method = "26EBBD09F55D7885EFA6C159947723C8")
      ReadWriteIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadWriteIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadWriteIntArrayBuffer buf =
                new ReadWriteIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.120 -0400", hash_original_method = "4B95192F4339BC062AF51933230B3F0C", hash_generated_method = "3AD24F9E839F5C65566D45E4D018E119")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_2114644413 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2114644413 = ReadOnlyIntArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_2114644413.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114644413;
        // ---------- Original Method ----------
        //return ReadOnlyIntArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.121 -0400", hash_original_method = "62E2BDB6C89716847449D50CC36598CA", hash_generated_method = "E4255F39C0C57CA7FDFCF534D319E3E1")
    @Override
    public IntBuffer compact() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_322848955 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_322848955 = this;
        varB4EAC82CA7396A68D541C85D26508E83_322848955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_322848955;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.149 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "DF281D026ECF966018D8DA5A84234EFC")
    @Override
    public IntBuffer duplicate() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_973710496 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_973710496 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_973710496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_973710496;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.153 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "D36660E3CD21F1643AF310DE834CC156")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058435703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058435703;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.163 -0400", hash_original_method = "A905887CE8C7700C79178CD7C8EB8B1A", hash_generated_method = "BAC4103D3591B90E17CF5BAD0AAD52C7")
    @Override
    protected int[] protectedArray() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_880801400 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_880801400;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.164 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "4B2931ADE142D63B1BE3C18E39D6C5D5")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175037483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175037483;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.164 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "0B295FCCAF9C9C58B42F31D03A25347B")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268752285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268752285;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.164 -0400", hash_original_method = "24A625E8D082FBF527A2D93F3C5BC8E0", hash_generated_method = "425726F8C37B2FF9440B6EDC05953122")
    @Override
    public IntBuffer put(int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_795221951 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_795221951 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_795221951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_795221951;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.165 -0400", hash_original_method = "2E47BE1B8B3BBE9EFD962F4A517C459A", hash_generated_method = "3EF0F5A4D823FD6959435EFB9CC1EB58")
    @Override
    public IntBuffer put(int index, int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1891211920 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1891211920 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1891211920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1891211920;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.168 -0400", hash_original_method = "F72176B11CC709D09C4C37209C319F78", hash_generated_method = "D71883D5760413BF50AACB37A59052E9")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1868619474 = null; //Variable for return #1
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_19432882 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_1868619474 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1868619474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868619474;
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.171 -0400", hash_original_method = "E64EEB28D2F233E17F9AAF235F4E0576", hash_generated_method = "8F228CFC1749B83DE5FA8CB493204B6B")
    @Override
    public IntBuffer slice() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1725248549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1725248549 = new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1725248549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1725248549;
        // ---------- Original Method ----------
        //return new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

