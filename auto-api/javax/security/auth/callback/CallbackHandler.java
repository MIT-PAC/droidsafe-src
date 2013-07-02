package javax.security.auth.callback;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public interface CallbackHandler {

    
    void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException;

}
