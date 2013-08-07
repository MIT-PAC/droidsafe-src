package android.support.v4.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;


public class ActivityCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.588 -0400", hash_original_method = "414402D33DBDAB1C5354F42B198D5939", hash_generated_method = "414402D33DBDAB1C5354F42B198D5939")
    public ActivityCompat ()
    {
        //Synthesized constructor
    }


    public static boolean invalidateOptionsMenu(Activity activity) {
        if (Build.VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(activity);
            return true;
        }
        return false;
    }

    
    public static boolean startActivities(Activity activity, Intent[] intents) {
        if (Build.VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.startActivities(activity, intents);
            return true;
        }
        return false;
    }

    
}

