package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.ViewConfiguration;

class ViewConfigurationCompatFroyo {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.134 -0400", hash_original_method = "EEE1AD00FE015BD5CCAF68F2B6B9A323", hash_generated_method = "EEE1AD00FE015BD5CCAF68F2B6B9A323")
    public ViewConfigurationCompatFroyo ()
    {
        //Synthesized constructor
    }


    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return config.getScaledPagingTouchSlop();
    }

    
}

