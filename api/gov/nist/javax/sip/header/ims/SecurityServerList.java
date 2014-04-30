package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class SecurityServerList extends SIPHeaderList<SecurityServer> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.923 -0500", hash_original_field = "BFB70B9E8ECA9009582E62A397ECA457", hash_generated_field = "FA2EA3141868868D79B17D55AFCB33DF")

    private static final long serialVersionUID = -1392066520803180238L;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.926 -0500", hash_original_method = "DDC555D009CE8B153DA6D33D8F867563", hash_generated_method = "096F336C3862128AF28B02E09C2DC88D")
    
public SecurityServerList()
    {
        super(SecurityServer.class, SecurityServerHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.930 -0500", hash_original_method = "DB9A46F7231A313671C09010ADA9A7C3", hash_generated_method = "9A26E59B08D0959DFE3D86925B5AB462")
    
public Object clone() {
        SecurityServerList retval = new SecurityServerList();
        return retval.clonehlist(this.hlist);
    }
}

