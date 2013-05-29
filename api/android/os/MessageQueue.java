package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import android.util.AndroidRuntimeException;
import android.util.Log;
import java.util.ArrayList;

public class MessageQueue {
    
    Message mMessages;
    private final ArrayList<IdleHandler> mIdleHandlers = new ArrayList<IdleHandler>();
    private IdleHandler[] mPendingIdleHandlers;
    private boolean mQuiting;
    boolean mQuitAllowed = true;
    private boolean mBlocked;
    @SuppressWarnings("unused")
    private int mPtr;
    
    @DSModeled(DSC.SAFE)
    private void nativeInit(){
        //Formerly a native function
        
    }
    
    @DSModeled(DSC.SAFE)
    private void nativeDestroy(){
        //Formerly a native function
        
    }
    
    private void nativePollOnce(int ptr, int timeoutMillis){
        //Formerly a native function
        
    }
    
    private void nativeWake(int ptr){
        //Formerly a native function
        
    }
    
    public static interface IdleHandler {
        
        boolean queueIdle();
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
    
    @DSModeled(DSC.SAFE)
    MessageQueue(){
        nativeInit();
        /*
        nativeInit();
        */
    }
    
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintBoolean();

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
        return dsTaint.getTaintBoolean();

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
}

