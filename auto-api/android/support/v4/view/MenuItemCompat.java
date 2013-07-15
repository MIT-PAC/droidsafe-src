package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.MenuItem;
import android.view.View;

public class MenuItemCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.441 -0400", hash_original_method = "70825ED8217B35997B960B05005B76A3", hash_generated_method = "70825ED8217B35997B960B05005B76A3")
    public MenuItemCompat ()
    {
        
    }


    public static boolean setShowAsAction(MenuItem item, int actionEnum) {
        return IMPL.setShowAsAction(item, actionEnum);
    }

    
    public static MenuItem setActionView(MenuItem item, View view) {
        return IMPL.setActionView(item, view);
    }

    
    static class BaseMenuVersionImpl implements MenuVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.442 -0400", hash_original_method = "BFDC30535AAA3E19A04AFADFFD50E16A", hash_generated_method = "BFDC30535AAA3E19A04AFADFFD50E16A")
        public BaseMenuVersionImpl ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.443 -0400", hash_original_method = "7F014EF22317C05910A706092D499BCA", hash_generated_method = "2276E29E50951FA66B2C02764301D930")
        @Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            addTaint(item.getTaint());
            addTaint(actionEnum);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500782261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_500782261;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.448 -0400", hash_original_method = "971C4B8F174AEBF876692B29A12DA5CF", hash_generated_method = "85ACB89BE96AC2CC66BF5C1A8F54087B")
        @Override
        public MenuItem setActionView(MenuItem item, View view) {
            MenuItem varB4EAC82CA7396A68D541C85D26508E83_1020288114 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1020288114 = item;
            addTaint(item.getTaint());
            addTaint(view.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1020288114.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1020288114;
            
            
        }

        
    }


    
    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.449 -0400", hash_original_method = "1A0F236AE805B2AE3CB14132D083E8D6", hash_generated_method = "1A0F236AE805B2AE3CB14132D083E8D6")
        public HoneycombMenuVersionImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.450 -0400", hash_original_method = "F1D99359C312DFE7F282494BE8BB96CD", hash_generated_method = "81BF845088B07CFF191022E7A21668FA")
        @Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
            addTaint(item.getTaint());
            addTaint(actionEnum);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_147091556 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_147091556;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.452 -0400", hash_original_method = "90CAAC5120E272242D0304C5B3BDF689", hash_generated_method = "7E05C6AC3F3D8A74AF15418CD23DC0E8")
        @Override
        public MenuItem setActionView(MenuItem item, View view) {
            MenuItem varB4EAC82CA7396A68D541C85D26508E83_1102449631 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1102449631 = MenuItemCompatHoneycomb.setActionView(item, view);
            addTaint(item.getTaint());
            addTaint(view.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1102449631.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1102449631;
            
            
        }

        
    }


    
    interface MenuVersionImpl {
        public boolean setShowAsAction(MenuItem item, int actionEnum);
        public MenuItem setActionView(MenuItem item, View view);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.453 -0400", hash_original_field = "95D34C0D050952D9CB3470FE30E9A4DE", hash_generated_field = "49E9487BFDE37A8FB02ED40DCD77804C")

    public static final int SHOW_AS_ACTION_NEVER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.453 -0400", hash_original_field = "F8AA5501C2474E7F8DF74183EF6D1A72", hash_generated_field = "F83989AA2029EE1F6F60BC38E0C9593B")

    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.454 -0400", hash_original_field = "CF0FD0FE327F9FF54EDD6A6383951E52", hash_generated_field = "DE50309D75A966DECCE3F374CC190FA0")

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.454 -0400", hash_original_field = "35B1D2661802AC2D98AA8284EC462D6A", hash_generated_field = "952B81CF40CAF8C98C9D373E5E3B8792")

    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.455 -0400", hash_original_field = "DD561E84F6D7BD65412BAE5D5AD9ABD6", hash_generated_field = "420F4F1044A62A048FC7608F58EA2B72")

    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.455 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "4E3138D2C8B4893576326933CC27438B")

    static MenuVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombMenuVersionImpl();
        } else {
            IMPL = new BaseMenuVersionImpl();
        }
    }
    
}

