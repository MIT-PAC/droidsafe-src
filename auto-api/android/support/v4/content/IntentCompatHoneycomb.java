package android.support.v4.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.ComponentName;
import android.content.Intent;

class IntentCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.295 -0400", hash_original_method = "858F6E9D286ACF80DE41048180ED3AB0", hash_generated_method = "858F6E9D286ACF80DE41048180ED3AB0")
    public IntentCompatHoneycomb ()
    {
        
    }


        public static Intent makeMainActivity(ComponentName mainActivity) {
        return Intent.makeMainActivity(mainActivity);
    }

    
        public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        return Intent.makeRestartActivityTask(mainActivity);
    }

    
}

