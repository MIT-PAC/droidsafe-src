package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Guard {

    
    public void checkGuard(Object object) throws SecurityException;
}
