package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface PrivilegedExceptionAction<T> {
    T run() throws Exception;
}
