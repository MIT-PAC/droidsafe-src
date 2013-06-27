package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.content.Intent;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ActivityCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.681 -0400", hash_original_method = "EDEF3A05A858D56A3B74BD91E5B0357B", hash_generated_method = "EDEF3A05A858D56A3B74BD91E5B0357B")
    public ActivityCompatHoneycomb ()
    {
        //Synthesized constructor
    }


        static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }

    
        static void startActivities(Activity activity, Intent[] intents) {
        activity.startActivities(intents);
    }

    
        static void dump(Activity activity, String prefix, FileDescriptor fd,
            PrintWriter writer, String[] args) {
        activity.dump(prefix, fd, writer, args);
    }

    
}

