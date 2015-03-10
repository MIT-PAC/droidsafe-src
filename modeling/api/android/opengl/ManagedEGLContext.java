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
 * Copyright (C) 2010 The Android Open Source Project
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


package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;
import static javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

import android.os.Looper;
import android.util.Log;

import com.google.android.gles_jni.EGLImpl;

public abstract class ManagedEGLContext {

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.370 -0500", hash_original_method = "5D3101613FD0E07F1B5669C4B02EC8F5", hash_generated_method = "0EF28348B25591EB4174A4B4BE855F2D")
    
public static boolean doTerminate() {
        ArrayList<ManagedEGLContext> active;

        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Called on wrong thread");
        }

        synchronized (sActive) {
            // If there are no active managed contexts, we will not even
            // try to terminate.
            if (sActive.size() <= 0) {
                return false;
            }

            // Need to check how many EGL contexts are actually running,
            // to compare with how many we are managing.
            EGL10 egl = (EGL10) EGLContext.getEGL();
            EGLDisplay display = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);

            if (display == EGL_NO_DISPLAY) {
                Log.w(TAG, "doTerminate failed: no display");
                return false;
            }

            if (EGLImpl.getInitCount(display) != sActive.size()) {
                Log.w(TAG, "doTerminate failed: EGL count is " + EGLImpl.getInitCount(display)
                        + " but managed count is " + sActive.size());
                return false;
            }

            active = new ArrayList<ManagedEGLContext>(sActive);
            sActive.clear();
        }

        for (int i = 0; i < active.size(); i++) {
            active.get(i).execTerminate();
        }

        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.350 -0500", hash_original_field = "0FE57C678C74D3385A561EDB43445BC1", hash_generated_field = "AA7820E70BB513EA18D582B7C663D5F7")

    static final String TAG = "ManagedEGLContext";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.353 -0500", hash_original_field = "675FF3412C0D87AB65E85E5B1A61006D", hash_generated_field = "6F26B317B7D1B34F8FDEAC7200D5F188")

    static final ArrayList<ManagedEGLContext> sActive = new ArrayList<ManagedEGLContext>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.355 -0500", hash_original_field = "5F205B80EE2B67A11B019B523ECA191F", hash_generated_field = "5F205B80EE2B67A11B019B523ECA191F")

     EGLContext mContext;

    /**
     * Instantiate to manage the given EGLContext.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.358 -0500", hash_original_method = "9D266735F37ADE970716DE5C813A7490", hash_generated_method = "68CEB275C685390CE0A8932EA30B263C")
    
public ManagedEGLContext(EGLContext context) {
        mContext = context;
        synchronized (sActive) {
            sActive.add(this);
        }
    }

    /**
     * Retrieve the EGLContext being managed by the class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.360 -0500", hash_original_method = "0BA5CAD8B17303B4C3A912EF0F9065A7", hash_generated_method = "3F9873457B8E9F7828FDD34F986E7D80")
    
public EGLContext getContext() {
        return mContext;
    }

    /**
     * Force-terminate the ManagedEGLContext.  This will cause
     * {@link #onTerminate(EGLContext)} to be called.  You <em>must</em>
     * call this when destroying the EGLContext, so that the framework
     * knows to stop managing it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.363 -0500", hash_original_method = "3A3C884C8DD72479D5B7016BF0489D57", hash_generated_method = "B71E58C6D6A17BB84C6E9FEA3D94F024")
    
public void terminate() {
        execTerminate();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.365 -0500", hash_original_method = "B8E737E7A559452A0DBE946D6943CE60", hash_generated_method = "B8E737E7A559452A0DBE946D6943CE60")
    
void execTerminate() {
        onTerminate(mContext);
    }

    /**
     * Override this method to destroy the EGLContext when appropriate.
     * <em>Note that this method is always called on the main thread
     * of the process.</em>  If your EGLContext was created on a different
     * thread, you will need to implement this method to hand off the work
     * of destroying the context to that thread.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:09.367 -0500", hash_original_method = "AC1EFD640BD9F8BD065765A5040125FA", hash_generated_method = "C065830DFE0B79F68CDB7035ED7CCD14")
    
public abstract void onTerminate(EGLContext context);
}

