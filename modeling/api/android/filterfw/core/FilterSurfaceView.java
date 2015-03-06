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
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @hide
 */
public class FilterSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.258 -0400", hash_original_field = "1CD49A1ED622DBD6D69152AE221D989D", hash_generated_field = "341DF832D8EC61BC59CD76271E2736DB")

    private static int STATE_ALLOCATED      = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.260 -0400", hash_original_field = "467228AB394C5C54B1CA24645DCA463B", hash_generated_field = "87FCAA6D81EA7C58C0162E97C74E6D9B")

    private static int STATE_CREATED        = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.263 -0400", hash_original_field = "A452FAA96A7ABA92C7DC5604CADF8803", hash_generated_field = "2BBB0FC4F74488F0F9503FCACA77BE63")

    private static int STATE_INITIALIZED    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.265 -0400", hash_original_field = "D5C0673909C74BAA499B1989D81ECBA0", hash_generated_field = "A21C0E570C0F3793E2D8F9F3E341F072")

    private int mState = STATE_ALLOCATED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.267 -0400", hash_original_field = "E27A02F6D2ED96D98F69FD560570C6F6", hash_generated_field = "A572404D3A48A460F6F616D51D9B5EA1")

    private SurfaceHolder.Callback mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.270 -0400", hash_original_field = "318545629B278F619E76321D7D49E8B1", hash_generated_field = "AF71389BF38E50A5BE604AAC0C8E5B99")

    private GLEnvironment mGLEnv;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.272 -0400", hash_original_field = "F274D9A6D075EEEA711AF201B69FCAF4", hash_generated_field = "AB812A232FD99D518B911A3EA9A3816E")

    private int mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.274 -0400", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.286 -0400", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.288 -0400", hash_original_field = "0C7CB482610F5286BFBD0D0521626857", hash_generated_field = "8A692E6955F7E7A26B813E895F961E27")

    private int mSurfaceId = -1;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.291 -0400", hash_original_method = "C44FC0AAF3C7D9F32B8A130C19AD092F", hash_generated_method = "E3FC263DA5C45B4EE9AC3B7E359CB118")
    
public FilterSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.293 -0400", hash_original_method = "91843FCEC035649C2E408E08D2824364", hash_generated_method = "085612AC3FD4613F0F02D352DD4B44E4")
    
public FilterSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.296 -0400", hash_original_method = "A34B942491E310087B22669A37E125EA", hash_generated_method = "149A4C0187FC1045080D45B6E36B28E9")
    
public synchronized void bindToListener(SurfaceHolder.Callback listener, GLEnvironment glEnv) {
        // Make sure we are not bound already
        if (listener == null) {
            throw new NullPointerException("Attempting to bind null filter to SurfaceView!");
        } else if (mListener != null && mListener != listener) {
            throw new RuntimeException(
                "Attempting to bind filter " + listener + " to SurfaceView with another open "
                + "filter " + mListener + " attached already!");
        }

        // Set listener
        mListener = listener;

        // Set GLEnv
        if (mGLEnv != null && mGLEnv != glEnv) {
            mGLEnv.unregisterSurfaceId(mSurfaceId);
        }
        mGLEnv = glEnv;

        // Check if surface has been created already
        if (mState >= STATE_CREATED) {
            // Register with env (double registration will be ignored by GLEnv, so we can simply
            // try to do it here).
            registerSurface();

            // Forward surface created to listener
            mListener.surfaceCreated(getHolder());

            // Forward surface changed to listener
            if (mState == STATE_INITIALIZED) {
                mListener.surfaceChanged(getHolder(), mFormat, mWidth, mHeight);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.298 -0400", hash_original_method = "8BEB744AD4E00AD213D77592160530AA", hash_generated_method = "960FE4C1A65BC744811AEA8C6FE8DA22")
    
public synchronized void unbind() {
        mListener = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.301 -0400", hash_original_method = "A52C36A1DF7C9587B70440ADA0DE4CE8", hash_generated_method = "DC913C51A05A4418764EDED5BB23E655")
    
public synchronized int getSurfaceId() {
        return mSurfaceId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.303 -0400", hash_original_method = "ECCEEC7664AE342AFAEB04EB91CECF46", hash_generated_method = "3D9292C62647F75DE7C41DCB80AEC312")
    
public synchronized GLEnvironment getGLEnv() {
        return mGLEnv;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.305 -0400", hash_original_method = "8E392DA809F2E83103331684A42A6141", hash_generated_method = "8E7D9E4421809F9BF072D0655482A061")
    
@Override
    public synchronized void surfaceCreated(SurfaceHolder holder) {
        mState = STATE_CREATED;

        // Register with GLEnvironment if we have it already
        if (mGLEnv != null) {
            registerSurface();
        }

        // Forward callback to listener
        if (mListener != null) {
            mListener.surfaceCreated(holder);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.308 -0400", hash_original_method = "CD0D5758A90C168F503C9E53CBD596C6", hash_generated_method = "9A6D9F98326B6C990F4644EA111E0A33")
    
@Override
    public synchronized void surfaceChanged(SurfaceHolder holder,
                                            int format,
                                            int width,
                                            int height) {
        // Remember these values
        mFormat = format;
        mWidth = width;
        mHeight = height;
        mState = STATE_INITIALIZED;

        // Forward to renderer
        if (mListener != null) {
            mListener.surfaceChanged(holder, format, width, height);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.311 -0400", hash_original_method = "93E1739893B019FAB626997344426962", hash_generated_method = "B4166EA9BFB2F7471D7EDFF5082A1C1F")
    
@Override
    public synchronized void surfaceDestroyed(SurfaceHolder holder) {
        mState = STATE_ALLOCATED;

        // Forward to renderer
        if (mListener != null) {
            mListener.surfaceDestroyed(holder);
        }

        // Get rid of internal objects associated with this surface
        unregisterSurface();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.313 -0400", hash_original_method = "F5B0F1A24D7BEACCE69559D96EB36E77", hash_generated_method = "DF3B4E69DBCE557F7E0BF1139EE86BA4")
    
private void registerSurface() {
        mSurfaceId = mGLEnv.registerSurface(getHolder().getSurface());
        if (mSurfaceId < 0) {
            throw new RuntimeException("Could not register Surface: " + getHolder().getSurface() +
                                       " in FilterSurfaceView!");
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:01.316 -0400", hash_original_method = "7364F72AE0337309FF1AF358BAB1F4A6", hash_generated_method = "04B2E758D8BCFFF94001377CEAB512F3")
    
private void unregisterSurface() {
        if (mGLEnv != null && mSurfaceId > 0) {
            mGLEnv.unregisterSurfaceId(mSurfaceId);
        }
    }

}
