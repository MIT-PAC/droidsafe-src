package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Object implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.622 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "4DFAD1EC9079C516825D3C67F76850BC")

    byte[] string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.622 -0400", hash_original_method = "210B116B260CE188F6D07BB4AB757CE1", hash_generated_method = "78C1B0AAF84BD1CAEDF7F28C981E84AD")
    public  ASN1OctetString(
        byte[]  string) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("string cannot be null");
        } //End block
        this.string = string;
        // ---------- Original Method ----------
        //if (string == null)
        //{
            //throw new NullPointerException("string cannot be null");
        //}
        //this.string = string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.623 -0400", hash_original_method = "654F394A2F1F18AA4253E49ED9387EFC", hash_generated_method = "D054636742C275320E7ABB3D88479A8B")
    public  ASN1OctetString(
        DEREncodable obj) {
        try 
        {
            this.string = obj.getDERObject().getEncoded(ASN1Encodable.DER);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Error processing object : " + e.toString());
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //this.string = obj.getDERObject().getEncoded(ASN1Encodable.DER);
        //}
        //catch (IOException e)
        //{
            //throw new IllegalArgumentException("Error processing object : " + e.toString());
        //}
    }

    
        public static ASN1OctetString getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof ASN1OctetString)
        {
            return getInstance(o);
        }
        else
        {
            return BERConstructedOctetString.fromSequence(ASN1Sequence.getInstance(o)); 
        }
    }

    
        public static ASN1OctetString getInstance(
        Object  obj) {
        if (obj == null || obj instanceof ASN1OctetString)
        {
            return (ASN1OctetString)obj;
        }
        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.651 -0400", hash_original_method = "34640A97A031BA78080CEBB6F9EA17E5", hash_generated_method = "49ABE60673E5559608972B850C403863")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_285458342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_285458342 = new ByteArrayInputStream(string);
        varB4EAC82CA7396A68D541C85D26508E83_285458342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_285458342;
        // ---------- Original Method ----------
        //return new ByteArrayInputStream(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.651 -0400", hash_original_method = "9D3ECD11646B7B9703C16B797DA8DA2E", hash_generated_method = "65D852AA5933E08829A873DED9101AA4")
    public ASN1OctetStringParser parser() {
        ASN1OctetStringParser varB4EAC82CA7396A68D541C85D26508E83_432953588 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_432953588 = this;
        varB4EAC82CA7396A68D541C85D26508E83_432953588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_432953588;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.652 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "D9B2F35EC87A3754C83A325733D40EC9")
    public byte[] getOctets() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_485634519 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_485634519;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.652 -0400", hash_original_method = "306C0053EB93BF3AE4D12BCDAA093AD0", hash_generated_method = "E17391BC29A1DAF07595F4D4D30C1BB9")
    public int hashCode() {
        int var41933DA9B61B1D0D596F60166BA264CB_1962289871 = (Arrays.hashCode(this.getOctets()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425491071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425491071;
        // ---------- Original Method ----------
        //return Arrays.hashCode(this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.652 -0400", hash_original_method = "5FE20DA2EBC8E33EF5740C0666CFE34F", hash_generated_method = "101C90D6F990CC0F8CB13648937331B8")
     boolean asn1Equals(
        DERObject  o) {
        ASN1OctetString other;
        other = (ASN1OctetString)o;
        boolean var46918AEC61FFB3A9DECC5C637B9D6AC0_779446287 = (Arrays.areEqual(string, other.string));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2078741771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2078741771;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1OctetString))
        //{
            //return false;
        //}
        //ASN1OctetString  other = (ASN1OctetString)o;
        //return Arrays.areEqual(string, other.string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.653 -0400", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "23C095AEEA909DB9D1780AB37E003AC5")
    public DERObject getLoadedObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_898161227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_898161227 = this.getDERObject();
        varB4EAC82CA7396A68D541C85D26508E83_898161227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898161227;
        // ---------- Original Method ----------
        //return this.getDERObject();
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.654 -0400", hash_original_method = "A6F4AE428E861451DA18F2BDC0B16A3E", hash_generated_method = "49ACF77B17E5DB3AE09DEADF1DFC613D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1114653752 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1114653752 = "#"+new String(Hex.encode(string));
        varB4EAC82CA7396A68D541C85D26508E83_1114653752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1114653752;
        // ---------- Original Method ----------
        //return "#"+new String(Hex.encode(string));
    }

    
}

