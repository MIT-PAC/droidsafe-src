package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.MenuItem;
import android.view.View;

class MenuItemCompatHoneycomb {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.396 -0400", hash_original_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D", hash_generated_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D")
    public MenuItemCompatHoneycomb ()
    {
        //Synthesized constructor
    }


    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    
    public static MenuItem setActionView(MenuItem item, View view) {
        return item.setActionView(view);
    }

    
}

