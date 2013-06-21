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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.113 -0400", hash_original_method = "3144D6BF2066D661F792BBA409558AA4", hash_generated_method = "499BDCB128B25531C4DD756ECC316A4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidHandler() {
        setFormatter(THE_FORMATTER);
        // ---------- Original Method ----------
        //setFormatter(THE_FORMATTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.113 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.114 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.114 -0400", hash_original_method = "CEA54EC9759DF54F81D3C4C5F0B6BD15", hash_generated_method = "7E39AFEA1C1ED3E46E82F7018AC4B24E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void publish(LogRecord record) {
        dsTaint.addTaint(record.dsTaint);
        int level;
        level = getAndroidLevel(record.getLevel());
        String tag;
        tag = DalvikLogging.loggerNameToTag(record.getLoggerName());
        {
            boolean varE5C6F5796C07A86B43D31059C7E1466E_1313155537 = (!Log.isLoggable(tag, level));
        } //End collapsed parenthetic
        try 
        {
            String message;
            message = getFormatter().format(record);
            Log.println(level, tag, message);
        } //End block
        catch (RuntimeException e)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.114 -0400", hash_original_method = "23FAB086781713B49A4D1AC40EDC6A51", hash_generated_method = "CE1FC8CE450499A0DD6B65D2D650E0F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void publish(Logger source, String tag, Level level, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(level.dsTaint);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(tag);
        int priority;
        priority = getAndroidLevel(level);
        {
            boolean varA3063426528B7BB2C222641072B6B376_819360071 = (!Log.isLoggable(tag, priority));
        } //End collapsed parenthetic
        try 
        {
            Log.println(priority, tag, message);
        } //End block
        catch (RuntimeException e)
        { }
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

    
    private static final Formatter THE_FORMATTER = new Formatter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.115 -0400", hash_original_method = "5552BF51EFD27F1F4C5C7AE17D37E3F1", hash_generated_method = "1E3907FD66CC15DD37EDDB848C334BF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String format(LogRecord r) {
            dsTaint.addTaint(r.dsTaint);
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
                String var8119C4FCFB3551812228C2BF013F6E0C_944012479 = (sw.toString());
            } //End block
            {
                String var83400180F3D0AF24F989B46B7D4A990B_1499488657 = (r.getMessage());
            } //End block
            return dsTaint.getTaintString();
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

        
}; //Transformed anonymous class
}

