package org.apache.http.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.ProtocolException;

public class AuthenticationException extends ProtocolException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.638 -0400", hash_original_method = "013088ABC431C6F3F4CF96BA31947D05", hash_generated_method = "3148FB1AEB7DC11678194C4759D9EA95")
    public  AuthenticationException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.639 -0400", hash_original_method = "42EE7D04E120D0BA05395B903F4DA9F5", hash_generated_method = "30CBF0C1BC505746267B43CC6B065512")
    public  AuthenticationException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.640 -0400", hash_original_method = "E1E933639B5521F15D3C671D186FDEA6", hash_generated_method = "01F7C99A699CAC66FA9493496094F503")
    public  AuthenticationException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.640 -0400", hash_original_field = "D53B058C916C125FBF6E422657642B85", hash_generated_field = "3DEC0A489DB670A71940A7B9CE08226B")

    private static final long serialVersionUID = -6794031905674764776L;
}

