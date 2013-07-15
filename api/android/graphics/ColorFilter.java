package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ColorFilter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.082 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")

    int native_instance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.082 -0400", hash_original_field = "9081852C2AA2EBCBA75216A7298619DA", hash_generated_field = "356D3DECEC4831614887BA02809E06EA")

    public int nativeColorFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.082 -0400", hash_original_method = "046AE4C958596245478875223EE4194E", hash_generated_method = "046AE4C958596245478875223EE4194E")
    public ColorFilter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.083 -0400", hash_original_method = "4AD2A6CCCDD358BAD652AE03056C36C3", hash_generated_method = "705C0CD94FF3798AD8571A1588FCA6C7")
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

    
    @DSModeled(DSC.SAFE)
    private static void finalizer(int native_instance, int nativeColorFilter) {
    }

    
}

