package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AcceptEncodingList extends SIPHeaderList<AcceptEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.636 -0400", hash_original_method = "6872E94CB9CC14DAB89517B2FDF048F7", hash_generated_method = "8D77967938F665982D2EA5AC5A044ED3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptEncodingList() {
        super(AcceptEncoding.class, AcceptEncodingHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.636 -0400", hash_original_method = "39DF8810A78ACD57DE26FFD5511EC56E", hash_generated_method = "AB3D1AC8AE31811CD573543F14C48F36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        AcceptEncodingList retval;
        retval = new AcceptEncodingList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AcceptEncodingList retval = new AcceptEncodingList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
}

