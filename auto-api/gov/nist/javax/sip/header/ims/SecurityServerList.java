package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityServer;

public class SecurityServerList extends SIPHeaderList<SecurityServer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.662 -0400", hash_original_method = "DDC555D009CE8B153DA6D33D8F867563", hash_generated_method = "744A6F9CF502C67EBD2705F91696A76E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityServerList() {
        super(SecurityServer.class, SecurityServerHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.662 -0400", hash_original_method = "DB9A46F7231A313671C09010ADA9A7C3", hash_generated_method = "855D6C9524F6B78B3A39EAF3BA626085")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SecurityServerList retval;
        retval = new SecurityServerList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1100142096 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecurityServerList retval = new SecurityServerList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -1392066520803180238L;
}

