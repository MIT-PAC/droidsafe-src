package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERPrintableString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.129 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.147 -0400", hash_original_method = "D997DB152CB96E2AA3DC66ADB95C73B5", hash_generated_method = "350D1FB6937C3785D97A5D4B718152B0")
    public  DERPrintableString(
        byte[]   string) {
        char[] cs;
        cs = new char[string.length];
        {
            int i;
            i = 0;
            {
                cs[i] = (char)(string[i] & 0xff);
            } //End block
        } //End collapsed parenthetic
        this.string = new String(cs).intern();
        // ---------- Original Method ----------
        //char[]  cs = new char[string.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)(string[i] & 0xff);
        //}
        //this.string = new String(cs).intern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.148 -0400", hash_original_method = "6FDBF9EC620F477F9D8DC023E90C58AD", hash_generated_method = "511B5423ACF1B90912179FC61A8F5833")
    public  DERPrintableString(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.157 -0400", hash_original_method = "884AB42617499DD6D6AA2A57724A994F", hash_generated_method = "E003F7C6D2868BDF92D5E6401376B6E2")
    public  DERPrintableString(
        String   string,
        boolean  validate) {
        {
            boolean varED015A089F9FC5B98B1596D943A29350_303396632 = (validate && !isPrintableString(string));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("string contains illegal characters");
            } //End block
        } //End collapsed parenthetic
        this.string = string.intern();
        addTaint(validate);
        // ---------- Original Method ----------
        //if (validate && !isPrintableString(string))
        //{
            //throw new IllegalArgumentException("string contains illegal characters");
        //}
        //this.string = string.intern();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.163 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "AFE8977E38FF3B4AE045EAC99B0EBD2E")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1517012781 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1517012781 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1517012781.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1517012781;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.164 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "E670538455C48E75445329C21EB59B14")
    public byte[] getOctets() {
        char[] cs;
        cs = string.toCharArray();
        byte[] bs;
        bs = new byte[cs.length];
        {
            int i;
            i = 0;
            {
                bs[i] = (byte)cs[i];
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1381026263 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1381026263;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.164 -0400", hash_original_method = "84DAFF7719AC505908CDD70F6E92DE78", hash_generated_method = "03D2D3CF78CFCAE36B788730DC3B863F")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(PRINTABLE_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(PRINTABLE_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.164 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "7B0455522E043BB336838660456C3E24")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_890464448 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806096462 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806096462;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.165 -0400", hash_original_method = "356EB8B61A96F4A47C607B567EAD3298", hash_generated_method = "E82982B2CF731F6765B4A3E9FA8340D4")
     boolean asn1Equals(
        DERObject  o) {
        DERPrintableString s;
        s = (DERPrintableString)o;
        boolean varEE57EA262042757EB3692934946962F3_1806191379 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302086165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302086165;
        // ---------- Original Method ----------
        //if (!(o instanceof DERPrintableString))
        //{
            //return false;
        //}
        //DERPrintableString  s = (DERPrintableString)o;
        //return this.getString().equals(s.getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.166 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "21BFD8828E1561E25B9A557761AC0EB8")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_13782508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_13782508 = string;
        varB4EAC82CA7396A68D541C85D26508E83_13782508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_13782508;
        // ---------- Original Method ----------
        //return string;
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

