package java.util.concurrent;

// Droidsafe Imports

public interface RunnableScheduledFuture<V> extends RunnableFuture<V>, ScheduledFuture<V> {

    
    boolean isPeriodic();
}
