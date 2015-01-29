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
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.core.KeyValueMap;

/**
 * @hide
 */
public class FrameBranch extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.559 -0400", hash_original_field = "FF5A211440D2E36BBC468899CB7540C1", hash_generated_field = "CEA56E62301AEEAEADF36259752DCEA1")


    @GenerateFinalPort(name = "outputs", hasDefault = true)
    private int mNumberOfOutputs = 2;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.563 -0400", hash_original_method = "3EFC51152269EBB8A4E18A7F4DDB1D41", hash_generated_method = "4176F1D33CE16B78DA7B1BBB03A53861")
    
public FrameBranch(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.567 -0400", hash_original_method = "D691AE03CB8D05EABDD729B336EB2FE6", hash_generated_method = "E7BE8C4A4B215A3A39D348FCD54E178F")
    
@Override
    public void setupPorts() {
        addInputPort("in");
        for (int i = 0; i < mNumberOfOutputs; ++i) {
            addOutputBasedOnInput("out" + i, "in");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.571 -0400", hash_original_method = "47C8144F7154BBBAF6C5C234EA442042", hash_generated_method = "04AD6D9243AEF2FC7ED294925E59E9BA")
    
@Override
    public FrameFormat getOutputFormat(String portName, FrameFormat inputFormat) {
        return inputFormat;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.576 -0400", hash_original_method = "A15DAC7745709B970D00F04437B426DE", hash_generated_method = "1C63903012E24192FA82C4349C239FA7")
    
public void process(FilterContext context) {
        // Get input frame
        Frame input = pullInput("in");

        // Push output
        for (int i = 0; i < mNumberOfOutputs; ++i) {
            pushOutput("out" + i, input);
        }
    }

}
