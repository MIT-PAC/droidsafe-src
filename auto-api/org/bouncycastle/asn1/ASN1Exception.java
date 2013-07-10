package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class ASN1Exception extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.824 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.825 -0400", hash_original_method = "723A1DBA8406751CA0BE121F0D1A9151", hash_generated_method = "BCDB967B921E585F1BBFBFA3FF4A327F")
      ASN1Exception(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.825 -0400", hash_original_method = "D17952479D481E219D9ED9BCF5D089F2", hash_generated_method = "9652B0507CB84355CD198EEA354F92AE")
      ASN1Exception(String message, Throwable cause) {
        super(message);
        this.cause = cause;
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.826 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "8B4076CBC1F898E0A5461C2855BBE13C")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_298925464 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_298925464 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_298925464.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_298925464;
        
        
    }

    
}

