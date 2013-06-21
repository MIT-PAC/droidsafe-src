package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MaskFilter {
    int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.252 -0400", hash_original_method = "5E33BDE59FF75B3D711386FCE2611A0F", hash_generated_method = "5E33BDE59FF75B3D711386FCE2611A0F")
        public MaskFilter ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.253 -0400", hash_original_method = "CA9745465B207BED8177C430188A7C4B", hash_generated_method = "0F8C7E32A99795A8E0AEE47F785754CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        nativeDestructor(native_instance);
        // ---------- Original Method ----------
        //nativeDestructor(native_instance);
    }

    
        private static void nativeDestructor(int native_filter) {
    }

    
}

