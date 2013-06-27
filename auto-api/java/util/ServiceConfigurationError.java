package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ServiceConfigurationError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.022 -0400", hash_original_method = "EBAE74DC80F9C6BC38A9630AD570AE77", hash_generated_method = "B25D0384CA532381692A4EAA5C51AD23")
    public  ServiceConfigurationError(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.023 -0400", hash_original_method = "29CC4F4897E024335846D9CA60D25833", hash_generated_method = "9C129F4EAB48AA508D73FE58F0C1122C")
    public  ServiceConfigurationError(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.023 -0400", hash_original_field = "723DA869693936CAFD445A5899E84FCF", hash_generated_field = "4DC6F2231FBC7AFE11440713511B2DA6")

    private static long serialVersionUID = 74132770414881L;
}

