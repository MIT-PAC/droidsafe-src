package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ThreadSampler {

    
    public void setDepth(int depth);

    
    public StackTraceElement[] getStackTrace(Thread thread);
}
