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


package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGLSurface;

public class EGLSurfaceImpl extends EGLSurface {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.658 -0500", hash_original_field = "296DD015E00E19A6AFBFBEA67F8ACDA3", hash_generated_field = "296DD015E00E19A6AFBFBEA67F8ACDA3")

    int mEGLSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.660 -0500", hash_original_field = "56DA9E94FD7AA86E5CD2913D51F85F53", hash_generated_field = "76B5871A33DA54FE461481FECA9BEAF0")

    private int mNativePixelRef;
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.662 -0500", hash_original_method = "86437EA058F070B58780D104343F6F45", hash_generated_method = "0723C6460ED17317E4124F3363AEBCA3")
    
public EGLSurfaceImpl() {
        mEGLSurface = 0;
        mNativePixelRef = 0;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.665 -0500", hash_original_method = "547A9AA0BBA76A5D7ACA46BEF8F827CB", hash_generated_method = "A47E0AF19A316A6FDC2D8F6A916E1833")
    
public EGLSurfaceImpl(int surface) {
        mEGLSurface = surface;
        mNativePixelRef = 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.667 -0500", hash_original_method = "686C2DC893E9E8D9D02295779AC83C23", hash_generated_method = "09C81E6A4BBCC1A424B9F1323BED9B21")
    
@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EGLSurfaceImpl that = (EGLSurfaceImpl) o;

        return mEGLSurface == that.mEGLSurface;

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.670 -0500", hash_original_method = "688B514F649E9FC55EF131746A1254F0", hash_generated_method = "98A5D045BA43EF4CACB9CA9CC6FC6595")
    
@Override
    public int hashCode() {
        return mEGLSurface;
    }
    
}

