package android.support.v4.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.261 -0400", hash_original_field = "0F416DC8E1EF1E61CE9DC1C4C6AAC524", hash_generated_field = "5C3107BBF367803569D0AB8A39076D22")

    volatile LoadTask mTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.261 -0400", hash_original_field = "EDF7920DB00DE49F0F969383ED96ADCF", hash_generated_field = "3D2A32ED16FA4BFF500D2C906E32BFB2")

    volatile LoadTask mCancellingTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.261 -0400", hash_original_field = "02ECB78B7782D2E17D2F48FF5560193C", hash_generated_field = "0CC16960397661E2A91A0C1245907990")

    long mUpdateThrottle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.261 -0400", hash_original_field = "9BA75F3ADE66FC882D737169079E87F5", hash_generated_field = "068F47D76DDC530CAC2DF35289A5CFB4")

    long mLastLoadCompleteTime = -10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.261 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.262 -0400", hash_original_method = "D12030B6AB606C68B1075214300CB0F6", hash_generated_method = "9F1C3BF057BEA8A30936008A3BBCBD74")
    public  AsyncTaskLoader(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.262 -0400", hash_original_method = "5FBC47B8FEAE1CF1C3C903D2FBB05A60", hash_generated_method = "2BDEECA3E40FF7A58BCB81FE6C24B787")
    public void setUpdateThrottle(long delayMS) {
        mUpdateThrottle = delayMS;
    if(delayMS != 0)        
        {
            mHandler = new Handler();
        } //End block
        // ---------- Original Method ----------
        //mUpdateThrottle = delayMS;
        //if (delayMS != 0) {
            //mHandler = new Handler();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.263 -0400", hash_original_method = "432E7B986B9CB9166C0D2E103A5093E2", hash_generated_method = "98784D694CDE9210C7AD1BC559086B5F")
    @Override
    protected void onForceLoad() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onForceLoad();
        cancelLoad();
        mTask = new LoadTask();
    if(DEBUG){ }        executePendingTask();
        // ---------- Original Method ----------
        //super.onForceLoad();
        //cancelLoad();
        //mTask = new LoadTask();
        //if (DEBUG) Log.v(TAG, "Preparing load: mTask=" + mTask);
        //executePendingTask();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.271 -0400", hash_original_method = "EED9AFD45373FFA0657A2114031AE14C", hash_generated_method = "5D3FE98D59DDD5DED6A31D290C21BD94")
    public boolean cancelLoad() {
    if(DEBUG){ }    if(mTask != null)        
        {
    if(mCancellingTask != null)            
            {
    if(DEBUG){ }    if(mTask.waiting)                
                {
                    mTask.waiting = false;
                    mHandler.removeCallbacks(mTask);
                } //End block
                mTask = null;
                boolean var68934A3E9455FA72420237EB05902327_186431196 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1124922694 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1124922694;
            } //End block
            else
    if(mTask.waiting)            
            {
    if(DEBUG){ }                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
                mTask = null;
                boolean var68934A3E9455FA72420237EB05902327_1233725685 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936159344 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_936159344;
            } //End block
            else
            {
                boolean cancelled = mTask.cancel(false);
    if(DEBUG){ }    if(cancelled)                
                {
                    mCancellingTask = mTask;
                } //End block
                mTask = null;
                boolean var38881E0A24039DC2621E1D6F86CB71F7_734271741 = (cancelled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090861181 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090861181;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1826653275 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103209640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103209640;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.271 -0400", hash_original_method = "6EDCFF0D227BFAAE1F619E412FD9521B", hash_generated_method = "0F4F990AA22D5996D91D9A1E1C026B8F")
    public void onCanceled(D data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.272 -0400", hash_original_method = "DFA4BC3BC4931E8E36EC6E65D042E4CC", hash_generated_method = "56935E9C12CA04F2379A59D652493C9A")
     void executePendingTask() {
    if(mCancellingTask == null && mTask != null)        
        {
    if(mTask.waiting)            
            {
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
            } //End block
    if(mUpdateThrottle > 0)            
            {
                long now = SystemClock.uptimeMillis();
    if(now < (mLastLoadCompleteTime+mUpdateThrottle))                
                {
    if(DEBUG){ }                    mTask.waiting = true;
                    mHandler.postAtTime(mTask, mLastLoadCompleteTime+mUpdateThrottle);
                    return;
                } //End block
            } //End block
    if(DEBUG){ }            mTask.executeOnExecutor(ModernAsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.272 -0400", hash_original_method = "BF74607E5A027725B948953035D3427E", hash_generated_method = "377F1B0AA1B8351EC1E6D497A7FF238D")
     void dispatchOnCancelled(LoadTask task, D data) {
        addTaint(data.getTaint());
        addTaint(task.getTaint());
        onCanceled(data);
    if(mCancellingTask == task)        
        {
    if(DEBUG){ }            mLastLoadCompleteTime = SystemClock.uptimeMillis();
            mCancellingTask = null;
            executePendingTask();
        } //End block
        // ---------- Original Method ----------
        //onCanceled(data);
        //if (mCancellingTask == task) {
            //if (DEBUG) Log.v(TAG, "Cancelled task is now canceled!");
            //mLastLoadCompleteTime = SystemClock.uptimeMillis();
            //mCancellingTask = null;
            //executePendingTask();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.272 -0400", hash_original_method = "A2F1D76D2090E39A2E66817DE2784754", hash_generated_method = "3BCD1C4A0B5DA7A46D83D230F0A8BA15")
     void dispatchOnLoadComplete(LoadTask task, D data) {
        addTaint(data.getTaint());
        addTaint(task.getTaint());
    if(mTask != task)        
        {
    if(DEBUG){ }            dispatchOnCancelled(task, data);
        } //End block
        else
        {
    if(isAbandoned())            
            {
                onCanceled(data);
            } //End block
            else
            {
                mLastLoadCompleteTime = SystemClock.uptimeMillis();
                mTask = null;
    if(DEBUG){ }                deliverResult(data);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mTask != task) {
            //if (DEBUG) Log.v(TAG, "Load complete of old task, trying to cancel");
            //dispatchOnCancelled(task, data);
        //} else {
            //if (isAbandoned()) {
                //onCanceled(data);
            //} else {
                //mLastLoadCompleteTime = SystemClock.uptimeMillis();
                //mTask = null;
                //if (DEBUG) Log.v(TAG, "Delivering result");
                //deliverResult(data);
            //}
        //}
    }

    
    public abstract D loadInBackground();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.272 -0400", hash_original_method = "4A83A9163F83587A19BB5376A46D430D", hash_generated_method = "63462BA86D5EB3129D0543FF64A055A7")
    protected D onLoadInBackground() {
        //DSFIXME:  CODE0009: Possible callback target function detected
D var7522CCD187CB392DA75B6694C38569FC_1042541103 =         loadInBackground();
        var7522CCD187CB392DA75B6694C38569FC_1042541103.addTaint(taint);
        return var7522CCD187CB392DA75B6694C38569FC_1042541103;
        // ---------- Original Method ----------
        //return loadInBackground();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.272 -0400", hash_original_method = "13983B8AAAA767CBF57A8C7D5EF6BF65", hash_generated_method = "B676BD6A52869B5090A9640B485DB77E")
    public void waitForLoader() {
        LoadTask task = mTask;
    if(task != null)        
        {
            try 
            {
                task.done.await();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //LoadTask task = mTask;
        //if (task != null) {
            //try {
                //task.done.await();
            //} catch (InterruptedException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_method = "3BD2D1BA0575E5C52E87DB33CE550D2F", hash_generated_method = "2B8AC69A86699D6FC3EF3021C3DD71C5")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
        super.dump(prefix, fd, writer, args);
    if(mTask != null)        
        {
            writer.print(prefix);
            writer.print("mTask=");
            writer.print(mTask);
            writer.print(" waiting=");
            writer.println(mTask.waiting);
        } //End block
    if(mCancellingTask != null)        
        {
            writer.print(prefix);
            writer.print("mCancellingTask=");
            writer.print(mCancellingTask);
            writer.print(" waiting=");
            writer.println(mCancellingTask.waiting);
        } //End block
    if(mUpdateThrottle != 0)        
        {
            writer.print(prefix);
            writer.print("mUpdateThrottle=");
            TimeUtils.formatDuration(mUpdateThrottle, writer);
            writer.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(mLastLoadCompleteTime,
                            SystemClock.uptimeMillis(), writer);
            writer.println();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "582B22379A32E8937A90E0545A184CFB")

        D result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_field = "CB05CAB65AFEFAB8FD3831D92CFC68BE", hash_generated_field = "4B5AD997260D6A7F7067C9C9B5D02B34")

        boolean waiting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_field = "E59FCAF1FB9C927C0B18C71A73C87BFA", hash_generated_field = "F0455DF121EFC5ECE22AA733E5351602")

        private CountDownLatch done = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_method = "16D80339785A96B3DBCA213BDE6C22F0", hash_generated_method = "16D80339785A96B3DBCA213BDE6C22F0")
        public LoadTask ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_method = "962D018A6346A7B0135AC9FF7B03DD4E", hash_generated_method = "AA0B0C45C914A527A88ED5F07209F530")
        @Override
        protected D doInBackground(Void... params) {
            addTaint(params[0].getTaint());
    if(DEBUG){ }            result = AsyncTaskLoader.this.onLoadInBackground();
    if(DEBUG){ }D varDC838461EE2FA0CA4C9BBB70A15456B0_1998206749 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1998206749.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1998206749;
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, this + " >>> doInBackground");
            //result = AsyncTaskLoader.this.onLoadInBackground();
            //if (DEBUG) Log.v(TAG, this + "  <<< doInBackground");
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_method = "58FAE55DC10E415A2FA190657D4F1D85", hash_generated_method = "63B4541D12E91A63EEE43C00050E6559")
        @Override
        protected void onPostExecute(D data) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(data.getTaint());
    if(DEBUG){ }            try 
            {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            } //End block
            finally 
            {
                done.countDown();
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, this + " onPostExecute");
            //try {
                //AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            //} finally {
                //done.countDown();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.273 -0400", hash_original_method = "B83F1AA509F54D59951BAD91749D4A0A", hash_generated_method = "7E9F53F70FEDD5B4E50A5542E92F1A8B")
        @Override
        protected void onCancelled() {
            //DSFIXME:  CODE0009: Possible callback target function detected
    if(DEBUG){ }            try 
            {
                AsyncTaskLoader.this.dispatchOnCancelled(this, result);
            } //End block
            finally 
            {
                done.countDown();
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, this + " onCancelled");
            //try {
                //AsyncTaskLoader.this.dispatchOnCancelled(this, result);
            //} finally {
                //done.countDown();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.274 -0400", hash_original_method = "65A4E8609F3A198276A58E99188CF50D", hash_generated_method = "A3D7CB50D3A18C07A0E486AD92E5DB33")
        @Override
        public void run() {
            waiting = false;
            AsyncTaskLoader.this.executePendingTask();
            // ---------- Original Method ----------
            //waiting = false;
            //AsyncTaskLoader.this.executePendingTask();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.274 -0400", hash_original_field = "642F64B2F6B3B4A629E0B76845D23A2B", hash_generated_field = "E2B79C20584722CC23AA6431B7343097")

    static final String TAG = "AsyncTaskLoader";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.274 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
}

