package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;

public class TemporaryBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.828 -0400", hash_original_method = "CFBF2A6774DCC5EC6A75DBF43848BEAE", hash_generated_method = "CFBF2A6774DCC5EC6A75DBF43848BEAE")
        public TemporaryBuffer ()
    {
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

    
    private static char[] sTemp = null;
}

