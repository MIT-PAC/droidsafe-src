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


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;

class GLES20TextureLayer extends GLES20Layer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.621 -0500", hash_original_field = "BDB6A6C8A3F80F4A028EAF374A5C2487", hash_generated_field = "95BD811F6C75A4EC837CB912DCEC863B")

    private int mTexture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.624 -0500", hash_original_field = "2DB428339FB9F1F6E6D23DD5A01621BD", hash_generated_field = "620EA06673388F6E0C713D180E59A2BE")

    private SurfaceTexture mSurface;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.626 -0500", hash_original_method = "CC530FDF67357759801B1D3133D8497C", hash_generated_method = "CC530FDF67357759801B1D3133D8497C")
    
GLES20TextureLayer(boolean isOpaque) {
        int[] layerInfo = new int[2];
        mLayer = GLES20Canvas.nCreateTextureLayer(isOpaque, layerInfo);

        if (mLayer != 0) {
            mTexture = layerInfo[0];
            mFinalizer = new Finalizer(mLayer);
        } else {
            mFinalizer = null;
        }        
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.628 -0500", hash_original_method = "11B63BDC356D1B06476790C8BA000825", hash_generated_method = "9B7C9A87E96D2A9B83C2FDE713A3EF2B")
    
@Override
    boolean isValid() {
        return mLayer != 0 && mTexture != 0;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.631 -0500", hash_original_method = "E6D4E5987C63DC0417A704140ED92009", hash_generated_method = "2250F39638A9D272CD23AEDC119315C2")
    
@Override
    void resize(int width, int height) {
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.633 -0500", hash_original_method = "FE3F18C4DF5FFEAAB94B6C71D2FF4AC1", hash_generated_method = "E1827AD236E6122B2580FCDDB65E8C53")
    
@Override
    HardwareCanvas getCanvas() {
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.635 -0500", hash_original_method = "2311903AB2BF759F2AF64EC85ECFCD74", hash_generated_method = "4EF99C99ADB0A028650241CA4DE380EA")
    
@Override
    HardwareCanvas start(Canvas currentCanvas) {
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.637 -0500", hash_original_method = "8A4AD7636F89A9F2F6FF510EF4082BAC", hash_generated_method = "F837A8C4E2DB540DA76051BC376B8CC4")
    
@Override
    void end(Canvas currentCanvas) {
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.639 -0500", hash_original_method = "CDD23CBBC42E4C818DBF49A0C1C7FFA6", hash_generated_method = "CDD23CBBC42E4C818DBF49A0C1C7FFA6")
    
SurfaceTexture getSurfaceTexture() {
        if (mSurface == null) {
            mSurface = new SurfaceTexture(mTexture, false);
        }
        return mSurface;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.642 -0500", hash_original_method = "1A4F8689DF0CBFF789DC290DBC90C4B6", hash_generated_method = "265612BC3D36F505F5DA8037402011D6")
    
@Override
    void update(int width, int height, boolean isOpaque) {
        super.update(width, height, isOpaque);
        GLES20Canvas.nUpdateTextureLayer(mLayer, width, height, isOpaque, mSurface);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:48.644 -0500", hash_original_method = "A2F486FA7726377A1A987D8CE4D8F80A", hash_generated_method = "0B46F5D91B999EC9E221C2651B58AB64")
    
@Override
    void setTransform(Matrix matrix) {
        GLES20Canvas.nSetTextureLayerTransform(mLayer, matrix.getTaintInt());
    }
    
}

