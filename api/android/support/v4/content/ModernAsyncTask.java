package android.support.v4.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.415 -0400", hash_original_field = "BB30BA3EDC46FDDC92BDFE7FACA691F0", hash_generated_field = "DAAB2689B37CB24EEF0B8E3B973EEFF3")

    private WorkerRunnable<Params, Result> mWorker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.415 -0400", hash_original_field = "76BB93AB423B813C0C115E37BB7B0147", hash_generated_field = "6DAED75BC4A1450C0B66E4CCB009EB53")

    private FutureTask<Result> mFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.415 -0400", hash_original_field = "8FA972E3894E5889324591B9B189ABDC", hash_generated_field = "0C1891F28AC7C3B6ED5CCBBABEAFE2C8")

    private volatile Status mStatus = Status.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.415 -0400", hash_original_field = "B024F65C6054CDE21F0BE3765446DCC0", hash_generated_field = "D8B55EE6C63AA30A6FA811119BF88197")

    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.418 -0400", hash_original_method = "23205AF15CA33077DF5B8FA9588BE2E9", hash_generated_method = "E437D216F49D81A32B8E4DF1C2EA63D9")
    public  ModernAsyncTask() {
        mWorker = new WorkerRunnable<Params, Result>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.416 -0400", hash_original_method = "A54B00CDBBB35FABA36BF774EC6EA22F", hash_generated_method = "E49490BC0038C619D041D6737C27AB0B")
        public Result call() throws Exception {
            mTaskInvoked.set(true);
            Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
Result var3E54577D8BA0B3895F3C3277069ED558_954375863 =             postResult(doInBackground(mParams));
            var3E54577D8BA0B3895F3C3277069ED558_954375863.addTaint(taint);
            return var3E54577D8BA0B3895F3C3277069ED558_954375863;
            // ---------- Original Method ----------
            //mTaskInvoked.set(true);
            //Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            //return postResult(doInBackground(mParams));
        }
};
        mFuture = new FutureTask<Result>(mWorker) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.417 -0400", hash_original_method = "EC5824A2B7431B45243C7897F66BDC0A", hash_generated_method = "5757186496BAB401A5F23FE466EA8025")
        @Override
        protected void done() {
            try 
            {
                final Result result = get();
                postResultIfNotInvoked(result);
            } //End block
            catch (InterruptedException e)
            {
                android.util.Log.w(LOG_TAG, e);
            } //End block
            catch (ExecutionException e)
            {
                RuntimeException varF8D4F5B31C1D2B7927B6CFBBA0286D57_1431498030 = new RuntimeException("An error occured while executing doInBackground()",
                            e.getCause());
                varF8D4F5B31C1D2B7927B6CFBBA0286D57_1431498030.addTaint(taint);
                throw varF8D4F5B31C1D2B7927B6CFBBA0286D57_1431498030;
            } //End block
            catch (CancellationException e)
            {
                postResultIfNotInvoked(null);
            } //End block
            catch (Throwable t)
            {
                RuntimeException var16B9994CE83BD3E7B18E1E37D2B3693B_2040801856 = new RuntimeException("An error occured while executing "
                            + "doInBackground()", t);
                var16B9994CE83BD3E7B18E1E37D2B3693B_2040801856.addTaint(taint);
                throw var16B9994CE83BD3E7B18E1E37D2B3693B_2040801856;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.419 -0400", hash_original_method = "3B97ED7071D46F297921BB0773C1C347", hash_generated_method = "4417C4FF646E21FA130E72F92B0D4080")
    private void postResultIfNotInvoked(Result result) {
        addTaint(result.getTaint());
        final boolean wasTaskInvoked = mTaskInvoked.get();
    if(!wasTaskInvoked)        
        {
            postResult(result);
        } //End block
        // ---------- Original Method ----------
        //final boolean wasTaskInvoked = mTaskInvoked.get();
        //if (!wasTaskInvoked) {
            //postResult(result);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.419 -0400", hash_original_method = "1FE912CF37AD5F28EFBFA6E2EE976D7C", hash_generated_method = "1808CE620857DB8DD8ECB18C639DBAE0")
    private Result postResult(Result result) {
        addTaint(result.getTaint());
        Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new AsyncTaskResult<Result>(this, result));
        message.sendToTarget();
Result varDC838461EE2FA0CA4C9BBB70A15456B0_440737117 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_440737117.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_440737117;
        // ---------- Original Method ----------
        //Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                //new AsyncTaskResult<Result>(this, result));
        //message.sendToTarget();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.420 -0400", hash_original_method = "C7B50D6362AC0A992140F3FAC71C75FC", hash_generated_method = "7A0B8B8CB474D096402B8A0C5BECFE55")
    public final Status getStatus() {
Status var6300E74790326279AA67EB8DFA2C84B0_560194753 =         mStatus;
        var6300E74790326279AA67EB8DFA2C84B0_560194753.addTaint(taint);
        return var6300E74790326279AA67EB8DFA2C84B0_560194753;
        // ---------- Original Method ----------
        //return mStatus;
    }

    
    protected abstract Result doInBackground(Params... params);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.420 -0400", hash_original_method = "D1C6308395AB600921F20543E51EAD98", hash_generated_method = "C0199AA9BD1E0917DA5290FDB264C17A")
    protected void onPreExecute() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.420 -0400", hash_original_method = "815F7407CD3192690B947D6EE1FFAB09", hash_generated_method = "C976233E37033A3D91D226FE1079E594")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onPostExecute(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.421 -0400", hash_original_method = "157B3FBC0632B3CAE882248D445D8AAC", hash_generated_method = "840A874EFC9E5D7D09065733171CECD0")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onProgressUpdate(Progress... values) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(values[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.421 -0400", hash_original_method = "D59B5ED17FD1F167CEB40DD1D5E0C9AC", hash_generated_method = "828E716C9F83A225045546A9111AE69D")
    @SuppressWarnings({"UnusedParameters"})
    protected void onCancelled(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        onCancelled();
        // ---------- Original Method ----------
        //onCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.421 -0400", hash_original_method = "50EA6C215817530416AC66D7F05F78C0", hash_generated_method = "71F6D962409DFEB2E35ECE3ED38075C4")
    protected void onCancelled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.422 -0400", hash_original_method = "DB46851A4B24FCF8A49F880359D5B78C", hash_generated_method = "5167D3C1BB9D310F7042F37D47A01283")
    public final boolean isCancelled() {
        boolean var7E7FA29716C4CBE4B16D639A4F3CDD24_1600252634 = (mFuture.isCancelled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_675559868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_675559868;
        // ---------- Original Method ----------
        //return mFuture.isCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.422 -0400", hash_original_method = "79A634F40CF588E281325883FCE2C51B", hash_generated_method = "547E1FB295DDFA6EA426C04548F9206C")
    public final boolean cancel(boolean mayInterruptIfRunning) {
        addTaint(mayInterruptIfRunning);
        boolean varC56519D800A095069C9D4DD00872ADF8_829898096 = (mFuture.cancel(mayInterruptIfRunning));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495932625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495932625;
        // ---------- Original Method ----------
        //return mFuture.cancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.422 -0400", hash_original_method = "6419D225056356234AD0A7B8CC3CE063", hash_generated_method = "B97001AB0FBC08FDA3B81B82894F027B")
    public final Result get() throws InterruptedException, ExecutionException {
Result var3209BEC855B70D6C26F0EC9DBDDA58B7_1588452824 =         mFuture.get();
        var3209BEC855B70D6C26F0EC9DBDDA58B7_1588452824.addTaint(taint);
        return var3209BEC855B70D6C26F0EC9DBDDA58B7_1588452824;
        // ---------- Original Method ----------
        //return mFuture.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.423 -0400", hash_original_method = "7D7E6E809B7EB95E206E2FFE71D3D78F", hash_generated_method = "F4B89844678CF7B0AE012AAC13EE911C")
    public final Result get(long timeout, TimeUnit unit) throws InterruptedException,
            ExecutionException, TimeoutException {
        addTaint(unit.getTaint());
        addTaint(timeout);
Result var5F8E5ACBC39B5812EA5F66BAABC411DD_1867499034 =         mFuture.get(timeout, unit);
        var5F8E5ACBC39B5812EA5F66BAABC411DD_1867499034.addTaint(taint);
        return var5F8E5ACBC39B5812EA5F66BAABC411DD_1867499034;
        // ---------- Original Method ----------
        //return mFuture.get(timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.423 -0400", hash_original_method = "88E70239038C6B17199526F5A138B52C", hash_generated_method = "6A3A844C79A809A05CF095F7C23907AB")
    public final ModernAsyncTask<Params, Progress, Result> execute(Params... params) {
        addTaint(params[0].getTaint());
ModernAsyncTask<Params, Progress, Result> var0A631FF6F1525828AF54B1432444F062_1886240901 =         executeOnExecutor(sDefaultExecutor, params);
        var0A631FF6F1525828AF54B1432444F062_1886240901.addTaint(taint);
        return var0A631FF6F1525828AF54B1432444F062_1886240901;
        // ---------- Original Method ----------
        //return executeOnExecutor(sDefaultExecutor, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.424 -0400", hash_original_method = "2D658F6D3BDE5104FE23D8DBAC134A95", hash_generated_method = "4565B2AD07E1B011F08FE7AD3F6507A1")
    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor exec,
            Params... params) {
        addTaint(exec.getTaint());
    if(mStatus != Status.PENDING)        
        {
switch(mStatus){
            case RUNNING:
            IllegalStateException varBBF5B433B0BE46D00C5A56392221703A_941534959 = new IllegalStateException("Cannot execute task:"
                            + " the task is already running.");
            varBBF5B433B0BE46D00C5A56392221703A_941534959.addTaint(taint);
            throw varBBF5B433B0BE46D00C5A56392221703A_941534959;
            case FINISHED:
            IllegalStateException var4AC73FB34036B56D3B47DF6B5659E72C_1064589088 = new IllegalStateException("Cannot execute task:"
                            + " the task has already been executed "
                            + "(a task can be executed only once)");
            var4AC73FB34036B56D3B47DF6B5659E72C_1064589088.addTaint(taint);
            throw var4AC73FB34036B56D3B47DF6B5659E72C_1064589088;
}
        } //End block
        mStatus = Status.RUNNING;
        onPreExecute();
        mWorker.mParams = params;
        exec.execute(mFuture);
ModernAsyncTask<Params, Progress, Result> var72A74007B2BE62B849F475C7BDA4658B_418575499 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_418575499.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_418575499;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.424 -0400", hash_original_method = "0B5FDDD22527F2F69D5D9DE9D9A2B1C6", hash_generated_method = "02380C102BBCB45F93696C9F91AA3E87")
    protected final void publishProgress(Progress... values) {
        addTaint(values[0].getTaint());
    if(!isCancelled())        
        {
            sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    new AsyncTaskResult<Progress>(this, values)).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (!isCancelled()) {
            //sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    //new AsyncTaskResult<Progress>(this, values)).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.425 -0400", hash_original_method = "14AF9B49F1E9643B41861D03798B3831", hash_generated_method = "C0F7221995D6AE74BD119A599A0BE04E")
    private void finish(Result result) {
        addTaint(result.getTaint());
    if(isCancelled())        
        {
            onCancelled(result);
        } //End block
        else
        {
            onPostExecute(result);
        } //End block
        mStatus = Status.FINISHED;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.425 -0400", hash_original_method = "702720A53E3CB2FDA0E1C09BCF5135A3", hash_generated_method = "702720A53E3CB2FDA0E1C09BCF5135A3")
        public InternalHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.425 -0400", hash_original_method = "921E33E8D8BBA9CD431C8BC69654B3A4", hash_generated_method = "3412AC0B19BEEA5471BA543EA333720D")
        @SuppressWarnings({"unchecked", "RawUseOfParameterizedType"})
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            AsyncTaskResult result = (AsyncTaskResult) msg.obj;
switch(msg.what){
            case MESSAGE_POST_RESULT:
            result.mTask.finish(result.mData[0]);
            break;
            case MESSAGE_POST_PROGRESS:
            result.mTask.onProgressUpdate(result.mData);
            break;
}
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.425 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "3458C32F6AB59FD27DC8D66D0781D783")

        Params[] mParams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.425 -0400", hash_original_method = "6133B28C5B62218BD6304F54DA37E6FE", hash_generated_method = "6133B28C5B62218BD6304F54DA37E6FE")
        public WorkerRunnable ()
        {
            //Synthesized constructor
        }


    }


    
    private static class AsyncTaskResult<Data> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.426 -0400", hash_original_field = "0F416DC8E1EF1E61CE9DC1C4C6AAC524", hash_generated_field = "F304F0D2C5C31A00544C8D41C67529B9")

        ModernAsyncTask mTask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.426 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F9DF2CD3BD472144E91B572BDD352920")

        Data[] mData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.426 -0400", hash_original_method = "D5FEEE1684992AD45A8A3E14AF387D03", hash_generated_method = "8EDA58525A416148F14DD2AE98C68390")
          AsyncTaskResult(ModernAsyncTask task, Data... data) {
            mTask = task;
            mData = data;
            // ---------- Original Method ----------
            //mTask = task;
            //mData = data;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.426 -0400", hash_original_field = "633B1285E96B59FE7188F4D85CC49A51", hash_generated_field = "1621B971276E6C94E07DE79B5D168C87")

    private static final String LOG_TAG = "AsyncTask";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "C3D7263FE4EB907C919B47ECE782B0BF", hash_generated_field = "CF0740E21C8B02D30E2E5C3E17F1896F")

    private static final int CORE_POOL_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "C992D099DBB7578480B14D215BCF43F3", hash_generated_field = "68EE0E4A694BDFD732EDA8B1D33337CD")

    private static final int MAXIMUM_POOL_SIZE = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "0262667811769BEE2F069CB2EAB3EE82", hash_generated_field = "874374A7281CFF977630F5545E6B2AEF")

    private static final int KEEP_ALIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_field = "31E648E4B6C25DADCBCC7E3D7E6E7D12", hash_generated_field = "1EF17D2F631985AE74A025531662435D")

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.358 -0400", hash_original_field = "0400DCCD0AD37CE0396AA49E9A3A5070", hash_generated_field = "53BD2EF82B0D2291D1219E89FB31ADA8")

        private final AtomicInteger mCount = new AtomicInteger(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_method = "77C8792F662CD3BCFB55CC8C0EAE2B98", hash_generated_method = "7C2862DA5F899CBF8BCF21BA933827A7")
        public Thread newThread(Runnable r) {
            Thread varB4EAC82CA7396A68D541C85D26508E83_386065161 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_386065161 = new Thread(r, "ModernAsyncTask #" + mCount.getAndIncrement());
            addTaint(r.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_386065161.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_386065161;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "832D0AB7F691D38DFCF25F1C48444796", hash_generated_field = "7AD4AF9308A3B3C68CAA0C63DB5A78BD")

    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "7656CA2646F7AF011CC114CB7F68F158", hash_generated_field = "36170CD50FC27C086EA38F1C050DEB00")

    public static final Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "8DEDF8C9E90E9561E2346963E5898747", hash_generated_field = "7C8C89B7EC349B108F0ED9BCFCF0D4AD")

    private static final int MESSAGE_POST_RESULT = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "9C5866459C52559035C2AED46C43B074", hash_generated_field = "A378167BD77B73C746FF0D775F9CDF82")

    private static final int MESSAGE_POST_PROGRESS = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "8235EF876A5F3E4DF366DDAE5A4B03BC", hash_generated_field = "4481C8AC52C6328405964555E7F1E170")

    private static final InternalHandler sHandler = new InternalHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.427 -0400", hash_original_field = "F9D8C926D7381713A6244C8745A0252C", hash_generated_field = "45EF8C423315DCAE20CB6CF839040B3F")

    private static volatile Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
}

