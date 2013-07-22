package android.os;

// Droidsafe Imports
import java.util.ArrayDeque;
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AsyncTask<Params, Progress, Result> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.586 -0400", hash_original_field = "8FA972E3894E5889324591B9B189ABDC", hash_generated_field = "0C1891F28AC7C3B6ED5CCBBABEAFE2C8")

    private volatile Status mStatus = Status.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.586 -0400", hash_original_field = "B024F65C6054CDE21F0BE3765446DCC0", hash_generated_field = "D8B55EE6C63AA30A6FA811119BF88197")

    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
	private boolean cancelled;
	
	private Result result;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.588 -0400", hash_original_method = "8B3C3F162E88495B3198046B04CCAD12", hash_generated_method = "717DB90AF8B9D7E6F5C69DCC8BADBDB4")
    public  AsyncTask() {
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static void init() {
        sHandler.getLooper();
    }

     
    @DSModeled(DSC.SAFE)
    public static void setDefaultExecutor(Executor exec) {
        sDefaultExecutor = exec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.589 -0400", hash_original_method = "3B97ED7071D46F297921BB0773C1C347", hash_generated_method = "4417C4FF646E21FA130E72F92B0D4080")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.589 -0400", hash_original_method = "1FE912CF37AD5F28EFBFA6E2EE976D7C", hash_generated_method = "B93DD365EACA133CBE5CAF01133F8330")
    private Result postResult(Result result) {
        addTaint(result.getTaint());
        Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new AsyncTaskResult<Result>(this, result));
        message.sendToTarget();
Result varDC838461EE2FA0CA4C9BBB70A15456B0_1511173595 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1511173595.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1511173595;
        // ---------- Original Method ----------
        //Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                //new AsyncTaskResult<Result>(this, result));
        //message.sendToTarget();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.590 -0400", hash_original_method = "C7B50D6362AC0A992140F3FAC71C75FC", hash_generated_method = "24721B6A881CC6D3BFA92F0E1842D858")
    public final Status getStatus() {
Status var6300E74790326279AA67EB8DFA2C84B0_2080544147 =         mStatus;
        var6300E74790326279AA67EB8DFA2C84B0_2080544147.addTaint(taint);
        return var6300E74790326279AA67EB8DFA2C84B0_2080544147;
        // ---------- Original Method ----------
        //return mStatus;
    }

    
    protected abstract Result doInBackground(Params... params);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.592 -0400", hash_original_method = "D1C6308395AB600921F20543E51EAD98", hash_generated_method = "C0199AA9BD1E0917DA5290FDB264C17A")
    protected void onPreExecute() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.593 -0400", hash_original_method = "815F7407CD3192690B947D6EE1FFAB09", hash_generated_method = "C976233E37033A3D91D226FE1079E594")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onPostExecute(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.594 -0400", hash_original_method = "157B3FBC0632B3CAE882248D445D8AAC", hash_generated_method = "840A874EFC9E5D7D09065733171CECD0")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onProgressUpdate(Progress... values) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(values[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.601 -0400", hash_original_method = "D59B5ED17FD1F167CEB40DD1D5E0C9AC", hash_generated_method = "828E716C9F83A225045546A9111AE69D")
    @SuppressWarnings({"UnusedParameters"})
    protected void onCancelled(Result result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        onCancelled();
        // ---------- Original Method ----------
        //onCancelled();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.602 -0400", hash_original_method = "50EA6C215817530416AC66D7F05F78C0", hash_generated_method = "71F6D962409DFEB2E35ECE3ED38075C4")
    protected void onCancelled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.602 -0400", hash_original_method = "DB46851A4B24FCF8A49F880359D5B78C", hash_generated_method = "7429E399886A985919F57383107CAFFB")
    public final boolean isCancelled() {
    	return cancelled;
        // ---------- Original Method ----------
        //return mFuture.isCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.603 -0400", hash_original_method = "79A634F40CF588E281325883FCE2C51B", hash_generated_method = "F2B9735A675310C684553A57E2E3C5AE")
    public final boolean cancel(boolean mayInterruptIfRunning) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.604 -0400", hash_original_method = "C6B4FDC12FE10CD7E1E7DDF258371598", hash_generated_method = "0EAE5227400D7C7E424516340D585048")
    public final AsyncTask<Params, Progress, Result> execute(Params... params) {
        addTaint(params[0].getTaint());
AsyncTask<Params, Progress, Result> var0A631FF6F1525828AF54B1432444F062_247341838 =         executeOnExecutor(sDefaultExecutor, params);
        var0A631FF6F1525828AF54B1432444F062_247341838.addTaint(taint);
        return var0A631FF6F1525828AF54B1432444F062_247341838;
        // ---------- Original Method ----------
        //return executeOnExecutor(sDefaultExecutor, params);
    }

    
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

    
    public static void execute(Runnable runnable) {
    	runnable.run();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.610 -0400", hash_original_method = "0B5FDDD22527F2F69D5D9DE9D9A2B1C6", hash_generated_method = "02380C102BBCB45F93696C9F91AA3E87")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.611 -0400", hash_original_method = "14AF9B49F1E9643B41861D03798B3831", hash_generated_method = "C0F7221995D6AE74BD119A599A0BE04E")
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

    
    private static class SerialExecutor implements Executor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.611 -0400", hash_original_field = "1145DE7B0EE5DC458C0C28AC0599DE84", hash_generated_field = "261CC8077C41EBB868A3FC32621980AF")

        final ArrayDeque<Runnable> mTasks = new ArrayDeque<Runnable>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.614 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "C695A68C51ACBA3E4D3915B59F291FEB")

        Runnable mActive;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.614 -0400", hash_original_method = "AEF1DBC157AC4B04251F94F6D52131CC", hash_generated_method = "AEF1DBC157AC4B04251F94F6D52131CC")
        public SerialExecutor ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.615 -0400", hash_original_method = "7659AD0BA1D4D745C5BB94FD1DAE3D8A", hash_generated_method = "E7CAC52610C18CB672BCD87FB537429E")
        public synchronized void execute(final Runnable r) {
            addTaint(r.getTaint());
            mTasks.offer(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.615 -0400", hash_original_method = "97925E5CC02778827B83E8E0CDA5AF7A", hash_generated_method = "C4A406957E6605C6F61D04A437666DDF")
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
            if(mActive == null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.616 -0400", hash_original_method = "F246C1002CD359817FA3C3F9B99415C3", hash_generated_method = "5511270FAC8A001EAE7B4EB6D54C9579")
        protected synchronized void scheduleNext() {
            if((mActive = mTasks.poll()) != null)            
            {
                THREAD_POOL_EXECUTOR.execute(mActive);
            } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.620 -0400", hash_original_method = "702720A53E3CB2FDA0E1C09BCF5135A3", hash_generated_method = "702720A53E3CB2FDA0E1C09BCF5135A3")
        public InternalHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.620 -0400", hash_original_method = "921E33E8D8BBA9CD431C8BC69654B3A4", hash_generated_method = "3412AC0B19BEEA5471BA543EA333720D")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "3458C32F6AB59FD27DC8D66D0781D783")

        Params[] mParams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_method = "6133B28C5B62218BD6304F54DA37E6FE", hash_generated_method = "6133B28C5B62218BD6304F54DA37E6FE")
        public WorkerRunnable ()
        {
            //Synthesized constructor
        }


    }


    
    private static class AsyncTaskResult<Data> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_field = "0F416DC8E1EF1E61CE9DC1C4C6AAC524", hash_generated_field = "DF2220D9D1A3CC6FD22A416585822610")

        AsyncTask mTask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F9DF2CD3BD472144E91B572BDD352920")

        Data[] mData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_method = "4090B8C552F02AD1AD16D083FA97D251", hash_generated_method = "52BF7A64B308C34B842B3C2EDE7F1048")
          AsyncTaskResult(AsyncTask task, Data... data) {
            mTask = task;
            mData = data;
            // ---------- Original Method ----------
            //mTask = task;
            //mData = data;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_field = "633B1285E96B59FE7188F4D85CC49A51", hash_generated_field = "1621B971276E6C94E07DE79B5D168C87")

    private static final String LOG_TAG = "AsyncTask";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_field = "C3D7263FE4EB907C919B47ECE782B0BF", hash_generated_field = "CF0740E21C8B02D30E2E5C3E17F1896F")

    private static final int CORE_POOL_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.621 -0400", hash_original_field = "C992D099DBB7578480B14D215BCF43F3", hash_generated_field = "68EE0E4A694BDFD732EDA8B1D33337CD")

    private static final int MAXIMUM_POOL_SIZE = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "0262667811769BEE2F069CB2EAB3EE82", hash_generated_field = "874374A7281CFF977630F5545E6B2AEF")

    private static final int KEEP_ALIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.861 -0400", hash_original_field = "CE50E0B18A35D10A1792CE5C702A9A23", hash_generated_field = "EFD974F406D7D4004DF1FB489A6EC4A2")

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.860 -0400", hash_original_field = "0400DCCD0AD37CE0396AA49E9A3A5070", hash_generated_field = "53BD2EF82B0D2291D1219E89FB31ADA8")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "832D0AB7F691D38DFCF25F1C48444796", hash_generated_field = "7AD4AF9308A3B3C68CAA0C63DB5A78BD")

    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "7656CA2646F7AF011CC114CB7F68F158", hash_generated_field = "36170CD50FC27C086EA38F1C050DEB00")

    public static final Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "1D982443E9892659AFAD933B002EEEC9", hash_generated_field = "7E466585D02C6A4723DB3DC0EB68409E")

    public static final Executor SERIAL_EXECUTOR = new SerialExecutor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "8DEDF8C9E90E9561E2346963E5898747", hash_generated_field = "7C8C89B7EC349B108F0ED9BCFCF0D4AD")

    private static final int MESSAGE_POST_RESULT = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "9C5866459C52559035C2AED46C43B074", hash_generated_field = "A378167BD77B73C746FF0D775F9CDF82")

    private static final int MESSAGE_POST_PROGRESS = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "8235EF876A5F3E4DF366DDAE5A4B03BC", hash_generated_field = "4481C8AC52C6328405964555E7F1E170")

    private static final InternalHandler sHandler = new InternalHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.622 -0400", hash_original_field = "D77D76EC84F8B9D382D2A734841EA4C7", hash_generated_field = "D10EB867669B9665863D7E252CF6C534")

    private static volatile Executor sDefaultExecutor = SERIAL_EXECUTOR;
}

