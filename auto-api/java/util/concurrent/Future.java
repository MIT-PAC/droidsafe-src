package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Future<V> {

    
    boolean cancel(boolean mayInterruptIfRunning);

    
    boolean isCancelled();

    
    boolean isDone();

    
    V get() throws InterruptedException, ExecutionException;

    
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
