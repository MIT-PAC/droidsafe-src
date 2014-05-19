package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.List;

public interface ExecutorService extends Executor {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.SHARED_PREFERENCES)
    void shutdown();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.THREADING)
    List<Runnable> shutdownNow();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    boolean isShutdown();
    
    boolean isTerminated();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException;
    
    @DSSpec(DSCat.THREADING)
    <T> Future<T> submit(Callable<T> task);
    
    @DSSpec(DSCat.THREADING)
    <T> Future<T> submit(Runnable task, T result);
    
    @DSSpec(DSCat.THREADING)
    Future<?> submit(Runnable task);

    @DSSpec(DSCat.THREADING)
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException;
    
    @DSSpec(DSCat.THREADING)
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                  long timeout, TimeUnit unit)
        throws InterruptedException;
    
    @DSSpec(DSCat.THREADING)
    <T> T invokeAny(Collection<? extends Callable<T>> tasks)
        throws InterruptedException, ExecutionException;
    
    @DSSpec(DSCat.THREADING)
    <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                    long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}
