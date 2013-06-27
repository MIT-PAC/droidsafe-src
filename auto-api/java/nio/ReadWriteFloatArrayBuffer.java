package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.033 -0400", hash_original_method = "5A8DCC269DCB08038721B4A37F7722F4", hash_generated_method = "917D66AB646F81D9388A210DA86C5D6F")
      ReadWriteFloatArrayBuffer(float[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.034 -0400", hash_original_method = "495FFBE47D4B4B6385F4C7F54B916311", hash_generated_method = "6395FB40A1F17E2D269D92B633E16471")
      ReadWriteFloatArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.034 -0400", hash_original_method = "2552E9D1905F4AE718E09F5BFBACBECB", hash_generated_method = "DB5BF54DAA1E96E71EE81B5E38733F43")
      ReadWriteFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadWriteFloatArrayBuffer copy(FloatArrayBuffer other, int markOfOther) {
        ReadWriteFloatArrayBuffer buf =
                new ReadWriteFloatArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.035 -0400", hash_original_method = "497069A519BB7A8E272B0965E0C603B5", hash_generated_method = "75C6738FF27A1EF6F1701411A59A6264")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_69377295 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_69377295 = ReadOnlyFloatArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_69377295.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_69377295;
        // ---------- Original Method ----------
        //return ReadOnlyFloatArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.041 -0400", hash_original_method = "22708AB3F2B534798FB2EED23A67DC19", hash_generated_method = "723EC3BA5C595EBBDD1AC0C7A4D5853F")
    @Override
    public FloatBuffer compact() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_2000982897 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_2000982897 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2000982897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2000982897;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.042 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "CD5A0010FEE01076C2334216B32AA81B")
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_591873883 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_591873883 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_591873883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_591873883;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.043 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "DE8A503F20A45A22438D228208788570")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576788856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576788856;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.043 -0400", hash_original_method = "902CC876A0B5CBA68FC4A86CDFA0BAEB", hash_generated_method = "C4ECE0046876DED8A11730B257E324A8")
    @Override
    protected float[] protectedArray() {
        float[] varB2C245003BAB9224CFB496218F7DAFE0_1980571394 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1980571394;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.043 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B250D2CE851CBD2D0C73C713790F0525")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815606904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815606904;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.054 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F6500832553BE37C4A77B245D4A49A92")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_782460413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_782460413;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.055 -0400", hash_original_method = "13B22E8941626D16AD9A1C582F86CDB9", hash_generated_method = "0293A2A0DF41EC265EFB5D7451A6CD59")
    @Override
    public FloatBuffer put(float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1118409705 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1118409705 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1118409705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1118409705;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.056 -0400", hash_original_method = "DA3D1DBD794212B37FED89EC3B7543A3", hash_generated_method = "42EA4AA35BAD919B2DBF884AAEE54F0A")
    @Override
    public FloatBuffer put(int index, float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1852578237 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1852578237 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1852578237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1852578237;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.057 -0400", hash_original_method = "596A2808C1B03A79358C8C3443A19501", hash_generated_method = "D77099455461BD40934E1840DE7A3953")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1143874095 = null; //Variable for return #1
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_1067198654 = (floatCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_1143874095 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_1143874095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1143874095;
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.067 -0400", hash_original_method = "B98DF5C640FB2DE362AEC4E72A11F767", hash_generated_method = "F2E005607964D80C870BD17BA516EBAF")
    @Override
    public FloatBuffer slice() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_642485739 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_642485739 = new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_642485739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_642485739;
        // ---------- Original Method ----------
        //return new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

