package dalvik.system.profiler;

// Droidsafe Imports

public interface ThreadSampler {

    
    public void setDepth(int depth);

    
    public StackTraceElement[] getStackTrace(Thread thread);
}
