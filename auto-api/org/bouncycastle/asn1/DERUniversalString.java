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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.366 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "F26C5AE8BA7ACEC7B1EA4DA4444275F5")

    private byte[] string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.366 -0400", hash_original_method = "2B92FC0148DCC3B768EB41AB12E19E0C", hash_generated_method = "EB9C704CCBDB706AC49133E4C66FA4A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.381 -0400", hash_original_method = "C8AC92EF6B951363C15B3CD0868FB9EA", hash_generated_method = "7628C742F7306CB1C5D3C511DFF238F0")
    public String getString() {
        String varB4EAC82CA7396A68D541C85D26508E83_99755228 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_99755228 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_99755228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_99755228;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.382 -0400", hash_original_method = "79F534E26CC8382FAA66B4080878D117", hash_generated_method = "6B867EAA93BB8D440CC5D342169ADA8A")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_11198768 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_11198768 = getString();
        varB4EAC82CA7396A68D541C85D26508E83_11198768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11198768;
        // ---------- Original Method ----------
        //return getString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.382 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "4ACB939F8F5430C6E547A183833CD4D2")
    public byte[] getOctets() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_405732107 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_405732107;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.382 -0400", hash_original_method = "7109223BA8B3755943761B0801F71200", hash_generated_method = "275C274B1C235B15774E86034D644668")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(UNIVERSAL_STRING, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.383 -0400", hash_original_method = "2C48DF670B2A84721AF2DD998EBDD99A", hash_generated_method = "1769FD700B229291793D76F52754425F")
     boolean asn1Equals(
        DERObject  o) {
        boolean var00D546E80C3C9A43E63DED65DEC633EB_992094377 = (this.getString().equals(((DERUniversalString)o).getString()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611354703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611354703;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUniversalString))
        //{
            //return false;
        //}
        //return this.getString().equals(((DERUniversalString)o).getString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.383 -0400", hash_original_method = "929F8DA4B9097458735D9AC5748FD267", hash_generated_method = "9E9B2D219975C4FCD3209F7973D5B2EA")
    public int hashCode() {
        int var21276083EDE53370F5E1E00F33D2C218_140113541 = (this.getString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59839284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59839284;
        // ---------- Original Method ----------
        //return this.getString().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.383 -0400", hash_original_field = "5102FEFA75F1FF15CF0FF9123C653112", hash_generated_field = "AD97C6F731350929D72EDA362115A2B2")

    private static char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
}

