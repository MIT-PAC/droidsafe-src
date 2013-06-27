package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.101 -0400", hash_original_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41", hash_generated_method = "55B4923DA3F935D80CF9E9294A9995E3")
      ReadWriteShortArrayBuffer(short[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.101 -0400", hash_original_method = "D514769C5D5F8B6E9B68E0333601C0ED", hash_generated_method = "231BB39C0D50E7FFC13D6EB0885AFC60")
      ReadWriteShortArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.111 -0400", hash_original_method = "9C56AF79FD26FC5F344A35E3553FC338", hash_generated_method = "54BC2C5B47493D743460EFCD83C4DF7B")
      ReadWriteShortArrayBuffer(int capacity, short[] backingArray,
            int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.112 -0400", hash_original_method = "462C3B568A7739CEDBF963B6B469485C", hash_generated_method = "DF8AB706B88B96E7B19B1B76365657A7")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1857207375 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1857207375 = ReadOnlyShortArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1857207375.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1857207375;
        // ---------- Original Method ----------
        //return ReadOnlyShortArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.127 -0400", hash_original_method = "36F9748654A1F1F28EBEE4901281019B", hash_generated_method = "AB4E7407A8D974B63E69DFDDC6643E41")
    @Override
    public ShortBuffer compact() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1750666399 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1750666399 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1750666399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1750666399;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.132 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "8ED709BB8C2CD59CAC134BE48872BC2D")
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1983893573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1983893573 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1983893573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1983893573;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.133 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "5B03C972451138E3D606F47F1C5E0D09")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492341616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492341616;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.133 -0400", hash_original_method = "085A06B6EDE16089D63E0B4E0858AD77", hash_generated_method = "0A9304995EBE467D67B1F49C18D9C829")
    @Override
    protected short[] protectedArray() {
        short[] var48EE7E2DDF8A83602BC526873BD0F875_1538078000 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1538078000;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.133 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "4A5ECF7A86C98071FD7A81C66B8D4B21")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746489041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746489041;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.133 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "B8F71D11FC79DD791F5FA7DB53F75A2E")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117045092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_117045092;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.134 -0400", hash_original_method = "54E323A30539354E0A95916606A58A4C", hash_generated_method = "EE8C3F1F3FCA5881F95E425FE32A2D4B")
    @Override
    public ShortBuffer put(short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1239199560 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1239199560 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1239199560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1239199560;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.138 -0400", hash_original_method = "40ADB3B61FB69E1E8C75AAC651E43068", hash_generated_method = "F569E5A32F8E72D4D31CEDBB81F5528E")
    @Override
    public ShortBuffer put(int index, short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_350060842 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_350060842 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_350060842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_350060842;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.143 -0400", hash_original_method = "2F2CA14AF95FC5682B6555E8CB32AB80", hash_generated_method = "1FCBAB9726FBDA0329E9F0CB5013B8C5")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_697230464 = null; //Variable for return #1
        {
            boolean varD727A1D2181C264BA4333582F807AE27_476826123 = (shortCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_697230464 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_697230464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697230464;
        // ---------- Original Method ----------
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        //position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.146 -0400", hash_original_method = "295BE67A092E5DAA08585681B1E9120C", hash_generated_method = "0FF3F6D6C6C362D55FDE159EC47CE9EE")
    @Override
    public ShortBuffer slice() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_2102993232 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2102993232 = new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_2102993232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2102993232;
        // ---------- Original Method ----------
        //return new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

