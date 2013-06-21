package javax.security.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Destroyable {

    
    void destroy() throws DestroyFailedException;

    
    boolean isDestroyed();

}
