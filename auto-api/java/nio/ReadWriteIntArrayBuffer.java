package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.035 -0400", hash_original_method = "8D9DDDEFB3AB21DD4A0254B750731D70", hash_generated_method = "FBE6D4444647FC0D91F17CC3B3839210")
      ReadWriteIntArrayBuffer(int[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.035 -0400", hash_original_method = "43CEDB64CCBA692E544DE7CD0AC198FC", hash_generated_method = "D5824848B8F8069FF2A536AD7318DD6E")
      ReadWriteIntArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.049 -0400", hash_original_method = "A26E8A674EF0ED3D9F3331CA6DE93799", hash_generated_method = "26EBBD09F55D7885EFA6C159947723C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.050 -0400", hash_original_method = "4B95192F4339BC062AF51933230B3F0C", hash_generated_method = "09272BE49A1608BECBAAFA65689F464E")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1437899542 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1437899542 = ReadOnlyIntArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1437899542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1437899542;
        // ---------- Original Method ----------
        //return ReadOnlyIntArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.050 -0400", hash_original_method = "62E2BDB6C89716847449D50CC36598CA", hash_generated_method = "51D4158CBFFBDD0CBD4FA5448CF25F3F")
    @Override
    public IntBuffer compact() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_888278355 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_888278355 = this;
        varB4EAC82CA7396A68D541C85D26508E83_888278355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_888278355;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.051 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "86B223892499EF4AF8040297043BD0E7")
    @Override
    public IntBuffer duplicate() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1390819384 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1390819384 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1390819384.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1390819384;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.051 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "3CE3C559485F5A91E8954D3802BFC3CD")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75007048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75007048;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.051 -0400", hash_original_method = "A905887CE8C7700C79178CD7C8EB8B1A", hash_generated_method = "EEE3377365C79A88D8A098BA34D79F1C")
    @Override
    protected int[] protectedArray() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_184413425 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_184413425;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.052 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "3CEDAEFDB018ED1EB30DA0FA15E39612")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462086284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462086284;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.052 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "99BC714C9D9FD798500FD5F814BD00AE")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327799971 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327799971;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.052 -0400", hash_original_method = "24A625E8D082FBF527A2D93F3C5BC8E0", hash_generated_method = "AB4124B126B22F47A7E91CF7BA0C1308")
    @Override
    public IntBuffer put(int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1984291142 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1984291142 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1984291142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1984291142;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.057 -0400", hash_original_method = "2E47BE1B8B3BBE9EFD962F4A517C459A", hash_generated_method = "08516EAAB44107D1C2F1674EC0D2F0BB")
    @Override
    public IntBuffer put(int index, int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_2004723373 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_2004723373 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2004723373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2004723373;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.058 -0400", hash_original_method = "F72176B11CC709D09C4C37209C319F78", hash_generated_method = "32901D27962F03D9558E0C0D5F03B7E3")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1021708184 = null; //Variable for return #1
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_539628580 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_1021708184 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1021708184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1021708184;
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.058 -0400", hash_original_method = "E64EEB28D2F233E17F9AAF235F4E0576", hash_generated_method = "D031976CD652EEAE3D1BB84070EF123C")
    @Override
    public IntBuffer slice() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1939640504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1939640504 = new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1939640504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1939640504;
        // ---------- Original Method ----------
        //return new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

