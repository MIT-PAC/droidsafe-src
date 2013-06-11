package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;
import android.util.Printer;
import android.util.PrefixPrinter;

public class Looper {
    private static final String TAG = "Looper";
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    final MessageQueue mQueue;
    final Thread mThread;
    volatile boolean mRun;
    private Printer mLogging = null;
    private static Looper mMainLooper = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.661 -0400", hash_original_method = "6D5C1375C6658BE56B40A9307D923CFE", hash_generated_method = "4ED72B01D9BE59156EBA97F356C8DD5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.661 -0400", hash_original_method = "FEBBB23996A64D1E1BC98572B1E7EBEA", hash_generated_method = "EF8043A779566FE44EC46C0233E35161")
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.661 -0400", hash_original_method = "A7C6E57A4F53A42AAF36561368965324", hash_generated_method = "8CCB9E9EC7017C451B551C6307805B5A")
    public static void prepareMainLooper() {
        prepare();
        setMainLooper(myLooper());
        myLooper().mQueue.mQuitAllowed = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.661 -0400", hash_original_method = "A88F24E81953AAC82D589D0EE00658ED", hash_generated_method = "1381AB89A6859F6920A51959D9AA4219")
    private synchronized static void setMainLooper(Looper looper) {
        mMainLooper = looper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.661 -0400", hash_original_method = "B301D14AF486D9D7134940A0F1BF13CF", hash_generated_method = "7397F1AB5AB47E75F37A7B7BE4B27DD9")
    public synchronized static Looper getMainLooper() {
        return mMainLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.662 -0400", hash_original_method = "BC3F82B82615C9B680A8D34DEA2FA18E", hash_generated_method = "CA9BC74D829F88609B7EE77E3A661BC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.662 -0400", hash_original_method = "258BB7B71BF16BC5E9C152CF504A6574", hash_generated_method = "EB636884A1188B4F7AC6C15671DD925C")
    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.662 -0400", hash_original_method = "46140967D8D75055A47353664A71B7EC", hash_generated_method = "E115E9274EEFDFBE4856CD1F40802D0D")
    @DSModeled(DSC.SAFE)
    public void setMessageLogging(Printer printer) {
        dsTaint.addTaint(printer.dsTaint);
        // ---------- Original Method ----------
        //mLogging = printer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.662 -0400", hash_original_method = "ACC1C28EC41DEC1A5523C89FE52F40AA", hash_generated_method = "6C55D997BEE358DAFBC9B70CDEA32257")
    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.662 -0400", hash_original_method = "DF45AC1272CB819FC8F99EA49DB70F76", hash_generated_method = "7A9D173914F8B86C0BD27350FA09DCA2")
    @DSModeled(DSC.SAFE)
    public void quit() {
        Message msg;
        msg = Message.obtain();
        mQueue.enqueueMessage(msg, 0);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //mQueue.enqueueMessage(msg, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.662 -0400", hash_original_method = "10A14FF061E08E67689F0F5686D6176F", hash_generated_method = "069D189EA51ADAFC1CD5933FA0048E38")
    @DSModeled(DSC.SAFE)
    public Thread getThread() {
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mThread;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.662 -0400", hash_original_method = "9CC180E1B870A467FDD64311213EECB9", hash_generated_method = "6B521FB887239F84565A6260AC06F795")
    @DSModeled(DSC.SAFE)
    public MessageQueue getQueue() {
        return (MessageQueue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.663 -0400", hash_original_method = "037799F5BAC1C721CA4C8E70E86373B0", hash_generated_method = "E64BC1BD1C0F6DFDA5E7AE29F18734E3")
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
                    n++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.663 -0400", hash_original_method = "DF5830583BA63D2A34E75134C24AA6CB", hash_generated_method = "DD3F8730099EE00B86BFA310E9169D1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var684BBBCBD0AACF70A1C75FDFB525AA63_21747230 = ("Looper{" + Integer.toHexString(System.identityHashCode(this)) + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Looper{" + Integer.toHexString(System.identityHashCode(this)) + "}";
    }

    
    public static interface Profiler {
        void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime);
    }
    
}


