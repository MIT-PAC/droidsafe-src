/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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



/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.filterpacks.base;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Set;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.format.ObjectFormat;

/**
 * @hide
 */
public class ObjectSource extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.261 -0400", hash_original_field = "63EB2904DE14485FE87749A3C0F578EC", hash_generated_field = "762D860C7E48C634E265FABDC007DAD1")


    @GenerateFieldPort(name = "object")
    private Object mObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.264 -0400", hash_original_field = "7E4426CB4877D8014B18C91387DED3FD", hash_generated_field = "C49F8BC458319686EDAC29BB5D02C3A5")


    @GenerateFinalPort(name = "format", hasDefault = true)
    private FrameFormat mOutputFormat = FrameFormat.unspecified();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.267 -0400", hash_original_field = "F089C48CAA2D2DE124CC433CF651BE5C", hash_generated_field = "053035A80DB458AF9ACD55D79119A2CB")


    @GenerateFieldPort(name = "repeatFrame", hasDefault = true)
    boolean mRepeatFrame = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.270 -0400", hash_original_field = "C19DC9677FE0C896ED0788F993573D91", hash_generated_field = "AFF7D442E0805C50A97A97ACA687AFB9")


    private Frame mFrame;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.274 -0400", hash_original_method = "E98A087A244194973E2D1F811A1B8E53", hash_generated_method = "D6CB7EDC33C0336F7139DC5841DE227E")
    
public ObjectSource(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.276 -0400", hash_original_method = "153F52204D3C2F7F83E8018FBEE49A45", hash_generated_method = "A58B194DF993B86E3DF6DEEE355FDD57")
    
@Override
    public void setupPorts() {
        addOutputPort("frame", mOutputFormat);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.279 -0400", hash_original_method = "4421626EFABCA18FC72B17F888C5E23E", hash_generated_method = "C1064CF9EA5B75AFC223A228DBFE52D3")
    
@Override
    public void process(FilterContext context) {
        // If no frame has been created, create one now.
        if (mFrame == null) {
            if (mObject == null) {
                throw new NullPointerException("ObjectSource producing frame with no object set!");
            }
            FrameFormat outputFormat = ObjectFormat.fromObject(mObject, FrameFormat.TARGET_SIMPLE);
            mFrame = context.getFrameManager().newFrame(outputFormat);
            mFrame.setObjectValue(mObject);
            mFrame.setTimestamp(Frame.TIMESTAMP_UNKNOWN);
        }

        // Push output
        pushOutput("frame", mFrame);

        // Wait for free output
        if (!mRepeatFrame) {
            closeOutputPort("frame");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.282 -0400", hash_original_method = "31625240DD0A6F01C9B3527D3018E1B7", hash_generated_method = "2C87D2AA80D65D78B82F61941C4D1CEC")
    
@Override
    public void tearDown(FilterContext context) {
        mFrame.release();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.285 -0400", hash_original_method = "F500397D8D189CD183ABB4FE599E6C81", hash_generated_method = "FCF75D6B785D146384B0773F5EB3124E")
    
@Override
    public void fieldPortValueUpdated(String name, FilterContext context) {
        // Release our internal frame, so that it is regenerated on the next call to process().
        if (name.equals("object")) {
            if (mFrame != null) {
                mFrame.release();
                mFrame = null;
            }
        }
    }
}
