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


package android.filterfw.format;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.MutableFrameFormat;
import android.graphics.Bitmap;

/**
 * @hide
 */
public class ImageFormat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.548 -0400", hash_original_field = "9E069AE0B24C29CC71791FBA3BAE7D0C", hash_generated_field = "3E03DD31812547355FB94132D0C57539")


    public static final String COLORSPACE_KEY = "colorspace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.551 -0400", hash_original_field = "2198E71CEE57E0FBE0715CCF05401D98", hash_generated_field = "FBAF478049B15028542B7DEF683621F0")


    public static final int COLORSPACE_GRAY  = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.553 -0400", hash_original_field = "859E99A125D682EA206C6146A6A11005", hash_generated_field = "EF5FB217E83BCE5595FA051AEB990DB6")

    public static final int COLORSPACE_RGB   = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.556 -0400", hash_original_field = "BB03D84839EC3827D74C0D5C5C6F9706", hash_generated_field = "12B7218ED0D4ACECB4E94FB3C9264CC7")

    public static final int COLORSPACE_RGBA  = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.559 -0400", hash_original_field = "FFCA416110A00D9552CDAB83F53B064A", hash_generated_field = "485CF577037BE6457F226DBB4EE599A3")

    public static final int COLORSPACE_YUV   = 4;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.561 -0400", hash_original_method = "2E8345BC6BD3601A88C15EE400E145D2", hash_generated_method = "E7CBDB664563BB208C98E92FB21382E9")
    
public static MutableFrameFormat create(int width,
                                            int height,
                                            int colorspace,
                                            int bytesPerSample,
                                            int target) {
        MutableFrameFormat result = new MutableFrameFormat(FrameFormat.TYPE_BYTE, target);
        result.setDimensions(width, height);
        result.setBytesPerSample(bytesPerSample);
        result.setMetaValue(COLORSPACE_KEY, colorspace);
        if (target == FrameFormat.TARGET_SIMPLE) {
            result.setObjectClass(Bitmap.class);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.563 -0400", hash_original_method = "3BD766684F8512EDC09BD51129E86F0F", hash_generated_method = "993AEBC081D4B85DEA7E5D6ABE1C3760")
    
public static MutableFrameFormat create(int width,
                                            int height,
                                            int colorspace,
                                            int target) {
        return create(width,
                      height,
                      colorspace,
                      bytesPerSampleForColorspace(colorspace),
                      target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.565 -0400", hash_original_method = "6B0F9B35DAA6C056FFDEE5CF394FE69C", hash_generated_method = "CDB7EF3378BE7EDD3FB137C06E3518AC")
    
public static MutableFrameFormat create(int colorspace, int target) {
        return create(FrameFormat.SIZE_UNSPECIFIED,
                      FrameFormat.SIZE_UNSPECIFIED,
                      colorspace,
                      bytesPerSampleForColorspace(colorspace),
                      target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.567 -0400", hash_original_method = "C5D2A66D51320470E06ED57CCBDC01DA", hash_generated_method = "A91673C8BA5C999066FBA688937650D9")
    
public static MutableFrameFormat create(int colorspace) {
        return create(FrameFormat.SIZE_UNSPECIFIED,
                      FrameFormat.SIZE_UNSPECIFIED,
                      colorspace,
                      bytesPerSampleForColorspace(colorspace),
                      FrameFormat.TARGET_UNSPECIFIED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.569 -0400", hash_original_method = "FC00BAD58C3187B5165952B5AE38429E", hash_generated_method = "D3DBA32B395B241D9A6829D695F91578")
    
public static int bytesPerSampleForColorspace(int colorspace) {
        switch (colorspace) {
            case COLORSPACE_GRAY:
                return 1;
            case COLORSPACE_RGB:
                return 3;
            case COLORSPACE_RGBA:
                return 4;
            case COLORSPACE_YUV:
                return 3;
            default:
                throw new RuntimeException("Unknown colorspace id " + colorspace + "!");
        }
    }
}
