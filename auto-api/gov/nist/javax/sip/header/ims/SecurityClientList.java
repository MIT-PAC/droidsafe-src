package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.SecurityClient;

public class SecurityClientList extends SIPHeaderList<SecurityClient> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.476 -0400", hash_original_method = "917A181365931F7A6837DEBD96805F45", hash_generated_method = "E0A52096EC1B851DD08D91D4333A641E")
    public  SecurityClientList() {
        super(SecurityClient.class, SecurityClientHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.488 -0400", hash_original_method = "8CB3EC0B5802F634A5AAC136D83D14DA", hash_generated_method = "9314AA130873FDE9F29A0210593852F8")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1297946715 = null; //Variable for return #1
        SecurityClientList retval;
        retval = new SecurityClientList();
        varB4EAC82CA7396A68D541C85D26508E83_1297946715 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1297946715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1297946715;
        // ---------- Original Method ----------
        //SecurityClientList retval = new SecurityClientList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.488 -0400", hash_original_field = "E1C3B5A2AF0EAAE3887FDDB04B41D33B", hash_generated_field = "407595499C57FEA11C303BE7F1010C6E")

    private static long serialVersionUID = 3094231003329176217L;
}

