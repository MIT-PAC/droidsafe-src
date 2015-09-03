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

import java.io.OutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @hide
 */
public class OutputStreamTarget extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.369 -0400", hash_original_field = "73A4A3989B1458C88FDAFF3AF49183EC", hash_generated_field = "9E0079F65B3740497025B7021D8F5049")


    @GenerateFieldPort(name = "stream")
    private OutputStream mOutputStream;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.372 -0400", hash_original_method = "779D189220EDEACFF1F47A26746D88A4", hash_generated_method = "9CB91536A7D1552FF92FFE3E562047DB")
    
public OutputStreamTarget(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.375 -0400", hash_original_method = "D6D1D54C1D0C92C13AF98A0DB8ADF9B0", hash_generated_method = "C72D5253DFFC0D3FB65A8B27F5D0FB5C")
    
@Override
    public void setupPorts() {
        addInputPort("data");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:58.378 -0400", hash_original_method = "DF3430C8E62DA486D187DF231DCAF570", hash_generated_method = "6B67E927E8E32A3558ACC4EB33D1A508")
    
@Override
    public void process(FilterContext context) {
        Frame input = pullInput("data");
        ByteBuffer data;

        if (input.getFormat().getObjectClass() == String.class) {
            String stringVal = (String)input.getObjectValue();
            data = ByteBuffer.wrap(stringVal.getBytes());
        } else {
            data = input.getData();
        }
        try {
            mOutputStream.write(data.array(), 0, data.limit());
            mOutputStream.flush();
        } catch (IOException exception) {
            throw new RuntimeException(
                "OutputStreamTarget: Could not write to stream: " + exception.getMessage() + "!");
        }
    }
}
