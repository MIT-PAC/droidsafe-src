package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.906 -0400", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "B72DBBF9678D6150D01B2FE35B65793A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteCharArrayBuffer(char[] array) {
        super(array);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.906 -0400", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "13FBF5F890F50310C82D25FDA438EFE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.906 -0400", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "A032C336B4116D4A7F0E3C39205E604A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.906 -0400", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "C2601ED120DBA80F4890B0E2DB3F518C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer var1D44264AD9123F2110890066FBAC5998_1099408196 = (ReadOnlyCharArrayBuffer.copy(this, mark));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyCharArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.906 -0400", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "18BB77405C104B40B2558F0B01BFF840")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.907 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "862F60E2F36AEE36DD6331D260B25750")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer duplicate() {
        CharBuffer var8C82ED9E4FDE12C9486E1252174918B6_280025388 = (copy(this, mark));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.907 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.907 -0400", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "E3A1FBD6605E2314BEDAE1083B2D3D2E")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] protectedArray() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.907 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B6AF1441163DC81E5A7523DBEAED19DC")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.907 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F14C0EBC785314AEABBE7CBCFAB3FB1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.907 -0400", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "6AFA5983D743B5281E793AA44313F580")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(char c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.908 -0400", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "7E2CB393A19D1436E52D4C02FDD421E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(int index, char c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        backingArray[offset + index] = c;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.908 -0400", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "DE862A3F47409D8FED4BCC5024D8073A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1946456173 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        position += charCount;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.908 -0400", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "D7A920EB04B076AF7EA1EF6C614C8D0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer slice() {
        CharBuffer var3F954EC81B4B5EDC94293A6EC0E4962A_872823620 = (new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

