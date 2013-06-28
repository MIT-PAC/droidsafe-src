package org.apache.http.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.ProtocolException;

public class RedirectException extends ProtocolException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.724 -0400", hash_original_method = "8993A7EF0CD7BC2114A435E71DE5C46D", hash_generated_method = "BDFE7BE5C52476C470E3F4CFC35AC311")
    public  RedirectException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.724 -0400", hash_original_method = "BF4F2A0BBB2FD109EB1FCB43C3342F5C", hash_generated_method = "9E6FC1C9FAF8560098C43D6CB2899993")
    public  RedirectException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.724 -0400", hash_original_method = "4935B20DF448DBE22DB0549C57AECB3F", hash_generated_method = "923B9E1FD2C21D1D545B1C23333933E9")
    public  RedirectException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.724 -0400", hash_original_field = "B7E1F8BD179AB4F400C3576EB0B4EA6F", hash_generated_field = "FAC8F8BB112A11F76DAF47499FAE9BA5")

    private static final long serialVersionUID = 4418824536372559326L;
}

