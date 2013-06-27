package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.protocol.HTTP;

public final class CharArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.407 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

    private char[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.407 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.408 -0400", hash_original_method = "80FC43534AFE570810C2810DCF706BBA", hash_generated_method = "FAB60F415B1534ADA92CFA9FEC19DE50")
    public  CharArrayBuffer(int capacity) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer capacity may not be negative");
        } //End block
        this.buffer = new char[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException("Buffer capacity may not be negative");
        //}
        //this.buffer = new char[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.467 -0400", hash_original_method = "2F17603B23741271B90038A790622089", hash_generated_method = "1E2B25A5886337F02BCBBFC4A925BC11")
    private void expand(int newlen) {
        char newbuffer[];
        newbuffer = new char[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
        addTaint(newlen);
        // ---------- Original Method ----------
        //char newbuffer[] = new char[Math.max(this.buffer.length << 1, newlen)];
        //System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        //this.buffer = newbuffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.468 -0400", hash_original_method = "1554F1B702E64F0170BDDCC0C4BCFFD0", hash_generated_method = "CE1887F5351C456233A401E156A8619B")
    public void append(final char[] b, int off, int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int newlen;
        newlen = this.len + len;
        {
            expand(newlen);
        } //End block
        System.arraycopy(b, off, this.buffer, this.len, len);
        this.len = newlen;
        addTaint(b[0]);
        addTaint(off);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.468 -0400", hash_original_method = "ACAF2F249BA22D0DF6BBB3AD4537636F", hash_generated_method = "91711A2558711ED2AF430D1FB4CC1CC2")
    public void append(String str) {
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
        addTaint(str.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.469 -0400", hash_original_method = "CF054D049383C7FB58555671D733BB49", hash_generated_method = "2253E0CE879F6EFCEF05E31218FFD9DD")
    public void append(final CharArrayBuffer b, int off, int len) {
        append(b.buffer, off, len);
        addTaint(b.getTaint());
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer, off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.469 -0400", hash_original_method = "8D8F799991037417FEE597D66B054738", hash_generated_method = "82C92D90BF46EC5D040071CA3FD469A7")
    public void append(final CharArrayBuffer b) {
        append(b.buffer,0, b.len);
        addTaint(b.getTaint());
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer,0, b.len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.470 -0400", hash_original_method = "D5C788E90F40398FB3614446E45BD8A0", hash_generated_method = "20498BA63E185C4CEDA7AF4A6F859212")
    public void append(char ch) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.470 -0400", hash_original_method = "1539B6B7FB9C49117830C213FB468302", hash_generated_method = "AD5A1054D17B3E8332D5FACACE75F5D3")
    public void append(final byte[] b, int off, int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
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
        addTaint(b[0]);
        addTaint(off);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.471 -0400", hash_original_method = "1FCF3DEEF5F4407F6E71047E93ADF346", hash_generated_method = "0B09B0E88A326E68381B623EAF178A49")
    public void append(final ByteArrayBuffer b, int off, int len) {
        append(b.buffer(), off, len);
        addTaint(b.getTaint());
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer(), off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.471 -0400", hash_original_method = "0BE283891823620662CC4786671FBEB2", hash_generated_method = "7681DE8CEDB860A552C2CA93DEFBFA88")
    public void append(final Object obj) {
        append(String.valueOf(obj));
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //append(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.471 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "337424E6F35DDD475218DC5AB9D00E92")
    public void clear() {
        this.len = 0;
        // ---------- Original Method ----------
        //this.len = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.471 -0400", hash_original_method = "4AFFE01BAE7027051F1E9CC8F13AAD3C", hash_generated_method = "0A57B5160EE069B20476B306CD569463")
    public char[] toCharArray() {
        char[] b;
        b = new char[this.len];
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } //End block
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1873898769 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1873898769;
        // ---------- Original Method ----------
        //char[] b = new char[this.len];
        //if (this.len > 0) {
            //System.arraycopy(this.buffer, 0, b, 0, this.len);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.472 -0400", hash_original_method = "0F5DF22A5A8E86304CC71C5AF54FB9F6", hash_generated_method = "8CFA9B3426C3EBC0135B3F98E0CBB698")
    public char charAt(int i) {
        addTaint(i);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1772083511 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1772083511;
        // ---------- Original Method ----------
        //return this.buffer[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.472 -0400", hash_original_method = "5B3D3354C10A8CE6B547B7C0987FB729", hash_generated_method = "86247B631C82E731F7049DE5CFE3DFBD")
    public char[] buffer() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_581803913 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_581803913;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.472 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "814DAD7D08EFE6D72DEEE6E0F6F9E81D")
    public int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576802928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1576802928;
        // ---------- Original Method ----------
        //return this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.472 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "BCA1E5B7087A37628C8964005EC1476F")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820812985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820812985;
        // ---------- Original Method ----------
        //return this.len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.473 -0400", hash_original_method = "D7CBA679433EAE08760B1427F02A5D97", hash_generated_method = "1E0577C30DF62EC6FBBC5C7931F40239")
    public void ensureCapacity(int required) {
        int available;
        available = this.buffer.length - this.len;
        {
            expand(this.len + required);
        } //End block
        addTaint(required);
        // ---------- Original Method ----------
        //int available = this.buffer.length - this.len;
        //if (required > available) {
            //expand(this.len + required);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.473 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "88308711C78C4406ECDB2D627E5D6C99")
    public void setLength(int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        this.len = len;
        // ---------- Original Method ----------
        //if (len < 0 || len > this.buffer.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //this.len = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.473 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "1B69AB9C7CF799D4D4F33C38F14DBCE2")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1542416568 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1542416568;
        // ---------- Original Method ----------
        //return this.len == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.474 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "4A4A65E701DAD9B3740FAD142D04CB15")
    public boolean isFull() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_532081887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_532081887;
        // ---------- Original Method ----------
        //return this.len == this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.478 -0400", hash_original_method = "C97943E501E1F01D557A940E7B003F7F", hash_generated_method = "A59BDAF69DAAB97E048B01EAB44126FD")
    public int indexOf(int ch, int beginIndex, int endIndex) {
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
        addTaint(ch);
        addTaint(beginIndex);
        addTaint(endIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996896358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996896358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.497 -0400", hash_original_method = "10D27E663D7DA2320707DA538278DAF0", hash_generated_method = "0772C2A10D9F9D7E5055EA0567A817DE")
    public int indexOf(int ch) {
        int var3F00C3A83A66DA6E813696977BC642E4_2128169757 = (indexOf(ch, 0, this.len));
        addTaint(ch);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65461042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65461042;
        // ---------- Original Method ----------
        //return indexOf(ch, 0, this.len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.497 -0400", hash_original_method = "22CCCAF5D720409DDBF6F0B0B6357B54", hash_generated_method = "C9FFF2F0902854371ED26A1591C22E35")
    public String substring(int beginIndex, int endIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_933581618 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_933581618 = new String(this.buffer, beginIndex, endIndex - beginIndex);
        addTaint(beginIndex);
        addTaint(endIndex);
        varB4EAC82CA7396A68D541C85D26508E83_933581618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_933581618;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.498 -0400", hash_original_method = "4246CE00C89336C6483535517E901EA8", hash_generated_method = "ECE69D423BC9348471543C41FEEEE9FB")
    public String substringTrimmed(int beginIndex, int endIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_636161486 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            boolean var61922099945D4AFC92E67DC8172246E3_119742108 = (beginIndex < endIndex && HTTP.isWhitespace(this.buffer[beginIndex]));
        } //End collapsed parenthetic
        {
            boolean var154623A58B224AC98D3E71F92000C6F5_209928227 = (endIndex > beginIndex && HTTP.isWhitespace(this.buffer[endIndex - 1]));
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_636161486 = new String(this.buffer, beginIndex, endIndex - beginIndex);
        addTaint(beginIndex);
        addTaint(endIndex);
        varB4EAC82CA7396A68D541C85D26508E83_636161486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636161486;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.498 -0400", hash_original_method = "37A881D5A8D6182DF31C9932D86CB3D7", hash_generated_method = "63B09A821ABB5FAA67ABA7BC8EB71841")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_230419984 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_230419984 = new String(this.buffer, 0, this.len);
        varB4EAC82CA7396A68D541C85D26508E83_230419984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_230419984;
        // ---------- Original Method ----------
        //return new String(this.buffer, 0, this.len);
    }

    
}

