package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssertedIdentityList extends SIPHeaderList<PAssertedIdentity> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.544 -0400", hash_original_method = "7B547E5D989DEE32A91F605E4D8F2A3B", hash_generated_method = "73CBFC9BA880055E577FD55BB3BE4139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssertedIdentityList() {
        super(PAssertedIdentity.class, PAssertedIdentityHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.545 -0400", hash_original_method = "5563A5DB4245DEBD4AD09019D9E2D95D", hash_generated_method = "9D0F14E37C3576D9CB1C7A8274B7C284")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PAssertedIdentityList retval;
        retval = new PAssertedIdentityList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1389528802 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAssertedIdentityList retval = new PAssertedIdentityList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -6465152445570308974L;
}

