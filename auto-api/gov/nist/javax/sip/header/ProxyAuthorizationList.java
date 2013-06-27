package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ProxyAuthorizationList extends SIPHeaderList<ProxyAuthorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.269 -0400", hash_original_method = "7E2339716E9E591A456966370DA5C67A", hash_generated_method = "13BE6CAE5E4586734CD6519D7633A9B2")
    public  ProxyAuthorizationList() {
        super(ProxyAuthorization.class, ProxyAuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.271 -0400", hash_original_method = "99D8471E873632F99CA4FA915EADF5BB", hash_generated_method = "89FC1BD1F2F5479F63F19534CD3CB290")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1603141513 = null; //Variable for return #1
        ProxyAuthorizationList retval;
        retval = new ProxyAuthorizationList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1603141513 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1603141513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603141513;
        // ---------- Original Method ----------
        //ProxyAuthorizationList retval = new ProxyAuthorizationList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.271 -0400", hash_original_field = "E460F7E4ADA0B134B90E3C7ACE044BAF", hash_generated_field = "C237B70726DD39073961E4D5475E682F")

    private static long serialVersionUID = -1L;
}

