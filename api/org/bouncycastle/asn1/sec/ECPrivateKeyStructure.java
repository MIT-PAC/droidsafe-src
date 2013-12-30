package org.bouncycastle.asn1.sec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.BigIntegers;






public class ECPrivateKeyStructure extends ASN1Encodable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.903 -0500", hash_original_field = "67B66723C4558F27E19029159A09253A", hash_generated_field = "37E06257AFCE21CC4EDFE67F34DC271C")

    private ASN1Sequence  seq;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.906 -0500", hash_original_method = "D12821E856A648EC440CD525D918157C", hash_generated_method = "A68BAD4AAB480A2E7BE6E5A231381F22")
    
public ECPrivateKeyStructure(
        ASN1Sequence  seq)
    {
        this.seq = seq;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.909 -0500", hash_original_method = "722B9EB1887267D3DC7C06AD31EE54C1", hash_generated_method = "BCE8D78B5238BAB1C8693E6E331470FF")
    
public ECPrivateKeyStructure(
        BigInteger  key)
    {
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);

        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(new DERInteger(1));
        v.add(new DEROctetString(bytes));

        seq = new DERSequence(v);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.912 -0500", hash_original_method = "407D07F6896B0C0E44D96F389E9D6F27", hash_generated_method = "5A7EFFA01892E1270667AAE53BA7BF4C")
    
public ECPrivateKeyStructure(
        BigInteger    key,
        ASN1Encodable parameters)
    {
        this(key, null, parameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.915 -0500", hash_original_method = "C18ECEEFE6A75682B0803E3F34C5782F", hash_generated_method = "B85488BAD5CD5C0674C9A1567398920C")
    
public ECPrivateKeyStructure(
        BigInteger    key,
        DERBitString  publicKey,
        ASN1Encodable parameters)
    {
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);

        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(new DERInteger(1));
        v.add(new DEROctetString(bytes));

        if (parameters != null)
        {
            v.add(new DERTaggedObject(true, 0, parameters));
        }

        if (publicKey != null)
        {
            v.add(new DERTaggedObject(true, 1, publicKey));
        }

        seq = new DERSequence(v);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.917 -0500", hash_original_method = "3364DFDFDAE0C599569065625E34DFA6", hash_generated_method = "58D9B52081BC7BE22DFFBCD415AC7AE0")
    
public BigInteger getKey()
    {
        ASN1OctetString  octs = (ASN1OctetString)seq.getObjectAt(1);

        return new BigInteger(1, octs.getOctets());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.919 -0500", hash_original_method = "DEBAFCE224E8193448683CCA3427311E", hash_generated_method = "0E4C7DA28767A783362300A26CB8EA66")
    
public DERBitString getPublicKey()
    {
        return (DERBitString)getObjectInTag(1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.922 -0500", hash_original_method = "6CC550729D926E5F97154297F8F1FBC7", hash_generated_method = "C45B7BA65F98995134F30F5384B871C4")
    
public ASN1Object getParameters()
    {
        return getObjectInTag(0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.924 -0500", hash_original_method = "F319A866ECD7F1BB5BF305B540FF9ADA", hash_generated_method = "A4E55A8C11A667E5BE3707ECC99AF9F0")
    
private ASN1Object getObjectInTag(int tagNo)
    {
        Enumeration e = seq.getObjects();

        while (e.hasMoreElements())
        {
            DEREncodable obj = (DEREncodable)e.nextElement();

            if (obj instanceof ASN1TaggedObject)
            {
                ASN1TaggedObject tag = (ASN1TaggedObject)obj;
                if (tag.getTagNo() == tagNo)
                {
                    return (ASN1Object)((DEREncodable)tag.getObject()).getDERObject();
                }
            }
        }
        return null;
    }

    /**
     * ECPrivateKey ::= SEQUENCE {
     *     version INTEGER { ecPrivkeyVer1(1) } (ecPrivkeyVer1),
     *     privateKey OCTET STRING,
     *     parameters [0] Parameters OPTIONAL,
     *     publicKey [1] BIT STRING OPTIONAL }
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.927 -0500", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "DA3C9DFD280268761F4161BB76907E1D")
    
public DERObject toASN1Object()
    {
        return seq;
    }

    
}

