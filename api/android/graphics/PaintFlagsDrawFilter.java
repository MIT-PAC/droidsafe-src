package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.*;



import droidsafe.helpers.DSUtils;

public class PaintFlagsDrawFilter extends DrawFilter {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.559 -0400", hash_original_method = "D31498501931F002B6E02A5E6FE68BA6", hash_generated_method = "80ADF9D0E9B8EF3DDE28C2BC6837B3A1")
    public  PaintFlagsDrawFilter(int clearBits, int setBits) {
        addTaint(setBits);
        addTaint(clearBits);
        mNativeInt = nativeConstructor(clearBits, setBits);
        // ---------- Original Method ----------
        //mNativeInt = nativeConstructor(clearBits, setBits);
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeConstructor(int clearBits, int setBits) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

