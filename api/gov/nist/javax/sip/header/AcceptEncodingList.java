package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class AcceptEncodingList extends SIPHeaderList<AcceptEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.805 -0400", hash_original_method = "6872E94CB9CC14DAB89517B2FDF048F7", hash_generated_method = "8D77967938F665982D2EA5AC5A044ED3")
    public  AcceptEncodingList() {
        super(AcceptEncoding.class, AcceptEncodingHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.805 -0400", hash_original_method = "39DF8810A78ACD57DE26FFD5511EC56E", hash_generated_method = "14F512F0E9441114BE56D9CE2855DD4C")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_211954516 = null; 
        AcceptEncodingList retval = new AcceptEncodingList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_211954516 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_211954516.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_211954516;
        
        
        
        
    }

    
}

