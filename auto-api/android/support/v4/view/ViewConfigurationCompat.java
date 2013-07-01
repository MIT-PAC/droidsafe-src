package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.140 -0400", hash_original_method = "4E5705462ABC07218BC228DFC04D8AC2", hash_generated_method = "4E5705462ABC07218BC228DFC04D8AC2")
    public ViewConfigurationCompat ()
    {
        //Synthesized constructor
    }


    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return IMPL.getScaledPagingTouchSlop(config);
    }

    
    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.141 -0400", hash_original_method = "A69B2452C79DFBE1CA7B04111C2A43A4", hash_generated_method = "A69B2452C79DFBE1CA7B04111C2A43A4")
        public BaseViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.142 -0400", hash_original_method = "40A95D8EF0A43B6ED733EDF4744F0469", hash_generated_method = "18181110519DC2336A2FB4FCCBCBE442")
        @Override
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            int varB7A03B4690454604B030F028E68C4FA9_280338246 = (config.getScaledTouchSlop());
            addTaint(config.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659788940 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659788940;
            // ---------- Original Method ----------
            //return config.getScaledTouchSlop();
        }

        
    }


    
    static class FroyoViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.143 -0400", hash_original_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583", hash_generated_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583")
        public FroyoViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.145 -0400", hash_original_method = "5FB3C1F49AB507E1F7081F1E34699ECD", hash_generated_method = "47EB254CD5DEB7F70EDF678A010A407D")
        @Override
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            int var4D4714B427AFE47BC3B507C1B71ABB6B_1269274871 = (ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config));
            addTaint(config.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911817873 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911817873;
            // ---------- Original Method ----------
            //return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config);
        }

        
    }


    
    interface ViewConfigurationVersionImpl {
        public int getScaledPagingTouchSlop(ViewConfiguration config);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.145 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "4BAEFA1DBA6789946690ACEDFD86419E")

    static ViewConfigurationVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }
    
}

