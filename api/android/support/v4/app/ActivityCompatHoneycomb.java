package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.content.Intent;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ActivityCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.593 -0400", hash_original_method = "EDEF3A05A858D56A3B74BD91E5B0357B", hash_generated_method = "EDEF3A05A858D56A3B74BD91E5B0357B")
    public ActivityCompatHoneycomb ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }

    
    @DSModeled(DSC.SPEC)
    static void startActivities(Activity activity, Intent[] intents) {
        activity.startActivities(intents);
    }

    
    @DSModeled(DSC.SPEC)
    static void dump(Activity activity, String prefix, FileDescriptor fd,
            PrintWriter writer, String[] args) {
        activity.dump(prefix, fd, writer, args);
    }

    
}

