package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class ByteArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.544 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.544 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.544 -0400", hash_original_method = "8E5F8B5095E051129F22BA678563CC37", hash_generated_method = "1144526B7DE705EC07BC2789294A64A5")
    public  ByteArrayBuffer(int capacity) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer capacity may not be negative");
        } //End block
        this.buffer = new byte[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException("Buffer capacity may not be negative");
        //}
        //this.buffer = new byte[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.550 -0400", hash_original_method = "00DB8B6A06284480D1470563C3051457", hash_generated_method = "35C082923B71C5E6D288A2D691ADAA0D")
    private void expand(int newlen) {
        byte newbuffer[];
        newbuffer = new byte[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
        addTaint(newlen);
        // ---------- Original Method ----------
        //byte newbuffer[] = new byte[Math.max(this.buffer.length << 1, newlen)];
        //System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        //this.buffer = newbuffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.555 -0400", hash_original_method = "DA5D0A844C4E68710DCEFB64AE959C3F", hash_generated_method = "06CB020FC576A085FFF4FB6E9F20C1A5")
    public void append(final byte[] b, int off, int len) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.556 -0400", hash_original_method = "2CBB81D0688F751ED507CC2CFBAC1CFC", hash_generated_method = "F9A25830F4B490821625AAE1645482C6")
    public void append(int b) {
        int newlen;
        newlen = this.len + 1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.558 -0400", hash_original_method = "46C6F4F43DFE7BB1741326F0CDCC6C04", hash_generated_method = "7D96340DC6EDF66E96C16BBFD7A2AADA")
    public void append(final char[] b, int off, int len) {
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
                this.buffer[i2] = (byte) b[i1];
            } //End block
        } //End collapsed parenthetic
        this.len = newlen;
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
            //this.buffer[i2] = (byte) b[i1];
        //}
        //this.len = newlen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.558 -0400", hash_original_method = "2B44500918C17771D87A9839758DBEB3", hash_generated_method = "0D30D33DC24A5A34C40A8939654DEF7C")
    public void append(final CharArrayBuffer b, int off, int len) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.560 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "337424E6F35DDD475218DC5AB9D00E92")
    public void clear() {
        this.len = 0;
        // ---------- Original Method ----------
        //this.len = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.568 -0400", hash_original_method = "1D2E8B5D0002EFCBEC9528FA90BDCD1E", hash_generated_method = "FD69BDAA056FB017D733B60B0F89F6F8")
    public byte[] toByteArray() {
        byte[] b;
        b = new byte[this.len];
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1372750502 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1372750502;
        // ---------- Original Method ----------
        //byte[] b = new byte[this.len];
        //if (this.len > 0) {
            //System.arraycopy(this.buffer, 0, b, 0, this.len);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.568 -0400", hash_original_method = "613A69635B934E492B5C1ACCF6550798", hash_generated_method = "082ABD719733C5222FB0D57F64DDE846")
    public int byteAt(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526051269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526051269;
        // ---------- Original Method ----------
        //return this.buffer[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.570 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "665187F7699C09759F883C251D816847")
    public int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38971463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38971463;
        // ---------- Original Method ----------
        //return this.buffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.578 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "573C87B482CC35915C7F3ADC4530F3B1")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809343343 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809343343;
        // ---------- Original Method ----------
        //return this.len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.578 -0400", hash_original_method = "7FCD7FDEC66BB92B19CC1167E6D11C2F", hash_generated_method = "E4B6ADE35D12F3B8F8BACF7B8556C405")
    public byte[] buffer() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_47813807 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_47813807;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.579 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "88308711C78C4406ECDB2D627E5D6C99")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.579 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "5C953049BF74AC30A0B47EFF3F0CFB32")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955100270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955100270;
        // ---------- Original Method ----------
        //return this.len == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.579 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "051159CC9AEB0B41E963DC2E2806FAAF")
    public boolean isFull() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149761326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149761326;
        // ---------- Original Method ----------
        //return this.len == this.buffer.length;
    }

    
}

