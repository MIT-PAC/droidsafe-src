package com.android.internal.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AndroidConfig {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.483 -0400", hash_original_method = "C1A94E93768B2642CCBAA40A11700DD6", hash_generated_method = "E9410D1FDB110DFD4CD10A147D5AE9DB")
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


