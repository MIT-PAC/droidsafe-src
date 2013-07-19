package java.security;

// Droidsafe Imports

public interface PrivilegedExceptionAction<T> {
    T run() throws Exception;
}
