package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.072 -0400", hash_original_method = "5A8DCC269DCB08038721B4A37F7722F4", hash_generated_method = "917D66AB646F81D9388A210DA86C5D6F")
      ReadWriteFloatArrayBuffer(float[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.075 -0400", hash_original_method = "495FFBE47D4B4B6385F4C7F54B916311", hash_generated_method = "6395FB40A1F17E2D269D92B633E16471")
      ReadWriteFloatArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.076 -0400", hash_original_method = "2552E9D1905F4AE718E09F5BFBACBECB", hash_generated_method = "DB5BF54DAA1E96E71EE81B5E38733F43")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.090 -0400", hash_original_method = "497069A519BB7A8E272B0965E0C603B5", hash_generated_method = "70F7ADD45499EAA7C8F1AFF1C754617C")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1929487504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1929487504 = ReadOnlyFloatArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1929487504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929487504;
        // ---------- Original Method ----------
        //return ReadOnlyFloatArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.091 -0400", hash_original_method = "22708AB3F2B534798FB2EED23A67DC19", hash_generated_method = "8A80E8A97A29E74F9FDEE226A232D4C7")
    @Override
    public FloatBuffer compact() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1514489254 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1514489254 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1514489254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514489254;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.092 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "8F53A765696B4CB6607729059153C3BF")
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1271474993 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1271474993 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1271474993.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1271474993;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.092 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "D2DE7FE0A67DA71D483F7FE426A8D224")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663328559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_663328559;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.092 -0400", hash_original_method = "902CC876A0B5CBA68FC4A86CDFA0BAEB", hash_generated_method = "0C36ADA14ACDBCDAF71C218C0760C02B")
    @Override
    protected float[] protectedArray() {
        float[] varB2C245003BAB9224CFB496218F7DAFE0_1374027543 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1374027543;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.096 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "72EBB219DC512A27A199454C7590A246")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701414163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701414163;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.111 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "6DFD5DAE9C81E3C4B801E2EC9E0B11E5")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988636616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988636616;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.112 -0400", hash_original_method = "13B22E8941626D16AD9A1C582F86CDB9", hash_generated_method = "802B7877E60B1A4AAFCF47AAEBEEB48B")
    @Override
    public FloatBuffer put(float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_350404505 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_350404505 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_350404505.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_350404505;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.112 -0400", hash_original_method = "DA3D1DBD794212B37FED89EC3B7543A3", hash_generated_method = "6E1668F4FFF153609FEC1B9FD9722359")
    @Override
    public FloatBuffer put(int index, float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1833258864 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1833258864 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1833258864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1833258864;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.113 -0400", hash_original_method = "596A2808C1B03A79358C8C3443A19501", hash_generated_method = "2AE878986DCE3DC206D3CB39A3086358")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_733224880 = null; //Variable for return #1
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_1703877136 = (floatCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_733224880 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_733224880.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_733224880;
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.114 -0400", hash_original_method = "B98DF5C640FB2DE362AEC4E72A11F767", hash_generated_method = "8B621E50D1E33B51876478EA379CC8EB")
    @Override
    public FloatBuffer slice() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_318030050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_318030050 = new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_318030050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_318030050;
        // ---------- Original Method ----------
        //return new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

