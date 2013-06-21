package org.apache.harmony.luni.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class TimezoneGetter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.796 -0400", hash_original_method = "E212A140D2CED8143ABDE630A1CC7A09", hash_generated_method = "E212A140D2CED8143ABDE630A1CC7A09")
        public TimezoneGetter ()
    {
    }


        public static TimezoneGetter getInstance() {
        return instance;
    }

    
        public static void setInstance(TimezoneGetter getter) {
        if (instance != null) {
            throw new UnsupportedOperationException("TimezoneGetter instance already set");
        }
        instance = getter;
    }

    
    public abstract String getId();

    
    private static TimezoneGetter instance;
}

