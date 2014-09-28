package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.View;

class ViewCompatGingerbread {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.584 -0500", hash_original_method = "5102930178F86D1534373691B1568829", hash_generated_method = "2EC2A28763596583164FD6BF5FAF5E97")
    
public static int getOverScrollMode(View v) {
        return v.getOverScrollMode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.587 -0500", hash_original_method = "3F822A27A2FBF877C37A982132EAA1C7", hash_generated_method = "81A0C41D4C00915FC59B5D6DF605910F")
    
public static void setOverScrollMode(View v, int mode) {
        v.setOverScrollMode(mode);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.382 -0400", hash_original_method = "190F874704D971FD8CFC3341F59D2192", hash_generated_method = "190F874704D971FD8CFC3341F59D2192")
    public ViewCompatGingerbread ()
    {
        //Synthesized constructor
    }
    
}

