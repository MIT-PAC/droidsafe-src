package org.apache.harmony.luni.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class TimezoneGetter {
    private static TimezoneGetter instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.563 -0400", hash_original_method = "C0F8B0F9DC6033715F5A9B5877DEC568", hash_generated_method = "8EA34018244D32BE4282BD0D1EC39A7B")
    public static TimezoneGetter getInstance() {
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.564 -0400", hash_original_method = "68E62A782D0D67099F52FF0719D92EF1", hash_generated_method = "5C1793B0FD208C3FCEA0F4677498E30A")
    public static void setInstance(TimezoneGetter getter) {
        if (instance != null) {
            throw new UnsupportedOperationException("TimezoneGetter instance already set");
        }
        instance = getter;
    }

    
    public abstract String getId();

    
}


