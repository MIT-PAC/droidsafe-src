package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Future<V> {

    
    boolean cancel(boolean mayInterruptIfRunning);

    
    boolean isCancelled();

    
    boolean isDone();

    
    V get() throws InterruptedException, ExecutionException;

    
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
