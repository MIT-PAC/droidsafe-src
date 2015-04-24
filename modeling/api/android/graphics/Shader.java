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


package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Shader {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDestructor(int native_shader, int native_skiaShader) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetLocalMatrix(int native_shader,
            int native_skiaShader, int matrix_instance) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.375 -0500", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "368FA2DC569BFE75826F8A8AC6BD5246")

    public int native_instance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.377 -0500", hash_original_field = "58075C44B0BFD362B18FEE20BC92AC6E", hash_generated_field = "0DB9AF0E0B134D090C8683C8A774B2B7")

    public int native_shader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.380 -0500", hash_original_field = "B098408BDC1C8F16240AC762D8C2DD9B", hash_generated_field = "D6800221AFA66D0081A0E98544EF5A6A")

    private Matrix mLocalMatrix;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.118 -0400", hash_original_method = "2C9D5C9CBFF528B332FC0D9B3274B66B", hash_generated_method = "2C9D5C9CBFF528B332FC0D9B3274B66B")
    public Shader ()
    {
        //Synthesized constructor
    }

    /**
     * Return true if the shader has a non-identity local matrix.
     * @param localM If not null, it is set to the shader's local matrix.
     * @return true if the shader has a non-identity local matrix
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.389 -0500", hash_original_method = "68EE3A19E97B552C55745306F03EBBEA", hash_generated_method = "76D75EAFA59EA9E9A826FA2F14B9EAF0")
    
public boolean getLocalMatrix(Matrix localM) {
        if (mLocalMatrix != null) {
            localM.set(mLocalMatrix);
            return !mLocalMatrix.isIdentity();
        }
        return false;
    }

    /**
     * Set the shader's local matrix. Passing null will reset the shader's
     * matrix to identity
     * @param localM The shader's new local matrix, or null to specify identity
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.391 -0500", hash_original_method = "D9D7C5F09B6958B88F23796DCADEE0F6", hash_generated_method = "3A24FF4520E0AC54135D1BAF56D0F708")
    
public void setLocalMatrix(Matrix localM) {
        mLocalMatrix = localM;
        nativeSetLocalMatrix(native_instance, native_shader,
                localM == null ? 0 : localM.native_instance);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.393 -0500", hash_original_method = "C66C3B2CF2D4E3C25A1D8C5724E65539", hash_generated_method = "2CF5D32D640D4D16A79BEE210A587A8B")
    
protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            nativeDestructor(native_instance, native_shader);
        }
    }
    
    public enum TileMode {
        CLAMP   (0),
        REPEAT  (1),
        MIRROR  (2);
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.383 -0500", hash_original_method = "3B53F4AFD55D12038BB431723BD12C86", hash_generated_method = "3B53F4AFD55D12038BB431723BD12C86")
            
TileMode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:25.385 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
}

