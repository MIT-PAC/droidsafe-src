package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface RejectedExecutionHandler {

    
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
