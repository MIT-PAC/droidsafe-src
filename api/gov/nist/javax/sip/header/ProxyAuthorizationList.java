package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class ProxyAuthorizationList extends SIPHeaderList<ProxyAuthorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.935 -0400", hash_original_method = "7E2339716E9E591A456966370DA5C67A", hash_generated_method = "13BE6CAE5E4586734CD6519D7633A9B2")
    public  ProxyAuthorizationList() {
        super(ProxyAuthorization.class, ProxyAuthorizationHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.936 -0400", hash_original_method = "99D8471E873632F99CA4FA915EADF5BB", hash_generated_method = "ADD61537D7BB76B0F09E4CC88E4A4ABC")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_709882959 = null; 
        ProxyAuthorizationList retval = new ProxyAuthorizationList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_709882959 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_709882959.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_709882959;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.936 -0400", hash_original_field = "E460F7E4ADA0B134B90E3C7ACE044BAF", hash_generated_field = "EC74D7B41C3C9002F8FE992882CA7626")

    private static final long serialVersionUID = -1L;
}

