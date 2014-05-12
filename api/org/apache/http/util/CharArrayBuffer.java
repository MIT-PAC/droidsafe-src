package org.apache.http.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.protocol.HTTP;

public final class CharArrayBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.476 -0500", hash_original_field = "AF37951EAE101F357ACAF48FB7E85D88", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")
    
    private char[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.478 -0500", hash_original_field = "EF721EE4D9006031C7456130341457B7", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.481 -0500", hash_original_method = "80FC43534AFE570810C2810DCF706BBA", hash_generated_method = "9D339DC497053BC17E9C4F64C0B65E58")
    
public CharArrayBuffer(int capacity) {
        super();
        if (capacity < 0) {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        }
        this.buffer = new char[capacity]; 
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.483 -0500", hash_original_method = "2F17603B23741271B90038A790622089", hash_generated_method = "ECF6D38E152CDFAF230D9110611FDFBC")
    
private void expand(int newlen) {
        char newbuffer[] = new char[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.486 -0500", hash_original_method = "1554F1B702E64F0170BDDCC0C4BCFFD0", hash_generated_method = "E67F4F40486C83D6BF9273E35315FEDB")
    
public void append(final char[] b, int off, int len) {
        if (b == null) {
            return;
        }
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length)) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        int newlen = this.len + len;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        System.arraycopy(b, off, this.buffer, this.len, len);
        this.len = newlen;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.488 -0500", hash_original_method = "ACAF2F249BA22D0DF6BBB3AD4537636F", hash_generated_method = "A5F1E4C243328B214FAD5A6C068C2A24")
    
public void append(String str) {
        if (str == null) {
            str = "null";
        }
        int strlen = str.length();
        int newlen = this.len + strlen;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        str.getChars(0, strlen, this.buffer, this.len);
        this.len = newlen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.491 -0500", hash_original_method = "CF054D049383C7FB58555671D733BB49", hash_generated_method = "F807282637C8B0C5BBE1FD8F4649ACA0")
    
public void append(final CharArrayBuffer b, int off, int len) {
        if (b == null) {
            return;
        }
        append(b.buffer, off, len);
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.493 -0500", hash_original_method = "8D8F799991037417FEE597D66B054738", hash_generated_method = "FC41DC5FC36369D88B113C3F0AC8E1B9")
    
public void append(final CharArrayBuffer b) {
        if (b == null) {
            return;
        }
        append(b.buffer,0, b.len);
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.496 -0500", hash_original_method = "D5C788E90F40398FB3614446E45BD8A0", hash_generated_method = "C14686A4CDD5D0F8B2E249FFE4E9BB73")
    
public void append(char ch) {
        int newlen = this.len + 1;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        this.buffer[this.len] = ch;
        this.len = newlen;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.499 -0500", hash_original_method = "1539B6B7FB9C49117830C213FB468302", hash_generated_method = "7EC9626D4CAF13B495B81E3A2AC0B85D")
    
public void append(final byte[] b, int off, int len) {
        if (b == null) {
            return;
        }
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length)) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        int oldlen = this.len;
        int newlen = oldlen + len;
        if (newlen > this.buffer.length) {
            expand(newlen);
        }
        for (int i1 = off, i2 = oldlen; i2 < newlen; i1++, i2++) {
            int ch = b[i1]; 
            if (ch < 0) {
                ch = 256 + ch;
            }
            this.buffer[i2] = (char) ch;
        }
        this.len = newlen;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.501 -0500", hash_original_method = "1FCF3DEEF5F4407F6E71047E93ADF346", hash_generated_method = "5ABB85A2314A38E420C44AD9C2F78BFD")
    
public void append(final ByteArrayBuffer b, int off, int len) {
        if (b == null) {
            return;
        }
        append(b.buffer(), off, len);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.503 -0500", hash_original_method = "0BE283891823620662CC4786671FBEB2", hash_generated_method = "67B4251210AF09EDC945CBCCC6E079DE")
    
public void append(final Object obj) {
        append(String.valueOf(obj));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.505 -0500", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "CE31F0CC9AFD628B5E4DF48E00CAC375")
    
public void clear() {
        this.len = 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.507 -0500", hash_original_method = "4AFFE01BAE7027051F1E9CC8F13AAD3C", hash_generated_method = "410A18E4946C804017AD8F04F04E9A29")
    
public char[] toCharArray() {
        char[] b = new char[this.len]; 
        if (this.len > 0) {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        }
        return b;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.510 -0500", hash_original_method = "0F5DF22A5A8E86304CC71C5AF54FB9F6", hash_generated_method = "BD84E1DDF8CE62FD721CA73D14077717")
    
public char charAt(int i) {
        return this.buffer[i];
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.512 -0500", hash_original_method = "5B3D3354C10A8CE6B547B7C0987FB729", hash_generated_method = "9A807B5F7E2F0D0102C02B0D79052F6C")
    
public char[] buffer() {
        return this.buffer;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.515 -0500", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "092E1610504C66CDED9F24489B6076B3")
    
public int capacity() {
        return this.buffer.length;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.517 -0500", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "7EA025E4C882E2E54C2E95609A3483C0")
    
public int length() {
        return this.len;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.520 -0500", hash_original_method = "D7CBA679433EAE08760B1427F02A5D97", hash_generated_method = "99904E6CB26E55F91213E0F65E19F642")
    
public void ensureCapacity(int required) {
        int available = this.buffer.length - this.len;
        if (required > available) {
            expand(this.len + required);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.522 -0500", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "08BC6C46EBB3779A91B976883B1A5775")
    
public void setLength(int len) {
        if (len < 0 || len > this.buffer.length) {
            throw new IndexOutOfBoundsException();
        }
        this.len = len;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.524 -0500", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "59620F2F45A22D898CF0EBE3C374D8DD")
    
public boolean isEmpty() {
        return this.len == 0; 
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.526 -0500", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "D2F9936ECE69C1BB3A0668781B1D8E7E")
    
public boolean isFull() {
        return this.len == this.buffer.length; 
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.529 -0500", hash_original_method = "C97943E501E1F01D557A940E7B003F7F", hash_generated_method = "8397E1B78AC937ED3464E34EB64D0792")
    
public int indexOf(int ch, int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > this.len) {
            endIndex = this.len;
        }
        if (beginIndex > endIndex) {
            return -1;
        }
        for (int i = beginIndex; i < endIndex; i++) {
            if (this.buffer[i] == ch) {
                return i;
            }
        }
        return -1;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.531 -0500", hash_original_method = "10D27E663D7DA2320707DA538278DAF0", hash_generated_method = "C31E0774C577026313D9090A40518CA8")
    
public int indexOf(int ch) {
        return indexOf(ch, 0, this.len);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.533 -0500", hash_original_method = "22CCCAF5D720409DDBF6F0B0B6357B54", hash_generated_method = "5513F09B18C7960BE6691E991411DDB7")
    
public String substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (endIndex > this.len) {
            throw new IndexOutOfBoundsException();
        }
        if (beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        return new String(this.buffer, beginIndex, endIndex - beginIndex);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.536 -0500", hash_original_method = "4246CE00C89336C6483535517E901EA8", hash_generated_method = "271E5165DF1606A88DB48150475EFAE6")
    
public String substringTrimmed(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (endIndex > this.len) {
            throw new IndexOutOfBoundsException();
        }
        if (beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        while (beginIndex < endIndex && HTTP.isWhitespace(this.buffer[beginIndex])) {
            beginIndex++;
        }
        while (endIndex > beginIndex && HTTP.isWhitespace(this.buffer[endIndex - 1])) {
            endIndex--;
        }
        return new String(this.buffer, beginIndex, endIndex - beginIndex);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.538 -0500", hash_original_method = "37A881D5A8D6182DF31C9932D86CB3D7", hash_generated_method = "A3F48E3767849BC3384241499FC5DC53")
    
public String toString() {
        return new String(this.buffer, 0, this.len);
    }
    
}

