package org.apache.http.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.protocol.HTTP;

public final class CharArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.696 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

    private char[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.696 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.697 -0400", hash_original_method = "80FC43534AFE570810C2810DCF706BBA", hash_generated_method = "FAB60F415B1534ADA92CFA9FEC19DE50")
    public  CharArrayBuffer(int capacity) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer capacity may not be negative");
        } 
        this.buffer = new char[capacity];
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.697 -0400", hash_original_method = "2F17603B23741271B90038A790622089", hash_generated_method = "D0A52042B186D1AF52210470981D1CF7")
    private void expand(int newlen) {
        char newbuffer[] = new char[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
        addTaint(newlen);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.698 -0400", hash_original_method = "1554F1B702E64F0170BDDCC0C4BCFFD0", hash_generated_method = "7DBA68F69C45C48A210A806CEB3E05A7")
    public void append(final char[] b, int off, int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        int newlen = this.len + len;
        {
            expand(newlen);
        } 
        System.arraycopy(b, off, this.buffer, this.len, len);
        this.len = newlen;
        addTaint(b[0]);
        addTaint(off);
        
        
            
        
        
                
            
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.698 -0400", hash_original_method = "ACAF2F249BA22D0DF6BBB3AD4537636F", hash_generated_method = "52414FDDCEA096E735DB2758ECAC9BC4")
    public void append(String str) {
        {
            str = "null";
        } 
        int strlen = str.length();
        int newlen = this.len + strlen;
        {
            expand(newlen);
        } 
        str.getChars(0, strlen, this.buffer, this.len);
        this.len = newlen;
        addTaint(str.getTaint());
        
        
            
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.699 -0400", hash_original_method = "CF054D049383C7FB58555671D733BB49", hash_generated_method = "2253E0CE879F6EFCEF05E31218FFD9DD")
    public void append(final CharArrayBuffer b, int off, int len) {
        append(b.buffer, off, len);
        addTaint(b.getTaint());
        addTaint(off);
        addTaint(len);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.700 -0400", hash_original_method = "8D8F799991037417FEE597D66B054738", hash_generated_method = "82C92D90BF46EC5D040071CA3FD469A7")
    public void append(final CharArrayBuffer b) {
        append(b.buffer,0, b.len);
        addTaint(b.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.701 -0400", hash_original_method = "D5C788E90F40398FB3614446E45BD8A0", hash_generated_method = "C42EB6C9DAFD7C97CDC72CCFDB502BD1")
    public void append(char ch) {
        int newlen = this.len + 1;
        {
            expand(newlen);
        } 
        this.buffer[this.len] = ch;
        this.len = newlen;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.702 -0400", hash_original_method = "1539B6B7FB9C49117830C213FB468302", hash_generated_method = "F596D0AA88EF332D311D7F867DDF346B")
    public void append(final byte[] b, int off, int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        int oldlen = this.len;
        int newlen = oldlen + len;
        {
            expand(newlen);
        } 
        {
            int i1 = off;
            int i2 = oldlen;
            {
                int ch = b[i1];
                {
                    ch = 256 + ch;
                } 
                this.buffer[i2] = (char) ch;
            } 
        } 
        this.len = newlen;
        addTaint(b[0]);
        addTaint(off);
        
        
            
        
        
                
            
        
        
            
        
        
        
        
            
        
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.702 -0400", hash_original_method = "1FCF3DEEF5F4407F6E71047E93ADF346", hash_generated_method = "0B09B0E88A326E68381B623EAF178A49")
    public void append(final ByteArrayBuffer b, int off, int len) {
        append(b.buffer(), off, len);
        addTaint(b.getTaint());
        addTaint(off);
        addTaint(len);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.702 -0400", hash_original_method = "0BE283891823620662CC4786671FBEB2", hash_generated_method = "7681DE8CEDB860A552C2CA93DEFBFA88")
    public void append(final Object obj) {
        append(String.valueOf(obj));
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.703 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "337424E6F35DDD475218DC5AB9D00E92")
    public void clear() {
        this.len = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.703 -0400", hash_original_method = "4AFFE01BAE7027051F1E9CC8F13AAD3C", hash_generated_method = "BFB81900DEF88CE510591C4F28C91E72")
    public char[] toCharArray() {
        char[] b = new char[this.len];
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } 
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_538149695 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_538149695;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.704 -0400", hash_original_method = "0F5DF22A5A8E86304CC71C5AF54FB9F6", hash_generated_method = "F292EDA81D3652288647945BC19D00DD")
    public char charAt(int i) {
        addTaint(i);
        char varA87DEB01C5F539E6BDA34829C8EF2368_985083121 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_985083121;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.704 -0400", hash_original_method = "5B3D3354C10A8CE6B547B7C0987FB729", hash_generated_method = "1B14812446143049CFFE904970BCEA00")
    public char[] buffer() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_667372521 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_667372521;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.704 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "45EEC8D988D00BD32A1AFDB6CCB2CB3B")
    public int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504723043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504723043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.705 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "0FF24200FF1BE3271993BCB3E19286D1")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226467195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226467195;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.705 -0400", hash_original_method = "D7CBA679433EAE08760B1427F02A5D97", hash_generated_method = "D17DE96DA3972502312B04EE9B6D97E9")
    public void ensureCapacity(int required) {
        int available = this.buffer.length - this.len;
        {
            expand(this.len + required);
        } 
        addTaint(required);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.706 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "88308711C78C4406ECDB2D627E5D6C99")
    public void setLength(int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        this.len = len;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.706 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "EB70C19EE717851D6EB3DE4844D4289E")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1904506485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1904506485;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.707 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "FD5066D4FBF0EA7072E8D0010C46C5FE")
    public boolean isFull() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063674070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063674070;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.708 -0400", hash_original_method = "C97943E501E1F01D557A940E7B003F7F", hash_generated_method = "A7D0EB818822BFD4EA68AFA6C2FFD571")
    public int indexOf(int ch, int beginIndex, int endIndex) {
        {
            beginIndex = 0;
        } 
        {
            endIndex = this.len;
        } 
        {
            int i = beginIndex;
        } 
        addTaint(ch);
        addTaint(beginIndex);
        addTaint(endIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503158763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503158763;
        
        
            
        
        
            
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.709 -0400", hash_original_method = "10D27E663D7DA2320707DA538278DAF0", hash_generated_method = "2D70EB436A34B7BE20732EF305BFE867")
    public int indexOf(int ch) {
        int var3F00C3A83A66DA6E813696977BC642E4_1792348705 = (indexOf(ch, 0, this.len));
        addTaint(ch);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320847445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320847445;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.711 -0400", hash_original_method = "22CCCAF5D720409DDBF6F0B0B6357B54", hash_generated_method = "A4D9F682A6E7BC34CF750E6F4EDB9632")
    public String substring(int beginIndex, int endIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1258135346 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1258135346 = new String(this.buffer, beginIndex, endIndex - beginIndex);
        addTaint(beginIndex);
        addTaint(endIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1258135346.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1258135346;
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.713 -0400", hash_original_method = "4246CE00C89336C6483535517E901EA8", hash_generated_method = "BCB20B25CB345F1C6BE1113DB0059F7E")
    public String substringTrimmed(int beginIndex, int endIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1224605458 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        {
            boolean var61922099945D4AFC92E67DC8172246E3_464314387 = (beginIndex < endIndex && HTTP.isWhitespace(this.buffer[beginIndex]));
        } 
        {
            boolean var154623A58B224AC98D3E71F92000C6F5_1399821876 = (endIndex > beginIndex && HTTP.isWhitespace(this.buffer[endIndex - 1]));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1224605458 = new String(this.buffer, beginIndex, endIndex - beginIndex);
        addTaint(beginIndex);
        addTaint(endIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1224605458.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1224605458;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.714 -0400", hash_original_method = "37A881D5A8D6182DF31C9932D86CB3D7", hash_generated_method = "F5A0097194471BBA1F88511A3C8E5772")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1656802447 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1656802447 = new String(this.buffer, 0, this.len);
        varB4EAC82CA7396A68D541C85D26508E83_1656802447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1656802447;
        
        
    }

    
}

