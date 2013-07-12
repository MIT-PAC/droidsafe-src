package org.apache.commons.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class LogConfigurationException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.906 -0400", hash_original_field = "42192DD9A02C9A36EB3E8BCA81DB33FC", hash_generated_field = "79DAA8AEAC199268F25EDA892CFE191F")

    protected Throwable cause = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.906 -0400", hash_original_method = "5BD29D5C4388EC618AF76FB6968F33B3", hash_generated_method = "7063A356E6027EED37F9AC630853EE07")
    public  LogConfigurationException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.907 -0400", hash_original_method = "DDAD033C1D6A94945D0EFE9FFDFBD321", hash_generated_method = "377CDF98092075BAD618B64B156E2C3C")
    public  LogConfigurationException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.907 -0400", hash_original_method = "4454085F5358E0B8D9507639FB30951F", hash_generated_method = "CA0B38F218551F5BF8A9A608B397A063")
    public  LogConfigurationException(Throwable cause) {
        this((cause == null) ? null : cause.toString(), cause);
        addTaint(cause.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.907 -0400", hash_original_method = "451E311949AEF6CA521A34CAA7EB210C", hash_generated_method = "AFF5F38333BD12959F3939F2AC1F49E9")
    public  LogConfigurationException(String message, Throwable cause) {
        super(message + " (Caused by " + cause + ")");
        addTaint(message.getTaint());
        this.cause = cause;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.908 -0400", hash_original_method = "9EB82C3F9FB6AE0D2962237AF0B1061E", hash_generated_method = "F68B799BEB9A652B14BFC3DA2C1E479C")
    public Throwable getCause() {
Throwable var2ABCC090853C179FD2BC09D1D39B19A8_1858326144 =         (this.cause);
        var2ABCC090853C179FD2BC09D1D39B19A8_1858326144.addTaint(taint);
        return var2ABCC090853C179FD2BC09D1D39B19A8_1858326144;
        
        
    }

    
}

