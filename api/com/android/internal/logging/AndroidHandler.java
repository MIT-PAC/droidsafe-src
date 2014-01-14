package com.android.internal.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import android.util.Log;
import dalvik.system.DalvikLogHandler;
import dalvik.system.DalvikLogging;

import droidsafe.runtime.DroidSafeAndroidRuntime;

public class AndroidHandler extends Handler implements DalvikLogHandler {

    /**
     * Converts a {@link java.util.logging.Logger} logging level into an Android one.
     *
     * @param level The {@link java.util.logging.Logger} logging level.
     *
     * @return The resulting Android logging level.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.853 -0500", hash_original_method = "3F92BD817EEC109FB3EFF14A3BE3BBE9", hash_generated_method = "35B5BBAE71B726DCD5E0BB70F044795B")
    
static int getAndroidLevel(Level level) {
        int value = level.intValue();
        if (value >= 1000) { // SEVERE
            return Log.ERROR;
        } else if (value >= 900) { // WARNING
            return Log.WARN;
        } else if (value >= 800) { // INFO
            return Log.INFO;
        } else {
            return Log.DEBUG;
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.231 -0400", hash_original_field = "05CB8D5FA80AAAD88471EF57C0EC546F", hash_generated_field = "006C8788F0F47E8A210E001196024E69")

    private static final Formatter THE_FORMATTER = new Formatter() {
        
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.231 -0400", hash_original_method = "5552BF51EFD27F1F4C5C7AE17D37E3F1", hash_generated_method = "F7BE88C6E38E8155E09EE006CC13CD65")
        @Override
        public String format(LogRecord r) {
            String varB4EAC82CA7396A68D541C85D26508E83_1079334625 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_947112914 = null; 
            Throwable thrown = r.getThrown();
            {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                sw.write(r.getMessage());
                sw.write("\n");
                thrown.printStackTrace(pw);
                pw.flush();
                varB4EAC82CA7396A68D541C85D26508E83_1079334625 = sw.toString();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_947112914 = r.getMessage();
            } 
            addTaint(r.getTaint());
            String varA7E53CE21691AB073D9660D615818899_1775326922; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1775326922 = varB4EAC82CA7396A68D541C85D26508E83_1079334625;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1775326922 = varB4EAC82CA7396A68D541C85D26508E83_947112914;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1775326922.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1775326922;
            
        }
        
};

    /**
     * Constructs a new instance of the Android log handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.838 -0500", hash_original_method = "3144D6BF2066D661F792BBA409558AA4", hash_generated_method = "743A6DC2556A7FDAC6C726598DD2E01D")
    
public AndroidHandler() {
        setFormatter(THE_FORMATTER);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.841 -0500", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "0161489F396FA1AC6DE664D6EC9C8356")
    
@Override
    public void close() {
        // No need to close, but must implement abstract method.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.844 -0500", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "E2C939B3E0C64F082957286C67166E9D")
    
@Override
    public void flush() {
        // No need to flush, but must implement abstract method.
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.848 -0500", hash_original_method = "CEA54EC9759DF54F81D3C4C5F0B6BD15", hash_generated_method = "A33B4D4D9FD9E95ACA274375B1828ED7")
    
@Override
    public void publish(LogRecord record) {
        int level = getAndroidLevel(record.getLevel());
        String tag = DalvikLogging.loggerNameToTag(record.getLoggerName());
        if (!Log.isLoggable(tag, level)) {
            return;
        }

        try {
            String message = getFormatter().format(record);
            Log.println(level, tag, message);
        } catch (RuntimeException e) {
            Log.e("AndroidHandler", "Error logging message.", e);
        }
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.850 -0500", hash_original_method = "23FAB086781713B49A4D1AC40EDC6A51", hash_generated_method = "A6C649DFABC7E10B72064E69B72963DC")
    
public void publish(Logger source, String tag, Level level, String message) {
        // TODO: avoid ducking into native 2x; we aren't saving any formatter calls
        int priority = getAndroidLevel(level);
        if (!Log.isLoggable(tag, priority)) {
            return;
        }

        try {
            Log.println(priority, tag, message);
        } catch (RuntimeException e) {
            Log.e("AndroidHandler", "Error logging message.", e);
        }
    }
}

