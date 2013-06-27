package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class CallInfoList extends SIPHeaderList<CallInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.674 -0400", hash_original_method = "ED4F99F21CB3236766303F800D1CCEF7", hash_generated_method = "D2020F1988EEA6AAE4D1E2BFFF584D3E")
    public  CallInfoList() {
        super(CallInfo.class, CallInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.674 -0400", hash_original_method = "95B657F1A1F55E6349A24A49AE286459", hash_generated_method = "4F39FAD3E049A439D81EC0F11D8B1958")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2020077026 = null; //Variable for return #1
        CallInfoList retval;
        retval = new CallInfoList ();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_2020077026 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2020077026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2020077026;
        // ---------- Original Method ----------
        //CallInfoList retval = new CallInfoList ();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.674 -0400", hash_original_field = "DE847272D55EC344DA2971AC1B9E57F0", hash_generated_field = "BFE4364990E04411367D603970756EAF")

    private static long serialVersionUID = -4949850334388806423L;
}

