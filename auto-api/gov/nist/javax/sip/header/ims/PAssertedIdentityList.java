package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssertedIdentityList extends SIPHeaderList<PAssertedIdentity> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.244 -0400", hash_original_method = "7B547E5D989DEE32A91F605E4D8F2A3B", hash_generated_method = "73CBFC9BA880055E577FD55BB3BE4139")
    public  PAssertedIdentityList() {
        super(PAssertedIdentity.class, PAssertedIdentityHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.245 -0400", hash_original_method = "5563A5DB4245DEBD4AD09019D9E2D95D", hash_generated_method = "9E5DD743F4775E0BF91143F87712E394")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1247862193 = null; //Variable for return #1
        PAssertedIdentityList retval;
        retval = new PAssertedIdentityList();
        varB4EAC82CA7396A68D541C85D26508E83_1247862193 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1247862193.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247862193;
        // ---------- Original Method ----------
        //PAssertedIdentityList retval = new PAssertedIdentityList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.245 -0400", hash_original_field = "52A118C1067FA0A9582F70AC166701CF", hash_generated_field = "DA0776ED676FCD91A7DBD7D6836BCC6E")

    private static long serialVersionUID = -6465152445570308974L;
}

