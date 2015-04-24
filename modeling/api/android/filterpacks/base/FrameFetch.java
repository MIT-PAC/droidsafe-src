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
import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;

import android.util.Log;

/**
 * @hide
 */
public class FrameFetch extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.634 -0400", hash_original_field = "47613899F4726DA2692D997866DE4B3B", hash_generated_field = "EE62E96E2911BC2A03E7CEC2C35733AB")


    @GenerateFinalPort(name = "format", hasDefault = true)
    private FrameFormat mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.673 -0400", hash_original_field = "4666685C3669B68C1BDAE5D25D295D9D", hash_generated_field = "1135E271E6D4419EAA2D4806DCE87C92")


    @GenerateFieldPort(name = "key")
    private String mKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.678 -0400", hash_original_field = "F089C48CAA2D2DE124CC433CF651BE5C", hash_generated_field = "0CB43F6FCE160E4C2ED9F21B5F852660")


    @GenerateFieldPort(name = "repeatFrame", hasDefault = true)
    private boolean mRepeatFrame = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.681 -0400", hash_original_method = "AD900A0C7BE1C677B5A2355DB22D9AF2", hash_generated_method = "67A4CC0017886B203D78080EC9E9E69F")
    
public FrameFetch(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.686 -0400", hash_original_method = "F6B1C8204E109E914C39705DFBDF8319", hash_generated_method = "020F6AF1E5406B60C2041C5E9594ECFA")
    
@Override
    public void setupPorts() {
        addOutputPort("frame", mFormat == null ? FrameFormat.unspecified() : mFormat);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.690 -0400", hash_original_method = "11863BF505E4BFF9AC49DC5A3B3EE523", hash_generated_method = "C88DADA2EA535B9595B49042A4A0A9A9")
    
public void process(FilterContext context) {
        Frame output = context.fetchFrame(mKey);
        if (output != null) {
            pushOutput("frame", output);
            if (!mRepeatFrame) {
                closeOutputPort("frame");
            }
        } else {
            delayNextProcess(250);
        }
    }

}
