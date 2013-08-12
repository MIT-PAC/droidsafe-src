package org.apache.http.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;




public class RedirectException extends ProtocolException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.382 -0400", hash_original_method = "8993A7EF0CD7BC2114A435E71DE5C46D", hash_generated_method = "BDFE7BE5C52476C470E3F4CFC35AC311")
    public  RedirectException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.383 -0400", hash_original_method = "BF4F2A0BBB2FD109EB1FCB43C3342F5C", hash_generated_method = "9E6FC1C9FAF8560098C43D6CB2899993")
    public  RedirectException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.383 -0400", hash_original_method = "4935B20DF448DBE22DB0549C57AECB3F", hash_generated_method = "777773B643C314F005901D1BFC9A2C12")
    public  RedirectException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.383 -0400", hash_original_field = "B7E1F8BD179AB4F400C3576EB0B4EA6F", hash_generated_field = "FAC8F8BB112A11F76DAF47499FAE9BA5")

    private static final long serialVersionUID = 4418824536372559326L;
}

