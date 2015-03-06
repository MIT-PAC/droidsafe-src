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
import android.filterfw.core.Filter;
import android.filterfw.core.Scheduler;
import android.filterfw.core.RoundRobinScheduler;
import android.util.Log;

import java.util.HashMap;

/**
 * This OneShotScheduler only schedules source filters at most once. All other
 * filters will be scheduled, and possibly repeatedly, until there is no filter
 * that can be scheduled.
 *
 * @hide
 */
public class OneShotScheduler extends RoundRobinScheduler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.571 -0400", hash_original_field = "D6246C70D25D3D7B364B44D83F4109EF", hash_generated_field = "520BB64C43C06D427C2AD9982F08991C")

    private static final String TAG = "OneShotScheduler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.567 -0400", hash_original_field = "174AAFC1A40014CDA0EF1E5545C3C997", hash_generated_field = "BF1292A81C0EB597EBE4B2218F2A04C9")

    private HashMap <String, Integer> scheduled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.569 -0400", hash_original_field = "CCFB9E24DC58F9E64BC75A559E0C33FC", hash_generated_field = "29542B7EA5B26DA8ADF116C9866AA3F1")


    private  boolean mLogVerbose;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.573 -0400", hash_original_method = "F2A08C38A968AF9FC5195183E5B9DCC4", hash_generated_method = "A835E3D71FA782D1F194E87B8E71CADD")
    
public OneShotScheduler(FilterGraph graph) {
        super(graph);
        scheduled = new HashMap<String, Integer>();
        mLogVerbose = Log.isLoggable(TAG, Log.VERBOSE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.575 -0400", hash_original_method = "A1DDB921E44A04F6F0FC6CCE46395D14", hash_generated_method = "AFABBA9CF668F3A6FEF60F46577B7531")
    
@Override
    public void reset() {
        super.reset();
        scheduled.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.578 -0400", hash_original_method = "D5967D1A96E5EE64505F3116C440F919", hash_generated_method = "9C04819789240B841691C4D38D095F12")
    
@Override
    public Filter scheduleNextNode() {
        Filter first = null;
        // return the first filter that is not scheduled before.
        while (true) {
            Filter filter = super.scheduleNextNode();
            if (filter == null) {
                if (mLogVerbose) Log.v(TAG, "No filters available to run.");
                return null;
            }
            if (!scheduled.containsKey(filter.getName())) {
                if (filter.getNumberOfConnectedInputs() == 0)
                    scheduled.put(filter.getName(),1);
                if (mLogVerbose) Log.v(TAG, "Scheduling filter \"" + filter.getName() + "\" of type " + filter.getFilterClassName());
                return filter;
            }
            // if loop back, nothing available
            if (first == filter) {
                break;
            }
            // save the first scheduled one
            if (first == null) first = filter;
        }
        if (mLogVerbose) Log.v(TAG, "One pass through graph completed.");
        return null;
    }
}
