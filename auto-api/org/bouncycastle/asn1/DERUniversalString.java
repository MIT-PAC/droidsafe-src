package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERUniversalString extends ASN1Object implements DERString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.276 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "F26C5AE8BA7ACEC7B1EA4DA4444275F5")

    private byte[] string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.277 -0400", hash_original_method = "2B92FC0148DCC3B768EB41AB12E19E0C", hash_generated_method = "EB9C704CCBDB706AC49133E4C66FA4A0")
    public  DERUniversalString(
        byte[]   string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
        public static DERUniversalString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERUniversalString)
        {
            return (DERUniversalString)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DERUniversalString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DERUniversalString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERUniversalString(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.278 -0400", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "FDEDD13BE71165E25FFFBB9FE9D42E36")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_563560349 = null; //Variable for return #1
        StringBuffer buf;
        buf = new StringBuffer("#");
        ByteArrayOutputStream bOut;
        bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut;
        aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(this);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("internal error encoding BitString");
        } //End block
        byte[] string;
        string = bOut.toByteArray();
        {
            int i;
            i = 0;
            {
                buf.append(table[(string[i] >>> 4) & 0xf]);
                buf.append(table[string[i] & 0xf]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_563560349 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_563560349.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_563560349;
        // ---------- Original Method ----------
        //StringBuffer    buf = new StringBuffer("#");
        //ByteArrayOutputStream    bOut = new ByteArrayOutputStream();
        //ASN1OutputStream            aOut = new ASN1OutputStream(bOut);
        //try
        //{
            //aOut.writeObject(this);
        //}
        //catch (IOException e)
        //{
           //throw new RuntimeException("internal error encoding BitString");
        //}
        //byte[]    string = bOut.toByteArray();
        //for (int i = 0; i != string.length; i++)
        //{
            //buf.append(table[(string[i] >>> 4) & 0xf]);
            //buf.append(table[string[i] & 0xf]);
        //}
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.285 -0400", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "B411B6EF297870D8B1B8A1A48361D762")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_242203205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_242203205 = getString();
        varB4EAC82CA7396A68D541C85D26508E83_242203205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_242203205;
        // ---------- Original Method ----------
        //return getString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.305 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "EF49D9E96F9D9703436A6612E8E37580")
    public byte[] getOctets() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1281471826 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1281471826;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.330 -0400", hash_original_method = "7109223BA8B3755943761B0801F71200", hash_generated_method = "275C274B1C235B15774E86034D644668")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.330 -0400", hash_original_method = "2C48DF670B2A84721AF2DD998EBDD99A", hash_generated_method = "2B5951D1746A99AD40E8A1095C7CA434")
     boolean asn1Equals(
        DERObject  o) {
        boolean var00D546E80C3C9A43E63DED65DEC633EB_1535879959 = (this.getString().equals(((DERUniversalString)o).getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406943428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_406943428;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUniversalString))
        //{
            //return false;
        //}
        //return this.getString().equals(((DERUniversalString)o).getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.331 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "93AD30483DADFFD17F55B01F967522D5")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_13440744 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739814414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739814414;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.331 -0400", hash_original_field = "5102FEFA75F1FF15CF0FF9123C653112", hash_generated_field = "16B625E7D69E2A0D7C5AB10B3550AEAF")

    private static char[] table = ;
}

