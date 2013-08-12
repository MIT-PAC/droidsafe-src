package android.support.v4.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.view.MenuItem;
import android.view.View;




class MenuItemCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.265 -0400", hash_original_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D", hash_generated_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D")
    public MenuItemCompatHoneycomb ()
    {
        //Synthesized constructor
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

