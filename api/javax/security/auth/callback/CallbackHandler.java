package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public interface CallbackHandler {

    
    void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException;

}
