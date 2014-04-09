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
public class GLTextureSource extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.901 -0400", hash_original_field = "531BD146DEFF61A3DA50FB80244F0EAD", hash_generated_field = "AF5BD109F49CC99B3312E42630607C65")


    @GenerateFieldPort(name = "texId")
    private int mTexId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.905 -0400", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "3F7B66C3BB05F33DDC2B3762E68AC099")


    @GenerateFieldPort(name = "width")
    private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.909 -0400", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "CBF1C1ABAC5CAC04682FA8A1AC09F410")


    @GenerateFieldPort(name = "height")
    private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.913 -0400", hash_original_field = "F089C48CAA2D2DE124CC433CF651BE5C", hash_generated_field = "0CB43F6FCE160E4C2ED9F21B5F852660")


    @GenerateFieldPort(name = "repeatFrame", hasDefault = true)
    private boolean mRepeatFrame = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.918 -0400", hash_original_field = "6065A429042CB597ED61515C7702CCD0", hash_generated_field = "3863010BE49F15AEFC15C18F82FB56EE")

    @GenerateFieldPort(name = "timestamp", hasDefault = true)
    private long mTimestamp = Frame.TIMESTAMP_UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.921 -0400", hash_original_field = "C19DC9677FE0C896ED0788F993573D91", hash_generated_field = "AFF7D442E0805C50A97A97ACA687AFB9")


    private Frame mFrame;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.924 -0400", hash_original_method = "740D3CD4E79863769A3DF28296C2F34A", hash_generated_method = "54151157468C4681CA0FB7B414824BCC")
    
public GLTextureSource(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.928 -0400", hash_original_method = "55977720AD97959B6CD1C64C3D6EB74B", hash_generated_method = "2452EBE4CC268657807D509BF8C86E02")
    
@Override
    public void setupPorts() {
        addOutputPort("frame", ImageFormat.create(ImageFormat.COLORSPACE_RGBA,
                                                  FrameFormat.TARGET_GPU));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.932 -0400", hash_original_method = "2E503590EC82A433C32720AF0624E2F8", hash_generated_method = "2F697E22A598920CD2DC75D9F13FF5F4")
    
@Override
    public void fieldPortValueUpdated(String name, FilterContext context) {
        // Release frame, so that it is recreated during the next process call
        if (mFrame != null) {
            mFrame.release();
            mFrame = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.936 -0400", hash_original_method = "661F2F9D9AF9A9D16413089EC75C81F1", hash_generated_method = "7386A9515AEF55DA8E4A576C2F518B8E")
    
@Override
    public void process(FilterContext context) {
        // Generate frame if not generated already
        if (mFrame == null) {
            FrameFormat outputFormat = ImageFormat.create(mWidth, mHeight,
                                                          ImageFormat.COLORSPACE_RGBA,
                                                          FrameFormat.TARGET_GPU);
            mFrame = context.getFrameManager().newBoundFrame(outputFormat,
                                                             GLFrame.EXISTING_TEXTURE_BINDING,
                                                             mTexId);
            mFrame.setTimestamp(mTimestamp);
        }

        // Push output
        pushOutput("frame", mFrame);

        if (!mRepeatFrame) {
            // Close output port as we are done here
            closeOutputPort("frame");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.940 -0400", hash_original_method = "F149B1D50E94BFE7E4E430529B2A2187", hash_generated_method = "FC66555B997143A5E1E447FC7724FBA8")
    
@Override
    public void tearDown(FilterContext context) {
        if (mFrame != null) {
            mFrame.release();
        }
    }

}
