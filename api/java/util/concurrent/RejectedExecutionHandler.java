package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface RejectedExecutionHandler {

    
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
