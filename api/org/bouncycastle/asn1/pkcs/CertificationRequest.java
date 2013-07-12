package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.275 -0400", hash_original_field = "66B6EAFFEC09FB0317492231378FF840", hash_generated_field = "9003A12F8EA0B0C4D36EC9A5166E846B")

    protected CertificationRequestInfo reqInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.275 -0400", hash_original_field = "76602024B157ED3EA07204530179A3A3", hash_generated_field = "0CADAF1F8C74DFC150BC4DB1CAB57B11")

    protected AlgorithmIdentifier sigAlgId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.275 -0400", hash_original_field = "DE238EC2E754643C29839D6A095B3831", hash_generated_field = "35F757CB0917C0394ECE5737FF60FF6E")

    protected DERBitString sigBits = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.275 -0400", hash_original_method = "1CFEB89AC9CC2F01B2815840CE7D5DC0", hash_generated_method = "0A9AC513A138E0AC5A936CA016F6281D")
    protected  CertificationRequest() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.276 -0400", hash_original_method = "3309D08710207237EB4B8131BFE31567", hash_generated_method = "B889F4024E78CCDC5E0231360ADCD23C")
    public  CertificationRequest(
        CertificationRequestInfo requestInfo,
        AlgorithmIdentifier     algorithm,
        DERBitString            signature) {
        this.reqInfo = requestInfo;
        this.sigAlgId = algorithm;
        this.sigBits = signature;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.277 -0400", hash_original_method = "9E46DFFF284F62A1B4585D1F4143C812", hash_generated_method = "6C0103451ABC5EFB3EFDF0C037047379")
    public  CertificationRequest(
        ASN1Sequence seq) {
        reqInfo = CertificationRequestInfo.getInstance(seq.getObjectAt(0));
        sigAlgId = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        sigBits = (DERBitString)seq.getObjectAt(2);
        
        
        
        
    }

    
        public static CertificationRequest getInstance(Object o) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.277 -0400", hash_original_method = "1818E5C8C94900171F27F008E876A50C", hash_generated_method = "EA97A7B34D5E4477AD326E03A40A03AB")
    public CertificationRequestInfo getCertificationRequestInfo() {
CertificationRequestInfo varA100F011E28E515ED2938D9CA6D6D85B_723544991 =         reqInfo;
        varA100F011E28E515ED2938D9CA6D6D85B_723544991.addTaint(taint);
        return varA100F011E28E515ED2938D9CA6D6D85B_723544991;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.278 -0400", hash_original_method = "D2F866B035500F031847DB89A72323B9", hash_generated_method = "18DA53206124BCF93B87337F7275F0C8")
    public AlgorithmIdentifier getSignatureAlgorithm() {
AlgorithmIdentifier varAD578BE7D19E543E6C39C817BAD78E33_758684725 =         sigAlgId;
        varAD578BE7D19E543E6C39C817BAD78E33_758684725.addTaint(taint);
        return varAD578BE7D19E543E6C39C817BAD78E33_758684725;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.278 -0400", hash_original_method = "FF80120581998E22D8FC69A9F1A1E26B", hash_generated_method = "96B5798E0FC311102B255D84AA7A9ACF")
    public DERBitString getSignature() {
DERBitString varC5633072113013D70DBB727048BAA9AC_1715680413 =         sigBits;
        varC5633072113013D70DBB727048BAA9AC_1715680413.addTaint(taint);
        return varC5633072113013D70DBB727048BAA9AC_1715680413;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.278 -0400", hash_original_method = "52E36C7D6F310829AB6E6BD23A9D3BF1", hash_generated_method = "04DD74737A224AF02358083B566BE5B8")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(reqInfo);
        v.add(sigAlgId);
        v.add(sigBits);
DERObject var0B338F106E3279986C87B595B0F4A439_210215993 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_210215993.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_210215993;
        
        
        
        
        
        
    }

    
}

