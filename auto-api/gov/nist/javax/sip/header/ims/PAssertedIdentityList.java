package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssertedIdentityList extends SIPHeaderList<PAssertedIdentity> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.180 -0400", hash_original_method = "7B547E5D989DEE32A91F605E4D8F2A3B", hash_generated_method = "73CBFC9BA880055E577FD55BB3BE4139")
    public  PAssertedIdentityList() {
        super(PAssertedIdentity.class, PAssertedIdentityHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.181 -0400", hash_original_method = "5563A5DB4245DEBD4AD09019D9E2D95D", hash_generated_method = "05D91BD498AB0B28EF364F4022070EB0")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1457185894 = null; 
        PAssertedIdentityList retval = new PAssertedIdentityList();
        varB4EAC82CA7396A68D541C85D26508E83_1457185894 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1457185894.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1457185894;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.181 -0400", hash_original_field = "52A118C1067FA0A9582F70AC166701CF", hash_generated_field = "327B462110ED9334DAFBBBFBC39902B6")

    private static final long serialVersionUID = -6465152445570308974L;
}

