package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.ViewConfiguration;



public class ViewConfigurationCompat {

    // -------------------------------------------------------------------

    /**
     * Call {@link ViewConfiguration#getScaledPagingTouchSlop()}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#FROYO} device,
     * returns {@link ViewConfiguration#getScaledTouchSlop()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.168 -0500", hash_original_method = "3528C0183AFB79CCB68AA739BEF357FF", hash_generated_method = "1BC52F06F2C8ECA5BEC4194ED7F7B291")
    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return IMPL.getScaledPagingTouchSlop(config);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.167 -0500", hash_original_field = "757E23C6B8816B26A38274C90DED08B4", hash_generated_field = "4BAEFA1DBA6789946690ACEDFD86419E")

    static  ViewConfigurationVersionImpl IMPL;

    
    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.387 -0400", hash_original_method = "A69B2452C79DFBE1CA7B04111C2A43A4", hash_generated_method = "A69B2452C79DFBE1CA7B04111C2A43A4")
        public BaseViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.163 -0500", hash_original_method = "40A95D8EF0A43B6ED733EDF4744F0469", hash_generated_method = "1D7E3EB014AE3CF651A36DC6CE49B7BB")
        @Override
public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return config.getScaledTouchSlop();
        }

        
    }


    
    static class FroyoViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.387 -0400", hash_original_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583", hash_generated_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583")
        public FroyoViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.165 -0500", hash_original_method = "5FB3C1F49AB507E1F7081F1E34699ECD", hash_generated_method = "36E3FC06272A4B4387BED92E9254E9DD")
        @Override
public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config);
        }

        
    }


    
    interface ViewConfigurationVersionImpl {
        public int getScaledPagingTouchSlop(ViewConfiguration config);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.387 -0400", hash_original_method = "4E5705462ABC07218BC228DFC04D8AC2", hash_generated_method = "4E5705462ABC07218BC228DFC04D8AC2")
    public ViewConfigurationCompat ()
    {
        //Synthesized constructor
    }
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }
    
}

