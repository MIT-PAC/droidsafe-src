package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;






public class SubjectPublicKeyInfo extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.524 -0500", hash_original_method = "59FD1238A50E7C71F5A7740863FEAF63", hash_generated_method = "CAEBEE4C0FA46A3DB43DA4586838010E")
    
public static SubjectPublicKeyInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.527 -0500", hash_original_method = "0E3E7EF469DA28D1A197D13A6FA73576", hash_generated_method = "87D8C3988800926D61169A9CC86C1163")
    
public static SubjectPublicKeyInfo getInstance(
        Object  obj)
    {
        if (obj instanceof SubjectPublicKeyInfo)
        {
            return (SubjectPublicKeyInfo)obj;
        }
        else if (obj != null)
        {
            return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(obj));
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.519 -0500", hash_original_field = "77AE1AC968895C7830B8ADE3B24ECA2A", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier     algId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.521 -0500", hash_original_field = "DC8F4C0896F58A16A26B2D1A239BE743", hash_generated_field = "B87CF10479B698EDA26B972A47E11904")

    private DERBitString            keyData;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.530 -0500", hash_original_method = "DAF161BC79C94F8473696EE08E829AE4", hash_generated_method = "72FA15591A1F857ACB08086B59CD4CC8")
    
public SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        DEREncodable        publicKey)
    {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.533 -0500", hash_original_method = "01C45324BCF6F8FB0A087E5E236F4467", hash_generated_method = "9D7D222E4252C4382A21A51D3E9539FE")
    
public SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              publicKey)
    {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.535 -0500", hash_original_method = "6922DB35904CEC4F9CE097AEE1FB704C", hash_generated_method = "161CC86EDDDFABBA3E665739F2AE9DA9")
    
public SubjectPublicKeyInfo(
        ASN1Sequence  seq)
    {
        if (seq.size() != 2)
        {
            throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
        }

        Enumeration         e = seq.getObjects();

        this.algId = AlgorithmIdentifier.getInstance(e.nextElement());
        this.keyData = DERBitString.getInstance(e.nextElement());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.538 -0500", hash_original_method = "47532F5520D2937711F415E7F39EF8B8", hash_generated_method = "BCED03BC4375EE48DC08B032712FE68B")
    
public AlgorithmIdentifier getAlgorithmId()
    {
        return algId;
    }

    /**
     * for when the public key is an encoded object - if the bitstring
     * can't be decoded this routine throws an IOException.
     *
     * @exception IOException - if the bit string doesn't represent a DER
     * encoded object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.541 -0500", hash_original_method = "090BC4B735B0EF996158F2D4FCADB97F", hash_generated_method = "D4469112C8AA5CA33918D180170945EF")
    
public DERObject getPublicKey()
        throws IOException
    {
        ASN1InputStream         aIn = new ASN1InputStream(keyData.getBytes());

        return aIn.readObject();
    }

    /**
     * for when the public key is raw bits...
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.544 -0500", hash_original_method = "FD0FC1FA0D4AD47E47F52CC8C4964141", hash_generated_method = "4478A4890BBEF1E246A2B8E762C0A3AA")
    
public DERBitString getPublicKeyData()
    {
        return keyData;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     * SubjectPublicKeyInfo ::= SEQUENCE {
     *                          algorithm AlgorithmIdentifier,
     *                          publicKey BIT STRING }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.546 -0500", hash_original_method = "8E6747A0EE688E54DEDDDF71F404B9F7", hash_generated_method = "8F534217A8FF2702C9892CED0504B925")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(algId);
        v.add(keyData);

        return new DERSequence(v);
    }

    
}

