package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadWriteShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.797 -0400", hash_original_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41", hash_generated_method = "55B4923DA3F935D80CF9E9294A9995E3")
      ReadWriteShortArrayBuffer(short[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.798 -0400", hash_original_method = "D514769C5D5F8B6E9B68E0333601C0ED", hash_generated_method = "231BB39C0D50E7FFC13D6EB0885AFC60")
      ReadWriteShortArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.798 -0400", hash_original_method = "9C56AF79FD26FC5F344A35E3553FC338", hash_generated_method = "C614BAC9B583D7A545AC4CCCA4360A3D")
      ReadWriteShortArrayBuffer(int capacity, short[] backingArray,
            int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    static ReadWriteShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadWriteShortArrayBuffer buf =
                new ReadWriteShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.799 -0400", hash_original_method = "462C3B568A7739CEDBF963B6B469485C", hash_generated_method = "C8D31DEBEC0A7E0BA098E7094A2704B1")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
ShortBuffer var8D30BF4939C2BDE4EA402152883AE49A_1699728884 =         ReadOnlyShortArrayBuffer.copy(this, mark);
        var8D30BF4939C2BDE4EA402152883AE49A_1699728884.addTaint(taint);
        return var8D30BF4939C2BDE4EA402152883AE49A_1699728884;
        // ---------- Original Method ----------
        //return ReadOnlyShortArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.800 -0400", hash_original_method = "36F9748654A1F1F28EBEE4901281019B", hash_generated_method = "08D51638C025A6233B7C97E9A953E0F3")
    @Override
    public ShortBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_151436295 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_151436295.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_151436295;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.800 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "B20FB448653EEA9D96E085CD088A7DA8")
    @Override
    public ShortBuffer duplicate() {
ShortBuffer var6ED4708F04CD11720ECFFDBFD927116F_568795348 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_568795348.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_568795348;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.801 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "AECA5C9E5C5D8DEE79D2E73315F88C3F")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1591714973 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916024546 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_916024546;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.801 -0400", hash_original_method = "085A06B6EDE16089D63E0B4E0858AD77", hash_generated_method = "04DB894160CA804C1AAB845E9B55A3AC")
    @Override
    protected short[] protectedArray() {
        short[] var8D50CD27AA8B6BEC65C484FFCC5B2334_868309670 = (backingArray);
                short[] var48EE7E2DDF8A83602BC526873BD0F875_754668668 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_754668668;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.801 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "FF0DB54D69B0717831CAC6D66014A2BB")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1631505482 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992975827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992975827;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.802 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "C6F11A829D9ED77168124E2868B6B1D2")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_1150093364 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271636244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271636244;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.802 -0400", hash_original_method = "54E323A30539354E0A95916606A58A4C", hash_generated_method = "8A7C8EDF9637482860014CBBD3B7A8D2")
    @Override
    public ShortBuffer put(short c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_233929149 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_233929149.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_233929149;
        } //End block
        backingArray[offset + position++] = c;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1132900415 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1132900415.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1132900415;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.803 -0400", hash_original_method = "40ADB3B61FB69E1E8C75AAC651E43068", hash_generated_method = "0CEFF9ADB985504DAE4BB582D8FDE67C")
    @Override
    public ShortBuffer put(int index, short c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_406692862 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_406692862.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_406692862;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.804 -0400", hash_original_method = "2F2CA14AF95FC5682B6555E8CB32AB80", hash_generated_method = "1B87BBCBB0DB0F2D1B4024BA53063099")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        if(shortCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_230662128 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_230662128.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_230662128;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        position += shortCount;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_860947246 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_860947246.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_860947246;
        // ---------- Original Method ----------
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        //position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.804 -0400", hash_original_method = "295BE67A092E5DAA08585681B1E9120C", hash_generated_method = "1229A572C8982C60272D4D8D13F4601E")
    @Override
    public ShortBuffer slice() {
ShortBuffer var6502F9D0CA12D865EEBE408CDEC29611_251116835 =         new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
        var6502F9D0CA12D865EEBE408CDEC29611_251116835.addTaint(taint);
        return var6502F9D0CA12D865EEBE408CDEC29611_251116835;
        // ---------- Original Method ----------
        //return new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

