package javax.security.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Destroyable {

    
    void destroy() throws DestroyFailedException;

    
    boolean isDestroyed();

}
