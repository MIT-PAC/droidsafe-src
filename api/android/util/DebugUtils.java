package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;





public class DebugUtils {

    /**
     * <p>Filters objects against the <code>ANDROID_OBJECT_FILTER</code>
     * environment variable. This environment variable can filter objects
     * based on their class name and attribute values.</p>
     *
     * <p>Here is the syntax for <code>ANDROID_OBJECT_FILTER</code>:</p>
     *
     * <p><code>ClassName@attribute1=value1@attribute2=value2...</code></p>
     *
     * <p>Examples:</p>
     * <ul>
     * <li>Select TextView instances: <code>TextView</code></li>
     * <li>Select TextView instances of text "Loading" and bottom offset of 22:
     * <code>TextView@text=Loading.*@bottom=22</code></li>
     * </ul>
     *
     * <p>The class name and the values are regular expressions.</p>
     *
     * <p>This class is useful for debugging and logging purpose:</p>
     * <pre>
     * if (DEBUG) {
     *   if (DebugUtils.isObjectSelected(childView) && LOGV_ENABLED) {
     *     Log.v(TAG, "Object " + childView + " logged!");
     *   }
     * }
     * </pre>
     *
     * <p><strong>NOTE</strong>: This method is very expensive as it relies
     * heavily on regular expressions and reflection. Calls to this method
     * should always be stripped out of the release binaries and avoided
     * as much as possible in debug mode.</p>
     *
     * @param object any object to match against the ANDROID_OBJECT_FILTER
     *        environement variable
     * @return true if object is selected by the ANDROID_OBJECT_FILTER
     *         environment variable, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.259 -0500", hash_original_method = "89690390C58E88977CA907FE5A88EB05", hash_generated_method = "E3F84148E6D130EB22903A427DD6E36D")
    public static boolean isObjectSelected(Object object) {
        boolean match = false;
        String s = System.getenv("ANDROID_OBJECT_FILTER");
        if (s != null && s.length() > 0) {
            String[] selectors = s.split("@");
            // first selector == class name
            if (object.getClass().getSimpleName().matches(selectors[0])) {
                // check potential attributes
                for (int i = 1; i < selectors.length; i++) {
                    String[] pair = selectors[i].split("=");
                    Class<?> klass = object.getClass();
                    try {
                        Method declaredMethod = null;
                        Class<?> parent = klass;
                        do {
                            declaredMethod = parent.getDeclaredMethod("get" +
                                    pair[0].substring(0, 1).toUpperCase() +
                                    pair[0].substring(1),
                                    (Class[]) null);
                        } while ((parent = klass.getSuperclass()) != null &&
                                declaredMethod == null);

                        if (declaredMethod != null) {
                            Object value = declaredMethod
                                    .invoke(object, (Object[])null);
                            match |= (value != null ?
                                    value.toString() : "null").matches(pair[1]);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return match;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.260 -0500", hash_original_method = "BC1C0A6DDB905724B12A3BE1E03F80F1", hash_generated_method = "A0E49CBE1D8E6D2C12C59921D8EDC0B4")
    public static void buildShortClassTag(Object cls, StringBuilder out) {
        if (cls == null) {
            out.append("null");
        } else {
            String simpleName = cls.getClass().getSimpleName();
            if (simpleName == null || simpleName.isEmpty()) {
                simpleName = cls.getClass().getName();
                int end = simpleName.lastIndexOf('.');
                if (end > 0) {
                    simpleName = simpleName.substring(end+1);
                }
            }
            out.append(simpleName);
            out.append('{');
            out.append(Integer.toHexString(System.identityHashCode(cls)));
        }
    }
    /** @hide */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.258 -0500", hash_original_method = "4AD5C036447EEE6EF322222D7F2F6DED", hash_generated_method = "BF5454E33769117159B2FC3ECE3C6B8B")
    public DebugUtils() {}

    
}

