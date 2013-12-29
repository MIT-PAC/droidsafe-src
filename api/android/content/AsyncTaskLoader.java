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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.835 -0500", hash_original_field = "F240A5C69F8AA9B45906194AB2ADEC92", hash_generated_field = "E2B79C20584722CC23AA6431B7343097")

    static final String TAG = "AsyncTaskLoader";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.836 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.844 -0500", hash_original_field = "0D8054BDEEA0AA0CC72AD8EB23D29AE2", hash_generated_field = "5C3107BBF367803569D0AB8A39076D22")


    volatile LoadTask mTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.844 -0500", hash_original_field = "3B3013D7772F24F621F8C9729AD8E28A", hash_generated_field = "3D2A32ED16FA4BFF500D2C906E32BFB2")

    volatile LoadTask mCancellingTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.845 -0500", hash_original_field = "0CC16960397661E2A91A0C1245907990", hash_generated_field = "0CC16960397661E2A91A0C1245907990")


    long mUpdateThrottle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.846 -0500", hash_original_field = "068F47D76DDC530CAC2DF35289A5CFB4", hash_generated_field = "068F47D76DDC530CAC2DF35289A5CFB4")

    long mLastLoadCompleteTime = -10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.847 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.847 -0500", hash_original_method = "D12030B6AB606C68B1075214300CB0F6", hash_generated_method = "96C9B7975FBAAEAD2973F88F4D729C01")
    public AsyncTaskLoader(Context context) {
        super(context);
    }

    /**
     * Set amount to throttle updates by.  This is the minimum time from
     * when the last {@link #onLoadInBackground()} call has completed until
     * a new load is scheduled.
     *
     * @param delayMS Amount of delay, in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.848 -0500", hash_original_method = "5FBC47B8FEAE1CF1C3C903D2FBB05A60", hash_generated_method = "7AF80CA8C36B293048A99FC2A0AFDF65")
    public void setUpdateThrottle(long delayMS) {
        mUpdateThrottle = delayMS;
        if (delayMS != 0) {
            mHandler = new Handler();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.849 -0500", hash_original_method = "13FE3EE94CAD35ADE9B925A153D1E2F2", hash_generated_method = "9B9E069F9B9FE01A4EC836C4C16C0927")
    @Override
protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        mTask = new LoadTask();
        if (DEBUG) Slog.v(TAG, "Preparing load: mTask=" + mTask);
        executePendingTask();
    }

    /**
     * Attempt to cancel the current load task. See {@link AsyncTask#cancel(boolean)}
     * for more info.  Must be called on the main thread of the process.
     *
     * <p>Cancelling is not an immediate operation, since the load is performed
     * in a background thread.  If there is currently a load in progress, this
     * method requests that the load be cancelled, and notes this is the case;
     * once the background thread has completed its work its remaining state
     * will be cleared.  If another load request comes in during this time,
     * it will be held until the cancelled load is complete.
     *
     * @return Returns <tt>false</tt> if the task could not be cancelled,
     *         typically because it has already completed normally, or
     *         because {@link #startLoading()} hasn't been called; returns
     *         <tt>true</tt> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.850 -0500", hash_original_method = "D61160F50878CF3D95A0B223A0044CD3", hash_generated_method = "154D154DC32BA2A5A0D3464A2BE0C207")
    public boolean cancelLoad() {
        if (DEBUG) Slog.v(TAG, "cancelLoad: mTask=" + mTask);
        if (mTask != null) {
            if (mCancellingTask != null) {
                // There was a pending task already waiting for a previous
                // one being canceled; just drop it.
                if (DEBUG) Slog.v(TAG,
                        "cancelLoad: still waiting for cancelled task; dropping next");
                if (mTask.waiting) {
                    mTask.waiting = false;
                    mHandler.removeCallbacks(mTask);
                }
                mTask = null;
                return false;
            } else if (mTask.waiting) {
                // There is a task, but it is waiting for the time it should
                // execute.  We can just toss it.
                if (DEBUG) Slog.v(TAG, "cancelLoad: task is waiting, dropping it");
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
                mTask = null;
                return false;
            } else {
                boolean cancelled = mTask.cancel(false);
                if (DEBUG) Slog.v(TAG, "cancelLoad: cancelled=" + cancelled);
                if (cancelled) {
                    mCancellingTask = mTask;
                }
                mTask = null;
                return cancelled;
            }
        }
        return false;
    }

    /**
     * Called if the task was canceled before it was completed.  Gives the class a chance
     * to properly dispose of the result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.851 -0500", hash_original_method = "6EDCFF0D227BFAAE1F619E412FD9521B", hash_generated_method = "9FEC541D061BA7A4CCE8EF034DC255B4")
    public void onCanceled(D data) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.852 -0500", hash_original_method = "45E2A10F8A270BE8E82A19AF3BE67D71", hash_generated_method = "2D35D877DC03BB25ADC7D0ABF098CBC0")
    void executePendingTask() {
        if (mCancellingTask == null && mTask != null) {
            if (mTask.waiting) {
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
            }
            if (mUpdateThrottle > 0) {
                long now = SystemClock.uptimeMillis();
                if (now < (mLastLoadCompleteTime+mUpdateThrottle)) {
                    // Not yet time to do another load.
                    if (DEBUG) Slog.v(TAG, "Waiting until "
                            + (mLastLoadCompleteTime+mUpdateThrottle)
                            + " to execute: " + mTask);
                    mTask.waiting = true;
                    mHandler.postAtTime(mTask, mLastLoadCompleteTime+mUpdateThrottle);
                    return;
                }
            }
            if (DEBUG) Slog.v(TAG, "Executing: " + mTask);
            mTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.852 -0500", hash_original_method = "2AFA09BEA839A112F3D6F9C423659AF4", hash_generated_method = "2AFA09BEA839A112F3D6F9C423659AF4")
    void dispatchOnCancelled(LoadTask task, D data) {
        onCanceled(data);
        if (mCancellingTask == task) {
            if (DEBUG) Slog.v(TAG, "Cancelled task is now canceled!");
            mLastLoadCompleteTime = SystemClock.uptimeMillis();
            mCancellingTask = null;
            executePendingTask();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.853 -0500", hash_original_method = "63FEDCADD7326B0F5C2BB0CB49E6D0DF", hash_generated_method = "D98FC31B6580F40DB46C71E8FEE45DB8")
    void dispatchOnLoadComplete(LoadTask task, D data) {
        if (mTask != task) {
            if (DEBUG) Slog.v(TAG, "Load complete of old task, trying to cancel");
            dispatchOnCancelled(task, data);
        } else {
            if (isAbandoned()) {
                // This cursor has been abandoned; just cancel the new data.
                onCanceled(data);
            } else {
                mLastLoadCompleteTime = SystemClock.uptimeMillis();
                mTask = null;
                if (DEBUG) Slog.v(TAG, "Delivering result");
                deliverResult(data);
            }
        }
    }

    /**
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.854 -0500", hash_original_method = "5399723D11980E7A8470EBBE4A650300", hash_generated_method = "7AFE79446E8B45C68AF3D723F3E91200")
    public abstract D loadInBackground();

    /**
     * Called on a worker thread to perform the actual load. Implementations should not deliver the
     * result directly, but should return them from this method, which will eventually end up
     * calling {@link #deliverResult} on the UI thread. If implementations need to process
     * the results on the UI thread they may override {@link #deliverResult} and do so
     * there.
     *
     * @return Implementations must return the result of their load operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.856 -0500", hash_original_method = "4A83A9163F83587A19BB5376A46D430D", hash_generated_method = "53F8C1A7952C6D72A2DB99C8C81E3BB4")
    protected D onLoadInBackground() {
        return loadInBackground();
    }

    
    final class LoadTask extends AsyncTask<Void, Void, D> implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.837 -0500", hash_original_field = "582B22379A32E8937A90E0545A184CFB", hash_generated_field = "582B22379A32E8937A90E0545A184CFB")


        D result;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.837 -0500", hash_original_field = "4B5AD997260D6A7F7067C9C9B5D02B34", hash_generated_field = "4B5AD997260D6A7F7067C9C9B5D02B34")

        boolean waiting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.838 -0500", hash_original_field = "09EE2768BAC0B25359CD49866A47E3A0", hash_generated_field = "F0455DF121EFC5ECE22AA733E5351602")


        private CountDownLatch done = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.343 -0400", hash_original_method = "16D80339785A96B3DBCA213BDE6C22F0", hash_generated_method = "16D80339785A96B3DBCA213BDE6C22F0")
        public LoadTask ()
        {
            //Synthesized constructor
        }

        /* Runs on a worker thread */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.839 -0500", hash_original_method = "DFBF37C86DDD5E9A57831EA3A10DC006", hash_generated_method = "69CF025D8691322D9B24DF452D277AAD")
        @Override
