package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERPrintableString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.659 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.660 -0400", hash_original_method = "D997DB152CB96E2AA3DC66ADB95C73B5", hash_generated_method = "289DCD29C6A84222074F631F788E8378")
    public  DERPrintableString(
        byte[]   string) {
        char[] cs = new char[string.length];
        {
            int i = 0;
            {
                cs[i] = (char)(string[i] & 0xff);
            } 
        } 
        this.string = new String(cs).intern();
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.660 -0400", hash_original_method = "6FDBF9EC620F477F9D8DC023E90C58AD", hash_generated_method = "511B5423ACF1B90912179FC61A8F5833")
    public  DERPrintableString(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.661 -0400", hash_original_method = "884AB42617499DD6D6AA2A57724A994F", hash_generated_method = "02AF9A5AB7D92A35536A5A498C66E33F")
    public  DERPrintableString(
        String   string,
        boolean  validate) {
        {
            boolean varED015A089F9FC5B98B1596D943A29350_82602118 = (validate && !isPrintableString(string));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("string contains illegal characters");
            } 
        } 
        this.string = string.intern();
        addTaint(validate);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERPrintableString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERPrintableString)
        {
            return (DERPrintableString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.663 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "F857F7950F098FDB398AEACF6D98AB2E")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1820370419 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1820370419 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1820370419.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1820370419;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.664 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "7E8414EBD54F53C95489CB44E5CA84FD")
    public byte[] getOctets() {
        char[] cs = string.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte)cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1246803600 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1246803600;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.665 -0400", hash_original_method = "84DAFF7719AC505908CDD70F6E92DE78", hash_generated_method = "03D2D3CF78CFCAE36B788730DC3B863F")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(PRINTABLE_STRING, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.665 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "88F44EB5513F4BDD3FDA71D1DE0B7212")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1269849276 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061234714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061234714;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.666 -0400", hash_original_method = "356EB8B61A96F4A47C607B567EAD3298", hash_generated_method = "A2D414DD59FA36697E22C312329BEBA9")
     boolean asn1Equals(
        DERObject  o) {
        DERPrintableString s = (DERPrintableString)o;
        boolean varEE57EA262042757EB3692934946962F3_19250788 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459630489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459630489;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.666 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "F88A03B6240AD8594CCCE7EAC06F9151")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_664832721 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_664832721 = string;
        varB4EAC82CA7396A68D541C85D26508E83_664832721.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_664832721;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

