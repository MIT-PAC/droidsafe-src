package org.bouncycastle.asn1.pkcs;

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
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;






public class CertificationRequest extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.800 -0500", hash_original_method = "9ADEAA5B9ED42763F6D36948E570D4D8", hash_generated_method = "D46C098F1E26C015A778C7B8ED3EED0F")
    
public static CertificationRequest getInstance(Object o)
    {
        if (o instanceof CertificationRequest)
        {
            return (CertificationRequest)o;
        }

        if (o != null)
        {
            return new CertificationRequest(ASN1Sequence.getInstance(o));
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.793 -0500", hash_original_field = "5F5A3A4EED399C2BE996EC7F8DF8FDD6", hash_generated_field = "9003A12F8EA0B0C4D36EC9A5166E846B")

    protected CertificationRequestInfo reqInfo = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.796 -0500", hash_original_field = "AFF0C98182402754924FB60B65FAE195", hash_generated_field = "0CADAF1F8C74DFC150BC4DB1CAB57B11")

    protected AlgorithmIdentifier sigAlgId = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.798 -0500", hash_original_field = "EAFD6DB9169A2E33B5EC6550DF10172C", hash_generated_field = "35F757CB0917C0394ECE5737FF60FF6E")

    protected DERBitString sigBits = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.803 -0500", hash_original_method = "1CFEB89AC9CC2F01B2815840CE7D5DC0", hash_generated_method = "0981917C55C818AEAD949C537664417D")
    
protected CertificationRequest()
    {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.806 -0500", hash_original_method = "3309D08710207237EB4B8131BFE31567", hash_generated_method = "F79F6C95D90A7D16D4899BCD7AEEF732")
    
public CertificationRequest(
        CertificationRequestInfo requestInfo,
        AlgorithmIdentifier     algorithm,
        DERBitString            signature)
    {
        this.reqInfo = requestInfo;
        this.sigAlgId = algorithm;
        this.sigBits = signature;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.809 -0500", hash_original_method = "9E46DFFF284F62A1B4585D1F4143C812", hash_generated_method = "00FD8182776F94AFB917D2525DB1B4B5")
    
public CertificationRequest(
        ASN1Sequence seq)
    {
        reqInfo = CertificationRequestInfo.getInstance(seq.getObjectAt(0));
        sigAlgId = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        sigBits = (DERBitString)seq.getObjectAt(2);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.812 -0500", hash_original_method = "1818E5C8C94900171F27F008E876A50C", hash_generated_method = "8DFED81CA8EFBD00BA2DF4220FD095ED")
    
public CertificationRequestInfo getCertificationRequestInfo()
    {
        return reqInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.815 -0500", hash_original_method = "D2F866B035500F031847DB89A72323B9", hash_generated_method = "6984460BA5DE014B902746D48E3B8DE5")
    
public AlgorithmIdentifier getSignatureAlgorithm()
    {
        return sigAlgId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.817 -0500", hash_original_method = "FF80120581998E22D8FC69A9F1A1E26B", hash_generated_method = "418DF0EF8F25AAE0334689FFFEB7B795")
    
public DERBitString getSignature()
    {
        return sigBits;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.819 -0500", hash_original_method = "52E36C7D6F310829AB6E6BD23A9D3BF1", hash_generated_method = "6C2C720A00B52249A46D1675EB6F38A9")
    
public DERObject toASN1Object()
    {
        // Construct the CertificateRequest
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(reqInfo);
        v.add(sigAlgId);
        v.add(sigBits);

        return new DERSequence(v);
    }

    
}

