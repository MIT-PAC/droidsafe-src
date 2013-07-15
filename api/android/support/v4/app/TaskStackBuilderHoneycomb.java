package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class TaskStackBuilderHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.246 -0400", hash_original_method = "C1C252B6FF985D09E6DE52071C17C6AB", hash_generated_method = "C1C252B6FF985D09E6DE52071C17C6AB")
    public TaskStackBuilderHoneycomb ()
    {
        //Synthesized constructor
    }


        public static PendingIntent getActivitiesPendingIntent(Context context, int requestCode,
            Intent[] intents, int flags) {
        return PendingIntent.getActivities(context, requestCode, intents, flags);
    }

    
}

