package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyDerivationFunc extends AlgorithmIdentifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.056 -0400", hash_original_method = "AD6BDDE959CE01BE7444FB2D02D03B3C", hash_generated_method = "0A265C1C624C15A4DCB5E7E95069D561")
      KeyDerivationFunc(
        ASN1Sequence  seq) {
        super(seq);
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.057 -0400", hash_original_method = "88796F5C07F15C92E2EFA3D6482AE187", hash_generated_method = "59A4A7756BF4D4F9857C701B739F26E5")
    public  KeyDerivationFunc(
        DERObjectIdentifier id,
        ASN1Encodable       params) {
        super(id, params);
        addTaint(id.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
    }

    
}

