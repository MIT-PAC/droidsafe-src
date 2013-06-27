package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERNumericString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.046 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.047 -0400", hash_original_method = "68F5D78267A661375BFA3ED79E149992", hash_generated_method = "CC5EC6776CB29CF601AC2391147BAC49")
    public  DERNumericString(
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
        this.string = new String(cs);
        // ---------- Original Method ----------
        //char[]  cs = new char[string.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)(string[i] & 0xff);
        //}
        //this.string = new String(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.058 -0400", hash_original_method = "4A4CC31A466FEB81F134844B7BA257FB", hash_generated_method = "F68CB3283C8D4442C3B0A799F975D5BD")
    public  DERNumericString(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.058 -0400", hash_original_method = "E352C3D2266CB71465C2437206485D10", hash_generated_method = "F07B28E36B29C0607F2FB68BC95FCA02")
    public  DERNumericString(
        String   string,
        boolean  validate) {
        {
            boolean varA832D522550617E6474D96A174BFFC39_1898839049 = (validate && !isNumericString(string));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("string contains illegal characters");
            } //End block
        } //End collapsed parenthetic
        this.string = string;
        addTaint(validate);
        // ---------- Original Method ----------
        //if (validate && !isNumericString(string))
        //{
            //throw new IllegalArgumentException("string contains illegal characters");
        //}
        //this.string = string;
    }

    
        public static DERNumericString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERNumericString)
        {
            return (DERNumericString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERNumericString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERNumericString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERNumericString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.059 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "51C3971E0061EDC18D09CA4D0E831DAE")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1169911478 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1169911478 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1169911478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1169911478;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.066 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "FE5780D184F357EEBB8704587F3E9A25")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_738938179 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_738938179 = string;
        varB4EAC82CA7396A68D541C85D26508E83_738938179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_738938179;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.076 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "13A2D092DEE0EA2E252C916B4B94C424")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_258510941 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_258510941;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.077 -0400", hash_original_method = "9CAFE2F99C4AA1A810005CA2021DBA5F", hash_generated_method = "35A32FE8EBB6FD07F8E3CC34B44D1432")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(NUMERIC_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(NUMERIC_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.077 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "6790F04C74FA83A9794E546FF360AAC0")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_414632937 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427020551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427020551;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.078 -0400", hash_original_method = "8BA017E030540263DAC8EBF952EA3B45", hash_generated_method = "F79FF03E3C39BD6ABFF3A77476A88214")
     boolean asn1Equals(
        DERObject  o) {
        DERNumericString s;
        s = (DERNumericString)o;
        boolean varEE57EA262042757EB3692934946962F3_1299896565 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1444337899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1444337899;
        // ---------- Original Method ----------
        //if (!(o instanceof DERNumericString))
        //{
            //return false;
        //}
        //DERNumericString  s = (DERNumericString)o;
        //return this.getString().equals(s.getString());
    }

    
        public static boolean isNumericString(
        String  str) {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);
            if (ch > 0x007f)
            {
                return false;
            }
            if (('0' <= ch && ch <= '9') || ch == ' ')
            {
                continue;
            }
            return false;
        }
        return true;
    }

    
}

