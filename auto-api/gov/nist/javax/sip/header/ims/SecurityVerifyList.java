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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.674 -0400", hash_original_method = "BB5D31C764D6B5DBD9562757DE1BE4AB", hash_generated_method = "F095E831F1F6EEA6D531EE4D2FD13812")
    public  SecurityVerifyList() {
        super(SecurityVerify.class, SecurityVerifyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.675 -0400", hash_original_method = "5D85FA960C60C09D5CA838E3BC582AEC", hash_generated_method = "61EBE7ADB66E3C8D08D6EDB569E144B7")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1908448351 = null; //Variable for return #1
        SecurityVerifyList retval;
        retval = new SecurityVerifyList();
        varB4EAC82CA7396A68D541C85D26508E83_1908448351 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1908448351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1908448351;
        // ---------- Original Method ----------
        //SecurityVerifyList retval = new SecurityVerifyList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.675 -0400", hash_original_field = "52F8DFE6BBE9E79F4E444977F64C9940", hash_generated_field = "E1CF673B2F72F400D90D17D93B6AA895")

    private static long serialVersionUID = 563201040577795125L;
}

