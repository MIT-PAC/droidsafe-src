package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ObjectInUseException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.030 -0400", hash_original_method = "1506D26AE793C20A85DE50298F844249", hash_generated_method = "8E06DD88D90B8E6C242DDAF66DBF9939")
    public  ObjectInUseException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.030 -0400", hash_original_method = "DD9CAB8B2E3E5148E8AE5B5B0A2DE7DC", hash_generated_method = "1A4FB7D54C92ED629FC4D0715DEFC092")
    public  ObjectInUseException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.030 -0400", hash_original_method = "A64ABB3B61ED7345FBF78ED9BA9ABC4F", hash_generated_method = "D01EDDF3AC645474708FD1384CA57BF3")
    public  ObjectInUseException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

