package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Callable<V> {
    
    V call() throws Exception;
}
