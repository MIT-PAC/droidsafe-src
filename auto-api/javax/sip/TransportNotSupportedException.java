package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransportNotSupportedException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.031 -0400", hash_original_method = "A9536702FA2FD929BCAA03BE02DE378D", hash_generated_method = "E158EFA88D439F44ECE432CEE5044D3E")
    public  TransportNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.031 -0400", hash_original_method = "72633799E19427EF47046C691F2C9C95", hash_generated_method = "6B49829F6267E8EEEBF96FAAF00AF27A")
    public  TransportNotSupportedException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.031 -0400", hash_original_method = "F97CF6294699591851DD663A9DDDF701", hash_generated_method = "EB0DE5EB98253BF02E929E8FD922C636")
    public  TransportNotSupportedException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

