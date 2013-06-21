package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.932 -0400", hash_original_method = "5A8DCC269DCB08038721B4A37F7722F4", hash_generated_method = "BDEF7EFC8368109E596168292ECE81EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteFloatArrayBuffer(float[] array) {
        super(array);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.932 -0400", hash_original_method = "495FFBE47D4B4B6385F4C7F54B916311", hash_generated_method = "401F6258AC69FBDF4C730E761B117F2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteFloatArrayBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.932 -0400", hash_original_method = "2552E9D1905F4AE718E09F5BFBACBECB", hash_generated_method = "97CDE9182E47E6CB53E25408E9E22F92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.932 -0400", hash_original_method = "497069A519BB7A8E272B0965E0C603B5", hash_generated_method = "71C92AFF77595BDF43CD5949E8639A37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer var31E02C882C3FC6FBF6512885CC6E3DD9_386317248 = (ReadOnlyFloatArrayBuffer.copy(this, mark));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyFloatArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.933 -0400", hash_original_method = "22708AB3F2B534798FB2EED23A67DC19", hash_generated_method = "3559472BBD8BAA4097EDE96C6F4FA9A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.933 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "20861758AF738091FDAA712582333221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer var8C82ED9E4FDE12C9486E1252174918B6_981776990 = (copy(this, mark));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.933 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.933 -0400", hash_original_method = "902CC876A0B5CBA68FC4A86CDFA0BAEB", hash_generated_method = "E565D3D49B0433F060E5DDF4F2248768")
    @DSModeled(DSC.SAFE)
    @Override
    protected float[] protectedArray() {
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.933 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B6AF1441163DC81E5A7523DBEAED19DC")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.933 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F14C0EBC785314AEABBE7CBCFAB3FB1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.934 -0400", hash_original_method = "13B22E8941626D16AD9A1C582F86CDB9", hash_generated_method = "59608F9072263BA465218B81CC275E8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(float c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.934 -0400", hash_original_method = "DA3D1DBD794212B37FED89EC3B7543A3", hash_generated_method = "0ED6DAE1ACBB98054A8C88387ED62D4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(int index, float c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        backingArray[offset + index] = c;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.934 -0400", hash_original_method = "596A2808C1B03A79358C8C3443A19501", hash_generated_method = "D15A1A31C3CB1F3E07529FA85B88E9A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(floatCount);
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_534599757 = (floatCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        position += floatCount;
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.934 -0400", hash_original_method = "B98DF5C640FB2DE362AEC4E72A11F767", hash_generated_method = "9C06A3BF99655D437EB2F816E498A5CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FloatBuffer slice() {
        FloatBuffer var3B00E64354D4F316336CB3D9E1169FD5_1325183791 = (new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position));
        return (FloatBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

