package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;


public class ObjectInUseException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.271 -0400", hash_original_method = "1506D26AE793C20A85DE50298F844249", hash_generated_method = "8E06DD88D90B8E6C242DDAF66DBF9939")
    public  ObjectInUseException() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.271 -0400", hash_original_method = "DD9CAB8B2E3E5148E8AE5B5B0A2DE7DC", hash_generated_method = "1A4FB7D54C92ED629FC4D0715DEFC092")
    public  ObjectInUseException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.271 -0400", hash_original_method = "A64ABB3B61ED7345FBF78ED9BA9ABC4F", hash_generated_method = "F12CB71AB2C914C75ACC2276D28E10DA")
    public  ObjectInUseException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

