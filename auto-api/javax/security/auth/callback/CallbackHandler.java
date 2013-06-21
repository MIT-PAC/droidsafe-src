package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public interface CallbackHandler {

    
    void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException;

}
