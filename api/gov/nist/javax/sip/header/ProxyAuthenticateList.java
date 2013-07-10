package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class ProxyAuthenticateList extends SIPHeaderList<ProxyAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.923 -0400", hash_original_method = "57E0FF9724534118B460C05E52A5FB72", hash_generated_method = "E5AD5AA5CA84C69837EF7825C288CAEA")
    public  ProxyAuthenticateList() {
        super(ProxyAuthenticate.class, ProxyAuthenticateHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.924 -0400", hash_original_method = "ECB851A15E7FFD0CBDE6FF3F7172E98C", hash_generated_method = "CD71E6E3D7FEE59F1C99A3E21666104A")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1667533596 = null; 
        ProxyAuthenticateList retval = new ProxyAuthenticateList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1667533596 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1667533596.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1667533596;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.924 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

