package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.util.ArrayUtils;






public class TemporaryBuffer {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:48.927 -0500", hash_original_method = "479CBA9FC8EA655BBDC28F01631A11FA", hash_generated_method = "66B1007AD9440A141FCEE73F59A60847")
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:48.928 -0500", hash_original_method = "071C606A3BD9E15E8A4F59CA77E0213C", hash_generated_method = "D7A996FB61E18FC691D8793A217A5412")
    public static void recycle(char[] temp) {
        if (temp.length > 1000) return;

        synchronized (TemporaryBuffer.class) {
            sTemp = temp;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:48.929 -0500", hash_original_field = "55DA4B3993779389A3DF2C10AD0407DA", hash_generated_field = "D5B55575C53803B48B8DF0B1F8C65A25")


    private static char[] sTemp = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.182 -0400", hash_original_method = "4FF062759AAFC6722B3224BBA791BE93", hash_generated_method = "4FF062759AAFC6722B3224BBA791BE93")
    public TemporaryBuffer ()
    {
        //Synthesized constructor
    }
}

