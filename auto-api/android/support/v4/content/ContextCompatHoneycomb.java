package android.support.v4.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.Intent;

class ContextCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.263 -0400", hash_original_method = "6C3A5F3C3C189F8EBC0E14B8C641BDD7", hash_generated_method = "6C3A5F3C3C189F8EBC0E14B8C641BDD7")
    public ContextCompatHoneycomb ()
    {
        //Synthesized constructor
    }


        static void startActivities(Context context, Intent[] intents) {
        context.startActivities(intents);
    }

    
}

