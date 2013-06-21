package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AuthorizationList extends SIPHeaderList<Authorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.825 -0400", hash_original_method = "84C7F0569F21A5F411F5E14C38C62885", hash_generated_method = "F63A8C57CD2EBABA71B55FD2B076BBC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthorizationList() {
        super(Authorization.class, Authorization.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.825 -0400", hash_original_method = "81792A8EF4604C1C9CC7309BCA2D7523", hash_generated_method = "46CDD65B41574460E6B2419E5F232473")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        AuthorizationList retval;
        retval = new AuthorizationList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AuthorizationList retval = new AuthorizationList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 1L;
}

