package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Debug {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.450 -0400", hash_original_method = "1047941695AF0866D2D5ED4C2A6971C3", hash_generated_method = "1047941695AF0866D2D5ED4C2A6971C3")
        public Debug ()
    {
    }


        public static void setStackLogger(StackLogger stackLogger) {
        Debug.stackLogger = stackLogger;
    }

    
        public static void println(String s) {
        if ((parserDebug || debug )&& stackLogger != null )
            stackLogger.logDebug(s + "\n");
    }

    
        public static void printStackTrace(Exception ex) {
        if ((parserDebug || debug ) && stackLogger != null) {
            stackLogger.logError("Stack Trace",ex);
        }
    }

    
        public static void logError(String message, Exception ex) {
        if ((parserDebug || debug) &&  stackLogger != null ) {
          stackLogger.logError(message,ex);
      }
    }

    
    public static boolean debug = false;
    public static boolean parserDebug = false;
    static StackLogger stackLogger;
}

