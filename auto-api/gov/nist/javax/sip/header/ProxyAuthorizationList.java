package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ProxyAuthorizationList extends SIPHeaderList<ProxyAuthorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.079 -0400", hash_original_method = "7E2339716E9E591A456966370DA5C67A", hash_generated_method = "13BE6CAE5E4586734CD6519D7633A9B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyAuthorizationList() {
        super(ProxyAuthorization.class, ProxyAuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.079 -0400", hash_original_method = "99D8471E873632F99CA4FA915EADF5BB", hash_generated_method = "EBE99828BCC086DEC9F8F9D0AFFE0914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ProxyAuthorizationList retval;
        retval = new ProxyAuthorizationList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ProxyAuthorizationList retval = new ProxyAuthorizationList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = -1L;
}

