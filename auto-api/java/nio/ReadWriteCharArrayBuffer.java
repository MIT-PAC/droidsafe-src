package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.056 -0400", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "85618B669CBD3732A0391EC884A4CAFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteCharArrayBuffer(char[] array) {
        super(array);
        dsTaint.addTaint(array);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.060 -0400", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "216EBB7E49944C98B894780C681F0345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.064 -0400", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "59B42CC7EF715CAD51D1DC34D4336A44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.068 -0400", hash_original_method = "DC122679E39D379674ECB7170941B521", hash_generated_method = "50E047E3BCE9CF21492181B4605C7215")
    static ReadWriteCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadWriteCharArrayBuffer buf =
                new ReadWriteCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.072 -0400", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "D145D6848E3B1771CC2375467115CB5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer var1D44264AD9123F2110890066FBAC5998_1604129098 = (ReadOnlyCharArrayBuffer.copy(this, mark));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyCharArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.078 -0400", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "2C1E92950CC0232D9AEDADAD0CE2970F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.081 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "BAAC207DD1215370B2DC1E5ABBC1BF40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer duplicate() {
        CharBuffer var8C82ED9E4FDE12C9486E1252174918B6_1897574831 = (copy(this, mark));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.084 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "EDE3D125C48BC2B572BB7B1A72691474")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.086 -0400", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "FB2CAEC3FD5AB79DBD83AA0FE13004DD")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] protectedArray() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.089 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "C403F81B3545D51463E491244133BC45")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.094 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "4F00CA162D65439C04371AC18CBFFB7F")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.097 -0400", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "251FF4C096B3509728AAA48062E35BAB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.099 -0400", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "123660F9A1846BEBD3E1043D812EF9FF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.103 -0400", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "509A327595F456CDC0AC80F05D8D9710")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1253029215 = (charCount > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:44:04.105 -0400", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "86D7BB202A5A28242F464D8EE53091D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharBuffer slice() {
        CharBuffer var3F954EC81B4B5EDC94293A6EC0E4962A_371279565 = (new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}


