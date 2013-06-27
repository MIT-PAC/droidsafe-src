package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.182 -0400", hash_original_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41", hash_generated_method = "55B4923DA3F935D80CF9E9294A9995E3")
      ReadWriteShortArrayBuffer(short[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.182 -0400", hash_original_method = "D514769C5D5F8B6E9B68E0333601C0ED", hash_generated_method = "231BB39C0D50E7FFC13D6EB0885AFC60")
      ReadWriteShortArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.182 -0400", hash_original_method = "9C56AF79FD26FC5F344A35E3553FC338", hash_generated_method = "54BC2C5B47493D743460EFCD83C4DF7B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.188 -0400", hash_original_method = "462C3B568A7739CEDBF963B6B469485C", hash_generated_method = "42DCC66020E51CEE53D6C6695C013AE5")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_2078061192 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2078061192 = ReadOnlyShortArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_2078061192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2078061192;
        // ---------- Original Method ----------
        //return ReadOnlyShortArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.192 -0400", hash_original_method = "36F9748654A1F1F28EBEE4901281019B", hash_generated_method = "FAA34B238F3B82F93D04FE98B418FD97")
    @Override
    public ShortBuffer compact() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1925212289 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1925212289 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1925212289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1925212289;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.207 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "7E2C4010F9CEF0D35841E3F0688B3DEA")
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1803322077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1803322077 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1803322077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1803322077;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.208 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "321FD1AEC951E5BF256C2BD457ABA852")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340026394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340026394;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.208 -0400", hash_original_method = "085A06B6EDE16089D63E0B4E0858AD77", hash_generated_method = "130CB219272033BADD60F805995A1C62")
    @Override
    protected short[] protectedArray() {
        short[] var48EE7E2DDF8A83602BC526873BD0F875_206948014 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_206948014;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.208 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "8CCA4467B9E24CFDA773F4F9743A0C13")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382797114 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382797114;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.218 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "CF2FFF4DA054132AB5A49948CFE23713")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047908368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047908368;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.231 -0400", hash_original_method = "54E323A30539354E0A95916606A58A4C", hash_generated_method = "00B1D313D842A2F512B1E136B055CD1B")
    @Override
    public ShortBuffer put(short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1981260008 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1981260008 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1981260008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1981260008;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.238 -0400", hash_original_method = "40ADB3B61FB69E1E8C75AAC651E43068", hash_generated_method = "E78CBB34A2573BA21BF3AC1B92803D28")
    @Override
    public ShortBuffer put(int index, short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_912066871 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_912066871 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_912066871.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_912066871;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.239 -0400", hash_original_method = "2F2CA14AF95FC5682B6555E8CB32AB80", hash_generated_method = "48BC5F61571E23D86C490285FE092433")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1672024915 = null; //Variable for return #1
        {
            boolean varD727A1D2181C264BA4333582F807AE27_723358373 = (shortCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_1672024915 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_1672024915.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1672024915;
        // ---------- Original Method ----------
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        //position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.239 -0400", hash_original_method = "295BE67A092E5DAA08585681B1E9120C", hash_generated_method = "55BD87656C68A28EA5C76186EC5F4F7F")
    @Override
    public ShortBuffer slice() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_651460533 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_651460533 = new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_651460533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_651460533;
        // ---------- Original Method ----------
        //return new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

