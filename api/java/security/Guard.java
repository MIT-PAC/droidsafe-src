package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Guard {

    
    public void checkGuard(Object object) throws SecurityException;
}
