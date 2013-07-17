package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.616 -0400", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "B6FB4023B182229615CC0744C948C988")
      ReadWriteCharArrayBuffer(char[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.617 -0400", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "6F7DBD898BDA1001DEF746EF80CCC230")
      ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.618 -0400", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "666D28BBC989E92424B07D38DDE3804D")
      ReadWriteCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.619 -0400", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "783C96543A959039AF74FED0D297D7AB")
    @Override
    public CharBuffer asReadOnlyBuffer() {
CharBuffer var1FDEA19A7947A41FF37E5A6C10133CE4_1362702319 =         ReadOnlyCharArrayBuffer.copy(this, mark);
        var1FDEA19A7947A41FF37E5A6C10133CE4_1362702319.addTaint(taint);
        return var1FDEA19A7947A41FF37E5A6C10133CE4_1362702319;
        // ---------- Original Method ----------
        //return ReadOnlyCharArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.621 -0400", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "16DBBA174658887FDB790B2EE79D7349")
    @Override
    public CharBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1337228876 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1337228876.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1337228876;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.621 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "17BB05411991FD46658D72B0D065EF21")
    @Override
    public CharBuffer duplicate() {
CharBuffer var6ED4708F04CD11720ECFFDBFD927116F_1709765235 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1709765235.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1709765235;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.622 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "A03FB01594A68A8D88C1408572516760")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1025968692 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1727880906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1727880906;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.622 -0400", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "4698264BA3073A0FF52429C39B833352")
    @Override
    protected char[] protectedArray() {
        char[] var8D50CD27AA8B6BEC65C484FFCC5B2334_426704870 = (backingArray);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1955842273 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1955842273;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.623 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "D506C94E3C6F9B414790A883B4CA1AE8")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_419734241 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660497996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660497996;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.623 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "98C6487C335AA60CB2E36292888D2116")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_2018878536 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815223887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815223887;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.624 -0400", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "38286CA5BB52F482C47E6D98FB0CAC83")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_975855878 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_975855878.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_975855878;
        } //End block
        backingArray[offset + position++] = c;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1808081783 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1808081783.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1808081783;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.625 -0400", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "F8E68F8A1897C687483EFC201B0A5AE2")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_715255171 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_715255171.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_715255171;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.626 -0400", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "A839D21B14293CB9CE03B87822ABABAE")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        if(charCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_751397177 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_751397177.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_751397177;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        position += charCount;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_229003757 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_229003757.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_229003757;
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.627 -0400", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "4854BB462B6BA4561CF9509786B74DCA")
    @Override
    public CharBuffer slice() {
CharBuffer varC34068456FDE00F3BAE48CF56A0D70CB_664962995 =         new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
        varC34068456FDE00F3BAE48CF56A0D70CB_664962995.addTaint(taint);
        return varC34068456FDE00F3BAE48CF56A0D70CB_664962995;
        // ---------- Original Method ----------
        //return new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

