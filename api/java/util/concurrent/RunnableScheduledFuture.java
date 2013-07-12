package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface RunnableScheduledFuture<V> extends RunnableFuture<V>, ScheduledFuture<V> {

    
    boolean isPeriodic();
}
