package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Guard {

    
    public void checkGuard(Object object) throws SecurityException;
}
