package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Slog;
import android.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    volatile LoadTask mTask;
    volatile LoadTask mCancellingTask;
    long mUpdateThrottle;
    long mLastLoadCompleteTime = -10000;
    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.179 -0400", hash_original_method = "D12030B6AB606C68B1075214300CB0F6", hash_generated_method = "6DCFED93DBA420F1695EB3F5175A306F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AsyncTaskLoader(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.206 -0400", hash_original_method = "5FBC47B8FEAE1CF1C3C903D2FBB05A60", hash_generated_method = "B20B819532282D13D5A33175349A829C")
    @DSModeled(DSC.SAFE)
    public void setUpdateThrottle(long delayMS) {
        dsTaint.addTaint(delayMS);
        {
            mHandler = new Handler();
        } //End block
        // ---------- Original Method ----------
        //mUpdateThrottle = delayMS;
        //if (delayMS != 0) {
            //mHandler = new Handler();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.222 -0400", hash_original_method = "13FE3EE94CAD35ADE9B925A153D1E2F2", hash_generated_method = "6435E7B4014EDA7501FF84D79EF545A9")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onForceLoad() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onForceLoad();
        cancelLoad();
        mTask = new LoadTask();
        executePendingTask();
        // ---------- Original Method ----------
        //super.onForceLoad();
        //cancelLoad();
        //mTask = new LoadTask();
        //if (DEBUG) Slog.v(TAG, "Preparing load: mTask=" + mTask);
        //executePendingTask();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.253 -0400", hash_original_method = "D61160F50878CF3D95A0B223A0044CD3", hash_generated_method = "BE64DB8CFE7EBD4E0DFA9902B6A80B6E")
    @DSModeled(DSC.SAFE)
    public boolean cancelLoad() {
        {
            {
                {
                    mTask.waiting = false;
                    mHandler.removeCallbacks(mTask);
                } //End block
                mTask = null;
            } //End block
            {
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
                mTask = null;
            } //End block
            {
                boolean cancelled;
                cancelled = mTask.cancel(false);
                {
                    mCancellingTask = mTask;
                } //End block
                mTask = null;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.264 -0400", hash_original_method = "6EDCFF0D227BFAAE1F619E412FD9521B", hash_generated_method = "AB70636E5CDD778D11CCCF63DFE93259")
    @DSModeled(DSC.SAFE)
    public void onCanceled(D data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.298 -0400", hash_original_method = "45E2A10F8A270BE8E82A19AF3BE67D71", hash_generated_method = "043B4654B5C1E97F35AC6F524CE176A3")
    @DSModeled(DSC.SAFE)
     void executePendingTask() {
        {
            {
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
            } //End block
            {
                long now;
                now = SystemClock.uptimeMillis();
                {
                    mTask.waiting = true;
                    mHandler.postAtTime(mTask, mLastLoadCompleteTime+mUpdateThrottle);
                } //End block
            } //End block
            mTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.317 -0400", hash_original_method = "2AFA09BEA839A112F3D6F9C423659AF4", hash_generated_method = "C183733BE8ABDD1BA999D0602FA4D537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchOnCancelled(LoadTask task, D data) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        onCanceled(data);
        {
            mLastLoadCompleteTime = SystemClock.uptimeMillis();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.344 -0400", hash_original_method = "63FEDCADD7326B0F5C2BB0CB49E6D0DF", hash_generated_method = "D137CCE2A40EACE974E66690AB6BB554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchOnLoadComplete(LoadTask task, D data) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        {
            dispatchOnCancelled(task, data);
        } //End block
        {
            {
                boolean varCF392471541B21B47F5379E70C625C71_371095094 = (isAbandoned());
                {
                    onCanceled(data);
                } //End block
                {
                    mLastLoadCompleteTime = SystemClock.uptimeMillis();
                    mTask = null;
                    deliverResult(data);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.365 -0400", hash_original_method = "4A83A9163F83587A19BB5376A46D430D", hash_generated_method = "1B9869F5459EE65A8851C481B77FA9B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected D onLoadInBackground() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        D varCB2F890DD7CE62B190E6638DE88B6EC8_1251037923 = (loadInBackground());
        return (D)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadInBackground();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.377 -0400", hash_original_method = "13983B8AAAA767CBF57A8C7D5EF6BF65", hash_generated_method = "B69F2A4C461A7A193F2AE21B1016FCFF")
    @DSModeled(DSC.SAFE)
    public void waitForLoader() {
        LoadTask task;
        task = mTask;
        {
            try 
            {
                task.done.await();
            } //End block
            catch (InterruptedException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.408 -0400", hash_original_method = "3BD2D1BA0575E5C52E87DB33CE550D2F", hash_generated_method = "B6731A5F1DEB1B8466E6DBA0C2CAFC9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(writer.dsTaint);
        super.dump(prefix, fd, writer, args);
        {
            writer.print(prefix);
            writer.print("mTask=");
            writer.print(mTask);
            writer.print(" waiting=");
            writer.println(mTask.waiting);
        } //End block
        {
            writer.print(prefix);
            writer.print("mCancellingTask=");
            writer.print(mCancellingTask);
            writer.print(" waiting=");
            writer.println(mCancellingTask.waiting);
        } //End block
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
        D result;
        boolean waiting;
        private CountDownLatch done = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.419 -0400", hash_original_method = "DFBF37C86DDD5E9A57831EA3A10DC006", hash_generated_method = "49EED1D4BE103B8F9CAC225872485EA6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected D doInBackground(Void... params) {
            dsTaint.addTaint(params[0].dsTaint);
            result = AsyncTaskLoader.this.onLoadInBackground();
            return (D)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (DEBUG) Slog.v(TAG, this + " >>> doInBackground");
            //result = AsyncTaskLoader.this.onLoadInBackground();
            //if (DEBUG) Slog.v(TAG, this + "  <<< doInBackground");
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.428 -0400", hash_original_method = "CA3BD1BFF35CD0AF15EEE08BAA19ADDD", hash_generated_method = "1CB4843FB8B83FE355FBB709EDB0C63D")
        @DSModeled(DSC.SAFE)
        @Override
        protected void onPostExecute(D data) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(data.dsTaint);
            try 
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.437 -0400", hash_original_method = "6CC87369107415F190BB09763C783671", hash_generated_method = "24E30F88DD3FFCA3A01E442B938806A1")
        @DSModeled(DSC.SAFE)
        @Override
        protected void onCancelled() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            try 
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-14 13:13:40.446 -0400", hash_original_method = "65A4E8609F3A198276A58E99188CF50D", hash_generated_method = "A3D7CB50D3A18C07A0E486AD92E5DB33")
        @DSModeled(DSC.SAFE)
        @Override
        public void run() {
            waiting = false;
            AsyncTaskLoader.this.executePendingTask();
            // ---------- Original Method ----------
            //waiting = false;
            //AsyncTaskLoader.this.executePendingTask();
        }

        
    }


    
    static final String TAG = "AsyncTaskLoader";
    static final boolean DEBUG = false;
}

