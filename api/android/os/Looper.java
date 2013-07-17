package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import android.util.Printer;
import android.util.PrefixPrinter;

public class Looper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.441 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED")

    MessageQueue mQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.441 -0400", hash_original_field = "1E66AA878E170B83C94516726B34414A", hash_generated_field = "8CE20653889294789C714060A391C40F")

    Thread mThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.441 -0400", hash_original_field = "AF5E499F38EC2270F329B29BB567CB7C", hash_generated_field = "977197925E2F2B56E95713ADFFCAE82C")

    volatile boolean mRun;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.441 -0400", hash_original_field = "9214D8F5470BBAE73BF6D4EFC6F2056C", hash_generated_field = "0DDB3AFD1E93687434C7D033CB3772C9")

    private Printer mLogging = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.442 -0400", hash_original_method = "6D5C1375C6658BE56B40A9307D923CFE", hash_generated_method = "8417B18BC4C5ECFABCBA976EC6312D5F")
    private  Looper() {
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

    
    @DSModeled(DSC.SAFE)
    private synchronized static void setMainLooper(Looper looper) {
        mMainLooper = looper;
    }

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.444 -0400", hash_original_method = "46140967D8D75055A47353664A71B7EC", hash_generated_method = "3C77C8DE8680E0A60FA1F4CB39038FA7")
    public void setMessageLogging(Printer printer) {
        mLogging = printer;
        // ---------- Original Method ----------
        //mLogging = printer;
    }

    
    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.445 -0400", hash_original_method = "DF45AC1272CB819FC8F99EA49DB70F76", hash_generated_method = "E4A7AC026D5F4335230CC9E2172335E1")
    public void quit() {
        Message msg = Message.obtain();
        mQueue.enqueueMessage(msg, 0);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //mQueue.enqueueMessage(msg, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.445 -0400", hash_original_method = "10A14FF061E08E67689F0F5686D6176F", hash_generated_method = "F81026310C9298F937F336339098B71E")
    public Thread getThread() {
Thread varFA48872E2EC416027B4C49FE68CA50D2_547678282 =         mThread;
        varFA48872E2EC416027B4C49FE68CA50D2_547678282.addTaint(taint);
        return varFA48872E2EC416027B4C49FE68CA50D2_547678282;
        // ---------- Original Method ----------
        //return mThread;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.445 -0400", hash_original_method = "9CC180E1B870A467FDD64311213EECB9", hash_generated_method = "12CF6B3C95B0EF63F318C2D6C8B95A2E")
    public MessageQueue getQueue() {
MessageQueue var50E51770E0A0DA5CD7716ADC83B54E12_1462885238 =         mQueue;
        var50E51770E0A0DA5CD7716ADC83B54E12_1462885238.addTaint(taint);
        return var50E51770E0A0DA5CD7716ADC83B54E12_1462885238;
        // ---------- Original Method ----------
        //return mQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.447 -0400", hash_original_method = "037799F5BAC1C721CA4C8E70E86373B0", hash_generated_method = "42331BFEB34968D2AF44B37B41EA3503")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        pw = PrefixPrinter.create(pw, prefix);
        pw.println(this.toString());
        pw.println("mRun=" + mRun);
        pw.println("mThread=" + mThread);
        pw.println("mQueue=" + ((mQueue != null) ? mQueue : "(null"));
        if(mQueue != null)        
        {
            synchronized
(mQueue)            {
                long now = SystemClock.uptimeMillis();
                Message msg = mQueue.mMessages;
                int n = 0;
                while
(msg != null)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.447 -0400", hash_original_method = "DF5830583BA63D2A34E75134C24AA6CB", hash_generated_method = "F372D363013C00C6EFE48BE2515B16AC")
    public String toString() {
String var1D29CD85C81BB849FC1C0ED8B418DFD9_644068193 =         "Looper{" + Integer.toHexString(System.identityHashCode(this)) + "}";
        var1D29CD85C81BB849FC1C0ED8B418DFD9_644068193.addTaint(taint);
        return var1D29CD85C81BB849FC1C0ED8B418DFD9_644068193;
        // ---------- Original Method ----------
        //return "Looper{" + Integer.toHexString(System.identityHashCode(this)) + "}";
    }

    
    public static interface Profiler {
        void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.448 -0400", hash_original_field = "18E18D5EFAF355DEA1C9304CE2C6AC27", hash_generated_field = "0F004D3C789B551E3561D24088906967")

    private static final String TAG = "Looper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.448 -0400", hash_original_field = "9DE48D4D809C0080D8E5A5A0AAC59B74", hash_generated_field = "C8930573EE1238D7A0610D567D877F21")

    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.448 -0400", hash_original_field = "EA8AA52F80B92DA4C5D3CCAB72E5E9FE", hash_generated_field = "6E4C110F69BE8DEA8DF414C174EDD200")

    private static Looper mMainLooper = null;
}

