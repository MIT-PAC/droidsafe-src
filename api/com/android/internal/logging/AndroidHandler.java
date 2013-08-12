package com.android.internal.logging;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.250 -0400", hash_original_method = "3144D6BF2066D661F792BBA409558AA4", hash_generated_method = "499BDCB128B25531C4DD756ECC316A4F")
    public  AndroidHandler() {
        setFormatter(THE_FORMATTER);
        // ---------- Original Method ----------
        //setFormatter(THE_FORMATTER);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.250 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.251 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.252 -0400", hash_original_method = "CEA54EC9759DF54F81D3C4C5F0B6BD15", hash_generated_method = "246215A133F1BFE6B0FFEC419C6FC955")
    @Override
    public void publish(LogRecord record) {
        addTaint(record.getTaint());
        int level = getAndroidLevel(record.getLevel());
        String tag = DalvikLogging.loggerNameToTag(record.getLoggerName());
        if(!Log.isLoggable(tag, level))        
        {
            return;
        } //End block
        try 
        {
            String message = getFormatter().format(record);
            Log.println(level, tag, message);
        } //End block
        catch (RuntimeException e)
        {
        } //End block
        // ---------- Original Method ----------
        //int level = getAndroidLevel(record.getLevel());
        //String tag = DalvikLogging.loggerNameToTag(record.getLoggerName());
        //if (!Log.isLoggable(tag, level)) {
            //return;
        //}
        //try {
            //String message = getFormatter().format(record);
            //Log.println(level, tag, message);
        //} catch (RuntimeException e) {
            //Log.e("AndroidHandler", "Error logging message.", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.253 -0400", hash_original_method = "23FAB086781713B49A4D1AC40EDC6A51", hash_generated_method = "025FD5B6A24F75086E4C8B6757718A47")
    public void publish(Logger source, String tag, Level level, String message) {
        addTaint(message.getTaint());
        addTaint(level.getTaint());
        addTaint(tag.getTaint());
        addTaint(source.getTaint());
        int priority = getAndroidLevel(level);
        if(!Log.isLoggable(tag, priority))        
        {
            return;
        } //End block
        try 
        {
            Log.println(priority, tag, message);
        } //End block
        catch (RuntimeException e)
        {
        } //End block
        // ---------- Original Method ----------
        //int priority = getAndroidLevel(level);
        //if (!Log.isLoggable(tag, priority)) {
            //return;
        //}
        //try {
            //Log.println(priority, tag, message);
        //} catch (RuntimeException e) {
            //Log.e("AndroidHandler", "Error logging message.", e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    static int getAndroidLevel(Level level) {
        int value = level.intValue();
        if (value >= 1000) { 
            return Log.ERROR;
        } else if (value >= 900) { 
            return Log.WARN;
        } else if (value >= 800) { 
            return Log.INFO;
        } else {
            return Log.DEBUG;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.231 -0400", hash_original_field = "05CB8D5FA80AAAD88471EF57C0EC546F", hash_generated_field = "006C8788F0F47E8A210E001196024E69")

    private static final Formatter THE_FORMATTER = new Formatter() {        
        @DSModeled(DSC.SAFE)
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
}

