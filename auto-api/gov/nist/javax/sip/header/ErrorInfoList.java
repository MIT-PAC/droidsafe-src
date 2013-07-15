package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class ErrorInfoList extends SIPHeaderList<ErrorInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.489 -0400", hash_original_method = "BE8380000E3CB2DA0A370B790F9454ED", hash_generated_method = "314469C48167DD93726734246BAB2F4B")
    public  ErrorInfoList() {
        super(ErrorInfo.class, ErrorInfoHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.490 -0400", hash_original_method = "DEBEF33CFB4944E55BD5A9FB315B228C", hash_generated_method = "7B0109465431077A153A84F7C31D2E28")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_855339123 = null; 
        ErrorInfoList retval = new ErrorInfoList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_855339123 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_855339123.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_855339123;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.490 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

