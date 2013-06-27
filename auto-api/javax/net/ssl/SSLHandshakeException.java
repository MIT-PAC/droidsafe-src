package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLHandshakeException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.279 -0400", hash_original_method = "82B36E212F934FE090A9654C18E5A390", hash_generated_method = "86E9F925F24EF66E8D14EE055E3C99F9")
    public  SSLHandshakeException(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.279 -0400", hash_original_method = "6E4EDFE9C902AE43BD6AF73325E7CB73", hash_generated_method = "9E854348974BED872AA7C89159962F7C")
    public  SSLHandshakeException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.280 -0400", hash_original_method = "7F0A583E3C5916ED2C2C7E0A6DE82F31", hash_generated_method = "DE46FBEEE9471091620265510C89E912")
    public  SSLHandshakeException(String reason, Throwable cause) {
        super(reason, cause);
        addTaint(reason.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.280 -0400", hash_original_field = "34CF5929FA9094A1E7F5D07A29A845A9", hash_generated_field = "7F4E73683E4DF2678A7A5CBD06B3C6B9")

    private static long serialVersionUID = -5045881315018326890L;
}

