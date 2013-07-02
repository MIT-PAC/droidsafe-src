package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class AlertInfoList extends SIPHeaderList<AlertInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.877 -0400", hash_original_method = "A08E8746373CA778814FF59876F6CC5B", hash_generated_method = "1454CC4C294B31424367C5E69A11C07E")
    public  AlertInfoList() {
        super( AlertInfo.class,AlertInfoHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.878 -0400", hash_original_method = "DA21929F9B4B968B70B27DDE76B9FF23", hash_generated_method = "2CF0579ABD91C69C57672343C4BF1318")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_58147687 = null; 
        AlertInfoList retval = new AlertInfoList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_58147687 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_58147687.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_58147687;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.878 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

