package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProviderDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.912 -0400", hash_original_method = "EB91B1D62AAE7F3701C2A2F893EEC27E", hash_generated_method = "D61E8ACB3BD9A2FFBF8DFCCE5147FF4B")
    public  ProviderDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.913 -0400", hash_original_method = "1B998FAE6F4B1663E51EF9B76543EA0A", hash_generated_method = "E5B188B68F9929B811241113E6A2D774")
    public  ProviderDoesNotExistException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.913 -0400", hash_original_method = "FCC82D2910C9FD9AF64C6B2313D46743", hash_generated_method = "71A24B489A6B25357F72FF74BB387085")
    public  ProviderDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

