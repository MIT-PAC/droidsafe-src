package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.021 -0400", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "B6FB4023B182229615CC0744C948C988")
      ReadWriteCharArrayBuffer(char[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.021 -0400", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "6F7DBD898BDA1001DEF746EF80CCC230")
      ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.021 -0400", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "7311D068D571957BB4530D893DE1BB74")
      ReadWriteCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadWriteCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadWriteCharArrayBuffer buf =
                new ReadWriteCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.022 -0400", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "BF8E6EC1E1C3FC49C590DE5E6672EC63")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_777954907 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_777954907 = ReadOnlyCharArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_777954907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_777954907;
        // ---------- Original Method ----------
        //return ReadOnlyCharArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.036 -0400", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "B2F943D12D3FBA1FE7143A87A8F88D70")
    @Override
    public CharBuffer compact() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_2103634209 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_2103634209 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2103634209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2103634209;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.036 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "4CC05DA4025BDD863EDAFA97EC7347CE")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_669064964 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_669064964 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_669064964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_669064964;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.037 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "5D6B01422B3FF04060C64DCDF1D043B3")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586508644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586508644;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.037 -0400", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "50BEC9A44EB2E3774D0593484DF6C99F")
    @Override
    protected char[] protectedArray() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_845575040 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_845575040;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.037 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "3B647422D71D0CD222684BEC3E4A16C9")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745253287 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745253287;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.038 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "CF56A7A02CC82E41C37951292000D46C")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622764273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622764273;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.051 -0400", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "A7738ED7905BBB2AFDEE3D0690E5E3BC")
    @Override
    public CharBuffer put(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_443132547 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_443132547 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_443132547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443132547;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.054 -0400", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "5D31DEF5C7E9E5645DE3925267FC902B")
    @Override
    public CharBuffer put(int index, char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_155622163 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_155622163 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_155622163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_155622163;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.054 -0400", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "D16CDD730540B2009C3008CBEDEC647F")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_677227337 = null; //Variable for return #1
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1736950414 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_677227337 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_677227337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_677227337;
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.055 -0400", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "401D07F59A140F316ABB9146052C24CE")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_464235104 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_464235104 = new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_464235104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_464235104;
        // ---------- Original Method ----------
        //return new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

