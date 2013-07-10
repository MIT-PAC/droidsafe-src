package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.MenuItem;
import android.view.View;

class MenuItemCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.396 -0400", hash_original_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D", hash_generated_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D")
    public MenuItemCompatHoneycomb ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    
    @DSModeled(DSC.SAFE)
    public static MenuItem setActionView(MenuItem item, View view) {
        return item.setActionView(view);
    }

    
}

