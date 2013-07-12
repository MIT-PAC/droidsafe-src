package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ServiceConfigurationError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.402 -0400", hash_original_method = "EBAE74DC80F9C6BC38A9630AD570AE77", hash_generated_method = "B25D0384CA532381692A4EAA5C51AD23")
    public  ServiceConfigurationError(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.403 -0400", hash_original_method = "29CC4F4897E024335846D9CA60D25833", hash_generated_method = "5AB14D72754D1E576B72A0479990AA22")
    public  ServiceConfigurationError(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.403 -0400", hash_original_field = "723DA869693936CAFD445A5899E84FCF", hash_generated_field = "D00548B78989F717848473F1BA6889B7")

    private static final long serialVersionUID = 74132770414881L;
}

