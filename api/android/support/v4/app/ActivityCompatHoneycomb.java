package android.support.v4.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Intent;

class ActivityCompatHoneycomb {
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.342 -0500", hash_original_method = "B0A1865910DB6E870CEA82F98D9E3069", hash_generated_method = "5B035CD3E0C4A183BCC08A40E143D49E")
    
static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.345 -0500", hash_original_method = "356A861558D63FF4E583ED250BFF9A4E", hash_generated_method = "E14091D7B34B62C0F9EA89C2D30899F2")
    
static void startActivities(Activity activity, Intent[] intents) {
        activity.startActivities(intents);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.347 -0500", hash_original_method = "4C4EA70E880985ABD300A15BC9BAEF5D", hash_generated_method = "6BBF29CB963A770E0B3F507D749DE499")
    
static void dump(Activity activity, String prefix, FileDescriptor fd,
            PrintWriter writer, String[] args) {
        activity.dump(prefix, fd, writer, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.593 -0400", hash_original_method = "EDEF3A05A858D56A3B74BD91E5B0357B", hash_generated_method = "EDEF3A05A858D56A3B74BD91E5B0357B")
    public ActivityCompatHoneycomb ()
    {
        //Synthesized constructor
    }
    
}

