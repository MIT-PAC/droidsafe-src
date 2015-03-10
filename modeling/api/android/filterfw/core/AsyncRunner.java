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


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.AsyncTask;
import android.os.Handler;

import android.util.Log;

import java.lang.InterruptedException;
import java.lang.Runnable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;

/**
 * @hide
 */
public class AsyncRunner extends GraphRunner{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.677 -0400", hash_original_field = "BE68ECDF1851D8F5289EB6B17138C3FE", hash_generated_field = "B60B117D13DD5CC47E1E23A954ABF935")

    private static final String TAG = "AsyncRunner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.633 -0400", hash_original_field = "CC7C0C73B928C6CD62A5EF51B03D8C6A", hash_generated_field = "FD56A1A6211A7C5652D79B0AAAA88DB8")

    private Class mSchedulerClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.635 -0400", hash_original_field = "BF989F77FF090E43D1DD90910FE127A1", hash_generated_field = "4343DE4F1BCA89FA7B80F45EBBAF4443")

    private SyncRunner mRunner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.638 -0400", hash_original_field = "FC44D486B810847C76FFD916164B2FAB", hash_generated_field = "A87866307D9F58E848868E5520120F07")

    private AsyncRunnerTask mRunTask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.640 -0400", hash_original_field = "5B97082E651D81471A94CB54B84B394E", hash_generated_field = "CDF2536C86261609BFE83C9B86A879BD")

    private OnRunnerDoneListener mDoneListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.642 -0400", hash_original_field = "52F2522BA59091C98823784EDD890AB3", hash_generated_field = "34776D80EC9C43CCF24E6A848BB10793")

    private boolean isProcessing;

    private class RunnerResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.649 -0400", hash_original_field = "1C56487B619DA92B695A36D614DF33D6", hash_generated_field = "FDFF6E8390FBE796B35AA8113458FD95")

        public int status = RESULT_UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.651 -0400", hash_original_field = "2CBC6074DF6BD2C2AC2A7CA4BC170BEC", hash_generated_field = "F93F9295BE658E2E6A1ED64F9A88FE45")

        public Exception exception;
    }

    private class AsyncRunnerTask extends AsyncTask<SyncRunner, Void, RunnerResult> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.658 -0400", hash_original_field = "7CAA8BFA98595C34EDAC140C36D468A0", hash_generated_field = "1A82A68E23324092FF0198CD8362236E")

        private static final String TAG = "AsyncRunnerTask";

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.661 -0400", hash_original_method = "A7C67D36A675C6D29E3FECF0E5FCA204", hash_generated_method = "27FDB7AC0C65C9E831FA118149873AFB")
        
