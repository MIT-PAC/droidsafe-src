package org.bouncycastle.util.io.pem;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class PemGenerationException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.347 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.348 -0400", hash_original_method = "33CBECFB76FE1092AA2D14F5073D46BE", hash_generated_method = "CF4210F5D6BBBE8CB3C01198F9AE051A")
    public  PemGenerationException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
        addTaint(message.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.348 -0400", hash_original_method = "80C2BF6F9B17521430AAD5FD6B82B847", hash_generated_method = "5993872145D4D76F61D45E0082C701F8")
    public  PemGenerationException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.349 -0400", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "6F135F446635FC84C27E18730044504F")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_208533650 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_208533650 = cause;
        varB4EAC82CA7396A68D541C85D26508E83_208533650.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_208533650;
        
        
    }

    
}

