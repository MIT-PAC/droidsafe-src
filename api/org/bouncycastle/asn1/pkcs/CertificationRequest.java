package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;






public class CertificationRequest extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.863 -0400", hash_original_field = "66B6EAFFEC09FB0317492231378FF840", hash_generated_field = "9003A12F8EA0B0C4D36EC9A5166E846B")

    protected CertificationRequestInfo reqInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.864 -0400", hash_original_field = "76602024B157ED3EA07204530179A3A3", hash_generated_field = "0CADAF1F8C74DFC150BC4DB1CAB57B11")

    protected AlgorithmIdentifier sigAlgId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.864 -0400", hash_original_field = "DE238EC2E754643C29839D6A095B3831", hash_generated_field = "35F757CB0917C0394ECE5737FF60FF6E")

    protected DERBitString sigBits = null;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.864 -0400", hash_original_method = "1CFEB89AC9CC2F01B2815840CE7D5DC0", hash_generated_method = "0A9AC513A138E0AC5A936CA016F6281D")
    protected  CertificationRequest() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.866 -0400", hash_original_method = "3309D08710207237EB4B8131BFE31567", hash_generated_method = "B889F4024E78CCDC5E0231360ADCD23C")
    public  CertificationRequest(
        CertificationRequestInfo requestInfo,
        AlgorithmIdentifier     algorithm,
        DERBitString            signature) {
        this.reqInfo = requestInfo;
        this.sigAlgId = algorithm;
        this.sigBits = signature;
        // ---------- Original Method ----------
        //this.reqInfo = requestInfo;
        //this.sigAlgId = algorithm;
        //this.sigBits = signature;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.867 -0400", hash_original_method = "9E46DFFF284F62A1B4585D1F4143C812", hash_generated_method = "6C0103451ABC5EFB3EFDF0C037047379")
    public  CertificationRequest(
        ASN1Sequence seq) {
        reqInfo = CertificationRequestInfo.getInstance(seq.getObjectAt(0));
        sigAlgId = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        sigBits = (DERBitString)seq.getObjectAt(2);
        // ---------- Original Method ----------
        //reqInfo = CertificationRequestInfo.getInstance(seq.getObjectAt(0));
        //sigAlgId = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        //sigBits = (DERBitString)seq.getObjectAt(2);
    }

    
    @DSModeled(DSC.SAFE)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.869 -0400", hash_original_method = "1818E5C8C94900171F27F008E876A50C", hash_generated_method = "C848E954B81F79CAEDD61A2151AD8D91")
    public CertificationRequestInfo getCertificationRequestInfo() {
CertificationRequestInfo varA100F011E28E515ED2938D9CA6D6D85B_552223780 =         reqInfo;
        varA100F011E28E515ED2938D9CA6D6D85B_552223780.addTaint(taint);
        return varA100F011E28E515ED2938D9CA6D6D85B_552223780;
        // ---------- Original Method ----------
        //return reqInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.869 -0400", hash_original_method = "D2F866B035500F031847DB89A72323B9", hash_generated_method = "0076A7707275D9E42678ECEF8EBE7175")
    public AlgorithmIdentifier getSignatureAlgorithm() {
AlgorithmIdentifier varAD578BE7D19E543E6C39C817BAD78E33_1841924444 =         sigAlgId;
        varAD578BE7D19E543E6C39C817BAD78E33_1841924444.addTaint(taint);
        return varAD578BE7D19E543E6C39C817BAD78E33_1841924444;
        // ---------- Original Method ----------
        //return sigAlgId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.870 -0400", hash_original_method = "FF80120581998E22D8FC69A9F1A1E26B", hash_generated_method = "86C5EA22E173C95A55E0C3F5BD88D784")
    public DERBitString getSignature() {
DERBitString varC5633072113013D70DBB727048BAA9AC_773319647 =         sigBits;
        varC5633072113013D70DBB727048BAA9AC_773319647.addTaint(taint);
        return varC5633072113013D70DBB727048BAA9AC_773319647;
        // ---------- Original Method ----------
        //return sigBits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.870 -0400", hash_original_method = "52E36C7D6F310829AB6E6BD23A9D3BF1", hash_generated_method = "418AD09F50A553F263696F18F780960F")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(reqInfo);
        v.add(sigAlgId);
        v.add(sigBits);
DERObject var0B338F106E3279986C87B595B0F4A439_1017090080 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1017090080.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1017090080;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(reqInfo);
        //v.add(sigAlgId);
        //v.add(sigBits);
        //return new DERSequence(v);
    }

    
}

