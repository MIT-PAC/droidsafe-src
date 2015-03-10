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
import android.filterfw.core.Filter;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameManager;
import android.filterfw.core.GLEnvironment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @hide
 */
public class FilterContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.112 -0400", hash_original_field = "B8CC72B24B18473F023C29A9BDF429C7", hash_generated_field = "C503D857955730749FB93FDC628FD774")


    private FrameManager mFrameManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.115 -0400", hash_original_field = "8BDB18895FCC3C3DE30D4A8182B759B0", hash_generated_field = "7F12F37111A28DB480E590BCA856DF01")

    private GLEnvironment mGLEnvironment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.118 -0400", hash_original_field = "8A24BD49E6727D9D90E80F76B9BBB0D8", hash_generated_field = "7B2F9718993F1757D619C20FC75DD19E")

    private HashMap<String, Frame> mStoredFrames = new HashMap<String, Frame>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.120 -0400", hash_original_field = "5A4FDCF55DDD97E340521A1913F4E0BE", hash_generated_field = "E3478C30ED9D15C69A070768251C8139")

    private Set<FilterGraph> mGraphs = new HashSet<FilterGraph>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.122 -0400", hash_original_method = "024F6C42080009D872E56D16574B421D", hash_generated_method = "4951949AE77EC31CC5D9DF7211264CCC")
    
public FrameManager getFrameManager() {
        return mFrameManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.125 -0400", hash_original_method = "313758598A02392F40BD119FBE16DCE7", hash_generated_method = "7959AE3CA3E8CA34094324659E7382EA")
    
public void setFrameManager(FrameManager manager) {
        if (manager == null) {
            throw new NullPointerException("Attempting to set null FrameManager!");
        } else if (manager.getContext() != null) {
            throw new IllegalArgumentException("Attempting to set FrameManager which is already "
                + "bound to another FilterContext!");
        } else {
            mFrameManager = manager;
            mFrameManager.setContext(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.127 -0400", hash_original_method = "775B48885FEEEE864377B7024CEEE1C9", hash_generated_method = "D79682786AAE3AD98CE337A50C288E86")
    
public GLEnvironment getGLEnvironment() {
        return mGLEnvironment;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.130 -0400", hash_original_method = "E64E39B4ABFAB19EFB6713D2EB5CC54B", hash_generated_method = "D63945F419DEE5A92D053803A173ABB4")
    
public void initGLEnvironment(GLEnvironment environment) {
        if (mGLEnvironment == null) {
            mGLEnvironment = environment;
        } else {
            throw new RuntimeException("Attempting to re-initialize GL Environment for " +
                "FilterContext!");
        }
    }

    public interface OnFrameReceivedListener {
        public void onFrameReceived(Filter filter, Frame frame, Object userData);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.134 -0400", hash_original_method = "EFAECFB5C6CC43FEFE48E647A791CD64", hash_generated_method = "599123C0B646E7F9E354245FE655E399")
    
public synchronized void storeFrame(String key, Frame frame) {
        Frame storedFrame = fetchFrame(key);
        if (storedFrame != null) {
            storedFrame.release();
        }
        frame.onFrameStore();
        mStoredFrames.put(key, frame.retain());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.137 -0400", hash_original_method = "CF982582EB2C6D1F15DB0A28021D0ECC", hash_generated_method = "3C621FC927C81E13F7C42F99B21AE446")
    
public synchronized Frame fetchFrame(String key) {
        Frame frame = mStoredFrames.get(key);
        if (frame != null) {
            frame.onFrameFetch();
        }
        return frame;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.139 -0400", hash_original_method = "FD64944D01C97C2DB2F973B30EB8F158", hash_generated_method = "01ABBC30CE01C8B237B3931E4F58215B")
    
public synchronized void removeFrame(String key) {
        Frame frame = mStoredFrames.get(key);
        if (frame != null) {
            mStoredFrames.remove(key);
            frame.release();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.142 -0400", hash_original_method = "AE58A06BDCB5A5D291642D2F683FAE10", hash_generated_method = "4FCA5CE454BB520389E5F7AC59E5E715")
    
public synchronized void tearDown() {
        // Release stored frames
        for (Frame frame : mStoredFrames.values()) {
            frame.release();
        }
        mStoredFrames.clear();

        // Release graphs
        for (FilterGraph graph : mGraphs) {
            graph.tearDown(this);
        }
        mGraphs.clear();

        // Release frame manager
        if (mFrameManager != null) {
            mFrameManager.tearDown();
            mFrameManager = null;
        }

        // Release GL context
        if (mGLEnvironment != null) {
            mGLEnvironment.tearDown();
            mGLEnvironment = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:00.144 -0400", hash_original_method = "2248AA93F9AD89C34A2B30996E1C1D09", hash_generated_method = "7FEEFC700DB3CD49A84EB96E844664AB")
    
final void addGraph(FilterGraph graph) {
        mGraphs.add(graph);
    }
}
