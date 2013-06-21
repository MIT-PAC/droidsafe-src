package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class VMStack {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.301 -0400", hash_original_method = "B578E03A50A9A42FA38BED0735EDE6FE", hash_generated_method = "B578E03A50A9A42FA38BED0735EDE6FE")
        public VMStack ()
    {
    }


        public static ClassLoader getCallingClassLoader() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static Class<?> getStackClass2() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static Class<?>[] getClasses(int maxDepth) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static StackTraceElement[] getThreadStackTrace(Thread t) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static int fillStackTraceElements(Thread t,
        StackTraceElement[] stackTraceElements) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

