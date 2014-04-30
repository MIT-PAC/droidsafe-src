package android.support.v4.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class TaskStackBuilderHoneycomb {
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.318 -0500", hash_original_method = "B7B78BA9C82576FBF699E71554D05A8F", hash_generated_method = "5AF0279EC24877E7656EDC0E865839DF")
    
public static PendingIntent getActivitiesPendingIntent(Context context, int requestCode,
            Intent[] intents, int flags) {
        return PendingIntent.getActivities(context, requestCode, intents, flags);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.742 -0400", hash_original_method = "C1C252B6FF985D09E6DE52071C17C6AB", hash_generated_method = "C1C252B6FF985D09E6DE52071C17C6AB")
    public TaskStackBuilderHoneycomb ()
    {
        //Synthesized constructor
    }
    
}

