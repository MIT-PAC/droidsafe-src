package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class Debug {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.578 -0500", hash_original_method = "45776951070E81888EE2163DB78828B0", hash_generated_method = "88AF64E4434A32C3C8046D7126992302")
    
public static void setStackLogger(StackLogger stackLogger) {
        Debug.stackLogger = stackLogger;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.581 -0500", hash_original_method = "1303CC9D384624F179F1AF8B3BF8EF11", hash_generated_method = "D662234221AFF09512A2FCE8D1CD5266")
    
public static void println(String s) {
        if ((parserDebug || debug )&& stackLogger != null )
            stackLogger.logDebug(s + "\n");
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.584 -0500", hash_original_method = "37F0B226FE5E9BA60C046A2F80E34DB5", hash_generated_method = "7E422133467543DEE0D7A953259A3432")
    
public static void printStackTrace(Exception ex) {
        if ((parserDebug || debug ) && stackLogger != null) {
            stackLogger.logError("Stack Trace",ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.587 -0500", hash_original_method = "3D0F04B05FED57F9989702383843073E", hash_generated_method = "92D819EB95E5B5564D9B03F5393E5799")
    
public static void logError(String message, Exception ex) {
      if ((parserDebug || debug) &&  stackLogger != null ) {
          stackLogger.logError(message,ex);
      }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.571 -0500", hash_original_field = "1D26EAE68CED0DB1FB96EFFC9C24F00B", hash_generated_field = "68DAC2AF18744984A1919AE3D9AD4F4A")


    public static  boolean debug = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.574 -0500", hash_original_field = "E4B01EC06B5F839A5CEBDD4FE20135C8", hash_generated_field = "C0A54A076B08484E8EE49E2E00817468")

    public static  boolean parserDebug = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:52.576 -0500", hash_original_field = "2D0C8423C59960E3E35FFD59E5DE02BE", hash_generated_field = "F7CF929DBAE178DEA793EA76808CB4B4")

    
    static StackLogger stackLogger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.061 -0400", hash_original_method = "D5DA96BAC7993F1698C6F83B8D04956A", hash_generated_method = "D5DA96BAC7993F1698C6F83B8D04956A")
    public Debug ()
    {
        //Synthesized constructor
    }
}

