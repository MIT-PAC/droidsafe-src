/*
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


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Set;

import android.filterfw.core.Filter;
import android.filterfw.core.Scheduler;

/**
 * @hide
 */
public class RoundRobinScheduler extends Scheduler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.880 -0400", hash_original_field = "2F40F5FB29927CA51C0887BEE643BE6B", hash_generated_field = "DCDB71DFB130B4E3B3663BAC7741400B")


    private int mLastPos = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.883 -0400", hash_original_method = "0C97F29ADEDF8762719BB66F61179792", hash_generated_method = "AB8088D154E0915FC74104583CAEDB28")
    
public RoundRobinScheduler(FilterGraph graph) {
        super(graph);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.885 -0400", hash_original_method = "0F2D5B3D34669931FAB5745FCFA5B7CD", hash_generated_method = "E417CBE0EFC02E1492BCFED1B782736F")
    
@Override
    public void reset() {
        mLastPos = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:04.888 -0400", hash_original_method = "74B36A9D88986B3284DE648B468DFDCD", hash_generated_method = "B8C41A4F7FA31997DA9938177DEE6B2A")
    
@Override
    public Filter scheduleNextNode() {
        Set<Filter> all_filters = getGraph().getFilters();
        if (mLastPos >= all_filters.size()) mLastPos = -1;
        int pos = 0;
        Filter first = null;
        int firstNdx = -1;
        for (Filter filter : all_filters) {
            if (filter.canProcess()) {
                if (pos <= mLastPos) {
                    if (first == null) {
                        // store the first available filter
                        first = filter;
                        firstNdx = pos;
                    }
                } else {
                    // return the next available filter since last
                    mLastPos = pos;
                    return filter;
                }
            }
            pos ++;
        }
        // going around from the beginning
        if (first != null ) {
            mLastPos = firstNdx;
            return first;
        }
        // if there is nothing to be scheduled, still keep the previous
        // position.
        return null;
    }
}
