package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;



public class AsyncResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.558 -0400", hash_original_field = "25C84ECB718C6159E9324F086F630B67", hash_generated_field = "ACC4BEB2E6BD76B8FB51D8C386A55DC8")

    public Object userObj;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.558 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "20DCDB367C6D3BBF38A6624ED17C8967")

    public Throwable exception;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.558 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "C4A6D58C2F47BA9A63392D945E9CECC1")

    public Object result;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.558 -0400", hash_original_method = "198D3897BE246B2AE096FCE067E81108", hash_generated_method = "8F6C040BA0BD8D45D2C9FD08E5B23663")
    public  AsyncResult(Object uo, Object r, Throwable ex) {
        userObj = uo;
        result = r;
        exception = ex;
        // ---------- Original Method ----------
        //userObj = uo;
        //result = r;
        //exception = ex;
    }

    
    @DSModeled(DSC.BAN)
    public static AsyncResult forMessage(Message m, Object r, Throwable ex) {
        AsyncResult ret;
        ret = new AsyncResult (m.obj, r, ex);
        m.obj = ret;
        return ret;
    }

    
    @DSModeled(DSC.BAN)
    public static AsyncResult forMessage(Message m) {
        AsyncResult ret;
        ret = new AsyncResult (m.obj, null, null);
        m.obj = ret;
        return ret;
    }

    
}

