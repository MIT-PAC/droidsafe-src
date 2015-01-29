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


package android.filterpacks.base;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;

/**
 * @hide
 */
public class FrameStore extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.817 -0400", hash_original_field = "4666685C3669B68C1BDAE5D25D295D9D", hash_generated_field = "1135E271E6D4419EAA2D4806DCE87C92")


    @GenerateFieldPort(name = "key")
    private String mKey;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.821 -0400", hash_original_method = "9B07387935B7A16FECDEE6C00C465068", hash_generated_method = "F82AD07DA28AB384EC8D73C7A6967E49")
    
public FrameStore(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.824 -0400", hash_original_method = "43D02BEF1A869E5ED4723F10A1D743D3", hash_generated_method = "A05959A1612C1C0A52BA95C1FE1E72B1")
    
@Override
    public void setupPorts() {
        addInputPort("frame");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.828 -0400", hash_original_method = "DBC67CF6A075AD017CD6BED9F5B18D8F", hash_generated_method = "EEBA39EA06D1A0DB0A206B484CB2516F")
    
public void process(FilterContext context) {
        // Get input frame
        Frame input = pullInput("frame");

        // Store frame
        context.storeFrame(mKey, input);
    }

}
