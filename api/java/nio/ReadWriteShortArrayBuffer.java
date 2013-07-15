package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadWriteShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.188 -0400", hash_original_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41", hash_generated_method = "55B4923DA3F935D80CF9E9294A9995E3")
      ReadWriteShortArrayBuffer(short[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.188 -0400", hash_original_method = "D514769C5D5F8B6E9B68E0333601C0ED", hash_generated_method = "231BB39C0D50E7FFC13D6EB0885AFC60")
      ReadWriteShortArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.189 -0400", hash_original_method = "9C56AF79FD26FC5F344A35E3553FC338", hash_generated_method = "C614BAC9B583D7A545AC4CCCA4360A3D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.189 -0400", hash_original_method = "462C3B568A7739CEDBF963B6B469485C", hash_generated_method = "A00D31607A35E25D0F8A5E1F0B092664")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
ShortBuffer var8D30BF4939C2BDE4EA402152883AE49A_82209822 =         ReadOnlyShortArrayBuffer.copy(this, mark);
        var8D30BF4939C2BDE4EA402152883AE49A_82209822.addTaint(taint);
        return var8D30BF4939C2BDE4EA402152883AE49A_82209822;
        // ---------- Original Method ----------
        //return ReadOnlyShortArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.190 -0400", hash_original_method = "36F9748654A1F1F28EBEE4901281019B", hash_generated_method = "44AE4A1DE4B9DE79397754CA5EB2D7C5")
    @Override
    public ShortBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1466509512 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1466509512.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1466509512;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.190 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "457D9BB4419FBCA76684B7F5E567139D")
    @Override
    public ShortBuffer duplicate() {
ShortBuffer var6ED4708F04CD11720ECFFDBFD927116F_353531642 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_353531642.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_353531642;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.191 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "EA81C6126D206C846BCC653C8D8E33E0")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_548047155 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662280049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662280049;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.191 -0400", hash_original_method = "085A06B6EDE16089D63E0B4E0858AD77", hash_generated_method = "A5FB67B1CCB7AE0FAF908A7DFE7F83D8")
    @Override
    protected short[] protectedArray() {
        short[] var8D50CD27AA8B6BEC65C484FFCC5B2334_1723821628 = (backingArray);
                short[] var48EE7E2DDF8A83602BC526873BD0F875_1813135680 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1813135680;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.191 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B228431B79550B9726BE7F3024039402")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_544553710 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195935386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195935386;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.192 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "FB87B7F5CF3F9D84D96A1A60161A7CD3")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_1221921282 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377932017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377932017;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.192 -0400", hash_original_method = "54E323A30539354E0A95916606A58A4C", hash_generated_method = "1630A41A2277C4A4C9E84114261C82D5")
    @Override
    public ShortBuffer put(short c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1876751467 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1876751467.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1876751467;
        } //End block
        backingArray[offset + position++] = c;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_465581891 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_465581891.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_465581891;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.193 -0400", hash_original_method = "40ADB3B61FB69E1E8C75AAC651E43068", hash_generated_method = "EAEDA53D68C82ADD27E7CDB92C6F4E7D")
    @Override
    public ShortBuffer put(int index, short c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_2073178275 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2073178275.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2073178275;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.193 -0400", hash_original_method = "2F2CA14AF95FC5682B6555E8CB32AB80", hash_generated_method = "621A8E944271531D481EE6070C61D499")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
    if(shortCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_71417615 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_71417615.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_71417615;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        position += shortCount;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1430135301 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1430135301.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1430135301;
        // ---------- Original Method ----------
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        //position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.194 -0400", hash_original_method = "295BE67A092E5DAA08585681B1E9120C", hash_generated_method = "AADFA63C7B1829254CAD165D6E6245AC")
    @Override
    public ShortBuffer slice() {
ShortBuffer var6502F9D0CA12D865EEBE408CDEC29611_1610308799 =         new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
        var6502F9D0CA12D865EEBE408CDEC29611_1610308799.addTaint(taint);
        return var6502F9D0CA12D865EEBE408CDEC29611_1610308799;
        // ---------- Original Method ----------
        //return new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

