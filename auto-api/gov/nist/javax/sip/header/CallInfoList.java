package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class CallInfoList extends SIPHeaderList<CallInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.290 -0400", hash_original_method = "ED4F99F21CB3236766303F800D1CCEF7", hash_generated_method = "D2020F1988EEA6AAE4D1E2BFFF584D3E")
    public  CallInfoList() {
        super(CallInfo.class, CallInfoHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.291 -0400", hash_original_method = "95B657F1A1F55E6349A24A49AE286459", hash_generated_method = "65C9CC435FF78CA453041296DE3D2F02")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1868082967 = null; 
        CallInfoList retval = new CallInfoList ();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1868082967 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1868082967.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1868082967;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.291 -0400", hash_original_field = "DE847272D55EC344DA2971AC1B9E57F0", hash_generated_field = "40CDC5D99109F77F75DE1AE9F98BF26C")

    private static final long serialVersionUID = -4949850334388806423L;
}

