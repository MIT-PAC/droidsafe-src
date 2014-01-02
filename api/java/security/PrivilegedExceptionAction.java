package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface PrivilegedExceptionAction<T> {
    T run() throws Exception;
}
