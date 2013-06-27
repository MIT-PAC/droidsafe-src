package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class BERFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.787 -0400", hash_original_method = "2004A08EE5598C5717D896D52ED3CFF9", hash_generated_method = "2004A08EE5598C5717D896D52ED3CFF9")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.788 -0400", hash_original_field = "FABD506CB176E92C34457223B1F5113E", hash_generated_field = "9D24BA6A8665F5D6A41954CEE254B5E3")

    static BERSequence EMPTY_SEQUENCE = new BERSequence();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.788 -0400", hash_original_field = "8A759E674F8D28D1C9BB4A17B276F187", hash_generated_field = "B8A8D3ECED1DEB6892A4BFD4E81054C9")

    static BERSet EMPTY_SET = new BERSet();
}

