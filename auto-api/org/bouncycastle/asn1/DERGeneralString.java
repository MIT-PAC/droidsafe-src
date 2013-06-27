package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERGeneralString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.074 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.074 -0400", hash_original_method = "E16C9AF2574A91241A7B16E43930D742", hash_generated_method = "8C5DDE850DD9F6AC501BB8688A1020E8")
    public  DERGeneralString(byte[] string) {
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
        //char[] cs = new char[string.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)(string[i] & 0xff);
        //}
        //this.string = new String(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.089 -0400", hash_original_method = "3F7BE61BE73D3159504C79D758BB363A", hash_generated_method = "F86DDB26CE3D7779080C2999FF08166A")
    public  DERGeneralString(String string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
        public static DERGeneralString getInstance(
        Object obj) {
        if (obj == null || obj instanceof DERGeneralString) 
        {
            return (DERGeneralString) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: "
                + obj.getClass().getName());
    }

    
        public static DERGeneralString getInstance(
        ASN1TaggedObject obj, 
        boolean explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERGeneralString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERGeneralString(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.090 -0400", hash_original_method = "3CB977BE316CAC9520A0E1ADE8D338F7", hash_generated_method = "B4F1743FBAABF98C73AA32719050B3BB")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_643068742 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_643068742 = string;
        varB4EAC82CA7396A68D541C85D26508E83_643068742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_643068742;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.091 -0400", hash_original_method = "A7AD745E242BD88C36EC3708384A50C0", hash_generated_method = "23A2C2347FDC8641F31B43FA9F02D147")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_271115929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_271115929 = string;
        varB4EAC82CA7396A68D541C85D26508E83_271115929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_271115929;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.091 -0400", hash_original_method = "22CE003B24CA00E42241233D24EF8326", hash_generated_method = "09C0E3673E44C3D4E410424A0E248ADC")
    public byte[] getOctets() {
        char[] cs;
        cs = string.toCharArray();
        byte[] bs;
        bs = new byte[cs.length];
        {
            int i;
            i = 0;
            {
                bs[i] = (byte) cs[i];
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1624144877 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1624144877;
        // ---------- Original Method ----------
        //char[] cs = string.toCharArray();
        //byte[] bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++) 
        //{
            //bs[i] = (byte) cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.091 -0400", hash_original_method = "329E6E60BDC6BE9FAC4D8B36E2859F0E", hash_generated_method = "8ADC1B0855D0D1D9DE630F2973C793EA")
     void encode(DEROutputStream out) throws IOException {
        out.writeEncoded(GENERAL_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(GENERAL_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.105 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "3C70358958DF3BCBDB0506BF4C38D58C")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_1248284066 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890810418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890810418;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.106 -0400", hash_original_method = "790E2075BB1CC35320196C74CBC9C39A", hash_generated_method = "D257723B09B61DAFD31DDC8283B7B497")
     boolean asn1Equals(DERObject o) {
        DERGeneralString s;
        s = (DERGeneralString) o;
        boolean varEE57EA262042757EB3692934946962F3_1456046050 = (this.getString().equals(s.getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047268647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047268647;
        // ---------- Original Method ----------
        //if (!(o instanceof DERGeneralString)) 
        //{
            //return false;
        //}
        //DERGeneralString s = (DERGeneralString) o;
        //return this.getString().equals(s.getString());
    }

    
}

