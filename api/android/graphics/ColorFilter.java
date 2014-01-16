package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ColorFilter {
    
    private static void finalizer(int native_instance, int nativeColorFilter) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.092 -0500", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")

    int native_instance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.094 -0500", hash_original_field = "18E9845A71E43900124F08ED6B6E0199", hash_generated_field = "356D3DECEC4831614887BA02809E06EA")

    public int nativeColorFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.004 -0400", hash_original_method = "046AE4C958596245478875223EE4194E", hash_generated_method = "046AE4C958596245478875223EE4194E")
    public ColorFilter ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.096 -0500", hash_original_method = "4AD2A6CCCDD358BAD652AE03056C36C3", hash_generated_method = "C4DD20B802A13FAC6510C3A64139B70A")
    
protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            finalizer(native_instance, nativeColorFilter);
        }
    }
    
}

