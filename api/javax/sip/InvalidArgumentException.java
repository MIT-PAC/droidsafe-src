package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class InvalidArgumentException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.210 -0400", hash_original_method = "058727A85A3561BD87B89BB684E2068E", hash_generated_method = "4A6154754A702AA8F9C7A1F4710C43C1")
    public  InvalidArgumentException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.210 -0400", hash_original_method = "6CFB0BD92581CA0A67925F5045802025", hash_generated_method = "AF1F3E7CDF7F73C0B5C53D3C8080E36B")
    public  InvalidArgumentException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.210 -0400", hash_original_method = "36D7705F557972E94094B17807C973B6", hash_generated_method = "EF6BB5B50F41E6023B65018D132B1DF0")
    public  InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
}

