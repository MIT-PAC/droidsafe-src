package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class TransportNotSupportedException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.397 -0400", hash_original_method = "A9536702FA2FD929BCAA03BE02DE378D", hash_generated_method = "E158EFA88D439F44ECE432CEE5044D3E")
    public  TransportNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.397 -0400", hash_original_method = "72633799E19427EF47046C691F2C9C95", hash_generated_method = "6B49829F6267E8EEEBF96FAAF00AF27A")
    public  TransportNotSupportedException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.397 -0400", hash_original_method = "F97CF6294699591851DD663A9DDDF701", hash_generated_method = "C0588B974C38A8AB14E6C80557E131AF")
    public  TransportNotSupportedException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

