package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TimeUtils;

public final class Message implements Parcelable {
	public int what;
	public int arg1;
	public int arg2;
	public Object obj;
	public Messenger replyTo;
	static final int FLAG_IN_USE = 1;
	static final int FLAGS_RESERVED = ~FLAG_IN_USE;
	static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAGS_RESERVED | FLAG_IN_USE;
	int flags;
	long when;
	Bundle data;
	Handler target;
	Runnable callback;
	Message next;
	private static final Object sPoolSync = new Object();
	private static Message sPool;
	private static int sPoolSize = 0;
	private static final int MAX_POOL_SIZE = 10;
	
	public static Message obtain(){
		
		// Original method
		/*
		{
        synchronized (sPoolSync) {
            if (sPool != null) {
                Message m = sPool;
                sPool = m.next;
                m.next = null;
                sPoolSize--;
                return m;
            }
        }
        return new Message();
    }
		*/
        return new Message();
	}
	
	@DSModeled(DSC.SAFE)
	public static Message obtain(Message orig){
		
		// Original method
        Message m = obtain();
        m.what = orig.what;
        m.arg1 = orig.arg1;
        m.arg2 = orig.arg2;
        m.obj = orig.obj;
        m.replyTo = orig.replyTo;
        if (orig.data != null) {
            m.data = new Bundle(orig.data);
        }
        m.target = orig.target;
        m.callback = orig.callback;

        return m;
	}
	
	@DSModeled(DSC.SAFE)
	public static Message obtain(Handler h){
		
		// Original method
        Message m = obtain();
        m.target = h;

        return m;
	}
	
	@DSModeled(DSC.SAFE)
	public static Message obtain(Handler h, Runnable callback){
		
		// Original method
        Message m = obtain();
        m.target = h;
        m.callback = callback;

        return m;
	}
	
	@DSModeled(DSC.SAFE)
	public static Message obtain(Handler h, int what){
		
		// Original method
        Message m = obtain();
        m.target = h;
        m.what = what;

        return m;
	}
	
	@DSModeled(DSC.SAFE)
	public static Message obtain(Handler h, int what, Object obj){
		
		// Original method
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.obj = obj;

        return m;
	}
	
	@DSModeled(DSC.SAFE)
	public static Message obtain(Handler h, int what, int arg1, int arg2){
		
		// Original method
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;

        return m;
	}
	
	@DSModeled(DSC.SAFE)
	public static Message obtain(Handler h, int what, 
            int arg1, int arg2, Object obj){
		
		// Original method
        Message m = obtain();
        m.target = h;
        m.what = what;
        m.arg1 = arg1;
        m.arg2 = arg2;
        m.obj = obj;

		return null;
	}
	
	public void recycle(){
		
		// Original method
		/*
		{
        clearForRecycle();

        synchronized (sPoolSync) {
            if (sPoolSize < MAX_POOL_SIZE) {
                next = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }
		*/
		//Return nothing
	}
	
	@DSModeled(DSC.SAFE)
	public void copyFrom(Message o){
		
		// Original method
        this.flags = o.flags & ~FLAGS_TO_CLEAR_ON_COPY_FROM;
        this.what = o.what;
        this.arg1 = o.arg1;
        this.arg2 = o.arg2;
        this.obj = o.obj;
        this.replyTo = o.replyTo;

        if (o.data != null) {
            this.data = (Bundle) o.data.clone();
        } else {
            this.data = null;
        }
	}
	
	@DSModeled(DSC.SAFE)
	public long getWhen(){
        return when;
	}
	
	@DSModeled(DSC.SAFE)
	public void setTarget(Handler target){
        this.target = target;
	}
	
	@DSModeled(DSC.SAFE)
	public Handler getTarget(){
        return target;
	}
	
	@DSModeled(DSC.SAFE)
	public Runnable getCallback(){
        return callback;
	}
	
	@DSModeled(DSC.SAFE)
	public Bundle getData(){
        return data = new Bundle();
	}
	
	@DSModeled(DSC.SAFE)
	public Bundle peekData(){
        return data;
	}
	
	@DSModeled(DSC.SAFE)
	public void setData(Bundle data){
        this.data = data;
	}
	
	@DSModeled(DSC.SAFE)
	public void sendToTarget(){
        target.sendMessage(this);
	}
	
	void clearForRecycle(){
		
		// Original method
		/*
		{
        flags = 0;
        what = 0;
        arg1 = 0;
        arg2 = 0;
        obj = null;
        replyTo = null;
        when = 0;
        target = null;
        callback = null;
        data = null;
    }
		*/
		//Return nothing
	}
	
	boolean isInUse(){
		
		// Original method
		/*
		{
        return ((flags & FLAG_IN_USE) == FLAG_IN_USE);
    }
		*/
		return false;
	}
	
	void markInUse(){
		
		// Original method
		/*
		{
        flags |= FLAG_IN_USE;
    }
		*/
		//Return nothing
	}
	
	public Message(){
	}
	
	public String toString(){
		
		// Original method
		/*
		{
        return toString(SystemClock.uptimeMillis());
    }
		*/
		return "";
	}
	
	String toString(long now){
		
		// Original method
		/*
		{
        StringBuilder   b = new StringBuilder();
        
        b.append("{ what=");
        b.append(what);

        b.append(" when=");
        TimeUtils.formatDuration(when-now, b);

        if (arg1 != 0) {
            b.append(" arg1=");
            b.append(arg1);
        }

        if (arg2 != 0) {
            b.append(" arg2=");
            b.append(arg2);
        }

        if (obj != null) {
            b.append(" obj=");
            b.append(obj);
        }

        b.append(" }");
        
        return b.toString();
    }
		*/
		return "";
	}
	public static final Parcelable.Creator<Message> CREATOR
            = new Parcelable.Creator<Message>() {
        public Message createFromParcel(Parcel source) {
            Message msg = Message.obtain();
            msg.readFromParcel(source);
            return msg;
        }
        
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
	
	public int describeContents(){
		
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}
	
	public void writeToParcel(Parcel dest, int flags){
		
		// Original method
		/*
		{
        if (callback != null) {
            throw new RuntimeException(
                "Can't marshal callbacks across processes.");
        }
        dest.writeInt(what);
        dest.writeInt(arg1);
        dest.writeInt(arg2);
        if (obj != null) {
            try {
                Parcelable p = (Parcelable)obj;
                dest.writeInt(1);
                dest.writeParcelable(p, flags);
            } catch (ClassCastException e) {
                throw new RuntimeException(
                    "Can't marshal non-Parcelable objects across processes.");
            }
        } else {
            dest.writeInt(0);
        }
        dest.writeLong(when);
        dest.writeBundle(data);
        Messenger.writeMessengerOrNullToParcel(replyTo, dest);
    }
		*/
		//Return nothing
	}
	
	private final void readFromParcel(Parcel source){
		
		// Original method
		/*
		{
        what = source.readInt();
        arg1 = source.readInt();
        arg2 = source.readInt();
        if (source.readInt() != 0) {
            obj = source.readParcelable(getClass().getClassLoader());
        }
        when = source.readLong();
        data = source.readBundle();
        replyTo = Messenger.readMessengerOrNullFromParcel(source);
    }
		*/
		//Return nothing
	}
}

