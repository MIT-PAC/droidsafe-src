package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class Xfermode {

    
    @DSModeled(DSC.SAFE)
    private static void finalizer(int native_instance) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:49.415 -0500", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")


    int native_instance;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.217 -0400", hash_original_method = "C597DAEA4231BF58F4F9DBF898816899", hash_generated_method = "C597DAEA4231BF58F4F9DBF898816899")
    public Xfermode ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:49.413 -0500", hash_original_method = "E460B29F415CD7A40554AE473F148807", hash_generated_method = "D49DD5D2A6C2FBFC72BA771457583316")
    protected void finalize() throws Throwable {
        try {
            finalizer(native_instance);
        } finally {
            super.finalize();
        }
    }

    
}

