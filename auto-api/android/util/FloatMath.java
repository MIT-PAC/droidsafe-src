package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class FloatMath {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.606 -0400", hash_original_method = "1F13790E730E0CCC2AC5BFBAA0385051", hash_generated_method = "9A2C8B2CE0B4533ACDD4930C17F98FAF")
    @DSModeled(DSC.SAFE)
    private FloatMath() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.606 -0400", hash_original_method = "CF1DE92991002B5B5E5BB967A3164031", hash_generated_method = "8AFD0302F586E49B296D568F3D2A9DE8")
    public static float floor(float value) {
        DSTaintObject taint = new DSTaintObject();
        taint.addTaint(value);
        return taint.getTaintFloat();

    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.606 -0400", hash_original_method = "D774E3047772BB7D2B91C13721EFA2C6", hash_generated_method = "78E6D9AE440B393FB8EA4B230324731E")
    public static float ceil(float value) {
    	 DSTaintObject taint = new DSTaintObject();
         taint.addTaint(value);
         return taint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.606 -0400", hash_original_method = "9E3C3AC0D128D0AF767C468A3A664511", hash_generated_method = "016587105EFB556FDCA84F433E18310D")
    public static float sin(float angle) {
    	 DSTaintObject taint = new DSTaintObject();
         taint.addTaint(angle);
         return taint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.606 -0400", hash_original_method = "68FA4BFE9E4EF213B97F360D4220B957", hash_generated_method = "2F9D6BF5F6A53F3739BE1ED32C10849D")
    public static float cos(float angle) {
    	 DSTaintObject taint = new DSTaintObject();
         taint.addTaint(angle);
         return taint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.606 -0400", hash_original_method = "85442B0A54D4EF41ED7EF4A5C052F0C9", hash_generated_method = "3AB48D9D9D5EADADFAC83C761251E762")
    public static float sqrt(float value) {
    	 DSTaintObject taint = new DSTaintObject();
         taint.addTaint(value);
         return taint.getTaintFloat();
    }

    
}


