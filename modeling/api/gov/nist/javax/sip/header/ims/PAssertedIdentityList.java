package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssertedIdentityList extends SIPHeaderList<PAssertedIdentity> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.220 -0500", hash_original_field = "A7ACC90EF62EAA63B226C89A9B875725", hash_generated_field = "327B462110ED9334DAFBBBFBC39902B6")

    private static final long serialVersionUID = -6465152445570308974L;

    /**
     * constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.225 -0500", hash_original_method = "7B547E5D989DEE32A91F605E4D8F2A3B", hash_generated_method = "0C820FF4B4B016F6B6A792084A19DCF5")
    
public PAssertedIdentityList()
    {
        super(PAssertedIdentity.class, PAssertedIdentityHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.228 -0500", hash_original_method = "5563A5DB4245DEBD4AD09019D9E2D95D", hash_generated_method = "D0177B7906254089EAC5F362E6BB0552")
    
public Object clone() {
        PAssertedIdentityList retval = new PAssertedIdentityList();
        return retval.clonehlist(this.hlist);
    }
}

