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
import android.filterfw.core.KeyValueMap;
import android.filterfw.core.MutableFrameFormat;

/**
 * @hide
 */
public class RetargetFilter extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.424 -0400", hash_original_field = "96131610597DF73273E063539CD2F1B7", hash_generated_field = "AE9CB8598DAB537D70008F50BEA0CDF8")


    @GenerateFinalPort(name = "target", hasDefault = false)
    private String mTargetString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.427 -0400", hash_original_field = "F48C3A3D1B9A3B6A5FC31491455AC038", hash_generated_field = "984F802A327A49AB6463D44C1A768344")


    private MutableFrameFormat mOutputFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.429 -0400", hash_original_field = "7AB7F7E8791EC7E65FC1F01A8EF0F2F2", hash_generated_field = "2744DD14450E0ED802DD3684DCC4A29E")

    private int mTarget = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.432 -0400", hash_original_method = "C8B5AF6272D8457953EC8F899ABA35EC", hash_generated_method = "EFAF21355B7659716804A703E55DA196")
    
public RetargetFilter(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.435 -0400", hash_original_method = "84A4375333EFA80059F1962876CFDC9B", hash_generated_method = "7429133187C83900189BEC6129A0A5E3")
    
@Override
    public void setupPorts() {
        // Setup target
        mTarget = FrameFormat.readTargetString(mTargetString);

        // Add ports
        addInputPort("frame");
        addOutputBasedOnInput("frame", "frame");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.438 -0400", hash_original_method = "536AFADA8BA844AAB9F7AE4E470184D5", hash_generated_method = "5EEEEDAAE3BBD669EE6309D9945081A8")
    
@Override
    public FrameFormat getOutputFormat(String portName, FrameFormat inputFormat) {
        MutableFrameFormat retargeted = inputFormat.mutableCopy();
        retargeted.setTarget(mTarget);
        return retargeted;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.440 -0400", hash_original_method = "28589E82BCCAC06A6032061F13433393", hash_generated_method = "A0F21980DD3BE3580563C5E53419B262")
    
@Override
    public void process(FilterContext context) {
        // Get input frame
        Frame input = pullInput("frame");

        // Create output frame
        Frame output = context.getFrameManager().duplicateFrameToTarget(input, mTarget);

        // Push output
        pushOutput("frame", output);

        // Release pushed frame
        output.release();
    }

}
