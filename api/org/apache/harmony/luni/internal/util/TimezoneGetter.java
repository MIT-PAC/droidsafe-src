package org.apache.harmony.luni.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public abstract class TimezoneGetter {

    /**
     * Retrieves the singleton instance of this class.
     *
     * @return TimezoneGetter the single instance of this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:16.727 -0500", hash_original_method = "C0F8B0F9DC6033715F5A9B5877DEC568", hash_generated_method = "8EA34018244D32BE4282BD0D1EC39A7B")
    public static TimezoneGetter getInstance() {
        return instance;
    }

    /**
     * Sets the singleton instance of this class.
     *
     * @param instance
     *            TimezoneGetter the single instance of this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:16.728 -0500", hash_original_method = "68E62A782D0D67099F52FF0719D92EF1", hash_generated_method = "5C1793B0FD208C3FCEA0F4677498E30A")
    public static void setInstance(TimezoneGetter getter) {
        if (instance != null) {
            throw new UnsupportedOperationException("TimezoneGetter instance already set");
        }
        instance = getter;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:16.726 -0500", hash_original_field = "30EB9F14C9B72E9925AF245C6CEF294C", hash_generated_field = "D3AAD2C19E68DBB13BF532AFF4D3C58C")


    private static TimezoneGetter instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.880 -0400", hash_original_method = "66ED1F8E1E851198705C6DFD8EC10BBB", hash_generated_method = "66ED1F8E1E851198705C6DFD8EC10BBB")
    public TimezoneGetter ()
    {
        //Synthesized constructor
    }

    /**
     * Retrieves the ID of the current time zone.
     *
     * @return String the ID of the current time zone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:16.728 -0500", hash_original_method = "786FFADA2702303736BFB9FDDC0A830C", hash_generated_method = "B5BA589892AA7DF2EDF582DD9382FAF7")
    public abstract String getId();
}

