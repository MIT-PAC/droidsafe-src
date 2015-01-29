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
import android.filterfw.core.GLFrame;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.format.ImageFormat;

import java.util.Set;

/**
 * @hide
 */
public class GLTextureTarget extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.032 -0400", hash_original_field = "531BD146DEFF61A3DA50FB80244F0EAD", hash_generated_field = "AF5BD109F49CC99B3312E42630607C65")


    @GenerateFieldPort(name = "texId")
    private int mTexId;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.036 -0400", hash_original_method = "BCA4F3066993B2B368EF899621F0D789", hash_generated_method = "8B577B00C718D0DA7E5566FC7823FDC5")
    
public GLTextureTarget(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.040 -0400", hash_original_method = "B013A4A7991E2783B4BEAB5766964866", hash_generated_method = "CC5A6C732A1A5E1D8CFA32F94D4D6A77")
    
@Override
    public void setupPorts() {
        addMaskedInputPort("frame", ImageFormat.create(ImageFormat.COLORSPACE_RGBA));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.045 -0400", hash_original_method = "E78A31C1ADED8A03ABF018A8BD9200C3", hash_generated_method = "CE50810115C532F3022BC5017C1EDD6B")
    
@Override
    public void process(FilterContext context) {
        // Get input frame
        Frame input = pullInput("frame");

        FrameFormat format = ImageFormat.create(input.getFormat().getWidth(),
                                                input.getFormat().getHeight(),
                                                ImageFormat.COLORSPACE_RGBA,
                                                FrameFormat.TARGET_GPU);

        Frame frame = context.getFrameManager().newBoundFrame(format, GLFrame.EXISTING_TEXTURE_BINDING, mTexId);

        // Copy to our texture frame
        frame.setDataFromFrame(input);
        frame.release();
    }
}
