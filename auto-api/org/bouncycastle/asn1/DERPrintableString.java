package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERPrintableString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.268 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.279 -0400", hash_original_method = "D997DB152CB96E2AA3DC66ADB95C73B5", hash_generated_method = "350D1FB6937C3785D97A5D4B718152B0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.280 -0400", hash_original_method = "6FDBF9EC620F477F9D8DC023E90C58AD", hash_generated_method = "511B5423ACF1B90912179FC61A8F5833")
    public  DERPrintableString(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.280 -0400", hash_original_method = "884AB42617499DD6D6AA2A57724A994F", hash_generated_method = "328816028FC250E315B82EEB96F9E549")
    public  DERPrintableString(
        String   string,
        boolean  validate) {
        {
            boolean varED015A089F9FC5B98B1596D943A29350_1832278882 = (validate && !isPrintableString(string));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.292 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "39EBF59B658B1286C624C07945B33205")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_338201861 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_338201861 = string;
        varB4EAC82CA7396A68D541C85D26508E83_338201861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_338201861;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.292 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "BAFD4EC293EDAD0F0117CCDCDC2EB4CB")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_575840370 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_575840370;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.292 -0400", hash_original_method = "84DAFF7719AC505908CDD70F6E92DE78", hash_generated_method = "03D2D3CF78CFCAE36B788730DC3B863F")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(PRINTABLE_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(PRINTABLE_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.293 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "6A5D227DAFC1D49C16B128B921EEF5FF")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_937713950 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021225791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021225791;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.293 -0400", hash_original_method = "356EB8B61A96F4A47C607B567EAD3298", hash_generated_method = "6EC0408EE5F6B945F802CE630D81775D")
     boolean asn1Equals(
        DERObject  o) {
        DERPrintableString s;
        s = (DERPrintableString)o;
        boolean varEE57EA262042757EB3692934946962F3_209662661 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117975517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_117975517;
        // ---------- Original Method ----------
        //if (!(o instanceof DERPrintableString))
        //{
            //return false;
        //}
        //DERPrintableString  s = (DERPrintableString)o;
        //return this.getString().equals(s.getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.293 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "778C3F483C28134A5A8D6E573D574FAF")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_598803807 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_598803807 = string;
        varB4EAC82CA7396A68D541C85D26508E83_598803807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_598803807;
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

