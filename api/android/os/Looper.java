package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.util.Printer;

public class Looper {
    
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.964 -0500", hash_original_method = "A88F24E81953AAC82D589D0EE00658ED", hash_generated_method = "1381AB89A6859F6920A51959D9AA4219")
    
private synchronized static void setMainLooper(Looper looper) {
        mMainLooper = looper;
    }

    /** Returns the application's main looper, which lives in the main thread of the application.
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.966 -0500", hash_original_method = "B301D14AF486D9D7134940A0F1BF13CF", hash_generated_method = "7397F1AB5AB47E75F37A7B7BE4B27DD9")
    
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
        long ident = Binder.clearCallingIdentity();
        Message msg = queue.next(); 
        msg.target.dispatchMessage(msg);
        long newIdent = Binder.clearCallingIdentity();
            msg.recycle();
    }
    
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    public static Looper myLooper() {
        return mLocalLooper;
    }
    
    /**
     * Return the {@link MessageQueue} object associated with the current
     * thread.  This must be called from a thread running a Looper, or a
     * NullPointerException will be thrown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.976 -0500", hash_original_method = "ACC1C28EC41DEC1A5523C89FE52F40AA", hash_generated_method = "6C55D997BEE358DAFBC9B70CDEA32257")
    
public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.943 -0500", hash_original_field = "44A9E78527E9E711DAE89B731B57800D", hash_generated_field = "0F004D3C789B551E3561D24088906967")

    private static final String TAG = "Looper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.946 -0500", hash_original_field = "257AB4BB76156C7B57A50BF0AB76445D", hash_generated_field = "C8930573EE1238D7A0610D567D877F21")

    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.956 -0500", hash_original_field = "E9D88853247AFDE4417B5EB2734F2C26", hash_generated_field = "6E4C110F69BE8DEA8DF414C174EDD200")

    private static Looper mMainLooper = null;
    // orphaned legacy field
    private static Looper mLocalLooper = new Looper();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.948 -0500", hash_original_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED", hash_generated_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED")

     MessageQueue mQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.950 -0500", hash_original_field = "8CE20653889294789C714060A391C40F", hash_generated_field = "8CE20653889294789C714060A391C40F")

     Thread mThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.952 -0500", hash_original_field = "867A8DAE706CDC88DBDB8C72C9054E2B", hash_generated_field = "977197925E2F2B56E95713ADFFCAE82C")

    volatile boolean mRun;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.954 -0500", hash_original_field = "2EC3375BAD17E0646ECDA14E2CF7DFDD", hash_generated_field = "0DDB3AFD1E93687434C7D033CB3772C9")

    private Printer mLogging = null;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.979 -0500", hash_original_method = "6D5C1375C6658BE56B40A9307D923CFE", hash_generated_method = "3C72C2D742FF74AE9DC766728DBC3719")
    
private Looper() {
        mQueue = new MessageQueue();
        mRun = true;
        mThread = Thread.currentThread();
    }

    /**
     * Control logging of messages as they are processed by this Looper.  If
     * enabled, a log message will be written to <var>printer</var> 
     * at the beginning and ending of each message dispatch, identifying the
     * target Handler and message contents.
     * 
     * @param printer A Printer object that will receive log messages, or
     * null to disable message logging.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.974 -0500", hash_original_method = "46140967D8D75055A47353664A71B7EC", hash_generated_method = "7E14E4115E59A219565E5F07139FB82A")
    
public void setMessageLogging(Printer printer) {
        mLogging = printer;
    }
    
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
    
    public static interface Profiler {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime);
    }

    /**
     * Return the Thread associated with this Looper.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.983 -0500", hash_original_method = "10A14FF061E08E67689F0F5686D6176F", hash_generated_method = "D402F1CFC3CD0CBF03882696518D38AC")
    
public Thread getThread() {
        return mThread;
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:29.984 -0500", hash_original_method = "9CC180E1B870A467FDD64311213EECB9", hash_generated_method = "00329067F61FEEBF263D62E8B22EAD26")
    
public MessageQueue getQueue() {
        return mQueue;
    }
    
    public void dump(Printer pw, String prefix){
    }
    
    public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }
    
}

