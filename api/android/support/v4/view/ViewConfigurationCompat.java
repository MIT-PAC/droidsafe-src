package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.890 -0400", hash_original_method = "4E5705462ABC07218BC228DFC04D8AC2", hash_generated_method = "4E5705462ABC07218BC228DFC04D8AC2")
    public ViewConfigurationCompat ()
    {
        //Synthesized constructor
    }


        public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return IMPL.getScaledPagingTouchSlop(config);
    }

    
    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.890 -0400", hash_original_method = "A69B2452C79DFBE1CA7B04111C2A43A4", hash_generated_method = "A69B2452C79DFBE1CA7B04111C2A43A4")
        public BaseViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.891 -0400", hash_original_method = "40A95D8EF0A43B6ED733EDF4744F0469", hash_generated_method = "8D89F6B665D42EBE8B04EAAB6365A1C6")
        @Override
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            addTaint(config.getTaint());
            int var33ADD0B58B6C6CBAD50BA8122F5803A3_709876008 = (config.getScaledTouchSlop());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194270789 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194270789;
            // ---------- Original Method ----------
            //return config.getScaledTouchSlop();
        }

        
    }


    
    static class FroyoViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.891 -0400", hash_original_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583", hash_generated_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583")
        public FroyoViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.891 -0400", hash_original_method = "5FB3C1F49AB507E1F7081F1E34699ECD", hash_generated_method = "81EACE6C4D4E91B88F6963E059EFB3A7")
        @Override
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            addTaint(config.getTaint());
            int var915F810AF7CE768570FF35D35C15EC72_1444690964 = (ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548401437 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548401437;
            // ---------- Original Method ----------
            //return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config);
        }

        
    }


    
    interface ViewConfigurationVersionImpl {
        public int getScaledPagingTouchSlop(ViewConfiguration config);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.891 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "4BAEFA1DBA6789946690ACEDFD86419E")

    static ViewConfigurationVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }
    
}

