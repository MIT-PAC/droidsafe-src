package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PMediaAuthorizationList extends SIPHeaderList<PMediaAuthorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.589 -0400", hash_original_method = "656C497A7A9D2E8465BD84DF21BD0C00", hash_generated_method = "9BCAC9929D32D2F555BF0B2B59C10BB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PMediaAuthorizationList() {
        super(PMediaAuthorization.class, PMediaAuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.589 -0400", hash_original_method = "535B60F78292A563EBB4CD53A0D5E752", hash_generated_method = "7AC3C61E8FB5C24B839316A0CC730F44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PMediaAuthorizationList retval;
        retval = new PMediaAuthorizationList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1659458761 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PMediaAuthorizationList retval = new PMediaAuthorizationList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -8226328073989632317L;
}

