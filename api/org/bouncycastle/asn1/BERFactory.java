package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



class BERFactory {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.638 -0500", hash_original_method = "C14D343AD2F781B2C351EEE6FA75DC28", hash_generated_method = "730439F28645067A9E0274C479958D7C")
    
static BERSequence createSequence(ASN1EncodableVector v)
    {
        return v.size() < 1 ? EMPTY_SEQUENCE : new BERSequence(v);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.640 -0500", hash_original_method = "F79D9FB64390166BBBDFF1A0E02669C4", hash_generated_method = "28F57A39C1232C573C19CBDE33B03CA2")
    
static BERSet createSet(ASN1EncodableVector v)
    {
        return v.size() < 1 ? EMPTY_SET : new BERSet(v);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.643 -0500", hash_original_method = "FDF25F6AB6ADABC17FFA4B7E90C11C66", hash_generated_method = "9D9428EADAF72068C0B069D7ABEE1DBE")
    
static BERSet createSet(ASN1EncodableVector v, boolean needsSorting)
    {
        return v.size() < 1 ? EMPTY_SET : new BERSet(v, needsSorting);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.634 -0500", hash_original_field = "96FE1B72F7068D51F04F3E9B9F3526A4", hash_generated_field = "18C7EC6F5E26463FA8FB83D596A84D8B")

    static final BERSequence EMPTY_SEQUENCE = new BERSequence();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.636 -0500", hash_original_field = "A94327D69CB428ADF139006A53EEF4AB", hash_generated_field = "B1F53E67BF457A3C3E8E171B8234FB75")

    static final BERSet EMPTY_SET = new BERSet();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.934 -0400", hash_original_method = "2004A08EE5598C5717D896D52ED3CFF9", hash_generated_method = "2004A08EE5598C5717D896D52ED3CFF9")
    public BERFactory ()
    {
        //Synthesized constructor
    }
}

