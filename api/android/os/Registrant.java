package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;






public class Registrant {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.120 -0500", hash_original_field = "0D5560AD898CE7ED29D9B0190B0760A0", hash_generated_field = "0D5560AD898CE7ED29D9B0190B0760A0")


    WeakReference   refH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.122 -0500", hash_original_field = "6100FAC75E91CAC232945E82029A9682", hash_generated_field = "6100FAC75E91CAC232945E82029A9682")

    int             what;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.124 -0500", hash_original_field = "F7E748C8E322C0020C08D9F5DB2D53B3", hash_generated_field = "F7E748C8E322C0020C08D9F5DB2D53B3")

    Object          userObj;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.101 -0500", hash_original_method = "5F497FB9D04E2FF153E80911709BB474", hash_generated_method = "C458C9242AD7DBE97FAF4C16F6457BC3")
    
public
    Registrant(Handler h, int what, Object obj)
    {
        refH = new WeakReference(h);
        this.what = what;
        userObj = obj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.103 -0500", hash_original_method = "AD65744D6793AC8F89861EE1586F2E60", hash_generated_method = "2B408564A70391F51537D09CB9E26678")
    
public void
    clear()
    {
        refH = null;
        userObj = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.105 -0500", hash_original_method = "4409C699F4CAB16C2D504E283EFD3CDE", hash_generated_method = "1433D76FAD8D3EBAC658594309C760AA")
    
public void
    notifyRegistrant()
    {
        internalNotifyRegistrant (null, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.107 -0500", hash_original_method = "64830107363F59A49C8D9CD8F53D1153", hash_generated_method = "7DCBAA98749CFC18D1CB62AE721EF62C")
    
public void
    notifyResult(Object result)
    {
        internalNotifyRegistrant (result, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.110 -0500", hash_original_method = "3375894D9F21481D987FA847F34F65EF", hash_generated_method = "43D300A00A473B453E43F9C95DA13E57")
    
public void
    notifyException(Throwable exception)
    {
        internalNotifyRegistrant (null, exception);
    }

    /**
     * This makes a copy of @param ar
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.112 -0500", hash_original_method = "5E7A4559085AA819B0F18D8B5740229E", hash_generated_method = "A205FE0CA1DE276DC22FAF1A46E5D07B")
    
public void
    notifyRegistrant(AsyncResult ar)
    {
        internalNotifyRegistrant (ar.result, ar.exception);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.114 -0500", hash_original_method = "8E93682DAE1125F8892DB75F842EE54A", hash_generated_method = "8E93682DAE1125F8892DB75F842EE54A")
    
void
    internalNotifyRegistrant (Object result, Throwable exception)
    {
        Handler h = getHandler();

        if (h == null) {
            clear();
        } else {
            Message msg = Message.obtain();

            msg.what = what;
            
            msg.obj = new AsyncResult(userObj, result, exception);
            
            h.sendMessage(msg);
        }
    }

    /**
     * NOTE: May return null if weak reference has been collected
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.116 -0500", hash_original_method = "D348E31FC7F90016E841E35B51E50760", hash_generated_method = "179197D05CE844A3D6C07DBB8C0BCA1A")
    
public Message
    messageForRegistrant()
    {
        Handler h = getHandler();

        if (h == null) {
            clear();

            return null;
        } else {
            Message msg = h.obtainMessage();

            msg.what = what;
            msg.obj = userObj;

            return msg;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.118 -0500", hash_original_method = "7FEDB520AB82A5F00001E1B2C02807FF", hash_generated_method = "BAF4D643CA1CD68E776D5FD3B9B103E0")
    
public Handler
    getHandler()
    {
        if (refH == null)
            return null;

        return (Handler) refH.get();
    }

    
}

