package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityVerify;

public class SecurityVerifyList extends SIPHeaderList<SecurityVerify> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.567 -0400", hash_original_method = "BB5D31C764D6B5DBD9562757DE1BE4AB", hash_generated_method = "F095E831F1F6EEA6D531EE4D2FD13812")
    public  SecurityVerifyList() {
        super(SecurityVerify.class, SecurityVerifyHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.567 -0400", hash_original_method = "5D85FA960C60C09D5CA838E3BC582AEC", hash_generated_method = "29AAFC2FEB5CFADB224E6FA284F0CF99")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_924230180 = null; 
        SecurityVerifyList retval = new SecurityVerifyList();
        varB4EAC82CA7396A68D541C85D26508E83_924230180 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_924230180.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_924230180;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.567 -0400", hash_original_field = "52F8DFE6BBE9E79F4E444977F64C9940", hash_generated_field = "114D267F20A061FCBE08202DA99B055A")

    private static final long serialVersionUID = 563201040577795125L;
}

