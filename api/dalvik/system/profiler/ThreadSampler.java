package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public interface ThreadSampler {

    
    public void setDepth(int depth);

    
    public StackTraceElement[] getStackTrace(Thread thread);
}
