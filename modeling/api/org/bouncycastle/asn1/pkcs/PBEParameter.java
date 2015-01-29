package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;




public class PBEParameter extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.324 -0500", hash_original_method = "004964110CEF6E19E709491508C56B4A", hash_generated_method = "E11F14526EFA1E27D8F16DFEDF5B7631")
    
public static PBEParameter getInstance(
        Object  obj)
    {
        if (obj instanceof PBEParameter)
        {
            return (PBEParameter)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new PBEParameter((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.312 -0500", hash_original_field = "78F9CF53C7E0D6433DD6CC8969049302", hash_generated_field = "78F9CF53C7E0D6433DD6CC8969049302")

    DERInteger      iterations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.315 -0500", hash_original_field = "83822DE1D48BD51F36389108E6B20D1C", hash_generated_field = "83822DE1D48BD51F36389108E6B20D1C")

    ASN1OctetString salt;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.318 -0500", hash_original_method = "F7EDA5A89282A21C4F04920900A9B0E0", hash_generated_method = "30C253C025D9CE70E097CCF7F45903B9")
    
public PBEParameter(
        byte[]      salt,
        int         iterations)
    {
        if (salt.length != 8)
        {
            throw new IllegalArgumentException("salt length must be 8");
        }
        this.salt = new DEROctetString(salt);
        this.iterations = new DERInteger(iterations);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.321 -0500", hash_original_method = "8CC750B4C495B3704F501666A3EEDBD9", hash_generated_method = "1AB29871CBA31E95F43C10059A0822AC")
    
public PBEParameter(
        ASN1Sequence  seq)
    {
        salt = (ASN1OctetString)seq.getObjectAt(0);
        iterations = (DERInteger)seq.getObjectAt(1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.328 -0500", hash_original_method = "12A862718040CD6821608ED594311F7C", hash_generated_method = "8C0956F6E505FEA33F4D0C5BCABB8A82")
    
public BigInteger getIterationCount()
    {
        return iterations.getValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.332 -0500", hash_original_method = "54CCD4EF015960D2546AD9BCFDF4FA17", hash_generated_method = "B7C766BA3AF438B80918CB718ECED327")
    
public byte[] getSalt()
    {
        return salt.getOctets();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.334 -0500", hash_original_method = "0DB5FC3A2AA27196084301AD64A15FCF", hash_generated_method = "CF7FEFD50015E3D3B80604CE469C8E10")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(salt);
        v.add(iterations);

        return new DERSequence(v);
    }

    
}

