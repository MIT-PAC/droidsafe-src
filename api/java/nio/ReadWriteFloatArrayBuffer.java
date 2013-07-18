package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadWriteFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.703 -0400", hash_original_method = "5A8DCC269DCB08038721B4A37F7722F4", hash_generated_method = "917D66AB646F81D9388A210DA86C5D6F")
      ReadWriteFloatArrayBuffer(float[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.703 -0400", hash_original_method = "495FFBE47D4B4B6385F4C7F54B916311", hash_generated_method = "6395FB40A1F17E2D269D92B633E16471")
      ReadWriteFloatArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.704 -0400", hash_original_method = "2552E9D1905F4AE718E09F5BFBACBECB", hash_generated_method = "788B1D252CFDFA93A6933DC63382BAE3")
      ReadWriteFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.704 -0400", hash_original_method = "497069A519BB7A8E272B0965E0C603B5", hash_generated_method = "B4A309EC4313E7C74B55D074EEA74D6A")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
FloatBuffer var662A7D7A40DE737ABECA72224AE9CFE7_1874005285 =         ReadOnlyFloatArrayBuffer.copy(this, mark);
        var662A7D7A40DE737ABECA72224AE9CFE7_1874005285.addTaint(taint);
        return var662A7D7A40DE737ABECA72224AE9CFE7_1874005285;
        // ---------- Original Method ----------
        //return ReadOnlyFloatArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.705 -0400", hash_original_method = "22708AB3F2B534798FB2EED23A67DC19", hash_generated_method = "641FF2E6A51C892E69912F5AEE6B969A")
    @Override
    public FloatBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_354127097 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_354127097.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_354127097;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.705 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "ADCC5096E096B9A64F577130425F961C")
    @Override
    public FloatBuffer duplicate() {
FloatBuffer var6ED4708F04CD11720ECFFDBFD927116F_1511541557 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1511541557.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1511541557;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.705 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "EB675C02BEA453E5FCE6CF4AC2C8920D")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_555404618 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224958897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224958897;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.706 -0400", hash_original_method = "902CC876A0B5CBA68FC4A86CDFA0BAEB", hash_generated_method = "D2A270B3779DB328F1E7E9DE8E0170AC")
    @Override
    protected float[] protectedArray() {
        float[] var8D50CD27AA8B6BEC65C484FFCC5B2334_1045698995 = (backingArray);
                float[] varB2C245003BAB9224CFB496218F7DAFE0_1442118131 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1442118131;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.706 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "9B670EF74757201C11CC2355856092AC")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_2108667290 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091525846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091525846;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.706 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "D6A9BC1012C925235B8FCF6A750BC0FC")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_1028727162 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382572130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382572130;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.707 -0400", hash_original_method = "13B22E8941626D16AD9A1C582F86CDB9", hash_generated_method = "203B1DB82704B0965A56C3F71B81CA9E")
    @Override
    public FloatBuffer put(float c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1177784035 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1177784035.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1177784035;
        } //End block
        backingArray[offset + position++] = c;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_797698359 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_797698359.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_797698359;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.707 -0400", hash_original_method = "DA3D1DBD794212B37FED89EC3B7543A3", hash_generated_method = "D5C2AF6D70D3AAC9C0CC446589200207")
    @Override
    public FloatBuffer put(int index, float c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1650930050 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1650930050.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1650930050;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.708 -0400", hash_original_method = "596A2808C1B03A79358C8C3443A19501", hash_generated_method = "E982169082F54292DE2306D63C29A452")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        if(floatCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_176633735 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_176633735.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_176633735;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        position += floatCount;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1528035380 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1528035380.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1528035380;
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.709 -0400", hash_original_method = "B98DF5C640FB2DE362AEC4E72A11F767", hash_generated_method = "CDB03B529E65022EB4037AFB7663D563")
    @Override
    public FloatBuffer slice() {
FloatBuffer varB7E634233F23F9DCA9B81D011CD01E3C_575490280 =         new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
        varB7E634233F23F9DCA9B81D011CD01E3C_575490280.addTaint(taint);
        return varB7E634233F23F9DCA9B81D011CD01E3C_575490280;
        // ---------- Original Method ----------
        //return new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

