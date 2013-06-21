package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ProxyAuthenticateList extends SIPHeaderList<ProxyAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.077 -0400", hash_original_method = "57E0FF9724534118B460C05E52A5FB72", hash_generated_method = "E5AD5AA5CA84C69837EF7825C288CAEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyAuthenticateList() {
        super(ProxyAuthenticate.class, ProxyAuthenticateHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.077 -0400", hash_original_method = "ECB851A15E7FFD0CBDE6FF3F7172E98C", hash_generated_method = "5F94E89A5C2D9A5FD244A40AFF5FEE1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ProxyAuthenticateList retval;
        retval = new ProxyAuthenticateList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ProxyAuthenticateList retval = new ProxyAuthenticateList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 1L;
}

