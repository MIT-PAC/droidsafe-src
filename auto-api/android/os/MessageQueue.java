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
    Message mMessages;
    private ArrayList<IdleHandler> mIdleHandlers = new ArrayList<IdleHandler>();
    private IdleHandler[] mPendingIdleHandlers;
    private boolean mQuiting;
    boolean mQuitAllowed = true;
    private boolean mBlocked;
    @SuppressWarnings("unused") private int mPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.866 -0400", hash_original_method = "024946A17D31C4FE5B39BFCF4854F539", hash_generated_method = "706665B871FA624C873ACD826DBDE13E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     MessageQueue() {
        nativeInit();
        // ---------- Original Method ----------
        //nativeInit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.867 -0400", hash_original_method = "22793401C0EAEE553460FBFE217265A2", hash_generated_method = "8042F95F79F7CE85F17E653A09698261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.867 -0400", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "1439525E8540D7F69358452344174A0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDestroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.868 -0400", hash_original_method = "6B1221F32AD6E733E25E3C4E5A3B3304", hash_generated_method = "CD3033DF33FD53A76C428C9351C60D1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativePollOnce(int ptr, int timeoutMillis) {
        dsTaint.addTaint(timeoutMillis);
        dsTaint.addTaint(ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.868 -0400", hash_original_method = "29C673C89C7A5B5047FFC8F646EEAF46", hash_generated_method = "2350D536FDDE0937B09AFCF3999288A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeWake(int ptr) {
        dsTaint.addTaint(ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.868 -0400", hash_original_method = "58A601CE5384C8EEE6AAD65D97957616", hash_generated_method = "6B25EC7B0BDBA974747B9048D8DE2395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addIdleHandler(IdleHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Can't add a null IdleHandler");
        } //End block
        {
            mIdleHandlers.add(handler);
        } //End block
        // ---------- Original Method ----------
        //if (handler == null) {
            //throw new NullPointerException("Can't add a null IdleHandler");
        //}
        //synchronized (this) {
            //mIdleHandlers.add(handler);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.868 -0400", hash_original_method = "42E54E0638259D139421664F7CE4D7BC", hash_generated_method = "8688DDAB81F7D0AB0C857AF2B7163218")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void removeIdleHandler(IdleHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        {
            mIdleHandlers.remove(handler);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mIdleHandlers.remove(handler);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.869 -0400", hash_original_method = "BA2F30DE255200D64377C35EBFA66603", hash_generated_method = "B6181847352A89BC6D1ACDC91A76C576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.869 -0400", hash_original_method = "FE8F633895A73ADF340290B052DEE51B", hash_generated_method = "723CAE174D97B3EFE7D0E8EED3B1DA77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final Message next() {
        int pendingIdleHandlerCount;
        pendingIdleHandlerCount = -1;
        int nextPollTimeoutMillis;
        nextPollTimeoutMillis = 0;
        {
            {
                Binder.flushPendingCommands();
            } //End block
            nativePollOnce(mPtr, nextPollTimeoutMillis);
            {
                long now;
                now = SystemClock.uptimeMillis();
                Message msg;
                msg = mMessages;
                {
                    long when;
                    when = msg.when;
                    {
                        mBlocked = false;
                        mMessages = msg.next;
                        msg.next = null;
                        msg.markInUse();
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
                int i;
                i = 0;
                {
                    IdleHandler idler;
                    idler = mPendingIdleHandlers[i];
                    mPendingIdleHandlers[i] = null;
                    boolean keep;
                    keep = false;
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
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.870 -0400", hash_original_method = "396D043333DC708706987577D4517B14", hash_generated_method = "8CD05826671A912D9DFD5B4D3EF6CACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean enqueueMessage(Message msg, long when) {
        dsTaint.addTaint(when);
        dsTaint.addTaint(msg.dsTaint);
        {
            boolean var8167E05B49B57A861EC1DBC3D6FD01F0_629239074 = (msg.isInUse());
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
                RuntimeException e;
                e = new RuntimeException(
                    msg.target + " sending message to a Handler on a dead thread");
            } //End block
            {
                mQuiting = true;
            } //End block
            msg.when = when;
            Message p;
            p = mMessages;
            {
                msg.next = p;
                needWake = mBlocked;
            } //End block
            {
                Message prev;
                prev = null;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.871 -0400", hash_original_method = "2C495FAE3014577A1BBEA9C534AF3749", hash_generated_method = "4390FA461791244C927A5A521A744CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean removeMessages(Handler h, int what, Object object,
            boolean doRemove) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        dsTaint.addTaint(doRemove);
        {
            Message p;
            p = mMessages;
            boolean found;
            found = false;
            {
                found = true;
                Message n;
                n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            } //End block
            {
                Message n;
                n = p.next;
                {
                    {
                        found = true;
                        Message nn;
                        nn = n.next;
                        n.recycle();
                        p.next = nn;
                    } //End block
                } //End block
                p = n;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.871 -0400", hash_original_method = "4D91148BDAD186BF2429C10F6DC32C8E", hash_generated_method = "37C1197E6820928F775892CA5DE90855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void removeMessages(Handler h, Runnable r, Object object) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        {
            Message p;
            p = mMessages;
            {
                Message n;
                n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            } //End block
            {
                Message n;
                n = p.next;
                {
                    {
                        Message nn;
                        nn = n.next;
                        n.recycle();
                        p.next = nn;
                    } //End block
                } //End block
                p = n;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.871 -0400", hash_original_method = "0BDD557AE388AA8E5DFEDF2C38C17A0C", hash_generated_method = "59536206E123656AF0596E858827BCE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void removeCallbacksAndMessages(Handler h, Object object) {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        {
            Message p;
            p = mMessages;
            {
                Message n;
                n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            } //End block
            {
                Message n;
                n = p.next;
                {
                    {
                        Message nn;
                        nn = n.next;
                        n.recycle();
                        p.next = nn;
                    } //End block
                } //End block
                p = n;
            } //End block
        } //End block
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

