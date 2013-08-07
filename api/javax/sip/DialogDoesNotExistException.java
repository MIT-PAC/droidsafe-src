package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;


public class DialogDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.225 -0400", hash_original_method = "9202A0FE59991A3B0A837B4E7082EB36", hash_generated_method = "1B44DD3DAF591CD5FC0BE6F2586414D3")
    public  DialogDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.226 -0400", hash_original_method = "92D6A3CD46517681F25A7E8C2DA97A21", hash_generated_method = "4E5A89A2B1BB6CDEAF1AB0111246325E")
    public  DialogDoesNotExistException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.226 -0400", hash_original_method = "3EDA84A1781F815A2C18879AE2F847E8", hash_generated_method = "C94681786C45942412CCE73A258ACF72")
    public  DialogDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

