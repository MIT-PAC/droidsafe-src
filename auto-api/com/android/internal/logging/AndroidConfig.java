package com.android.internal.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AndroidConfig {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.111 -0400", hash_original_method = "C1A94E93768B2642CCBAA40A11700DD6", hash_generated_method = "1ED6184285E7A3920FB84DD06EF57D85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidConfig() {
        super();
        try 
        {
            Logger rootLogger;
            rootLogger = Logger.getLogger("");
            rootLogger.addHandler(new AndroidHandler());
            rootLogger.setLevel(Level.INFO);
            Logger.getLogger("org.apache").setLevel(Level.WARNING);
        } //End block
        catch (Exception ex)
        {
            ex.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        //try {
            //Logger rootLogger = Logger.getLogger("");
            //rootLogger.addHandler(new AndroidHandler());
            //rootLogger.setLevel(Level.INFO);
            //Logger.getLogger("org.apache").setLevel(Level.WARNING);
        //} catch (Exception ex) {
            //ex.printStackTrace();
        //}
    }

    
}

