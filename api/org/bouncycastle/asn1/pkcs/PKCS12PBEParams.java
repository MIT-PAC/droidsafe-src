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




public class PKCS12PBEParams extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.675 -0500", hash_original_method = "ED486E24F46E65387FF2C084F6C3AAF1", hash_generated_method = "D8E3D7C065F78D4B50727C1325A974D0")
    
public static PKCS12PBEParams getInstance(
        Object  obj)
    {
        if (obj instanceof PKCS12PBEParams)
        {
            return (PKCS12PBEParams)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new PKCS12PBEParams((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.665 -0500", hash_original_field = "78F9CF53C7E0D6433DD6CC8969049302", hash_generated_field = "78F9CF53C7E0D6433DD6CC8969049302")

    DERInteger      iterations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.667 -0500", hash_original_field = "B25868518F07845AA04DDD7C4143C484", hash_generated_field = "B25868518F07845AA04DDD7C4143C484")

    ASN1OctetString iv;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.669 -0500", hash_original_method = "386E04A4D9F1D93ADFE74A748112E74F", hash_generated_method = "AA5BC1405F72A94F71125B0556588513")
    
public PKCS12PBEParams(
        byte[]      salt,
        int         iterations)
    {
        this.iv = new DEROctetString(salt);
        this.iterations = new DERInteger(iterations);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.672 -0500", hash_original_method = "9796F53576903CCA620F278DD161E921", hash_generated_method = "D51CFC4C40B71528863B498B81E8C4A5")
    
public PKCS12PBEParams(
        ASN1Sequence  seq)
    {
        iv = (ASN1OctetString)seq.getObjectAt(0);
        iterations = (DERInteger)seq.getObjectAt(1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.677 -0500", hash_original_method = "DD1CD350639FBEA94B58D8C0FBFF69DE", hash_generated_method = "4E3A7447059AA4F944D8DC554668A14F")
    
public BigInteger getIterations()
    {
        return iterations.getValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.679 -0500", hash_original_method = "ABC6C1F7D45D0FDDF94BEAE70F71F0ED", hash_generated_method = "2F01B0CBBD4FF00E85E017A8BAF0056D")
    
public byte[] getIV()
    {
        return iv.getOctets();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.682 -0500", hash_original_method = "08D9069F477C4E4688BE524F0F9F7EEF", hash_generated_method = "583DA0C385E18BCF52D8467D0FBFADE8")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(iv);
        v.add(iterations);

        return new DERSequence(v);
    }

    
}

