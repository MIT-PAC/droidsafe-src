package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AlertInfoList extends SIPHeaderList<AlertInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.388 -0400", hash_original_method = "A08E8746373CA778814FF59876F6CC5B", hash_generated_method = "1454CC4C294B31424367C5E69A11C07E")
    public  AlertInfoList() {
        super( AlertInfo.class,AlertInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.389 -0400", hash_original_method = "DA21929F9B4B968B70B27DDE76B9FF23", hash_generated_method = "301E7E431D20F09C5FFC7E744F5F0A7F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_480673700 = null; //Variable for return #1
        AlertInfoList retval;
        retval = new AlertInfoList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_480673700 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_480673700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480673700;
        // ---------- Original Method ----------
        //AlertInfoList retval = new AlertInfoList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.390 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

