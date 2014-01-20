package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class DalvikLogging {

    /**
     * Returns the short logger tag (up to 23 chars) for the given logger name.
     * Traditionally loggers are named by fully-qualified Java classes; this
     * method attempts to return a concise identifying part of such names.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.150 -0500", hash_original_method = "0985A29138FED57B817275CA373E16BB", hash_generated_method = "C8AE084F0A43B82FC7C2DB9FAC19AA61")
    
public static String loggerNameToTag(String loggerName) {
        // Anonymous logger.
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
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.148 -0500", hash_original_method = "A5E4F7DD8D6CBC86B82114507B3451BF", hash_generated_method = "E1DD2A0114CBCFB6FC98080C422CA57D")
    
private DalvikLogging() {}
    
}

