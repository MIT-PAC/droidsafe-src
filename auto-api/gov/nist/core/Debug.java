package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Debug {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.169 -0400", hash_original_method = "D5DA96BAC7993F1698C6F83B8D04956A", hash_generated_method = "D5DA96BAC7993F1698C6F83B8D04956A")
    public Debug ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static void setStackLogger(StackLogger stackLogger) {
        Debug.stackLogger = stackLogger;
    }

    
    @DSModeled(DSC.SAFE)
    public static void println(String s) {
        if ((parserDebug || debug )&& stackLogger != null )
            stackLogger.logDebug(s + "\n");
    }

    
    @DSModeled(DSC.SAFE)
    public static void printStackTrace(Exception ex) {
        if ((parserDebug || debug ) && stackLogger != null) {
            stackLogger.logError("Stack Trace",ex);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void logError(String message, Exception ex) {
        if ((parserDebug || debug) &&  stackLogger != null ) {
          stackLogger.logError(message,ex);
      }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.171 -0400", hash_original_field = "3E160F8191A128BF71278081784675C8", hash_generated_field = "68DAC2AF18744984A1919AE3D9AD4F4A")

    public static boolean debug = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.171 -0400", hash_original_field = "764B99F79DADB0649045C3C812265016", hash_generated_field = "C0A54A076B08484E8EE49E2E00817468")

    public static boolean parserDebug = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.171 -0400", hash_original_field = "E36C03BD76A3345DFD7C16B0A9186E53", hash_generated_field = "F7CF929DBAE178DEA793EA76808CB4B4")

    static StackLogger stackLogger;
}

