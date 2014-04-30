package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.KeyEvent;

class KeyEventCompatHoneycomb {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.796 -0500", hash_original_method = "79BE0D2D02FC363E2DC3AC75A06B389D", hash_generated_method = "4B3DD113D59C5E46AABF7963C281AC7C")
    
public static int normalizeMetaState(int metaState) {
        return KeyEvent.normalizeMetaState(metaState);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.798 -0500", hash_original_method = "A185A3BFCA88730040BCF27DB06CF64E", hash_generated_method = "600AA1BD83992B8B5FE80EFD6C4E148C")
    
public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return KeyEvent.metaStateHasModifiers(metaState, modifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.801 -0500", hash_original_method = "8465E4D7036B4EBB9FC64269413E76C4", hash_generated_method = "10899E3CE74C041885F3E17B3695C5D2")
    
public static boolean metaStateHasNoModifiers(int metaState) {
        return KeyEvent.metaStateHasNoModifiers(metaState);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.249 -0400", hash_original_method = "2025FF61554914F4FC15F8674DA32210", hash_generated_method = "2025FF61554914F4FC15F8674DA32210")
    public KeyEventCompatHoneycomb ()
    {
        //Synthesized constructor
    }
    
}

