package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class ByteArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.034 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.034 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.034 -0400", hash_original_method = "8E5F8B5095E051129F22BA678563CC37", hash_generated_method = "68BB3FE11AE7B7BB5130B840E9150530")
    public  ByteArrayBuffer(int capacity) {
        super();
    if(capacity < 0)        
        {
            IllegalArgumentException var03F979431F23399CC6456A2D82EB9665_1403951890 = new IllegalArgumentException("Buffer capacity may not be negative");
            var03F979431F23399CC6456A2D82EB9665_1403951890.addTaint(taint);
            throw var03F979431F23399CC6456A2D82EB9665_1403951890;
        } //End block
        this.buffer = new byte[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException("Buffer capacity may not be negative");
        //}
        //this.buffer = new byte[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.035 -0400", hash_original_method = "00DB8B6A06284480D1470563C3051457", hash_generated_method = "6480572B68B9B86AD9C02C3C0C6383C9")
    private void expand(int newlen) {
        addTaint(newlen);
        byte newbuffer[] = new byte[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
        // ---------- Original Method ----------
        //byte newbuffer[] = new byte[Math.max(this.buffer.length << 1, newlen)];
        //System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        //this.buffer = newbuffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.035 -0400", hash_original_method = "DA5D0A844C4E68710DCEFB64AE959C3F", hash_generated_method = "2E046A14A5B87B4C9F7F7B0DC1D0EDA6")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_112542231 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_112542231.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_112542231;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.036 -0400", hash_original_method = "2CBB81D0688F751ED507CC2CFBAC1CFC", hash_generated_method = "0FE56DBCD92E1ADD5F67C120391BD066")
    public void append(int b) {
        int newlen = this.len + 1;
    if(newlen > this.buffer.length)        
        {
            expand(newlen);
        } //End block
        this.buffer[this.len] = (byte)b;
        this.len = newlen;
        // ---------- Original Method ----------
        //int newlen = this.len + 1;
        //if (newlen > this.buffer.length) {
            //expand(newlen);
        //}
        //this.buffer[this.len] = (byte)b;
        //this.len = newlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.037 -0400", hash_original_method = "46C6F4F43DFE7BB1741326F0CDCC6C04", hash_generated_method = "4BABF0FC8DE81582F2DE2777330DC119")
    public void append(final char[] b, int off, int len) {
        addTaint(off);
    if(b == null)        
        {
            return;
        } //End block
    if((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length))        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1386265007 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1386265007.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1386265007;
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
            this.buffer[i2] = (byte) b[i1];
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
            //this.buffer[i2] = (byte) b[i1];
        //}
        //this.len = newlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.038 -0400", hash_original_method = "2B44500918C17771D87A9839758DBEB3", hash_generated_method = "401156F7DBE3B1961FF1FBA7ABEFB291")
    public void append(final CharArrayBuffer b, int off, int len) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.038 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "337424E6F35DDD475218DC5AB9D00E92")
    public void clear() {
        this.len = 0;
        // ---------- Original Method ----------
        //this.len = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.039 -0400", hash_original_method = "1D2E8B5D0002EFCBEC9528FA90BDCD1E", hash_generated_method = "BF6B0FF83C538FFF4BD69C9553A84B61")
    public byte[] toByteArray() {
        byte[] b = new byte[this.len];
    if(this.len > 0)        
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } //End block
        byte[] var92EB5FFEE6AE2FEC3AD71C777531578F_696556594 = (b);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1953639809 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1953639809;
        // ---------- Original Method ----------
        //byte[] b = new byte[this.len];
        //if (this.len > 0) {
            //System.arraycopy(this.buffer, 0, b, 0, this.len);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.039 -0400", hash_original_method = "613A69635B934E492B5C1ACCF6550798", hash_generated_method = "E0C5AB073575BFDD467C6F681AE5BE28")
    public int byteAt(int i) {
        addTaint(i);
        int varA9E56EEB630C8BFCBFDB63C413A3939E_1323735932 = (this.buffer[i]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093404126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093404126;
        // ---------- Original Method ----------
        //return this.buffer[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.039 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "77C43A642F896FEFB161278EB1ACCB06")
    public int capacity() {
        int var52B286FBAC396E14EB741753BEC48E2E_1425375528 = (this.buffer.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98818466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98818466;
        // ---------- Original Method ----------
        //return this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.040 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "3829829029BDE9D8D1E94C36604C3BEF")
    public int length() {
        int varAAF77C96E17DBD2484969826EE87EC7C_1386414081 = (this.len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490273468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490273468;
        // ---------- Original Method ----------
        //return this.len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.040 -0400", hash_original_method = "7FCD7FDEC66BB92B19CC1167E6D11C2F", hash_generated_method = "C9949C2CAD5D785CDBD74066974FA842")
    public byte[] buffer() {
        byte[] var397661C75635A0FA840423E8342CE0C1_838482677 = (this.buffer);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2037939417 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2037939417;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.040 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "E37113F2521A3D278DCF5E4A922C046D")
    public void setLength(int len) {
    if(len < 0 || len > this.buffer.length)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_428676671 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_428676671.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_428676671;
        } //End block
        this.len = len;
        // ---------- Original Method ----------
        //if (len < 0 || len > this.buffer.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //this.len = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.040 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "8A677DA05BF6B1F5660E3F29930AC1E8")
    public boolean isEmpty() {
        boolean var57A5224D99B6BA900B7758F06CD5187E_959399520 = (this.len == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512040354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512040354;
        // ---------- Original Method ----------
        //return this.len == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.041 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "5D4CCCAB44E991BB49AD02FACA3284C7")
    public boolean isFull() {
        boolean varD708B71DF33C050A22F18E0A4D966659_653598398 = (this.len == this.buffer.length);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7037731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7037731;
        // ---------- Original Method ----------
        //return this.len == this.buffer.length;
    }

    
}

