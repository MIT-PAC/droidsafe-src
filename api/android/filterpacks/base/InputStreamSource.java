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
import android.filterfw.format.PrimitiveFormat;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @hide
 */
public class InputStreamSource extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.120 -0400", hash_original_field = "0E5A5F1757CEEF7344767A5F58BA86AD", hash_generated_field = "5ACCF73E54855FA7B8A92BD660089CC3")


    @GenerateFinalPort(name = "target")
    private String mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.123 -0400", hash_original_field = "514FB88864F91247F240CC01D2ACC68C", hash_generated_field = "CE09661CCAD9FF04A8D1683D506BA4CE")


    @GenerateFieldPort(name = "stream")
    private InputStream mInputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.127 -0400", hash_original_field = "1A9D364657300B2C97156DEF0D051C9A", hash_generated_field = "15BCC374E24D856E452AF89E3274CD3A")


    @GenerateFinalPort(name = "format", hasDefault = true)
    private MutableFrameFormat mOutputFormat = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.131 -0400", hash_original_method = "C7CCB7376443935E37D0AF738D0F2361", hash_generated_method = "6228FC2AEEE95DBF6C65734DD3567B3B")
    
public InputStreamSource(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.134 -0400", hash_original_method = "E2C0A7363F6F2B5F5F1E48C699717CC0", hash_generated_method = "14724248218E9D94205C6AC80C0F8467")
    
@Override
    public void setupPorts() {
        int target = FrameFormat.readTargetString(mTarget);
        if (mOutputFormat == null) {
            mOutputFormat = PrimitiveFormat.createByteFormat(target);
        }
        addOutputPort("data", mOutputFormat);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.139 -0400", hash_original_method = "488A0E851A0831A37726F1576AE45085", hash_generated_method = "E0B99A927035C3553AF016EA2B4BC7E7")
    
@Override
    public void process(FilterContext context) {
        int fileSize = 0;
        ByteBuffer byteBuffer = null;

        // Read the file
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = mInputStream.read(buffer)) > 0) {
                byteStream.write(buffer, 0, bytesRead);
                fileSize += bytesRead;
            }
            byteBuffer = ByteBuffer.wrap(byteStream.toByteArray());
        } catch (IOException exception) {
            throw new RuntimeException(
                "InputStreamSource: Could not read stream: " + exception.getMessage() + "!");
        }

        // Put it into a frame
        mOutputFormat.setDimensions(fileSize);
        Frame output = context.getFrameManager().newFrame(mOutputFormat);
        output.setData(byteBuffer);

        // Push output
        pushOutput("data", output);

        // Release pushed frame
        output.release();

        // Close output port as we are done here
        closeOutputPort("data");
    }
}
