package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AuthorizationList extends SIPHeaderList<Authorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.526 -0400", hash_original_method = "84C7F0569F21A5F411F5E14C38C62885", hash_generated_method = "F63A8C57CD2EBABA71B55FD2B076BBC7")
    public  AuthorizationList() {
        super(Authorization.class, Authorization.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.527 -0400", hash_original_method = "81792A8EF4604C1C9CC7309BCA2D7523", hash_generated_method = "4DB6496F74069E5F263FCDAC42864A48")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_429162298 = null; //Variable for return #1
        AuthorizationList retval;
        retval = new AuthorizationList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_429162298 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_429162298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_429162298;
        // ---------- Original Method ----------
        //AuthorizationList retval = new AuthorizationList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.527 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

