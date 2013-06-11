package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ColorFilter {
    int native_instance;
    public int nativeColorFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.020 -0400", hash_original_method = "4AD2A6CCCDD358BAD652AE03056C36C3", hash_generated_method = "2A8FD0AB7638C4E3F5432790ECFF4DA8")
    @DSModeled(DSC.SAFE)
    protected void finalize() throws Throwable {
        try 
        {
            super.finalize();
        } //End block
        finally 
        {
            finalizer(native_instance, nativeColorFilter);
        } //End block
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} finally {
            //finalizer(native_instance, nativeColorFilter);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.020 -0400", hash_original_method = "4AA054A6DE4B48C0BA2DEB83EF675B58", hash_generated_method = "AB75C3B53FF33D30AA243D76D3A25DA9")
    private static void finalizer(int native_instance, int nativeColorFilter) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


