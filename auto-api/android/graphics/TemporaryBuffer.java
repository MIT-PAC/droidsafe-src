package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class TemporaryBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.582 -0400", hash_original_method = "4FF062759AAFC6722B3224BBA791BE93", hash_generated_method = "4FF062759AAFC6722B3224BBA791BE93")
    public TemporaryBuffer ()
    {
        //Synthesized constructor
    }


        public static char[] obtain(int len) {
        char[] buf;
        synchronized (TemporaryBuffer.class) {
            buf = sTemp;
            sTemp = null;
        }
        if (buf == null || buf.length < len) {
            buf = new char[ArrayUtils.idealCharArraySize(len)];
        }
        return buf;
    }

    
        public static void recycle(char[] temp) {
        if (temp.length > 1000) return;
        synchronized (TemporaryBuffer.class) {
            sTemp = temp;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:14.586 -0400", hash_original_field = "C736DCF0716493E46DC696537C472B83", hash_generated_field = "D5B55575C53803B48B8DF0B1F8C65A25")

    private static char[] sTemp = null;
}

