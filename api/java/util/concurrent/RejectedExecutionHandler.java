package java.util.concurrent;

// Droidsafe Imports

public interface RejectedExecutionHandler {

    
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
