package javax.security.auth;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Destroyable {

    
    void destroy() throws DestroyFailedException;

    
    boolean isDestroyed();

}
