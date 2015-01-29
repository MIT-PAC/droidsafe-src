package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;




public class PBKDF2Params extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.619 -0500", hash_original_method = "3D7772C89CDABE15F842F599F7B3DB3F", hash_generated_method = "9360D13A66A2FDF53946297AEF7529BF")
    
public static PBKDF2Params getInstance(
        Object  obj)
    {
        if (obj instanceof PBKDF2Params)
        {
            return (PBKDF2Params)obj;
        }

        if (obj instanceof ASN1Sequence)
        {
            return new PBKDF2Params((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.611 -0500", hash_original_field = "C4E024966702B2B3513608BAFCBB1CD2", hash_generated_field = "C4E024966702B2B3513608BAFCBB1CD2")

    ASN1OctetString     octStr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.613 -0500", hash_original_field = "445B4EB2AC4E7AC0887283D0FCFD8571", hash_generated_field = "445B4EB2AC4E7AC0887283D0FCFD8571")

    DERInteger          iterationCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.616 -0500", hash_original_field = "20DCD247C63016DB3D80E9C4D5F28082", hash_generated_field = "20DCD247C63016DB3D80E9C4D5F28082")

    DERInteger          keyLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.621 -0500", hash_original_method = "5BA909CEBC7BF7CD8A582DB2DCC88322", hash_generated_method = "F5039E58050DBA79088E5868EA20E3B4")
    
public PBKDF2Params(
        byte[]  salt,
        int     iterationCount)
    {
        this.octStr = new DEROctetString(salt);
        this.iterationCount = new DERInteger(iterationCount);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.624 -0500", hash_original_method = "04097C22B31A4C58A7AF2A76FBE1FC77", hash_generated_method = "2D446164BD6B3C2662557990869A648A")
    
public PBKDF2Params(
        ASN1Sequence  seq)
    {
        Enumeration e = seq.getObjects();

        octStr = (ASN1OctetString)e.nextElement();
        iterationCount = (DERInteger)e.nextElement();

        if (e.hasMoreElements())
        {
            keyLength = (DERInteger)e.nextElement();
        }
        else
        {
            keyLength = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.626 -0500", hash_original_method = "5423221662EFD73C70147CAB8114C396", hash_generated_method = "80B1339A2DD116116449C8E63DE6BA54")
    
public byte[] getSalt()
    {
        return octStr.getOctets();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.629 -0500", hash_original_method = "1C8F1DF1E9A7C9D74F917C50A0F9295E", hash_generated_method = "FFE158B115EA99915D5238786A45AD24")
    
public BigInteger getIterationCount()
    {
        return iterationCount.getValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.631 -0500", hash_original_method = "05FD7C7D47C946F5351B5DDBB4ABDC60", hash_generated_method = "532C07540C0957E74958EFAFC5255822")
    
public BigInteger getKeyLength()
    {
        if (keyLength != null)
        {
            return keyLength.getValue();
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.633 -0500", hash_original_method = "B60CD10E8E03E12312566D8BFE3F0B82", hash_generated_method = "A78F2D8DA7FEA0F3D48D47A0F60C797D")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(octStr);
        v.add(iterationCount);

        if (keyLength != null)
        {
            v.add(keyLength);
        }

        return new DERSequence(v);
    }

    
}

