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

/**
 * @hide
 */
public class NullFilter extends Filter {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.200 -0400", hash_original_method = "3887EA006D57854395904515AF4F8544", hash_generated_method = "9F321D987D951FF47192971308CDB7B0")
    
public NullFilter(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.203 -0400", hash_original_method = "43D02BEF1A869E5ED4723F10A1D743D3", hash_generated_method = "A05959A1612C1C0A52BA95C1FE1E72B1")
    
@Override
    public void setupPorts() {
        addInputPort("frame");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.206 -0400", hash_original_method = "EF824EE734877DB57620C72F073EF88C", hash_generated_method = "F19310D6936CA60A4F736E0743E28F0F")
    
@Override
    public void process(FilterContext context) {
        pullInput("frame");
    }

}