protected D doInBackground(Void... params) {
            if (DEBUG) Slog.v(TAG, this + " >>> doInBackground");
            result = AsyncTaskLoader.this.onLoadInBackground();
            if (DEBUG) Slog.v(TAG, this + "  <<< doInBackground");
            return result;
        }

        /* Runs on the UI thread */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.841 -0500", hash_original_method = "CA3BD1BFF35CD0AF15EEE08BAA19ADDD", hash_generated_method = "60430D20397DCF6CD464A7AB8FF9A24D")
        @Override
protected void onPostExecute(D data) {
            if (DEBUG) Slog.v(TAG, this + " onPostExecute");
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            } finally {
                done.countDown();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.841 -0500", hash_original_method = "6CC87369107415F190BB09763C783671", hash_generated_method = "1590F3D07BC80E7178CEBADCFA696BBE")
        @Override
protected void onCancelled() {
            if (DEBUG) Slog.v(TAG, this + " onCancelled");
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, result);
            } finally {
                done.countDown();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.842 -0500", hash_original_method = "65A4E8609F3A198276A58E99188CF50D", hash_generated_method = "531BF8F868D2E01906A06FD22AC2753F")
        @Override
public void run() {
            waiting = false;
            AsyncTaskLoader.this.executePendingTask();
        }

        
    }

    /**
     * Locks the current thread until the loader completes the current load
     * operation. Returns immediately if there is no load operation running.
     * Should not be called from the UI thread: calling it from the UI
     * thread would cause a deadlock.
     * <p>
     * Use for testing only.  <b>Never</b> call this from a UI thread.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.856 -0500", hash_original_method = "13983B8AAAA767CBF57A8C7D5EF6BF65", hash_generated_method = "168E209A0E3FB4F21B4BA58E35635657")
    public void waitForLoader() {
        LoadTask task = mTask;
        if (task != null) {
            try {
                task.done.await();
            } catch (InterruptedException e) {
                // Ignore
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:58.857 -0500", hash_original_method = "3BD2D1BA0575E5C52E87DB33CE550D2F", hash_generated_method = "3E7257BE9C311B4D212E63E51336AD55")
    @Override
public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        if (mTask != null) {
            writer.print(prefix); writer.print("mTask="); writer.print(mTask);
                    writer.print(" waiting="); writer.println(mTask.waiting);
        }
        if (mCancellingTask != null) {
            writer.print(prefix); writer.print("mCancellingTask="); writer.print(mCancellingTask);
                    writer.print(" waiting="); writer.println(mCancellingTask.waiting);
        }
        if (mUpdateThrottle != 0) {
            writer.print(prefix); writer.print("mUpdateThrottle=");
                    TimeUtils.formatDuration(mUpdateThrottle, writer);
                    writer.print(" mLastLoadCompleteTime=");
                    TimeUtils.formatDuration(mLastLoadCompleteTime,
                            SystemClock.uptimeMillis(), writer);
                    writer.println();
        }
    }
}

