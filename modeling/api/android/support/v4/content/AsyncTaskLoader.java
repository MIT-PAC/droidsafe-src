/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.754 -0500", hash_original_field = "F240A5C69F8AA9B45906194AB2ADEC92", hash_generated_field = "E2B79C20584722CC23AA6431B7343097")

    static final String TAG = "AsyncTaskLoader";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.756 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.780 -0500", hash_original_field = "0D8054BDEEA0AA0CC72AD8EB23D29AE2", hash_generated_field = "5C3107BBF367803569D0AB8A39076D22")

    volatile LoadTask mTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.782 -0500", hash_original_field = "3B3013D7772F24F621F8C9729AD8E28A", hash_generated_field = "3D2A32ED16FA4BFF500D2C906E32BFB2")

    volatile LoadTask mCancellingTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.784 -0500", hash_original_field = "0CC16960397661E2A91A0C1245907990", hash_generated_field = "0CC16960397661E2A91A0C1245907990")

    long mUpdateThrottle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.786 -0500", hash_original_field = "068F47D76DDC530CAC2DF35289A5CFB4", hash_generated_field = "068F47D76DDC530CAC2DF35289A5CFB4")

    long mLastLoadCompleteTime = -10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.788 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.791 -0500", hash_original_method = "D12030B6AB606C68B1075214300CB0F6", hash_generated_method = "96C9B7975FBAAEAD2973F88F4D729C01")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.794 -0500", hash_original_method = "5FBC47B8FEAE1CF1C3C903D2FBB05A60", hash_generated_method = "7AF80CA8C36B293048A99FC2A0AFDF65")
    
public void setUpdateThrottle(long delayMS) {
        mUpdateThrottle = delayMS;
        if (delayMS != 0) {
            mHandler = new Handler();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.796 -0500", hash_original_method = "432E7B986B9CB9166C0D2E103A5093E2", hash_generated_method = "2B68A0E7026AEC8A6A9591DCBB10759E")
    
@Override
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        mTask = new LoadTask();
        if (DEBUG) Log.v(TAG, "Preparing load: mTask=" + mTask);
        executePendingTask();
    }

    /**
     * Attempt to cancel the current load task. See {@link android.os.AsyncTask#cancel(boolean)}
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.799 -0500", hash_original_method = "EED9AFD45373FFA0657A2114031AE14C", hash_generated_method = "4A4B3BB952605C872539E5B90B2B2161")
    
public boolean cancelLoad() {
        /*if (DEBUG) Log.v(TAG, "cancelLoad: mTask=" + mTask);
        if (mTask != null) {
            if (mCancellingTask != null) {
                // There was a pending task already waiting for a previous
                // one being canceled; just drop it.
                if (DEBUG) Log.v(TAG,
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
                if (DEBUG) Log.v(TAG, "cancelLoad: task is waiting, dropping it");
                mTask.waiting = false;
                mHandler.removeCallbacks(mTask);
                mTask = null;
                return false;
            } else {
                boolean cancelled = mTask.cancel(false);
                if (DEBUG) Log.v(TAG, "cancelLoad: cancelled=" + cancelled);
                if (cancelled) {
                    mCancellingTask = mTask;
                }
                mTask = null;
                return cancelled;
            }
        }*/
        return false;
    }

    /**
     * Called if the task was canceled before it was completed.  Gives the class a chance
     * to properly dispose of the result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.801 -0500", hash_original_method = "6EDCFF0D227BFAAE1F619E412FD9521B", hash_generated_method = "9FEC541D061BA7A4CCE8EF034DC255B4")
    @DSSafe(DSCat.SAFE_LIST)
public void onCanceled(D data) {
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.803 -0500", hash_original_method = "DFA4BC3BC4931E8E36EC6E65D042E4CC", hash_generated_method = "7A879335BCECB8C6BA6A80EBA2EA88EB")
    
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
                    if (DEBUG) Log.v(TAG, "Waiting until "
                            + (mLastLoadCompleteTime+mUpdateThrottle)
                            + " to execute: " + mTask);
                    mTask.waiting = true;
                    mHandler.postAtTime(mTask, mLastLoadCompleteTime+mUpdateThrottle);
                    return;
                }
            }
            if (DEBUG) Log.v(TAG, "Executing: " + mTask);
            mTask.executeOnExecutor(ModernAsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:01:59.744 -0400", hash_original_method = "6F889D2313C3AF179C915052A4D42116", hash_generated_method = "6F889D2313C3AF179C915052A4D42116")
    
    @DSSafe(DSCat.SAFE_LIST)
void dispatchOnCancelled(LoadTask task, D data) {
        onCanceled(data);
        if (mCancellingTask == task) {
            if (DEBUG) Log.v(TAG, "Cancelled task is now canceled!");
            //rollbackContentChanged();
            mLastLoadCompleteTime = SystemClock.uptimeMillis();
            mCancellingTask = null;
            executePendingTask();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:01:59.753 -0400", hash_original_method = "60255F832A19B4AE733DAA83200BB399", hash_generated_method = "09E167AE34BECEDE706ED8B919BE4945")
    @DSSafe(DSCat.SAFE_LIST)
    
void dispatchOnLoadComplete(LoadTask task, D data) {
        if (mTask != task) {
            if (DEBUG) Log.v(TAG, "Load complete of old task, trying to cancel");
            dispatchOnCancelled(task, data);
        } else {
            if (isAbandoned()) {
                // This cursor has been abandoned; just cancel the new data.
                onCanceled(data);
            } else {
                commitContentChanged();
                mLastLoadCompleteTime = SystemClock.uptimeMillis();
                mTask = null;
                if (DEBUG) Log.v(TAG, "Delivering result");
                deliverResult(data);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    public void commitContentChanged() {
		// TODO Auto-generated method stub
		
	}
    @DSSafe(DSCat.SAFE_LIST)
    public void rollbackContentChanged() {
    	
    }

	/**
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.811 -0500", hash_original_method = "5399723D11980E7A8470EBBE4A650300", hash_generated_method = "7AFE79446E8B45C68AF3D723F3E91200")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.813 -0500", hash_original_method = "4A83A9163F83587A19BB5376A46D430D", hash_generated_method = "53F8C1A7952C6D72A2DB99C8C81E3BB4")
    
protected D onLoadInBackground() {
        return loadInBackground();
    }
    
    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.759 -0500", hash_original_field = "582B22379A32E8937A90E0545A184CFB", hash_generated_field = "582B22379A32E8937A90E0545A184CFB")

        D result;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.762 -0500", hash_original_field = "4B5AD997260D6A7F7067C9C9B5D02B34", hash_generated_field = "4B5AD997260D6A7F7067C9C9B5D02B34")

        boolean waiting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.764 -0500", hash_original_field = "09EE2768BAC0B25359CD49866A47E3A0", hash_generated_field = "F0455DF121EFC5ECE22AA733E5351602")

        private CountDownLatch done = new CountDownLatch(1);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.780 -0400", hash_original_method = "16D80339785A96B3DBCA213BDE6C22F0", hash_generated_method = "16D80339785A96B3DBCA213BDE6C22F0")
        public LoadTask ()
        {
            //Synthesized constructor
        }

        /* Runs on a worker thread */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.767 -0500", hash_original_method = "962D018A6346A7B0135AC9FF7B03DD4E", hash_generated_method = "73EBB57BF6DEE1E88C88B16EAB06ECBF")
        
