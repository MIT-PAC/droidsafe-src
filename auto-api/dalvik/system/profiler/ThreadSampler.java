package dalvik.system.profiler;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public interface ThreadSampler {

    
    public void setDepth(int depth);

    
    public StackTraceElement[] getStackTrace(Thread thread);
}
