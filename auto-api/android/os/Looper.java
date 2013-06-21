package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import android.util.Printer;
import android.util.PrefixPrinter;

public class Looper {
    MessageQueue mQueue;
    Thread mThread;
    volatile boolean mRun;
    private Printer mLogging = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.675 -0400", hash_original_method = "6D5C1375C6658BE56B40A9307D923CFE", hash_generated_method = "8417B18BC4C5ECFABCBA976EC6312D5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Looper() {
        mQueue = new MessageQueue();
        mRun = true;
        mThread = Thread.currentThread();
        // ---------- Original Method ----------
        //mQueue = new MessageQueue();
        //mRun = true;
        //mThread = Thread.currentThread();
    }

    
        public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    
        public static void prepareMainLooper() {
        prepare();
        setMainLooper(myLooper());
        myLooper().mQueue.mQuitAllowed = false;
    }

    
        private synchronized static void setMainLooper(Looper looper) {
        mMainLooper = looper;
    }

    
        public synchronized static Looper getMainLooper() {
        return mMainLooper;
    }

    
        public static void loop() {
        Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        MessageQueue queue = me.mQueue;
        Binder.clearCallingIdentity();
        final long ident = Binder.clearCallingIdentity();
        while (true) {
            Message msg = queue.next(); 
            if (msg != null) {
                if (msg.target == null) {
                    return;
                }
                long wallStart = 0;
                long threadStart = 0;
                Printer logging = me.mLogging;
                if (logging != null) {
                    logging.println(">>>>> Dispatching to " + msg.target + " " +
                            msg.callback + ": " + msg.what);
                    wallStart = SystemClock.currentTimeMicro();
                    threadStart = SystemClock.currentThreadTimeMicro();
                }
                msg.target.dispatchMessage(msg);
                if (logging != null) {
                    long wallTime = SystemClock.currentTimeMicro() - wallStart;
                    long threadTime = SystemClock.currentThreadTimeMicro() - threadStart;
                    logging.println("<<<<< Finished to " + msg.target + " " + msg.callback);
                    if (logging instanceof Profiler) {
                        ((Profiler) logging).profile(msg, wallStart, wallTime,
                                threadStart, threadTime);
                    }
                }
                final long newIdent = Binder.clearCallingIdentity();
                if (ident != newIdent) {
                    Log.wtf(TAG, "Thread identity changed from 0x"
                            + Long.toHexString(ident) + " to 0x"
                            + Long.toHexString(newIdent) + " while dispatching to "
                            + msg.target.getClass().getName() + " "
                            + msg.callback + " what=" + msg.what);
                }
                msg.recycle();
            }
        }
    }

    
        public static Looper myLooper() {
        return sThreadLocal.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.676 -0400", hash_original_method = "46140967D8D75055A47353664A71B7EC", hash_generated_method = "E72A325F6A18F09FC9798EB4C39F9914")
    @DSModeled(DSC.SAFE)
    public void setMessageLogging(Printer printer) {
        dsTaint.addTaint(printer.dsTaint);
        // ---------- Original Method ----------
        //mLogging = printer;
    }

    
        public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.677 -0400", hash_original_method = "DF45AC1272CB819FC8F99EA49DB70F76", hash_generated_method = "DB51BEE36A603BA5F62762DB6D90DAF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void quit() {
        Message msg;
        msg = Message.obtain();
        mQueue.enqueueMessage(msg, 0);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //mQueue.enqueueMessage(msg, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.677 -0400", hash_original_method = "10A14FF061E08E67689F0F5686D6176F", hash_generated_method = "6BE95CFD389AE813CECF4ACB768A261F")
    @DSModeled(DSC.SAFE)
    public Thread getThread() {
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mThread;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.677 -0400", hash_original_method = "9CC180E1B870A467FDD64311213EECB9", hash_generated_method = "5625799499F1C3C5A8585C0925986D55")
    @DSModeled(DSC.SAFE)
    public MessageQueue getQueue() {
        return (MessageQueue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.678 -0400", hash_original_method = "037799F5BAC1C721CA4C8E70E86373B0", hash_generated_method = "CA946A145E2AB8DC3826B5B42747994F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        pw = PrefixPrinter.create(pw, prefix);
        pw.println(this.toString());
        pw.println("mRun=" + mRun);
        pw.println("mThread=" + mThread);
        pw.println("mQueue=" + ((mQueue != null) ? mQueue : "(null"));
        {
            {
                long now;
                now = SystemClock.uptimeMillis();
                Message msg;
                msg = mQueue.mMessages;
                int n;
                n = 0;
                {
                    pw.println("  Message " + n + ": " + msg.toString(now));
                    msg = msg.next;
                } //End block
                pw.println("(Total messages: " + n + ")");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //pw = PrefixPrinter.create(pw, prefix);
        //pw.println(this.toString());
        //pw.println("mRun=" + mRun);
        //pw.println("mThread=" + mThread);
        //pw.println("mQueue=" + ((mQueue != null) ? mQueue : "(null"));
        //if (mQueue != null) {
            //synchronized (mQueue) {
                //long now = SystemClock.uptimeMillis();
                //Message msg = mQueue.mMessages;
                //int n = 0;
                //while (msg != null) {
                    //pw.println("  Message " + n + ": " + msg.toString(now));
                    //n++;
                    //msg = msg.next;
                //}
                //pw.println("(Total messages: " + n + ")");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.678 -0400", hash_original_method = "DF5830583BA63D2A34E75134C24AA6CB", hash_generated_method = "06F7649ABFABF14C61B7AF276CBC6977")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var684BBBCBD0AACF70A1C75FDFB525AA63_1093242384 = ("Looper{" + Integer.toHexString(System.identityHashCode(this)) + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Looper{" + Integer.toHexString(System.identityHashCode(this)) + "}";
    }

    
    public static interface Profiler {
        void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime);
    }
    
    private static final String TAG = "Looper";
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    private static Looper mMainLooper = null;
}

