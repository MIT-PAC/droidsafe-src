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

/**
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class StreamPort extends InputPort {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.791 -0400", hash_original_field = "C19DC9677FE0C896ED0788F993573D91", hash_generated_field = "AFF7D442E0805C50A97A97ACA687AFB9")

    private Frame mFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.793 -0400", hash_original_field = "E1263BE4F24799A096E4A190AF659E63", hash_generated_field = "1C30FD3100633379B7561B2FFED7CFE9")

    private boolean mPersistent;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.794 -0400", hash_original_method = "151F8402DA8214D34A209F7E9294F7AD", hash_generated_method = "00BD3A90F0A4B132412B3C8EDFCEBF4E")
    
public StreamPort(Filter filter, String name) {
        super(filter, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.796 -0400", hash_original_method = "E1480154D1601422A5709E863A312150", hash_generated_method = "FC83886E830A710C4E276CB5A37394A3")
    
@Override
    public void clear() {
        if (mFrame != null) {
            mFrame.release();
            mFrame = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.798 -0400", hash_original_method = "44A9B4C29D75730409F2BBA181FE4DD1", hash_generated_method = "CEDB30BAE6A10590AED2A979273285F7")
    
@Override
    public void setFrame(Frame frame) {
        assignFrame(frame, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.800 -0400", hash_original_method = "56EFC0665714A78C9E531EEE7F762A2D", hash_generated_method = "BE69AD22D63B0029EA2DB727BED2C9E6")
    
@Override
    public void pushFrame(Frame frame) {
        assignFrame(frame, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.803 -0400", hash_original_method = "E680508530519201071E74F694FBED5C", hash_generated_method = "85165FB20535F4C672C510FEA74AC3D2")
    
protected synchronized void assignFrame(Frame frame, boolean persistent) {
        assertPortIsOpen();
        checkFrameType(frame, persistent);

        if (persistent) {
            if (mFrame != null) {
                mFrame.release();
            }
        } else if (mFrame != null) {
            throw new RuntimeException(
                "Attempting to push more than one frame on port: " + this + "!");
        }
        mFrame = frame.retain();
        mFrame.markReadOnly();
        mPersistent = persistent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.805 -0400", hash_original_method = "67E2CDF5C74C03239A5E4DFD69D05C38", hash_generated_method = "D0308D5F79FCBBEC52FB375E4E62F172")
    
@Override
    public synchronized Frame pullFrame() {
        // Make sure we have a frame
        if (mFrame == null) {
            throw new RuntimeException("No frame available to pull on port: " + this + "!");
        }

        // Return a retained result
        Frame result = mFrame;
        if (mPersistent) {
            mFrame.retain();
        } else {
            mFrame = null;
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.807 -0400", hash_original_method = "5C0A749A29735A02E700A0EB131B2C67", hash_generated_method = "92F495C8EA516D43978B794DA869ABBC")
    
@Override
    public synchronized boolean hasFrame() {
        return mFrame != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.810 -0400", hash_original_method = "931CAA6DF472BF7AA71C3B235FCAE4A7", hash_generated_method = "D528DD764EAD8E810C2FBE3F12AAA26B")
    
@Override
    public String toString() {
        return "input " + super.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:05.813 -0400", hash_original_method = "2A5C56AAAC776DC4586CB85D97206838", hash_generated_method = "93FB8CF565A220921A3A8E43DEB3932B")
    
@Override
    public synchronized void transfer(FilterContext context) {
        if (mFrame != null) {
            checkFrameManager(mFrame, context);
        }
    }
}
