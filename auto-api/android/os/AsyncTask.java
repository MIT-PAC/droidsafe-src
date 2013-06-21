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
    private WorkerRunnable<Params, Result> mWorker;
    private FutureTask<Result> mFuture;
    private volatile Status mStatus = Status.PENDING;
    private AtomicBoolean mTaskInvoked = new AtomicBoolean();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.323 -0400", hash_original_method = "8B3C3F162E88495B3198046B04CCAD12", hash_generated_method = "24BB2E094C90168F4570692208762ED9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AsyncTask() {
        mWorker = new WorkerRunnable<Params, Result>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.322 -0400", hash_original_method = "A54B00CDBBB35FABA36BF774EC6EA22F", hash_generated_method = "0AF59E0B21DF2CB28F04019184516D3C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Result call() throws Exception {
                mTaskInvoked.set(true);
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                Result varF5AC4084B41C2C25D584EC89B4E14930_1794617962 = (postResult(doInBackground(mParams)));
                return (Result)dsTaint.getTaint();
                // ---------- Original Method ----------
                //mTaskInvoked.set(true);
                //Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                //return postResult(doInBackground(mParams));
            }
};
        mFuture = new FutureTask<Result>(mWorker) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.323 -0400", hash_original_method = "EC5824A2B7431B45243C7897F66BDC0A", hash_generated_method = "79DCFFE9D26B9E4EDB5C3C5210F11BD5")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected void done() {
                try 
                {
                    Result result;
                    result = get();
                    postResultIfNotInvoked(result);
                } //End block
                catch (InterruptedException e)
                {
                    android.util.Log.w(LOG_TAG, e);
                } //End block
                catch (ExecutionException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("An error occured while executing doInBackground()",
                            e.getCause());
                } //End block
                catch (CancellationException e)
                {
                    postResultIfNotInvoked(null);
                } //End block
                catch (Throwable t)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("An error occured while executing "
                            + "doInBackground()", t);
                } //End block
                // ---------- Original Method ----------
                //try {
                    //final Result result = get();
                    //postResultIfNotInvoked(result);
                //} catch (InterruptedException e) {
                    //android.util.Log.w(LOG_TAG, e);
                //} catch (ExecutionException e) {
                    //throw new RuntimeException("An error occured while executing doInBackground()",
                            //e.getCause());
                //} catch (CancellationException e) {
                    //postResultIfNotInvoked(null);
                //} catch (Throwable t) {
                    //throw new RuntimeException("An error occured while executing "
                            //+ "doInBackground()", t);
                //}
            }
};
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static void init() {
        sHandler.getLooper();
    }

    
        public static void setDefaultExecutor(Executor exec) {
        sDefaultExecutor = exec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.324 -0400", hash_original_method = "3B97ED7071D46F297921BB0773C1C347", hash_generated_method = "C7C8440961CB3EE691423765991BA982")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.324 -0400", hash_original_method = "1FE912CF37AD5F28EFBFA6E2EE976D7C", hash_generated_method = "3DD802CDE48A9600A92FF75874E8BCD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.324 -0400", hash_original_method = "C7B50D6362AC0A992140F3FAC71C75FC", hash_generated_method = "B5B22C1A3EAB6F06C4B237ADBFE27AAA")
    @DSModeled(DSC.SAFE)
    public final Status getStatus() {
        return (Status)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mStatus;
    }

    
    protected abstract Result doInBackground(Params... params);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.325 -0400", hash_original_method = "D1C6308395AB600921F20543E51EAD98", hash_generated_method = "C0199AA9BD1E0917DA5290FDB264C17A")
    @DSModeled(DSC.SAFE)
    protected void onPreExecute() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.325 -0400", hash_original_method = "815F7407CD3192690B947D6EE1FFAB09", hash_generated_method = "B2969982D5C7BCE69C92CE9D9497FC2E")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onPostExecute(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.325 -0400", hash_original_method = "157B3FBC0632B3CAE882248D445D8AAC", hash_generated_method = "261FAB08ECEE8931F38090B06936E8D9")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onProgressUpdate(Progress... values) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(values[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.325 -0400", hash_original_method = "D59B5ED17FD1F167CEB40DD1D5E0C9AC", hash_generated_method = "FA92A28F2766FF3265E34424AFE739FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedParameters"})
    protected void onCancelled(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(result.dsTaint);
        onCancelled();
        // ---------- Original Method ----------
        //onCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.326 -0400", hash_original_method = "50EA6C215817530416AC66D7F05F78C0", hash_generated_method = "71F6D962409DFEB2E35ECE3ED38075C4")
    @DSModeled(DSC.SAFE)
    protected void onCancelled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.326 -0400", hash_original_method = "DB46851A4B24FCF8A49F880359D5B78C", hash_generated_method = "D3D9CE546C3211F0FC6DE311C148DB63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isCancelled() {
        boolean varE689F9A33D91E57560F3F7F78307B4C2_653509112 = (mFuture.isCancelled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFuture.isCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.326 -0400", hash_original_method = "79A634F40CF588E281325883FCE2C51B", hash_generated_method = "EBE2FFCEE15566D610D746EF60227AE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean cancel(boolean mayInterruptIfRunning) {
        dsTaint.addTaint(mayInterruptIfRunning);
        boolean var9435D92544DADC2A7A666A5C650C1855_1573634165 = (mFuture.cancel(mayInterruptIfRunning));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFuture.cancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.326 -0400", hash_original_method = "6419D225056356234AD0A7B8CC3CE063", hash_generated_method = "93E88B53AD0D7C53BEEE357C2B18CA0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Result get() throws InterruptedException, ExecutionException {
        Result varAA329A087007968F6FB086C75E7578F5_699237002 = (mFuture.get());
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFuture.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.327 -0400", hash_original_method = "7D7E6E809B7EB95E206E2FFE71D3D78F", hash_generated_method = "D20A5D66BAED118B01ACB79AC9698F7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Result get(long timeout, TimeUnit unit) throws InterruptedException,
            ExecutionException, TimeoutException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        Result var5AE3FD5638089D591161F467CFDDF183_1769407302 = (mFuture.get(timeout, unit));
        return (Result)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFuture.get(timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.327 -0400", hash_original_method = "C6B4FDC12FE10CD7E1E7DDF258371598", hash_generated_method = "4BA71057E97399032DA18E301305EA87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AsyncTask<Params, Progress, Result> execute(Params... params) {
        dsTaint.addTaint(params[0].dsTaint);
        AsyncTask<Params, Progress, Result> var66C4FEF4EA9C8B929D96264D337E3701_484746357 = (executeOnExecutor(sDefaultExecutor, params));
        return (AsyncTask<Params, Progress, Result>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return executeOnExecutor(sDefaultExecutor, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.328 -0400", hash_original_method = "579EA4E2ACCB0940FE86E74F49727E28", hash_generated_method = "D8497B047B3363F95B20B341306E25DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.331 -0400", hash_original_method = "0B5FDDD22527F2F69D5D9DE9D9A2B1C6", hash_generated_method = "11FAA5252FFEF660E86C051C112940D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void publishProgress(Progress... values) {
        dsTaint.addTaint(values[0].dsTaint);
        {
            boolean var400FC4A64E54A86E4D11CC7D9451AF61_389162890 = (!isCancelled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.331 -0400", hash_original_method = "14AF9B49F1E9643B41861D03798B3831", hash_generated_method = "99A79FF9945E0A777B1A5C386CC233CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finish(Result result) {
        dsTaint.addTaint(result.dsTaint);
        {
            boolean var08348B91A6AA0A281F1856BF13E9F87F_565784309 = (isCancelled());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.332 -0400", hash_original_method = "37D850A301C73685D4402599C8935C9D", hash_generated_method = "37D850A301C73685D4402599C8935C9D")
                public SerialExecutor ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.332 -0400", hash_original_method = "7659AD0BA1D4D745C5BB94FD1DAE3D8A", hash_generated_method = "F8287396B40E355298F6959C17685E0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void execute(final Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            mTasks.offer(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.332 -0400", hash_original_method = "97925E5CC02778827B83E8E0CDA5AF7A", hash_generated_method = "C4A406957E6605C6F61D04A437666DDF")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    try 
                    {
                        r.run();
                    } //End block
                    finally 
                    {
                        scheduleNext();
                    } //End block
                    // ---------- Original Method ----------
                    //try {
                        //r.run();
                    //} finally {
                        //scheduleNext();
                    //}
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.332 -0400", hash_original_method = "F246C1002CD359817FA3C3F9B99415C3", hash_generated_method = "4EDC2D11E322D7DC3C7A155C74B767E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected synchronized void scheduleNext() {
            {
                boolean var352B7D8C43A53F23D1CC57EC4344C33E_314862306 = ((mActive = mTasks.poll()) != null);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.332 -0400", hash_original_method = "28E38A638EFF55B23D0F1F1D80CC7961", hash_generated_method = "28E38A638EFF55B23D0F1F1D80CC7961")
                public InternalHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.333 -0400", hash_original_method = "921E33E8D8BBA9CD431C8BC69654B3A4", hash_generated_method = "207F06AD7C244C61043B3D9D9C0314A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.333 -0400", hash_original_method = "0F2C2476CE1D7370C2DB3E9E192051D9", hash_generated_method = "0F2C2476CE1D7370C2DB3E9E192051D9")
                public WorkerRunnable ()
        {
        }


    }


    
    private static class AsyncTaskResult<Data> {
        AsyncTask mTask;
        Data[] mData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.333 -0400", hash_original_method = "4090B8C552F02AD1AD16D083FA97D251", hash_generated_method = "AA1DA67695D8FFA689592610D4B508B8")
        @DSModeled(DSC.SAFE)
         AsyncTaskResult(AsyncTask task, Data... data) {
            dsTaint.addTaint(task.dsTaint);
            dsTaint.addTaint(data[0].dsTaint);
            // ---------- Original Method ----------
            //mTask = task;
            //mData = data;
        }

        
    }


    
    private static final String LOG_TAG = "AsyncTask";
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int KEEP_ALIVE = 1;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {        private AtomicInteger mCount = new AtomicInteger(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.333 -0400", hash_original_method = "B4DE4405298900F09E8E832E952AEF02", hash_generated_method = "FCB77B40878F3E0BA51352BF94241FEA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Thread newThread(Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            Thread var979BEF2481889DD370CD3410171931E6_1538388104 = (new Thread(r, "AsyncTask #" + mCount.getAndIncrement()));
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
        }

        
}; //Transformed anonymous class
    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(10);
    public static final Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    public static final Executor SERIAL_EXECUTOR = new SerialExecutor();
    private static final int MESSAGE_POST_RESULT = 0x1;
    private static final int MESSAGE_POST_PROGRESS = 0x2;
    private static final InternalHandler sHandler = new InternalHandler();
    private static volatile Executor sDefaultExecutor = SERIAL_EXECUTOR;
}

