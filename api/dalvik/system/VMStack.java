package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public final class VMStack {
    
    public static ClassLoader getCallingClassLoader() {
    	return (ClassLoader) new Object();
    }
    
    public static Class<?> getStackClass2() {
    	return Object.class;
    }
    
    public static Class<?>[] getClasses(int maxDepth) {
    	return new Class[]{Object.class};
    }
    
    public static StackTraceElement[] getThreadStackTrace(Thread t) {
    	return new StackTraceElement[0];
    }
    
    public static int fillStackTraceElements(Thread t,
        StackTraceElement[] stackTraceElements) {
        return t.getTaintInt() + stackTraceElements.getTaintInt() + stackTraceElements[0].getTaintInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.859 -0400", hash_original_method = "48F2A5F5D0FB61BCDEE57F0E62DA7F3A", hash_generated_method = "48F2A5F5D0FB61BCDEE57F0E62DA7F3A")
    public VMStack ()
    {
        //Synthesized constructor
    }
    
}

