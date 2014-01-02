package com.android.internal.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AndroidConfig {

    /**
     * This looks a bit weird, but it's the way the logging config works: A
     * named class is instantiated, the constructor is assumed to tweak the
     * configuration, the instance itself is of no interest.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:39.792 -0500", hash_original_method = "C1A94E93768B2642CCBAA40A11700DD6", hash_generated_method = "552BBAF613451D21B2E3FBE44D5C4689")
    
public AndroidConfig() {
        super();
        
        try {
            Logger rootLogger = Logger.getLogger("");
            rootLogger.addHandler(new AndroidHandler());
            rootLogger.setLevel(Level.INFO);

            // Turn down logging in Apache libraries.
            Logger.getLogger("org.apache").setLevel(Level.WARNING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}

