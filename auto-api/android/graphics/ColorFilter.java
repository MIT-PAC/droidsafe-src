package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ColorFilter {
    int native_instance;
    public int nativeColorFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.230 -0400", hash_original_method = "6AB6F7F41EBFAB1EA211B7B3B6070EBE", hash_generated_method = "6AB6F7F41EBFAB1EA211B7B3B6070EBE")
        public ColorFilter ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.230 -0400", hash_original_method = "4AD2A6CCCDD358BAD652AE03056C36C3", hash_generated_method = "705C0CD94FF3798AD8571A1588FCA6C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static void finalizer(int native_instance, int nativeColorFilter) {
    }

    
}

