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
import java.util.Map.Entry;

/**
 * @hide
 */
public class FilterFunction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.396 -0400", hash_original_field = "E9FBEB72F5336AFA25831B1B3CB2A4B4", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

    private Filter mFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.399 -0400", hash_original_field = "D7554CB19BD4FB115F2FF07545DAB5A9", hash_generated_field = "54D4403BAC7AC7472A7E8C55A28CC65E")

    private FilterContext mFilterContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.401 -0400", hash_original_field = "BE41FACDC5DAFF9932C9DDE1FBC59CA4", hash_generated_field = "54C6C7159C314F618B6356BEA64256CB")

    private boolean mFilterIsSetup = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.403 -0400", hash_original_field = "5A3A753F1FE2CC6EB33067BCA8BC0A28", hash_generated_field = "D7F9B4788535F9F212A6C9B4615C283A")

    private FrameHolderPort[] mResultHolders;

    private class FrameHolderPort extends StreamPort {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.406 -0400", hash_original_method = "793082ACDD6DD17752CFD7EEA4E79C3D", hash_generated_method = "2E23E8312FCED0D381B84EF80B70B366")
        
public FrameHolderPort() {
            super(null, "holder");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.410 -0400", hash_original_method = "819396395B6823DD296855F84FF3F52F", hash_generated_method = "54B705396B5C8B2BB22624C0BDD3ECDA")
    
public FilterFunction(FilterContext context, Filter filter) {
        mFilterContext = context;
        mFilter = filter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.413 -0400", hash_original_method = "75B2C40067A6A78B3EF1F97DDF74A647", hash_generated_method = "2CABB1B80952C012FD330A801D160FD9")
    
public Frame execute(KeyValueMap inputMap) {
        int filterOutCount = mFilter.getNumberOfOutputs();

        // Sanity checks
        if (filterOutCount > 1) {
            throw new RuntimeException("Calling execute on filter " + mFilter + " with multiple "
                + "outputs! Use executeMulti() instead!");
        }

        // Setup filter
        if (!mFilterIsSetup) {
            connectFilterOutputs();
            mFilterIsSetup = true;
        }

        // Make sure GL environment is active
        boolean didActivateGLEnv = false;
        GLEnvironment glEnv = mFilterContext.getGLEnvironment();
        if (glEnv != null && !glEnv.isActive()) {
            glEnv.activate();
            didActivateGLEnv = true;
        }

        // Setup the inputs
        for (Entry<String, Object> entry : inputMap.entrySet()) {
            if (entry.getValue() instanceof Frame) {
                mFilter.pushInputFrame(entry.getKey(), (Frame)entry.getValue());
            } else {
                mFilter.pushInputValue(entry.getKey(), entry.getValue());
            }
        }

        // Process the filter
        if (mFilter.getStatus() != Filter.STATUS_PROCESSING) {
            mFilter.openOutputs();
        }

        mFilter.performProcess(mFilterContext);

        // Create result handle
        Frame result = null;
        if (filterOutCount == 1 && mResultHolders[0].hasFrame()) {
            result = mResultHolders[0].pullFrame();
        }

        // Deactivate GL environment if activated
        if (didActivateGLEnv) {
            glEnv.deactivate();
        }

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.416 -0400", hash_original_method = "C919EFF00DC015E0BB5B881585071C6F", hash_generated_method = "7CDE510065B5A6E4A22CBA26FDE84BB0")
    
public Frame executeWithArgList(Object... inputs) {
        return execute(KeyValueMap.fromKeyValues(inputs));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.418 -0400", hash_original_method = "455BD36898827B7DA0EF28070719DBB8", hash_generated_method = "0555EFDDBA33F9E1D1A019C0AD5A9799")
    
public void close() {
        mFilter.performClose(mFilterContext);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.420 -0400", hash_original_method = "BF7F2FE91F869AF67A90F8D5B0ADE3B9", hash_generated_method = "2AE870C63D543EC0610CEF345F6EE3DC")
    
public FilterContext getContext() {
        return mFilterContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.422 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "F668027EA3D6A22181739B4473EB4541")
    
public Filter getFilter() {
        return mFilter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.424 -0400", hash_original_method = "5F39944477BF8F99CAD0935BAE9B75A1", hash_generated_method = "EACEFCA05F5D45D4623119ACE1165C81")
    
public void setInputFrame(String input, Frame frame) {
        mFilter.setInputFrame(input, frame);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.427 -0400", hash_original_method = "C950A593426D2B98C21FE4817883DCDD", hash_generated_method = "DEDDD4B18766B1C9BE691DBA24A5A9E6")
    
public void setInputValue(String input, Object value) {
        mFilter.setInputValue(input, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.429 -0400", hash_original_method = "0C61FF9A7902357B30D2CF1AE810F15B", hash_generated_method = "C21906020657D41232D6DEC3C8CCB197")
    
public void tearDown() {
        mFilter.performTearDown(mFilterContext);
        mFilter = null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.431 -0400", hash_original_method = "A5AEB9F1EDDBEBEA0E2E3B1A8A53D7DC", hash_generated_method = "834CC7D5A741EC5A02CBC85FCB843CED")
    
@Override
    public String toString() {
        return mFilter.getName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.434 -0400", hash_original_method = "226F925E394DB29F79AB5045FE4D4C35", hash_generated_method = "4D2FC3393233EFDBCC274C94F6A5A719")
    
private void connectFilterOutputs() {
        int  i = 0;
        mResultHolders = new FrameHolderPort[mFilter.getNumberOfOutputs()];
        for (OutputPort outputPort : mFilter.getOutputPorts()) {
            mResultHolders[i] = new FrameHolderPort();
            outputPort.connectTo(mResultHolders[i]);
            ++i;
        }
    }
}
