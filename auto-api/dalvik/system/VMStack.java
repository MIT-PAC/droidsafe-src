package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class VMStack {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.820 -0400", hash_original_method = "48F2A5F5D0FB61BCDEE57F0E62DA7F3A", hash_generated_method = "48F2A5F5D0FB61BCDEE57F0E62DA7F3A")
    public VMStack ()
    {
        //Synthesized constructor
    }


    public static ClassLoader getCallingClassLoader() {
                //DSFIXME:  This shouldn't happen!
    	return (ClassLoader) new Object();
    }

    
    public static Class<?> getStackClass2() {
                //DSFIXME:  This shouldn't happen!
    	return Object.class;
    }

    
    public static Class<?>[] getClasses(int maxDepth) {
                //DSFIXME:  This shouldn't happen!
    	return new Class[]{Object.class};
    }

    
    public static StackTraceElement[] getThreadStackTrace(Thread t) {
                //DSFIXME:  This shouldn't happen!
    	return new StackTraceElement[0];
    }

    
    public static int fillStackTraceElements(Thread t,
        StackTraceElement[] stackTraceElements) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892665896 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892665896;
    }

    
}

