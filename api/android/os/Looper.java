package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.util.Printer;



public class Looper {
    final MessageQueue mQueue;
    final Thread mThread;
    volatile boolean mRun;
    private Printer mLogging = null;
    
    @DSModeled(DSC.BAN)
    private Looper(){
        mQueue = new MessageQueue();
        mRun = true;
        mThread = Thread.currentThread();
    }

    
    @DSModeled(DSC.SAFE)
    public static void prepare() {
    	/*
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        static }
        sThreadLocal.set(new Looper());
        */
    }

    
    public static void prepareMainLooper() {
        prepare();
        setMainLooper(myLooper());
       // myLooper().mQueue.mQuitAllowed = false;
    }

    
    @DSModeled(DSC.BAN)
    private synchronized static void setMainLooper(Looper looper) {
        mMainLooper = looper;
    }

    
    @DSModeled(DSC.SAFE)
    public synchronized static Looper getMainLooper() {
        return mMainLooper;
    }

    
    @DSModeled(DSC.SAFE)
    public static void loop() {
        Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        MessageQueue queue = me.mQueue;
        Binder.clearCallingIdentity();
        long ident = Binder.clearCallingIdentity();
        Message msg = queue.next(); 
        msg.target.dispatchMessage(msg);
        long newIdent = Binder.clearCallingIdentity();
            msg.recycle();
    }

    
    @DSModeled(DSC.SAFE)
    public static Looper myLooper() {
        return mLocalLooper;
    }

    
    @DSModeled(DSC.SAFE)
    public void setMessageLogging(Printer printer){
        mLogging = printer;  //DSFIXME:  CODE0003: Field assignment should be reviewed
        // Original method
        /*
        {
        mLogging = printer;
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    
    @DSModeled(DSC.SAFE)
    public void quit(){
        //DSFIXME:  CODE0004: Local variable requires review, uncomment if needed
        //Message msg = Message.obtain();
        //mQueue.enqueueMessage(msg, 0);
        // Original method
        /*
        {
        Message msg = Message.obtain();
        mQueue.enqueueMessage(msg, 0);
    }
        */
    }

    
    @DSModeled(DSC.SAFE)
    public Thread getThread(){
        return mThread;  //DSFIXME:  CODE0001: Unresolved return type/value combination
        // Original method
        /*
        {
        return mThread;
    }
        */
    }

    
    @DSModeled(DSC.BAN)
    public MessageQueue getQueue(){
        return mQueue;  //DSFIXME:  CODE0001: Unresolved return type/value combination
    }

    
    public void dump(Printer pw, String prefix){
    }

    
    public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }

    
    public static interface Profiler {
        void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime);
    }
    
    private static final String TAG = "Looper";
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    private static Looper mMainLooper = null;
    // orphaned legacy field
    private static Looper mLocalLooper = new Looper();
    
}

