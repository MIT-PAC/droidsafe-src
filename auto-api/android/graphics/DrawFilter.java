package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DrawFilter {
    int mNativeInt;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.232 -0400", hash_original_method = "D7C5775B96A1125409FD8ECAEA6A877F", hash_generated_method = "D7C5775B96A1125409FD8ECAEA6A877F")
        public DrawFilter ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.232 -0400", hash_original_method = "AD4C46BBF7AD12904405D19E52AE287A", hash_generated_method = "DF886E907054C8F11AAD3730C8F79A4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        nativeDestructor(mNativeInt);
        // ---------- Original Method ----------
        //nativeDestructor(mNativeInt);
    }

    
        private static void nativeDestructor(int nativeDrawFilter) {
    }

    
}

