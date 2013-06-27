package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

class PortableThreadSampler implements ThreadSampler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.294 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.295 -0400", hash_original_method = "4D56809BA46B0880BDFB6525AB14F55F", hash_generated_method = "4D56809BA46B0880BDFB6525AB14F55F")
    public PortableThreadSampler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.295 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "3A4056680CF8761630C703B1A5197ADD")
    @Override
    public void setDepth(int depth) {
        this.depth = depth;
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.296 -0400", hash_original_method = "E8C7A5DFD07B28248405DFC9E0C75853", hash_generated_method = "1385AF7E346BBA3A9A815B79687B2E9F")
    @Override
    public StackTraceElement[] getStackTrace(Thread thread) {
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_2113216959 = null; //Variable for return #1
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_1191389441 = null; //Variable for return #2
        StackTraceElement[] stackFrames;
        stackFrames = thread.getStackTrace();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2113216959 = null;
        } //End block
        {
            stackFrames = Arrays.copyOfRange(stackFrames, 0, depth);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1191389441 = stackFrames;
        addTaint(thread.getTaint());
        StackTraceElement[] varA7E53CE21691AB073D9660D615818899_624251054; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_624251054 = varB4EAC82CA7396A68D541C85D26508E83_2113216959;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_624251054 = varB4EAC82CA7396A68D541C85D26508E83_1191389441;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_624251054.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_624251054;
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

