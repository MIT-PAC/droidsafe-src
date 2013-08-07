package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;


public class ProviderDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.280 -0400", hash_original_method = "EB91B1D62AAE7F3701C2A2F893EEC27E", hash_generated_method = "D61E8ACB3BD9A2FFBF8DFCCE5147FF4B")
    public  ProviderDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.281 -0400", hash_original_method = "1B998FAE6F4B1663E51EF9B76543EA0A", hash_generated_method = "E5B188B68F9929B811241113E6A2D774")
    public  ProviderDoesNotExistException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.281 -0400", hash_original_method = "FCC82D2910C9FD9AF64C6B2313D46743", hash_generated_method = "A0F39E92129418E2BBC251580907A90F")
    public  ProviderDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

