package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SipException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.754 -0400", hash_original_method = "2844FA66AE6BF3430E2D663113A5D509", hash_generated_method = "55BA8DDE2D4649EC43875D789C2CA939")
    public  SipException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.754 -0400", hash_original_method = "9795DB733321F498B81268F6E7181236", hash_generated_method = "E42819ACCDC57D85ECA3E0EEEEC55716")
    public  SipException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.773 -0400", hash_original_method = "0929D315124628FA3E72B5EC08F3DEFE", hash_generated_method = "06B8DFC3599DE0157F74D145C680C8D3")
    public  SipException(String message, Throwable cause) {
        super(message, ((cause instanceof javax.sip.SipException)
                && (cause.getCause() != null))
                ? cause.getCause()
                : cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

