package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityServer;

public class SecurityServerList extends SIPHeaderList<SecurityServer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.555 -0400", hash_original_method = "DDC555D009CE8B153DA6D33D8F867563", hash_generated_method = "744A6F9CF502C67EBD2705F91696A76E")
    public  SecurityServerList() {
        super(SecurityServer.class, SecurityServerHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.556 -0400", hash_original_method = "DB9A46F7231A313671C09010ADA9A7C3", hash_generated_method = "CBEA4F4ECA4B11E6DE445F96C9EC655A")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1328930149 = null; 
        SecurityServerList retval = new SecurityServerList();
        varB4EAC82CA7396A68D541C85D26508E83_1328930149 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1328930149.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1328930149;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.556 -0400", hash_original_field = "DA5AA60986249AC34031EC85612912C9", hash_generated_field = "FA2EA3141868868D79B17D55AFCB33DF")

    private static final long serialVersionUID = -1392066520803180238L;
}

