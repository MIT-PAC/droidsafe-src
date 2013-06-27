package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ProxyAuthenticateList extends SIPHeaderList<ProxyAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.231 -0400", hash_original_method = "57E0FF9724534118B460C05E52A5FB72", hash_generated_method = "E5AD5AA5CA84C69837EF7825C288CAEA")
    public  ProxyAuthenticateList() {
        super(ProxyAuthenticate.class, ProxyAuthenticateHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.243 -0400", hash_original_method = "ECB851A15E7FFD0CBDE6FF3F7172E98C", hash_generated_method = "B1D19072DE9EA7465F50D98AB8CDEF3F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1350083605 = null; //Variable for return #1
        ProxyAuthenticateList retval;
        retval = new ProxyAuthenticateList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1350083605 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1350083605.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1350083605;
        // ---------- Original Method ----------
        //ProxyAuthenticateList retval = new ProxyAuthenticateList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.243 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

