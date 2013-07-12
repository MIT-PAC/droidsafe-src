package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.047 -0400", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "B6FB4023B182229615CC0744C948C988")
      ReadWriteCharArrayBuffer(char[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.048 -0400", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "6F7DBD898BDA1001DEF746EF80CCC230")
      ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.048 -0400", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "666D28BBC989E92424B07D38DDE3804D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.049 -0400", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "B2B8832E9536954AF41C9FB77D7B0B5D")
    @Override
    public CharBuffer asReadOnlyBuffer() {
CharBuffer var1FDEA19A7947A41FF37E5A6C10133CE4_694001805 =         ReadOnlyCharArrayBuffer.copy(this, mark);
        var1FDEA19A7947A41FF37E5A6C10133CE4_694001805.addTaint(taint);
        return var1FDEA19A7947A41FF37E5A6C10133CE4_694001805;
        // ---------- Original Method ----------
        //return ReadOnlyCharArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.049 -0400", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "92BDACD64E5ACD673348399E16A1A88A")
    @Override
    public CharBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_414485207 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_414485207.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_414485207;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.050 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "51D633E153667ECA19C0B1C48DCDE810")
    @Override
    public CharBuffer duplicate() {
CharBuffer var6ED4708F04CD11720ECFFDBFD927116F_24490191 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_24490191.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_24490191;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.050 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "A6AE8ABF98109ECBF125AF64201FAA19")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1252908079 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1553709766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1553709766;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.050 -0400", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "132FE0371E1186A06192F1CD1F277EE1")
    @Override
    protected char[] protectedArray() {
        char[] var8D50CD27AA8B6BEC65C484FFCC5B2334_1929018979 = (backingArray);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_24187107 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_24187107;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.051 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "E53B5128DECFF76EC5A049EBC005FA7B")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1109555707 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003470541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003470541;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.051 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "57D7E368D43A8C873526C40F560A9169")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_1227266485 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623700126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_623700126;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.051 -0400", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "763EB21558ED33F7473BC6CFABE8F2BF")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1217293846 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1217293846.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1217293846;
        } //End block
        backingArray[offset + position++] = c;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1150390973 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1150390973.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1150390973;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.052 -0400", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "82826B2ED26A7444EB5A450AA433BFC8")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_2014034208 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2014034208.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2014034208;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.053 -0400", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "DB58B8CA2EFE68E3EA6E2A4B086560F3")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
    if(charCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_69191246 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_69191246.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_69191246;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        position += charCount;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1445053319 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1445053319.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1445053319;
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.053 -0400", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "1DF77AEBC1C341551AE03818A746F4A0")
    @Override
    public CharBuffer slice() {
CharBuffer varC34068456FDE00F3BAE48CF56A0D70CB_887031893 =         new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
        varC34068456FDE00F3BAE48CF56A0D70CB_887031893.addTaint(taint);
        return varC34068456FDE00F3BAE48CF56A0D70CB_887031893;
        // ---------- Original Method ----------
        //return new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

