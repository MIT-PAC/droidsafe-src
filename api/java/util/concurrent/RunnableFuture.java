package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface RunnableFuture<V> extends Runnable, Future<V> {
    
    void run();
}
