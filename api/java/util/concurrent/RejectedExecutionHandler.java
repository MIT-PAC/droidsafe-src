package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface RejectedExecutionHandler {

    
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
