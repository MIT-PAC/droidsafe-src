package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface PrivilegedAction<T> {
    public T run();
}
