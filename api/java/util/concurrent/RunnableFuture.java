package java.util.concurrent;

// Droidsafe Imports

public interface RunnableFuture<V> extends Runnable, Future<V> {
    
    void run();
}
