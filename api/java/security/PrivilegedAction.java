package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface PrivilegedAction<T> {
    public T run();
}
