package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.List;

public interface ExecutorService extends Executor {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void shutdown();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    List<Runnable> shutdownNow();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    boolean isShutdown();
    
    boolean isTerminated();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException;
    
    <T> Future<T> submit(Callable<T> task);
    
    <T> Future<T> submit(Runnable task, T result);
    
    Future<?> submit(Runnable task);

    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException;
    
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                  long timeout, TimeUnit unit)
        throws InterruptedException;
    
    <T> T invokeAny(Collection<? extends Callable<T>> tasks)
        throws InterruptedException, ExecutionException;
    
    <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                    long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
