package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ProxyAuthorizationHeader;






public class ProxyAuthorizationList extends SIPHeaderList<ProxyAuthorization> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.747 -0500", hash_original_field = "940086535B5F9C73E65BCC6CBE990443", hash_generated_field = "EC74D7B41C3C9002F8FE992882CA7626")

    private static final long serialVersionUID = -1L;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.749 -0500", hash_original_method = "7E2339716E9E591A456966370DA5C67A", hash_generated_method = "4037AD3E9AF31EE4ED9B1061CD824248")
    public ProxyAuthorizationList() {
        super(ProxyAuthorization.class, ProxyAuthorizationHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:53.748 -0500", hash_original_method = "99D8471E873632F99CA4FA915EADF5BB", hash_generated_method = "C4252516B3859DE547BA3F5AADFA7863")
    public Object clone() {
        ProxyAuthorizationList retval = new ProxyAuthorizationList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

