package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.protocol.HTTP;

public final class CharArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.065 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

    private char[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.066 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.066 -0400", hash_original_method = "80FC43534AFE570810C2810DCF706BBA", hash_generated_method = "CFD8D31CAAFE94AA66E5D035F6F9AC7A")
    public  CharArrayBuffer(int capacity) {
        super();
    if(capacity < 0)        
        {
            IllegalArgumentException var03F979431F23399CC6456A2D82EB9665_886382995 = new IllegalArgumentException("Buffer capacity may not be negative");
            var03F979431F23399CC6456A2D82EB9665_886382995.addTaint(taint);
            throw var03F979431F23399CC6456A2D82EB9665_886382995;
        } //End block
        this.buffer = new char[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException("Buffer capacity may not be negative");
        //}
        //this.buffer = new char[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.066 -0400", hash_original_method = "2F17603B23741271B90038A790622089", hash_generated_method = "05497A398F5D79907E8AD5F9DC81D178")
    private void expand(int newlen) {
        addTaint(newlen);
        char newbuffer[] = new char[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
        // ---------- Original Method ----------
        //char newbuffer[] = new char[Math.max(this.buffer.length << 1, newlen)];
        //System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        //this.buffer = newbuffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.067 -0400", hash_original_method = "1554F1B702E64F0170BDDCC0C4BCFFD0", hash_generated_method = "F3EECD2EC1B8E396E309495ADBBE3E0F")
    public void append(final char[] b, int off, int len) {
        addTaint(off);
        addTaint(b[0]);
    if(b == null)        
        {
            return;
        } //End block
    if((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length))        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_340312645 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_340312645.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_340312645;
        } //End block
    if(len == 0)        
        {
            return;
        } //End block
        int newlen = this.len + len;
    if(newlen > this.buffer.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.068 -0400", hash_original_method = "ACAF2F249BA22D0DF6BBB3AD4537636F", hash_generated_method = "01288A38BDE8C46EF1B1059E9C9F520B")
    public void append(String str) {
        addTaint(str.getTaint());
    if(str == null)        
        {
            str = "null";
        } //End block
        int strlen = str.length();
        int newlen = this.len + strlen;
    if(newlen > this.buffer.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.068 -0400", hash_original_method = "CF054D049383C7FB58555671D733BB49", hash_generated_method = "8A8E381CC04ED22BEA2463A28A3946B3")
    public void append(final CharArrayBuffer b, int off, int len) {
        addTaint(len);
        addTaint(off);
        addTaint(b.getTaint());
    if(b == null)        
        {
            return;
        } //End block
        append(b.buffer, off, len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer, off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.069 -0400", hash_original_method = "8D8F799991037417FEE597D66B054738", hash_generated_method = "F0B333814D14404CF6DA0AB10EF705B3")
    public void append(final CharArrayBuffer b) {
        addTaint(b.getTaint());
    if(b == null)        
        {
            return;
        } //End block
        append(b.buffer,0, b.len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer,0, b.len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.070 -0400", hash_original_method = "D5C788E90F40398FB3614446E45BD8A0", hash_generated_method = "B35B5546EB1901E8F4189CF525DF6ED7")
    public void append(char ch) {
        int newlen = this.len + 1;
    if(newlen > this.buffer.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.071 -0400", hash_original_method = "1539B6B7FB9C49117830C213FB468302", hash_generated_method = "1DA9053AB92B90106B6F8DC55AC4E353")
    public void append(final byte[] b, int off, int len) {
        addTaint(off);
        addTaint(b[0]);
    if(b == null)        
        {
            return;
        } //End block
    if((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length))        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1387237133 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1387237133.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1387237133;
        } //End block
    if(len == 0)        
        {
            return;
        } //End block
        int oldlen = this.len;
        int newlen = oldlen + len;
    if(newlen > this.buffer.length)        
        {
            expand(newlen);
        } //End block
for(int i1 = off, i2 = oldlen;i2 < newlen;i1++,i2++)
        {
            int ch = b[i1];
    if(ch < 0)            
            {
                ch = 256 + ch;
            } //End block
            this.buffer[i2] = (char) ch;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.072 -0400", hash_original_method = "1FCF3DEEF5F4407F6E71047E93ADF346", hash_generated_method = "49730BC943CE4FB60121280D8C8C9DAA")
    public void append(final ByteArrayBuffer b, int off, int len) {
        addTaint(len);
        addTaint(off);
        addTaint(b.getTaint());
    if(b == null)        
        {
            return;
        } //End block
        append(b.buffer(), off, len);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //append(b.buffer(), off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.072 -0400", hash_original_method = "0BE283891823620662CC4786671FBEB2", hash_generated_method = "68A206D09A6080BDFCB875FFDE94E284")
    public void append(final Object obj) {
        addTaint(obj.getTaint());
        append(String.valueOf(obj));
        // ---------- Original Method ----------
        //append(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.072 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "337424E6F35DDD475218DC5AB9D00E92")
    public void clear() {
        this.len = 0;
        // ---------- Original Method ----------
        //this.len = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.073 -0400", hash_original_method = "4AFFE01BAE7027051F1E9CC8F13AAD3C", hash_generated_method = "38705DA61DA307D48DCE8E72CDE5D4EB")
    public char[] toCharArray() {
        char[] b = new char[this.len];
    if(this.len > 0)        
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } //End block
        char[] var92EB5FFEE6AE2FEC3AD71C777531578F_2046967763 = (b);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1611435644 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1611435644;
        // ---------- Original Method ----------
        //char[] b = new char[this.len];
        //if (this.len > 0) {
            //System.arraycopy(this.buffer, 0, b, 0, this.len);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.073 -0400", hash_original_method = "0F5DF22A5A8E86304CC71C5AF54FB9F6", hash_generated_method = "4F408D853BAB7BB0DD1E440EA674946A")
    public char charAt(int i) {
        addTaint(i);
        char varA9E56EEB630C8BFCBFDB63C413A3939E_1081053961 = (this.buffer[i]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1755322931 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1755322931;
        // ---------- Original Method ----------
        //return this.buffer[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.073 -0400", hash_original_method = "5B3D3354C10A8CE6B547B7C0987FB729", hash_generated_method = "44D168237BE8D2E7B5D88407DF52FFCF")
    public char[] buffer() {
        char[] var397661C75635A0FA840423E8342CE0C1_1717153866 = (this.buffer);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_398675177 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_398675177;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.073 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "FD4A7D03A92076321BFF0D25B4766D0D")
    public int capacity() {
        int var52B286FBAC396E14EB741753BEC48E2E_1924023427 = (this.buffer.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960434367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960434367;
        // ---------- Original Method ----------
        //return this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.074 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "B3A69FFA705685783C0CA1FEA92AD140")
    public int length() {
        int varAAF77C96E17DBD2484969826EE87EC7C_382195635 = (this.len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709959606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709959606;
        // ---------- Original Method ----------
        //return this.len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.074 -0400", hash_original_method = "D7CBA679433EAE08760B1427F02A5D97", hash_generated_method = "1A12E18CB314E65E520C436FFA3460E2")
    public void ensureCapacity(int required) {
        addTaint(required);
        int available = this.buffer.length - this.len;
    if(required > available)        
        {
            expand(this.len + required);
        } //End block
        // ---------- Original Method ----------
        //int available = this.buffer.length - this.len;
        //if (required > available) {
            //expand(this.len + required);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.074 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "16C13BB4FE3B25CE059BC51001D7F42C")
    public void setLength(int len) {
    if(len < 0 || len > this.buffer.length)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1466887444 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1466887444.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1466887444;
        } //End block
        this.len = len;
        // ---------- Original Method ----------
        //if (len < 0 || len > this.buffer.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //this.len = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.075 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "DF640AEFD12E65E9B58D4AE591780D20")
    public boolean isEmpty() {
        boolean var57A5224D99B6BA900B7758F06CD5187E_2021318264 = (this.len == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272735925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272735925;
        // ---------- Original Method ----------
        //return this.len == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.075 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "F2B5C5822C7CC8C5034614F2AB3C8898")
    public boolean isFull() {
        boolean varD708B71DF33C050A22F18E0A4D966659_1101972967 = (this.len == this.buffer.length);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517704070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517704070;
        // ---------- Original Method ----------
        //return this.len == this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.076 -0400", hash_original_method = "C97943E501E1F01D557A940E7B003F7F", hash_generated_method = "01DC677F1FBC6993805F561F0C38BBC1")
    public int indexOf(int ch, int beginIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(beginIndex);
        addTaint(ch);
    if(beginIndex < 0)        
        {
            beginIndex = 0;
        } //End block
    if(endIndex > this.len)        
        {
            endIndex = this.len;
        } //End block
    if(beginIndex > endIndex)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_636000740 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059628082 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059628082;
        } //End block
for(int i = beginIndex;i < endIndex;i++)
        {
    if(this.buffer[i] == ch)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1742861075 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920150787 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920150787;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_48922451 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344454552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344454552;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.076 -0400", hash_original_method = "10D27E663D7DA2320707DA538278DAF0", hash_generated_method = "38113B85B0EB3642A37F328679AAFACC")
    public int indexOf(int ch) {
        addTaint(ch);
        int varCE2C35DB54E11BE3E3147B6C60608E1E_651788961 = (indexOf(ch, 0, this.len));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140799821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140799821;
        // ---------- Original Method ----------
        //return indexOf(ch, 0, this.len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.077 -0400", hash_original_method = "22CCCAF5D720409DDBF6F0B0B6357B54", hash_generated_method = "A08FABEE788F11B854186D9A1A80D281")
    public String substring(int beginIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(beginIndex);
    if(beginIndex < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_2064468908 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_2064468908.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_2064468908;
        } //End block
    if(endIndex > this.len)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_298334962 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_298334962.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_298334962;
        } //End block
    if(beginIndex > endIndex)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_189023639 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_189023639.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_189023639;
        } //End block
String var957C2F5ECFE141535AC828E3F6DE7C6E_393136229 =         new String(this.buffer, beginIndex, endIndex - beginIndex);
        var957C2F5ECFE141535AC828E3F6DE7C6E_393136229.addTaint(taint);
        return var957C2F5ECFE141535AC828E3F6DE7C6E_393136229;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.077 -0400", hash_original_method = "4246CE00C89336C6483535517E901EA8", hash_generated_method = "4919011027AA605198A945CC399F2904")
    public String substringTrimmed(int beginIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(beginIndex);
    if(beginIndex < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_207712065 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_207712065.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_207712065;
        } //End block
    if(endIndex > this.len)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1104700584 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1104700584.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1104700584;
        } //End block
    if(beginIndex > endIndex)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_469117729 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_469117729.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_469117729;
        } //End block
        while
(beginIndex < endIndex && HTTP.isWhitespace(this.buffer[beginIndex]))        
        {
            beginIndex++;
        } //End block
        while
(endIndex > beginIndex && HTTP.isWhitespace(this.buffer[endIndex - 1]))        
        {
            endIndex--;
        } //End block
String var957C2F5ECFE141535AC828E3F6DE7C6E_1158005060 =         new String(this.buffer, beginIndex, endIndex - beginIndex);
        var957C2F5ECFE141535AC828E3F6DE7C6E_1158005060.addTaint(taint);
        return var957C2F5ECFE141535AC828E3F6DE7C6E_1158005060;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.078 -0400", hash_original_method = "37A881D5A8D6182DF31C9932D86CB3D7", hash_generated_method = "B097BCBADFA297F3A52838388F0930B4")
    public String toString() {
String var3D75D818B237A39FF7B4B1A5D24EBC63_1849538973 =         new String(this.buffer, 0, this.len);
        var3D75D818B237A39FF7B4B1A5D24EBC63_1849538973.addTaint(taint);
        return var3D75D818B237A39FF7B4B1A5D24EBC63_1849538973;
        // ---------- Original Method ----------
        //return new String(this.buffer, 0, this.len);
    }

    
}

