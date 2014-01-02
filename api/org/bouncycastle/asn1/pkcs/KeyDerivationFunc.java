package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;



public class KeyDerivationFunc extends AlgorithmIdentifier {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.886 -0500", hash_original_method = "AD6BDDE959CE01BE7444FB2D02D03B3C", hash_generated_method = "AD6BDDE959CE01BE7444FB2D02D03B3C")
    
KeyDerivationFunc(
        ASN1Sequence  seq)
    {
        super(seq);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.889 -0500", hash_original_method = "88796F5C07F15C92E2EFA3D6482AE187", hash_generated_method = "A588292C8AC0C5D180FEDF4A12CB7D18")
    
public KeyDerivationFunc(
        DERObjectIdentifier id,
        ASN1Encodable       params)
    {
        super(id, params);
    }

    
}

