package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProviderException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.139 -0400", hash_original_method = "4F6DF0DF8572865516F19A786749BA2D", hash_generated_method = "2AC577969C19328440ED86758D795C53")
    public  ProviderException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.147 -0400", hash_original_method = "C6FD128032A25223FCE8DF59B6440EFD", hash_generated_method = "AE2C6FE8FA1DD7754D6AAA9F0ABC68D7")
    public  ProviderException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.147 -0400", hash_original_method = "9D8D611DA847D087295A6CFF5F4EEF0C", hash_generated_method = "1738284FCF01A833C563BA201F1052F4")
    public  ProviderException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.147 -0400", hash_original_method = "39103B62643A614FF10A8AB7735F1560", hash_generated_method = "6E8F6DB5AA52A79F263745D983B01B81")
    public  ProviderException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.147 -0400", hash_original_field = "A48AFDB3DA30B5433BC74D5AEA0E833C", hash_generated_field = "169A2D24611678E75F16C50B90512447")

    private static long serialVersionUID = 5256023526693665674L;
}

