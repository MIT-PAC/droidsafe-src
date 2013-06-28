package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

class PortableThreadSampler implements ThreadSampler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.099 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.099 -0400", hash_original_method = "4D56809BA46B0880BDFB6525AB14F55F", hash_generated_method = "4D56809BA46B0880BDFB6525AB14F55F")
    public PortableThreadSampler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.100 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "3A4056680CF8761630C703B1A5197ADD")
    @Override
    public void setDepth(int depth) {
        this.depth = depth;
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.101 -0400", hash_original_method = "E8C7A5DFD07B28248405DFC9E0C75853", hash_generated_method = "60EE944416D8FB17E41A29C32CF7A71B")
    @Override
    public StackTraceElement[] getStackTrace(Thread thread) {
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_1583791814 = null; //Variable for return #1
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_708248070 = null; //Variable for return #2
        StackTraceElement[] stackFrames = thread.getStackTrace();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1583791814 = null;
        } //End block
        {
            stackFrames = Arrays.copyOfRange(stackFrames, 0, depth);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_708248070 = stackFrames;
        addTaint(thread.getTaint());
        StackTraceElement[] varA7E53CE21691AB073D9660D615818899_1538588931; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1538588931 = varB4EAC82CA7396A68D541C85D26508E83_1583791814;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1538588931 = varB4EAC82CA7396A68D541C85D26508E83_708248070;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1538588931.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1538588931;
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

