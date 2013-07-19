package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class TransactionUnavailableException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.391 -0400", hash_original_method = "E1225E9A0C179C24A6F556EFDF84E711", hash_generated_method = "43E10BCACF034EAE177943DB519A76E0")
    public  TransactionUnavailableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.392 -0400", hash_original_method = "037265DD61866BF76BF55F595E642E2B", hash_generated_method = "D68069B79DA09A4434B8BF68EFC45F48")
    public  TransactionUnavailableException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.392 -0400", hash_original_method = "9A237A264B439534488FA55C4A599BD6", hash_generated_method = "4A9CAF7F1B751280633AF7F37AADEB1B")
    public  TransactionUnavailableException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

