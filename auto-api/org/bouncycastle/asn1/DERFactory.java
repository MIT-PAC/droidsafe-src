package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class DERFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.965 -0400", hash_original_method = "2DA71B0AE496B3C2B80EF0106AA885B2", hash_generated_method = "2DA71B0AE496B3C2B80EF0106AA885B2")
    public DERFactory ()
    {
        //Synthesized constructor
    }


        static DERSequence createSequence(ASN1EncodableVector v) {
        return v.size() < 1 ? EMPTY_SEQUENCE : new DERSequence(v);
    }

    
        static DERSet createSet(ASN1EncodableVector v) {
        return v.size() < 1 ? EMPTY_SET : new DERSet(v);
    }

    
        static DERSet createSet(ASN1EncodableVector v, boolean needsSorting) {
        return v.size() < 1 ? EMPTY_SET : new DERSet(v, needsSorting);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.966 -0400", hash_original_field = "5FE057ABAE8DA18326FA833B2A9362EB", hash_generated_field = "A9A20193488069550C04F36414BB9551")

    static DERSequence EMPTY_SEQUENCE = new DERSequence();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.966 -0400", hash_original_field = "BFE8F76F7E1EACC720D86BB88FDEACE4", hash_generated_field = "576BB934F70820C9304DAE8DE057F813")

    static DERSet EMPTY_SET = new DERSet();
}

