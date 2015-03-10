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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Rect;

public interface SurfaceHolder {
    
    @Deprecated
    public static final int SURFACE_TYPE_NORMAL = 0;
    
    @Deprecated
    public static final int SURFACE_TYPE_HARDWARE = 1;
    
    @Deprecated
    public static final int SURFACE_TYPE_GPU = 2;
    
    @Deprecated
    public static final int SURFACE_TYPE_PUSH_BUFFERS = 3;
    
    public static class BadSurfaceTypeException extends RuntimeException {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.840 -0500", hash_original_method = "5B711042C26083732A0FE1DD39275FD8", hash_generated_method = "FD7DD460BCB3D7623A5171C48B4F08E5")
        
public BadSurfaceTypeException() {
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.843 -0500", hash_original_method = "548B66E802408B549443C0031F038236", hash_generated_method = "B26C9C0F99ED3B0153CF9DE48E3B5F31")
        
public BadSurfaceTypeException(String name) {
            super(name);
        }
    }
    
    public interface Callback {
        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void surfaceCreated(SurfaceHolder holder);

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                int height);

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void surfaceDestroyed(SurfaceHolder holder);
    }
    
    public interface Callback2 extends Callback {
        
        public void surfaceRedrawNeeded(SurfaceHolder holder);
    }
    
    public void addCallback(Callback callback);
    
    public void removeCallback(Callback callback);
    
    public boolean isCreating();
    
    @Deprecated
    public void setType(int type);
    
    public void setFixedSize(int width, int height);
    
    public void setSizeFromLayout();
    
    public void setFormat(int format);
    
    public void setKeepScreenOn(boolean screenOn);
    
    public Canvas lockCanvas();
    
    public Canvas lockCanvas(Rect dirty);
    
    public void unlockCanvasAndPost(Canvas canvas);
    
    public Rect getSurfaceFrame();
    
    public Surface getSurface();
    
}
