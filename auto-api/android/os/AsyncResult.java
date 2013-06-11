package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Message;

public class AsyncResult {
    public Object userObj;
    public Throwable exception;
    public Object result;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.510 -0400", hash_original_method = "198D3897BE246B2AE096FCE067E81108", hash_generated_method = "E9B76DB41AE9BB0F79CC80F5A305E7E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.510 -0400", hash_original_method = "5FA42A6835435D19A578EB7E92901DD9", hash_generated_method = "0D23F35D6282AF4EBECB37D456B20660")
    public static AsyncResult forMessage(Message m, Object r, Throwable ex) {
        AsyncResult ret;
        ret = new AsyncResult (m.obj, r, ex);
        m.obj = ret;
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.510 -0400", hash_original_method = "B55C51475342E21944BBC277A5B7F7B5", hash_generated_method = "5FD637A1BF21F23506E3D921E389895C")
    public static AsyncResult forMessage(Message m) {
        AsyncResult ret;
        ret = new AsyncResult (m.obj, null, null);
        m.obj = ret;
        return ret;
    }

    
}


