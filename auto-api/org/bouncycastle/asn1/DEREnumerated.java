package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class DEREnumerated extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.045 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[] bytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.046 -0400", hash_original_method = "B36B300F3CB5F32541367868C7626677", hash_generated_method = "E532E052C1FA38D42DFB95732E77D2B4")
    public  DEREnumerated(
        int         value) {
        bytes = BigInteger.valueOf(value).toByteArray();
        // ---------- Original Method ----------
        //bytes = BigInteger.valueOf(value).toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.046 -0400", hash_original_method = "678F1FE65267358F51A86F36E09F17C8", hash_generated_method = "2D794F76CC64ED7BEB779014F7114CE5")
    public  DEREnumerated(
        BigInteger   value) {
        bytes = value.toByteArray();
        // ---------- Original Method ----------
        //bytes = value.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.050 -0400", hash_original_method = "AD7320D92755415772C23A44F11EC5AC", hash_generated_method = "42B294B3504DA5B568596960B2B8FA33")
    public  DEREnumerated(
        byte[]   bytes) {
        this.bytes = bytes;
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
        public static DEREnumerated getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DEREnumerated)
        {
            return (DEREnumerated)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static DEREnumerated getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DEREnumerated)
        {
            return getInstance(o);
        }
        else
        {
            return new DEREnumerated(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.051 -0400", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "A3CAB051817871348E94A5381B06DF70")
    public BigInteger getValue() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1023702620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1023702620 = new BigInteger(bytes);
        varB4EAC82CA7396A68D541C85D26508E83_1023702620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1023702620;
        // ---------- Original Method ----------
        //return new BigInteger(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.051 -0400", hash_original_method = "F1F5D8639E81BFE0F662E5D9DEEDCE8E", hash_generated_method = "6B056E6B6E2E91BC0392D0D604ABFE87")
     void encode(
        DEROutputStream out) throws IOException {
        out.writeEncoded(ENUMERATED, bytes);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(ENUMERATED, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.058 -0400", hash_original_method = "87F9EE40A630F0723068642FAAE69D4D", hash_generated_method = "ACCEA9D2D18E720187659CA6BA32E172")
     boolean asn1Equals(
        DERObject  o) {
        DEREnumerated other;
        other = (DEREnumerated)o;
        boolean varDFB3B47AA311A72834B9B76D9A5D1536_154766603 = (Arrays.areEqual(this.bytes, other.bytes));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865580842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_865580842;
        // ---------- Original Method ----------
        //if (!(o instanceof DEREnumerated))
        //{
            //return false;
        //}
        //DEREnumerated other = (DEREnumerated)o;
        //return Arrays.areEqual(this.bytes, other.bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.061 -0400", hash_original_method = "ECC4B202736A567045152AD0D498E31B", hash_generated_method = "56772228D450024BCAFEECBF95E69BF9")
    public int hashCode() {
        int var88D4CD75A93BDF94B63A1DFF90FF8231_1717913655 = (Arrays.hashCode(bytes));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994562871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994562871;
        // ---------- Original Method ----------
        //return Arrays.hashCode(bytes);
    }

    
}

