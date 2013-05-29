package android.os;

// Droidsafe Imports
import android.util.Printer;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Handler {
	
	private static final boolean FIND_POTENTIAL_LEAKS = false;
	private static final String TAG = "Handler";
	
	public interface Callback {
        public boolean handleMessage(Message msg);
    }
	
	public void handleMessage(Message msg){
		
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}
	
	public void dispatchMessage(Message msg){
		
		// Original method
		/*
		{
        if (msg.callback != null) {
            handleCallback(msg);
        } else {
            if (mCallback != null) {
                if (mCallback.handleMessage(msg)) {
                    return;
                }
            }
            handleMessage(msg);
        }
    }
		*/
		//Return nothing
	}
	
	@DSModeled(DSC.SAFE)
	public Handler(){
		mLooper = Looper.myLooper();
		//mQueue = mLooper.mQueue;
		mCallback = null;
		/*
		if (FIND_POTENTIAL_LEAKS) {
            final Class<? extends Handler> klass = getClass();
            if ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0) {
                Log.w(TAG, "The following Handler class should be static or leaks might occur: " +
                    klass.getCanonicalName());
            }
        }
		mLooper = Looper.myLooper();
		if (mLooper == null) {
            throw new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
        }
		mQueue = mLooper.mQueue;
		mCallback = null;
		*/
	}
	
	@DSModeled(DSC.SAFE)
	public Handler(Callback callback){
		mLooper = Looper.myLooper();
		//mQueue = mLooper.mQueue;
		mCallback = callback;
		/*
		if (FIND_POTENTIAL_LEAKS) {
            final Class<? extends Handler> klass = getClass();
            if ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0) {
                Log.w(TAG, "The following Handler class should be static or leaks might occur: " +
                    klass.getCanonicalName());
            }
        }
		mLooper = Looper.myLooper();
		if (mLooper == null) {
            throw new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
        }
		mQueue = mLooper.mQueue;
		mCallback = callback;
		*/
	}
	
	@DSModeled(DSC.SAFE)
	public Handler(Looper looper){
		mLooper = looper;
		//mQueue = looper.mQueue;
		mCallback = null;
	}
	
	@DSModeled(DSC.SAFE)
	public Handler(Looper looper, Callback callback){
		mLooper = looper;
		//mQueue = looper.mQueue;
		mCallback = callback;
	}
	
	public String getMessageName(Message message){
		
		// Original method
		/*
		{
        if (message.callback != null) {
            return message.callback.getClass().getName();
        }
        return "0x" + Integer.toHexString(message.what);
    }
		*/
		return "";
	}
	
	public final Message obtainMessage(){
		
		// Original method
		/*
		{
        return Message.obtain(this);
    }
		*/
		return null;
	}
	
	public final Message obtainMessage(int what){
		
		// Original method
		/*
		{
        return Message.obtain(this, what);
    }
		*/
		return null;
	}
	
	public final Message obtainMessage(int what, Object obj){
		
		// Original method
		/*
		{
        return Message.obtain(this, what, obj);
    }
		*/
		return null;
	}
	
	public final Message obtainMessage(int what, int arg1, int arg2){
		
		// Original method
		/*
		{
        return Message.obtain(this, what, arg1, arg2);
    }
		*/
		return null;
	}
	
	public final Message obtainMessage(int what, int arg1, int arg2, Object obj){
		
		// Original method
		/*
		{
        return Message.obtain(this, what, arg1, arg2, obj);
    }
		*/
		return null;
	}
	
	@DSModeled(DSC.SAFE)
	public final boolean post(Runnable r){
		
		// Original method
		/*
		{
       return  sendMessageDelayed(getPostMessage(r), 0);
    }
		*/
       return  sendMessageDelayed(getPostMessage(r), 0);
	}
	
	public final boolean postAtTime(Runnable r, long uptimeMillis){
		
		// Original method
		/*
		{
        return sendMessageAtTime(getPostMessage(r), uptimeMillis);
    }
		*/
		return false;
	}
	
	public final boolean postAtTime(Runnable r, Object token, long uptimeMillis){
		
		// Original method
		/*
		{
        return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
    }
		*/
		return false;
	}
	
	public final boolean postDelayed(Runnable r, long delayMillis){
		
		// Original method
		/*
		{
        return sendMessageDelayed(getPostMessage(r), delayMillis);
    }
		*/
		return false;
	}
	
	public final boolean postAtFrontOfQueue(Runnable r){
		
		// Original method
		/*
		{
        return sendMessageAtFrontOfQueue(getPostMessage(r));
    }
		*/
		return false;
	}
	
	public final void removeCallbacks(Runnable r){
		
		// Original method
		/*
		{
        mQueue.removeMessages(this, r, null);
    }
		*/
		//Return nothing
	}
	
	public final void removeCallbacks(Runnable r, Object token){
		
		// Original method
		/*
		{
        mQueue.removeMessages(this, r, token);
    }
		*/
		//Return nothing
	}
	
	@DSModeled(DSC.SAFE)
	public final boolean sendMessage(Message msg){
		
		// Original method
		/*
		{
        return sendMessageDelayed(msg, 0);
    }
		*/
        return sendMessageDelayed(msg, 0);
	}
	
	@DSModeled(DSC.SAFE)
	public final boolean sendEmptyMessage(int what){
		
		// Original method
		/*
		{
        return sendEmptyMessageDelayed(what, 0);
    }
		*/
        return sendEmptyMessageDelayed(what, 0);
	}
	
	@DSModeled(DSC.SAFE)
	public final boolean sendEmptyMessageDelayed(int what, long delayMillis){
		
		// Original method
		/*
		{
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageDelayed(msg, delayMillis);
    }
		*/
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageDelayed(msg, delayMillis);
	}
	
	@DSModeled(DSC.SAFE)
	public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis){
		
		// Original method
		/*
		{
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageAtTime(msg, uptimeMillis);
    }
		*/
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageAtTime(msg, uptimeMillis);
	}
	
	@DSModeled(DSC.SAFE)
	public final boolean sendMessageDelayed(Message msg, long delayMillis){
		
		// Original method
		/*
		{
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
    }
		*/
        return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
	}
	
	@DSModeled(DSC.SAFE)
	public boolean sendMessageAtTime(Message msg, long uptimeMillis){
		
		// Original method
		/*
		{
        boolean sent = false;
        MessageQueue queue = mQueue;
        if (queue != null) {
            msg.target = this;
            sent = queue.enqueueMessage(msg, uptimeMillis);
        }
        else {
            RuntimeException e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
            Log.w("Looper", e.getMessage(), e);
        }
        return sent;
    }
		*/
		// DSModeled - "sending" message without need for MessageQueue by calling handler directly.
		dsTaint.addTaint(uptimeMillis);
		msg.callback.run();
		return true;
	}
	
	public final boolean sendMessageAtFrontOfQueue(Message msg){
		
		// Original method
		/*
		{
        boolean sent = false;
        MessageQueue queue = mQueue;
        if (queue != null) {
            msg.target = this;
            sent = queue.enqueueMessage(msg, 0);
        }
        else {
            RuntimeException e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
            Log.w("Looper", e.getMessage(), e);
        }
        return sent;
    }
		*/
		return false;
	}
	
	public final void removeMessages(int what){
		
		// Original method
		/*
		{
        mQueue.removeMessages(this, what, null, true);
    }
		*/
		//Return nothing
	}
	
	public final void removeMessages(int what, Object object){
		
		// Original method
		/*
		{
        mQueue.removeMessages(this, what, object, true);
    }
		*/
		//Return nothing
	}
	
	public final void removeCallbacksAndMessages(Object token){
		
		// Original method
		/*
		{
        mQueue.removeCallbacksAndMessages(this, token);
    }
		*/
		//Return nothing
	}
	
	public final boolean hasMessages(int what){
		
		// Original method
		/*
		{
        return mQueue.removeMessages(this, what, null, false);
    }
		*/
		return false;
	}
	
	public final boolean hasMessages(int what, Object object){
		
		// Original method
		/*
		{
        return mQueue.removeMessages(this, what, object, false);
    }
		*/
		return false;
	}
	
	@DSModeled(DSC.SAFE)
	public final Looper getLooper(){
		
		// Original method
		/*
		{
        return mLooper;
    }
		*/
		return mLooper;
	}
	
	public final void dump(Printer pw, String prefix){
		
		// Original method
		/*
		{
        pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        if (mLooper == null) {
            pw.println(prefix + "looper uninitialized");
        } else {
            mLooper.dump(pw, prefix + "  ");
        }
    }
		*/
		//Return nothing
	}
	
	@Override public String toString(){
		
		// Original method
		/*
		{
        return "Handler (" + getClass().getName() + ") {"
        + Integer.toHexString(System.identityHashCode(this))
        + "}";
    }
		*/
		return "";
	}
	
	final IMessenger getIMessenger(){
		
		// Original method
		/*
		{
        synchronized (mQueue) {
            if (mMessenger != null) {
                return mMessenger;
            }
            mMessenger = new MessengerImpl();
            return mMessenger;
        }
    }
		*/
		return null;
	}
	
	/*
	private final class MessengerImpl extends IMessenger.Stub {
		
		
		public void send(Message msg){
			
			// Original method
			//
			//{
            //Handler.this.sendMessage(msg);
        //}
			//
			//Return nothing
		}
	}
	*/
	
	@DSModeled(DSC.SAFE)
	private final Message getPostMessage(Runnable r) {
        Message m = new Message();
        m.callback = r;
        return m;
    }
	
	//final MessageQueue mQueue;
	final Looper mLooper;
	final Callback mCallback;
	IMessenger mMessenger;
}

