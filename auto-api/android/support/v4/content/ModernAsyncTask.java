package android.support.v4.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import android.os.Handler;
import android.os.Message;
import android.os.Process;

abstract class ModernAsyncTask<Params, Progress, Result> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.011 -0400", hash_original_field = "BB30BA3EDC46FDDC92BDFE7FACA691F0", hash_generated_field = "DAAB2689B37CB24EEF0B8E3B973EEFF3")

    private WorkerRunnable<Params, Result> mWorker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.011 -0400", hash_original_field = "76BB93AB423B813C0C115E37BB7B0147", hash_generated_field = "6DAED75BC4A1450C0B66E4CCB009EB53")

    private FutureTask<Result> mFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.011 -0400", hash_original_field = "8FA972E3894E5889324591B9B189ABDC", hash_generated_field = "0C1891F28AC7C3B6ED5CCBBABEAFE2C8")

    private volatile Status mStatus = Status.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.011 -0400", hash_original_field = "B024F65C6054CDE21F0BE3765446DCC0", hash_generated_field = "6388A9EBD5BF48DC74B4634613407B70")

    private AtomicBoolean mTaskInvoked = new AtomicBoolean();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.030 -0400", hash_original_method = "23205AF15CA33077DF5B8FA9588BE2E9", hash_generated_method = "EF7B17C0A59827CF15268A6212EB8EB6")
    public  ModernAsyncTask() {
        mWorker = new WorkerRunnable<Params, Result>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.016 -0400", hash_original_method = "A54B00CDBBB35FABA36BF774EC6EA22F", hash_generated_method = "6DB57854AC9B6C8FB5BB56FDBCC4E116")
            public Result call() throws Exception {
                Result varB4EAC82CA7396A68D541C85D26508E83_1008692620 = null; //Variable for return #1
                mTaskInvoked.set(true);
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                varB4EAC82CA7396A68D541C85D26508E83_1008692620 = postResult(doInBackground(mParams));
                varB4EAC82CA7396A68D541C85D26508E83_1008692620.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1008692620;
                // ---------- Original Method ----------
                //mTaskInvoked.set(true);
                //Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                //return postResult(doInBackground(mParams));
            }
};
        mFuture = new FutureTask<Result>(mWorker) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.030 -0400", hash_original_method = "EC5824A2B7431B45243C7897F66BDC0A", hash_generated_method = "79DCFFE9D26B9E4EDB5C3C5210F11BD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.038 -0400", hash_original_method = "3B97ED7071D46F297921BB0773C1C347", hash_generated_method = "14C75509D821807E889DAFE9850FE0C5")
    private void postResultIfNotInvoked(Result result) {
        boolean wasTaskInvoked;
        wasTaskInvoked = mTaskInvoked.get();
        {
            postResult(result);
        } //End block
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //final boolean wasTaskInvoked = mTaskInvoked.get();
        //if (!wasTaskInvoked) {
            //postResult(result);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.041 -0400", hash_original_method = "1FE912CF37AD5F28EFBFA6E2EE976D7C", hash_generated_method = "AC29E965BDC0F8635274953BC41F215A")
    private Result postResult(Result result) {
        Result varB4EAC82CA7396A68D541C85D26508E83_689332769 = null; //Variable for return #1
        Message message;
        message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new AsyncTaskResult<Result>(this, result));
        message.sendToTarget();
        varB4EAC82CA7396A68D541C85D26508E83_689332769 = result;
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_689332769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_689332769;
        // ---------- Original Method ----------
        //Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                //new AsyncTaskResult<Result>(this, result));
        //message.sendToTarget();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.042 -0400", hash_original_method = "C7B50D6362AC0A992140F3FAC71C75FC", hash_generated_method = "463A7472F9CBCA5E0F9B6A822B2D9B2D")
    public final Status getStatus() {
        Status varB4EAC82CA7396A68D541C85D26508E83_546790568 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_546790568 = mStatus;
        varB4EAC82CA7396A68D541C85D26508E83_546790568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_546790568;
        // ---------- Original Method ----------
        //return mStatus;
    }

    
    protected abstract Result doInBackground(Params... params);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.042 -0400", hash_original_method = "D1C6308395AB600921F20543E51EAD98", hash_generated_method = "C0199AA9BD1E0917DA5290FDB264C17A")
    protected void onPreExecute() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.059 -0400", hash_original_method = "815F7407CD3192690B947D6EE1FFAB09", hash_generated_method = "C976233E37033A3D91D226FE1079E594")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onPostExecute(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.059 -0400", hash_original_method = "157B3FBC0632B3CAE882248D445D8AAC", hash_generated_method = "840A874EFC9E5D7D09065733171CECD0")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onProgressUpdate(Progress... values) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(values[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.059 -0400", hash_original_method = "D59B5ED17FD1F167CEB40DD1D5E0C9AC", hash_generated_method = "295E24CF2011E2415E50209BC2862E86")
    @SuppressWarnings({"UnusedParameters"})
    protected void onCancelled(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onCancelled();
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //onCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.060 -0400", hash_original_method = "50EA6C215817530416AC66D7F05F78C0", hash_generated_method = "71F6D962409DFEB2E35ECE3ED38075C4")
    protected void onCancelled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.060 -0400", hash_original_method = "DB46851A4B24FCF8A49F880359D5B78C", hash_generated_method = "46DD22739A94F9E51F08E90B5F53F16F")
    public final boolean isCancelled() {
        boolean varE689F9A33D91E57560F3F7F78307B4C2_706957856 = (mFuture.isCancelled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238060458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238060458;
        // ---------- Original Method ----------
        //return mFuture.isCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.061 -0400", hash_original_method = "79A634F40CF588E281325883FCE2C51B", hash_generated_method = "7699FF4AE0F3BE7D1F57374B62DAFD2B")
    public final boolean cancel(boolean mayInterruptIfRunning) {
        boolean var9435D92544DADC2A7A666A5C650C1855_941058815 = (mFuture.cancel(mayInterruptIfRunning));
        addTaint(mayInterruptIfRunning);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448281977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448281977;
        // ---------- Original Method ----------
        //return mFuture.cancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.061 -0400", hash_original_method = "6419D225056356234AD0A7B8CC3CE063", hash_generated_method = "2EB5323F571DBC1646B9C9B112B1B927")
    public final Result get() throws InterruptedException, ExecutionException {
        Result varB4EAC82CA7396A68D541C85D26508E83_2101896623 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2101896623 = mFuture.get();
        varB4EAC82CA7396A68D541C85D26508E83_2101896623.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101896623;
        // ---------- Original Method ----------
        //return mFuture.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.075 -0400", hash_original_method = "7D7E6E809B7EB95E206E2FFE71D3D78F", hash_generated_method = "A812276BF635FCADA3B8FE08479A6C0E")
    public final Result get(long timeout, TimeUnit unit) throws InterruptedException,
            ExecutionException, TimeoutException {
        Result varB4EAC82CA7396A68D541C85D26508E83_65785878 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_65785878 = mFuture.get(timeout, unit);
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_65785878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_65785878;
        // ---------- Original Method ----------
        //return mFuture.get(timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.075 -0400", hash_original_method = "88E70239038C6B17199526F5A138B52C", hash_generated_method = "B7691C374C0FE19A3D94F263E3483C52")
    public final ModernAsyncTask<Params, Progress, Result> execute(Params... params) {
        ModernAsyncTask<Params, Progress, Result> varB4EAC82CA7396A68D541C85D26508E83_843964442 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_843964442 = executeOnExecutor(sDefaultExecutor, params);
        addTaint(params[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_843964442.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_843964442;
        // ---------- Original Method ----------
        //return executeOnExecutor(sDefaultExecutor, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.076 -0400", hash_original_method = "2D658F6D3BDE5104FE23D8DBAC134A95", hash_generated_method = "C7FFE19BACBD279BA53299F50AFC4281")
    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor exec,
            Params... params) {
        ModernAsyncTask<Params, Progress, Result> varB4EAC82CA7396A68D541C85D26508E83_348442292 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_348442292 = this;
        addTaint(exec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_348442292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_348442292;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.077 -0400", hash_original_method = "0B5FDDD22527F2F69D5D9DE9D9A2B1C6", hash_generated_method = "7A1DB8EAA4D5BE7868F095AE3EE906B7")
    protected final void publishProgress(Progress... values) {
        {
            boolean var400FC4A64E54A86E4D11CC7D9451AF61_1150897831 = (!isCancelled());
            {
                sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    new AsyncTaskResult<Progress>(this, values)).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        addTaint(values[0].getTaint());
        // ---------- Original Method ----------
        //if (!isCancelled()) {
            //sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    //new AsyncTaskResult<Progress>(this, values)).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.082 -0400", hash_original_method = "14AF9B49F1E9643B41861D03798B3831", hash_generated_method = "C6982004BC32F2E7A870EC6E1D439219")
    private void finish(Result result) {
        {
            boolean var08348B91A6AA0A281F1856BF13E9F87F_227850649 = (isCancelled());
            {
                onCancelled(result);
            } //End block
            {
                onPostExecute(result);
            } //End block
        } //End collapsed parenthetic
        mStatus = Status.FINISHED;
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //if (isCancelled()) {
            //onCancelled(result);
        //} else {
            //onPostExecute(result);
        //}
        //mStatus = Status.FINISHED;
    }

    
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED,
    }

    
    private static class InternalHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.082 -0400", hash_original_method = "702720A53E3CB2FDA0E1C09BCF5135A3", hash_generated_method = "702720A53E3CB2FDA0E1C09BCF5135A3")
        public InternalHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.086 -0400", hash_original_method = "921E33E8D8BBA9CD431C8BC69654B3A4", hash_generated_method = "87404DE591810292BBEEF371399EE872")
        @SuppressWarnings({"unchecked", "RawUseOfParameterizedType"})
        @Override
        public void handleMessage(Message msg) {
            AsyncTaskResult result;
            result = (AsyncTaskResult) msg.obj;
            //Begin case MESSAGE_POST_RESULT 
            result.mTask.finish(result.mData[0]);
            //End case MESSAGE_POST_RESULT 
            //Begin case MESSAGE_POST_PROGRESS 
            result.mTask.onProgressUpdate(result.mData);
            //End case MESSAGE_POST_PROGRESS 
            addTaint(msg.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.086 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "3458C32F6AB59FD27DC8D66D0781D783")

        Params[] mParams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.086 -0400", hash_original_method = "6133B28C5B62218BD6304F54DA37E6FE", hash_generated_method = "6133B28C5B62218BD6304F54DA37E6FE")
        public WorkerRunnable ()
        {
            //Synthesized constructor
        }


    }


    
    private static class AsyncTaskResult<Data> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.086 -0400", hash_original_field = "0F416DC8E1EF1E61CE9DC1C4C6AAC524", hash_generated_field = "F304F0D2C5C31A00544C8D41C67529B9")

        ModernAsyncTask mTask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.087 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F9DF2CD3BD472144E91B572BDD352920")

        Data[] mData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.087 -0400", hash_original_method = "D5FEEE1684992AD45A8A3E14AF387D03", hash_generated_method = "8EDA58525A416148F14DD2AE98C68390")
          AsyncTaskResult(ModernAsyncTask task, Data... data) {
            mTask = task;
            mData = data;
            // ---------- Original Method ----------
            //mTask = task;
            //mData = data;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.087 -0400", hash_original_field = "633B1285E96B59FE7188F4D85CC49A51", hash_generated_field = "B260D7F0F689B74E4DB6C1A622CAE9AA")

    private static String LOG_TAG = "AsyncTask";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.087 -0400", hash_original_field = "C3D7263FE4EB907C919B47ECE782B0BF", hash_generated_field = "80F9C6E250B0D708AC4131810EEF83F5")

    private static int CORE_POOL_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.107 -0400", hash_original_field = "C992D099DBB7578480B14D215BCF43F3", hash_generated_field = "80DC80C5358F6380BF7C0D3355D5C074")

    private static int MAXIMUM_POOL_SIZE = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.107 -0400", hash_original_field = "0262667811769BEE2F069CB2EAB3EE82", hash_generated_field = "D28BB5DF0E14911D83CC0D6623E5E585")

    private static int KEEP_ALIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.108 -0400", hash_original_field = "31E648E4B6C25DADCBCC7E3D7E6E7D12", hash_generated_field = "4F977E5C4DC08226759269F433AEFADF")

    private static ThreadFactory sThreadFactory = new ThreadFactory() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.107 -0400", hash_original_field = "0400DCCD0AD37CE0396AA49E9A3A5070", hash_generated_field = "B4A746055001BF4E34A1898BD708AD22")

        private AtomicInteger mCount = new AtomicInteger(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.108 -0400", hash_original_method = "77C8792F662CD3BCFB55CC8C0EAE2B98", hash_generated_method = "953BDA2356669087969A95BDB197163C")
        public Thread newThread(Runnable r) {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1757173367 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1757173367 = new Thread(r, "ModernAsyncTask #" + mCount.getAndIncrement());
            addTaint(r.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1757173367.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1757173367;
            // ---------- Original Method ----------
            //return new Thread(r, "ModernAsyncTask #" + mCount.getAndIncrement());
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.108 -0400", hash_original_field = "832D0AB7F691D38DFCF25F1C48444796", hash_generated_field = "F2214ED05E220DD2E190A36863517CE2")

    private static BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.108 -0400", hash_original_field = "7656CA2646F7AF011CC114CB7F68F158", hash_generated_field = "36170CD50FC27C086EA38F1C050DEB00")

    public static final Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.108 -0400", hash_original_field = "8DEDF8C9E90E9561E2346963E5898747", hash_generated_field = "75317C735A0AB2FC012C419E13EBFE8D")

    private static int MESSAGE_POST_RESULT = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.119 -0400", hash_original_field = "9C5866459C52559035C2AED46C43B074", hash_generated_field = "53603E4784F78FE23E41629FD093FC3F")

    private static int MESSAGE_POST_PROGRESS = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.119 -0400", hash_original_field = "8235EF876A5F3E4DF366DDAE5A4B03BC", hash_generated_field = "7841C19751E6A3E2E7B7D513102547AD")

    private static InternalHandler sHandler = new InternalHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.119 -0400", hash_original_field = "F9D8C926D7381713A6244C8745A0252C", hash_generated_field = "45EF8C423315DCAE20CB6CF839040B3F")

    private static volatile Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
}

