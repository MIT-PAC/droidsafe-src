package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityClient;

public class SecurityClientList extends SIPHeaderList<SecurityClient> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.545 -0400", hash_original_method = "917A181365931F7A6837DEBD96805F45", hash_generated_method = "E0A52096EC1B851DD08D91D4333A641E")
    public  SecurityClientList() {
        super(SecurityClient.class, SecurityClientHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.546 -0400", hash_original_method = "8CB3EC0B5802F634A5AAC136D83D14DA", hash_generated_method = "693E5E862C32ABDD3584E0871D8479E7")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_24107468 = null; 
        SecurityClientList retval = new SecurityClientList();
        varB4EAC82CA7396A68D541C85D26508E83_24107468 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_24107468.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_24107468;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.546 -0400", hash_original_field = "E1C3B5A2AF0EAAE3887FDDB04B41D33B", hash_generated_field = "B92E7636CCB3AA76B1E07C77D59BF0D0")

    private static final long serialVersionUID = 3094231003329176217L;
}

