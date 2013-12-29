package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface InvocationHandler {

    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
