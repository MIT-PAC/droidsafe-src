package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class TransactionAlreadyExistsException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.304 -0400", hash_original_method = "6748172A8FDBE98EBDE794888E886227", hash_generated_method = "03AE0A4D0E3FD942DF397A578BE0B81F")
    public  TransactionAlreadyExistsException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.304 -0400", hash_original_method = "230B9A8FB8272D6B6901D384356BD5A2", hash_generated_method = "2F90F56936551D51BF335C744FFD9252")
    public  TransactionAlreadyExistsException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.304 -0400", hash_original_method = "9199B538C593B6B8FFCCFB817BC4F480", hash_generated_method = "418F660DF8E449CD78AC33A0687184B5")
    public  TransactionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
}

