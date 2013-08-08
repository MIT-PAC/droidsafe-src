package android.support.v4.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.view.MenuItem;
import android.view.View;





public class MenuItemCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.257 -0400", hash_original_method = "70825ED8217B35997B960B05005B76A3", hash_generated_method = "70825ED8217B35997B960B05005B76A3")
    public MenuItemCompat ()
    {
        //Synthesized constructor
    }


    public static boolean setShowAsAction(MenuItem item, int actionEnum) {
        return IMPL.setShowAsAction(item, actionEnum);
    }

    
    public static MenuItem setActionView(MenuItem item, View view) {
        return IMPL.setActionView(item, view);
    }

    
    static class BaseMenuVersionImpl implements MenuVersionImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.258 -0400", hash_original_method = "BFDC30535AAA3E19A04AFADFFD50E16A", hash_generated_method = "BFDC30535AAA3E19A04AFADFFD50E16A")
        public BaseMenuVersionImpl ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.258 -0400", hash_original_method = "7F014EF22317C05910A706092D499BCA", hash_generated_method = "00A3E922E65F6D17CB23A015C92A9991")
        @Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            addTaint(actionEnum);
            addTaint(item.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1406462297 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448775760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_448775760;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.259 -0400", hash_original_method = "971C4B8F174AEBF876692B29A12DA5CF", hash_generated_method = "C7D3E46F1EB5A13010DFBC92833327F1")
        @Override
        public MenuItem setActionView(MenuItem item, View view) {
            addTaint(view.getTaint());
            addTaint(item.getTaint());
MenuItem var393CF4FD24220F0ED4B080A1E7108CD3_362247719 =             item;
            var393CF4FD24220F0ED4B080A1E7108CD3_362247719.addTaint(taint);
            return var393CF4FD24220F0ED4B080A1E7108CD3_362247719;
            // ---------- Original Method ----------
            //return item;
        }

        
    }


    
    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.259 -0400", hash_original_method = "1A0F236AE805B2AE3CB14132D083E8D6", hash_generated_method = "1A0F236AE805B2AE3CB14132D083E8D6")
        public HoneycombMenuVersionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.259 -0400", hash_original_method = "F1D99359C312DFE7F282494BE8BB96CD", hash_generated_method = "25BD7296032FE685AA4DC621E0E33084")
        @Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            addTaint(actionEnum);
            addTaint(item.getTaint());
            MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
            boolean varB326B5062B2F0E69046810717534CB09_228184575 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_434542299 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_434542299;
            // ---------- Original Method ----------
            //MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.260 -0400", hash_original_method = "90CAAC5120E272242D0304C5B3BDF689", hash_generated_method = "6CC2D83BA7876DD99EEDFDA41443EF5E")
        @Override
        public MenuItem setActionView(MenuItem item, View view) {
            addTaint(view.getTaint());
            addTaint(item.getTaint());
MenuItem var104E6C0FB77127EB4F48475DCACA9E7E_1073949051 =             MenuItemCompatHoneycomb.setActionView(item, view);
            var104E6C0FB77127EB4F48475DCACA9E7E_1073949051.addTaint(taint);
            return var104E6C0FB77127EB4F48475DCACA9E7E_1073949051;
            // ---------- Original Method ----------
            //return MenuItemCompatHoneycomb.setActionView(item, view);
        }

        
    }


    
    interface MenuVersionImpl {
        public boolean setShowAsAction(MenuItem item, int actionEnum);
        public MenuItem setActionView(MenuItem item, View view);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.260 -0400", hash_original_field = "95D34C0D050952D9CB3470FE30E9A4DE", hash_generated_field = "49E9487BFDE37A8FB02ED40DCD77804C")

    public static final int SHOW_AS_ACTION_NEVER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.260 -0400", hash_original_field = "F8AA5501C2474E7F8DF74183EF6D1A72", hash_generated_field = "F83989AA2029EE1F6F60BC38E0C9593B")

    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.260 -0400", hash_original_field = "CF0FD0FE327F9FF54EDD6A6383951E52", hash_generated_field = "DE50309D75A966DECCE3F374CC190FA0")

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.260 -0400", hash_original_field = "35B1D2661802AC2D98AA8284EC462D6A", hash_generated_field = "952B81CF40CAF8C98C9D373E5E3B8792")

    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.260 -0400", hash_original_field = "DD561E84F6D7BD65412BAE5D5AD9ABD6", hash_generated_field = "420F4F1044A62A048FC7608F58EA2B72")

    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.261 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "4E3138D2C8B4893576326933CC27438B")

    static MenuVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombMenuVersionImpl();
        } else {
            IMPL = new BaseMenuVersionImpl();
        }
    }
    
}