@Override
        protected D doInBackground(Void... params) {
            if (DEBUG) Log.v(TAG, this + " >>> doInBackground");
            result = AsyncTaskLoader.this.onLoadInBackground();
            if (DEBUG) Log.v(TAG, this + "  <<< doInBackground");
            return result;
        }

        /* Runs on the UI thread */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.770 -0500", hash_original_method = "58FAE55DC10E415A2FA190657D4F1D85", hash_generated_method = "3FC1816C8A4BBA47018C242C78C0E1B1")
        
        @DSSafe(DSCat.SAFE_LIST)
@Override
        protected void onPostExecute(D data) {
            if (DEBUG) Log.v(TAG, this + " onPostExecute");
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            } finally {
                done.countDown();
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.773 -0500", hash_original_method = "B83F1AA509F54D59951BAD91749D4A0A", hash_generated_method = "CC2843AB79537EC4059DD6E24F45EDC8")
        
@Override
        protected void onCancelled() {
            if (DEBUG) Log.v(TAG, this + " onCancelled");
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, result);
            } finally {
                done.countDown();
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.775 -0500", hash_original_method = "65A4E8609F3A198276A58E99188CF50D", hash_generated_method = "531BF8F868D2E01906A06FD22AC2753F")
        
@Override
        public void run() {
            waiting = false;
            AsyncTaskLoader.this.executePendingTask();
            onForceLoad();
            onCancelled();
            onPostExecute(result);
            onLoadInBackground();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.815 -0500", hash_original_method = "13983B8AAAA767CBF57A8C7D5EF6BF65", hash_generated_method = "168E209A0E3FB4F21B4BA58E35635657")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.820 -0500", hash_original_method = "3BD2D1BA0575E5C52E87DB33CE550D2F", hash_generated_method = "3E7257BE9C311B4D212E63E51336AD55")
    
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

