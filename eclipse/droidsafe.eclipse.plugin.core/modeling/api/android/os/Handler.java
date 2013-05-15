package android.os;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class Handler {
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	public Handler() {
		//Do Nothing
	}
	
	@DSModeled(DSC.SAFE)
	public Handler(Looper looper) {
		dsTaint.addTaint(looper);
	}
	
	@DSModeled(DSC.SAFE)
	public Looper getLooper() {
		return (Looper)dsTaint.getTaint();
	}
	
	@DSModeled(DSC.SAFE)
	public boolean sendMessageAtTime(Message msg, long uptimeMillis)
    {
        boolean sent = false;
        dsTaint.addTaint(msg); //Technically this taint occurs at the MessageQueue level, but this is sufficient (for now)
        /*
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
        */
        return sent;
    }
	
	@DSModeled(DSC.SAFE)
	public final boolean sendMessageDelayed(Message msg, long delayMillis)
    {
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
    }
	
	@DSModeled(DSC.SAFE)
	private final Message getPostMessage(Runnable r) {
		//DSFIXME:  Figure this out...
        Message m = new Message();
        m.callback = r;
        return m;
    }
	
	@DSModeled(DSC.SAFE)
	public final boolean post(Runnable r)
    {
       return  sendMessageDelayed(getPostMessage(r), 0);
    }
	
	@DSModeled(DSC.SAFE)
	public final boolean sendMessage(Message msg)
	{
	    return sendMessageDelayed(msg, 0);
	}
	
	@DSModeled(DSC.SAFE)
	public void handleMessage(Message msg) {
    }
	
	public interface Callback {
        public boolean handleMessage(Message msg);
    }
}
