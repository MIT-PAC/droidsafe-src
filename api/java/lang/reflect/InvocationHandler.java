package java.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface InvocationHandler {

    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
