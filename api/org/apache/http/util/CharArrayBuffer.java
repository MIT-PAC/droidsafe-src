package org.apache.http.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.protocol.HTTP;






public final class CharArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.472 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

    private char[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.472 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.472 -0400", hash_original_method = "80FC43534AFE570810C2810DCF706BBA", hash_generated_method = "725A2061C68FF4A6E4BBF926B128545B")
    public  CharArrayBuffer(int capacity) {
        super();
        if(capacity < 0)        
        {
            IllegalArgumentException var03F979431F23399CC6456A2D82EB9665_1921257017 = new IllegalArgumentException("Buffer capacity may not be negative");
            var03F979431F23399CC6456A2D82EB9665_1921257017.addTaint(taint);
            throw var03F979431F23399CC6456A2D82EB9665_1921257017;
        } //End block
        this.buffer = new char[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException("Buffer capacity may not be negative");
        //}
        //this.buffer = new char[capacity];
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.473 -0400", hash_original_method = "2F17603B23741271B90038A790622089", hash_generated_method = "05497A398F5D79907E8AD5F9DC81D178")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.474 -0400", hash_original_method = "1554F1B702E64F0170BDDCC0C4BCFFD0", hash_generated_method = "4B162B41A2C3258845F8C6DBE22684D9")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_513986937 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_513986937.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_513986937;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.475 -0400", hash_original_method = "ACAF2F249BA22D0DF6BBB3AD4537636F", hash_generated_method = "01288A38BDE8C46EF1B1059E9C9F520B")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.475 -0400", hash_original_method = "CF054D049383C7FB58555671D733BB49", hash_generated_method = "8A8E381CC04ED22BEA2463A28A3946B3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.476 -0400", hash_original_method = "8D8F799991037417FEE597D66B054738", hash_generated_method = "F0B333814D14404CF6DA0AB10EF705B3")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.476 -0400", hash_original_method = "D5C788E90F40398FB3614446E45BD8A0", hash_generated_method = "B35B5546EB1901E8F4189CF525DF6ED7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.477 -0400", hash_original_method = "1539B6B7FB9C49117830C213FB468302", hash_generated_method = "649F83A224065D9794903E795C6EB80D")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_408552101 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_408552101.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_408552101;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.478 -0400", hash_original_method = "1FCF3DEEF5F4407F6E71047E93ADF346", hash_generated_method = "49730BC943CE4FB60121280D8C8C9DAA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.479 -0400", hash_original_method = "0BE283891823620662CC4786671FBEB2", hash_generated_method = "68A206D09A6080BDFCB875FFDE94E284")
    public void append(final Object obj) {
        addTaint(obj.getTaint());
        append(String.valueOf(obj));
        // ---------- Original Method ----------
        //append(String.valueOf(obj));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.479 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "337424E6F35DDD475218DC5AB9D00E92")
    public void clear() {
        this.len = 0;
        // ---------- Original Method ----------
        //this.len = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.480 -0400", hash_original_method = "4AFFE01BAE7027051F1E9CC8F13AAD3C", hash_generated_method = "2DEC92CD3855A599E46604D20FA4521F")
    public char[] toCharArray() {
        char[] b = new char[this.len];
        if(this.len > 0)        
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } //End block
        char[] var92EB5FFEE6AE2FEC3AD71C777531578F_1021851806 = (b);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_847238874 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_847238874;
        // ---------- Original Method ----------
        //char[] b = new char[this.len];
        //if (this.len > 0) {
            //System.arraycopy(this.buffer, 0, b, 0, this.len);
        //}
        //return b;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.480 -0400", hash_original_method = "0F5DF22A5A8E86304CC71C5AF54FB9F6", hash_generated_method = "489D7923E22F5C317C1D17E2A08E1DE0")
    public char charAt(int i) {
        addTaint(i);
        char varA9E56EEB630C8BFCBFDB63C413A3939E_977112224 = (this.buffer[i]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_750088326 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_750088326;
        // ---------- Original Method ----------
        //return this.buffer[i];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.480 -0400", hash_original_method = "5B3D3354C10A8CE6B547B7C0987FB729", hash_generated_method = "6495AC73DA85CDCEB282EC4035C8FBE6")
    public char[] buffer() {
        char[] var397661C75635A0FA840423E8342CE0C1_1574735146 = (this.buffer);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1392768648 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1392768648;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.481 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "9FE440EAFC801301ADCB6A1290E701A4")
    public int capacity() {
        int var52B286FBAC396E14EB741753BEC48E2E_1827304240 = (this.buffer.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326088818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326088818;
        // ---------- Original Method ----------
        //return this.buffer.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.481 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "1BEB240CC3AF2D92B2AEB34D1460E051")
    public int length() {
        int varAAF77C96E17DBD2484969826EE87EC7C_1531128791 = (this.len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412332606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412332606;
        // ---------- Original Method ----------
        //return this.len;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.482 -0400", hash_original_method = "D7CBA679433EAE08760B1427F02A5D97", hash_generated_method = "1A12E18CB314E65E520C436FFA3460E2")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.483 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "01E9F063C89C89F723CBC877417F5426")
    public void setLength(int len) {
        if(len < 0 || len > this.buffer.length)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1939013123 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1939013123.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1939013123;
        } //End block
        this.len = len;
        // ---------- Original Method ----------
        //if (len < 0 || len > this.buffer.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //this.len = len;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.483 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "C7408AD231D053DBBA40A8E50EF81AF0")
    public boolean isEmpty() {
        boolean var57A5224D99B6BA900B7758F06CD5187E_41125154 = (this.len == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837699929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837699929;
        // ---------- Original Method ----------
        //return this.len == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.484 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "37C5A0E67A142288D6DBAF92A696D8DC")
    public boolean isFull() {
        boolean varD708B71DF33C050A22F18E0A4D966659_574942033 = (this.len == this.buffer.length);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694176958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_694176958;
        // ---------- Original Method ----------
        //return this.len == this.buffer.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.485 -0400", hash_original_method = "C97943E501E1F01D557A940E7B003F7F", hash_generated_method = "202EA90538CF8D347F51EB2FD0F34363")
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
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1046669480 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131285653 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131285653;
        } //End block
for(int i = beginIndex;i < endIndex;i++)
        {
            if(this.buffer[i] == ch)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_786371065 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127255739 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127255739;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_986490 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1910368514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1910368514;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.486 -0400", hash_original_method = "10D27E663D7DA2320707DA538278DAF0", hash_generated_method = "7F49276C9FE236339A0B4B75009DBE96")
    public int indexOf(int ch) {
        addTaint(ch);
        int varCE2C35DB54E11BE3E3147B6C60608E1E_1756279350 = (indexOf(ch, 0, this.len));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959169880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959169880;
        // ---------- Original Method ----------
        //return indexOf(ch, 0, this.len);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.487 -0400", hash_original_method = "22CCCAF5D720409DDBF6F0B0B6357B54", hash_generated_method = "0932D0FBB961ECADDB31350300F10DDF")
    public String substring(int beginIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(beginIndex);
        if(beginIndex < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_2082644675 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_2082644675.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_2082644675;
        } //End block
        if(endIndex > this.len)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_75232700 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_75232700.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_75232700;
        } //End block
        if(beginIndex > endIndex)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_182248038 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_182248038.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_182248038;
        } //End block
String var957C2F5ECFE141535AC828E3F6DE7C6E_2018396126 =         new String(this.buffer, beginIndex, endIndex - beginIndex);
        var957C2F5ECFE141535AC828E3F6DE7C6E_2018396126.addTaint(taint);
        return var957C2F5ECFE141535AC828E3F6DE7C6E_2018396126;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.487 -0400", hash_original_method = "4246CE00C89336C6483535517E901EA8", hash_generated_method = "3384166277D0B5157BD833BACCB6200B")
    public String substringTrimmed(int beginIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(beginIndex);
        if(beginIndex < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_395128339 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_395128339.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_395128339;
        } //End block
        if(endIndex > this.len)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1223205094 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1223205094.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1223205094;
        } //End block
        if(beginIndex > endIndex)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_997416769 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_997416769.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_997416769;
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
String var957C2F5ECFE141535AC828E3F6DE7C6E_2070943618 =         new String(this.buffer, beginIndex, endIndex - beginIndex);
        var957C2F5ECFE141535AC828E3F6DE7C6E_2070943618.addTaint(taint);
        return var957C2F5ECFE141535AC828E3F6DE7C6E_2070943618;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.488 -0400", hash_original_method = "37A881D5A8D6182DF31C9932D86CB3D7", hash_generated_method = "35EC7BF7C0E975B42F1556603B420073")
    public String toString() {
String var3D75D818B237A39FF7B4B1A5D24EBC63_2098129020 =         new String(this.buffer, 0, this.len);
        var3D75D818B237A39FF7B4B1A5D24EBC63_2098129020.addTaint(taint);
        return var3D75D818B237A39FF7B4B1A5D24EBC63_2098129020;
        // ---------- Original Method ----------
        //return new String(this.buffer, 0, this.len);
    }

    
}

