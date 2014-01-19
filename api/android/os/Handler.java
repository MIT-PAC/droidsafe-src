package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.util.Printer;

public class Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.007 -0500", hash_original_field = "EF077B080E17BA8045DEC02712518733", hash_generated_field = "0511AC5400F6AB0B4374BEAACA5C07BE")

    private static final boolean FIND_POTENTIAL_LEAKS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.009 -0500", hash_original_field = "104D1D0D252AE2A79C970B6831381C21", hash_generated_field = "BFB213888655CBD96A5FA5BA90716E2A")

    private static final String TAG = "Handler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.106 -0500", hash_original_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED", hash_generated_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED")

     MessageQueue mQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.108 -0500", hash_original_field = "4C6A73D1D5351706C43659B423CF9288", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

     Looper mLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.111 -0500", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

     Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.113 -0500", hash_original_field = "35095A7AFB955F43B213705056D01A47", hash_generated_field = "35095A7AFB955F43B213705056D01A47")

    IMessenger mMessenger;
    
	@DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
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
    
	@DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    public Handler(Looper looper){
		mLooper = looper;
		//mQueue = looper.mQueue;
		mCallback = null;
	}
    
	public Handler(Looper looper, Callback callback){
		mLooper = looper;
		//mQueue = looper.mQueue;
		mCallback = callback;
	}
    
    /**
     * Subclasses must implement this to receive messages.
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.014 -0500", hash_original_method = "C13ECA453D39BD1621DCBD4764283A41", hash_generated_method = "C6FC13FE8E92DCBE16F162867E28E817")
    
public void handleMessage(Message msg) {
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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

    /**
     * Returns a new {@link android.os.Message Message} from the global message pool. More efficient than
     * creating and allocating new instances. The retrieved message has its handler set to this instance (Message.target == this).
     *  If you don't want that facility, just call Message.obtain() instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.031 -0500", hash_original_method = "3FA1D1E6850485EFDFF54C55EBFDD1CC", hash_generated_method = "D4575D4F60FCD7C3F7B83BA70194059B")
    
public final Message obtainMessage()
    {
        return Message.obtain(this);
    }
    
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    public final Message obtainMessage(int what){
		// Original method
		/*
		{
        return Message.obtain(this, what);
    }
		*/
    	addTaint(what);
    	return Message.obtain(this, what);
	}
    
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    public final Message obtainMessage(int what, Object obj){
		// Original method
		/*
		{
        return Message.obtain(this, what, obj);
    }
		*/
    	addTaint(what);
    	addTaint(obj.getTaint());
    	return Message.obtain(this, what, obj);
	}
    
    public final Message obtainMessage(int what, int arg1, int arg2){
		// Original method
		/*
		{
        return Message.obtain(this, what, arg1, arg2);
    }
		*/
    	addTaint(what);
    	addTaint(arg1);
    	addTaint(arg2);
    	return Message.obtain(this, what, arg1, arg2);
	}
    
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj){
		// Original method
		/*
		{
        return Message.obtain(this, what, arg1, arg2, obj);
    }
		*/
    	addTaint(what);
    	addTaint(arg1);
    	addTaint(arg2);
    	addTaint(obj.getTaint());
    	return Message.obtain(this, what, arg1, arg2, obj);
	}
    
	@DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    public final boolean post(Runnable r){
		// Original method
		/*
		{
       return  sendMessageDelayed(getPostMessage(r), 0);
    }
		*/
    	addTaint(r.getTaint());
       return  sendMessageDelayed(getPostMessage(r), 0);
	}
    
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    public final boolean postAtTime(Runnable r, long uptimeMillis){
		// Original method
		/*
		{
        return sendMessageAtTime(getPostMessage(r), uptimeMillis);
    }
		*/
    	addTaint(r.getTaint());
    	addTaint(uptimeMillis);
    	return sendMessageAtTime(getPostMessage(r), uptimeMillis);
	}
    
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis){
		// Original method
		/*
		{
        return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
    }
		*/
    	addTaint(r.getTaint());
    	addTaint(token.getTaint());
    	addTaint(uptimeMillis);
    	return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
	}
    
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    public final boolean postDelayed(Runnable r, long delayMillis){
		// Original method
		/*
		{
        return sendMessageDelayed(getPostMessage(r), delayMillis);
    }
		*/
    	addTaint(r.getTaint());
    	addTaint(delayMillis);
    	return sendMessageDelayed(getPostMessage(r), delayMillis);
	}
    
    public final boolean postAtFrontOfQueue(Runnable r){
		// Original method
		/*
		{
        return sendMessageAtFrontOfQueue(getPostMessage(r));
    }
		*/
    	addTaint(r.getTaint());
    	return sendMessageAtFrontOfQueue(getPostMessage(r));
	}
    
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    public final void removeCallbacks(Runnable r){
		// Original method
		/*
		{
        mQueue.removeMessages(this, r, null);
    }
		*/
		//Return nothing
    	addTaint(r.getTaint());
    	mQueue.removeMessages(this, r, null);
	}
    
    public final void removeCallbacks(Runnable r, Object token){
		// Original method
		/*
		{
        mQueue.removeMessages(this, r, token);
    }
		*/
		//Return nothing
    	addTaint(r.getTaint());
    	addTaint(token.getTaint());
    	mQueue.removeMessages(this, r, token);
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final boolean sendMessage(Message msg){
		// Original method
		/*
		{
        return sendMessageDelayed(msg, 0);
    }
		*/
    	addTaint(msg.getTaint());
        return sendMessageDelayed(msg, 0);
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final boolean sendEmptyMessage(int what){
		// Original method
		/*
		{
        return sendEmptyMessageDelayed(what, 0);
    }
		*/
    	addTaint(what);
        return sendEmptyMessageDelayed(what, 0);
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis){
		// Original method
		/*
		{
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageDelayed(msg, delayMillis);
    }
		*/
    	addTaint(what);
    	addTaint(delayMillis);
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageDelayed(msg, delayMillis);
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis){
		// Original method
		/*
		{
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageAtTime(msg, uptimeMillis);
    }
		*/
    	addTaint(what);
    	addTaint(uptimeMillis);
        Message msg = Message.obtain();
        msg.what = what;
        return sendMessageAtTime(msg, uptimeMillis);
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    	addTaint(msg.getTaint());
    	addTaint(delayMillis);
        return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
	}
    
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
    	addTaint(msg.getTaint());
		addTaint(uptimeMillis);
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
    	addTaint(msg.getTaint());
    	boolean sent = false;
        MessageQueue queue = mQueue;
        if (queue != null) {
            msg.target = this;
            sent = queue.enqueueMessage(msg, 0);
        }
        else {
            RuntimeException e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
        }
		return getTaintBoolean();
	}
    
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    public final void removeMessages(int what){
		// Original method
		/*
		{
        mQueue.removeMessages(this, what, null, true);
    }
		*/
		//Return nothing
    	addTaint(what);
    	mQueue.removeMessages(this, what, null, true);
	}
    
    public final void removeMessages(int what, Object object){
		// Original method
		/*
		{
        mQueue.removeMessages(this, what, object, true);
    }
		*/
		//Return nothing
    	addTaint(what);
    	addTaint(object.getTaint());
    	mQueue.removeMessages(this, what, object, true);
	}
    
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    public final void removeCallbacksAndMessages(Object token){
		// Original method
		/*
		{
        mQueue.removeCallbacksAndMessages(this, token);
    }
		*/
		//Return nothing
    	addTaint(token.getTaint());
    	mQueue.removeCallbacksAndMessages(this, token);
	}
    
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    public final boolean hasMessages(int what){
		// Original method
		/*
		{
        return mQueue.removeMessages(this, what, null, false);
    }
		*/
    	mQueue.removeMessages(this, what, null, false);
		return getTaintBoolean();
	}
    
    public final boolean hasMessages(int what, Object object){
		// Original method
		/*
		{
        return mQueue.removeMessages(this, what, object, false);
    }
		*/
    	mQueue.removeMessages(this, what, object, false);
		return getTaintBoolean();
	}

    // if we can get rid of this method, the handler need not remember its loop
    // we could instead export a getMessageQueue() method... 
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.087 -0500", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "98064444349E07D7BAA3C9B4FAC15DC7")
    
public final Looper getLooper() {
        return mLooper;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    	addTaint(pw.getTaint());
    	addTaint(prefix.getTaint());
    	pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        if (mLooper == null) {
            pw.println(prefix + "looper uninitialized");
        } else {
            mLooper.dump(pw, prefix + "  ");
        }
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
    	String retVal = "Handler (" + getClass().getName() + ") {"
    	        + Integer.toHexString(System.identityHashCode(this))
    	        + "}";
    	retVal.addTaint(getTaint());
		return retVal;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    	IMessenger retVal;
    	synchronized (mQueue) {
            if (mMessenger != null) {
                retVal = mMessenger;
            }
            mMessenger = new MessengerImpl();
            retVal = mMessenger;
        }
    	retVal.addTaint(getTaint());
    	return retVal;
	}
    
	private final Message getPostMessage(Runnable r) {
    	addTaint(r.getTaint());
        Message m = new Message();
        m.callback = r;
        m.addTaint(getTaint());
        return m;
    }
    
    private final class MessengerImpl extends IMessenger.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.985 -0400", hash_original_method = "68A768E132C1125DE9510AF39EB42EE7", hash_generated_method = "68A768E132C1125DE9510AF39EB42EE7")
        public MessengerImpl ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.097 -0500", hash_original_method = "CF11BADC884B068E4FC98150B23E5EB1", hash_generated_method = "F786300E27C986F542B94E2D484AD33A")
        
public void send(Message msg) {
            Handler.this.sendMessage(msg);
        }
        
    }
    
    public interface Callback {
        public boolean handleMessage(Message msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.102 -0500", hash_original_method = "001850E10F072AF670657F2F37A16A9C", hash_generated_method = "A5974E73A9C80C82DFA1C17347E03874")
    
private final Message getPostMessage(Runnable r, Object token) {
        Message m = Message.obtain();
        m.obj = token;
        m.callback = r;
        return m;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.104 -0500", hash_original_method = "6CA31B63D4772009E291A8EEE8116A2F", hash_generated_method = "AD0BE4CB06C28D91482679A28DE4CCB6")
    
private final void handleCallback(Message message) {
        message.callback.run();
    }
}

