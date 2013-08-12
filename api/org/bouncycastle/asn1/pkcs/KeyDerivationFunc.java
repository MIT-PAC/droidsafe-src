package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;



public class KeyDerivationFunc extends AlgorithmIdentifier {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.946 -0400", hash_original_method = "AD6BDDE959CE01BE7444FB2D02D03B3C", hash_generated_method = "0A265C1C624C15A4DCB5E7E95069D561")
      KeyDerivationFunc(
        ASN1Sequence  seq) {
        super(seq);
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.946 -0400", hash_original_method = "88796F5C07F15C92E2EFA3D6482AE187", hash_generated_method = "FAB15ECB5B5A4C207EEF9196F617B260")
    public  KeyDerivationFunc(
        DERObjectIdentifier id,
        ASN1Encodable       params) {
        super(id, params);
        addTaint(params.getTaint());
        addTaint(id.getTaint());
        // ---------- Original Method ----------
    }

    
}

