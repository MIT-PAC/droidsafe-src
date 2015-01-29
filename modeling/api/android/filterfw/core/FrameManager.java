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
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.MutableFrameFormat;

/**
 * @hide
 */
public abstract class FrameManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.542 -0400", hash_original_field = "D6E5CFBFA0DC2FDA2B8D92A477B24166", hash_generated_field = "54A795D76EECF1DFA15EA59DBD8B1B14")


    private FilterContext mContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.544 -0400", hash_original_method = "74AE31C55FB524C35BCD3BECE533D6AC", hash_generated_method = "3268308D8784433B99A52CD70A93B28C")
    
public abstract Frame newFrame(FrameFormat format);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.547 -0400", hash_original_method = "483DFA1894FFB395760289BE7A8313CD", hash_generated_method = "612C65B546B06A554CE338F817639D7B")
    
public abstract Frame newBoundFrame(FrameFormat format, int bindingType, long bindingId);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.549 -0400", hash_original_method = "6F0C7A6FDB37A8407EBF0C72D72CDF84", hash_generated_method = "461151ABB21C8A3FEA5E4B16CF7DAE78")
    
public Frame duplicateFrame(Frame frame) {
        Frame result = newFrame(frame.getFormat());
        result.setDataFromFrame(frame);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.552 -0400", hash_original_method = "364A70ADB4D194AF00C52F65DDC8DA46", hash_generated_method = "26F74E827AD1D7FC165CCA6E555277BF")
    
public Frame duplicateFrameToTarget(Frame frame, int newTarget) {
        MutableFrameFormat newFormat = frame.getFormat().mutableCopy();
        newFormat.setTarget(newTarget);
        Frame result = newFrame(newFormat);
        result.setDataFromFrame(frame);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.554 -0400", hash_original_method = "DED7D12E32A569A4533AFBAB9817FC41", hash_generated_method = "6B1892D354D148BD82F4E24381B2246D")
    
public abstract Frame retainFrame(Frame frame);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.556 -0400", hash_original_method = "F10E2E4B4303F7AF4F032F02FE72BB71", hash_generated_method = "F8E63F0CFAC592F719A55BCB2A434B74")
    
public abstract Frame releaseFrame(Frame frame);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.558 -0400", hash_original_method = "3A6A1A99DE88FE112B716367E8A4E4CA", hash_generated_method = "4C5F5C80F56697D18436511D12998B69")
    
public FilterContext getContext() {
        return mContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.561 -0400", hash_original_method = "5E85A9CDC3425E6879447948D3802CA8", hash_generated_method = "42CC32F7D5B52B313733BBEC208B44C1")
    
public GLEnvironment getGLEnvironment() {
        return mContext != null ? mContext.getGLEnvironment() : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.562 -0400", hash_original_method = "6EC4395C215947EFB3C6A99F968884F1", hash_generated_method = "186C772EE402ACEC59344F8DAFD25AF8")
    
public void tearDown() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:02.564 -0400", hash_original_method = "7637BD9DAA031EF2B2B139F76D06EEFE", hash_generated_method = "7637BD9DAA031EF2B2B139F76D06EEFE")
    
void setContext(FilterContext context) {
        mContext = context;
    }
}
