package javax.security.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Destroyable {

    
    void destroy() throws DestroyFailedException;

    
    boolean isDestroyed();

}
