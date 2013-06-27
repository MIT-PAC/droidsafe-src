package com.android.internal.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import dalvik.system.DalvikLogging;
import dalvik.system.DalvikLogHandler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class AndroidHandler extends Handler implements DalvikLogHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.119 -0400", hash_original_method = "3144D6BF2066D661F792BBA409558AA4", hash_generated_method = "499BDCB128B25531C4DD756ECC316A4F")
    public  AndroidHandler() {
        setFormatter(THE_FORMATTER);
        // ---------- Original Method ----------
        //setFormatter(THE_FORMATTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.119 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.120 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.121 -0400", hash_original_method = "CEA54EC9759DF54F81D3C4C5F0B6BD15", hash_generated_method = "D53FA8E575FDBBC34EE121AF0AA4B514")
    @Override
    public void publish(LogRecord record) {
        int level;
        level = getAndroidLevel(record.getLevel());
        String tag;
        tag = DalvikLogging.loggerNameToTag(record.getLoggerName());
        {
            boolean varE5C6F5796C07A86B43D31059C7E1466E_480330067 = (!Log.isLoggable(tag, level));
        } //End collapsed parenthetic
        try 
        {
            String message;
            message = getFormatter().format(record);
            Log.println(level, tag, message);
        } //End block
        catch (RuntimeException e)
        { }
        addTaint(record.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.134 -0400", hash_original_method = "23FAB086781713B49A4D1AC40EDC6A51", hash_generated_method = "7FAC163EC368CC6C7C7A702B793BCC2C")
    public void publish(Logger source, String tag, Level level, String message) {
        int priority;
        priority = getAndroidLevel(level);
        {
            boolean varA3063426528B7BB2C222641072B6B376_1519632723 = (!Log.isLoggable(tag, priority));
        } //End collapsed parenthetic
        try 
        {
            Log.println(priority, tag, message);
        } //End block
        catch (RuntimeException e)
        { }
        addTaint(source.getTaint());
        addTaint(tag.getTaint());
        addTaint(level.getTaint());
        addTaint(message.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.136 -0400", hash_original_field = "05CB8D5FA80AAAD88471EF57C0EC546F", hash_generated_field = "3DE40AB675D719C226F90D53F0C1BBCB")

    private static Formatter THE_FORMATTER = new Formatter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.136 -0400", hash_original_method = "5552BF51EFD27F1F4C5C7AE17D37E3F1", hash_generated_method = "F1ED86646DF824472C9CB6AFAAF8ACC3")
        @Override
        public String format(LogRecord r) {
            String varB4EAC82CA7396A68D541C85D26508E83_2004955564 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_824736856 = null; //Variable for return #2
            Throwable thrown;
            thrown = r.getThrown();
            {
                StringWriter sw;
                sw = new StringWriter();
                PrintWriter pw;
                pw = new PrintWriter(sw);
                sw.write(r.getMessage());
                sw.write("\n");
                thrown.printStackTrace(pw);
                pw.flush();
                varB4EAC82CA7396A68D541C85D26508E83_2004955564 = sw.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_824736856 = r.getMessage();
            } //End block
            addTaint(r.getTaint());
            String varA7E53CE21691AB073D9660D615818899_1761288566; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1761288566 = varB4EAC82CA7396A68D541C85D26508E83_2004955564;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1761288566 = varB4EAC82CA7396A68D541C85D26508E83_824736856;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1761288566.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1761288566;
            // ---------- Original Method ----------
            //Throwable thrown = r.getThrown();
            //if (thrown != null) {
                //StringWriter sw = new StringWriter();
                //PrintWriter pw = new PrintWriter(sw);
                //sw.write(r.getMessage());
                //sw.write("\n");
                //thrown.printStackTrace(pw);
                //pw.flush();
                //return sw.toString();
            //} else {
                //return r.getMessage();
            //}
        }

        
};
}

