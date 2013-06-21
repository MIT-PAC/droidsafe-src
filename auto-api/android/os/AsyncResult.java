package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Message;

public class AsyncResult {
    public Object userObj;
    public Throwable exception;
    public Object result;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.307 -0400", hash_original_method = "198D3897BE246B2AE096FCE067E81108", hash_generated_method = "4371B688A7AB4E1E0E947439C732BD36")
    @DSModeled(DSC.SAFE)
    public AsyncResult(Object uo, Object r, Throwable ex) {
        dsTaint.addTaint(ex.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(uo.dsTaint);
        // ---------- Original Method ----------
        //userObj = uo;
        //result = r;
        //exception = ex;
    }

    
        public static AsyncResult forMessage(Message m, Object r, Throwable ex) {
        AsyncResult ret;
        ret = new AsyncResult (m.obj, r, ex);
        m.obj = ret;
        return ret;
    }

    
        public static AsyncResult forMessage(Message m) {
        AsyncResult ret;
        ret = new AsyncResult (m.obj, null, null);
        m.obj = ret;
        return ret;
    }

    
}

