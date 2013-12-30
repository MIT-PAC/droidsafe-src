package org.apache.http.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Method;




public final class ExceptionUtils {

    /**
     * Returns a <code>Method<code> allowing access to
     * {@link Throwable#initCause(Throwable) initCause} method of {@link Throwable},
     * or <code>null</code> if the method
     * does not exist.
     * 
     * @return A <code>Method<code> for <code>Throwable.initCause</code>, or
     * <code>null</code> if unavailable.
     */ 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.815 -0500", hash_original_method = "E0B19896BEC7E8973FE5692D01506C32", hash_generated_method = "41CF6E32BE46313F3FB2C00B6918F893")
    
static private Method getInitCauseMethod() {
        try {
            Class[] paramsClasses = new Class[] { Throwable.class };
            return Throwable.class.getMethod("initCause", paramsClasses);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
    
    /** 
     * If we're running on JDK 1.4 or later, initialize the cause for the given throwable.
     * 
     * @param  throwable The throwable.
     * @param  cause     The cause of the throwable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.817 -0500", hash_original_method = "9500C77C5C6AE8093B22F8C92F23F797", hash_generated_method = "1E8C4A2053650C39451358B0C7AC5086")
    
public static void initCause(Throwable throwable, Throwable cause) {
        if (INIT_CAUSE_METHOD != null) {
            try {
                INIT_CAUSE_METHOD.invoke(throwable, new Object[] { cause });
            } catch (Exception e) {
                // Well, with no logging, the only option is to munch the exception
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.812 -0500", hash_original_field = "8549D60C6BFF50442E2F356E6E865681", hash_generated_field = "909CE2AC4E4D131D0ECCF0CD71A1706C")

    static private final Method INIT_CAUSE_METHOD = getInitCauseMethod();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.820 -0500", hash_original_method = "A1F3D67C211E4EC7543A3C1E27BD7049", hash_generated_method = "B702D3BB38F6042B3663A5D39DE6CA37")
    
private ExceptionUtils() {
    }
}

