package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface PrivilegedExceptionAction<T> {
    T run() throws Exception;
}
