package android.support.v4.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.view.KeyEvent;




class KeyEventCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.249 -0400", hash_original_method = "2025FF61554914F4FC15F8674DA32210", hash_generated_method = "2025FF61554914F4FC15F8674DA32210")
    public KeyEventCompatHoneycomb ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static int normalizeMetaState(int metaState) {
        return KeyEvent.normalizeMetaState(metaState);
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return KeyEvent.metaStateHasModifiers(metaState, modifiers);
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean metaStateHasNoModifiers(int metaState) {
        return KeyEvent.metaStateHasNoModifiers(metaState);
    }

    
}

