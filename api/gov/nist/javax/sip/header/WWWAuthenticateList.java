package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import  javax.sip.header.*;

public class WWWAuthenticateList extends SIPHeaderList<WWWAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.966 -0400", hash_original_method = "5D0C93082A28C4F76AC90901A48C6BD1", hash_generated_method = "6035EA6C915C1EC737CCB1ED8A829814")
    public  WWWAuthenticateList() {
        super(WWWAuthenticate.class, WWWAuthenticateHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.967 -0400", hash_original_method = "CD4D2DBD74BB3BE1B1C2856EF354DA52", hash_generated_method = "48B7263454C63274F078BE4611F97821")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_19481621 = null; 
        WWWAuthenticateList retval = new WWWAuthenticateList();
        varB4EAC82CA7396A68D541C85D26508E83_19481621 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_19481621.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_19481621;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.967 -0400", hash_original_field = "1E01E6607AEE257B1EA82D4E79E39A88", hash_generated_field = "DAEA8AA6BFFB39A4E5CCB1F3F4CC7E4D")

    private static final long serialVersionUID = -6978902284285501346L;
}

