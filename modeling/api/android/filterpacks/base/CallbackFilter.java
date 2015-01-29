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
import android.filterfw.core.NativeProgram;
import android.filterfw.core.NativeFrame;
import android.filterfw.core.Program;
import android.os.Handler;
import android.os.Looper;

import java.lang.Runnable;

/**
 * @hide
 */
public class CallbackFilter extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.299 -0400", hash_original_field = "DA1CC322A22874297D9BC3D5725F0E90", hash_generated_field = "CDF9ECD89E0D459D80B955C72EB9CE57")

    @GenerateFieldPort(name = "listener", hasDefault = true)
    private FilterContext.OnFrameReceivedListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.303 -0400", hash_original_field = "226A7C6502AB948D187D5632223BC72F", hash_generated_field = "56FB14870E68042D9D7BF3D9FD648DAF")

    @GenerateFieldPort(name = "userData", hasDefault = true)
    private Object mUserData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.306 -0400", hash_original_field = "343FB082C33F88F3E826E914289630FB", hash_generated_field = "2030E1FFD2C63101642DF475D42A3360")

    @GenerateFinalPort(name = "callUiThread", hasDefault = true)
    private boolean mCallbacksOnUiThread = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.309 -0400", hash_original_field = "7667443146CC3F56EE6876E57EF46DF4", hash_generated_field = "B3091F4E42E4A1AB5D6A4785989484B3")

    private Handler mUiThreadHandler;

    private class CallbackRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.313 -0400", hash_original_field = "E9FBEB72F5336AFA25831B1B3CB2A4B4", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

        private Filter mFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.316 -0400", hash_original_field = "C19DC9677FE0C896ED0788F993573D91", hash_generated_field = "AFF7D442E0805C50A97A97ACA687AFB9")

        private Frame mFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.319 -0400", hash_original_field = "226A7C6502AB948D187D5632223BC72F", hash_generated_field = "6D47C086CAE9137E0CE754A20D8D9E3C")

        private Object mUserData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.322 -0400", hash_original_field = "DA1CC322A22874297D9BC3D5725F0E90", hash_generated_field = "CBFFE3ECC489A9FE9C9BFBCFC7664295")

        private FilterContext.OnFrameReceivedListener mListener;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.326 -0400", hash_original_method = "6177B7D07326B89638017EB372F3A6B2", hash_generated_method = "FBA59E00C1FFE74469ADB98A9A059E37")
        
public CallbackRunnable(FilterContext.OnFrameReceivedListener listener, Filter filter, Frame frame, Object userData) {
            mListener = listener;
            mFilter = filter;
            mFrame = frame;
            mUserData = userData;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.329 -0400", hash_original_method = "5A83EF49B6B92DC977E0343EF5C3F232", hash_generated_method = "C59DE47CD8ACB181772B2E58E045F6ED")
        
public void run() {
            mListener.onFrameReceived(mFilter, mFrame, mUserData);
            mFrame.release();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.335 -0400", hash_original_method = "F9B5724786AB761DA4A3667BCCA98916", hash_generated_method = "FF4329ABE0D1F5925A9C36DB3760CD24")
    
public CallbackFilter(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.338 -0400", hash_original_method = "43D02BEF1A869E5ED4723F10A1D743D3", hash_generated_method = "A05959A1612C1C0A52BA95C1FE1E72B1")
    
@Override
    public void setupPorts() {
        addInputPort("frame");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.341 -0400", hash_original_method = "3A1D99F2F683B2B3CD58C2E81E4E959A", hash_generated_method = "67E5412722AA6EB04A0C6A232601C980")
    
public void prepare(FilterContext context) {
        if (mCallbacksOnUiThread) {
            mUiThreadHandler = new Handler(Looper.getMainLooper());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.344 -0400", hash_original_method = "F532A54C8ABDC22259EE4E184A711F18", hash_generated_method = "4E7D64AF8A952C3494158D96BAC3C3B5")
    
public void process(FilterContext context) {
        // Get frame and forward to listener
        final Frame input = pullInput("frame");
        if (mListener != null) {
            if (mCallbacksOnUiThread) {
                input.retain();
                CallbackRunnable uiRunnable = new CallbackRunnable(mListener, this, input, mUserData);
                if (!mUiThreadHandler.post(uiRunnable)) {
                    throw new RuntimeException("Unable to send callback to UI thread!");
                }
            } else {
                mListener.onFrameReceived(this, input, mUserData);
            }
        } else {
            throw new RuntimeException("CallbackFilter received frame, but no listener set!");
        }
    }

}
