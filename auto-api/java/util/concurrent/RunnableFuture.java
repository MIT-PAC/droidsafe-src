package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface RunnableFuture<V> extends Runnable, Future<V> {
    
    void run();
}
