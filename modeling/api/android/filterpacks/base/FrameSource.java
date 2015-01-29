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
import android.filterfw.core.GenerateFinalPort;

/**
 * @hide
 */
public class FrameSource extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.748 -0400", hash_original_field = "47613899F4726DA2692D997866DE4B3B", hash_generated_field = "EB40E631F158079600DAE93578843225")


    @GenerateFinalPort(name = "format")
    private FrameFormat mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.751 -0400", hash_original_field = "17CA85595AF0A3F92D75EC371AA1968B", hash_generated_field = "82471FEA75068F361CD94F258FFF3B13")


    @GenerateFieldPort(name = "frame", hasDefault = true)
    private Frame mFrame = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.755 -0400", hash_original_field = "F089C48CAA2D2DE124CC433CF651BE5C", hash_generated_field = "0CB43F6FCE160E4C2ED9F21B5F852660")


    @GenerateFieldPort(name = "repeatFrame", hasDefault = true)
    private boolean mRepeatFrame = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.758 -0400", hash_original_method = "428BDEBD21AE108DAC7A4AE271937C37", hash_generated_method = "4AC6204F30BDE5ADC43C7F3D414ACDFD")
    
public FrameSource(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.762 -0400", hash_original_method = "758DAFEA404ED87A61C46701770328E0", hash_generated_method = "E65B2842E9945A6A1340F48526FA91E0")
    
@Override
    public void setupPorts() {
        addOutputPort("frame", mFormat);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.766 -0400", hash_original_method = "9006808DD9B666A74C01347A3EC0D0A0", hash_generated_method = "8DD0F4A68DA084DA89E97002C1CF344C")
    
@Override
    public void process(FilterContext context) {
        if (mFrame != null) {
            // Push output
            pushOutput("frame", mFrame);
        }

        if (!mRepeatFrame) {
            // Close output port as we are done here
            closeOutputPort("frame");
        }
    }

}
