package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityVerify;

public class SecurityVerifyList extends SIPHeaderList<SecurityVerify> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.217 -0400", hash_original_method = "BB5D31C764D6B5DBD9562757DE1BE4AB", hash_generated_method = "F095E831F1F6EEA6D531EE4D2FD13812")
    public  SecurityVerifyList() {
        super(SecurityVerify.class, SecurityVerifyHeader.NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.217 -0400", hash_original_method = "5D85FA960C60C09D5CA838E3BC582AEC", hash_generated_method = "9F90EDF1C4B64933BDD13649A566D925")
    public Object clone() {
        SecurityVerifyList retval = new SecurityVerifyList();
Object varF627329B9209466293A1BF71D9AF7B2B_709784744 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_709784744.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_709784744;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.217 -0400", hash_original_field = "52F8DFE6BBE9E79F4E444977F64C9940", hash_generated_field = "114D267F20A061FCBE08202DA99B055A")

    private static final long serialVersionUID = 563201040577795125L;
}

