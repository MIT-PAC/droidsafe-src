package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ASN1ParsingException extends IllegalStateException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.945 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.945 -0400", hash_original_method = "A04BEE8A9A73EAD532708A0AE36FAA5C", hash_generated_method = "B74E3B8C969CC011DCD96E67B42BFF1B")
      ASN1ParsingException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.946 -0400", hash_original_method = "9ABB1845457B0FD65DC264E5CAAB1469", hash_generated_method = "75E511F5872A529C998A34438C937DDE")
      ASN1ParsingException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.946 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "36C737148F28C925EEF61EEB10240E15")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1600491280 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1600491280 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_1600491280.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1600491280;
        
        
    }

    
}

