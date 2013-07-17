package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class BERFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.934 -0400", hash_original_method = "2004A08EE5598C5717D896D52ED3CFF9", hash_generated_method = "2004A08EE5598C5717D896D52ED3CFF9")
    public BERFactory ()
    {
        //Synthesized constructor
    }


    static BERSequence createSequence(ASN1EncodableVector v) {
        return v.size() < 1 ? EMPTY_SEQUENCE : new BERSequence(v);
    }

    
    static BERSet createSet(ASN1EncodableVector v) {
        return v.size() < 1 ? EMPTY_SET : new BERSet(v);
    }

    
    static BERSet createSet(ASN1EncodableVector v, boolean needsSorting) {
        return v.size() < 1 ? EMPTY_SET : new BERSet(v, needsSorting);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.937 -0400", hash_original_field = "FABD506CB176E92C34457223B1F5113E", hash_generated_field = "18C7EC6F5E26463FA8FB83D596A84D8B")

    static final BERSequence EMPTY_SEQUENCE = new BERSequence();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.937 -0400", hash_original_field = "8A759E674F8D28D1C9BB4A17B276F187", hash_generated_field = "B1F53E67BF457A3C3E8E171B8234FB75")

    static final BERSet EMPTY_SET = new BERSet();
}

