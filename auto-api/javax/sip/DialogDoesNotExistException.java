package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DialogDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.463 -0400", hash_original_method = "9202A0FE59991A3B0A837B4E7082EB36", hash_generated_method = "1B44DD3DAF591CD5FC0BE6F2586414D3")
    public  DialogDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.463 -0400", hash_original_method = "92D6A3CD46517681F25A7E8C2DA97A21", hash_generated_method = "4E5A89A2B1BB6CDEAF1AB0111246325E")
    public  DialogDoesNotExistException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.463 -0400", hash_original_method = "3EDA84A1781F815A2C18879AE2F847E8", hash_generated_method = "9D14B301FB66741446E5C51733F0A574")
    public  DialogDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

