package android.support.v4.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DebugUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.030 -0400", hash_original_method = "09D0F8538A2479079AB46637D5733AC2", hash_generated_method = "09D0F8538A2479079AB46637D5733AC2")
    public DebugUtils ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static void buildShortClassTag(Object cls, StringBuilder out) {
        if (cls == null) {
            out.append("null");
        } else {
            String simpleName = cls.getClass().getSimpleName();
            if (simpleName == null || simpleName.length() <= 0) {
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

