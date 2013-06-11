package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PaintFlagsDrawFilter extends DrawFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.280 -0400", hash_original_method = "D31498501931F002B6E02A5E6FE68BA6", hash_generated_method = "16BC9D82FD11DD89219868BF90809015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PaintFlagsDrawFilter(int clearBits, int setBits) {
        dsTaint.addTaint(setBits);
        dsTaint.addTaint(clearBits);
        mNativeInt = nativeConstructor(clearBits, setBits);
        // ---------- Original Method ----------
        //mNativeInt = nativeConstructor(clearBits, setBits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.280 -0400", hash_original_method = "1D7B69BE9832A8F4047167A4F16ADE32", hash_generated_method = "648BCF8D34B7BD82B6689C079088E1B2")
    private static int nativeConstructor(int clearBits, int setBits) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


