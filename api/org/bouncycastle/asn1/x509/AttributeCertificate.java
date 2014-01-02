package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;






public class AttributeCertificate extends ASN1Encodable {

    /**
     * @param obj
     * @return an AttributeCertificate object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.654 -0500", hash_original_method = "80A8FEB19F54AF747BBCC88F61BD19AB", hash_generated_method = "9693D71218BF99542E124EF8738418B1")
    
public static AttributeCertificate getInstance(Object obj)
    {
        if (obj instanceof AttributeCertificate)
        {
            return (AttributeCertificate)obj;
        }
        else if (obj != null)
        {
            return new AttributeCertificate(ASN1Sequence.getInstance(obj));
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.648 -0500", hash_original_field = "B5AE372EF54AD09B5DE33BF4EF964975", hash_generated_field = "B5AE372EF54AD09B5DE33BF4EF964975")

    AttributeCertificateInfo    acinfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.650 -0500", hash_original_field = "2F7BE616514E885F71195FC5A07117B0", hash_generated_field = "2F7BE616514E885F71195FC5A07117B0")

    AlgorithmIdentifier         signatureAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.652 -0500", hash_original_field = "4A7A5C247FCE2D566D9AC9C1B8CED914", hash_generated_field = "4A7A5C247FCE2D566D9AC9C1B8CED914")

    DERBitString                signatureValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.657 -0500", hash_original_method = "2BEC4272F0342CC60C1E5750AB362553", hash_generated_method = "846946351C5BBFB4238421D2EC2BC1B4")
    
public AttributeCertificate(
        AttributeCertificateInfo    acinfo,
        AlgorithmIdentifier         signatureAlgorithm,
        DERBitString                signatureValue)
    {
        this.acinfo = acinfo;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = signatureValue;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.660 -0500", hash_original_method = "B4D994B87261FFD4B0816002B55F0788", hash_generated_method = "DF0088A860D8D49B14E7FFB9F47BC64A")
    
public AttributeCertificate(
        ASN1Sequence    seq)
    {
        if (seq.size() != 3)
        {
            throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
        }

        this.acinfo = AttributeCertificateInfo.getInstance(seq.getObjectAt(0));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        this.signatureValue = DERBitString.getInstance(seq.getObjectAt(2));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.662 -0500", hash_original_method = "B550BE2A3120BC2739AC35C67600D16E", hash_generated_method = "21F6FC81631FE2FB6AF87D55399DEB18")
    
public AttributeCertificateInfo getAcinfo()
    {
        return acinfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.664 -0500", hash_original_method = "7848C69970B1A1FD0A4AF2994EC6E56B", hash_generated_method = "722F2F081458606521142B0E7DB4A2D3")
    
public AlgorithmIdentifier getSignatureAlgorithm()
    {
        return signatureAlgorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.667 -0500", hash_original_method = "C8410B5B4D26900579B7A994FFDFFA14", hash_generated_method = "D0B1C6D20ADF6FF2D8857417568427B3")
    
public DERBitString getSignatureValue()
    {
        return signatureValue;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  AttributeCertificate ::= SEQUENCE {
     *       acinfo               AttributeCertificateInfo,
     *       signatureAlgorithm   AlgorithmIdentifier,
     *       signatureValue       BIT STRING
     *  }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.669 -0500", hash_original_method = "EEF14432CC16BDD5140583520373DF2D", hash_generated_method = "F5F1B376AD20FEFF0012CC2869CC3100")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(acinfo);
        v.add(signatureAlgorithm);
        v.add(signatureValue);

        return new DERSequence(v);
    }

    
}

