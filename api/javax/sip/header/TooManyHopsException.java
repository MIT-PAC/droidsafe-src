package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class TooManyHopsException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.530 -0400", hash_original_method = "7059525C7D643548AACC26A1B7FECDC6", hash_generated_method = "AF59B1FD7F0919C215A47EAD9FDD1B59")
    public  TooManyHopsException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.530 -0400", hash_original_method = "10941AD8E9E3A8951C3E1FF56EF96A49", hash_generated_method = "4AE550554BDAF63EA77A7DAD0298DFE4")
    public  TooManyHopsException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.530 -0400", hash_original_method = "3567ED48A659002D0FAAA891FC5B218E", hash_generated_method = "3ED4A5020568BB6BF6F549D0453D4241")
    public  TooManyHopsException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
}

