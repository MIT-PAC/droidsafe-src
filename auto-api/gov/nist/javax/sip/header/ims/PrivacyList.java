package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PrivacyList extends SIPHeaderList<Privacy> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.639 -0400", hash_original_method = "45F84AF986B8E1D18781B003920274BC", hash_generated_method = "1112F36E1D63D8A6DB0A3433FC13B944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrivacyList() {
        super(Privacy.class, PrivacyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.640 -0400", hash_original_method = "09C54AFDDBF31F8225613CB28A3AFCA3", hash_generated_method = "4084497F18BE2AA167B39E8E73ED0B21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PrivacyList retval;
        retval = new PrivacyList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_407179523 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PrivacyList retval = new PrivacyList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = 1798720509806307461L;
}

