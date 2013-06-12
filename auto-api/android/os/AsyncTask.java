package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {
    private static String LOG_TAG = "AsyncTask";
    private static int CORE_POOL_SIZE = 5;
    private static int MAXIMUM_POOL_SIZE = 128;
    private static int KEEP_ALIVE = 1;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {        private AtomicInteger mCount = new AtomicInteger(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.226 -0400", hash_original_method = "B4DE4405298900F09E8E832E952AEF02", hash_generated_method = "44674C41364B65F62E5E389347E67A1A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Thread newThread(Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            Thread var979BEF2481889DD370CD3410171931E6_886514877 = (new Thread(r, "AsyncTask #" + mCount.getAndIncrement()));
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
        }

        
}; //Transformed anonymous class
    private static BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(10);
    public static Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    public static Executor SERIAL_EXECUTOR = new SerialExecutor();
    private static int MESSAGE_POST_RESULT = 0x1;
    private static int MESSAGE_POST_PROGRESS = 0x2;
    private static InternalHandler sHandler = new InternalHandler();
    private static volatile Executor sDefaultExecutor = SERIAL_EXECUTOR;
    private WorkerRunnable<Params, Result> mWorker;
    private FutureTask<Result> mFuture;
    private volatile Status mStatus = Status.PENDING;
    private AtomicBoolean mTaskInvoked = new AtomicBoolean();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.227 -0400", hash_original_method = "8B3C3F162E88495B3198046B04CCAD12", hash_generated_method = "709A29078E6BE5DD8EE44CE90F0CA8D6")
    @DSModeled(DSC.SAFE)
    public AsyncTask() {
        mWorker = new WorkerRunnable<Params, Result>() {
            public Result call() throws Exception {
                mTaskInvoked.set(true);
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                return postResult(doInBackground(mParams));
            }
        };
        mFuture = new FutureTask<Result>(mWorker) {
            @Override
            protected void done() {
                try {
                    final Result result = get();
                    postResultIfNotInvoked(result);
                } catch (InterruptedException e) {
                    android.util.Log.w(LOG_TAG, e);
                } catch (ExecutionException e) {
                    throw new RuntimeException("An error occured while executing doInBackground()",
                            e.getCause());
                } catch (CancellationException e) {
                    postResultIfNotInvoked(null);
                } catch (Throwable t) {
                    throw new RuntimeException("An error occured while executing "
                            + "doInBackground()", t);
                }
            }
        };
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.227 -0400", hash_original_method = "85B7E9920F04AD03DB055D36153974ED", hash_generated_method = "8717D9EFB6DC73C1619EB6E1EBC30550")
    public static void init() {
        sHandler.getLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.228 -0400", hash_original_method = "B027C147EDCD8E49898D40178E159A21", hash_generated_method = "58070820B0D447663D6A5F11B97A69F4")
    public static void setDefaultExecutor(Executor exec) {
        sDefaultExecutor = exec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.228 -0400", hash_original_method = "3B97ED7071D46F297921BB0773C1C347", hash_generated_method = "77243FD1910FE6F91F35AEBD1B450888")
    @DSModeled(DSC.SAFE)
    private void postResultIfNotInvoked(Result result) {
        dsTaint.addTaint(result.dsTaint);
        boolean wasTaskInvoked;
        wasTaskInvoked = mTaskInvoked.get();
        {
            postResult(result);
        } //End block
        // ---------- Original Method ----------
        //final boolean wasTaskInvoked = mTaskInvoked.get();
        //if (!wasTaskInvoked) {
            //postResult(result);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.228 -0400", hash_original_method = "1FE912CF37AD5F28EFBFA6E2EE976D7C", hash_generated_method = "096454596F5E7C81CE35406A5E81A660")
    @DSModeled(DSC.SAFE)
    private Result postResult(Result result) {
        dsTaint.addTaint(result.dsTaint);
        Message message;
        message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new AsyncTaskResult<Result>(this, result));
        message.sendToTarget();
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                //new AsyncTaskResult<Result>(this, result));
        //message.sendToTarget();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.229 -0400", hash_original_method = "C7B50D6362AC0A992140F3FAC71C75FC", hash_generated_method = "69C90304006973E5327E00D44938DCDF")
    @DSModeled(DSC.SAFE)
    public final Status getStatus() {
        return (Status)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mStatus;
    }

    
    protected abstract Result doInBackground(Params... params);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.229 -0400", hash_original_method = "D1C6308395AB600921F20543E51EAD98", hash_generated_method = "A1D8035DB44371B2BA3345DD0B9686A5")
    @DSModeled(DSC.SAFE)
    protected void onPreExecute() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.229 -0400", hash_original_method = "815F7407CD3192690B947D6EE1FFAB09", hash_generated_method = "C20C112E49D31E6DB0FB5C57C074FCF3")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onPostExecute(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.230 -0400", hash_original_method = "157B3FBC0632B3CAE882248D445D8AAC", hash_generated_method = "F8BAA6794221AFA6162FC8E4D5218881")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onProgressUpdate(Progress... values) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(values[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.230 -0400", hash_original_method = "D59B5ED17FD1F167CEB40DD1D5E0C9AC", hash_generated_method = "5BDB4F8389442E443D5D0CB34461F8F2")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedParameters"})
    protected void onCancelled(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(result.dsTaint);
        onCancelled();
        // ---------- Original Method ----------
        //onCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.230 -0400", hash_original_method = "50EA6C215817530416AC66D7F05F78C0", hash_generated_method = "EC1E170602773B070BDE78153C5E01D9")
    @DSModeled(DSC.SAFE)
    protected void onCancelled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.230 -0400", hash_original_method = "DB46851A4B24FCF8A49F880359D5B78C", hash_generated_method = "4B4D947C3666379FA77623ED4AE099C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isCancelled() {
        boolean varE689F9A33D91E57560F3F7F78307B4C2_806797947 = (mFuture.isCancelled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFuture.isCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.231 -0400", hash_original_method = "79A634F40CF588E281325883FCE2C51B", hash_generated_method = "DEB3F76D0E1FA55CB4B814D936AFC4C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean cancel(boolean mayInterruptIfRunning) {
        dsTaint.addTaint(mayInterruptIfRunning);
        boolean var9435D92544DADC2A7A666A5C650C1855_868560540 = (mFuture.cancel(mayInterruptIfRunning));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFuture.cancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.231 -0400", hash_original_method = "6419D225056356234AD0A7B8CC3CE063", hash_generated_method = "B40B5163C052746C22ECE04C92CFABD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Result get() throws InterruptedException, ExecutionException {
        Result varAA329A087007968F6FB086C75E7578F5_801796507 = (mFuture.get());
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFuture.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.231 -0400", hash_original_method = "7D7E6E809B7EB95E206E2FFE71D3D78F", hash_generated_method = "CB8204C69213CD7C9FD7629B2F8ED3FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Result get(long timeout, TimeUnit unit) throws InterruptedException,
            ExecutionException, TimeoutException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        Result var5AE3FD5638089D591161F467CFDDF183_1284218897 = (mFuture.get(timeout, unit));
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFuture.get(timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.231 -0400", hash_original_method = "C6B4FDC12FE10CD7E1E7DDF258371598", hash_generated_method = "3CAB060973242243129C44E986F669D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AsyncTask<Params, Progress, Result> execute(Params... params) {
        dsTaint.addTaint(params[0].dsTaint);
        AsyncTask<Params, Progress, Result> var66C4FEF4EA9C8B929D96264D337E3701_1261339190 = (executeOnExecutor(sDefaultExecutor, params));
        return (AsyncTask<Params, Progress, Result>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return executeOnExecutor(sDefaultExecutor, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.231 -0400", hash_original_method = "579EA4E2ACCB0940FE86E74F49727E28", hash_generated_method = "963C99F4EE86D0710E0B98C64C20C883")
    @DSModeled(DSC.SAFE)
    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor exec,
            Params... params) {
        dsTaint.addTaint(exec.dsTaint);
        dsTaint.addTaint(params[0].dsTaint);
        {
            //Begin case RUNNING 
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot execute task:"
                            + " the task is already running.");
            //End case RUNNING 
            //Begin case FINISHED 
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot execute task:"
                            + " the task has already been executed "
                            + "(a task can be executed only once)");
            //End case FINISHED 
        } //End block
        mStatus = Status.RUNNING;
        onPreExecute();
        mWorker.mParams = params;
        exec.execute(mFuture);
        return (AsyncTask<Params, Progress, Result>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.232 -0400", hash_original_method = "5DB94E109D2E156E0892B089B6E1C000", hash_generated_method = "7D360453291A42BBF10A598F95417923")
    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.233 -0400", hash_original_method = "0B5FDDD22527F2F69D5D9DE9D9A2B1C6", hash_generated_method = "AF557FE2977FD9A98F915FA41F49DF70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void publishProgress(Progress... values) {
        dsTaint.addTaint(values[0].dsTaint);
        {
            boolean var400FC4A64E54A86E4D11CC7D9451AF61_1764392205 = (!isCancelled());
            {
                sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    new AsyncTaskResult<Progress>(this, values)).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isCancelled()) {
            //sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    //new AsyncTaskResult<Progress>(this, values)).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.234 -0400", hash_original_method = "14AF9B49F1E9643B41861D03798B3831", hash_generated_method = "198271EFCB296F3547C6B6AF374B0649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finish(Result result) {
        dsTaint.addTaint(result.dsTaint);
        {
            boolean var08348B91A6AA0A281F1856BF13E9F87F_1070156151 = (isCancelled());
            {
                onCancelled(result);
            } //End block
            {
                onPostExecute(result);
            } //End block
        } //End collapsed parenthetic
        mStatus = Status.FINISHED;
        // ---------- Original Method ----------
        //if (isCancelled()) {
            //onCancelled(result);
        //} else {
            //onPostExecute(result);
        //}
        //mStatus = Status.FINISHED;
    }

    
    private static class SerialExecutor implements Executor {
        ArrayDeque<Runnable> mTasks = new ArrayDeque<Runnable>();
        Runnable mActive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.234 -0400", hash_original_method = "7659AD0BA1D4D745C5BB94FD1DAE3D8A", hash_generated_method = "588192ADA944FE4E6F4DB5CC0272AC8C")
        @DSModeled(DSC.SAFE)
        public synchronized void execute(final Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        r.run();
                    } finally {
                        scheduleNext();
                    }
                }
            });
            {
                scheduleNext();
            } //End block
            // ---------- Original Method ----------
            //mTasks.offer(new Runnable() {
                //public void run() {
                    //try {
                        //r.run();
                    //} finally {
                        //scheduleNext();
                    //}
                //}
            //});
            //if (mActive == null) {
                //scheduleNext();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.234 -0400", hash_original_method = "F246C1002CD359817FA3C3F9B99415C3", hash_generated_method = "F31FB42D4762899A043AD20A4668862E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected synchronized void scheduleNext() {
            {
                boolean var352B7D8C43A53F23D1CC57EC4344C33E_831767682 = ((mActive = mTasks.poll()) != null);
                {
                    THREAD_POOL_EXECUTOR.execute(mActive);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if ((mActive = mTasks.poll()) != null) {
                //THREAD_POOL_EXECUTOR.execute(mActive);
            //}
        }

        
    }


    
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED,
    }

    
    private static class InternalHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.235 -0400", hash_original_method = "921E33E8D8BBA9CD431C8BC69654B3A4", hash_generated_method = "8D5E0CAF72D0B1CDEDB69B34DF254E43")
        @DSModeled(DSC.SAFE)
        @SuppressWarnings({"unchecked", "RawUseOfParameterizedType"})
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            AsyncTaskResult result;
            result = (AsyncTaskResult) msg.obj;
            //Begin case MESSAGE_POST_RESULT 
            result.mTask.finish(result.mData[0]);
            //End case MESSAGE_POST_RESULT 
            //Begin case MESSAGE_POST_PROGRESS 
            result.mTask.onProgressUpdate(result.mData);
            //End case MESSAGE_POST_PROGRESS 
            // ---------- Original Method ----------
            //AsyncTaskResult result = (AsyncTaskResult) msg.obj;
            //switch (msg.what) {
                //case MESSAGE_POST_RESULT:
                    //result.mTask.finish(result.mData[0]);
                    //break;
                //case MESSAGE_POST_PROGRESS:
                    //result.mTask.onProgressUpdate(result.mData);
                    //break;
            //}
        }

        
    }


    
    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;
        
    }


    
    private static class AsyncTaskResult<Data> {
        AsyncTask mTask;
        Data[] mData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.235 -0400", hash_original_method = "4090B8C552F02AD1AD16D083FA97D251", hash_generated_method = "95F4C733F724E9362E950835DD04C5D0")
        @DSModeled(DSC.SAFE)
         AsyncTaskResult(AsyncTask task, Data... data) {
            dsTaint.addTaint(task.dsTaint);
            dsTaint.addTaint(data[0].dsTaint);
            // ---------- Original Method ----------
            //mTask = task;
            //mData = data;
        }

        
    }


    
}


