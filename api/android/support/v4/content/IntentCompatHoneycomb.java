package android.support.v4.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Intent;


class IntentCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.842 -0400", hash_original_method = "858F6E9D286ACF80DE41048180ED3AB0", hash_generated_method = "858F6E9D286ACF80DE41048180ED3AB0")
    public IntentCompatHoneycomb ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static Intent makeMainActivity(ComponentName mainActivity) {
        return Intent.makeMainActivity(mainActivity);
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        return Intent.makeRestartActivityTask(mainActivity);
    }

    
}

