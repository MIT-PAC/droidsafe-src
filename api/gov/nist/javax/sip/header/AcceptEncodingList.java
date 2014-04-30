package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.AcceptEncodingHeader;

public class AcceptEncodingList extends SIPHeaderList<AcceptEncoding> {

    /** default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.438 -0500", hash_original_method = "6872E94CB9CC14DAB89517B2FDF048F7", hash_generated_method = "3F163E81D70CC7351578FAFDB890125D")
    
public AcceptEncodingList() {
        super(AcceptEncoding.class, AcceptEncodingHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.435 -0500", hash_original_method = "39DF8810A78ACD57DE26FFD5511EC56E", hash_generated_method = "87537BCF893B3FB01B919BE3358FCE8F")
    
@Override
    public Object clone() {
        AcceptEncodingList retval = new AcceptEncodingList();
        retval.clonehlist(this.hlist);
        return retval;
    }
    
}

