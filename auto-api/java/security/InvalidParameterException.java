package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidParameterException extends IllegalArgumentException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.957 -0400", hash_original_method = "A4FEFBD78FD62EF00C6F1D79EDBD5401", hash_generated_method = "5C07804D1F3ED78B3325D5ACF24549E2")
    public  InvalidParameterException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.957 -0400", hash_original_method = "9CA8CE9AC39DC45F96DE6473AB9F71B5", hash_generated_method = "A364D8E4484CEE6C11C8D78768D38217")
    public  InvalidParameterException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.957 -0400", hash_original_field = "FFD2081AF7C75B29A7D796D7F2503C27", hash_generated_field = "2269A15707DA53F9E2EE3E67674380DB")

    private static long serialVersionUID = -857968536935667808L;
}

