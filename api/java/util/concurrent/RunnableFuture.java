package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface RunnableFuture<V> extends Runnable, Future<V> {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.EXEC)
    void run();
}
