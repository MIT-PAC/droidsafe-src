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
import android.filterfw.core.Filter;
import android.filterfw.core.Scheduler;

/**
 * @hide
 */
public class SimpleScheduler extends Scheduler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.646 -0400", hash_original_method = "00DA2F9D81A81D29D743D1C424360662", hash_generated_method = "82B62A16BD7B02737E714E318D08DCEA")
    
public SimpleScheduler(FilterGraph graph) {
        super(graph);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.648 -0400", hash_original_method = "4EF91A3E15873EFCED84A853021A57CF", hash_generated_method = "0B2662DB1D26440275E15FE32301A5F4")
    
@Override
    public void reset() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.651 -0400", hash_original_method = "E08CAB879FCFC499582B1561AB7656F2", hash_generated_method = "631BD7E7972C9BADCC206D463C41C15A")
    
@Override
    public Filter scheduleNextNode() {
        for (Filter filter : getGraph().getFilters()) {
            if (filter.canProcess())
                return filter;
        }
        return null;
    }

}
