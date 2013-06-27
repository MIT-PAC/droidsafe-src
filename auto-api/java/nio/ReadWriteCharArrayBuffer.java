package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.981 -0400", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "B6FB4023B182229615CC0744C948C988")
      ReadWriteCharArrayBuffer(char[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.981 -0400", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "6F7DBD898BDA1001DEF746EF80CCC230")
      ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.981 -0400", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "7311D068D571957BB4530D893DE1BB74")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.982 -0400", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "6AE4912B37ECB86515EEBA39EB27FB54")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1787948333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1787948333 = ReadOnlyCharArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1787948333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1787948333;
        // ---------- Original Method ----------
        //return ReadOnlyCharArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.983 -0400", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "445FD9EA648C5F08B59E3DD5E716CB8F")
    @Override
    public CharBuffer compact() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1333253217 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1333253217 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1333253217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1333253217;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.984 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "92DFBEB8D7A01C7993F4F1FCDF58CF5E")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1349432342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1349432342 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1349432342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1349432342;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.984 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "F36263D8BFD7F22A4DA12774303E5098")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_778541762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_778541762;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.988 -0400", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "D5D85F405FC852FABBE6B32A4A6E18B4")
    @Override
    protected char[] protectedArray() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_875663830 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_875663830;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.988 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "9920A2C0D8037FAAE79EB50B42E6352E")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040955583 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040955583;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.988 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "C8FB19DF74B3BC6B28658C9C0817EDF4")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788307865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788307865;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.989 -0400", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "B88BB28DA310D43A9788B168D3E1B825")
    @Override
    public CharBuffer put(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1377422571 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1377422571 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1377422571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1377422571;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.989 -0400", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "A8321EAA83AD7DDCBAC978B6DBF07D2F")
    @Override
    public CharBuffer put(int index, char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_88536462 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_88536462 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_88536462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_88536462;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.991 -0400", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "6AA47A637935A298297525E1101D5EFB")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1269970054 = null; //Variable for return #1
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1978226001 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_1269970054 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1269970054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1269970054;
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.999 -0400", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "D59230B935B8CA1BD59E268E79DACCA6")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1512291364 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512291364 = new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1512291364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512291364;
        // ---------- Original Method ----------
        //return new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

