package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {

    /** @hide Used to force static handler to be created. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.236 -0500", hash_original_method = "85B7E9920F04AD03DB055D36153974ED", hash_generated_method = "8717D9EFB6DC73C1619EB6E1EBC30550")
    
public static void init() {
        sHandler.getLooper();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.239 -0500", hash_original_method = "B027C147EDCD8E49898D40178E159A21", hash_generated_method = "58070820B0D447663D6A5F11B97A69F4")
    @DSVerified
    @DSSafe(DSCat.OS_GENERAL)  
public static void setDefaultExecutor(Executor exec) {
        sDefaultExecutor = exec;
    }
    
    @DSVerified
    @DSSafe(DSCat.OS_GENERAL)  
    public static void execute(Runnable runnable) {
    	runnable.run();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.175 -0500", hash_original_field = "528CFAB5DE877B703E7DACCBAA67819D", hash_generated_field = "1621B971276E6C94E07DE79B5D168C87")

    private static final String LOG_TAG = "AsyncTask";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.177 -0500", hash_original_field = "2BAA5AA0839D150C1EAC64CF8DA3B700", hash_generated_field = "CF0740E21C8B02D30E2E5C3E17F1896F")

    private static final int CORE_POOL_SIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.180 -0500", hash_original_field = "B9B71D1929EF9C441A1A5A7BA21D4B6B", hash_generated_field = "68EE0E4A694BDFD732EDA8B1D33337CD")

    private static final int MAXIMUM_POOL_SIZE = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.182 -0500", hash_original_field = "BC25ECD11BC142C44EAFCE42CC08FE92", hash_generated_field = "874374A7281CFF977630F5545E6B2AEF")

    private static final int KEEP_ALIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.861 -0400", hash_original_field = "CE50E0B18A35D10A1792CE5C702A9A23", hash_generated_field = "EFD974F406D7D4004DF1FB489A6EC4A2")

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.185 -0500", hash_original_field = "09935F89874D8393BB7419189C0F2C7D", hash_generated_field = "53BD2EF82B0D2291D1219E89FB31ADA8")

        private final AtomicInteger mCount = new AtomicInteger(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.861 -0400", hash_original_method = "B4DE4405298900F09E8E832E952AEF02", hash_generated_method = "A4D12BFC850B96B3DEBA3947DCCDBB60")
        public Thread newThread(Runnable r) {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1226229624 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1226229624 = new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
            addTaint(r.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1226229624.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1226229624;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.193 -0500", hash_original_field = "61D62BF500D3B6901E7BB17A2CC28BFF", hash_generated_field = "7AD4AF9308A3B3C68CAA0C63DB5A78BD")

    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.195 -0500", hash_original_field = "7C639E3ED45F8FE1035F0CAC5A7CD2B9", hash_generated_field = "36170CD50FC27C086EA38F1C050DEB00")

    public static final Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.197 -0500", hash_original_field = "37E455483B80A96F20121EB91E356F2C", hash_generated_field = "7E466585D02C6A4723DB3DC0EB68409E")

    public static final Executor SERIAL_EXECUTOR = new SerialExecutor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.200 -0500", hash_original_field = "8766B25B73C4AF5D1C7E12B1D51A48A2", hash_generated_field = "7C8C89B7EC349B108F0ED9BCFCF0D4AD")

    private static final int MESSAGE_POST_RESULT = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.202 -0500", hash_original_field = "65BE0A0CD963BEECA4B2113C826E13DB", hash_generated_field = "A378167BD77B73C746FF0D775F9CDF82")

    private static final int MESSAGE_POST_PROGRESS = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.204 -0500", hash_original_field = "2256EA44468B264C40F577DBC9D102F2", hash_generated_field = "4481C8AC52C6328405964555E7F1E170")

    private static final InternalHandler sHandler = new InternalHandler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.207 -0500", hash_original_field = "DC6621AC9E5AE0C8738F83372BAA6647", hash_generated_field = "D10EB867669B9665863D7E252CF6C534")

    private static volatile Executor sDefaultExecutor = SERIAL_EXECUTOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.214 -0500", hash_original_field = "8B185CE7701C09CB4813EAF3DCF94EB3", hash_generated_field = "0C1891F28AC7C3B6ED5CCBBABEAFE2C8")

    private volatile Status mStatus = Status.PENDING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.216 -0500", hash_original_field = "364A0BD4E8BE9C781E802F7A26AF1462", hash_generated_field = "D8B55EE6C63AA30A6FA811119BF88197")
    
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
	private boolean cancelled;
	
	private Result result;
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.588 -0400", hash_original_method = "8B3C3F162E88495B3198046B04CCAD12", hash_generated_method = "717DB90AF8B9D7E6F5C69DCC8BADBDB4")
    @DSVerified
    public  AsyncTask() {
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.250 -0500", hash_original_method = "3B97ED7071D46F297921BB0773C1C347", hash_generated_method = "B892F3B62337C7FA8F4DB2B283CECB48")
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSVerified
private void postResultIfNotInvoked(Result result) {
        final boolean wasTaskInvoked = mTaskInvoked.get();
        if (!wasTaskInvoked) {
            postResult(result);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.253 -0500", hash_original_method = "1FE912CF37AD5F28EFBFA6E2EE976D7C", hash_generated_method = "602FBAA8201076CF27A77C6A020DD7E3")
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSVerified
private Result postResult(Result result) {
        Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new AsyncTaskResult<Result>(this, result));
        message.sendToTarget();
        return result;
    }

    /**
     * Returns the current status of this task.
     *
     * @return The current status.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.255 -0500", hash_original_method = "C7B50D6362AC0A992140F3FAC71C75FC", hash_generated_method = "43A258D3633FEB76DAF4ECCF46B59AF2")
    
public final Status getStatus() {
        return mStatus;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     *
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     *
     * @return A result, defined by the subclass of this task.
     *
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.257 -0500", hash_original_method = "050FF2806404EDD55751088E715072CB", hash_generated_method = "1DABA09C2EFA51EF8D9CEC44618A8740")
    
protected abstract Result doInBackground(Params... params);

    /**
     * Runs on the UI thread before {@link #doInBackground}.
     *
     * @see #onPostExecute
     * @see #doInBackground
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.259 -0500", hash_original_method = "D1C6308395AB600921F20543E51EAD98", hash_generated_method = "19E203C96602819786512F2B26D8C26C")
    
    @DSVerified    
protected void onPreExecute() {
    }
    
    private static class SerialExecutor implements Executor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.219 -0500", hash_original_field = "70DD1576CBB92EC9C206AE2C6ABB3DB6", hash_generated_field = "261CC8077C41EBB868A3FC32621980AF")

        final ArrayDeque<Runnable> mTasks = new ArrayDeque<Runnable>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.221 -0500", hash_original_field = "C695A68C51ACBA3E4D3915B59F291FEB", hash_generated_field = "C695A68C51ACBA3E4D3915B59F291FEB")

        Runnable mActive;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.614 -0400", hash_original_method = "AEF1DBC157AC4B04251F94F6D52131CC", hash_generated_method = "AEF1DBC157AC4B04251F94F6D52131CC")
        public SerialExecutor ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.227 -0500", hash_original_method = "7659AD0BA1D4D745C5BB94FD1DAE3D8A", hash_generated_method = "ED70B71C467DD2C88A554AF70E9E2EFE")
        
public synchronized void execute(final Runnable r) {
            mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        r.run();
                    } finally {
                        scheduleNext();
                    }
                }
            });
            if (mActive == null) {
                scheduleNext();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.229 -0500", hash_original_method = "F246C1002CD359817FA3C3F9B99415C3", hash_generated_method = "7508EB235846525C263AF3CB87C62F3D")
        
protected synchronized void scheduleNext() {
            if ((mActive = mTasks.poll()) != null) {
                THREAD_POOL_EXECUTOR.execute(mActive);
            }
        }
        
    }
    
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED,
    }
    
    private static class InternalHandler extends Handler {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.620 -0400", hash_original_method = "702720A53E3CB2FDA0E1C09BCF5135A3", hash_generated_method = "702720A53E3CB2FDA0E1C09BCF5135A3")
        public InternalHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.293 -0500", hash_original_method = "921E33E8D8BBA9CD431C8BC69654B3A4", hash_generated_method = "FFEA0DC46482681EBB493D95E9326E90")
        
@SuppressWarnings({"unchecked", "RawUseOfParameterizedType"})
        @Override
        public void handleMessage(Message msg) {
            AsyncTaskResult result = (AsyncTaskResult) msg.obj;
            switch (msg.what) {
                case MESSAGE_POST_RESULT:
                    // There is only one result
                    result.mTask.finish(result.mData[0]);
                    break;
                case MESSAGE_POST_PROGRESS:
                    result.mTask.onProgressUpdate(result.mData);
                    break;
            }
        }
        
    }
    
    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.298 -0500", hash_original_field = "3458C32F6AB59FD27DC8D66D0781D783", hash_generated_field = "3458C32F6AB59FD27DC8D66D0781D783")

        Params[] mParams;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_method = "6133B28C5B62218BD6304F54DA37E6FE", hash_generated_method = "6133B28C5B62218BD6304F54DA37E6FE")
        public WorkerRunnable ()
        {
            //Synthesized constructor
        }

    }
    
    private static class AsyncTaskResult<Data> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.302 -0500", hash_original_field = "DF2220D9D1A3CC6FD22A416585822610", hash_generated_field = "DF2220D9D1A3CC6FD22A416585822610")

         AsyncTask mTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.304 -0500", hash_original_field = "F9DF2CD3BD472144E91B572BDD352920", hash_generated_field = "F9DF2CD3BD472144E91B572BDD352920")

         Data[] mData;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.307 -0500", hash_original_method = "4090B8C552F02AD1AD16D083FA97D251", hash_generated_method = "4090B8C552F02AD1AD16D083FA97D251")
        
AsyncTaskResult(AsyncTask task, Data... data) {
            mTask = task;
            mData = data;
        }
        
    }

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     * 
     * <p>This method won't be invoked if the task was cancelled.</p>
     *
     * @param result The result of the operation computed by {@link #doInBackground}.
     *
     * @see #onPreExecute
     * @see #doInBackground
     * @see #onCancelled(Object) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.261 -0500", hash_original_method = "815F7407CD3192690B947D6EE1FFAB09", hash_generated_method = "AD609ADA895A3E153D035F81FAEF3E1A")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@SuppressWarnings({"UnusedDeclaration"})
    protected void onPostExecute(Result result) {
    }

    /**
     * Runs on the UI thread after {@link #publishProgress} is invoked.
     * The specified values are the values passed to {@link #publishProgress}.
     *
     * @param values The values indicating progress.
     *
     * @see #publishProgress
     * @see #doInBackground
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.264 -0500", hash_original_method = "157B3FBC0632B3CAE882248D445D8AAC", hash_generated_method = "A730193FC2E19B8CA66C41764F3098FF")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@SuppressWarnings({"UnusedDeclaration"})
    protected void onProgressUpdate(Progress... values) {
    }

    /**
     * <p>Runs on the UI thread after {@link #cancel(boolean)} is invoked and
     * {@link #doInBackground(Object[])} has finished.</p>
     * 
     * <p>The default implementation simply invokes {@link #onCancelled()} and
     * ignores the result. If you write your own implementation, do not call
     * <code>super.onCancelled(result)</code>.</p>
     *
     * @param result The result, if any, computed in
     *               {@link #doInBackground(Object[])}, can be null
     * 
     * @see #cancel(boolean)
     * @see #isCancelled()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.266 -0500", hash_original_method = "D59B5ED17FD1F167CEB40DD1D5E0C9AC", hash_generated_method = "7E43458B6C54753F6FA513FCA2BB81E3")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@SuppressWarnings({"UnusedParameters"})
    protected void onCancelled(Result result) {
        onCancelled();
    }
    
    /**
     * <p>Applications should preferably override {@link #onCancelled(Object)}.
     * This method is invoked by the default implementation of
     * {@link #onCancelled(Object)}.</p>
     * 
     * <p>Runs on the UI thread after {@link #cancel(boolean)} is invoked and
     * {@link #doInBackground(Object[])} has finished.</p>
     *
     * @see #onCancelled(Object) 
     * @see #cancel(boolean)
     * @see #isCancelled()
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.268 -0500", hash_original_method = "50EA6C215817530416AC66D7F05F78C0", hash_generated_method = "D07A2E6060CD99151CC30F4F6E6B6769")
    @DSVerified
    
protected void onCancelled() {
    }
    
    @DSVerified    
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.602 -0400", hash_original_method = "DB46851A4B24FCF8A49F880359D5B78C", hash_generated_method = "7429E399886A985919F57383107CAFFB")
    public final boolean isCancelled() {
    	return cancelled;
        // ---------- Original Method ----------
        //return mFuture.isCancelled();
    }
    
    @DSVerified    
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.603 -0400", hash_original_method = "79A634F40CF588E281325883FCE2C51B", hash_generated_method = "F2B9735A675310C684553A57E2E3C5AE")
    public final boolean cancel(boolean mayInterruptIfRunning) {
        onCancelled();
    	if ((mStatus == Status.RUNNING && mayInterruptIfRunning) || mStatus == Status.PENDING) {
    		cancelled = true;
    		return true;
    	} else {
    		return false;
    	}
        // ---------- Original Method ----------
        //return mFuture.cancel(mayInterruptIfRunning);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.603 -0400", hash_original_method = "6419D225056356234AD0A7B8CC3CE063", hash_generated_method = "7274381A5287B7C12182BBC6BC0E6E85")
    public final Result get() throws InterruptedException, ExecutionException {
    	return result;
        // ---------- Original Method ----------
        //return mFuture.get();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.604 -0400", hash_original_method = "7D7E6E809B7EB95E206E2FFE71D3D78F", hash_generated_method = "EF206F948FB16BA65C70E85B1721FB56")
    public final Result get(long timeout, TimeUnit unit) throws InterruptedException,
            ExecutionException, TimeoutException {
    	return result;
        // ---------- Original Method ----------
        //return mFuture.get(timeout, unit);
    }

    /**
     * Executes the task with the specified parameters. The task returns
     * itself (this) so that the caller can keep a reference to it.
     * 
     * <p>Note: this function schedules the task on a queue for a single background
     * thread or pool of threads depending on the platform version.  When first
     * introduced, AsyncTasks were executed serially on a single background thread.
     * Starting with {@link android.os.Build.VERSION_CODES#DONUT}, this was changed
     * to a pool of threads allowing multiple tasks to operate in parallel.  After
     * {@link android.os.Build.VERSION_CODES#HONEYCOMB}, it is planned to change this
     * back to a single thread to avoid common application errors caused
     * by parallel execution.  If you truly want parallel execution, you can use
     * the {@link #executeOnExecutor} version of this method
     * with {@link #THREAD_POOL_EXECUTOR}; however, see commentary there for warnings on
     * its use.
     *
     * <p>This method must be invoked on the UI thread.
     *
     * @param params The parameters of the task.
     *
     * @return This instance of AsyncTask.
     *
     * @throws IllegalStateException If {@link #getStatus()} returns either
     *         {@link AsyncTask.Status#RUNNING} or {@link AsyncTask.Status#FINISHED}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.279 -0500", hash_original_method = "C6B4FDC12FE10CD7E1E7DDF258371598", hash_generated_method = "C9C181AC8660B884EFC53DDD4FDD03CB")
    @DSSafe(DSCat.ANDROID_CALLBACK)
   @DSVerified
public final AsyncTask<Params, Progress, Result> execute(Params... params) {
        return executeOnExecutor(sDefaultExecutor, params);
    }

    @DSVerified
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.608 -0400", hash_original_method = "579EA4E2ACCB0940FE86E74F49727E28", hash_generated_method = "4DFC50B34A0C3A4BCA817175FC7DF9B3")
    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor exec,
            Params... params) {
        if(mStatus != Status.PENDING)        
        {
switch(mStatus){
            case RUNNING:
            IllegalStateException varBBF5B433B0BE46D00C5A56392221703A_33384526 = new IllegalStateException("Cannot execute task:"
                            + " the task is already running.");
            varBBF5B433B0BE46D00C5A56392221703A_33384526.addTaint(taint);
            throw varBBF5B433B0BE46D00C5A56392221703A_33384526;
            case FINISHED:
            IllegalStateException var4AC73FB34036B56D3B47DF6B5659E72C_879800599 = new IllegalStateException("Cannot execute task:"
                            + " the task has already been executed "
                            + "(a task can be executed only once)");
            var4AC73FB34036B56D3B47DF6B5659E72C_879800599.addTaint(taint);
            throw var4AC73FB34036B56D3B47DF6B5659E72C_879800599;
}
        } //End block
        mStatus = Status.RUNNING;
        onPreExecute();
        List<Progress> list = new LinkedList<Progress>();
        onProgressUpdate((Progress[])list.toArray());
        result = doInBackground(params);
        onPostExecute(result);
        return this;
        // ---------- Original Method ----------
        //if (mStatus != Status.PENDING) {
            //switch (mStatus) {
                //case RUNNING:
                    //throw new IllegalStateException("Cannot execute task:"
                            //+ " the task is already running.");
                //case FINISHED:
                    //throw new IllegalStateException("Cannot execute task:"
                            //+ " the task has already been executed "
                            //+ "(a task can be executed only once)");
            //}
        //}
        //mStatus = Status.RUNNING;
        //onPreExecute();
        //mWorker.mParams = params;
        //exec.execute(mFuture);
        //return this;
    }

    /**
     * This method can be invoked from {@link #doInBackground} to
     * publish updates on the UI thread while the background computation is
     * still running. Each call to this method will trigger the execution of
     * {@link #onProgressUpdate} on the UI thread.
     *
     * {@link #onProgressUpdate} will note be called if the task has been
     * canceled.
     *
     * @param values The progress values to update the UI with.
     *
     * @see #onProgressUpdate
     * @see #doInBackground
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.287 -0500", hash_original_method = "0B5FDDD22527F2F69D5D9DE9D9A2B1C6", hash_generated_method = "D6162B4EF4179E6560EB9178786EC120")
    
protected final void publishProgress(Progress... values) {
        if (!isCancelled()) {
            sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    new AsyncTaskResult<Progress>(this, values)).sendToTarget();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.290 -0500", hash_original_method = "14AF9B49F1E9643B41861D03798B3831", hash_generated_method = "8F31C3EAE93F9501ED89483BC6EC48A8")
    
private void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        mStatus = Status.FINISHED;
    }
}

