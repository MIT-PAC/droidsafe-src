package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface RunnableFuture<V> extends Runnable, Future<V> {
    
    void run();
}
