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
import android.os.ConditionVariable;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @hide
 */
public class SyncRunner extends GraphRunner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.927 -0400", hash_original_field = "E6C9D35D2D21DB56B8BCC2FCFE7EF84E", hash_generated_field = "83B132D73F0A132D06180EFE14C96C9B")

    private final static String TAG = "SyncRunner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.915 -0400", hash_original_field = "5992056C9267592B33B804B090D8E40B", hash_generated_field = "30894F15A8E5B0FB682C1090C80CBEA1")

    private Scheduler mScheduler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.917 -0400", hash_original_field = "CEF28BCE55888AAEC7BB510C9702F1BA", hash_generated_field = "4BD384BFA563352526DE5E456192E0BE")

    private OnRunnerDoneListener mDoneListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.919 -0400", hash_original_field = "7099FF148FBA9573A9F46B036391606C", hash_generated_field = "590DF364C87CCF1DBD166B12FB362356")

    private ScheduledThreadPoolExecutor mWakeExecutor = new ScheduledThreadPoolExecutor(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.921 -0400", hash_original_field = "543DDE9C599AE0DFF9D385A7DA825B3C", hash_generated_field = "FADD1257D7FF0CA39EB9FF4459CA9885")

    private ConditionVariable mWakeCondition = new ConditionVariable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.923 -0400", hash_original_field = "9B00ED9622D774FE98BBA25FBA3C718F", hash_generated_field = "F65B4040D4A62DDAA67369124ECCF33C")

    private StopWatchMap mTimer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.925 -0400", hash_original_field = "CCFB9E24DC58F9E64BC75A559E0C33FC", hash_generated_field = "29542B7EA5B26DA8ADF116C9866AA3F1")

    private  boolean mLogVerbose;

    // TODO: Provide factory based constructor?
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.930 -0400", hash_original_method = "16231EA2C70C8E8A890EF68838744D71", hash_generated_method = "96ECDD0AF450D26C815BB8474205A65A")
    
public SyncRunner(FilterContext context, FilterGraph graph, Class schedulerClass) {
        super(context);

        mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);

        if (mLogVerbose) Log.v(TAG, "Initializing SyncRunner");

        // Create the scheduler
        if (Scheduler.class.isAssignableFrom(schedulerClass)) {
            try {
                Constructor schedulerConstructor = schedulerClass.getConstructor(FilterGraph.class);
                mScheduler = (Scheduler)schedulerConstructor.newInstance(graph);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Scheduler does not have constructor <init>(FilterGraph)!", e);
            } catch (InstantiationException e) {
                throw new RuntimeException("Could not instantiate the Scheduler instance!", e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot access Scheduler constructor!", e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Scheduler constructor threw an exception", e);
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate Scheduler", e);
            }
        } else {
            throw new IllegalArgumentException("Class provided is not a Scheduler subclass!");
        }

        // Associate this runner and the graph with the context
        mFilterContext = context;
        mFilterContext.addGraph(graph);

        mTimer = new StopWatchMap();

        if (mLogVerbose) Log.v(TAG, "Setting up filters");

        // Setup graph filters
        graph.setupFilters();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.932 -0400", hash_original_method = "68D33940A5B1C89DDA210C4A82394F97", hash_generated_method = "E6C0871C25FBDD2624603C53FE9A67E7")
    
@Override
    public FilterGraph getGraph() {
        return mScheduler != null ? mScheduler.getGraph() : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.935 -0400", hash_original_method = "450F4A7E331D1B9E7106D75BC541987E", hash_generated_method = "4DC5825F397043155FDA6C6B1C144856")
    
public int step() {
        assertReadyToStep();
        if (!getGraph().isReady() ) {
            throw new RuntimeException("Trying to process graph that is not open!");
        }
        return performStep() ? RESULT_RUNNING : determinePostRunState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.937 -0400", hash_original_method = "710996337BE3D466565FC703886DF342", hash_generated_method = "6CC3F22E55A198A52B108C00283ED1BD")
    
public void beginProcessing() {
        mScheduler.reset();
        getGraph().beginProcessing();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.939 -0400", hash_original_method = "A7AFEBB2661EE0C7B255516254DB92C3", hash_generated_method = "BCE4E72AA9D66D22D5079CCAD668BE45")
    
public void close() {
        // Close filters
        if (mLogVerbose) Log.v(TAG, "Closing graph.");
        getGraph().closeFilters(mFilterContext);
        mScheduler.reset();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.941 -0400", hash_original_method = "A95AA44FA5C929268DBB4AEF5C43E9FE", hash_generated_method = "32E884C554B368ACDDE0A7241D7B1B8A")
    
@Override
    public void run() {
        if (mLogVerbose) Log.v(TAG, "Beginning run.");

        assertReadyToStep();

        // Preparation
        beginProcessing();
        boolean glActivated = activateGlContext();

        // Run
        boolean keepRunning = true;
        while (keepRunning) {
            keepRunning = performStep();
        }

        // Cleanup
        if (glActivated) {
            deactivateGlContext();
        }

        // Call completion callback if set
        if (mDoneListener != null) {
            if (mLogVerbose) Log.v(TAG, "Calling completion listener.");
            mDoneListener.onRunnerDone(determinePostRunState());
        }
        if (mLogVerbose) Log.v(TAG, "Run complete");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.943 -0400", hash_original_method = "5C64A57C7B28269E783804B9F7CA89FF", hash_generated_method = "001DEB3D44B2947D3FCFF117BA879BBC")
    
@Override
    public boolean isRunning() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.945 -0400", hash_original_method = "2BE8A9C7CA8C92DB1A4D49C0CD3DAD64", hash_generated_method = "AC056568EBEFB0AD2A65DE2C9002C639")
    
@Override
    public void setDoneCallback(OnRunnerDoneListener listener) {
        mDoneListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.947 -0400", hash_original_method = "5DF41C3C8DD31BA0E02B40CFA4B8655B", hash_generated_method = "308106C4A2E9DF014478D6E12CB30E67")
    
@Override
    public void stop() {
        throw new RuntimeException("SyncRunner does not support stopping a graph!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.948 -0400", hash_original_method = "407B71EB2FFEC6FF32D64300C98C0143", hash_generated_method = "45BBEFC7F3AD93C9A853FF3FECB9BBD7")
    
@Override
    synchronized public Exception getError() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.951 -0400", hash_original_method = "1B8A783BD009689A35D516BAD68F364A", hash_generated_method = "0D8D1C0AC26A197E25E3CAD4278CE86B")
    
protected void waitUntilWake() {
        mWakeCondition.block();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.952 -0400", hash_original_method = "5DA8F8B70E1E20B780C0DB44CC3ED8AA", hash_generated_method = "8DDEF78D3A191875D6E9F5594F40484A")
    
protected void processFilterNode(Filter filter) {
        if (mLogVerbose) Log.v(TAG, "Processing filter node");
        filter.performProcess(mFilterContext);
        if (filter.getStatus() == Filter.STATUS_ERROR) {
            throw new RuntimeException("There was an error executing " + filter + "!");
        } else if (filter.getStatus() == Filter.STATUS_SLEEPING) {
            if (mLogVerbose) Log.v(TAG, "Scheduling filter wakeup");
            scheduleFilterWake(filter, filter.getSleepDelay());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.957 -0400", hash_original_method = "7935225037FFFC8A2ECB8F8B3CA93ED6", hash_generated_method = "6F071F425BE74E7EE30A2CA1E4BAAE37")
    
protected void scheduleFilterWake(Filter filter, int delay) {
        // Close the wake condition
        mWakeCondition.close();

        // Schedule the wake-up
        final Filter filterToSchedule = filter;
        final ConditionVariable conditionToWake = mWakeCondition;

        mWakeExecutor.schedule(new Runnable() {
          @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.218 -0400", hash_original_method = "13E75D52956FA158BC64E98457594B1E", hash_generated_method = "ABD9F224C479AEF5F293E13D9D557AA8")
            
@Override
          public void run() {
                filterToSchedule.unsetStatus(Filter.STATUS_SLEEPING);
                conditionToWake.open();
            }
        }, delay, TimeUnit.MILLISECONDS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.959 -0400", hash_original_method = "64CFF74417D0367E54C6AD8D75363789", hash_generated_method = "9A7363427A610D710AAF936D905C7525")
    
protected int determinePostRunState() {
        boolean isBlocked = false;
        for (Filter filter : mScheduler.getGraph().getFilters()) {
            if (filter.isOpen()) {
                if (filter.getStatus() == Filter.STATUS_SLEEPING) {
                    // If ANY node is sleeping, we return our state as sleeping
                    return RESULT_SLEEPING;
                } else {
                    // If a node is still open, it is blocked (by input or output)
                    return RESULT_BLOCKED;
                }
            }
        }
        return RESULT_FINISHED;
    }

    // Core internal methods ///////////////////////////////////////////////////////////////////////
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.960 -0400", hash_original_method = "300FA6EACB984402B7F0355F7A22E563", hash_generated_method = "300FA6EACB984402B7F0355F7A22E563")
    
boolean performStep() {
        if (mLogVerbose) Log.v(TAG, "Performing one step.");
        Filter filter = mScheduler.scheduleNextNode();
        if (filter != null) {
            mTimer.start(filter.getName());
            processFilterNode(filter);
            mTimer.stop(filter.getName());
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.962 -0400", hash_original_method = "72E6E6CB25E84F0EAC5401FFB0A76914", hash_generated_method = "72E6E6CB25E84F0EAC5401FFB0A76914")
    
void assertReadyToStep() {
        if (mScheduler == null) {
            throw new RuntimeException("Attempting to run schedule with no scheduler in place!");
        } else if (getGraph() == null) {
            throw new RuntimeException("Calling step on scheduler with no graph in place!");
        }
    }
}
