package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.AndroidRuntimeException;
import android.util.Log;
import java.util.ArrayList;

public class MessageQueue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_field = "F0A93F453266A0E24808893EDA6F3279", hash_generated_field = "4CD2256F13C791768C1C46ADDB2DD4CF")

    Message mMessages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_field = "EECCB023985CC9B16019C860E5A15B6E", hash_generated_field = "9FB9E39B5A909D64069FF435A199CC07")

    private final ArrayList<IdleHandler> mIdleHandlers = new ArrayList<IdleHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_field = "A1A0DE92EC477644372CE069AE7B8A27", hash_generated_field = "9ECE673ABB53E3B4A3FD3EACB7D57DE3")

    private IdleHandler[] mPendingIdleHandlers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_field = "0A7C611CE1BAB08B280C8FB0CED45EC0", hash_generated_field = "8D159A051416488D8C3D9A0DE1446123")

    private boolean mQuiting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_field = "0459E5A08C15937A6515081D4871BBC5", hash_generated_field = "76FCB0C059FE9E4D676BDC9706D4EFC3")

    boolean mQuitAllowed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_field = "FAF0A23D92ADF0F321BB109C77D5A9BC", hash_generated_field = "E847C74EBFAB1303FF64CBEBF73D5F3A")

    private boolean mBlocked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "F6CBBCA427D08C52E84BEBFADDF6C4B3")

    @SuppressWarnings("unused") private int mPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.549 -0400", hash_original_method = "024946A17D31C4FE5B39BFCF4854F539", hash_generated_method = "706665B871FA624C873ACD826DBDE13E")
      MessageQueue() {
        nativeInit();
        // ---------- Original Method ----------
        //nativeInit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.550 -0400", hash_original_method = "22793401C0EAEE553460FBFE217265A2", hash_generated_method = "8042F95F79F7CE85F17E653A09698261")
    private void nativeInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.550 -0400", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "1439525E8540D7F69358452344174A0D")
    private void nativeDestroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.550 -0400", hash_original_method = "6B1221F32AD6E733E25E3C4E5A3B3304", hash_generated_method = "E68E2F879822840F7A9D106BA1192115")
    private void nativePollOnce(int ptr, int timeoutMillis) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.551 -0400", hash_original_method = "29C673C89C7A5B5047FFC8F646EEAF46", hash_generated_method = "30625EDBBCA95C5F841D5787B682A772")
    private void nativeWake(int ptr) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.551 -0400", hash_original_method = "58A601CE5384C8EEE6AAD65D97957616", hash_generated_method = "7D75B04766E0082CB589E446FDD73F76")
    public final void addIdleHandler(IdleHandler handler) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Can't add a null IdleHandler");
        } //End block
        {
            mIdleHandlers.add(handler);
        } //End block
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //if (handler == null) {
            //throw new NullPointerException("Can't add a null IdleHandler");
        //}
        //synchronized (this) {
            //mIdleHandlers.add(handler);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.552 -0400", hash_original_method = "42E54E0638259D139421664F7CE4D7BC", hash_generated_method = "0080F7420575BEE6D434ED88DAB2899A")
    public final void removeIdleHandler(IdleHandler handler) {
        {
            mIdleHandlers.remove(handler);
        } //End block
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIdleHandlers.remove(handler);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.553 -0400", hash_original_method = "BA2F30DE255200D64377C35EBFA66603", hash_generated_method = "B6181847352A89BC6D1ACDC91A76C576")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            nativeDestroy();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //nativeDestroy();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.554 -0400", hash_original_method = "FE8F633895A73ADF340290B052DEE51B", hash_generated_method = "0DEAD18817FEABC12C329BAB2AE1657C")
    final Message next() {
        Message varB4EAC82CA7396A68D541C85D26508E83_1356380453 = null; //Variable for return #1
        int pendingIdleHandlerCount = -1;
        int nextPollTimeoutMillis = 0;
        {
            {
                Binder.flushPendingCommands();
            } //End block
            nativePollOnce(mPtr, nextPollTimeoutMillis);
            {
                final long now = SystemClock.uptimeMillis();
                final Message msg = mMessages;
                {
                    final long when = msg.when;
                    {
                        mBlocked = false;
                        mMessages = msg.next;
                        msg.next = null;
                        msg.markInUse();
                        varB4EAC82CA7396A68D541C85D26508E83_1356380453 = msg;
                    } //End block
                    {
                        nextPollTimeoutMillis = (int) Math.min(when - now, Integer.MAX_VALUE);
                    } //End block
                } //End block
                {
                    nextPollTimeoutMillis = -1;
                } //End block
                {
                    pendingIdleHandlerCount = mIdleHandlers.size();
                } //End block
                {
                    mBlocked = true;
                } //End block
                {
                    mPendingIdleHandlers = new IdleHandler[Math.max(pendingIdleHandlerCount, 4)];
                } //End block
                mPendingIdleHandlers = mIdleHandlers.toArray(mPendingIdleHandlers);
            } //End block
            {
                int i = 0;
                {
                    final IdleHandler idler = mPendingIdleHandlers[i];
                    mPendingIdleHandlers[i] = null;
                    boolean keep = false;
                    try 
                    {
                        keep = idler.queueIdle();
                    } //End block
                    catch (Throwable t)
                    {
                        Log.wtf("MessageQueue", "IdleHandler threw exception", t);
                    } //End block
                    {
                        {
                            mIdleHandlers.remove(idler);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            pendingIdleHandlerCount = 0;
            nextPollTimeoutMillis = 0;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1356380453.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1356380453;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.555 -0400", hash_original_method = "396D043333DC708706987577D4517B14", hash_generated_method = "64640C5FB40E35AD58198EE3D0E58462")
    final boolean enqueueMessage(Message msg, long when) {
        {
            boolean var8167E05B49B57A861EC1DBC3D6FD01F0_1677054651 = (msg.isInUse());
            {
                if (DroidSafeAndroidRuntime.control) throw new AndroidRuntimeException(msg
                    + " This message is already in use.");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Main thread not allowed to quit");
        } //End block
        boolean needWake;
        {
            {
                RuntimeException e = new RuntimeException(
                    msg.target + " sending message to a Handler on a dead thread");
            } //End block
            {
                mQuiting = true;
            } //End block
            msg.when = when;
            Message p = mMessages;
            {
                msg.next = p;
                mMessages = msg;
                needWake = mBlocked;
            } //End block
            {
                Message prev = null;
                {
                    prev = p;
                    p = p.next;
                } //End block
                msg.next = prev.next;
                prev.next = msg;
                needWake = false;
            } //End block
        } //End block
        {
            nativeWake(mPtr);
        } //End block
        addTaint(when);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144242890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144242890;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.555 -0400", hash_original_method = "2C495FAE3014577A1BBEA9C534AF3749", hash_generated_method = "81559B25E58BFE3EA7555A273635D618")
    final boolean removeMessages(Handler h, int what, Object object,
            boolean doRemove) {
        {
            Message p = mMessages;
            boolean found = false;
            {
                found = true;
                Message n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            } //End block
            {
                Message n = p.next;
                {
                    {
                        found = true;
                        Message nn = n.next;
                        n.recycle();
                        p.next = nn;
                    } //End block
                } //End block
                p = n;
            } //End block
        } //End block
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(object.getTaint());
        addTaint(doRemove);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_318766116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_318766116;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.556 -0400", hash_original_method = "4D91148BDAD186BF2429C10F6DC32C8E", hash_generated_method = "99B2C87ADE5D1452F777ED8F06236CAB")
    final void removeMessages(Handler h, Runnable r, Object object) {
        {
            Message p = mMessages;
            {
                Message n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            } //End block
            {
                Message n = p.next;
                {
                    {
                        Message nn = n.next;
                        n.recycle();
                        p.next = nn;
                    } //End block
                } //End block
                p = n;
            } //End block
        } //End block
        addTaint(h.getTaint());
        addTaint(r.getTaint());
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.557 -0400", hash_original_method = "0BDD557AE388AA8E5DFEDF2C38C17A0C", hash_generated_method = "32725956D7599FD183F2F716702A5403")
    final void removeCallbacksAndMessages(Handler h, Object object) {
        {
            Message p = mMessages;
            {
                Message n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            } //End block
            {
                Message n = p.next;
                {
                    {
                        Message nn = n.next;
                        n.recycle();
                        p.next = nn;
                    } //End block
                } //End block
                p = n;
            } //End block
        } //End block
        addTaint(h.getTaint());
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //Message p = mMessages;
            //while (p != null && p.target == h
                    //&& (object == null || p.obj == object)) {
                //Message n = p.next;
                //mMessages = n;
                //p.recycle();
                //p = n;
            //}
            //while (p != null) {
                //Message n = p.next;
                //if (n != null) {
                    //if (n.target == h && (object == null || n.obj == object)) {
                        //Message nn = n.next;
                        //n.recycle();
                        //p.next = nn;
                        //continue;
                    //}
                //}
                //p = n;
            //}
        //}
    }

    
    public static interface IdleHandler {
        
        boolean queueIdle();
    }
    
}

