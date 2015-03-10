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


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.FrameManager;
import android.filterfw.core.GLFrame;
import android.filterfw.core.NativeFrame;
import android.filterfw.core.SimpleFrame;
import android.filterfw.core.VertexFrame;

/**
 * @hide
 */
public class SimpleFrameManager extends FrameManager {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.606 -0400", hash_original_method = "9AE489D1DB0431630039A7615731833A", hash_generated_method = "60B9148A91F4DC25161EB3BB30A9E49F")
    
public SimpleFrameManager() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.608 -0400", hash_original_method = "DC32DCD8B11C6C15E4F2182359268531", hash_generated_method = "39E4BE89977A9005E8B1D0494723F549")
    
@Override
    public Frame newFrame(FrameFormat format) {
        return createNewFrame(format);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.610 -0400", hash_original_method = "CDA5C14F8CDCE778A8FB11BE8150AA9D", hash_generated_method = "3FFDA852F4258D4F3758CE4950CDFF55")
    
@Override
    public Frame newBoundFrame(FrameFormat format, int bindingType, long bindingId) {
        Frame result = null;
        switch(format.getTarget()) {
            case FrameFormat.TARGET_GPU: {
                GLFrame glFrame = new GLFrame(format, this, bindingType, bindingId);
                glFrame.init(getGLEnvironment());
                result = glFrame;
                break;
            }

            default:
                throw new RuntimeException("Attached frames are not supported for target type: "
                    + FrameFormat.targetToString(format.getTarget()) + "!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.612 -0400", hash_original_method = "D9BBB52F9327CED81F2FD031D449BDDB", hash_generated_method = "BEBB154B0E0C4A7B71B71BFF09B6D9F8")
    
private Frame createNewFrame(FrameFormat format) {
        Frame result = null;
        switch(format.getTarget()) {
            case FrameFormat.TARGET_SIMPLE:
                result = new SimpleFrame(format, this);
                break;

            case FrameFormat.TARGET_NATIVE:
                result = new NativeFrame(format, this);
                break;

            case FrameFormat.TARGET_GPU: {
                GLFrame glFrame = new GLFrame(format, this);
                glFrame.init(getGLEnvironment());
                result = glFrame;
                break;
            }

            case FrameFormat.TARGET_VERTEXBUFFER: {
                result = new VertexFrame(format, this);
                break;
            }

            default:
                throw new RuntimeException("Unsupported frame target type: " +
                                           FrameFormat.targetToString(format.getTarget()) + "!");
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.614 -0400", hash_original_method = "ABDDA5E524E12A2B17D2C27425316FD9", hash_generated_method = "022C30C5F8D5387B90F915A66921E452")
    
@Override
    public Frame retainFrame(Frame frame) {
        frame.incRefCount();
        return frame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.616 -0400", hash_original_method = "59D02CEC00EF815EE803C3374C27459D", hash_generated_method = "2F68D0C970CA62EB09CB198464CD461A")
    
@Override
    public Frame releaseFrame(Frame frame) {
        int refCount = frame.decRefCount();
        if (refCount == 0 && frame.hasNativeAllocation()) {
            frame.releaseNativeAllocation();
            return null;
        } else if (refCount < 0) {
            throw new RuntimeException("Frame reference count dropped below 0!");
        }
        return frame;
    }

}
