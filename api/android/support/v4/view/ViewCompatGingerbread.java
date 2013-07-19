package android.support.v4.view;

// Droidsafe Imports
import android.view.View;
import droidsafe.annotations.DSGenerator;

class ViewCompatGingerbread {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.382 -0400", hash_original_method = "190F874704D971FD8CFC3341F59D2192", hash_generated_method = "190F874704D971FD8CFC3341F59D2192")
    public ViewCompatGingerbread ()
    {
        //Synthesized constructor
    }


    public static int getOverScrollMode(View v) {
        return v.getOverScrollMode();
    }

    
    public static void setOverScrollMode(View v, int mode) {
        v.setOverScrollMode(mode);
    }

    
}

