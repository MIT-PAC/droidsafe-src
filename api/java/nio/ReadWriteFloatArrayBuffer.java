package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadWriteFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.111 -0400", hash_original_method = "5A8DCC269DCB08038721B4A37F7722F4", hash_generated_method = "917D66AB646F81D9388A210DA86C5D6F")
      ReadWriteFloatArrayBuffer(float[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.112 -0400", hash_original_method = "495FFBE47D4B4B6385F4C7F54B916311", hash_generated_method = "6395FB40A1F17E2D269D92B633E16471")
      ReadWriteFloatArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.112 -0400", hash_original_method = "2552E9D1905F4AE718E09F5BFBACBECB", hash_generated_method = "788B1D252CFDFA93A6933DC63382BAE3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.113 -0400", hash_original_method = "497069A519BB7A8E272B0965E0C603B5", hash_generated_method = "197696473F542DB5B7A6AFACBC3A5B81")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
FloatBuffer var662A7D7A40DE737ABECA72224AE9CFE7_1523974315 =         ReadOnlyFloatArrayBuffer.copy(this, mark);
        var662A7D7A40DE737ABECA72224AE9CFE7_1523974315.addTaint(taint);
        return var662A7D7A40DE737ABECA72224AE9CFE7_1523974315;
        // ---------- Original Method ----------
        //return ReadOnlyFloatArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.113 -0400", hash_original_method = "22708AB3F2B534798FB2EED23A67DC19", hash_generated_method = "45EC2E9C2C1660BA8B84D502C3D455ED")
    @Override
    public FloatBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1944506581 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1944506581.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1944506581;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.114 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "3B9052344A93BE0E24A2288E09BC910A")
    @Override
    public FloatBuffer duplicate() {
FloatBuffer var6ED4708F04CD11720ECFFDBFD927116F_2017893389 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_2017893389.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_2017893389;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.114 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "46B2F9FD3FCF0D0C96937F5138C546E6")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_2126986722 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025657432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025657432;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.114 -0400", hash_original_method = "902CC876A0B5CBA68FC4A86CDFA0BAEB", hash_generated_method = "8CE1A8BF42DF7ACAEEF6E3387A2194D0")
    @Override
    protected float[] protectedArray() {
        float[] var8D50CD27AA8B6BEC65C484FFCC5B2334_393847632 = (backingArray);
                float[] varB2C245003BAB9224CFB496218F7DAFE0_1380898408 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1380898408;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.115 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "7D1EA631E2637627EAE3A4D853565A76")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_928620058 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129589163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129589163;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.115 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "7A8568E83E58CCDF153B4363E4B87218")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_1394048131 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832733266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832733266;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.116 -0400", hash_original_method = "13B22E8941626D16AD9A1C582F86CDB9", hash_generated_method = "3B039C50149856E098A7A531F14610EC")
    @Override
    public FloatBuffer put(float c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_952330027 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_952330027.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_952330027;
        } //End block
        backingArray[offset + position++] = c;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_214326483 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_214326483.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_214326483;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.116 -0400", hash_original_method = "DA3D1DBD794212B37FED89EC3B7543A3", hash_generated_method = "B43630351D0E494E96044BC965908E59")
    @Override
    public FloatBuffer put(int index, float c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_84440539 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_84440539.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_84440539;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.117 -0400", hash_original_method = "596A2808C1B03A79358C8C3443A19501", hash_generated_method = "69E82709863D6E2EBD416606056A910A")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
    if(floatCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1208046262 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1208046262.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1208046262;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        position += floatCount;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_952385394 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_952385394.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_952385394;
        // ---------- Original Method ----------
        //if (floatCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        //position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.117 -0400", hash_original_method = "B98DF5C640FB2DE362AEC4E72A11F767", hash_generated_method = "7984E21D432847077C42C573447A8779")
    @Override
    public FloatBuffer slice() {
FloatBuffer varB7E634233F23F9DCA9B81D011CD01E3C_1446455111 =         new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
        varB7E634233F23F9DCA9B81D011CD01E3C_1446455111.addTaint(taint);
        return varB7E634233F23F9DCA9B81D011CD01E3C_1446455111;
        // ---------- Original Method ----------
        //return new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

