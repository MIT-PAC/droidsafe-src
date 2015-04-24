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
 * Copyright (C) 2010 The Android Open Source Project
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


package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueuedWork { // lazy, guarded by class

    /**
     * Returns a single-thread Executor shared by the entire process,
     * creating it if necessary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.014 -0500", hash_original_method = "13E1A18DB49260CED334452DE885FB8A", hash_generated_method = "28A5EE30497C1876B145CE4886521D9B")
    
public static ExecutorService singleThreadExecutor() {
        synchronized (QueuedWork.class) {
            if (sSingleThreadExecutor == null) {
                // TODO: can we give this single thread a thread name?
                sSingleThreadExecutor = Executors.newSingleThreadExecutor();
            }
            return sSingleThreadExecutor;
        }
    }

    /**
     * Add a runnable to finish (or wait for) a deferred operation
     * started in this context earlier.  Typically finished by e.g.
     * an Activity#onPause.  Used by SharedPreferences$Editor#startCommit().
     *
     * Note that this doesn't actually start it running.  This is just
     * a scratch set for callers doing async work to keep updated with
     * what's in-flight.  In the common case, caller code
     * (e.g. SharedPreferences) will pretty quickly call remove()
     * after an add().  The only time these Runnables are run is from
     * waitToFinish(), below.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.016 -0500", hash_original_method = "7B6375E3361202B2623A569246ADB845", hash_generated_method = "86CE4C043442D3BE24E2CEC21928CA6A")
    
public static void add(Runnable finisher) {
        sPendingWorkFinishers.add(finisher);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.018 -0500", hash_original_method = "417BEE19E0D290A8A24EFBE6B2C62725", hash_generated_method = "9514EA57B6A9BA3DF3BD34C31E2AEBEB")
    
public static void remove(Runnable finisher) {
        sPendingWorkFinishers.remove(finisher);
    }

    /**
     * Finishes or waits for async operations to complete.
     * (e.g. SharedPreferences$Editor#startCommit writes)
     *
     * Is called from the Activity base class's onPause(), after
     * BroadcastReceiver's onReceive, after Service command handling,
     * etc.  (so async work is never lost)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.021 -0500", hash_original_method = "0ABA14D3C219E3137A12A8B54201A585", hash_generated_method = "1BEEE3D600CCD50D9170B9CA2284E416")
    
public static void waitToFinish() {
        Runnable toFinish;
        while ((toFinish = sPendingWorkFinishers.poll()) != null) {
            toFinish.run();
        }
    }
    
    /**
     * Returns true if there is pending work to be done.  Note that the
     * result is out of data as soon as you receive it, so be careful how you
     * use it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.024 -0500", hash_original_method = "3EDC66A2B3D8F14E5C835683106EF1A9", hash_generated_method = "8A1497FE1DF985F390DD86C438698A75")
    
public static boolean hasPendingWork() {
        return !sPendingWorkFinishers.isEmpty();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.009 -0500", hash_original_field = "3E40C7098CEF2DEF860D9093EC00D37B", hash_generated_field = "0D17711C705DF8B5527B3E8A366114DD")

    // activities started by the application.
    private static final ConcurrentLinkedQueue<Runnable> sPendingWorkFinishers =
            new ConcurrentLinkedQueue<Runnable>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.012 -0500", hash_original_field = "A85FABE3F0CB6E39549C7FC378135E94", hash_generated_field = "48846E427360D3B755393A8B7AB28CDC")

    private static ExecutorService sSingleThreadExecutor = null;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.510 -0400", hash_original_method = "94C2F41E1F3AD149B563D9E976EAD755", hash_generated_method = "94C2F41E1F3AD149B563D9E976EAD755")
    public QueuedWork ()
    {
        //Synthesized constructor
    }
}

