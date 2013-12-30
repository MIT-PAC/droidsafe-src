package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class AuthorizationList extends SIPHeaderList<Authorization> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.381 -0500", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
    /**
     * constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.386 -0500", hash_original_method = "84C7F0569F21A5F411F5E14C38C62885", hash_generated_method = "9E714D95E1CC610DF76FCCBD775E49C5")
    
public AuthorizationList() {
        super(Authorization.class, Authorization.NAME);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.383 -0500", hash_original_method = "81792A8EF4604C1C9CC7309BCA2D7523", hash_generated_method = "4BE3C1A579D3044C077E5040F8686124")
    
public Object clone() {
        AuthorizationList retval = new AuthorizationList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

