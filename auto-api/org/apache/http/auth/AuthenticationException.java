package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.ProtocolException;

public class AuthenticationException extends ProtocolException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.773 -0400", hash_original_method = "013088ABC431C6F3F4CF96BA31947D05", hash_generated_method = "3148FB1AEB7DC11678194C4759D9EA95")
    public  AuthenticationException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.774 -0400", hash_original_method = "42EE7D04E120D0BA05395B903F4DA9F5", hash_generated_method = "30CBF0C1BC505746267B43CC6B065512")
    public  AuthenticationException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.775 -0400", hash_original_method = "E1E933639B5521F15D3C671D186FDEA6", hash_generated_method = "01F7C99A699CAC66FA9493496094F503")
    public  AuthenticationException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.775 -0400", hash_original_field = "D53B058C916C125FBF6E422657642B85", hash_generated_field = "7D7320A5100A53E9823D08951F9BDCB8")

    private static long serialVersionUID = -6794031905674764776L;
}

