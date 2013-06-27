package org.apache.http.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Method;

public final class ExceptionUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.406 -0400", hash_original_method = "A1F3D67C211E4EC7543A3C1E27BD7049", hash_generated_method = "F95AF61D71C58EF7813E91379E4F91E7")
    private  ExceptionUtils() {
        // ---------- Original Method ----------
    }

    
        static private Method getInitCauseMethod() {
        try {
            Class[] paramsClasses = new Class[] { Throwable.class };
            return Throwable.class.getMethod("initCause", paramsClasses);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    
        public static void initCause(Throwable throwable, Throwable cause) {
        if (INIT_CAUSE_METHOD != null) {
            try {
                INIT_CAUSE_METHOD.invoke(throwable, new Object[] { cause });
            } catch (Exception e) {
            }
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.406 -0400", hash_original_field = "273C39948CEEB1567DD9DAF0228DAFB5", hash_generated_field = "7C8375F37FD80C55575F5DCF2A7735EE")

    static private Method INIT_CAUSE_METHOD = getInitCauseMethod();
}

