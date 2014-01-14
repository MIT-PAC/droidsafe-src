package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

class PortableThreadSampler implements ThreadSampler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.348 -0500", hash_original_field = "C1588B2CF4C1B54961548959E16213DF", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.999 -0400", hash_original_method = "4D56809BA46B0880BDFB6525AB14F55F", hash_generated_method = "4D56809BA46B0880BDFB6525AB14F55F")
    public PortableThreadSampler ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.350 -0500", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "703440AD348D072130AC21EFD56BAB6A")
    
@Override public void setDepth(int depth) {
        this.depth = depth;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.353 -0500", hash_original_method = "E8C7A5DFD07B28248405DFC9E0C75853", hash_generated_method = "EE73165FFF9E91AF146444B307784C44")
    
@Override public StackTraceElement[] getStackTrace(Thread thread) {
        StackTraceElement[] stackFrames = thread.getStackTrace();
        if (stackFrames.length == 0) {
            return null;
        }
        if (stackFrames.length > depth) {
            stackFrames = Arrays.copyOfRange(stackFrames, 0, depth);
        }
        return stackFrames;
    }
    
}

