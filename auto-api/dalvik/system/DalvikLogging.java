package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class DalvikLogging {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.324 -0400", hash_original_method = "A5E4F7DD8D6CBC86B82114507B3451BF", hash_generated_method = "4C9CD9297067258B2F7F03468FC10AC0")
    @DSModeled(DSC.SAFE)
    private DalvikLogging() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.324 -0400", hash_original_method = "0985A29138FED57B817275CA373E16BB", hash_generated_method = "ACAE0402AE948995348B0BDFB51E9245")
    public static String loggerNameToTag(String loggerName) {
        if (loggerName == null) {
            return "null";
        }
        int length = loggerName.length();
        if (length <= 23) {
            return loggerName;
        }
        int lastPeriod = loggerName.lastIndexOf(".");
        return length - (lastPeriod + 1) <= 23
                ? loggerName.substring(lastPeriod + 1)
                : loggerName.substring(loggerName.length() - 23);
    }

    
}


