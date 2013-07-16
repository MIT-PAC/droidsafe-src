package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

class PortableThreadSampler implements ThreadSampler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.997 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.997 -0400", hash_original_method = "4D56809BA46B0880BDFB6525AB14F55F", hash_generated_method = "4D56809BA46B0880BDFB6525AB14F55F")
    public PortableThreadSampler ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.998 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "3A4056680CF8761630C703B1A5197ADD")
    @Override
    public void setDepth(int depth) {
        this.depth = depth;
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.998 -0400", hash_original_method = "E8C7A5DFD07B28248405DFC9E0C75853", hash_generated_method = "C95709B92A40B1CED59FC2DA07C19009")
    @Override
    public StackTraceElement[] getStackTrace(Thread thread) {
        addTaint(thread.getTaint());
        StackTraceElement[] stackFrames = thread.getStackTrace();
    if(stackFrames.length == 0)        
        {
StackTraceElement[] var540C13E9E156B687226421B24F2DF178_33737793 =             null;
            var540C13E9E156B687226421B24F2DF178_33737793.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_33737793;
        } //End block
    if(stackFrames.length > depth)        
        {
            stackFrames = Arrays.copyOfRange(stackFrames, 0, depth);
        } //End block
StackTraceElement[] varE98473DA09074D13245C9DB218456746_941114788 =         stackFrames;
        varE98473DA09074D13245C9DB218456746_941114788.addTaint(taint);
        return varE98473DA09074D13245C9DB218456746_941114788;
        // ---------- Original Method ----------
        //StackTraceElement[] stackFrames = thread.getStackTrace();
        //if (stackFrames.length == 0) {
            //return null;
        //}
        //if (stackFrames.length > depth) {
            //stackFrames = Arrays.copyOfRange(stackFrames, 0, depth);
        //}
        //return stackFrames;
    }

    
}

