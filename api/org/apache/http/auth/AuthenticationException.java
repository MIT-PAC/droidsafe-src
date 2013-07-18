package org.apache.http.auth;

// Droidsafe Imports
import org.apache.http.ProtocolException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class AuthenticationException extends ProtocolException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.322 -0400", hash_original_method = "013088ABC431C6F3F4CF96BA31947D05", hash_generated_method = "3148FB1AEB7DC11678194C4759D9EA95")
    public  AuthenticationException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.323 -0400", hash_original_method = "42EE7D04E120D0BA05395B903F4DA9F5", hash_generated_method = "30CBF0C1BC505746267B43CC6B065512")
    public  AuthenticationException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.323 -0400", hash_original_method = "E1E933639B5521F15D3C671D186FDEA6", hash_generated_method = "88B36661093732212DFDD72104CB1CA7")
    public  AuthenticationException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.323 -0400", hash_original_field = "D53B058C916C125FBF6E422657642B85", hash_generated_field = "3DEC0A489DB670A71940A7B9CE08226B")

    private static final long serialVersionUID = -6794031905674764776L;
}

