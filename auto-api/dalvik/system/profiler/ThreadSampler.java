package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public interface ThreadSampler {

    
    public void setDepth(int depth);

    
    public StackTraceElement[] getStackTrace(Thread thread);
}
