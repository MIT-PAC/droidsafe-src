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

/**
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class GraphRunner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.401 -0400", hash_original_field = "3846A66A58D3468C0811D07C71336228", hash_generated_field = "9A1FE1E43559306B52BD37F4D2BA1977")


    public static final int RESULT_UNKNOWN  = 0;

    /** Interface for listeners waiting for the runner to complete. */
    public interface OnRunnerDoneListener {
        /** Callback method to be called when the runner completes a
         * {@link #run()} call.
         *
         * @param result will be RESULT_FINISHED if the graph finished running
         *        on its own, RESULT_STOPPED if the runner was stopped by a call
         *        to stop(), RESULT_BLOCKED if no filters could run due to lack
         *        of inputs or outputs or due to scheduling policies, and
         *        RESULT_SLEEPING if a filter node requested sleep.
         */
        public void onRunnerDone(int result);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.403 -0400", hash_original_field = "3CA30736BE4569562EA913494BB2CCC9", hash_generated_field = "F1C078406A3F1D979694C004F730461D")

    public static final int RESULT_RUNNING  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.405 -0400", hash_original_field = "063672D8FB2E126C60E55903CC1162F9", hash_generated_field = "9795499FD2F164C8F41ED2175577E41B")

    public static final int RESULT_FINISHED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.407 -0400", hash_original_field = "E72DB60795D13B4495E2B30F4AE7C332", hash_generated_field = "A697828E885554A1370EAFA4C43D65E0")

    public static final int RESULT_SLEEPING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.409 -0400", hash_original_field = "A646065AD3DDC9943B53DE0AC4C36A71", hash_generated_field = "E6A51127BBB1DEE26432AF50EC43B483")

    public static final int RESULT_BLOCKED  = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.411 -0400", hash_original_field = "E3B3EC622DE37FCD64C6355844D49852", hash_generated_field = "42DFC031E26F351111226560703B7CE3")

    public static final int RESULT_STOPPED  = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.413 -0400", hash_original_field = "EB4E2701B1E6EF7383242BFC2D3971B3", hash_generated_field = "2A7A6830489B7CB58CDB9416D9F00C7C")

    public static final int RESULT_ERROR    = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.397 -0400", hash_original_field = "9141D53E2C4D1436074AF46690FEF824", hash_generated_field = "162A68E6FA8DE1BC6114CD2620EED429")


    protected FilterContext mFilterContext = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.416 -0400", hash_original_method = "F8E7BC50704E49143260150B15B343EC", hash_generated_method = "298A283B687C5346672FB9933D89F815")
    
public GraphRunner(FilterContext context) {
        mFilterContext = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.418 -0400", hash_original_method = "B000BACCD795C1904AE669A3169B9FEF", hash_generated_method = "115337FA93775FE5CC2A55F111A80E8C")
    
public abstract FilterGraph getGraph();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.420 -0400", hash_original_method = "BF7F2FE91F869AF67A90F8D5B0ADE3B9", hash_generated_method = "2AE870C63D543EC0610CEF345F6EE3DC")
    
public FilterContext getContext() {
        return mFilterContext;
    }

    /**
     * Helper function for subclasses to activate the GL environment before running.
     * @return true, if the GL environment was activated. Returns false, if the GL environment
     *         was already active.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.421 -0400", hash_original_method = "3E44A439A913DAF48F890509E158FA6A", hash_generated_method = "3B3A8E27F00FB658E78AFE4DD4779E1E")
    
protected boolean activateGlContext() {
        GLEnvironment glEnv = mFilterContext.getGLEnvironment();
        if (glEnv != null && !glEnv.isActive()) {
            glEnv.activate();
            return true;
        }
        return false;
    }

    /**
     * Helper function for subclasses to deactivate the GL environment after running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.423 -0400", hash_original_method = "E30FBAAE20BA9B0175A4F9E113BE97CD", hash_generated_method = "81FE6D51F5BC4F417AFE47635C12B5C7")
    
protected void deactivateGlContext() {
        GLEnvironment glEnv = mFilterContext.getGLEnvironment();
        if (glEnv != null) {
            glEnv.deactivate();
        }
    }

    /** Starts running the graph. Will open the filters in the graph if they are not already open. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.425 -0400", hash_original_method = "2C6A443C83148E86AAD705D9EE784F75", hash_generated_method = "5BBE1BCB74D1FAFBB58FE7F038D48F66")
    
public abstract void run();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.427 -0400", hash_original_method = "6E0228B24C4C43C573D158013B77E11C", hash_generated_method = "6AA3865A9E15CB67127F9F8230324A22")
    
public abstract void setDoneCallback(OnRunnerDoneListener listener);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.429 -0400", hash_original_method = "01F0FE44E71A30E093E481EBA696B87A", hash_generated_method = "6E27EBB5A90EFE7D59D40ADC42E0CBF6")
    
public abstract boolean isRunning();

    /** Stops graph execution. As part of stopping, also closes the graph nodes. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.431 -0400", hash_original_method = "702270B81E0A152F42E95B594CBF6271", hash_generated_method = "83BF6F52E4E13B269491279EF09CDA29")
    
public abstract void stop();

    /** Closes the filters in a graph. Can only be called if the graph is not running. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.433 -0400", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "01CBB4D2860961B039FF408E6402870A")
    
public abstract void close();

    /**
     * Returns the last exception that happened during an asynchronous run. Returns null if
     * there is nothing to report.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.435 -0400", hash_original_method = "E9E623A5FE8E3F31C333550186F49DF3", hash_generated_method = "1DF0B5113E36E2D57B9C42ABAB1E7F0A")
    
public abstract Exception getError();
}
