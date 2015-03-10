/* //device/java/android/javax/microedition/khronos/opengles/GL11Ext.java
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
**
** Copyright 2007, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License"); 
** you may not use this file except in compliance with the License. 
** You may obtain a copy of the License at 
**
**     http://www.apache.org/licenses/LICENSE-2.0 
**
** Unless required by applicable law or agreed to in writing, software 
** distributed under the License is distributed on an "AS IS" BASIS, 
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
** See the License for the specific language governing permissions and 
** limitations under the License.
*/

// This source file is automatically generated


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package javax.microedition.khronos.opengles;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface GL11Ext extends GL {
    int GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES = 0x8B9E;
    int GL_MATRIX_INDEX_ARRAY_OES                = 0x8844;
    int GL_MATRIX_INDEX_ARRAY_POINTER_OES        = 0x8849;
    int GL_MATRIX_INDEX_ARRAY_SIZE_OES           = 0x8846;
    int GL_MATRIX_INDEX_ARRAY_STRIDE_OES         = 0x8848;
    int GL_MATRIX_INDEX_ARRAY_TYPE_OES           = 0x8847;
    int GL_MATRIX_PALETTE_OES                    = 0x8840;
    int GL_MAX_PALETTE_MATRICES_OES              = 0x8842;
    int GL_MAX_VERTEX_UNITS_OES                  = 0x86A4;
    int GL_TEXTURE_CROP_RECT_OES                 = 0x8B9D;
    int GL_WEIGHT_ARRAY_BUFFER_BINDING_OES       = 0x889E;
    int GL_WEIGHT_ARRAY_OES                      = 0x86AD;
    int GL_WEIGHT_ARRAY_POINTER_OES              = 0x86AC;
    int GL_WEIGHT_ARRAY_SIZE_OES                 = 0x86AB;
    int GL_WEIGHT_ARRAY_STRIDE_OES               = 0x86AA;
    int GL_WEIGHT_ARRAY_TYPE_OES                 = 0x86A9;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glTexParameterfv(int target, int pname, float[] param, int offset);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glCurrentPaletteMatrixOES(
        int matrixpaletteindex
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexfOES(
        float x,
        float y,
        float z,
        float width,
        float height
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexfvOES(
        float[] coords,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexfvOES(
        java.nio.FloatBuffer coords
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexiOES(
        int x,
        int y,
        int z,
        int width,
        int height
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexivOES(
        int[] coords,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexivOES(
        java.nio.IntBuffer coords
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexsOES(
        short x,
        short y,
        short z,
        short width,
        short height
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexsvOES(
        short[] coords,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexsvOES(
        java.nio.ShortBuffer coords
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexxOES(
        int x,
        int y,
        int z,
        int width,
        int height
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexxvOES(
        int[] coords,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glDrawTexxvOES(
        java.nio.IntBuffer coords
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glEnable(
        int cap
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glEnableClientState(
        int array
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glLoadPaletteFromModelViewMatrixOES(
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glMatrixIndexPointerOES(
        int size,
        int type,
        int stride,
        int offset
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glWeightPointerOES(
        int size,
        int type,
        int stride,
        java.nio.Buffer pointer
    );

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void glWeightPointerOES(
        int size,
        int type,
        int stride,
        int offset
    );

}
