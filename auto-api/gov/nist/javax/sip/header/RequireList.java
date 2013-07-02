package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public final class RequireList extends SIPHeaderList<Require> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.117 -0400", hash_original_method = "7F18EBBB41892DE4ABBAD1AE9000FBF7", hash_generated_method = "36D9A361FAF93C191230D023E2D39CA4")
    public  RequireList() {
        super(Require.class, RequireHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.117 -0400", hash_original_method = "4C9D6FE7DF8BFD06BB544C2582BF8758", hash_generated_method = "1028CB83EF0D386CF2BB20580F3301F7")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_72648794 = null; 
        RequireList retval = new RequireList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_72648794 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_72648794.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_72648794;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.117 -0400", hash_original_field = "8080C96575DEF2E403CA5D4337270376", hash_generated_field = "5974674B2811E6A05BEB42772D3F9734")

    private static final long serialVersionUID = -1760629092046963213L;
}

