package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface RejectedExecutionHandler {

    
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
