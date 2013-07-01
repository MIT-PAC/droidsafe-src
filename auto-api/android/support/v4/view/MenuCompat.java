package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.MenuItem;

public class MenuCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.386 -0400", hash_original_method = "E9449EE1430A40536E18C8456731A263", hash_generated_method = "E9449EE1430A40536E18C8456731A263")
    public MenuCompat ()
    {
        //Synthesized constructor
    }


    public static boolean setShowAsAction(MenuItem item, int actionEnum) {
        return IMPL.setShowAsAction(item, actionEnum);
    }

    
    static class BaseMenuVersionImpl implements MenuVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.387 -0400", hash_original_method = "BFDC30535AAA3E19A04AFADFFD50E16A", hash_generated_method = "BFDC30535AAA3E19A04AFADFFD50E16A")
        public BaseMenuVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.388 -0400", hash_original_method = "7F014EF22317C05910A706092D499BCA", hash_generated_method = "6DEDB9D95491B1F64E1829B40AD86EF8")
        @Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            addTaint(item.getTaint());
            addTaint(actionEnum);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705310234 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_705310234;
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.389 -0400", hash_original_method = "1A0F236AE805B2AE3CB14132D083E8D6", hash_generated_method = "1A0F236AE805B2AE3CB14132D083E8D6")
        public HoneycombMenuVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.390 -0400", hash_original_method = "F1D99359C312DFE7F282494BE8BB96CD", hash_generated_method = "82B19C2FBB6515D5C2FA2539F4626BA4")
        @Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
            addTaint(item.getTaint());
            addTaint(actionEnum);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765120236 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765120236;
            // ---------- Original Method ----------
            //MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
            //return true;
        }

        
    }


    
    interface MenuVersionImpl {
        public boolean setShowAsAction(MenuItem item, int actionEnum);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.392 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "4E3138D2C8B4893576326933CC27438B")

    static MenuVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombMenuVersionImpl();
        } else {
            IMPL = new BaseMenuVersionImpl();
        }
    }
    
}

