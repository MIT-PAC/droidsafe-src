package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PaintFlagsDrawFilter extends DrawFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.458 -0400", hash_original_method = "D31498501931F002B6E02A5E6FE68BA6", hash_generated_method = "F6904B9DC079E34BCF5A428FE0FD7CB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PaintFlagsDrawFilter(int clearBits, int setBits) {
        dsTaint.addTaint(setBits);
        dsTaint.addTaint(clearBits);
        mNativeInt = nativeConstructor(clearBits, setBits);
        // ---------- Original Method ----------
        //mNativeInt = nativeConstructor(clearBits, setBits);
    }

    
        private static int nativeConstructor(int clearBits, int setBits) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

