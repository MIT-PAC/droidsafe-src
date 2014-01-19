package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.util.Log;

public class MessageQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.789 -0500", hash_original_field = "4CD2256F13C791768C1C46ADDB2DD4CF", hash_generated_field = "4CD2256F13C791768C1C46ADDB2DD4CF")

    Message mMessages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.792 -0500", hash_original_field = "D54FEA86C2A57E013115BB80D80AFF83", hash_generated_field = "9FB9E39B5A909D64069FF435A199CC07")

    private final ArrayList<IdleHandler> mIdleHandlers = new ArrayList<IdleHandler>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.794 -0500", hash_original_field = "196EA8F4FD61AF8E040EF23C4EEF177F", hash_generated_field = "9ECE673ABB53E3B4A3FD3EACB7D57DE3")

    private IdleHandler[] mPendingIdleHandlers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.796 -0500", hash_original_field = "AF7B740F1E4253B4C172BA0B0F8E8473", hash_generated_field = "8D159A051416488D8C3D9A0DE1446123")

    private boolean mQuiting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.798 -0500", hash_original_field = "76FCB0C059FE9E4D676BDC9706D4EFC3", hash_generated_field = "76FCB0C059FE9E4D676BDC9706D4EFC3")

    boolean mQuitAllowed = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.800 -0500", hash_original_field = "14FC009A68B2C76B8D4B8EEE56CE7ECC", hash_generated_field = "E847C74EBFAB1303FF64CBEBF73D5F3A")

    private boolean mBlocked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.802 -0500", hash_original_field = "42C21A18FB5976D4C67962413781C35D", hash_generated_field = "F6CBBCA427D08C52E84BEBFADDF6C4B3")

    @SuppressWarnings("unused")
    private int mPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.825 -0500", hash_original_method = "024946A17D31C4FE5B39BFCF4854F539", hash_generated_method = "024946A17D31C4FE5B39BFCF4854F539")
    
MessageQueue() {
        nativeInit();
    }
    
    private void nativeInit(){
        //Formerly a native function
    }
    
    private void nativeDestroy(){
        //Formerly a native function
    }
    
    private void nativePollOnce(int ptr, int timeoutMillis){
        //Formerly a native function
    }
    
    private void nativeWake(int ptr){
        //Formerly a native function
    }
    
    public final void addIdleHandler(IdleHandler handler){
        //throw new NullPointerException("Can't add a null IdleHandler");
        mIdleHandlers.add(handler);
        // Original method
        /*
        {
        if (handler == null) {
            throw new NullPointerException("Can't add a null IdleHandler");
        }
        synchronized (this) {
            mIdleHandlers.add(handler);
        }
    }
        */
    }
    
    public final void removeIdleHandler(IdleHandler handler){
        mIdleHandlers.remove(handler);
        // Original method
        /*
        {
        synchronized (this) {
            mIdleHandlers.remove(handler);
        }
    }
        */
    }
    
    @Override protected void finalize(){
        nativeDestroy();
        try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
		}
        // Original method
        /*
        {
        try {
            nativeDestroy();
        } finally {
            super.finalize();
        }
    }
        */
    }
    
    final Message next(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //int pendingIdleHandlerCount = -1;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        int nextPollTimeoutMillis = 0;
        Binder.flushPendingCommands();
        nativePollOnce(mPtr, nextPollTimeoutMillis);
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //final long now = SystemClock.uptimeMillis();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        final Message msg = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //final long when = msg.when;
        Log.v("MessageQueue", "Returning message: " + msg);
        msg.markInUse();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        final IdleHandler idler = mPendingIdleHandlers[0];
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //boolean keep = false;
        mIdleHandlers.remove(idler);
        return msg;  //DSFIXME:  CODE0001: Unresolved return type/value combination
        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final boolean enqueueMessage(Message msg, long when){
        //throw new AndroidRuntimeException(msg + " This message is already in use.");
        //throw new RuntimeException("Main thread not allowed to quit");
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //final boolean needWake;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //RuntimeException e = new RuntimeException( msg.target + " sending message to a Handler on a dead thread");
        //Log.w("MessageQueue", e.getMessage(), e);
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message p = mMessages;
        mMessages = msg;  //DSFIXME:  CODE0003: Field assignment should be reviewed
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message prev = null;
        nativeWake(mPtr);
        return getTaintBoolean();
        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final boolean removeMessages(Handler h, int what, Object object,
            boolean doRemove){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message p = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //boolean found = false;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message n = p.next;
        p.recycle();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message n = p.next;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message nn = n.next;
        n.recycle();
        return getTaintBoolean();
        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final void removeMessages(Handler h, Runnable r, Object object){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message p = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message n = p.next;
        p.recycle();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message n = p.next;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message nn = n.next;
        n.recycle();
        // Original method
        /* Original Method Too Long, Refer to Original Implementation */
    }
    
    final void removeCallbacksAndMessages(Handler h, Object object){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message p = mMessages;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        Message n = p.next;
        p.recycle();
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message n = p.next;
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message nn = n.next;
        n.recycle();
        // Original method
        /*
        {
        synchronized (this) {
            Message p = mMessages;
            while (p != null && p.target == h
                    && (object == null || p.obj == object)) {
                Message n = p.next;
                mMessages = n;
                p.recycle();
                p = n;
            }
            while (p != null) {
                Message n = p.next;
                if (n != null) {
                    if (n.target == h && (object == null || n.obj == object)) {
                        Message nn = n.next;
                        n.recycle();
                        p.next = nn;
                        continue;
                    }
                }
                p = n;
            }
        }
    }
        */
    }
    
    public static interface IdleHandler {
        
        boolean queueIdle();
    }
    
}

