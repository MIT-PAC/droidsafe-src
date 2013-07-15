package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface PrivilegedExceptionAction<T> {
    T run() throws Exception;
}
