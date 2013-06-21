package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityVerify;

public class SecurityVerifyList extends SIPHeaderList<SecurityVerify> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.664 -0400", hash_original_method = "BB5D31C764D6B5DBD9562757DE1BE4AB", hash_generated_method = "F095E831F1F6EEA6D531EE4D2FD13812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecurityVerifyList() {
        super(SecurityVerify.class, SecurityVerifyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.664 -0400", hash_original_method = "5D85FA960C60C09D5CA838E3BC582AEC", hash_generated_method = "6D0D6C4C2E585DBB9C86412A15DDC2F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SecurityVerifyList retval;
        retval = new SecurityVerifyList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_218472689 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SecurityVerifyList retval = new SecurityVerifyList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = 563201040577795125L;
}

