package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PrivacyList extends SIPHeaderList<Privacy> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.474 -0400", hash_original_method = "45F84AF986B8E1D18781B003920274BC", hash_generated_method = "1112F36E1D63D8A6DB0A3433FC13B944")
    public  PrivacyList() {
        super(Privacy.class, PrivacyHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.474 -0400", hash_original_method = "09C54AFDDBF31F8225613CB28A3AFCA3", hash_generated_method = "41E36169445854C7F81E31168244C139")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_836050146 = null; 
        PrivacyList retval = new PrivacyList();
        varB4EAC82CA7396A68D541C85D26508E83_836050146 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_836050146.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_836050146;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.474 -0400", hash_original_field = "C0CA76C219951888324430E8E7118357", hash_generated_field = "2DADF4F7F0061239917C97DB089D6111")

    private static final long serialVersionUID = 1798720509806307461L;
}

