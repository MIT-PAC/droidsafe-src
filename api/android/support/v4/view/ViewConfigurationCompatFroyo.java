package android.support.v4.view;

// Droidsafe Imports
import android.view.ViewConfiguration;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class ViewConfigurationCompatFroyo {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.390 -0400", hash_original_method = "EEE1AD00FE015BD5CCAF68F2B6B9A323", hash_generated_method = "EEE1AD00FE015BD5CCAF68F2B6B9A323")
    public ViewConfigurationCompatFroyo ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return config.getScaledPagingTouchSlop();
    }

    
}

