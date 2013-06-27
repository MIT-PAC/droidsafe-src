package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AlertInfoList extends SIPHeaderList<AlertInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.193 -0400", hash_original_method = "A08E8746373CA778814FF59876F6CC5B", hash_generated_method = "1454CC4C294B31424367C5E69A11C07E")
    public  AlertInfoList() {
        super( AlertInfo.class,AlertInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.194 -0400", hash_original_method = "DA21929F9B4B968B70B27DDE76B9FF23", hash_generated_method = "0FC7B99CDA9F376F063D55597176E1A0")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_90315064 = null; //Variable for return #1
        AlertInfoList retval;
        retval = new AlertInfoList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_90315064 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_90315064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90315064;
        // ---------- Original Method ----------
        //AlertInfoList retval = new AlertInfoList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.195 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

