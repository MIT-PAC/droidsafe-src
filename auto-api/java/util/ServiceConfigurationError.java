package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ServiceConfigurationError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.913 -0400", hash_original_method = "EBAE74DC80F9C6BC38A9630AD570AE77", hash_generated_method = "B25D0384CA532381692A4EAA5C51AD23")
    public  ServiceConfigurationError(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.913 -0400", hash_original_method = "29CC4F4897E024335846D9CA60D25833", hash_generated_method = "9C129F4EAB48AA508D73FE58F0C1122C")
    public  ServiceConfigurationError(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.913 -0400", hash_original_field = "723DA869693936CAFD445A5899E84FCF", hash_generated_field = "D00548B78989F717848473F1BA6889B7")

    private static final long serialVersionUID = 74132770414881L;
}

