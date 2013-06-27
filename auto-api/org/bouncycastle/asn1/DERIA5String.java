package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERIA5String extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.097 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.097 -0400", hash_original_method = "6D45D0BD0357770FD3E912C483EA28A2", hash_generated_method = "2F75E7C699EC3331FA83A7399D1B5568")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.108 -0400", hash_original_method = "E43446DCFA1E12AD62CEF41AA43F405C", hash_generated_method = "1148FF261F792216188D48ADE936F9C9")
    public  DERIA5String(
        String   string) {
        this(string, false);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.109 -0400", hash_original_method = "116E9F3E400BAA7DE0ED2CEAD98AD4A9", hash_generated_method = "A7BE2483D57AEF2D90D646C46AD31239")
    public  DERIA5String(
        String   string,
        boolean  validate) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("string cannot be null");
        } //End block
        {
            boolean varB801B1D718CB8DA1FEFA96343D82FB76_2135215181 = (validate && !isIA5String(string));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.110 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "44639A5FE2B585DE798562AAE2B112C8")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1282112546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1282112546 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1282112546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1282112546;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.110 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "631B13A0D056DFDFDAB5686D84D7B524")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1555025800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1555025800 = string;
        varB4EAC82CA7396A68D541C85D26508E83_1555025800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1555025800;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.111 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "39384F5F5650C228FAF4B0B1CA3DF6B1")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1644805391 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1644805391;
        // ---------- Original Method ----------
        //char[]  cs = string.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.122 -0400", hash_original_method = "81A044D942E61187B7BC9BD1DB599BBA", hash_generated_method = "90F8FE9528179B4CE3890909112CE1A4")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(IA5_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(IA5_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.122 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "1751A16AFAC8A8EFA47E1AF8E420EC70")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_661847551 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363110652 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363110652;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.131 -0400", hash_original_method = "9B52498F79C21F529133E97FFA41DA30", hash_generated_method = "1EFBC13909BBC594ACC75A7FA1A28508")
     boolean asn1Equals(
        DERObject  o) {
        DERIA5String s;
        s = (DERIA5String)o;
        boolean varEE57EA262042757EB3692934946962F3_1290003945 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370629070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370629070;
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

