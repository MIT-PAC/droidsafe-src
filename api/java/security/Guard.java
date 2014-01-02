package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Guard {

    
    public void checkGuard(Object object) throws SecurityException;
}
