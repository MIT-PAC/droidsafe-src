package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityClient;

public class SecurityClientList extends SIPHeaderList<SecurityClient> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.659 -0400", hash_original_method = "917A181365931F7A6837DEBD96805F45", hash_generated_method = "E0A52096EC1B851DD08D91D4333A641E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityClientList() {
        super(SecurityClient.class, SecurityClientHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.660 -0400", hash_original_method = "8CB3EC0B5802F634A5AAC136D83D14DA", hash_generated_method = "B677EC25ADDD8ADEA14B86035EB72846")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SecurityClientList retval;
        retval = new SecurityClientList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1584794659 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecurityClientList retval = new SecurityClientList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = 3094231003329176217L;
}

