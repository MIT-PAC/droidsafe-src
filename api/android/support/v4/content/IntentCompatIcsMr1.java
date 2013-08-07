package android.support.v4.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Intent;


class IntentCompatIcsMr1 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.847 -0400", hash_original_method = "675FBFFBDF7BA4F4ADA16E21CDC468F7", hash_generated_method = "675FBFFBDF7BA4F4ADA16E21CDC468F7")
    public IntentCompatIcsMr1 ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
        return Intent.makeMainSelectorActivity(selectorAction, selectorCategory);
    }

    
}

