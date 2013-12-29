package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.MenuItem;
import android.view.View;





public class MenuItemCompat {

    // -------------------------------------------------------------------

    /**
     * Call {@link MenuItem#setShowAsAction(int) MenuItem.setShowAsAction()}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#HONEYCOMB} device,
     * does nothing and returns false.  Otherwise returns true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.455 -0500", hash_original_method = "5464B522F72319259637DF43320B19A6", hash_generated_method = "12B28E79969300F0990EE2EDC1028CE1")
    public static boolean setShowAsAction(MenuItem item, int actionEnum) {
        return IMPL.setShowAsAction(item, actionEnum);
    }

    /**
     * Set an action view for this menu item. An action view will be displayed in place
     * of an automatically generated menu item element in the UI when this item is shown
     * as an action within a parent.
     *
     * @param view View to use for presenting this item to the user.
     * @return This Item so additional setters can be called.
     *
     * @see #setShowAsAction(MenuItem, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.456 -0500", hash_original_method = "B3285C2813AFB5C96292CF418F0C9C53", hash_generated_method = "98046490AEA87846141A314092DEA084")
    public static MenuItem setActionView(MenuItem item, View view) {
        return IMPL.setActionView(item, view);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.443 -0500", hash_original_field = "CE0FD093D5606EE490406D031A25C64B", hash_generated_field = "49E9487BFDE37A8FB02ED40DCD77804C")

    public static final int SHOW_AS_ACTION_NEVER = 0;

    
    static class BaseMenuVersionImpl implements MenuVersionImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.258 -0400", hash_original_method = "BFDC30535AAA3E19A04AFADFFD50E16A", hash_generated_method = "BFDC30535AAA3E19A04AFADFFD50E16A")
        public BaseMenuVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.448 -0500", hash_original_method = "7F014EF22317C05910A706092D499BCA", hash_generated_method = "89BB310A989C6FF93C741B0EF53FBAE6")
        @Override
public boolean setShowAsAction(MenuItem item, int actionEnum) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.450 -0500", hash_original_method = "971C4B8F174AEBF876692B29A12DA5CF", hash_generated_method = "FD9B5895EB1D14BB3B517503EA4E37F7")
        @Override
public MenuItem setActionView(MenuItem item, View view) {
            return item;
        }

        
    }


    
    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.259 -0400", hash_original_method = "1A0F236AE805B2AE3CB14132D083E8D6", hash_generated_method = "1A0F236AE805B2AE3CB14132D083E8D6")
        public HoneycombMenuVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.452 -0500", hash_original_method = "F1D99359C312DFE7F282494BE8BB96CD", hash_generated_method = "EA0914BF60B1334207BB9253E2344C05")
        @Override
public boolean setShowAsAction(MenuItem item, int actionEnum) {
            MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
            return true;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.453 -0500", hash_original_method = "90CAAC5120E272242D0304C5B3BDF689", hash_generated_method = "9B0BAF31F7A0B25B95A994276C25ED5B")
        @Override
public MenuItem setActionView(MenuItem item, View view) {
            return MenuItemCompatHoneycomb.setActionView(item, view);
        }

        
    }


    
    interface MenuVersionImpl {
        public boolean setShowAsAction(MenuItem item, int actionEnum);
        public MenuItem setActionView(MenuItem item, View view);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.444 -0500", hash_original_field = "DB02EA7CAFC50D4ED26C0904D5112D55", hash_generated_field = "F83989AA2029EE1F6F60BC38E0C9593B")

    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.445 -0500", hash_original_field = "111C6B8FAFFDDA0C5D2F4A588AFB73B6", hash_generated_field = "DE50309D75A966DECCE3F374CC190FA0")

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.446 -0500", hash_original_field = "D219A6715D1C1D7D21AB0BDD1F5F21E7", hash_generated_field = "952B81CF40CAF8C98C9D373E5E3B8792")

    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.447 -0500", hash_original_field = "D49FA3E90EDF32C5CE4EC8398CC41D65", hash_generated_field = "420F4F1044A62A048FC7608F58EA2B72")

    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:34.454 -0500", hash_original_field = "8028B97E4B96DA4F8B25DB17232BD5A2", hash_generated_field = "4E3138D2C8B4893576326933CC27438B")

    static  MenuVersionImpl IMPL;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.257 -0400", hash_original_method = "70825ED8217B35997B960B05005B76A3", hash_generated_method = "70825ED8217B35997B960B05005B76A3")
    public MenuItemCompat ()
    {
        //Synthesized constructor
    }
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombMenuVersionImpl();
        } else {
            IMPL = new BaseMenuVersionImpl();
        }
    }
    
}

