package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.apache.http.protocol.HTTP;

public final class CharArrayBuffer {
    private char[] buffer;
    private int len;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.043 -0400", hash_original_method = "80FC43534AFE570810C2810DCF706BBA", hash_generated_method = "AC95B062E37E4038AEE85113048E5384")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharArrayBuffer(int capacity) {
        super();
        dsTaint.addTaint(capacity);
        {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        } //End block
        this.buffer = new char[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException("Buffer capacity may not be negative");
        //}
        //this.buffer = new char[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.043 -0400", hash_original_method = "2F17603B23741271B90038A790622089", hash_generated_method = "C4FDA4580D38F0B079C8F130BB7C9762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void expand(int newlen) {
        dsTaint.addTaint(newlen);
        char newbuffer[];
        newbuffer = new char[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
        // ---------- Original Method ----------
        //char newbuffer[] = new char[Math.max(this.buffer.length << 1, newlen)];
        //System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        //this.buffer = newbuffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.043 -0400", hash_original_method = "1554F1B702E64F0170BDDCC0C4BCFFD0", hash_generated_method = "30F2C76F2A7F1E43F19AF834C85C5612")
    @DSModeled(DSC.SAFE)
    public void append(final char[] b, int off, int len) {
        dsTaint.addTaint(b);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        {
            throw new IndexOutOfBoundsException();
        } //End block
        int newlen;
        newlen = this.len + len;
        {
            expand(newlen);
        } //End block
        System.arraycopy(b, off, this.buffer, this.len, len);
        this.len = newlen;
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //if ((off < 0) || (off > b.length) || (len < 0) ||
                //((off + len) < 0) || ((off + len) > b.length)) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (len == 0) {
            //return;
        //}
        //int newlen = this.len + len;
        //if (newlen > this.buffer.length) {
            //expand(newlen);
        //}
        //System.arraycopy(b, off, this.buffer, this.len, len);
        //this.len = newlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.043 -0400", hash_original_method = "ACAF2F249BA22D0DF6BBB3AD4537636F", hash_generated_method = "A78AD680262285CA3B348F651D5CF5C4")
    @DSModeled(DSC.SAFE)
    public void append(String str) {
        dsTaint.addTaint(str);
        {
            str = "null";
        } //End block
        int strlen;
        strlen = str.length();
        int newlen;
        newlen = this.len + strlen;
        {
            expand(newlen);
        } //End block
        str.getChars(0, strlen, this.buffer, this.len);
        this.len = newlen;
        // ---------- Original Method ----------
        //if (str == null) {
            //str = "null";
        //}
        //int strlen = str.length();
        //int newlen = this.len + strlen;
        //if (newlen > this.buffer.length) {
            //expand(newlen);
        //}
        //str.getChars(0, strlen, this.buffer, this.len);
        //this.len = newlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "CF054D049383C7FB58555671D733BB49", hash_generated_method = "61743DF5F6C0418CCD6D9D650DED8AC1")
    @DSModeled(DSC.SAFE)
    public void append(final CharArrayBuffer b, int off, int len) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        append(b.buffer, off, len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer, off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "8D8F799991037417FEE597D66B054738", hash_generated_method = "FFCEE74F600DAACD265D3EE64FD7741B")
    @DSModeled(DSC.SAFE)
    public void append(final CharArrayBuffer b) {
        dsTaint.addTaint(b.dsTaint);
        append(b.buffer,0, b.len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer,0, b.len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "D5C788E90F40398FB3614446E45BD8A0", hash_generated_method = "415C1B45897C3E830D15C6E8598AC590")
    @DSModeled(DSC.SAFE)
    public void append(char ch) {
        dsTaint.addTaint(ch);
        int newlen;
        newlen = this.len + 1;
        {
            expand(newlen);
        } //End block
        this.buffer[this.len] = ch;
        this.len = newlen;
        // ---------- Original Method ----------
        //int newlen = this.len + 1;
        //if (newlen > this.buffer.length) {
            //expand(newlen);
        //}
        //this.buffer[this.len] = ch;
        //this.len = newlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "1539B6B7FB9C49117830C213FB468302", hash_generated_method = "D50A6F48C5EEAA580A09782D752E10E3")
    @DSModeled(DSC.SAFE)
    public void append(final byte[] b, int off, int len) {
        dsTaint.addTaint(b);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        {
            throw new IndexOutOfBoundsException();
        } //End block
        int oldlen;
        oldlen = this.len;
        int newlen;
        newlen = oldlen + len;
        {
            expand(newlen);
        } //End block
        {
            int i1, i2;
            i1 = off;
            i2 = oldlen;
            {
                int ch;
                ch = b[i1];
                {
                    ch = 256 + ch;
                } //End block
                this.buffer[i2] = (char) ch;
            } //End block
        } //End collapsed parenthetic
        this.len = newlen;
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //if ((off < 0) || (off > b.length) || (len < 0) ||
                //((off + len) < 0) || ((off + len) > b.length)) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (len == 0) {
            //return;
        //}
        //int oldlen = this.len;
        //int newlen = oldlen + len;
        //if (newlen > this.buffer.length) {
            //expand(newlen);
        //}
        //for (int i1 = off, i2 = oldlen; i2 < newlen; i1++, i2++) {
            //int ch = b[i1]; 
            //if (ch < 0) {
                //ch = 256 + ch;
            //}
            //this.buffer[i2] = (char) ch;
        //}
        //this.len = newlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "1FCF3DEEF5F4407F6E71047E93ADF346", hash_generated_method = "BDA4C95191558CD73FCB11081C77AEC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void append(final ByteArrayBuffer b, int off, int len) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        append(b.buffer(), off, len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer(), off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "0BE283891823620662CC4786671FBEB2", hash_generated_method = "B31BB4F2E9789BC96040A04ACF5818D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void append(final Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        append(String.valueOf(obj));
        // ---------- Original Method ----------
        //append(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "898CA144C2526FB0FA7559868C1DF5A8")
    @DSModeled(DSC.SAFE)
    public void clear() {
        this.len = 0;
        // ---------- Original Method ----------
        //this.len = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "4AFFE01BAE7027051F1E9CC8F13AAD3C", hash_generated_method = "D98BCA1FBAE8002D0DD2653442295A91")
    @DSModeled(DSC.SAFE)
    public char[] toCharArray() {
        char[] b;
        b = new char[this.len];
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //char[] b = new char[this.len];
        //if (this.len > 0) {
            //System.arraycopy(this.buffer, 0, b, 0, this.len);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "0F5DF22A5A8E86304CC71C5AF54FB9F6", hash_generated_method = "811E6BC733410C2A8F6EC3831D1A57B0")
    @DSModeled(DSC.SAFE)
    public char charAt(int i) {
        dsTaint.addTaint(i);
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return this.buffer[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "5B3D3354C10A8CE6B547B7C0987FB729", hash_generated_method = "A70C6896AD149C3FBDD582EF6515994D")
    @DSModeled(DSC.SAFE)
    public char[] buffer() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "F3F81A4535BD3752629E6F5A92D529AA")
    @DSModeled(DSC.SAFE)
    public int capacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "37FC05A2160F424BE9AF6FE43D01D75E")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "D7CBA679433EAE08760B1427F02A5D97", hash_generated_method = "028332503FED615DD1F0190B74F6966E")
    @DSModeled(DSC.SAFE)
    public void ensureCapacity(int required) {
        dsTaint.addTaint(required);
        int available;
        available = this.buffer.length - this.len;
        {
            expand(this.len + required);
        } //End block
        // ---------- Original Method ----------
        //int available = this.buffer.length - this.len;
        //if (required > available) {
            //expand(this.len + required);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "3DFA10BAA0880E2A35FE010178D58723")
    @DSModeled(DSC.SAFE)
    public void setLength(int len) {
        dsTaint.addTaint(len);
        {
            throw new IndexOutOfBoundsException();
        } //End block
        // ---------- Original Method ----------
        //if (len < 0 || len > this.buffer.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //this.len = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "B443F0F5C31435F37B1743152871D7B3")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.len == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.044 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "C19950CB002C31F9E29F35F97FF0F542")
    @DSModeled(DSC.SAFE)
    public boolean isFull() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.len == this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.045 -0400", hash_original_method = "C97943E501E1F01D557A940E7B003F7F", hash_generated_method = "3EAE39DAA2444A16FCDE74DC3325AB85")
    @DSModeled(DSC.SAFE)
    public int indexOf(int ch, int beginIndex, int endIndex) {
        dsTaint.addTaint(beginIndex);
        dsTaint.addTaint(ch);
        dsTaint.addTaint(endIndex);
        {
            beginIndex = 0;
        } //End block
        {
            endIndex = this.len;
        } //End block
        {
            int i;
            i = beginIndex;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (beginIndex < 0) {
            //beginIndex = 0;
        //}
        //if (endIndex > this.len) {
            //endIndex = this.len;
        //}
        //if (beginIndex > endIndex) {
            //return -1;
        //}
        //for (int i = beginIndex; i < endIndex; i++) {
            //if (this.buffer[i] == ch) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.045 -0400", hash_original_method = "10D27E663D7DA2320707DA538278DAF0", hash_generated_method = "E6E9C5EAC70FEA316F12FBDCB86601E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(int ch) {
        dsTaint.addTaint(ch);
        int var3F00C3A83A66DA6E813696977BC642E4_409292727 = (indexOf(ch, 0, this.len));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indexOf(ch, 0, this.len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.045 -0400", hash_original_method = "22CCCAF5D720409DDBF6F0B0B6357B54", hash_generated_method = "2632D5AF3ADA0E9DEEC9E247CD80BE0C")
    @DSModeled(DSC.SAFE)
    public String substring(int beginIndex, int endIndex) {
        dsTaint.addTaint(beginIndex);
        dsTaint.addTaint(endIndex);
        {
            throw new IndexOutOfBoundsException();
        } //End block
        {
            throw new IndexOutOfBoundsException();
        } //End block
        {
            throw new IndexOutOfBoundsException();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (beginIndex < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (endIndex > this.len) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (beginIndex > endIndex) {
            //throw new IndexOutOfBoundsException();
        //}
        //return new String(this.buffer, beginIndex, endIndex - beginIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.045 -0400", hash_original_method = "4246CE00C89336C6483535517E901EA8", hash_generated_method = "587F72B61F8E975B62C1EAEAFCB82A60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String substringTrimmed(int beginIndex, int endIndex) {
        dsTaint.addTaint(beginIndex);
        dsTaint.addTaint(endIndex);
        {
            throw new IndexOutOfBoundsException();
        } //End block
        {
            throw new IndexOutOfBoundsException();
        } //End block
        {
            throw new IndexOutOfBoundsException();
        } //End block
        {
            boolean var61922099945D4AFC92E67DC8172246E3_1305667858 = (beginIndex < endIndex && HTTP.isWhitespace(this.buffer[beginIndex]));
            {
                beginIndex++;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var154623A58B224AC98D3E71F92000C6F5_42453901 = (endIndex > beginIndex && HTTP.isWhitespace(this.buffer[endIndex - 1]));
            {
                endIndex--;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (beginIndex < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (endIndex > this.len) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (beginIndex > endIndex) {
            //throw new IndexOutOfBoundsException();
        //}
        //while (beginIndex < endIndex && HTTP.isWhitespace(this.buffer[beginIndex])) {
            //beginIndex++;
        //}
        //while (endIndex > beginIndex && HTTP.isWhitespace(this.buffer[endIndex - 1])) {
            //endIndex--;
        //}
        //return new String(this.buffer, beginIndex, endIndex - beginIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.045 -0400", hash_original_method = "37A881D5A8D6182DF31C9932D86CB3D7", hash_generated_method = "380816C5CF212C3B9728FDB2CC29903A")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new String(this.buffer, 0, this.len);
    }

    
}


