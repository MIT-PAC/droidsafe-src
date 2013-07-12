package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERPrintableString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.168 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.169 -0400", hash_original_method = "D997DB152CB96E2AA3DC66ADB95C73B5", hash_generated_method = "D16BF1940FE575B97E8AB0D562B258D3")
    public  DERPrintableString(
        byte[]   string) {
        char[] cs = new char[string.length];
for(int i = 0;i != cs.length;i++)
        {
            cs[i] = (char)(string[i] & 0xff);
        } 
        this.string = new String(cs).intern();
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.170 -0400", hash_original_method = "6FDBF9EC620F477F9D8DC023E90C58AD", hash_generated_method = "511B5423ACF1B90912179FC61A8F5833")
    public  DERPrintableString(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.170 -0400", hash_original_method = "884AB42617499DD6D6AA2A57724A994F", hash_generated_method = "D0E6D26B59732F6A2A014DF0419F3D0D")
    public  DERPrintableString(
        String   string,
        boolean  validate) {
        addTaint(validate);
    if(validate && !isPrintableString(string))        
        {
            IllegalArgumentException var004F07C3BE12B584F6B99C05A347E3ED_89093871 = new IllegalArgumentException("string contains illegal characters");
            var004F07C3BE12B584F6B99C05A347E3ED_89093871.addTaint(taint);
            throw var004F07C3BE12B584F6B99C05A347E3ED_89093871;
        } 
        this.string = string.intern();
        
        
        
            
        
        
    }

    
        public static DERPrintableString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERPrintableString)
        {
            return (DERPrintableString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERPrintableString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERPrintableString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERPrintableString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.171 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "CF7D2D922FDCB76B1369BE7E88BE4FA9")
    public String getString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_2105646936 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_2105646936.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_2105646936;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.172 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "CAF00A50A8A9B2B768554CB52DF3017A")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } 
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_695737386 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1478282196 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1478282196;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.172 -0400", hash_original_method = "84DAFF7719AC505908CDD70F6E92DE78", hash_generated_method = "73FCDE4E9E1C70C7AD9BAC8132114FCA")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(PRINTABLE_STRING, this.getOctets());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.172 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "15EF1BFCE4DC6B059415D725BD9C6AAA")
    public int hashCode() {
        int var5EE87F4C9D30CCD0C63D46FAC325C3D6_1670358406 = (this.getString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248094040 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248094040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.173 -0400", hash_original_method = "356EB8B61A96F4A47C607B567EAD3298", hash_generated_method = "774DD36226FB24320DAE0F11C2950628")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERPrintableString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1338166807 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523633568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523633568;
        } 
        DERPrintableString s = (DERPrintableString)o;
        boolean varEDB7CD599351FA878152EF17A169B1A6_486160867 = (this.getString().equals(s.getString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587448259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587448259;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.173 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "5CC6CE383862492D394A9F80BBA03690")
    public String toString() {
String varDCF8A90B03379D9C1C8BF337A3879E0C_116784829 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_116784829.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_116784829;
        
        
    }

    
        public static boolean isPrintableString(
        String  str) {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);
            if (ch > 0x007f)
            {
                return false;
            }
            if ('a' <= ch && ch <= 'z')
            {
                continue;
            }
            if ('A' <= ch && ch <= 'Z')
            {
                continue;
            }
            if ('0' <= ch && ch <= '9')
            {
                continue;
            }
            switch (ch)
            {
            case ' ':
            case '\'':
            case '(':
            case ')':
            case '+':
            case '-':
            case '.':
            case ':':
            case '=':
            case '?':
            case '/':
            case ',':
                continue;
            }
            return false;
        }
        return true;
    }

    
}

