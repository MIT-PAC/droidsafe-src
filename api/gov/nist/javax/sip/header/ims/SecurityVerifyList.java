package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;



public class SecurityVerifyList extends SIPHeaderList<SecurityVerify> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.592 -0500", hash_original_field = "4A16F472373C6C0D20533BA3A658CEF5", hash_generated_field = "114D267F20A061FCBE08202DA99B055A")



    private static final long serialVersionUID = 563201040577795125L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.593 -0500", hash_original_method = "BB5D31C764D6B5DBD9562757DE1BE4AB", hash_generated_method = "3473B37762F59EA39EB300C563F0B394")
    public SecurityVerifyList()
    {
        super(SecurityVerify.class, SecurityVerifyHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.594 -0500", hash_original_method = "5D85FA960C60C09D5CA838E3BC582AEC", hash_generated_method = "2057FBC99FA363B01459E25630E30E40")
    public Object clone() {
        SecurityVerifyList retval = new SecurityVerifyList();
        return retval.clonehlist(this.hlist);
    }
}

