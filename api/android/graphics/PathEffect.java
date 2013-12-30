package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class PathEffect {

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int native_patheffect) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.339 -0500", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")

    int native_instance;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.608 -0400", hash_original_method = "EF0E91C0111CDC8D080E8EA855247871", hash_generated_method = "EF0E91C0111CDC8D080E8EA855247871")
    public PathEffect ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.333 -0500", hash_original_method = "CA9745465B207BED8177C430188A7C4B", hash_generated_method = "1B58F815E13231E7E163ED79B267DEA7")
    
protected void finalize() throws Throwable {
        nativeDestructor(native_instance);
    }

    
}

