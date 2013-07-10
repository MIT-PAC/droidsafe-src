package org.apache.http.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class ByteArrayBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.669 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.669 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "6B317AC04635B3FCED4BC37586F98E37")

    private int len;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.669 -0400", hash_original_method = "8E5F8B5095E051129F22BA678563CC37", hash_generated_method = "1144526B7DE705EC07BC2789294A64A5")
    public  ByteArrayBuffer(int capacity) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer capacity may not be negative");
        } 
        this.buffer = new byte[capacity];
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.670 -0400", hash_original_method = "00DB8B6A06284480D1470563C3051457", hash_generated_method = "D7D86314513812A4B5ABB0F664F3CA12")
    private void expand(int newlen) {
        byte newbuffer[] = new byte[Math.max(this.buffer.length << 1, newlen)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.len);
        this.buffer = newbuffer;
        addTaint(newlen);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.670 -0400", hash_original_method = "DA5D0A844C4E68710DCEFB64AE959C3F", hash_generated_method = "DA149543C2DA329702304EA507D503C5")
    public void append(final byte[] b, int off, int len) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.670 -0400", hash_original_method = "2CBB81D0688F751ED507CC2CFBAC1CFC", hash_generated_method = "2944E31FA27B4784CB5143B46849C7A6")
    public void append(int b) {
        int newlen = this.len + 1;
        {
            expand(newlen);
        } 
        this.buffer[this.len] = (byte)b;
        this.len = newlen;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.671 -0400", hash_original_method = "46C6F4F43DFE7BB1741326F0CDCC6C04", hash_generated_method = "C1BC21107D325E203431E89E2FB6CC04")
    public void append(final char[] b, int off, int len) {
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
                this.buffer[i2] = (byte) b[i1];
            } 
        } 
        this.len = newlen;
        addTaint(off);
        
        
            
        
        
                
            
        
        
            
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.671 -0400", hash_original_method = "2B44500918C17771D87A9839758DBEB3", hash_generated_method = "0D30D33DC24A5A34C40A8939654DEF7C")
    public void append(final CharArrayBuffer b, int off, int len) {
        append(b.buffer(), off, len);
        addTaint(b.getTaint());
        addTaint(off);
        addTaint(len);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.672 -0400", hash_original_method = "A450C39265F5D0A0BD0BDC87E4C74433", hash_generated_method = "337424E6F35DDD475218DC5AB9D00E92")
    public void clear() {
        this.len = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.672 -0400", hash_original_method = "1D2E8B5D0002EFCBEC9528FA90BDCD1E", hash_generated_method = "CA7A500C1553D62A7290961DB7116703")
    public byte[] toByteArray() {
        byte[] b = new byte[this.len];
        {
            System.arraycopy(this.buffer, 0, b, 0, this.len);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1705004440 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1705004440;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.672 -0400", hash_original_method = "613A69635B934E492B5C1ACCF6550798", hash_generated_method = "751D44677EE46EA6BF97B6BB305A394F")
    public int byteAt(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937055086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937055086;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.673 -0400", hash_original_method = "E6DBC98D148FFCF2E5C7804935F48006", hash_generated_method = "5FE249899F5853712608589C2768EF51")
    public int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404978005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404978005;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.673 -0400", hash_original_method = "2CD8E08F4F467579BB3BB8F7D0C8447F", hash_generated_method = "F7990B370456997D1C8CF2951F321739")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337759374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337759374;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.674 -0400", hash_original_method = "7FCD7FDEC66BB92B19CC1167E6D11C2F", hash_generated_method = "10F0B28B328D49E31C21A819AA3F4FC1")
    public byte[] buffer() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1671568540 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1671568540;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.674 -0400", hash_original_method = "91BC3CAF824730CA70DA03BDE47FFB38", hash_generated_method = "88308711C78C4406ECDB2D627E5D6C99")
    public void setLength(int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        this.len = len;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.675 -0400", hash_original_method = "469F2C344B75CE70282CF1EAB0C57115", hash_generated_method = "6D853A0AC8C4BA9B39C46B7E8D07ED1B")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007748371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007748371;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.676 -0400", hash_original_method = "174E21FDFCCB8A5F3AFE842BEA806892", hash_generated_method = "4492CAE19D271F557DF939526E5EAE97")
    public boolean isFull() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969165245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_969165245;
        
        
    }

    
}

