package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class DalvikLogging {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.632 -0400", hash_original_method = "A5E4F7DD8D6CBC86B82114507B3451BF", hash_generated_method = "77A1B090F9E2BBA948F90A9B3C43AEC3")
    private  DalvikLogging() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
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

