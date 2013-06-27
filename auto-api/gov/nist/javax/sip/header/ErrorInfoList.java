package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ErrorInfoList extends SIPHeaderList<ErrorInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.935 -0400", hash_original_method = "BE8380000E3CB2DA0A370B790F9454ED", hash_generated_method = "314469C48167DD93726734246BAB2F4B")
    public  ErrorInfoList() {
        super(ErrorInfo.class, ErrorInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.935 -0400", hash_original_method = "DEBEF33CFB4944E55BD5A9FB315B228C", hash_generated_method = "3D14445E9FE6C7BE2462505C687144AB")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_739658715 = null; //Variable for return #1
        ErrorInfoList retval;
        retval = new ErrorInfoList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_739658715 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_739658715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739658715;
        // ---------- Original Method ----------
        //ErrorInfoList retval = new ErrorInfoList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.939 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

