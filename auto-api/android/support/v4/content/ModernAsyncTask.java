package android.support.v4.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.346 -0400", hash_original_field = "BB30BA3EDC46FDDC92BDFE7FACA691F0", hash_generated_field = "DAAB2689B37CB24EEF0B8E3B973EEFF3")

    private WorkerRunnable<Params, Result> mWorker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.346 -0400", hash_original_field = "76BB93AB423B813C0C115E37BB7B0147", hash_generated_field = "6DAED75BC4A1450C0B66E4CCB009EB53")

    private FutureTask<Result> mFuture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.346 -0400", hash_original_field = "8FA972E3894E5889324591B9B189ABDC", hash_generated_field = "0C1891F28AC7C3B6ED5CCBBABEAFE2C8")

    private volatile Status mStatus = Status.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.346 -0400", hash_original_field = "B024F65C6054CDE21F0BE3765446DCC0", hash_generated_field = "D8B55EE6C63AA30A6FA811119BF88197")

    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.348 -0400", hash_original_method = "23205AF15CA33077DF5B8FA9588BE2E9", hash_generated_method = "B588ED3822068A4ED574571AF83F655D")
    public  ModernAsyncTask() {
        mWorker = new WorkerRunnable<Params, Result>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.347 -0400", hash_original_method = "A54B00CDBBB35FABA36BF774EC6EA22F", hash_generated_method = "E82C11FACC0AA2E44F20FEB4A5F7F2B1")
            public Result call() throws Exception {
                Result varB4EAC82CA7396A68D541C85D26508E83_2081208495 = null; 
                mTaskInvoked.set(true);
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                varB4EAC82CA7396A68D541C85D26508E83_2081208495 = postResult(doInBackground(mParams));
                varB4EAC82CA7396A68D541C85D26508E83_2081208495.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_2081208495;
                
                
                
                
            }
};
        mFuture = new FutureTask<Result>(mWorker) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.348 -0400", hash_original_method = "EC5824A2B7431B45243C7897F66BDC0A", hash_generated_method = "410AA128957C71B99B2E8DAF46280732")
            @Override
            protected void done() {
                try 
                {
                    final Result result = get();
                    postResultIfNotInvoked(result);
                } 
                catch (InterruptedException e)
                {
                    android.util.Log.w(LOG_TAG, e);
                } 
                catch (ExecutionException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("An error occured while executing doInBackground()",
                            e.getCause());
                } 
                catch (CancellationException e)
                {
                    postResultIfNotInvoked(null);
                } 
                catch (Throwable t)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("An error occured while executing "
                            + "doInBackground()", t);
                } 
                
                
                    
                    
                
                    
                
                    
                            
                
                    
                
                    
                            
                
            }
};
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static void init() {
        sHandler.getLooper();
    }

    
        public static void setDefaultExecutor(Executor exec) {
        sDefaultExecutor = exec;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.349 -0400", hash_original_method = "3B97ED7071D46F297921BB0773C1C347", hash_generated_method = "1548A4747F0B0E03EAF9605E4E62FA95")
    private void postResultIfNotInvoked(Result result) {
        final boolean wasTaskInvoked = mTaskInvoked.get();
        {
            postResult(result);
        } 
        addTaint(result.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.349 -0400", hash_original_method = "1FE912CF37AD5F28EFBFA6E2EE976D7C", hash_generated_method = "70F8E7A8E080E7A22AB10AD34F277858")
    private Result postResult(Result result) {
        Result varB4EAC82CA7396A68D541C85D26508E83_1312622964 = null; 
        Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new AsyncTaskResult<Result>(this, result));
        message.sendToTarget();
        varB4EAC82CA7396A68D541C85D26508E83_1312622964 = result;
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1312622964.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1312622964;
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.350 -0400", hash_original_method = "C7B50D6362AC0A992140F3FAC71C75FC", hash_generated_method = "5572EC7562E2AAE407E851D14E47D742")
    public final Status getStatus() {
        Status varB4EAC82CA7396A68D541C85D26508E83_1346218823 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1346218823 = mStatus;
        varB4EAC82CA7396A68D541C85D26508E83_1346218823.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1346218823;
        
        
    }

    
    protected abstract Result doInBackground(Params... params);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.351 -0400", hash_original_method = "D1C6308395AB600921F20543E51EAD98", hash_generated_method = "C0199AA9BD1E0917DA5290FDB264C17A")
    protected void onPreExecute() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.351 -0400", hash_original_method = "815F7407CD3192690B947D6EE1FFAB09", hash_generated_method = "C976233E37033A3D91D226FE1079E594")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onPostExecute(Result result) {
        
        addTaint(result.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.352 -0400", hash_original_method = "157B3FBC0632B3CAE882248D445D8AAC", hash_generated_method = "840A874EFC9E5D7D09065733171CECD0")
    @SuppressWarnings({"UnusedDeclaration"})
    protected void onProgressUpdate(Progress... values) {
        
        addTaint(values[0].getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.352 -0400", hash_original_method = "D59B5ED17FD1F167CEB40DD1D5E0C9AC", hash_generated_method = "295E24CF2011E2415E50209BC2862E86")
    @SuppressWarnings({"UnusedParameters"})
    protected void onCancelled(Result result) {
        
        onCancelled();
        addTaint(result.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.353 -0400", hash_original_method = "50EA6C215817530416AC66D7F05F78C0", hash_generated_method = "71F6D962409DFEB2E35ECE3ED38075C4")
    protected void onCancelled() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.353 -0400", hash_original_method = "DB46851A4B24FCF8A49F880359D5B78C", hash_generated_method = "6CF3E0F544B781A7904BE1C9963FB473")
    public final boolean isCancelled() {
        boolean varE689F9A33D91E57560F3F7F78307B4C2_180236529 = (mFuture.isCancelled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665236196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_665236196;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.353 -0400", hash_original_method = "79A634F40CF588E281325883FCE2C51B", hash_generated_method = "6EC35C4D903F8269A7E365492BF4F54C")
    public final boolean cancel(boolean mayInterruptIfRunning) {
        boolean var9435D92544DADC2A7A666A5C650C1855_146930370 = (mFuture.cancel(mayInterruptIfRunning));
        addTaint(mayInterruptIfRunning);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431350712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431350712;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.354 -0400", hash_original_method = "6419D225056356234AD0A7B8CC3CE063", hash_generated_method = "0AA46E25B087D0B62C6F2343C02BC253")
    public final Result get() throws InterruptedException, ExecutionException {
        Result varB4EAC82CA7396A68D541C85D26508E83_441160704 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_441160704 = mFuture.get();
        varB4EAC82CA7396A68D541C85D26508E83_441160704.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_441160704;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.354 -0400", hash_original_method = "7D7E6E809B7EB95E206E2FFE71D3D78F", hash_generated_method = "57E80BFE58866EAB6C0B58EB5B322D87")
    public final Result get(long timeout, TimeUnit unit) throws InterruptedException,
            ExecutionException, TimeoutException {
        Result varB4EAC82CA7396A68D541C85D26508E83_759029964 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_759029964 = mFuture.get(timeout, unit);
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_759029964.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_759029964;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.355 -0400", hash_original_method = "88E70239038C6B17199526F5A138B52C", hash_generated_method = "306427E5AC1DCB6EC30A663B0B9CCA88")
    public final ModernAsyncTask<Params, Progress, Result> execute(Params... params) {
        ModernAsyncTask<Params, Progress, Result> varB4EAC82CA7396A68D541C85D26508E83_1667449874 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1667449874 = executeOnExecutor(sDefaultExecutor, params);
        addTaint(params[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1667449874.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1667449874;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.356 -0400", hash_original_method = "2D658F6D3BDE5104FE23D8DBAC134A95", hash_generated_method = "99473BD52981F1F6F1D17AF397D53C64")
    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor exec,
            Params... params) {
        ModernAsyncTask<Params, Progress, Result> varB4EAC82CA7396A68D541C85D26508E83_339560414 = null; 
        {
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot execute task:"
                            + " the task is already running.");
            
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot execute task:"
                            + " the task has already been executed "
                            + "(a task can be executed only once)");
            
        } 
        mStatus = Status.RUNNING;
        onPreExecute();
        mWorker.mParams = params;
        exec.execute(mFuture);
        varB4EAC82CA7396A68D541C85D26508E83_339560414 = this;
        addTaint(exec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_339560414.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_339560414;
        
        
            
                
                    
                            
                
                    
                            
                            
            
        
        
        
        
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.356 -0400", hash_original_method = "0B5FDDD22527F2F69D5D9DE9D9A2B1C6", hash_generated_method = "29E40A86CE91614906F97277FEFCD9AB")
    protected final void publishProgress(Progress... values) {
        {
            boolean var400FC4A64E54A86E4D11CC7D9451AF61_862345905 = (!isCancelled());
            {
                sHandler.obtainMessage(MESSAGE_POST_PROGRESS,
                    new AsyncTaskResult<Progress>(this, values)).sendToTarget();
            } 
        } 
        addTaint(values[0].getTaint());
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.357 -0400", hash_original_method = "14AF9B49F1E9643B41861D03798B3831", hash_generated_method = "C512088CAE236C7B6531774C78D6B5E4")
    private void finish(Result result) {
        {
            boolean var08348B91A6AA0A281F1856BF13E9F87F_1982890713 = (isCancelled());
            {
                onCancelled(result);
            } 
            {
                onPostExecute(result);
            } 
        } 
        mStatus = Status.FINISHED;
        addTaint(result.getTaint());
        
        
            
        
            
        
        
    }

    
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED,
    }

    
    private static class InternalHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.357 -0400", hash_original_method = "702720A53E3CB2FDA0E1C09BCF5135A3", hash_generated_method = "702720A53E3CB2FDA0E1C09BCF5135A3")
        public InternalHandler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.357 -0400", hash_original_method = "921E33E8D8BBA9CD431C8BC69654B3A4", hash_generated_method = "45BF69A47FDC9FEEE8FBBA9D3C925D3C")
        @SuppressWarnings({"unchecked", "RawUseOfParameterizedType"})
        @Override
        public void handleMessage(Message msg) {
            AsyncTaskResult result = (AsyncTaskResult) msg.obj;
            
            result.mTask.finish(result.mData[0]);
            
            
            result.mTask.onProgressUpdate(result.mData);
            
            addTaint(msg.getTaint());
            
            
            
                
                    
                    
                
                    
                    
            
        }

        
    }


    
    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.357 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "3458C32F6AB59FD27DC8D66D0781D783")

        Params[] mParams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.357 -0400", hash_original_method = "6133B28C5B62218BD6304F54DA37E6FE", hash_generated_method = "6133B28C5B62218BD6304F54DA37E6FE")
        public WorkerRunnable ()
        {
            
        }


    }


    
    private static class AsyncTaskResult<Data> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.357 -0400", hash_original_field = "0F416DC8E1EF1E61CE9DC1C4C6AAC524", hash_generated_field = "F304F0D2C5C31A00544C8D41C67529B9")

        ModernAsyncTask mTask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.357 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F9DF2CD3BD472144E91B572BDD352920")

        Data[] mData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.358 -0400", hash_original_method = "D5FEEE1684992AD45A8A3E14AF387D03", hash_generated_method = "8EDA58525A416148F14DD2AE98C68390")
          AsyncTaskResult(ModernAsyncTask task, Data... data) {
            mTask = task;
            mData = data;
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.358 -0400", hash_original_field = "633B1285E96B59FE7188F4D85CC49A51", hash_generated_field = "1621B971276E6C94E07DE79B5D168C87")

    private static final String LOG_TAG = "AsyncTask";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.358 -0400", hash_original_field = "C3D7263FE4EB907C919B47ECE782B0BF", hash_generated_field = "CF0740E21C8B02D30E2E5C3E17F1896F")

    private static final int CORE_POOL_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.358 -0400", hash_original_field = "C992D099DBB7578480B14D215BCF43F3", hash_generated_field = "68EE0E4A694BDFD732EDA8B1D33337CD")

    private static final int MAXIMUM_POOL_SIZE = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.358 -0400", hash_original_field = "0262667811769BEE2F069CB2EAB3EE82", hash_generated_field = "874374A7281CFF977630F5545E6B2AEF")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_field = "832D0AB7F691D38DFCF25F1C48444796", hash_generated_field = "7AD4AF9308A3B3C68CAA0C63DB5A78BD")

    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_field = "7656CA2646F7AF011CC114CB7F68F158", hash_generated_field = "36170CD50FC27C086EA38F1C050DEB00")

    public static final Executor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_field = "8DEDF8C9E90E9561E2346963E5898747", hash_generated_field = "7C8C89B7EC349B108F0ED9BCFCF0D4AD")

    private static final int MESSAGE_POST_RESULT = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_field = "9C5866459C52559035C2AED46C43B074", hash_generated_field = "A378167BD77B73C746FF0D775F9CDF82")

    private static final int MESSAGE_POST_PROGRESS = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_field = "8235EF876A5F3E4DF366DDAE5A4B03BC", hash_generated_field = "4481C8AC52C6328405964555E7F1E170")

    private static final InternalHandler sHandler = new InternalHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.359 -0400", hash_original_field = "F9D8C926D7381713A6244C8745A0252C", hash_generated_field = "45EF8C423315DCAE20CB6CF839040B3F")

    private static volatile Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
}

