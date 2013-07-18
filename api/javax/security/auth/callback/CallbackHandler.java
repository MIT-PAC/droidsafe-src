package javax.security.auth.callback;

// Droidsafe Imports
import java.io.IOException;

public interface CallbackHandler {

    
    void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException;

}
