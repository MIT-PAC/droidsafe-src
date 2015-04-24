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


package android.filterfw;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.CachedFrameManager;
import android.filterfw.core.FilterContext;
import android.filterfw.core.FrameManager;
import android.filterfw.core.GLEnvironment;

/**
 * Base class for mobile filter framework (MFF) frontend environments. These convenience classes
 * allow using the filter framework without the requirement of performing manual setup of its
 * required components.
 *
 * @hide
 */
public class MffEnvironment {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.196 -0400", hash_original_field = "D6E5CFBFA0DC2FDA2B8D92A477B24166", hash_generated_field = "54A795D76EECF1DFA15EA59DBD8B1B14")


    private FilterContext mContext;

    /**
     * Protected constructor to initialize the environment's essential components. These are the
     * frame-manager and the filter-context. Passing in null for the frame-manager causes this
     * to be auto-created.
     *
     * @param frameManager The FrameManager to use or null to auto-create one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.200 -0400", hash_original_method = "E26A837FD5FF324510690CBD8766F9B1", hash_generated_method = "4B337BE179226BCEC8DDDCE00A7EAB15")
    
protected MffEnvironment(FrameManager frameManager) {
        // Get or create the frame manager
        if (frameManager == null) {
            frameManager = new CachedFrameManager();
        }

        // Setup the environment
        mContext = new FilterContext();
        mContext.setFrameManager(frameManager);

    }

    /**
     * Returns the environment's filter-context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.203 -0400", hash_original_method = "3A6A1A99DE88FE112B716367E8A4E4CA", hash_generated_method = "4C5F5C80F56697D18436511D12998B69")
    
public FilterContext getContext() {
        return mContext;
    }

    /**
     * Set the environment's GL environment to the specified environment. This does not activate
     * the environment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.206 -0400", hash_original_method = "6F9C1D0AB334AE3441988A0B74D0F71A", hash_generated_method = "C7DC69C7E749A8F8142917CCAFEC8EED")
    
public void setGLEnvironment(GLEnvironment glEnvironment) {
        mContext.initGLEnvironment(glEnvironment);
    }

    /**
     * Create and activate a new GL environment for use in this filter context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.209 -0400", hash_original_method = "4BFE8A5DE4FE06221223B0828088CB22", hash_generated_method = "6FF71AD905FA6A6D3810CABF223622E3")
    
public void createGLEnvironment() {
        GLEnvironment glEnvironment = new GLEnvironment();
        glEnvironment.initWithNewContext();
        setGLEnvironment(glEnvironment);
    }

    /**
     * Activate the GL environment for use in the current thread. A GL environment must have been
     * previously set or created using setGLEnvironment() or createGLEnvironment()! Call this after
     * having switched to a new thread for GL filter execution.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.212 -0400", hash_original_method = "AB39B7AC7379086239E9836E0CD70917", hash_generated_method = "D5BEEA9A703F3AEB9ED8954FA7A03574")
    
public void activateGLEnvironment() {
        GLEnvironment glEnv = mContext.getGLEnvironment();
        if (glEnv != null) {
            mContext.getGLEnvironment().activate();
        } else {
            throw new NullPointerException("No GLEnvironment in place to activate!");
        }
    }

    /**
     * Deactivate the GL environment from use in the current thread. A GL environment must have been
     * previously set or created using setGLEnvironment() or createGLEnvironment()! Call this before
     * running GL filters in another thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:05:57.216 -0400", hash_original_method = "29CF94A8D78D7A07450933C1FA54D781", hash_generated_method = "456E4A0190C28AE89497DA7AB99F64EE")
    
public void deactivateGLEnvironment() {
        GLEnvironment glEnv = mContext.getGLEnvironment();
        if (glEnv != null) {
            mContext.getGLEnvironment().deactivate();
        } else {
            throw new NullPointerException("No GLEnvironment in place to deactivate!");
        }
    }
}
