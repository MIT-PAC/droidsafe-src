package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class TransactionUnavailableException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.134 -0400", hash_original_method = "E1225E9A0C179C24A6F556EFDF84E711", hash_generated_method = "43E10BCACF034EAE177943DB519A76E0")
    public  TransactionUnavailableException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.135 -0400", hash_original_method = "037265DD61866BF76BF55F595E642E2B", hash_generated_method = "D68069B79DA09A4434B8BF68EFC45F48")
    public  TransactionUnavailableException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.135 -0400", hash_original_method = "9A237A264B439534488FA55C4A599BD6", hash_generated_method = "51FFCA0470E1ACA32BBD92A829155031")
    public  TransactionUnavailableException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        
    }

    
}

