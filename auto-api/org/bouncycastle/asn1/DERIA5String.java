package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERIA5String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.007 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.008 -0400", hash_original_method = "6D45D0BD0357770FD3E912C483EA28A2", hash_generated_method = "2F75E7C699EC3331FA83A7399D1B5568")
    public  DERIA5String(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.008 -0400", hash_original_method = "E43446DCFA1E12AD62CEF41AA43F405C", hash_generated_method = "1148FF261F792216188D48ADE936F9C9")
    public  DERIA5String(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.008 -0400", hash_original_method = "116E9F3E400BAA7DE0ED2CEAD98AD4A9", hash_generated_method = "094087D679E2089EB1211AEF5DD25E22")
    public  DERIA5String(
        String   string,
        boolean  validate) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("string cannot be null");
        } //End block
        {
            boolean varB801B1D718CB8DA1FEFA96343D82FB76_1926002003 = (validate && !isIA5String(string));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("string contains illegal characters");
            } //End block
        } //End collapsed parenthetic
        this.string = string;
        addTaint(validate);
        // ---------- Original Method ----------
        //if (string == null)
        //{
            //throw new NullPointerException("string cannot be null");
        //}
        //if (validate && !isIA5String(string))
        //{
            //throw new IllegalArgumentException("string contains illegal characters");
        //}
        //this.string = string;
    }

    
        public static DERIA5String getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERIA5String)
        {
            return (DERIA5String)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERIA5String getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERIA5String)
        {
            return getInstance(o);
        }
        else
        {
            return new DERIA5String(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.017 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "0F9129CD27118F2AB241B290A2D2FC2D")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1508958131 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1508958131 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1508958131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1508958131;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.023 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "04C9B644429E56F378FB2EE4EF385C0E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_484838112 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_484838112 = string;
        varB4EAC82CA7396A68D541C85D26508E83_484838112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_484838112;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.023 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "8FA38F9A58BB7A9B5B1500E5A8C51E92")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1979644827 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1979644827;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.023 -0400", hash_original_method = "81A044D942E61187B7BC9BD1DB599BBA", hash_generated_method = "90F8FE9528179B4CE3890909112CE1A4")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(IA5_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(IA5_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.024 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "8CDB08FF4AFEF13152B71AE5D46C6977")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_386041689 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925006454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925006454;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.024 -0400", hash_original_method = "9B52498F79C21F529133E97FFA41DA30", hash_generated_method = "FEC94F87763C7DF7EDA744C66A22DE5F")
     boolean asn1Equals(
        DERObject  o) {
        DERIA5String s;
        s = (DERIA5String)o;
        boolean varEE57EA262042757EB3692934946962F3_2111143214 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94759562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94759562;
        // ---------- Original Method ----------
        //if (!(o instanceof DERIA5String))
        //{
            //return false;
        //}
        //DERIA5String  s = (DERIA5String)o;
        //return this.getString().equals(s.getString());
    }

    
        public static boolean isIA5String(
        String  str) {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);
            if (ch > 0x007f)
            {
                return false;
            }
        }
        return true;
    }

    
}

