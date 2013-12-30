package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class AsyncResult {

    /***************************** Class Methods *****************************/

    /** Saves and sets m.obj */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.485 -0500", hash_original_method = "5FA42A6835435D19A578EB7E92901DD9", hash_generated_method = "0D23F35D6282AF4EBECB37D456B20660")
    
public static AsyncResult 
    forMessage(Message m, Object r, Throwable ex)
    {
        AsyncResult ret;

        ret = new AsyncResult (m.obj, r, ex);

        m.obj = ret; 

        return ret;
    }

    /** Saves and sets m.obj */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.488 -0500", hash_original_method = "B55C51475342E21944BBC277A5B7F7B5", hash_generated_method = "5FD637A1BF21F23506E3D921E389895C")
    
public static AsyncResult 
    forMessage(Message m)
    {
        AsyncResult ret;

        ret = new AsyncResult (m.obj, null, null);

        m.obj = ret; 

        return ret;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.478 -0500", hash_original_field = "F7E748C8E322C0020C08D9F5DB2D53B3", hash_generated_field = "CA4C0BAFB581420A18911A65CC27CE46")


    // Expect either exception or result to be null
    public Object userObj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.480 -0500", hash_original_field = "ED6B643F1012B300A602DEA8C7E5C621", hash_generated_field = "20DCDB367C6D3BBF38A6624ED17C8967")

    public Throwable exception;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.482 -0500", hash_original_field = "BCA77D12632DFCDF9A8AEB56A649B3D3", hash_generated_field = "C4A6D58C2F47BA9A63392D945E9CECC1")

    public Object result;

    /** please note, this sets m.obj to be this */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.490 -0500", hash_original_method = "198D3897BE246B2AE096FCE067E81108", hash_generated_method = "15714F25F35000B504727D14E9A2D164")
    
public 
    AsyncResult (Object uo, Object r, Throwable ex)
    {
        userObj = uo;
        result = r;
        exception = ex;
    }

    
}

