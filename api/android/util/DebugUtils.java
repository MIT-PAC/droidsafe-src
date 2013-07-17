package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class DebugUtils {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.631 -0400", hash_original_method = "4AD5C036447EEE6EF322222D7F2F6DED", hash_generated_method = "40067A418DEF2AF784763164D3515C4D")
    public  DebugUtils() {
        // ---------- Original Method ----------
    }

    
    public static boolean isObjectSelected(Object object) {
        boolean match = false;
        String s = System.getenv("ANDROID_OBJECT_FILTER");
        if (s != null && s.length() > 0) {
            String[] selectors = s.split("@");
            if (object.getClass().getSimpleName().matches(selectors[0])) {
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

    
    @DSModeled(DSC.SAFE)
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

    
}

