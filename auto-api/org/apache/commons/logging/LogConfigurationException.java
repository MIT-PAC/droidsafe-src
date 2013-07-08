package org.apache.commons.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class LogConfigurationException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.863 -0400", hash_original_field = "42192DD9A02C9A36EB3E8BCA81DB33FC", hash_generated_field = "79DAA8AEAC199268F25EDA892CFE191F")

    protected Throwable cause = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.863 -0400", hash_original_method = "5BD29D5C4388EC618AF76FB6968F33B3", hash_generated_method = "7063A356E6027EED37F9AC630853EE07")
    public  LogConfigurationException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.863 -0400", hash_original_method = "DDAD033C1D6A94945D0EFE9FFDFBD321", hash_generated_method = "377CDF98092075BAD618B64B156E2C3C")
    public  LogConfigurationException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.864 -0400", hash_original_method = "4454085F5358E0B8D9507639FB30951F", hash_generated_method = "CA0B38F218551F5BF8A9A608B397A063")
    public  LogConfigurationException(Throwable cause) {
        this((cause == null) ? null : cause.toString(), cause);
        addTaint(cause.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.864 -0400", hash_original_method = "451E311949AEF6CA521A34CAA7EB210C", hash_generated_method = "176AD1C8BA4E7F2FDEEC669E2BE9AF62")
    public  LogConfigurationException(String message, Throwable cause) {
        super(message + " (Caused by " + cause + ")");
        this.cause = cause;
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.865 -0400", hash_original_method = "9EB82C3F9FB6AE0D2962237AF0B1061E", hash_generated_method = "03B169FAE44B9547F4A928B0CE185798")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_2100928172 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2100928172 = (this.cause);
        varB4EAC82CA7396A68D541C85D26508E83_2100928172.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2100928172;
        
        
    }

    
}

