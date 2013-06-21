package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Xfermode {
    int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.837 -0400", hash_original_method = "878DB4809A89DC89D70FF8E9DA07FF8E", hash_generated_method = "878DB4809A89DC89D70FF8E9DA07FF8E")
        public Xfermode ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.837 -0400", hash_original_method = "E460B29F415CD7A40554AE473F148807", hash_generated_method = "498A22B6312114B222536B9B92E00CB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        try 
        {
            finalizer(native_instance);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //finalizer(native_instance);
        //} finally {
            //super.finalize();
        //}
    }

    
        private static void finalizer(int native_instance) {
    }

    
}

