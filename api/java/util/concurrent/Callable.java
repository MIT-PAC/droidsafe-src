package java.util.concurrent;

// Droidsafe Imports

public interface Callable<V> {
    
    V call() throws Exception;
}
