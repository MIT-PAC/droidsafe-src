package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class AuthorizationList extends SIPHeaderList<Authorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.205 -0400", hash_original_method = "84C7F0569F21A5F411F5E14C38C62885", hash_generated_method = "F63A8C57CD2EBABA71B55FD2B076BBC7")
    public  AuthorizationList() {
        super(Authorization.class, Authorization.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.206 -0400", hash_original_method = "81792A8EF4604C1C9CC7309BCA2D7523", hash_generated_method = "C1AFF350CD5236D5C0B4036181266E18")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2141411295 = null; 
        AuthorizationList retval = new AuthorizationList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_2141411295 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2141411295.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2141411295;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.207 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

