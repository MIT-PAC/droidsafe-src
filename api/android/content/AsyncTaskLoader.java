package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Slog;
import android.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.266 -0400", hash_original_field = "0F416DC8E1EF1E61CE9DC1C4C6AAC524", hash_generated_field = "5C3107BBF367803569D0AB8A39076D22")

    volatile LoadTask mTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.267 -0400", hash_original_field = "EDF7920DB00DE49F0F969383ED96ADCF", hash_generated_field = "3D2A32ED16FA4BFF500D2C906E32BFB2")

    volatile LoadTask mCancellingTask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.268 -0400", hash_original_field = "02ECB78B7782D2E17D2F48FF5560193C", hash_generated_field = "0CC16960397661E2A91A0C1245907990")

    long mUpdateThrottle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.268 -0400", hash_original_field = "9BA75F3ADE66FC882D737169079E87F5", hash_generated_field = "068F47D76DDC530CAC2DF35289A5CFB4")

    long mLastLoadCompleteTime = -10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.269 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.271 -0400", hash_original_method = "D12030B6AB606C68B1075214300CB0F6", hash_generated_method = "9F1C3BF057BEA8A30936008A3BBCBD74")
    public  AsyncTaskLoader(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.274 -0400", hash_original_method = "5FBC47B8FEAE1CF1C3C903D2FBB05A60", hash_generated_method = "2BDEECA3E40FF7A58BCB81FE6C24B787")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.277 -0400", hash_original_method = "13FE3EE94CAD35ADE9B925A153D1E2F2", hash_generated_method = "2CC91AC2A040002D59FF9B983B18E4A9")
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
        //if (DEBUG) Slog.v(TAG, "Preparing load: mTask=" + mTask);
        //executePendingTask();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.289 -0400", hash_original_method = "D61160F50878CF3D95A0B223A0044CD3", hash_generated_method = "7D7E3CFE4AE69D5A135F138369A89F3E")
    public boolean cancelLoad() {
        if(DEBUG){ }        if(mTask != null)        
        {
            if(mCancellingTask != null)            
            {
                if(DEBUG){ }                if(mTask.waiting)                
                {
                    mTask.waiting = false;
                    mHandler.removeCallbacks(mTask);
                } //End block
                mTask = null;
                boolean var68934A3E9455FA72420237EB05902327_793937272 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738222362 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738222362;
            } //End block
            else
            if(mTask.waiting)            
            {
                if(DEBUG){ }                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
                mTask = null;
                boolean var68934A3E9455FA72420237EB05902327_871394814 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244408262 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244408262;
            } //End block
            else
            {
                boolean cancelled = mTask.cancel(false);
                if(DEBUG){ }                if(cancelled)                
                {
                    mCancellingTask = mTask;
                } //End block
                mTask = null;
                boolean var38881E0A24039DC2621E1D6F86CB71F7_1511203263 = (cancelled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901242581 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901242581;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1961464626 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359129814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_359129814;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.299 -0400", hash_original_method = "6EDCFF0D227BFAAE1F619E412FD9521B", hash_generated_method = "0F4F990AA22D5996D91D9A1E1C026B8F")
    public void onCanceled(D data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.303 -0400", hash_original_method = "45E2A10F8A270BE8E82A19AF3BE67D71", hash_generated_method = "62DF043DEEEF5C876731596F536A7654")
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
            if(DEBUG){ }            mTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.308 -0400", hash_original_method = "2AFA09BEA839A112F3D6F9C423659AF4", hash_generated_method = "E11AB181F82762133ECE6D238A6231E2")
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
            //if (DEBUG) Slog.v(TAG, "Cancelled task is now canceled!");
            //mLastLoadCompleteTime = SystemClock.uptimeMillis();
            //mCancellingTask = null;
            //executePendingTask();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.318 -0400", hash_original_method = "63FEDCADD7326B0F5C2BB0CB49E6D0DF", hash_generated_method = "10B99FC56D3E23C8A81D2256D803AF77")
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
            //if (DEBUG) Slog.v(TAG, "Load complete of old task, trying to cancel");
            //dispatchOnCancelled(task, data);
        //} else {
            //if (isAbandoned()) {
                //onCanceled(data);
            //} else {
                //mLastLoadCompleteTime = SystemClock.uptimeMillis();
                //mTask = null;
                //if (DEBUG) Slog.v(TAG, "Delivering result");
                //deliverResult(data);
            //}
        //}
    }

    
    public abstract D loadInBackground();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.323 -0400", hash_original_method = "4A83A9163F83587A19BB5376A46D430D", hash_generated_method = "357197113F04D8900F3BBD73EB125E23")
    protected D onLoadInBackground() {
        //DSFIXME:  CODE0009: Possible callback target function detected
D var7522CCD187CB392DA75B6694C38569FC_616122858 =         loadInBackground();
        var7522CCD187CB392DA75B6694C38569FC_616122858.addTaint(taint);
        return var7522CCD187CB392DA75B6694C38569FC_616122858;
        // ---------- Original Method ----------
        //return loadInBackground();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.325 -0400", hash_original_method = "13983B8AAAA767CBF57A8C7D5EF6BF65", hash_generated_method = "B676BD6A52869B5090A9640B485DB77E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.332 -0400", hash_original_method = "3BD2D1BA0575E5C52E87DB33CE550D2F", hash_generated_method = "2B8AC69A86699D6FC3EF3021C3DD71C5")
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

    
    final class LoadTask extends AsyncTask<Void, Void, D> implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.338 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "582B22379A32E8937A90E0545A184CFB")

        D result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.340 -0400", hash_original_field = "CB05CAB65AFEFAB8FD3831D92CFC68BE", hash_generated_field = "4B5AD997260D6A7F7067C9C9B5D02B34")

        boolean waiting;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.342 -0400", hash_original_field = "E59FCAF1FB9C927C0B18C71A73C87BFA", hash_generated_field = "F0455DF121EFC5ECE22AA733E5351602")

        private CountDownLatch done = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.343 -0400", hash_original_method = "16D80339785A96B3DBCA213BDE6C22F0", hash_generated_method = "16D80339785A96B3DBCA213BDE6C22F0")
        public LoadTask ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.348 -0400", hash_original_method = "DFBF37C86DDD5E9A57831EA3A10DC006", hash_generated_method = "93F0ABC7DF4771D9E4C0E749DE17E1FD")
        @Override
        protected D doInBackground(Void... params) {
            addTaint(params[0].getTaint());
            if(DEBUG){ }            result = AsyncTaskLoader.this.onLoadInBackground();
            if(DEBUG){ }D varDC838461EE2FA0CA4C9BBB70A15456B0_1381957786 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1381957786.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1381957786;
            // ---------- Original Method ----------
            //if (DEBUG) Slog.v(TAG, this + " >>> doInBackground");
            //result = AsyncTaskLoader.this.onLoadInBackground();
            //if (DEBUG) Slog.v(TAG, this + "  <<< doInBackground");
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.350 -0400", hash_original_method = "CA3BD1BFF35CD0AF15EEE08BAA19ADDD", hash_generated_method = "F8CF3AE47699FD39E2D8DB2B59C8C72E")
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
            //if (DEBUG) Slog.v(TAG, this + " onPostExecute");
            //try {
                //AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            //} finally {
                //done.countDown();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.354 -0400", hash_original_method = "6CC87369107415F190BB09763C783671", hash_generated_method = "87B1ABED05A636384E5F430ECF9A613D")
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
            //if (DEBUG) Slog.v(TAG, this + " onCancelled");
            //try {
                //AsyncTaskLoader.this.dispatchOnCancelled(this, result);
            //} finally {
                //done.countDown();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.359 -0400", hash_original_method = "65A4E8609F3A198276A58E99188CF50D", hash_generated_method = "A3D7CB50D3A18C07A0E486AD92E5DB33")
        @Override
        public void run() {
            waiting = false;
            AsyncTaskLoader.this.executePendingTask();
            // ---------- Original Method ----------
            //waiting = false;
            //AsyncTaskLoader.this.executePendingTask();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.361 -0400", hash_original_field = "642F64B2F6B3B4A629E0B76845D23A2B", hash_generated_field = "E2B79C20584722CC23AA6431B7343097")

    static final String TAG = "AsyncTaskLoader";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.363 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
}

