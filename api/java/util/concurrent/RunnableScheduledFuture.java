package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface RunnableScheduledFuture<V> extends RunnableFuture<V>, ScheduledFuture<V> {

    
    boolean isPeriodic();
}
