package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.reflect.Method;

public final class ExceptionUtils {
    static private final Method INIT_CAUSE_METHOD = getInitCauseMethod();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.046 -0400", hash_original_method = "A1F3D67C211E4EC7543A3C1E27BD7049", hash_generated_method = "0AFAEB6CF63B0747A48836ADFEF59D6E")
    @DSModeled(DSC.SAFE)
    private ExceptionUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.046 -0400", hash_original_method = "E0B19896BEC7E8973FE5692D01506C32", hash_generated_method = "41CF6E32BE46313F3FB2C00B6918F893")
    static private Method getInitCauseMethod() {
        try {
            Class[] paramsClasses = new Class[] { Throwable.class };
            return Throwable.class.getMethod("initCause", paramsClasses);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.046 -0400", hash_original_method = "9500C77C5C6AE8093B22F8C92F23F797", hash_generated_method = "BC6401B90B9C93817A3C39A9C5E80CC2")
    public static void initCause(Throwable throwable, Throwable cause) {
        if (INIT_CAUSE_METHOD != null) {
            try {
                INIT_CAUSE_METHOD.invoke(throwable, new Object[] { cause });
            } catch (Exception e) {
            }
        }
    }

    
}


