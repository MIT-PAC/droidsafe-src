package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class BERApplicationSpecific extends DERApplicationSpecific {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.778 -0400", hash_original_method = "E78D77DEE677FFFF68D062C7ECE7F399", hash_generated_method = "3C7E0486D38F4773B245FC6393D48935")
    public  BERApplicationSpecific(int tagNo, ASN1EncodableVector vec) {
        super(tagNo, vec);
        addTaint(vec.getTaint());
        addTaint(tagNo);
        // ---------- Original Method ----------
    }

    
}

