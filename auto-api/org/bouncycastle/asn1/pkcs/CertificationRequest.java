package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.419 -0400", hash_original_field = "66B6EAFFEC09FB0317492231378FF840", hash_generated_field = "9003A12F8EA0B0C4D36EC9A5166E846B")

    protected CertificationRequestInfo reqInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.419 -0400", hash_original_field = "76602024B157ED3EA07204530179A3A3", hash_generated_field = "0CADAF1F8C74DFC150BC4DB1CAB57B11")

    protected AlgorithmIdentifier sigAlgId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.419 -0400", hash_original_field = "DE238EC2E754643C29839D6A095B3831", hash_generated_field = "35F757CB0917C0394ECE5737FF60FF6E")

    protected DERBitString sigBits = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.419 -0400", hash_original_method = "1CFEB89AC9CC2F01B2815840CE7D5DC0", hash_generated_method = "0A9AC513A138E0AC5A936CA016F6281D")
    protected  CertificationRequest() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.419 -0400", hash_original_method = "3309D08710207237EB4B8131BFE31567", hash_generated_method = "B889F4024E78CCDC5E0231360ADCD23C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.426 -0400", hash_original_method = "9E46DFFF284F62A1B4585D1F4143C812", hash_generated_method = "6C0103451ABC5EFB3EFDF0C037047379")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.438 -0400", hash_original_method = "1818E5C8C94900171F27F008E876A50C", hash_generated_method = "9C0926FD4BC1E5149FD7035FC757BAAD")
    public CertificationRequestInfo getCertificationRequestInfo() {
        CertificationRequestInfo varB4EAC82CA7396A68D541C85D26508E83_108765573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_108765573 = reqInfo;
        varB4EAC82CA7396A68D541C85D26508E83_108765573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_108765573;
        // ---------- Original Method ----------
        //return reqInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.438 -0400", hash_original_method = "D2F866B035500F031847DB89A72323B9", hash_generated_method = "42A20FDFE1442021FD690E4D60286376")
    public AlgorithmIdentifier getSignatureAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1871439173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1871439173 = sigAlgId;
        varB4EAC82CA7396A68D541C85D26508E83_1871439173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1871439173;
        // ---------- Original Method ----------
        //return sigAlgId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.439 -0400", hash_original_method = "FF80120581998E22D8FC69A9F1A1E26B", hash_generated_method = "D44768EB2DBE132325E133E2309CCF76")
    public DERBitString getSignature() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_2005335169 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005335169 = sigBits;
        varB4EAC82CA7396A68D541C85D26508E83_2005335169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005335169;
        // ---------- Original Method ----------
        //return sigBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.443 -0400", hash_original_method = "52E36C7D6F310829AB6E6BD23A9D3BF1", hash_generated_method = "928A4410CF72D58157E0C0D85C716407")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1447013070 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(reqInfo);
        v.add(sigAlgId);
        v.add(sigBits);
        varB4EAC82CA7396A68D541C85D26508E83_1447013070 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1447013070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1447013070;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(reqInfo);
        //v.add(sigAlgId);
        //v.add(sigBits);
        //return new DERSequence(v);
    }

    
}

