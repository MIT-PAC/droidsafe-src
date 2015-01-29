package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class SecurityClientList extends SIPHeaderList<SecurityClient> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.417 -0500", hash_original_field = "A049947E4A9DA8A89D6D561F966FF328", hash_generated_field = "B92E7636CCB3AA76B1E07C77D59BF0D0")

    private static final long serialVersionUID = 3094231003329176217L;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.421 -0500", hash_original_method = "917A181365931F7A6837DEBD96805F45", hash_generated_method = "99C5E699BA095669F46F1163AD731AD2")
    
public SecurityClientList()
    {
        super(SecurityClient.class, SecurityClientHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.424 -0500", hash_original_method = "8CB3EC0B5802F634A5AAC136D83D14DA", hash_generated_method = "E489BFA062A3143B472A4B66C0C0558F")
    
public Object clone() {
        SecurityClientList retval = new SecurityClientList();
        return retval.clonehlist(this.hlist);
    }
}

