package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class PaintFlagsDrawFilter extends DrawFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:31.894 -0400", hash_original_method = "D31498501931F002B6E02A5E6FE68BA6", hash_generated_method = "9E7F7223A031A3C523DB61B7290810A3")
    public  PaintFlagsDrawFilter(int clearBits, int setBits) {
        mNativeInt = nativeConstructor(clearBits, setBits);
        addTaint(clearBits);
        addTaint(setBits);
        
        
    }

    
    private static int nativeConstructor(int clearBits, int setBits) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

