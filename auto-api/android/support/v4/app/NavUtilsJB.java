package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.NavUtils;

class NavUtilsJB {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.079 -0400", hash_original_method = "D4A651A611CC51B857BCA8DE73B73039", hash_generated_method = "D4A651A611CC51B857BCA8DE73B73039")
    public NavUtilsJB ()
    {
        //Synthesized constructor
    }


        public static Intent getParentActivityIntent(Activity activity) {
        return NavUtils.getParentActivityIntent(activity);
    }

    
        public static boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
        return NavUtils.shouldUpRecreateTask(activity, targetIntent);
    }

    
        public static void navigateUpTo(Activity activity, Intent upIntent) {
        NavUtils.navigateUpTo(activity, upIntent);
    }

    
}