@Override
        protected RunnerResult doInBackground(SyncRunner... runner) {
            RunnerResult result = new RunnerResult();
            try {
                if (runner.length > 1) {
                    throw new RuntimeException("More than one runner received!");
                }

                runner[0].assertReadyToStep();

                // Preparation
                if (mLogVerbose) Log.v(TAG, "Starting background graph processing.");
                activateGlContext();

                if (mLogVerbose) Log.v(TAG, "Preparing filter graph for processing.");
                runner[0].beginProcessing();

                if (mLogVerbose) Log.v(TAG, "Running graph.");

                // Run loop
                result.status = RESULT_RUNNING;
                while (!isCancelled() && result.status == RESULT_RUNNING) {
                    if (!runner[0].performStep()) {
                        result.status = runner[0].determinePostRunState();
                        if (result.status == GraphRunner.RESULT_SLEEPING) {
                            runner[0].waitUntilWake();
                            result.status = RESULT_RUNNING;
                        }
                    }
                }

                // Cleanup
                if (isCancelled()) {
                    result.status = RESULT_STOPPED;
                }
            } catch (Exception exception) {
                result.exception = exception;
                result.status = RESULT_ERROR;
            }

            // Deactivate context.
            try {
                deactivateGlContext();
            } catch (Exception exception) {
                result.exception = exception;
                result.status = RESULT_ERROR;
            }

            if (mLogVerbose) Log.v(TAG, "Done with background graph processing.");
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.664 -0400", hash_original_method = "8A83CFF72B9A16B3223587AA41F16EA3", hash_generated_method = "F632ADC80CAC4FBBC8E6BE7AE31E2C7A")
        
@Override
        protected void onCancelled(RunnerResult result) {
            onPostExecute(result);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.667 -0400", hash_original_method = "1CEBB715383E1C3C897096B710CEC649", hash_generated_method = "EE56C2E3221CCEA63062B47122AEEB8D")
        
@Override
        protected void onPostExecute(RunnerResult result) {
            if (mLogVerbose) Log.v(TAG, "Starting post-execute.");
            setRunning(false);
            if (result == null) {
                // Cancelled before got to doInBackground
                result = new RunnerResult();
                result.status = RESULT_STOPPED;
            }
            setException(result.exception);
            if (result.status == RESULT_STOPPED || result.status == RESULT_ERROR) {
                if (mLogVerbose) Log.v(TAG, "Closing filters.");
                try {
                    mRunner.close();
                } catch (Exception exception) {
                    result.status = RESULT_ERROR;
                    setException(exception);
                }
            }
            if (mDoneListener != null) {
                if (mLogVerbose) Log.v(TAG, "Calling graph done callback.");
                mDoneListener.onRunnerDone(result.status);
            }
            if (mLogVerbose) Log.v(TAG, "Completed post-execute.");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.645 -0400", hash_original_field = "83551CA4879D7FA8FF1D696543D03AD9", hash_generated_field = "F0738F68529E2EE5F73E9EE1D09D9DE1")

    private Exception mException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.674 -0400", hash_original_field = "CCFB9E24DC58F9E64BC75A559E0C33FC", hash_generated_field = "29542B7EA5B26DA8ADF116C9866AA3F1")

    private boolean mLogVerbose;

    /** Create a new asynchronous graph runner with the given filter
     * context, and the given scheduler class.
     *
     * Must be created on the UI thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.680 -0400", hash_original_method = "A580448BC11843D68965B5924130AA7D", hash_generated_method = "8416EA58AB258F93C005DA79AA740733")
    
public AsyncRunner(FilterContext context, Class schedulerClass) {
        super(context);

        mSchedulerClass = schedulerClass;
        mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);
    }

    /** Create a new asynchronous graph runner with the given filter
     * context. Uses a default scheduler.
     *
     * Must be created on the UI thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.682 -0400", hash_original_method = "5BB837D750DC12D68B4610C57E179EC7", hash_generated_method = "94BD60CF172F0C50E0B88CB0B4F17B80")
    
public AsyncRunner(FilterContext context) {
        super(context);

        mSchedulerClass = SimpleScheduler.class;
        mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);
    }

    /** Set a callback to be called in the UI thread once the AsyncRunner
     * completes running a graph, whether the completion is due to a stop() call
     * or the filters running out of data to process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.685 -0400", hash_original_method = "2BE8A9C7CA8C92DB1A4D49C0CD3DAD64", hash_generated_method = "AC056568EBEFB0AD2A65DE2C9002C639")
    
@Override
    public void setDoneCallback(OnRunnerDoneListener listener) {
        mDoneListener = listener;
    }

    /** Sets the graph to be run. Will call prepare() on graph. Cannot be called
     * when a graph is already running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.687 -0400", hash_original_method = "0438B1CADDB5BF9CE41045C20B46B0EE", hash_generated_method = "3E2C6D88A7601D3C4DE345FE3348E454")
    
synchronized public void setGraph(FilterGraph graph) {
        if (isRunning()) {
            throw new RuntimeException("Graph is already running!");
        }
        mRunner = new SyncRunner(mFilterContext, graph, mSchedulerClass);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.690 -0400", hash_original_method = "4B4ED21089BABBD494D283ABA6950CE3", hash_generated_method = "7BA9D56278C5C8673E497DB6881D83E8")
    
@Override
    public FilterGraph getGraph() {
        return mRunner != null ? mRunner.getGraph() : null;
    }

    /** Execute the graph in a background thread. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.694 -0400", hash_original_method = "24E62A441A211059E57D1F5CD5478155", hash_generated_method = "71EBA1F015C37EEFE900D43ACF38BD5F")
    
@Override
    synchronized public void run() {
        if (mLogVerbose) Log.v(TAG, "Running graph.");
        setException(null);

        if (isRunning()) {
            throw new RuntimeException("Graph is already running!");
        }
        if (mRunner == null) {
            throw new RuntimeException("Cannot run before a graph is set!");
        }
        mRunTask = this.new AsyncRunnerTask();

        setRunning(true);
        mRunTask.execute(mRunner);
    }

    /** Stop graph execution. This is an asynchronous call; register a callback
     * with setDoneCallback to be notified of when the background processing has
     * been completed. Calling stop will close the filter graph. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.697 -0400", hash_original_method = "532AF2CB70F634AF3C0AFD4E52F346C0", hash_generated_method = "9737C3928C505E32BBBEFCA99B803424")
    
@Override
    synchronized public void stop() {
        if (mRunTask != null && !mRunTask.isCancelled() ) {
            if (mLogVerbose) Log.v(TAG, "Stopping graph.");
            mRunTask.cancel(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.699 -0400", hash_original_method = "5C8F967F05F79D991F796D115F121B18", hash_generated_method = "67EAB7A529BD0E0FBE8AC043758BF6E2")
    
@Override
    synchronized public void close() {
        if (isRunning()) {
            throw new RuntimeException("Cannot close graph while it is running!");
        }
        if (mLogVerbose) Log.v(TAG, "Closing filters.");
        mRunner.close();
    }

    /** Check if background processing is happening */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.702 -0400", hash_original_method = "4C39D33D36F039D96E99CA904F9EF3AF", hash_generated_method = "E5A661D667B20970BF8F3702A989F785")
    
@Override
    synchronized public boolean isRunning() {
        return isProcessing;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.704 -0400", hash_original_method = "1913BA9B31EA47C536B24B8C5C3C6334", hash_generated_method = "94A10EB396C8B41619C161A4D050F9D5")
    
@Override
    synchronized public Exception getError() {
        return mException;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.707 -0400", hash_original_method = "F3CE22592DA48F8239740EEA595A02B9", hash_generated_method = "F9154A187285D6F0445AC94E51D97BF9")
    
synchronized private void setRunning(boolean running) {
        isProcessing = running;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.709 -0400", hash_original_method = "68287FAD69B035245BA1CC84AEB3EDDF", hash_generated_method = "3580022DA3021FBEAF2291D43478B7E1")
    
synchronized private void setException(Exception exception) {
        mException = exception;
    }

}
