package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

class PortableThreadSampler implements ThreadSampler {
    private int depth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.411 -0400", hash_original_method = "84D450C63B65A2E98E32183DE2F02344", hash_generated_method = "84D450C63B65A2E98E32183DE2F02344")
        public PortableThreadSampler ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.411 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "799C8F6565E2410709EBC0F987921C8D")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDepth(int depth) {
        dsTaint.addTaint(depth);
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.411 -0400", hash_original_method = "E8C7A5DFD07B28248405DFC9E0C75853", hash_generated_method = "284281051F7AB0B4529E8182283E0D81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StackTraceElement[] getStackTrace(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        StackTraceElement[] stackFrames;
        stackFrames = thread.getStackTrace();
        {
            stackFrames = Arrays.copyOfRange(stackFrames, 0, depth);
        } //End block
        return (StackTraceElement[])dsTaint.getTaint();
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

