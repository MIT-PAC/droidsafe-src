package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.MenuItem;
import android.view.View;

class MenuItemCompatHoneycomb {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.556 -0500", hash_original_method = "89CD2C30CF5A705FF97EBB7DAEFF0B6A", hash_generated_method = "DDAF007DCCB4122BF03524C617CCE49F")
    
public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.558 -0500", hash_original_method = "472E51716AFA194E818BC256203A7F04", hash_generated_method = "810E367DCDDAB1D06C8E8F576F4B806B")
    
public static MenuItem setActionView(MenuItem item, View view) {
        return item.setActionView(view);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.265 -0400", hash_original_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D", hash_generated_method = "7746D8AEA87F7C8BC2BBB0341ED8F77D")
    public MenuItemCompatHoneycomb ()
    {
        //Synthesized constructor
    }
    
}

