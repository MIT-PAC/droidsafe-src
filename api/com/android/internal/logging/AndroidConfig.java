package com.android.internal.logging;

// Droidsafe Imports
import java.util.logging.Level;
import java.util.logging.Logger;

import droidsafe.annotations.DSGenerator;

public class AndroidConfig {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.234 -0400", hash_original_method = "C1A94E93768B2642CCBAA40A11700DD6", hash_generated_method = "AD9D36F20FB1DF2A5955803E2BDC9DC0")
    public  AndroidConfig() {
        super();
        try 
        {
            Logger rootLogger = Logger.getLogger("");
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

