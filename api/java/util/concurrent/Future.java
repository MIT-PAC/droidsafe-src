package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Future<V> {

    
    boolean cancel(boolean mayInterruptIfRunning);

    
    boolean isCancelled();

    
    boolean isDone();

    
    V get() throws InterruptedException, ExecutionException;

    
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
